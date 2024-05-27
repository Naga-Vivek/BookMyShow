package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    // @Autowired is not needed for constructor injection.
    public TicketService(ShowSeatRepository showSeatRepository, UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    public Ticket bookTicket(List<Long> showSeatIds , Long userId){
        //Actual work for booking the ticket will come here.

        //Steps to book a ticket :-
        //1. Fetch the showseats & User from the given ids.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        User user = userRepository.findById(userId).get();
        //2. Check the status.
        //3. If all the seats are available, then only proceed with the booking.
        //4. Lock
        //5. Check the status again.
        //6. Book the seats.

        return null;
    }

}
