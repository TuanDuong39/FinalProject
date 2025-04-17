package com.example.market.Service.Suppplier;

import com.example.market.Entity.Supplier;
import com.example.market.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteSupplierService {
    private SupplierRepo supplierRepo;
    @Autowired
    public DeleteSupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public void delete(Long id) {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Supplier not found"));

        supplierRepo.delete(supplier);
    }
}
