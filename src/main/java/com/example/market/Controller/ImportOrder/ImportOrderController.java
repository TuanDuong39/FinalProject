package com.example.market.Controller.ImportOrder;

import com.example.market.DTO.Import_Order.AddImportDTO;
import com.example.market.DTO.Import_Order.ImportDTO;
import com.example.market.Service.ImportOrder.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ImportOrderController {
    private ImportService importService;
    @Autowired
    public ImportOrderController(ImportService importService) {
        this.importService = importService;
    }

    @GetMapping("/showImport")
    public List<ImportDTO> getAllImportOrder() {
        return importService.getAllImports();
    }

    @GetMapping("/manageImport/{id}")
    public ImportDTO importDTO(@PathVariable long id){
        return importService.getImportById(id);
    }

    @PostMapping("/addImport")
    public ResponseEntity<Long> addImport(@RequestBody AddImportDTO addImportDTO) {
        System.out.println("Received DTO: " + addImportDTO.getId() + " - " + addImportDTO.getSupplierId());
        try{
            return ResponseEntity.ok(importService.addImport(addImportDTO));
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/deleteImport/{id}")
    public void deleteImport(@PathVariable long id) {
        importService.deleteImportById(id);
    }


}
