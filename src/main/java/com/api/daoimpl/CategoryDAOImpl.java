package com.api.daoimpl;

import com.api.dao.CategoryDAO;
import com.api.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static List<Category> categories=new ArrayList<>();

    static {
        Category category= new Category();
        category.setId(1);
        category.setDescription("This is first category");
        category.setImageUrl("https://www.w3schools.com/w3css/img_fjords.jpg");
        category.setName("First Product");
        categories.add(category);

        /*-----second category------------*/
        category= new Category();
        category.setId(2);
        category.setDescription("This is second category");
        category.setImageUrl("https://www.w3schools.com/w3css/img_fjords.jpg");
        category.setName("second Product");
        categories.add(category);

    }

    @Override
    public List<Category> list() {
        return categories;
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(Category category) {
        return false;
    }

    @Override
    @Transactional
    public boolean add(Category category){
        try{
            sessionFactory.getCurrentSession().persist(category);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
