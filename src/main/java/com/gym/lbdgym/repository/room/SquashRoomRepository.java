package com.gym.lbdgym.repository.room;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SquashRoomRepository extends JpaRepository<SquashRoom, Long> {

    List<SquashRoom> findAllByBookingsIsNotIn ();

    List<SquashRoom> findAllByBookings ();

    //ver a disponibilidade de sala
}