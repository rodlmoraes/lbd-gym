package com.gym.lbdgym.service;

import com.gym.lbdgym.model.CanTeach;
import com.gym.lbdgym.repository.CanTeachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CanTeachService {

    private final CanTeachRepository repository;

    public List<CanTeach> findAll() {
        return repository.findAll();
    }

    public Optional<CanTeach> findById(Long id) {
        return repository.findById(id);
    }

    public CanTeach save(CanTeach canTeach) {
        return repository.save(canTeach);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
