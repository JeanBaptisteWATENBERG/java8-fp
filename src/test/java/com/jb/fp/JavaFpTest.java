package com.jb.fp;

import org.junit.Test;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jeanbaptiste.watenberg@gmail.com
 */
public class JavaFpTest {

    private JavaFp javaFp = new JavaFp();

    private List<Movie> movies = Arrays.asList(
        new Movie("The Matrix", Year.of(1999)),
        new Movie("A beautiful mind", Year.of(2001)),
        new Movie("Intouchable", Year.of(2011)),
        new Movie("Forest Gump", Year.of(1994))
    );


    @Test
    public void should_return_empty_when_none_found() throws Exception {
        assertThat(javaFp.findByTitle.apply("Interstellar").apply(movies)).isEmpty();
    }

    @Test
    public void should_return_a_matching_movie() throws Exception {
        assertThat(javaFp.findByTitle.apply("The Matrix").apply(movies)).containsExactly(
            new Movie("The Matrix", Year.of(1999))
        );
    }

    @Test
    public void should_return_all_matching_movies() throws Exception {
        assertThat(javaFp.findByTitle.apply("o").apply(movies)).containsExactly(
            new Movie("Intouchable", Year.of(2011)),
            new Movie("Forest Gump", Year.of(1994))
        );
    }
}