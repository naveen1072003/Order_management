package com.order.order_management.repository;

import com.order.order_management.dto.imageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<imageDto,Long> {
}
