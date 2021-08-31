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
    public Integer getCount(Integer pid) {
        Integer count = reviewMapper.getCount(pid);
        if (count==null){
            return  0;
        }else{
            return reviewMapper.getCount(pid);
        }
        //return reviewMapper.getCount(pid);
    }
}
