package com.example.app.SpringBootWebNaturix.service;

import com.example.app.SpringBootWebNaturix.entity.Product;
import com.example.app.SpringBootWebNaturix.entity.ProductDTO;
import com.example.app.SpringBootWebNaturix.repository.ProductRepository;
import com.example.app.SpringBootWebNaturix.utils.Constants;
import com.example.app.SpringBootWebNaturix.utils.ImgCreator;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private static final Logger LOGGER =
            Logger.getLogger(ProductService.class.getName());

    @Autowired
    ProductRepository repository;

    public void add(ProductDTO productDTO) throws IOException {
        String fileUpload = ImgCreator.createFile(productDTO.getImg());
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());
        product.setImg(fileUpload);
        repository.save(product);

        LOGGER.info("Product added successfully! " + product);
    }

    public void update(ProductDTO productDTO) throws IOException {
        Product product = getById(productDTO.getId());
        product.setName(productDTO.getName());
        product.setType(productDTO.getType());
        product.setPrice(productDTO.getPrice());

        if (!productDTO.getImg().isEmpty()) {
            File oldImg = new File(Constants.URL_FILE_UPLOADS + product.getImg());
            if (oldImg.delete()) {
                String newImg = ImgCreator.createFile(productDTO.getImg());
                product.setImg(newImg);
            } else {
                LOGGER.warning("Can't delete img - " + productDTO.getImg());
                return;
            }
        }

        repository.save(product);
        LOGGER.info("Product updated successfully! " + product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        LOGGER.info("Product №" + id + " deleted successfully! ");
    }

    public List<Product> getAll() {
        Iterable<Product> iterable = repository.findAll();
        return changeImgUrl(StreamSupport.stream(iterable.spliterator(), false));
    }

    public Product getById(Long id) throws ObjectNotFoundException {
        Optional<Product> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            LOGGER.warning("Can't find product with id: " + id);
            throw new ObjectNotFoundException("Product not found", id);
        }
    }

    private List<Product> changeImgUrl(Stream<Product> stream) {
        return stream.peek(product -> product.setImg(Constants.BASE_URL +
                Constants.URL_IMAGES_UPLOADS + product.getImg())).toList();
    }
}
