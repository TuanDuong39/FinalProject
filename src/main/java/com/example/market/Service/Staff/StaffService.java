package com.example.market.Service.Staff;

import com.example.market.DTO.Staff.AddStaffDTO;
import com.example.market.DTO.Staff.StaffDTO;
import com.example.market.Entity.Staff;
import com.example.market.Mapper.Staff.StaffMapper;
import com.example.market.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.market.Repository.RoleRepo;
import com.example.market.Entity.Role;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class StaffService {
    private final StaffMapper staffMapper;
    private final StaffRepo staffRepo;
    private final RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public StaffService(StaffRepo staffRepo, StaffMapper staffMapper, RoleRepo roleRepo) {
        this.staffRepo = staffRepo;
        this.staffMapper = staffMapper;
        this.roleRepo = roleRepo;
    }

    @Transactional
    public List<StaffDTO> findAll(){
        List<Staff> staffList = staffRepo.findAll();
        return staffMapper.mapToDTO(staffList);
    }

    @Transactional
    public void addStaff(AddStaffDTO addStaffDTO) {
        Staff staff = new Staff();
        staff.setUsername(addStaffDTO.getUsername());
        staff.setPassword(passwordEncoder.encode(addStaffDTO.getPassword()));
        staff.setEmail(addStaffDTO.getEmail());

        Role role = roleRepo.findByRoleName(addStaffDTO.getRoleName())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Role không tồn tại"
                ));

        staff.setRole(role);

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
