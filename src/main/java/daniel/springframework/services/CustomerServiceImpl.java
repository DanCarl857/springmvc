package daniel.springframework.services;

import daniel.springframework.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by daniel on 1/3/17.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        super();
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Product can't be null");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers(){

        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Daniel");
        customer1.setLastName("Carlson");
        customer1.setEmail("dancarl857@gmail.com");
        customer1.setPhoneNumber("67xxxxxxx");
        customer1.setAddressLineOne("rhada");
        customer1.setAddressLineTwo("rhada bak");
        customer1.setCity("Buea");
        customer1.setState("SW");

        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Mark");
        customer2.setLastName("Ryan");
        customer2.setEmail("markusryanus@gmail.com");
        customer2.setPhoneNumber("67xxxxxxx");
        customer2.setAddressLineOne("rhada");
        customer2.setAddressLineTwo("rhada bak");
        customer2.setCity("Buea");
        customer2.setState("SW");

        customers.put(2, customer2);
    }
}
