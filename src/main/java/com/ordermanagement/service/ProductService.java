package com.ordermanagement.service;

import com.ordermanagement.dto.ProductRequest;
import com.ordermanagement.models.Category;
import com.ordermanagement.models.ColorAnSize;
import com.ordermanagement.models.Products;
import com.ordermanagement.models.Suppliers;
import com.ordermanagement.repository.CategoryRepo;
import com.ordermanagement.repository.ProductRepo;
import com.ordermanagement.repository.SuppliersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SuppliersRepo suppliersRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public Products saveProduct(ProductRequest products){

        Suppliers suppliers = suppliersRepo.findById(products.getSupplierId()).get();
        Category category = categoryRepo.findById(products.getCategoryId()).get();
        Products products1 = new Products();
        BeanUtils.copyProperties(products,products1);

        ColorAnSize colorAnSize = new ColorAnSize();
        String colors = String.join(",",products.getColorAnSizes().getColors()) ;
        String size = String.join(",",products.getColorAnSizes().getSize()) ;
        colorAnSize.setColors(colors);
        colorAnSize.setSize(size);
        colorAnSize.setProducts(products1);

        products1.setColorAnSize(colorAnSize);
        category.getProducts().add(products1);
        suppliers.getProducts().add(products1);

        products1.setSuppliers(suppliers);
        products1.setCategory(category);
        //products1.setUpdatedAt(new Date());
        //products1.setCreatedAt(new Date());
        Products p=productRepo.save(products1);

        //categoryRepo.save(category);
        //suppliersRepo.save(suppliers);
        return p;

    }

    public Products getProductById(Long id){
        return productRepo.findById(id).get();
    }
}
