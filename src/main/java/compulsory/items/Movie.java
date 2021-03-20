package compulsory.items;


import compulsory.exceptions.FailedToCreateFileException;
import compulsory.exceptions.InvalidPathFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
public
class Movie extends Item {
    @Getter
    private final List<String> movieDirectors;
    @Getter
    private final Duration movieLength;

    public Movie(String name, String path, Duration movieLength, String... movieDirectors) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        super(name, path);
        this.movieDirectors = new LinkedList<>(Arrays.asList(movieDirectors));
        this.movieLength = movieLength;
    }
}
