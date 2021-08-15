package com.Tmall.mapper;

import com.Tmall.bean.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> getReviews(Integer pid);

    int getCount(Integer pid);
}
