package com.Tmall.mapper;

import java.util.List;

import com.Tmall.bean.PropertyValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyValueMapper {
	public List<PropertyValue> getPvByPid(Integer pid);
	
	public int updateVByid(PropertyValue p);
	
	public PropertyValue getPv(@Param("pid")Integer pid,@Param("ptid")Integer ptid);
	
	public void addPv(PropertyValue pv);
}
