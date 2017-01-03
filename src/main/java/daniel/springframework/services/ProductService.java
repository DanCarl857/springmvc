package daniel.springframework.services;

import daniel.springframework.domain.Product;

import java.util.List;

/**
 * Created by daniel on 1/3/17.
 */
public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
