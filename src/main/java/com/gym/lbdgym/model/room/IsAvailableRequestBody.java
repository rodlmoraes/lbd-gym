package com.gym.lbdgym.model.room;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class IsAvailableRequestBody {
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}