package com.order.order_management.controller;

import com.order.order_management.entity.StaffDetails;
import com.order.order_management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping
    public String saveStaff(StaffDetails staffDetails){
        return adminService.saveStaffDetails(staffDetails);
    }

    @PostMapping("/")
    public String removeStaff(Long id){
        return adminService.deleteStaff(id);
    }
}
