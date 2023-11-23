package com.example.contador;

public class Usuario {
    private int id;
    private String username;
    private String password;

    public Usuario(String username, String password, int id) {
        this.username = username;
        this.id=id;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    // Constructor, getters y setters
}
