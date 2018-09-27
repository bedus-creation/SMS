package com.api.test;

import com.api.dao.CategoryDAO;
import com.api.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestCase {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init(){
        context=new AnnotationConfigApplicationContext();
        context.scan("com.api");
        context.refresh();
        categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
    }

    @Test
    public void testAddCategory(){
        category=new Category();
        category.setDescription("This is television");
        category.setImageUrl("https://www.w3schools.com/w3css/img_fjords.jpg");
        category.setName("ojt");

        assertEquals("successfull",true,categoryDAO.add(category));
    }

}