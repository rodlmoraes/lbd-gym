package com.gym.lbdgym.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
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

  public List<SquashRoom> associateSquashRooms (Long idAssociate) {
    List<Booking> bookings =  repository.findAllByAssociate(idAssociate);
    return bookings.stream().map(Booking::getSquashRoom).collect(Collectors.toList());
  }

  //ver a disponibilidade de sala
  //reserver sala
  //verificar de um socio tem sala reservada e qual é a sala
}