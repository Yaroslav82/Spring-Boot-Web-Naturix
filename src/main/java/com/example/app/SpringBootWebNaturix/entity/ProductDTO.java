package com.example.app.SpringBootWebNaturix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    Long id;

    MultipartFile img;

    String name;

    String type;

    Double price;
}
