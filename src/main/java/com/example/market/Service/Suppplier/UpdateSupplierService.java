package com.example.market.Service.Suppplier;

import com.example.market.Entity.Supplier;
import com.example.market.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSupplierService {

    private SupplierRepo supplierRepo;
    @Autowired
    public UpdateSupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        //Lấy supplier theo id
        Supplier supplierEntity = supplierRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplierEntity.setName(supplier.getName());
        supplierEntity.setAddress(supplier.getAddress());
        supplierEntity.setEmail(supplier.getEmail());
        supplierEntity.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepo.save(supplierEntity);

        return supplierEntity;
    }


}
