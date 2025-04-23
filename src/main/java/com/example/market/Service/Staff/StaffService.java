package com.example.market.Service.Staff;

import com.example.market.DTO.Staff.AddStaffDTO;
import com.example.market.DTO.Staff.StaffDTO;
import com.example.market.Entity.Staff;
import com.example.market.Mapper.Staff.StaffMapper;
import com.example.market.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffService {
    private final StaffMapper staffMapper;
    private StaffRepo staffRepo;
    @Autowired
    public StaffService(StaffRepo staffRepo, StaffMapper staffMapper) {
        this.staffRepo = staffRepo;
        this.staffMapper = staffMapper;
    }

    @Transactional
    public List<StaffDTO> findAll(){
        List<Staff> staffList = staffRepo.findAll();
        return staffMapper.mapToDTO(staffList);
    }

    @Transactional
    public void addStaff(AddStaffDTO addStaffDTO){
        Staff staff = staffMapper.mapToEntity(addStaffDTO);
        staffRepo.save(staff);
    }

    @Transactional
    public void updateStaff(Long id,StaffDTO staffDTO){
        Staff staff = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staffMapper.mapToUpdateEntity(staffDTO,staff);
        staffRepo.save(staff);
    }

    @Transactional
    public StaffDTO getStaff(Long id){
        Staff staff = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        return staffMapper.mapToDTO(staff);
    }

    @Transactional
    public void deleteStaff(Long id){
        Staff staff = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        staffRepo.delete(staff);
    }

}
