package by.tms.web.controller;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.OperationService;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class CalculatorController {
    @Autowired
    private UserService userService;
    @Autowired
    private OperationService operationService;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("newUser") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "registration";
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/authorisation")
    public String authorisation(@ModelAttribute("authorisationUser") User user) {
        return "authorisation";
    }

    @PostMapping("/authorisation")
    public String authorisation(@ModelAttribute("authorisationUser") User user, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "authorisation";
        }
        Optional<User> checkOfUser = userService.findUserByEmail(user.getEmail());
        if (checkOfUser.isPresent()) {
            if (checkOfUser.get().getPassword().equals(user.getPassword())) {
                httpSession.setAttribute("currentUser", checkOfUser.get());
                return "redirect:/";
            } else throw new RuntimeException("Wrong password");
        } else throw new RuntimeException("User not found");
    }

    @GetMapping("/calculator")
    public String calculator(@ModelAttribute("newOperation") Operation operation) {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculator(@ModelAttribute("newOperation") Operation operation, BindingResult bindingResult, Model model, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "calculator";
        }
        operationService.checkOperation(operation);
        User currentUser = (User) httpSession.getAttribute("currentUser");
        Operation calculate = operationService.calculate(operation, currentUser);
        model.addAttribute("resultOfOperation", calculate);
        return "calculator";
    }

    @GetMapping("/history")
    public String history(Model model, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        List<Operation> operationsListOfCurrentUser = operationService.findOperationsByUser(user);
        model.addAttribute("operationList", operationsListOfCurrentUser);
        return "history";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("currentUser");
        return "redirect:/";
    }

}
