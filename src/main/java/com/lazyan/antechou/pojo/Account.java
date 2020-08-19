package com.lazyan.antechou.pojo;

public class Account {

    private int id;
    private String mailbox;
    private String password;
    private String salt;
    private String lost_ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLost_ip() {
        return lost_ip;
    }

    public void setLost_ip(String lost_ip) {
        this.lost_ip = lost_ip;
    }
}
