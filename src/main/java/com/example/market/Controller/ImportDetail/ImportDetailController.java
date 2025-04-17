package com.example.market.Controller.ImportDetail;

import com.example.market.DTO.ImportDetail.AddImportDetailDTO;
import com.example.market.DTO.ImportDetail.ManageImportDetailDTO;
import com.example.market.DTO.ImportDetail.UpdateImportDetailDTO;
import com.example.market.Service.ImportDetail.ImportDetailService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/manageImport")
public class ImportDetailController {
    private final ImportDetailService importDetailService;

    public ImportDetailController(ImportDetailService importDetailService) {
        this.importDetailService = importDetailService;
    }

    @PostMapping("/addImportDetail")
    public void addImportDetail(@RequestParam int id_import, @RequestBody AddImportDetailDTO importDetailDTO) {
        importDetailDTO.setId_import(id_import);
        importDetailService.addImportDetail(importDetailDTO);
    }

    @PutMapping("/updateImportDetail/{id}")
    public void updateImportDetail(@PathVariable long id, @RequestBody UpdateImportDetailDTO importDetailDTO) {
        importDetailService.updateImportDetail(id, importDetailDTO);
    }

    @GetMapping("/manageImportDetail/{import_id}")
    public List<ManageImportDetailDTO> getByImport_Id(@PathVariable long import_id) {
        return importDetailService.getAllImportDetail(import_id);
    }

}
