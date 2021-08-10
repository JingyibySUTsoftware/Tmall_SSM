package com.Tmall.mapper;

import com.Tmall.bean.Category;
import com.Tmall.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
	//@Select("select * from category order by id desc limit #{start},#{count}")
	public List<Category> list(Page page);
	//@Select("select count(*) from category")
	public int total();
	//@Insert("insert into category (name)  values (#{name})")
	//@Options(useGeneratedKeys = true, keyProperty = "id")
	public void add(Category c);
	//@Delete("delete from category where id=#{id}")
	public void delete(int id);
	//@Select("select * from category where id=#{id}")
	public Category get(int id);
	//@Update("update category set name=#{name} where id=#{id}")
	public void update(Category c);

	public List<Category> getAllCategory();
}
