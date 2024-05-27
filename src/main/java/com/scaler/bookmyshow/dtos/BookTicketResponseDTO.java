package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.ResponseStatus;
import com.scaler.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
