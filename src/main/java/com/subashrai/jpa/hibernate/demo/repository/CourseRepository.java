package com.subashrai.jpa.hibernate.demo.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.subashrai.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    /**
     * Find a course by its ID.
     *
     * @param id the ID of the course
     * @return the course entity
     */
    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    /**
     * Delete a course by its ID.
     *
     * @param id the ID of the course to be deleted
     */
    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    /**
     * Save a course (insert if new, update if existing).
     *
     * @param course the course entity to be saved
     * @return the saved course entity
     */
    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    /**
     * Demonstrate the use of EntityManager with flush and detach.
     */
    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);
        Course course2 = new Course("Angular JS in 100 Steps");
        em.persist(course2);

        em.flush();
        em.detach(course2);

        course1.setName("Web Services in 100 Steps - Updated");
    }

    /**
     * Refresh the state of the entity from the database.
     *
     * @param course the course entity to be refreshed
     */
    public void refreshEntity(Course course) {
        em.refresh(course);
    }
}