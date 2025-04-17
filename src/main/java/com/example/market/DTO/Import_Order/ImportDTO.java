package com.example.market.DTO.Import_Order;

import java.time.LocalDate;

public class ImportDTO {
    private long id;
    private LocalDate time;
    private String supplierName;
    private int total_money;
    private int status;

    public ImportDTO() {

    }

    public ImportDTO(long id, LocalDate time, String supplierName, int total_money, int status) {
        this.id = id;
        this.time = time;
        this.supplierName = supplierName;
        this.total_money = total_money;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
