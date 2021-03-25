package optional.items;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import optional.exceptions.FailedToCreateFileException;
import optional.exceptions.InvalidPathFormat;

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

    public Book(String itemName, String path, String bookName, List<String> authors) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        super(itemName, path);
        this.authors = new ArrayList<>(authors);
        this.bookName = bookName;
    }
}
