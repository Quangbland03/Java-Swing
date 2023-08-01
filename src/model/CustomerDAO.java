/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author quang
 */
public class CustomerDAO {

    private static List<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        this.customers = new ArrayList<>(); // Khởi tạo danh sách sinh viên
    }
// add customer

    public void addCustomer(Customer c) {
        customers.add(c);
    }
// eidt customer

    public void editCustomer(int selectedIndex, String name, int age, String province,
            int phone, int room, String date, double hours, double totalprice) {
        if (selectedIndex >= 0 && selectedIndex < customers.size()) {
            Customer selectedStudent = customers.get(selectedIndex);
            selectedStudent.setName(name);
            selectedStudent.setAge(age);
            selectedStudent.setProvince(province);
            selectedStudent.setPhone(phone);
            selectedStudent.setRoom(room);
            selectedStudent.setDate(date);
            selectedStudent.setHours(hours);
            selectedStudent.setTotalprice(totalprice);
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void remove(int index) {
        customers.remove(index);
    }

    public List<Customer> searchCustomer(String searchText) {
        List<Customer> searchResults = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(searchText.toLowerCase())) {
                searchResults.add(customer);
            }
        }
        return searchResults;
    }

    public boolean isRoomBooked(int room, String date, CustomerDAO cusdao) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate bookingDate = LocalDate.parse(date, formatter);

        // Kiểm tra nếu ngày đặt phòng là quá khứ
        if (bookingDate.isBefore(currentDate)) {
            JOptionPane.showMessageDialog(null, "Do not set a date in the past.", "Error"
                    , JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (Customer booking : cusdao.getCustomers()) {
            if (booking.getRoom() == room && booking.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

// sort by price
    public void sortbyprice(CustomerDAO cusdao) {
        List<Customer> Customers = cusdao.getCustomers();
        Collections.sort(Customers, new Comparator<Customer>() { 
            @Override
            public int compare(Customer s1, Customer s2) {
                return Double.compare(s1.getTotalprice(), s2.getTotalprice());
            }
        });

    }

}
