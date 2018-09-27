package com.api.dao;


import com.api.dto.Category;

import java.util.List;

public interface CategoryDAO {

    Category get(int id);
    boolean update(Category category);
    boolean delete(Category category);
    boolean add(Category category);
    List<Category> list();

}