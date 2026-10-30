package com.mycompany.framely;

public class Admin extends Pengguna {

    private String username;
    private String password;

    public Admin(String nama, String username, String password) {
        super(nama);
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    @Override
    public String getPeran() {
        return "Admin";
    }
}

