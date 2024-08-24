package com.subashrai.jpa.hibernate.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.subashrai.jpa.hibernate.demo.entity.Course;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest {

    @Autowired
    private EntityManager em;

    //make a jpql_basic test method
    @Test
    @Transactional
    public void jpql_basic() {
        //create a query
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        assertEquals(6, resultList.size());
    }

    //make a jpql_typed test method
    @Test
    @Transactional
    public void jpql_typed() {
        //create a query
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        assertEquals(4, resultList.size());
    }

    //make a jpql_where test method
    @Test
    @Transactional
    public void jpql_where() {
        //create a query
        TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);
        List<Course> resultList = query.getResultList();
        assertEquals(1, resultList.size());
    }



}