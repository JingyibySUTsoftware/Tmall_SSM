package com.Tmall.service;

import com.Tmall.bean.Review;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ReviewService {
    /*
     * @description 获取产品对应的评论
     * @param
     * @param pid
     * @author jingyi
     * @date 2021/8/15 15:16
     * @return java.util.List<com.Tmall.bean.Review>
     */
    List<Review> getReviews(Integer pid);
    /**
     * @description 获取评论数
     * @param
     * @param pid
     * @author jingyi
     * @date 2021/8/15 17:15
     * @return int
     */
    Integer getCount(Integer pid);
}
