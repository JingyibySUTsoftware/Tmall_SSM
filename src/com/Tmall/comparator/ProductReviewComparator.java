package com.Tmall.comparator;

import com.Tmall.bean.Product;

import java.util.Comparator;

/**
 * @author jingyi
 * @Classname ProductReviewComparator
 * @description TODO
 * @date 2021/8/22 13:41
 */
public class ProductReviewComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount()-o1.getReviewCount();
    }
}
