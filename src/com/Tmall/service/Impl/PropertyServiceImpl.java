package com.Tmall.service.Impl;

import com.Tmall.bean.Property;
import com.Tmall.mapper.PropertyMapper;
import com.Tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname PropertyServiceImpl
 * @description TODO
 * @date 2021/8/3 10:22
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyMapper propertyMapper;
    @Override
    public List<Property> list(int start , int count, int cid) {
        return propertyMapper.list(start,count,cid);
    }

    @Override
    public void add(Property p) {
        propertyMapper.add(p);
    }


    @Override
    public Property get(int id) {
        return propertyMapper.get(id);
    }


    @Override
    public void update(Property p) {
        propertyMapper.update(p);
    }

    @Override
    public void delete(int id) {
        propertyMapper.delete(id);
    }

    @Override
    public int total(int cid) {
        return propertyMapper.total(cid);
    }

    @Override
    public List<Property> listBycid(Integer cid) {
        return propertyMapper.listBycid(cid);
    }

}
