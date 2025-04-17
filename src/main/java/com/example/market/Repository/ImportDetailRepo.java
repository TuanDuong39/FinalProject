package com.example.market.Repository;

import com.example.market.DTO.ImportDetail.AddImportDetailDTO;
import com.example.market.Entity.Import_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportDetailRepo extends JpaRepository <Import_Detail, Long> {
     List<Import_Detail> findByImportOrderId(Long import_id);
}

