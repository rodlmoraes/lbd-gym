package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.Enrollment;
import com.gym.lbdgym.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({ "/enrollment" })
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService service;

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Enrollment> findById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = service.findById(id);
        return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(service.save(enrollment));
    }

    @PutMapping
    public ResponseEntity<Enrollment> update(@RequestBody Enrollment enrollment) {
        if (!service.findById(enrollment.getId()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(enrollment));
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
