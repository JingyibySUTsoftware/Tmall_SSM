package com.Tmall.service;

import com.Tmall.bean.User;
import com.Tmall.util.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface UserService {
    /**
     *
     * @Title: total
     * @Description: 获取用户表的总记录数
     * @param @param cid
     * @param @return 参数
     * @return int 返回类型
     * @throws
     */
    int total();
    /**
     *
     * @Title: list
     * @Description: 获取用户信息列表
     * @param @param page
     * @param @return 参数
     * @return List<User> 返回类型
     * @throws
     */
    List<User> list(Page page);
    /**
     *
     * @Title: getUserByid
     * @Description: 根据用户id获取用户基本信息
     * @param @param id
     * @param @return 参数
     * @return User 返回类型
     * @throws
     */
    User getUserByid(Integer id);
    /**
     *
     * @Title: updateUserPwd
     * @Description: 管理员修改用户密码
     * @param @param user 参数
     * @return void 返回类型
     * @throws
     */
    void updateUserPwd(User user);
    /**
     *
     * @Title: deleteUserByid
     * @Description: 删除用户信息
     * @param @param id 参数
     * @return void 返回类型
     * @throws
     */
    void deleteUserByid(Integer id);
}
