package com.Tmall.service.Impl;

import com.Tmall.bean.Review;
import com.Tmall.mapper.ReviewMapper;
import com.Tmall.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingyi
 * @Classname ReviewServiceImpl
 * @description TODO
 * @date 2021/8/15 15:16
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    @Override
    public List<Review> getReviews(Integer pid) {
        return  reviewMapper.getReviews(pid);
    }

    @Override
    public int getCount(Integer pid) {
        return reviewMapper.getCount(pid);
    }
}
