package api.response;

import api.model.Customer;

/**
 * Created by pfunes on 13/09/17.
 */
public class CustomerResponse {

    private Status status;
    private Customer customer;

    public CustomerResponse(Status status, Customer customer) {
        this.status = status;
        this.customer = customer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
