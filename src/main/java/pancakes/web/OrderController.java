package pancakes.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pancakes.Order;
import pancakes.dao.OrderRepository;

@Slf4j
@Controller
@RequestMapping( "/orders")
@SessionAttributes( "order" )
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController( OrderRepository orderRepo ) {

        this.orderRepo = orderRepo;
    }

    @GetMapping( "/current" )
    public String showOrderForm( Model model ) {

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@ModelAttribute Order order, SessionStatus sessionStatus ) {

        orderRepo.save( order );
        sessionStatus.setComplete();
        log.info( "Order is ready: " + order );
        return "redirect:/";
    }
}
