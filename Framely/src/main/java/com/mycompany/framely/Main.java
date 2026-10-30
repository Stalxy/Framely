package com.mycompany.framely;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }
}