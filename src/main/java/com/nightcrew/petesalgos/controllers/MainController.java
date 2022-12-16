package com.nightcrew.petesalgos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  @GetMapping("/algo")
  public String algo() {
      return "algo.jsp";
  }


}
