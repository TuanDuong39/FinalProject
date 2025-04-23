package com.example.market.Service.ImportDetail;

import com.example.market.DTO.ImportDetail.AddImportDetailDTO;
import com.example.market.DTO.ImportDetail.ManageImportDetailDTO;
import com.example.market.DTO.ImportDetail.UpdateImportDetailDTO;
import com.example.market.Entity.Import_Detail;
import com.example.market.Entity.Import_Order;
import com.example.market.Entity.Inventory;
import com.example.market.Entity.Product;
import com.example.market.Mapper.ImportDetail.ImportDetailMapper;
import com.example.market.Repository.ImportDetailRepo;
import com.example.market.Repository.ImportRepo;
import com.example.market.Repository.InventoryRepo;
import com.example.market.Repository.ProductRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImportDetailService {
    private final ProductRepo productRepo;
    private final ImportRepo importRepo;
    private final InventoryRepo inventoryRepo;
    private ImportDetailRepo importDetailRepo;
    private ImportDetailMapper importDetailMapper;
    @Autowired
    public ImportDetailService(ImportDetailRepo importDetailRepo, ImportDetailMapper importDetailMapper, ProductRepo productRepo, ImportRepo importRepo, InventoryRepo inventoryRepo) {
        this.importDetailRepo = importDetailRepo;
        this.importDetailMapper = importDetailMapper;
        this.productRepo = productRepo;
        this.importRepo = importRepo;
        this.inventoryRepo = inventoryRepo;
    }

    //add impl id_import
    @Transactional
    public void addImportDetail(AddImportDetailDTO addImportDetailDTO) {
        Product product = productRepo.findById(addImportDetailDTO.getId_product())
                .orElse(null);

        if(product == null){
            product = new Product();
            productRepo.save(product);

            Inventory inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setQuantity(addImportDetailDTO.getQuantity());
            inventoryRepo.save(inventory);
        }
        else {
            Inventory inventory = inventoryRepo.findByProduct(product).orElseThrow(()
                    -> new RuntimeException("product in inventory is null"));
            inventory.setQuantity(inventory.getQuantity() + addImportDetailDTO.getQuantity());
            inventoryRepo.save(inventory);
        }


        // Lấy đơn nhập từ id_import
        Import_Order importOrder = importRepo.findById(addImportDetailDTO.getId_import())
                .orElseThrow(() -> new RuntimeException("Import Order not found"));

        Import_Detail importDetail = importDetailMapper.mapTOEntity(addImportDetailDTO);
        importDetail.setProduct(product);
        importDetail.setImportOrder(importOrder);
        importDetailRepo.save(importDetail);

        List<Import_Detail> details = importDetailRepo.findByImportOrderId(importOrder.getId());

        double totalMoney = details.stream()
                .mapToDouble(d -> d.getQuantity() * d.getMoney())
                .sum();

        importOrder.setTotal_money(totalMoney);
        importRepo.save(importOrder);
    }

    // update
    @Transactional
    public void updateImportDetail(Long id, UpdateImportDetailDTO updateImportDetailDTO) {
        Import_Detail importDetail = importDetailRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Id Import Detail not found"));

        importDetailMapper.mapTOEntity(updateImportDetailDTO, importDetail);
        importDetailRepo.save(importDetail);
    }

    @Transactional
    // show detail by id_import
    public List<ManageImportDetailDTO> getAllImportDetail(Long import_id){

        List<Import_Detail> importDetails = importDetailRepo.findByImportOrderId(import_id);
        return importDetailMapper.mapDtoForShow(importDetails);
    }
}
