package com.bakery.bakehouse.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer custId;

    @Column
    private String custEmail;

    @Column
    private String custMobile;

    @Column
    private String custName;

    @Column
    private String custPassword;

    @Column
    private String custUsername;

    // Constructors
    public Customer() {}

    public Customer(String custEmail, String custMobile, String custName, String custPassword, String custUsername) {
        this.custEmail = custEmail;
        this.custMobile = custMobile;
        this.custName = custName;
        this.custPassword = custPassword;
        this.custUsername = custUsername;
    }

    // Getters and Setters
    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custEmail='" + custEmail + '\'' +
                ", custMobile='" + custMobile + '\'' +
                ", custName='" + custName + '\'' +
                ", custPassword='" + custPassword + '\'' +
                ", custUsername='" + custUsername + '\'' +
                '}';
    }
}
