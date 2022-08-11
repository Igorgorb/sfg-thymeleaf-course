package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 1/20/16.
 */
@Controller
public class IndexController {

    @RequestMapping({"","/", "/index", "index.html"})
    public String getIndex(){

        return "index";
    }
}
