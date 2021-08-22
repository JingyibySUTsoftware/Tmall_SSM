package com.Tmall.comparator;

import com.Tmall.bean.Product;

import java.util.Comparator;

/**
 * @author jingyi
 * @Classname ProductPriceComparator
 * @description TODO
 * @date 2021/8/22 14:14
 */
public class ProductPriceComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
         float result=o2.getPromotePrice()-o1.getPromotePrice();
         if(result>0){
             return (int)(result+1);
        }else if(result==0){
             return 0;
        }else{
             return (int)(result -1);
        }

    }
}
