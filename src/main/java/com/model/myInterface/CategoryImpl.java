package com.model.myInterface;

import com.model.myClass.Category;
import com.model.myClass.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements ICrud<Category>,ISearch <Category>{
    List<Category> listCategory;

    public CategoryImpl() {
        listCategory = new ArrayList<>();
        listCategory.add(new Category(1, "Nike"));
        listCategory.add(new Category(2, "Adidas"));
        listCategory.add(new Category(3, "Puma"));
        listCategory.add(new Category(4, "Converse"));
        listCategory.add(new Category(5, "Vans"));
        listCategory.add(new Category(6, "NewBalance"));
        listCategory.add(new Category(7, "Reebok"));
        listCategory.add(new Category(8, "UnderArmour"));
        listCategory.add(new Category(9, "Fila"));
        listCategory.add(new Category(10, "Skechers"));
    }

    @Override
    public List<Category> findAll() {
        return listCategory;
    }

    @Override
    public void save(Category category) {
            listCategory.add(category);
    }

    @Override
    public void update(int index, Category category) {
        listCategory.set(index,category);
    }

    @Override
    public void delete(Category category) {
        listCategory.remove(category);
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        for (Category c :
                listCategory) {
            if (c.getId() == id) {
                category = c;
                break;
            }
        }
        return category;
    }
}
