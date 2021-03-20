package compulsory.items;

import compulsory.exceptions.FailedToCreateFileException;
import compulsory.exceptions.InvalidPathFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public
class Book extends Item {
    @Getter
    private final List<String> authors;
    @Getter
    private final String bookName;

    public Book(String name, String path, String bookName, String... authors) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        super(name, path);
        this.authors = new ArrayList<>(Arrays.asList(authors));
        this.bookName = bookName;
    }
}
