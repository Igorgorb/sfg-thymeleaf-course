package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author igorg
 * Date 21.05.2022
 */
@Controller
public class MainController {

    @RequestMapping({"","/", "/index", "index.html"})
    public String indexPage() {
        return "index";
    }

    @RequestMapping({"/product", "/product.html"})
    public String productPage() {
        return "product";
    }
}
