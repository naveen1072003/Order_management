package com.order.order_management.controller;

import com.order.order_management.dto.imageDto;
import com.order.order_management.repository.ImageRepo;
import com.order.order_management.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin
@RequestMapping("/sample")
public class ImageController {

    @Autowired
    private ImageRepo imageRepo;

    @PostMapping("/uploadImage")
    public String uploadImage(MultipartFile file) throws IOException {

        imageDto imageData = imageRepo.save(imageDto.builder()
                .name(file.getOriginalFilename())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }


    @GetMapping("/getImage")
    public byte[] downloadImage(String fileName) {
        List<imageDto> imageDtoList = imageRepo.findAll();
        return ImageUtil.decompressImage(imageDtoList.get(3).getImageData());
    }


}
