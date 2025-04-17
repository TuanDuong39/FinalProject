package com.example.market.Service.Suppplier;

import com.example.market.Entity.Supplier;
import com.example.market.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepo supplierRepo;
    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }
}
