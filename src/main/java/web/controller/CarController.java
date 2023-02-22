package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.object.Car;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public static String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("cars",
                Stream.of(new Car ("VW", "Polo"),
                new Car ("Audi", "Q3"),
                new Car ("Lada", "Kalina"),
                new Car ("BMW", "X4"),
                new Car ("Range Rover", "Sport"))
                        .limit(count).collect(Collectors.toList()));
        return "cars";
    }
}
