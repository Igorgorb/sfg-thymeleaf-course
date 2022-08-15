package guru.springframework.services;

import guru.springframework.domain.Product;
import java.util.List;

/**
 *
 * @author igorg
 * @date 15 серп. 2022 р.
 */
public interface ProductService {

  Product getProduct(Integer id);

  List<Product> listProducts();
}
