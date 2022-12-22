package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;


import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext // use instead of autowired i guess
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void findById(long id) {
        entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }


}
