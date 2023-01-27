package ibf2022.ssfAssessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.ssfAssessment.model.Order;
import ibf2022.ssfAssessment.model.Pizza;
import ibf2022.ssfAssessment.service.PizzaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/")
// (path = "/", produces = MediaType.TEXT_HTML_VALUE)
public class PizzaController {

    @Autowired
    private PizzaService pizzaSvr;

    @GetMapping(path = "/")
    public String showView0(Model model) {
        model.addAttribute("pizza", new Pizza());
        // over here you get id
        return "index";
    }

    @PostMapping(path = "/pizza", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String savePizza(@Valid Pizza pizza, Model model) {

        // over here you get another id
        System.out.println("id at controller, post >>> " + pizza.getId());
        System.out.println("pizza at controller, post >>> " + pizza.getPizza());
        System.out.println("size at controller, post >>> " + pizza.getSize());
        System.out.println("qty at controller, post >>> " + pizza.getQuantity());

        pizzaSvr.savePizza(pizza);

        model.addAttribute("pizza", pizza);

        return "view1";
    }

    @PostMapping(path = "/pizza/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveOrder(@Valid Order order, BindingResult binding, Model model) {

        if (binding.hasErrors()) {
            return "view1";
        }
        
        pizzaSvr.saveOrder(order);

        return "null"; // return "view2"
    }

}
