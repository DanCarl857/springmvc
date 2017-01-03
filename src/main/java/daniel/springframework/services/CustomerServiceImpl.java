package daniel.springframework.services;

import daniel.springframework.domain.Customer;
import daniel.springframework.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by daniel on 1/3/17.
 */
@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    private Map<Integer, Customer> customers;

    public List<DomainObject> listAllCustomers() { return super.listAll(); }

    @Override
    public Customer getById(Integer id) { return (Customer) super.getById(id); }

    @Override
    public Customer saveOrUpdate(Customer domainObject) { return (Customer) super.saveOrUpdate(domainObject); }

    @Override
    public void delete(Integer id) { super.delete(id); }

    public CustomerServiceImpl() {
        super();
        loadDomainObjects();
    }

    protected void loadDomainObjects(){

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
