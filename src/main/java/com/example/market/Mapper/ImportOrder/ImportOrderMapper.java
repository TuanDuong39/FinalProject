package com.example.market.Mapper.ImportOrder;

import com.example.market.DTO.Import_Order.AddImportDTO;
import com.example.market.DTO.Import_Order.ImportDTO;
import com.example.market.Entity.Import_Order;
import com.example.market.Entity.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImportOrderMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public ImportOrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImportDTO mapToDTO(Import_Order import_order) {
        ImportDTO importDTO = new ImportDTO();
        importDTO.setSupplierName(import_order.getSupplier().getName());
        importDTO.setTime(import_order.getTime());
        importDTO.setTotal_money(import_order.getTotal_money());
        importDTO.setStatus(import_order.getStatus());
        return importDTO;
    }

    public List<ImportDTO> mapToDTO(List<Import_Order> import_orders) {
        return import_orders.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Import_Order mapToEntity(AddImportDTO addImportDTO, Supplier supplier) {
        Import_Order import_order = new Import_Order();
        import_order.setSupplier(supplier);
        import_order.setStatus(1);
        return import_order;
    }


}
