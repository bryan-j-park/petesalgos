package com.nightcrew.petesalgos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nightcrew.petesalgos.models.LoginUser;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.services.UserService;

@Controller
public class LoginRegController {
  @Autowired
  private UserService userService;

// ============== Landing Page =============
  @GetMapping("/")
  public String index() {
    return "index.jsp";
  }

// =============== Login/Register Page ==============
  @GetMapping("/loginpage")
  public String logreg(Model model) {
    model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
    return "logreg.jsp";
  }

// ================ Process Register Form ================
  @PostMapping("/register")
  public String register(@Valid @ModelAttribute("newUser") User newUser,
      BindingResult result, Model model, HttpSession session) {
    User registeredUser = userService.register(newUser, result);
    if(result.hasErrors()) {
      model.addAttribute("newLogin", new LoginUser());
      return "logreg.jsp";
    }
    else {
      session.setAttribute("userId", registeredUser.getId());
      Long id = (Long) session.getAttribute("userId");
      model.addAttribute("user", userService.getOneUser(id));
      return "redirect:/dashboard";
    }
  }

// =================== Process Login Form ===================
  @PostMapping("/login")
  public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
      BindingResult result, Model model, HttpSession session) {
    User loginUser = userService.login(newLogin, result);
    if(result.hasErrors()) {
      model.addAttribute("newUser", new User());
      return "logreg.jsp";
    }
    else {
      session.setAttribute("userId", loginUser.getId());
      Long id = (Long) session.getAttribute("userId");
      model.addAttribute("user", userService.getOneUser(id));
      return "redirect:/dashboard";
    }
  }

// =============== Logout Route ==================
  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

}
