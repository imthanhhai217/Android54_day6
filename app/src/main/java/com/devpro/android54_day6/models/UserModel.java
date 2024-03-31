package com.devpro.android54_day6.models;

public class UserModel {
    private String userName, password, address;
    private int age;

    public UserModel() {
    }

    public UserModel(String userName, String password, String address, int age) {
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
