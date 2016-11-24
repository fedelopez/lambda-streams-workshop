package io.pivotal.lsw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Exercise {

    static class Album {
        String name;
        List<Track> tracks;

        Album(String name, List<Track> tracks) {
            this.name = name;
            this.tracks = tracks;
        }

        public String toString() {
            return name;
        }
    }

    static class Track {
        int rating;

        Track(int rating) {
            this.rating = rating;
        }
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
                .filter(a -> a.tracks.stream().anyMatch(t -> t.rating >= 4))
                .sorted((a1, a2) -> a1.name.compareTo(a2.name))
                .collect(Collectors.toList());
    }
}
