package com.jb.fp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jeanbaptiste.watenberg@gmail.com
 */
public class JavaFp {

    public List<Movie> findByTitle(String title, List<Movie> movies) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie: movies) {
            if (movie.getTitle().contains(title)) result.add(movie);
        }
        return result;
    }

    public List<Movie> findByTitleStream(String title, List<Movie> movies) {
        return movies.stream().filter(movie -> movie.getTitle().contains(title)).collect(Collectors.toList());
    }
}
