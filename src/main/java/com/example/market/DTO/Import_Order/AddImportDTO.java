package com.example.market.DTO.Import_Order;

public class AddImportDTO {
    private long id;
    private long supplierId;

    public AddImportDTO() {

    }

    public AddImportDTO(long id, int supplierId) {
        this.id = id;
        this.supplierId = supplierId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }
}
