package com.gym.lbdgym.service;

import com.gym.lbdgym.model.Associate;
import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

  public Set<SquashRoom> associateSquashRooms(Optional<Associate> associate) {
    List<Booking> bookings = repository.findAllByAssociate(associate);
    return bookings.stream().map(Booking::getSquashRoom).collect(Collectors.toSet());
  }
}