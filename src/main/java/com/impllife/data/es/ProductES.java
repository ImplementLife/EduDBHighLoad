package com.impllife.data.es;

import com.impllife.data.entity.elasticsearch.ProductIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductES extends ElasticsearchRepository<ProductIndex, String> {
    List<ProductIndex> findByDescriptionContaining(String name);
}
