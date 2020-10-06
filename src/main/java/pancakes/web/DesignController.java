package pancakes.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pancakes.Order;
import pancakes.Pancake;
import pancakes.Sauce;
import pancakes.dao.PancakeRepository;
import pancakes.dao.SauceRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping( "/design" )
@SessionAttributes( "order" )
public class DesignController {

    PancakeRepository pancakeRepo;
    SauceRepository sauceRepo;

    public DesignController( PancakeRepository pancakeRepo, SauceRepository sauceRepo ) {

        this.pancakeRepo = pancakeRepo;
        this.sauceRepo = sauceRepo;
    }

    @ModelAttribute( "order" )
    public Order order() {

        return new Order();
    }

    @GetMapping
    public String showDesignForm( Model model ) {

        List<Pancake> pancakes = new ArrayList<>();
        pancakeRepo.findAll().forEach( ( n ) -> pancakes.add( n ) );
        model.addAttribute( "Pancakes", pancakes );
        List<Sauce> sauces = new ArrayList<>();
        sauceRepo.findAll().forEach( ( n ) -> sauces.add( n ) );
        model.addAttribute( "Sauces", sauces );
        return "design";
    }

    @PostMapping
    public String processDesign() {


        return "redirect:/orders/current";
    }
}
