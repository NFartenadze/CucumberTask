package solvd.carina.BDD.db.models;

public class Orders {
    private Long id;
    private Long userID;
    private String productName;
    private Double productPrice;

    public Orders(Long userID, String productName, Double productPrice) {
        this.userID = userID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Orders(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}