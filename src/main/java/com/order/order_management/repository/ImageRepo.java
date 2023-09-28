package com.order.order_management.repository;

import com.order.order_management.dto.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageDto,Long> {
}
