package com.example.market.Mapper.Staff;

import com.example.market.DTO.Customer.CustomerDTO;
import com.example.market.DTO.Staff.AddStaffDTO;
import com.example.market.DTO.Staff.StaffDTO;
import com.example.market.Entity.Customer;
import com.example.market.Entity.Staff;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffMapper {
    private final ModelMapper modelMapper;
    @Autowired
    public StaffMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StaffDTO mapToDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setUsername(staff.getUsername());
        staffDTO.setEmail(staff.getEmail());

        if (staff.getRole() != null) {
            staffDTO.setRoleName(staff.getRole().getRoleName());
        } else {
            staffDTO.setRoleName(null);
        }
        return staffDTO;
    }

    public List<StaffDTO> mapToDTO(List<Staff> staffList) {
        return staffList
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Staff mapToEntity(AddStaffDTO addStaffDTO) {
        return modelMapper.map(addStaffDTO, Staff.class);
    }

    public void mapToUpdateEntity(StaffDTO staffDTO, Staff staff) {
        modelMapper.map(staffDTO, staff);
    }

}
