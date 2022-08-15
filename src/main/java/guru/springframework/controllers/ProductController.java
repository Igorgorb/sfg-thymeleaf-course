package guru.springframework.controllers;

import guru.springframework.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jt on 1/20/16.
 */
@Controller
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping({"/product", "/product.html"})
  public String getProduct() {
    return "product";
  }

  @RequestMapping("/product/{id}")
  public String getProductById(@PathVariable Integer id, Model model) {
    model.addAttribute("product", productService.getProduct(id));
    return "product";
  }
}
