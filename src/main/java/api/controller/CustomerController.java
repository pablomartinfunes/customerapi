package api.controller;

import api.model.Customer;
import api.model.CustomerDAO;
import api.response.CustomerResponse;
import api.response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by pfunes on 09/09/17.
 */

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;
    private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        logger.info("Deleting customer id: " + id );
        if (customerDAO.findOne(id) != null) {
            customerDAO.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        logger.info("Saving customer " + customer);

        try {
            Customer c = customerDAO.save(customer);
            return new ResponseEntity<Customer>(c, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> allCustomers(){

        List<Customer> customerList = customerDAO.findAll();

        return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id){
        CustomerResponse customerResponse;
        Status status = new Status();

        Customer customer = customerDAO.findOne(id);

        if(customer != null){
            status.setCode(1);
            status.setDescription("Customer finded");
        }else{
            status.setCode(2);
            status.setDescription("Customer not finded");
        }

        customerResponse = new CustomerResponse(status, customer);

        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
                        produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Customer> changeCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){

        Customer c = customerDAO.findOne(id);
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        customerDAO.save(c);

        return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }

}
