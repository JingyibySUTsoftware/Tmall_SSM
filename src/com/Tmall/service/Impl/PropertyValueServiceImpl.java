package com.Tmall.service.Impl;

import com.Tmall.bean.Product;
import com.Tmall.bean.Property;
import com.Tmall.bean.PropertyValue;
import com.Tmall.mapper.PropertyMapper;
import com.Tmall.mapper.PropertyValueMapper;
import com.Tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname PropertyValueServiceImpl
 * @description TODO
 * @date 2021/8/3 10:23
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    private PropertyValueMapper propertyValueMapper;
    @Autowired
    private PropertyMapper propertyMapper;
    @Override
    public List<PropertyValue> getPvByPid(Integer pid) {
        return propertyValueMapper.getPvByPid(pid);
    }

    @Override
    public int updateVByid(PropertyValue p) {
        return propertyValueMapper.updateVByid(p);
    }
    //初始化产品的属性值
    @Override
    public void init(Product p) {
        List<Property> prlist = propertyMapper.listBycid(p.getCid());
        for (Property property : prlist) {
            PropertyValue pv = getPv(p.getId(), property.getId());
            if(pv==null) {
                PropertyValue propertyValue = new  PropertyValue();
                propertyValue.setPid(p.getId());
                propertyValue.setPtid(property.getId());
                propertyValueMapper.addPv(propertyValue);
            }
        }

    }

    @Override
    public PropertyValue getPv(Integer pid, Integer ptid) {
        return propertyValueMapper.getPv(pid, ptid);
    }

    @Override
    public void addPv(PropertyValue pv) {
        propertyValueMapper.addPv(pv);
    }
}
