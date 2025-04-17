package com.example.market.Service.Suppplier;

import com.example.market.Entity.Supplier;
import com.example.market.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddSupplierService {

    private SupplierRepo supplierRepo;
    @Autowired
    public AddSupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }
}
