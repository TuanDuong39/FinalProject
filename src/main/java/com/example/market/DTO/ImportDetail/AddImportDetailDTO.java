package com.example.market.DTO.ImportDetail;

public class AddImportDetailDTO {
    private int id_import;
    private int id_product;
    private int quantity;
    private int money;

    public AddImportDetailDTO() {

    }

    public AddImportDetailDTO(int id_import,int id_product, int quantity, int money) {
        this.id_import=id_import;
        this.id_product = id_product;
        this.quantity = quantity;
        this.money = money;
    }

    public long getId_import() {
        return id_import;
    }

    public void setId_import(int id_import) {
        this.id_import = id_import;
    }

    public long getId_product() {
        return  id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
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
