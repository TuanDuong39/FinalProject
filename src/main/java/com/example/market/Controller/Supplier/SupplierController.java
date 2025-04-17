package com.example.market.Controller.Supplier;

import com.example.market.Entity.Supplier;
import com.example.market.Service.Suppplier.AddSupplierService;
import com.example.market.Service.Suppplier.DeleteSupplierService;
import com.example.market.Service.Suppplier.SupplierService;
import com.example.market.Service.Suppplier.UpdateSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SupplierController {
    private final SupplierService supplierService;
    private final AddSupplierService addSupplierService;
    private final UpdateSupplierService updateSupplierService;
    private final DeleteSupplierService deleteSupplierService;

    @Autowired
    public SupplierController(SupplierService supplierService, AddSupplierService addSupplierService, UpdateSupplierService updateSupplierService, DeleteSupplierService deleteSupplierService) {
        this.supplierService = supplierService;
        this.addSupplierService = addSupplierService;
        this.updateSupplierService = updateSupplierService;
        this.deleteSupplierService = deleteSupplierService;
    }

    @GetMapping("/manageSupplier")
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/addSupplier")
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return addSupplierService.addSupplier(supplier);
    }

    @PutMapping("/updateSupplier/{id}")
    public Supplier updateSupplier(@PathVariable long id, @RequestBody Supplier supplier){
        return updateSupplierService.updateSupplier(id, supplier);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable long id){
         deleteSupplierService.delete(id);
         return "delete success";
    }
}
