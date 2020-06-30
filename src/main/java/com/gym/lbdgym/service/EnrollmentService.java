package com.gym.lbdgym.service;

import com.gym.lbdgym.model.Enrollment;
import com.gym.lbdgym.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;

    public List<Enrollment> findAll() {
        return repository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return repository.findById(id);
    }

    public Enrollment save(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
