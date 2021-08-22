package com.Tmall.comparator;

import com.Tmall.bean.Product;

import java.util.Comparator;

/**
 * @author jingyi
 * @Classname ProductAllComparator
 * @description TODO
 * @date 2021/8/22 13:38
 */
public class ProductAllComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount()*o2.getSaleCount()-o1.getReviewCount()*o1.getSaleCount();
    }
}
