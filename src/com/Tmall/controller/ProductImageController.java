package com.Tmall.controller;

import com.Tmall.bean.Category;
import com.Tmall.bean.Product;
import com.Tmall.bean.ProductImage;
import com.Tmall.service.CategoryService;
import com.Tmall.service.ProductImageService;
import com.Tmall.service.ProductService;
import com.Tmall.util.ImageUtil;
import com.Tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author jingyi
 * @Classname ProductImageController
 * @description TODO
 * @date 2021/8/3 10:30
 */
@Controller
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("admin_productImage_list")
    public String listProductImage(Integer pid, Model model){
        Product product = productService.get(pid);
        Category category = categoryService.get(product.getCid());
        product.setCategory(category);
        List<ProductImage> pisSingle= productImageService.list(pid, ProductImageService.TYPE_SINGLE);
        List<ProductImage> pisDetail= productImageService.list(pid, ProductImageService.TYPE_DETAIL);
        model.addAttribute("pisSingle", pisSingle);
        model.addAttribute("pisDetail", pisDetail);
        model.addAttribute("p", product);
        return "admin/listProductImage";
    }
    @RequestMapping("admin_productImage_add")
    public String add(ProductImage pi, HttpSession session, UploadedImageFile uploadedImageFile)throws IOException {
        productImageService.add(pi);
        ImageAddProcess(pi, session, uploadedImageFile);
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(Integer id,HttpSession session) {
        ProductImage pi = productImageService.get(id);
        ImageDeleteProcess(pi, session);
        productImageService.delete(id);
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }

    public void ImageAddProcess(ProductImage productImage,HttpSession session,UploadedImageFile uploadedImageFile) throws IOException{
        String fileName = productImage.getId() + ".jpg";
        String imageFolder;
        String imageFolder_small = null;
        String imageFolder_middle = null;

        //如果上传的是产品单个图片的缩略图，将图片转换成两种不同规格大小的图片
        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())){
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small = session.getServletContext().getRealPath("img/productSingle/small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle/middle");
        }else {
            //如果上传的是产品详情图片缩略图
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
        }

        //创建文件夹
        File file = new File(imageFolder,fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        uploadedImageFile.getImage().transferTo(file);
        BufferedImage image = ImageUtil.change2jpg(file);
        ImageIO.write(image,"jpg",file);

        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())){
            File file_small = new File(imageFolder_small,fileName);
            File file_middle = new File(imageFolder_middle,fileName);

            ImageUtil.resizeImage(file,56,56,file_small);
            ImageUtil.resizeImage(file,217,190,file_middle);
        }
    }

    public void ImageDeleteProcess(ProductImage productImage, HttpSession session){
        String fileName = productImage.getId() + ".jpg";
        String imageFolder;
        String imageFolder_small = null;
        String imageFolder_middle = null;

        if (ProductImageService.TYPE_SINGLE.equals(productImage.getType())){
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small = session.getServletContext().getRealPath("img/productSingle/small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle/middle");

            File imageFile = new File(imageFolder,fileName);
            File file_small = new File(imageFolder_small,fileName);
            File file_middle = new File(imageFolder_middle,fileName);

            imageFile.delete();
            file_small.delete();
            file_middle.delete();
        }else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder,fileName);
            imageFile.delete();
        }
    }
}
