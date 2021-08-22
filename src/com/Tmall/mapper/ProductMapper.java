package com.Tmall.mapper;

import com.Tmall.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
	//@Select("select * from product where cid=#{cid} order by id desc limit #{start},#{count}")
	public List<Product> list(@Param("start")int start , @Param("count")int count, @Param("cid")int cid);
	//@Insert("insert into product(name,subTitle,originalPrice,promotePrice,stock,cid,createDate) "
			//+ "values(#{name},#{subTitle},#{originalPrice},#{promotePrice},#{stock},#{cid},#{createDate})")
	public void add(Product p);
	//@Select("select * from product where id=#{id}")
	public Product get(int id);
	//@Update("update product set name=#{name},subTitle=#{subTitle},originalPrice=#{originalPrice},"
			//+ "promotePrice=#{promotePrice},stock=#{stock} where id=#{id}")
	public void update(Product p);
	//@Delete("delete from product where id=#{id}")
	public void delete(int id);
	
	public int total(Integer cid);

	List<Product> listBycid(Integer cid);

	List<Product> searchBykeyword(String keyword);

}
