package com.Tmall.mapper;

import com.Tmall.bean.Property;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyMapper {
	//@Select("select * from property where cid=#{cid} order by id desc limit #{start},#{count}")
	public List<Property> list(@Param("start")int start , @Param("count")int count, @Param("cid")int cid);
	//@Insert("insert into property (cid,name) values(#{cid},#{name})")
	public void add(Property p);
	//@Select("select * from property where id=#{id}")
	public Property get(int id);
	//@Update("update property set name=#{name} where id=#{id}")
	public void update(Property p);
	//@Delete("delete from property where id=#{id}")
	public void delete(int id);
	
	public int total(Integer cid);
	
	public List<Property> listBycid(Integer cid);


}
