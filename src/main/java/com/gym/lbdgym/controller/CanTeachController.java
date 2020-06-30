package com.gym.lbdgym.controller;

import com.gym.lbdgym.model.CanTeach;
import com.gym.lbdgym.service.CanTeachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({ "/canTeach" })
@RequiredArgsConstructor
public class CanTeachController {

    private final CanTeachService service;

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<CanTeach> findById(@PathVariable Long id) {
        Optional<CanTeach> canTeach = service.findById(id);
        return canTeach.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<CanTeach> create(@RequestBody CanTeach canTeach) {
        return ResponseEntity.ok(service.save(canTeach));
    }

    @PutMapping
    public ResponseEntity<CanTeach> update(@RequestBody CanTeach canTeach) {
        if (!service.findById(canTeach.getId()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(canTeach));
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
