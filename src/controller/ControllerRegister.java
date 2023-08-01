/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.LoginFrm;
import view.RegisterFrm;

/**
 *
 * @author quang
 */
public class ControllerRegister {
     private RegisterFrm register;

    public ControllerRegister(RegisterFrm register) {
        this.register = register;
        register.btnreggiProductListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              register.register();
            }
        });
    }}

                

