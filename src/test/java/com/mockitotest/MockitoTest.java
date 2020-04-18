package com.mockitotest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {
    @Mock
    MyDataBase dataBaseMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private EntityManager entityManager;

    @Test
    public void testQuery() {
        ClassToTest t = new ClassToTest(dataBaseMock);
        when(dataBaseMock.query("* from t")).thenReturn(true);
        boolean check = t.query("* from t");
        Assert.assertTrue(check);
    }

    @Test
    public void customerReaderTest() {
        Customer sampleCustomer = new Customer("Susan","Ivanova");

        EntityManager entityManger = mock(EntityManager.class);
        when(entityManger.find(Customer.class,1L)).thenReturn(sampleCustomer);

        CustomerReader customerReader = new CustomerReader();
        customerReader.setEntityManager(entityManger);

        String findFullName = customerReader.findFullName(1L);
        Assert.assertEquals("Susan Ivanova",findFullName);
    }
}
