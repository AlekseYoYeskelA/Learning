package patterns.behavioral.state.ui;

import patterns.behavioral.state.states.ReadyState;
import patterns.behavioral.state.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing = false;
    private List<String> playList = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i <= 12; i++) {
            playList.add("Track" + i);
        }
    }

    public State getState() {
        return state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String startPlayback() {
        return "Playing " + playList.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playList.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playList.size() - 1;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}
