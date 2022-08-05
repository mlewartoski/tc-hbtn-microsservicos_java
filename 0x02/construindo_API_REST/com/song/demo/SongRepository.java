package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream().filter(p -> p.getId().equals(id)).findAny().get();
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        this.list = list.stream().map(song -> song.getId().equals(s.getId()) ? s : song).collect(Collectors.toList());
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}
