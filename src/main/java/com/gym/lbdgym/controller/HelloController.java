package com.gym.lbdgym.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
  @GetMapping(value = "/")
  public String hello() {
    return "Oie";
  }

}