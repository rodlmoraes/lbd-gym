package com.gym.lbdgym.service.room;

import java.util.List;
import java.util.Optional;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.repository.room.SquashRoomRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SquashRoomService {

  private final SquashRoomRepository repository;

  public List<SquashRoom> findAll() {
    return repository.findAll();
  }

  public Optional<SquashRoom> findById(Long id) {
    return repository.findById(id);
  }

  public SquashRoom save(SquashRoom squashRoom) {
    return repository.save(squashRoom);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public List<Booking> bookingsBySquashRoom (Long id){
    Optional<SquashRoom> squashRoom = repository.findById(id);
    return squashRoom.map(SquashRoom::getBookings).orElse(null);
  }

}