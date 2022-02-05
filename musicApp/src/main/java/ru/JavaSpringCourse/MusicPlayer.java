package ru.JavaSpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MusicPlayer {
    private Music music;
    @Value("${musicPlayer.playerName}")
    private String playerName;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Autowired
    public MusicPlayer(@Qualifier("popMusic") Music music) {
        this.music = music;
    }

    public MusicPlayer() {}

    public void setMusic (Music music) {
        this.music = music;
    }

    public String playMusic () {
        return "Playing: " + music.getSong();
    }
}
