package com.jb.fp;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author jeanbaptiste.watenberg@gmail.com
 */
public class JavaFp {

    private Function<String, Function<String, Boolean>> isInfixOf = title -> whole -> whole.contains(title);
    private Function<Function<Movie, Boolean>, Function<Collection<Movie>, Collection<Movie>>> filter = predicate -> collection -> collection.stream().filter(movie -> predicate.apply(movie)).collect(Collectors.toList());
    private Function<Movie, String> getTitle = Movie::getTitle;
    private Function<String, Function<Movie, Boolean>> matches = title -> movie -> isInfixOf.apply(title).apply(getTitle.apply(movie));
    public Function<String, Function<Collection<Movie>, Collection<Movie>>> findByTitle = query -> movies -> filter.apply(matches.apply(query)).apply(movies);

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
