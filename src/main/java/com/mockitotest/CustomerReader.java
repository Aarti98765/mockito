package com.mockitotest;

public class CustomerReader {
    private EntityManager entityManager;
    public void setEntityManager(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    public String findFullName(long id) {
        Customer customer = this.entityManager.find(Customer.class, id);
        return customer.fname + " " + customer.lname;
    }
}
