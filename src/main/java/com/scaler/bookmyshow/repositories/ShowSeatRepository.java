package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    //This class is responsible to interact with show_seat table in DB.

    @Lock(LockModeType.PESSIMISTIC_READ) //select * from show_seat where id in (1,2,3,4) for update.
    List<ShowSeat> findAllById(List<Long> showSeatIds);

    ShowSeat save(ShowSeat showSeat);
    //ShowSeat object that is getting returned will have the id associated.
    //create a showseat or Update the showseat.
    //UPSERT -> UPDATE + INSERT
    //save() can be used for both insert and update.
    //If the show seat id isn't there then insert it else update it.
}
