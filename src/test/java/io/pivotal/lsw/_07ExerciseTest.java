package io.pivotal.lsw;

import io.pivotal.lsw._07Exercise.Album;
import io.pivotal.lsw._07Exercise.Track;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class _07ExerciseTest {

    @Test
    public void shouldReturnFavouriteAlbums() throws Exception {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Thriller", asList(new Track(1), new Track(3), new Track(7))));
        albums.add(new Album("Back in Black", asList(new Track(3), new Track(3), new Track(5), new Track(4))));
        albums.add(new Album("The Dark Side of the Moon", asList(new Track(3), new Track(3), new Track(3), new Track(1))));
        albums.add(new Album("Saturday Night Fever", asList(new Track(1), new Track(1), new Track(2), new Track(0))));
        albums.add(new Album("Hotel California", asList(new Track(1), new Track(1), new Track(2), new Track(3))));
        albums.add(new Album("Dirty Dancing", asList(new Track(2), new Track(2), new Track(6),new Track(1))));

        List<Album> favourites1 = _07Exercise.favourites(albums);
        assertThat(favourites1).extracting("name").containsExactly("Back in Black", "Dirty Dancing", "Thriller");

        List<Album> favourites2 = _07Exercise.favouritesUsingStreams(albums);
        assertThat(favourites2).extracting("name").containsExactly("Back in Black", "Dirty Dancing", "Thriller");
    }
}