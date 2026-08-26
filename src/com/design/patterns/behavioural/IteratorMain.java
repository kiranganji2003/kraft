package com.design.patterns.behavioural;

import java.util.List;

class Song {
    private String songName;

    public Song(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }
}

interface Iterator {

}

class Playlist {
    private List<Song> playlist;
}

public class IteratorMain {
}
