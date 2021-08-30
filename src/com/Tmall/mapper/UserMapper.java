package com.Tmall.mapper;

import com.Tmall.bean.User;
import com.Tmall.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	public int total();
	
	public List<User> list(Page page);
	
	public User getUserByid(Integer id);
	
	public void updateUserPwd(User user);
	
	public void deleteUserByid(Integer id);

	int userNameisExist(String name);

	void userAdd(User user);

	User getUserNameAndID(User user);
}
