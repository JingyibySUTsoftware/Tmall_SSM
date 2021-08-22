package com.Tmall.comparator;

import com.Tmall.bean.Product;

import java.util.Comparator;

/**
 * @author jingyi
 * @Classname ProductDateComparator
 * @description TODO
 * @date 2021/8/22 14:10
 */
public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getCreateDate().compareTo(o1.getCreateDate());
    }
}
