package com.impllife.config;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;

import java.io.IOException;

@Configuration
public class ElasticsearchConfig {

//    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchConfig.class);
//
//    @Bean
//    public RestClients.ElasticsearchRestClient elasticsearchRestClient() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//            .connectedTo("localhost:9200")
//            .withHttpClientConfigurer(httpClientBuilder -> {
//                httpClientBuilder.addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
//                    if (request instanceof HttpEntityEnclosingRequestBase) {
//                        HttpEntityEnclosingRequestBase entityRequest = (HttpEntityEnclosingRequestBase) request;
//                        HttpEntity entity = entityRequest.getEntity();
//                        if (entity != null) {
//                            try {
//                                String content = EntityUtils.toString(entity);
//                                logger.debug("Request: " + request.getRequestLine() + " Body: " + content);
//                            } catch (IOException e) {
//                                logger.error("Failed to parse request body", e);
//                            }
//                        }
//                    } else {
//                        logger.debug("Request: " + request.getRequestLine());
//                    }
//                });
//
//                httpClientBuilder.addInterceptorLast((HttpResponseInterceptor) (response, context) -> {
//                    HttpEntity entity = response.getEntity();
//                    if (entity != null) {
//                        try {
//                            String content = EntityUtils.toString(entity);
//                            logger.debug("Response: " + response.getStatusLine() + " Body: " + content);
//                        } catch (IOException e) {
//                            logger.error("Failed to parse response body", e);
//                        }
//                    } else {
//                        logger.debug("Response: " + response.getStatusLine());
//                    }
//                });
//            })
//            .build();
//
//        return RestClients.create(clientConfiguration);
//    }
}

