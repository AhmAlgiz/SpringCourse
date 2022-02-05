package ru.JavaSpringCourse;

import org.springframework.stereotype.Component;

@Component
public class PopMusic implements Music {
    @Override
    public String getSong() {
        return "Pop";
    }
}
