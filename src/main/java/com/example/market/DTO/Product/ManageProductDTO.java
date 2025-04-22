package com.example.market.DTO.Product;

public class ManageProductDTO {
    private int id;
    private String name;
    private String unit;
    private int price;
    private String description;
    private String manufacturer;
    private String categoryName;

    public ManageProductDTO() {

    }

    public ManageProductDTO(int id,String name, String unit, int price, String description, String manufacturer, String categoryName) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
