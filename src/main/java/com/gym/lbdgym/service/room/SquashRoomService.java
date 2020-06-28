package com.gym.lbdgym.service.room;

import com.gym.lbdgym.model.Booking;
import com.gym.lbdgym.model.room.SquashRoom;
import com.gym.lbdgym.repository.room.SquashRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

  public Optional<List<Booking>> bookingsBySquashRoom(Long id) {
    Optional<SquashRoom> squashRoom = repository.findById(id);
    return squashRoom.map(SquashRoom::getBookings);
  }

  public boolean isAvailable(Long id, LocalDateTime startDate, LocalDateTime endDate) {
    Optional<SquashRoom> squashRoom = repository.findById(id);

    boolean occupied = squashRoom.get().getBookings().stream()
        .anyMatch(b -> b.getStartDate().isBefore(endDate) && b.getEndDate().isAfter(startDate));

    return !occupied;
  }
}