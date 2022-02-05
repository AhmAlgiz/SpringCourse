package ru.JavaSpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;
    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer= musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer: " + id + ", " + musicPlayer.playMusic();
    }
    @PostConstruct
    public void doConstruct() {
        System.out.println("Construction");
    }
    @PreDestroy
    public void doDestroy() {
        System.out.println("Destruction");
    }
}
