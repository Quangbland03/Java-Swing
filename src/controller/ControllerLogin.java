/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CustomerDAO;
import view.Home;
import view.LoginFrm;

/**
 *
 * @author quang
 */
public class ControllerLogin {

    private LoginFrm login;

    public ControllerLogin(LoginFrm login) {
        this.login = login;
        login.btnAddaddProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.Login();
            }
        });

    }

}
