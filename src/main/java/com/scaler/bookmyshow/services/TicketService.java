package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.TicketRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    private TicketRepository ticketRepository;

    // @Autowired is not needed for constructor injection.
    public TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository,TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds , Long userId) throws ShowSeatNotAvailableException {
        //Actual work for booking the ticket will come here.

        //Steps to book a ticket.
        //1. Fetch Show Seats from DB with the set of given showSeatIds.
        //showSeatIds -> (4, 5, 6, 7)
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIsIn(showSeatIds); // FOR UPDATE

        //2. Check the status of ShowSeats.
        //3. If any of them is NOT AVAILABLE then throw an exception.
        for (ShowSeat showSeat: showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }

        //If all the seats are available.
        //4. Take a lock.
        //5. Check the status again if all the ShowSeats are available or not.(DOUBLE CHECK LOCKING)
        //6. Proceed with the booking.

        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            //throw an Exception.
        }
        ticket.setBookedBy(optionalUser.get());
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setShowSeats(showSeats);
        ticketRepository.save(ticket);

        // Ticket has been generated on the backend, now we need to navigate
        // to Payment page to complete the payment.
        // And once the payment is successful then the ticket status
        // will changed from PENDING to SUCCESS.
        return ticket;
    }

}
