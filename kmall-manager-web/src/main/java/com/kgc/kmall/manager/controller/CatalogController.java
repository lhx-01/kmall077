package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.bean.PmsBaseCatalog2;
import com.kgc.kmall.bean.PmsBaseCatalog3;
import com.kgc.kmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LHX
 * @Date 2020/12/16 15:34
 */
@CrossOrigin
@RestController
public class CatalogController {
    @Reference
    CatalogService catalogService;
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1s=catalogService.getCatalog1();
        return catalog1s;
    }
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id){
        List<PmsBaseCatalog2> catalog2s=catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id){
        List<PmsBaseCatalog3> catalog3s=catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }
}
