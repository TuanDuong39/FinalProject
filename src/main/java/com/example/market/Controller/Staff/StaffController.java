package com.example.market.Controller.Staff;

import com.example.market.DTO.Staff.AddStaffDTO;
import com.example.market.DTO.Staff.StaffDTO;
import com.example.market.Service.Staff.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/manageStaff")
    public List<StaffDTO> findAll(){
        return staffService.findAll();
    }

    @PostMapping("/addStaff")
    public ResponseEntity<?> addStaff(@RequestBody AddStaffDTO addStaffDTO){
        staffService.addStaff(addStaffDTO);
        return ResponseEntity.ok("Add thành công ");
    }

    @PutMapping("/updateStaff/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable Long id, @RequestBody StaffDTO staffDTO){
        staffService.updateStaff(id, staffDTO);
        return ResponseEntity.ok("Update success");
    }

    @GetMapping("/getStaff/{id}")
    public StaffDTO findStaffById(@PathVariable Long id){
        return staffService.getStaff(id);
    }

    @DeleteMapping("/deleteStaff/{id}")
    public void deleteStaffById(@PathVariable Long id){
        staffService.deleteStaff(id);
    }
}
