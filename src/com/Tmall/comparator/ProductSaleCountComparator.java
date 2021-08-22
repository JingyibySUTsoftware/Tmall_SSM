package com.Tmall.comparator;

import com.Tmall.bean.Product;

import java.util.Comparator;

/**
 * @author jingyi
 * @Classname ProductSaleCountComparator
 * @description TODO
 * @date 2021/8/22 14:12
 */
public class ProductSaleCountComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()-o1.getSaleCount();
    }
}
