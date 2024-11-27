package cn.edu.wic.exam.courseadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CourseAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseAdminApplication.class, args);
    }

}
