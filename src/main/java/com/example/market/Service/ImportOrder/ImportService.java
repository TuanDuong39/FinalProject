package com.example.market.Service.ImportOrder;

import com.example.market.DTO.Import_Order.AddImportDTO;
import com.example.market.DTO.Import_Order.ImportDTO;
import com.example.market.Entity.Import_Order;
import com.example.market.Entity.Supplier;
import com.example.market.Mapper.ImportOrder.ImportOrderMapper;
import com.example.market.Repository.ImportRepo;
import com.example.market.Repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImportService {
    private final SupplierRepo supplierRepo;
    private ImportRepo importRepo;
    private ImportOrderMapper importOrderMapper;
    @Autowired
    public ImportService(ImportRepo importRepo, ImportOrderMapper importOrderMapper, SupplierRepo supplierRepo) {
        this.importRepo = importRepo;
        this.importOrderMapper = importOrderMapper;
        this.supplierRepo = supplierRepo;
    }

    @Transactional
    public List<ImportDTO> getAllImports() {
        List<Import_Order> importOrder = importRepo.findAll();
        return importOrderMapper.mapToDTO(importOrder);
    }

    // get 1
    @Transactional
    public ImportDTO getImportById(Long id) {
        Import_Order importOrder = importRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Import Order not found"));
        return importOrderMapper.mapToDTO(importOrder);
    }

    // add Import
    @Transactional
    public Long addImport(AddImportDTO addImportDTO) {
        Supplier supplier = supplierRepo.findById(addImportDTO.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier not found"));
            Import_Order importOrder = importOrderMapper.mapToEntity(addImportDTO,supplier);
            Import_Order savedImportOrder = importRepo.save(importOrder);
            return savedImportOrder.getId();
    }

    //delete
    @Transactional
    public void deleteImportById(Long id) {
        importRepo.deleteById(id);
    }
}
