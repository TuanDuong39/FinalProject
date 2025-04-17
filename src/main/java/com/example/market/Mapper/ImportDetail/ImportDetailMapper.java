package com.example.market.Mapper.ImportDetail;

import com.example.market.DTO.ImportDetail.AddImportDetailDTO;
import com.example.market.DTO.ImportDetail.ManageImportDetailDTO;
import com.example.market.DTO.ImportDetail.UpdateImportDetailDTO;
import com.example.market.Entity.Import_Detail;
import com.example.market.Entity.Inventory;
import com.example.market.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImportDetailMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public ImportDetailMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    //add
    public Import_Detail mapTOEntity(AddImportDetailDTO addImportDetailDTO) {
        Product product = new Product();
        product.setId(addImportDetailDTO.getId_product());

        Import_Detail importDetail = new Import_Detail();
        importDetail.setMoney(addImportDetailDTO.getMoney());
        importDetail.setQuantity(addImportDetailDTO.getQuantity());
        return importDetail;
    }

    //update
    public void mapTOEntity(UpdateImportDetailDTO updateImportDetailDTO, Import_Detail importDetail) {
        modelMapper.map(updateImportDetailDTO, importDetail);
    }

    public ManageImportDetailDTO mapDtoForShow(Import_Detail importDetail) {
        ManageImportDetailDTO manageImportDetailDTO = new ManageImportDetailDTO();
        manageImportDetailDTO.setProductName(importDetail.getProduct().getName());
        manageImportDetailDTO.setImportId(importDetail.getImportOrder().getId());
        manageImportDetailDTO.setQuantity(importDetail.getQuantity());
        manageImportDetailDTO.setMoney(importDetail.getMoney());
        return manageImportDetailDTO;
    }

    public List<ManageImportDetailDTO> mapDtoForShow(List<Import_Detail> importDetailList) {
        return importDetailList.stream()
                .map(this::mapDtoForShow)
                .collect(Collectors.toList());
    }
}
