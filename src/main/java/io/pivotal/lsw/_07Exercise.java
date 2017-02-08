package io.pivotal.lsw;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class _07Exercise {

    @Data
    @AllArgsConstructor
    static class Album {
        String name;
        List<Track> tracks;
    }

    @Data
    @AllArgsConstructor
    static class Track {
        int rating;
    }

    static List<Album> favourites(List<Album> albums) {
        List<Album> favs = new ArrayList<>();
        for (Album a : albums) {
            boolean hasFavorite = false;
            for (Track t : a.tracks) {
                if (t.rating >= 4) {
                    hasFavorite = true;
                    break;
                }
            }
            if (hasFavorite)
                favs.add(a);
        }
        Collections.sort(favs, new Comparator<Album>() {
            public int compare(Album a1, Album a2) {
                return a1.name.compareTo(a2.name);
            }
        });
        return favs;
    }

    //filter, sorted, and collect
    static List<Album> favouritesUsingStreams(List<Album> albums) {
        return albums
                .stream()
                .filter(album -> album.tracks.stream().anyMatch(t -> t.rating >= 4))
                .sorted((a1, a2) -> a1.name.compareTo(a2.name))
                .collect(Collectors.toList());
    }
}
