/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.ERROR;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import model.Customer;
import model.CustomerDAO;
import view.Home;
import view.ViewBIll;

/**
 *
 * @author quang
 */
public class ControllerCustomer {

    private Home home;
    private CustomerDAO model;
    private static final String FILE_EMPLOYEE = "employee.bin";

    public ControllerCustomer(Home home) {
        this.home = home;

        model = new CustomerDAO();
        init();
    }

    public ControllerCustomer() {
    }

    public List<Customer> getCustomers() {
        return model.getCustomers();
    }

    public void init() {
        home.btnAddaddProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (home.check2()) {
                    String name = home.getTxtname();
                    int age = home.getTxtage();
                    String province = home.getTxtprovince();
                    int phone = home.getPhone();
                    int room = home.getRoom();
                    String date = home.getDate();
                    double hours = home.getHours();
                    double price = home.getPrice();
                    if (model.isRoomBooked(room, date, model)) {
                        JOptionPane.showMessageDialog(home, "This room is already booked.");
                    } else {
                        Customer cus2 = new Customer(name, age, province, phone, room, date, hours, price);
                        model.addCustomer(cus2);
                        home.showData(model);
                        JOptionPane.showMessageDialog(home, "Add data successfully");
                    }
                }
                try {
                    writeDataFile();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
                home.changeColor1(model);
            }

        });

        home.btnEditeditProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = home.getindex();
                if (model.getCustomers().isEmpty()) {
                    JOptionPane.showMessageDialog(home, "Add data before editing");
                } else if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(home, "Select the line that you need to edit");
                } else {
                    String name = home.getTxtname();
                    int age = home.getTxtage();
                    String province = home.getTxtprovince();
                    int phone = home.getPhone();
                    int room = home.getRoom();
                    String date = home.getDate();
                    double hours = home.getHours();
                    double price = home.getPrice();
                    model.editCustomer(selectedIndex, name, age, province, phone, room, date, hours, price);
                    home.tablelear();
                    selectedIndex = -1;
                    home.showData(model);
                    JOptionPane.showMessageDialog(home, "successful edit");
                }

            }
        });
        home.addTableMouseClickedListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                home.tableclick(model, evt);
                home.changeColor1(model);
            }
        });
        home.btnRemoveremoveProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.removebtn(model);
            }
        });
        home.btnRemoveallremoveProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to delete all data?", "Confirm data deletion", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    home.clearAll(model);
                    home.resetFields();
                }
            }
        });

        home.btnBackAfterbackafterProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.showData(model);
            }
        });

        home.btnSearchsearchProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.searchbyName(model);
            }
        });
        home.btnbillBillProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (model.getCustomers().isEmpty()) {
                    JOptionPane.showMessageDialog(home, "No data has been entered");
                } else if (home.getindex() == -1) {
                    JOptionPane.showMessageDialog(home, "No lines to select");
                } else {
                    ViewBIll bill = new ViewBIll();
                    bill.setVisible(true);
                    String name = home.getTxtname();
                    String province = home.getTxtprovince();
                    String room = home.getRoom1();
                    String date = home.getDate();
                    String hours = home.getHours1();
                    String price = home.getprice1();
                    bill.setname(name);
                    bill.setprovince(province);
                    bill.setroom(room);
                    bill.setdate(date);
                    bill.sethours(hours);
                    bill.settotalprice(price);
                }
            }
        });
        home.btnexit11ProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writeDataFile();
                } catch (IOException ex) {
                    Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        home.btnsortbypriceProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getCustomers().size() < 2) {
                    JOptionPane.showMessageDialog(home, "you need to enter at least 2 rows or more to sort");
                } else {
                    model.sortbyprice(model);
                    home.showData(model);
                    JOptionPane.showMessageDialog(home, "Successful sort");
                }

            }
        });
    }

    public void writeDataFile() throws IOException {
        // 2. save data
        String fileName = "D:\\Filesave\\demo.bin"; // bin: binary format
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(model.getCustomers());
        System.out.println("Save data to file " + fileName + " succeed !");
        oos.close();
//        fos.close();
    }

    public void readDataFile() throws IOException, ClassNotFoundException {
        String filename = "D:\\Filesave\\demo.bin";
        List<Customer> customers = model.getCustomers();
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        customers = (List<Customer>) ois.readObject();
        ois.close();
        fis.close();

        // Thêm dữ liệu vào đối tượng model
        model.getCustomers().clear();
        model.getCustomers().addAll(customers);

        // In dữ liệu đọc từ tệp trên console
        System.out.println("Data read from file " + filename + ":");
        for (Customer customer : customers) {
            home.showData(model);
            System.out.println(customer);
        }
    }

}
