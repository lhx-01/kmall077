package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrInfoExample;
import com.kgc.kmall.bean.PmsBaseAttrValue;
import com.kgc.kmall.bean.PmsBaseAttrValueExample;
import com.kgc.kmall.manager.mapper.PmsBaseAttrInfoMapper;
import com.kgc.kmall.manager.mapper.PmsBaseAttrValueMapper;
import com.kgc.kmall.service.AttrService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author LHX
 * @Date 2020/12/16 16:57
 */
@Component
@Service
public class AttrServiceImpl implements AttrService {
    @Resource
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Resource
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Override
    public List<PmsBaseAttrInfo> select(Long catalog3Id) {
        PmsBaseAttrInfoExample example=new PmsBaseAttrInfoExample();
        example.createCriteria().andCatalog3IdEqualTo(catalog3Id);
        return pmsBaseAttrInfoMapper.selectByExample(example);
    }

    @Override
    public Integer add(PmsBaseAttrInfo attrInfo) {
        int i=0;
        if (attrInfo.getId()==null){
            i=pmsBaseAttrInfoMapper.insert(attrInfo);
        }else {
            i=pmsBaseAttrInfoMapper.updateByPrimaryKey(attrInfo);
        }
        PmsBaseAttrValueExample example=new PmsBaseAttrValueExample();
        PmsBaseAttrValueExample.Criteria criteria=example.createCriteria();
        criteria.andAttrIdEqualTo(attrInfo.getId());
        i=pmsBaseAttrValueMapper.deleteByExample(example);
        if (attrInfo.getAttrValueList().size()>0){
            i=pmsBaseAttrValueMapper.insertBatch(attrInfo.getId(),attrInfo.getAttrValueList());
        }
        return i;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        PmsBaseAttrValueExample example=new PmsBaseAttrValueExample();
        example.createCriteria().andAttrIdEqualTo(attrId);
        return pmsBaseAttrValueMapper.selectByExample(example);
    }
}
