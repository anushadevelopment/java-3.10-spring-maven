package sg.edu.ntu.javaspringmaven310;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private ArrayList<Customer> customers = new ArrayList<>();
    
    
    public CustomerController(){
        customers.add(new Customer("Bruce", "Wayne"));
        customers.add(new Customer("lolly", "lilly"));
        customers.add(new Customer("Peter", "Parker"));
    }

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customers.add(customer);
        return  new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<ArrayList<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        try{
            int index = getCustomerIndex(id);
            return new ResponseEntity<>(customers.get(index), HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
        int index = getCustomerIndex(id);
        if (index == -1){
            customers.add(customer);
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        }
        customers.set(index, customer);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
        int index = getCustomerIndex(id);
        return new ResponseEntity<>(customers.remove(index), HttpStatus.OK);
    }

    private int getCustomerIndex(String id){
        for(Customer customer : customers){
            if (customer.getId().equals(id)){
                return customers.indexOf(customer);
            }
        }
        throw new CustomerNotFoundException(id);

}
}

    

