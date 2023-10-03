package com.order.order_management.controller;

import com.order.order_management.dto.ImageDto;
import com.order.order_management.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sample")
public class ImageController {

    @Autowired
    private ImageRepo imageRepo;

    @PostMapping(value = "/uploadImage")
    public String uploadImage(
            @RequestParam MultipartFile file
    ) throws IOException {
        imageRepo.save(new ImageDto(Base64.getEncoder().encodeToString(file.getBytes()), file.getOriginalFilename()));

        return "Image uploaded successfully";
    }


    @GetMapping("/getImage")
    public String downloadImage(String fileName) {
        List<ImageDto> imageDtoList = imageRepo.findAll();
        return "data:image/png;base64," + imageDtoList.get(0).getImageData();
    }
}