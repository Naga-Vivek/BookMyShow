package com.scaler.bookmyshow.exceptions;

public class ShowSeatNotAvailableException extends Exception{
    public ShowSeatNotAvailableException(Long showSeatId) {
        super("ShowSeat with id: " + showSeatId + " isn't available");
    }
}
