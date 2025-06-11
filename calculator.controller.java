package calculator.controllers;

import calculator.TitleDTO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("calculator")
public class CalculatorController {

    @GetMapping
    public String renderCalculator() {
        return "calculator";
    }

}
@GetMapping
public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO,
                               @ModelAttribute TitleDTO titleDTO) {
    titleDTO.setTitle("Spring Calculator!");

    return "calculator";
}

@PostMapping
public String calculate(
        @ModelAttribute CalculatorDTO calculatorDTO,
        Model model
) {
    float calculationResult = calculatorService.calculate(calculatorDTO);
    model.addAttribute("calculationResult", calculationResult);
    return "result";
}

@Controller
public class CustomErrorController implements ErrorController {

}
