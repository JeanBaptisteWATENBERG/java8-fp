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
            addIfMatches(title, movie, result);
        }
        return result;
    }

    private void addIfMatches(String title, Movie movie, List<Movie> result) {
        if (matches(title, movie)) result.add(movie);
    }

    private boolean matches(String title, Movie movie) {
        return isInfixOf(movie.getTitle(), title);
    }

    private boolean isInfixOf(String whole, String title) {
        return whole.contains(title);
    }

    public List<Movie> findByTitleBasic(String title, List<Movie> movies) {
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
