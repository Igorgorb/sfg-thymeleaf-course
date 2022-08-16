package guru.springframework.controllers;

import guru.springframework.comands.LoginCommand;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author igorg
 * @date 16 серп. 2022 р.
 */
@Controller
public class LoginController {

  @RequestMapping("/login")
  public String loginForm(Model model) {

    model.addAttribute("loginCommand", new LoginCommand());

    return "loginform";
  }

  @RequestMapping("logout-success")
  public String yourLoggedOut() {

    return "logout-success";
  }

  //@RequestMapping(value = "/dologin", method = RequestMethod.POST)
  public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "loginform";
    }
    return "redirect:/index";
  }
}
