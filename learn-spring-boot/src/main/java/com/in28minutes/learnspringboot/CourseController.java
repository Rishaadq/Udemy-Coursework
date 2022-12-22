package com.in28minutes.learnspringboot;

import com.in28minutes.learnspringboot.courses.bean.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController {
    // http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"),
                new Course(2, "Learn Full Stack with Angular and React", "in28minutes"));
    }


    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        List<Course> courseList = Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"),
                new Course(2, "Learn Full Stack with Angular and React", "in28minutes"));
        return courseList.get(id-1);
    }



}
