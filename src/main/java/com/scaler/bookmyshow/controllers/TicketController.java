package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.BookTicketRequestDTO;
import com.scaler.bookmyshow.dtos.BookTicketResponseDTO;
import com.scaler.bookmyshow.dtos.CancelTicketRequestDTO;
import com.scaler.bookmyshow.dtos.CancelTicketResponseDTO;
import com.scaler.bookmyshow.models.ResponseStatus;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;

    //@Autowired not needed for constructor injection
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @PostMapping("/bookTicket")
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
        Ticket ticket = ticketService.bookTicket(
                requestDTO.getShowSeatIds(),
                requestDTO.getUserId()
        );
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        responseDTO.setTicket(ticket);
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDTO;
    }
    @PostMapping("/cancelTicket")
    public CancelTicketResponseDTO bookTicket(CancelTicketRequestDTO requestDTO){
        return null;
    }


}
