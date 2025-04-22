package com.example.market.DTO.ImportDetail;

public class ManageImportDetailDTO {
    private int id;
    private String productName;
    private long importId;
    private int quantity;
    private int money;

    public ManageImportDetailDTO(){

    }

    public ManageImportDetailDTO(int id,String productName, long importId, int quantity, int money) {
        this.id = id;
        this.productName = productName;
        this.importId = importId;
        this.quantity = quantity;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getImportId() {
        return importId;
    }

    public void setImportId(long importId) {
        this.importId = importId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
