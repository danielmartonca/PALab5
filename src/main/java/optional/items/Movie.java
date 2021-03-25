package optional.items;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import optional.exceptions.FailedToCreateFileException;
import optional.exceptions.InvalidPathFormat;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
public
class Movie extends Item {
    @Getter
    private final List<String> movieDirectors;
    @Getter
    private final String movieLength;

    public Movie(String itemName, String path, String movieLength, List<String> movieDirectors) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        super(itemName, path);
        this.movieDirectors = new LinkedList<>(movieDirectors);
        this.movieLength = movieLength;
    }
}
