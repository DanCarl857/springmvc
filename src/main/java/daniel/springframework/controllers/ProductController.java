package daniel.springframework.controllers;

import daniel.springframework.domain.Product;
import daniel.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daniel on 1/3/17.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model){

        model.addAttribute("products", productService.listAll());
        return "/product/products";
    }

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable(name = "id") Integer id, Model model){

        model.addAttribute("product", productService.getById(id));

        return "/product/product";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        model.addAttribute("product", productService.getById(id));
        return "/product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){

        model.addAttribute("product", new Product());
        return "/product/productform";
    }

    @RequestMapping(value="/product" , method= RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/product/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){

        productService.delete(id);
        return "redirect:/product/products";
    }
}
