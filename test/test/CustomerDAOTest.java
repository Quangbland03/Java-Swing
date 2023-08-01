/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import java.util.List;
import model.Customer;
import model.CustomerDAO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author quang
 */
public class CustomerDAOTest {

    CustomerDAO customerDAO;

    public CustomerDAOTest() {
        customerDAO = new CustomerDAO();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("John", 25, "New York", 
                123456789, 101, "2023-06-19", 2.5, 100.0);
        customerDAO.addCustomer(customer);
        List<Customer> customers = customerDAO.getCustomers();
        assertEquals(1, customers.size());
        assertEquals(customer, customers.get(0));
    }

    @Test
    public void testEditCustomer() {
        Customer customer = new Customer("John", 25, "New York", 
                123456789, 101, "2023-06-19", 2.5, 100.0);
        customerDAO.addCustomer(customer);
        int selectedIndex = 0;
        String newName = "Jane";
        int newAge = 30;
        String newProvince = "California";
        int newPhone = 987654321;
        int newRoom = 102;
        String newDate = "2023-06-20";
        double newHours = 3.0;
        double newTotalPrice = 150.0;
        customerDAO.editCustomer(selectedIndex, newName, newAge, newProvince, 
                newPhone, newRoom, newDate, newHours, newTotalPrice);
        List<Customer> customers = customerDAO.getCustomers();
        Customer editedCustomer = customers.get(selectedIndex);
        assertEquals(newName, editedCustomer.getName());
        assertEquals(newAge, editedCustomer.getAge());
        assertEquals(newProvince, editedCustomer.getProvince());
    }

    @Test
    public void testGetCustomers() {
        Customer customer1 = new Customer("John", 25, "New York", 
                123456789, 101, "2023-06-19", 2.5, 100.0);
        Customer customer2 = new Customer("Jane", 30, "California", 
                987654321, 102, "2023-06-20", 3.0, 150.0);
        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);
        List<Customer> customers = customerDAO.getCustomers();
        assertEquals(2, customers.size());
        assertEquals(customer1, customers.get(0));
        assertEquals(customer2, customers.get(1));
    }

    @Test
    public void testRemove() {
        Customer customer1 = new Customer("John", 25, "New York", 
                123456789, 101, "2023-06-19", 2.5, 100.0);
        Customer customer2 = new Customer("Jane", 30, "California", 
                987654321, 102, "2023-06-20", 3.0, 150.0);
        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);
        int indexToRemove = 0;
        customerDAO.remove(indexToRemove);
        List<Customer> customers = customerDAO.getCustomers();
        assertEquals(1, customers.size());
        assertEquals(customer2, customers.get(0));
    }

    @Test
    public void testSearchCustomer() {
        Customer customer1 = new Customer("John Doe", 25, "New York", 
                123456789, 101, "2023-06-19", 2.5, 100.0);
        Customer customer2 = new Customer("Jane Smith", 30, "California", 
                987654321, 102, "2023-06-20", 3.0, 150.0);

        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);
        String searchText = "John";
        List<Customer> searchResults = customerDAO.searchCustomer(searchText);
        assertEquals(1, searchResults.size());
        assertEquals(customer1, searchResults.get(0));
    }

    @Test
    public void testIsRoomBooked() {
        Customer customer1 = new Customer("John", 25, "New York", 123456789, 
                101, "20-06-2023", 2.5, 100.0);
        Customer customer2 = new Customer("Jane", 30, "California", 987654321, 
                102, "21-06-2023", 3.0, 150.0);
        customerDAO.addCustomer(customer1);
        customerDAO.addCustomer(customer2);
        assertTrue(customerDAO.isRoomBooked(102, "20-06-2023", customerDAO));
        assertFalse(customerDAO.isRoomBooked(103, "21-06-2023", customerDAO));
    }

    

}
