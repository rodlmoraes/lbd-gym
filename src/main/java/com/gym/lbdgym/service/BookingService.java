package com.gym.lbdgym.service;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.repository.BookingRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookingService {

  private final BookingRepository repository;

  public List<Booking> findAll() {
    return repository.findAll();
  }

  public Optional<Booking> findById(Long id) {
    return repository.findById(id);
  }

  public Booking save(Booking booking) {
    return repository.save(booking);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}