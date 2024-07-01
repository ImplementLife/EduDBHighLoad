package com.impllife.service.es;

import com.impllife.data.entity.Product;
import com.impllife.data.entity.elasticsearch.ProductIndex;
import com.impllife.data.es.ProductES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductES productES;

    public void saveIndex(Product product) {
        ProductIndex productIndex = new ProductIndex(product);
        productES.save(productIndex);
    }

    public void saveBulk(List<Product> products) {
        productES.saveAll(
            products.stream()
            .map(ProductIndex::new)
            .collect(Collectors.toList())
        );
    }

    public List<ProductIndex> findByNameContaining(String name) {
        return productES.findByDescriptionContaining(name);
    }
}
