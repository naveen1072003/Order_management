package com.order.order_management.service;

import com.order.order_management.entity.StaffDetails;
import com.order.order_management.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    @Autowired
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
