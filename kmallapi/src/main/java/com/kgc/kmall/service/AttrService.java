package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrValue;

import java.util.List;

/**
 * @Author LHX
 * @Date 2020/12/16 16:55
 */
public interface AttrService {
    List<PmsBaseAttrInfo> select(Long catalog3Id);

    public Integer add(PmsBaseAttrInfo attrInfo);

    public List<PmsBaseAttrValue> getAttrValueList(Long attrId);
}
