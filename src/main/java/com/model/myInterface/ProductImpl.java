package com.model.myInterface;

import com.model.myClass.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ICrud<Product>, ISearch<Product> {
    List<Product> listProduct;
    CategoryImpl category;

    public ProductImpl(CategoryImpl category) {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "SP1", 150000, category.listCategory.get(1), 100));
        listProduct.add(new Product(2, "SP2", 250000, category.listCategory.get(2), 300));
        listProduct.add(new Product(3, "SP3", 155000, category.listCategory.get(3), 200));
        listProduct.add(new Product(4, "SP4", 199000, category.listCategory.get(4), 400));
        listProduct.add(new Product(5, "SP5", 155000, category.listCategory.get(3), 200));
        listProduct.add(new Product(6, "SP6", 199000, category.listCategory.get(2), 300));
        listProduct.add(new Product(7, "SP7", 2990000, category.listCategory.get(3), 200));
        listProduct.add(new Product(8, "SP4", 450000, category.listCategory.get(4), 400));
        listProduct.add(new Product(9, "SP9", 699000, category.listCategory.get(3), 200));
        listProduct.add(new Product(10, "SP4", 750000, category.listCategory.get(4), 400));
        this.category = category;
    }

    public CategoryImpl getCategory() {
        return category;
    }

    public void setCategory(CategoryImpl category) {
        this.category = category;
    }

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void save(Product product) {
        listProduct.add(product);
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product p :
                listProduct) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }

    @Override
    public void update(int index,Product product) {
        listProduct.set(index,product);
    }

    @Override
    public void delete(Product product) {
        listProduct.remove(product);
    }
}
