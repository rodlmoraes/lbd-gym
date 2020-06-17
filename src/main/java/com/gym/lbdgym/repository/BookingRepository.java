package com.gym.lbdgym.repository;

import com.gym.lbdgym.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}