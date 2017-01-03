package daniel.springframework.controllers;

import daniel.springframework.domain.Customer;
import daniel.springframework.services.CustomerService;
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
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listAllCustomers(Model model){

        model.addAttribute("customers", customerService.listAll());
        return "customer/customers";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomerById(@PathVariable Integer id, Model model){

        model.addAttribute("customer", customerService.getById(id));
        return "customer/customer";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){

        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform";
    }

    @RequestMapping("/customer/new")
    public String newCustomer(Model model){

        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping(value="/customers", method= RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/customer/" + savedCustomer.getId();
    }

    @RequestMapping("customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){

        customerService.delete(id);
        return "redirect:/customer/customers";
    }


}
