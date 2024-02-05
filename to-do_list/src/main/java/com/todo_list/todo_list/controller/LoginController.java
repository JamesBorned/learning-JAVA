package com.todo_list.todo_list.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginSignupButton;

    @FXML
    private TextField loginUsername;

    @FXML
    void initialize(){
        loginButton.setOnAction(event -> {
            System.out.println("Login Clicked!");
        });
    }
}
