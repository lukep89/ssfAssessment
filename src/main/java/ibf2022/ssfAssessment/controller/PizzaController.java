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
import ibf2022.ssfAssessment.model.Select;
import ibf2022.ssfAssessment.service.PizzaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/")
// (path = "/", produces = MediaType.TEXT_HTML_VALUE)
public class PizzaController {

    @Autowired
    private PizzaService pizzaSvr;

    private Double total;

    @GetMapping(path = "/")
    public String showView0(Model model) {
        model.addAttribute("pizza", new Select());
        // over here you get id
        return "index";
    }

    @PostMapping(path = "pizza")
    public String savePizza(@Valid Select select, Model model) {

        // over here you get another id
        System.out.println("id at controller, post >>> " + select.getId());
        System.out.println("pizza at controller, post >>> " + select.getPizza());
        System.out.println("size at controller, post >>> " + select.getSize());
        System.out.println("qty at controller, post >>> " + select.getQuantity());

        String pizza = select.getPizza();
        switch (pizza) {
            case "bella", "marinara", "spianatacalabrese":
                total += 30;
                break;

            case "margherita":
                total += 22;
                break;

            case "trioformaggio":
                total += 25;
                break;

            default:
                break;
        }

        String size = select.getSize();
        switch (size) {
            case "sm":
                total *= 1;
                break;

            case "md":
                total *= 1.2;
                break;

            case "lg":
                total *= 1.5;
                break;

            default:
                break;
        }

        Integer qty = select.getQuantity();
        total *= qty;

        pizzaSvr.savePizza(select);

        model.addAttribute("pizza", select);

        return "view1";
    }

    @PostMapping(path = "/pizza/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveOrder(@Valid Order order, BindingResult binding, Model model) {

        if (binding.hasErrors()) {
            return "view1";
        }

        pizzaSvr.saveOrder(order);

        if (order.getIsRush()) {
            total += 2;
        }

        model.addAttribute("order", order);
        return "null"; // return "view2"
    }

}
