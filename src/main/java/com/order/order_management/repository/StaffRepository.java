package com.order.order_management.repository;

import com.order.order_management.entity.StaffDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffDetails,Long> {
}
