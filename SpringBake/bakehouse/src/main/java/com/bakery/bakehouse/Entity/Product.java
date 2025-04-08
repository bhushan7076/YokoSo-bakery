package com.bakery.bakehouse.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer pId; 

    @Column
    private String pName; 

    @Column
    private String pCategory; 

    @Column
    private String pDesc; // Matches varchar(100)

    @Column
    private Double pPrice; // Matches decimal(10,2)
    
    @Column 
    private String imageUrl;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(Integer pId, String pName, String pCategory, String pDesc, Double pPrice,String imageUrl) {
        this.pId = pId;
        this.pName = pName;
        this.pCategory = pCategory;
        this.pDesc = pDesc;
        this.pPrice = pPrice;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public String getImageUrl() { 
    	return imageUrl; 
    }
    
    public void setImageUrl(String imageUrl) {
    	this.imageUrl = imageUrl;
    }
    
    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPCategory() {
        return pCategory;
    }

    public void setPCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getPDesc() {
        return pDesc;
    }

    public void setPDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public Double getPPrice() {
        return pPrice;
    }

    public void setPPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pCategory='" + pCategory + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", pPrice=" + pPrice +
                ",pImageUrl="+imageUrl+
                '}';
    }
}
