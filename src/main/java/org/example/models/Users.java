package org.example.models;

public class Users {
    private String id;
    private String full_name;
    private String phone_number;

    public Users(String id, String full_name, String phone_number) {
        this.id = id;
        this.full_name = full_name;
        this.phone_number = phone_number;
    }

    public Users() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
