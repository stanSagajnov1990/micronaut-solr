package com.example.solr.data;

import com.example.solr.data.DetailData;
import org.apache.solr.client.solrj.beans.Field;

import java.util.List;


public class ProductDocument {
    @Field
    public String id;

    @Field
    public List<String> sku;

    @Field(value= "details", child = true)
    public List<DetailData> details;

    public ProductDocument() {

    }

    public ProductDocument(String id, List<String> sku, List<DetailData> detail) {
        this.id = id;
        this.sku = sku;
        this.details = detail;
    }
}
