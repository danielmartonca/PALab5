package compulsory.items;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
public @Data
class Movie extends Item {
    private List<String> movieDirectors;
    private Duration movieLength;

    public Movie(String name, String path, Duration movieLength, String... movieDirectors) {
        super(name, path);
        this.movieDirectors = new LinkedList<>(Arrays.asList(movieDirectors));
        this.movieLength = movieLength;
    }

    @Override
    void isAbstract() {
    }
}
