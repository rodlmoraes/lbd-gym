package com.gym.lbdgym.repository;

import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByAssociate (Optional<Associate> Associate);
}