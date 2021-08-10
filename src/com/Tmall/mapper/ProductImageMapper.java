package com.Tmall.mapper;

import java.util.List;

import com.Tmall.bean.ProductImage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageMapper {
	//@Select("select * from productimage where pid=#{pid} and type=#{type}")
	public List<ProductImage> list(@Param("pid")int pid, @Param("type")String type);
	//@Insert("insert into productimage(pid,type) values(#{pid},#{type})")
	public void add(ProductImage pi);
	//@Select("select * from productimage where id=#{id}")
	public ProductImage get(int id);
	//@Delete("delete from productimage where id=#{id}")
	public void delete(int id);
}
