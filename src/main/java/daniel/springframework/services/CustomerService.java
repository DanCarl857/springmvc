package daniel.springframework.services;

import daniel.springframework.domain.Customer;

import java.util.List;

/**
 * Created by daniel on 1/3/17.
 */
public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer findCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
