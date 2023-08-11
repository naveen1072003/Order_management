package com.order.order_management.service;

import com.order.order_management.entity.StaffDetails;
import com.order.order_management.repository.StaffRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private StaffRepository staffRepository;

    public String saveStaffDetails(StaffDetails staffDetails){
        staffRepository.save(staffDetails);
        return "Staff Details Saved!";
    }

    public String deleteStaff(long id){
       staffRepository.deleteById(id);
       return "Staff Deleted!";
    }
}
