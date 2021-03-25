package optional.items;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import optional.exceptions.FailedToCreateFileException;
import optional.exceptions.InvalidPathFormat;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public
class Song extends Item {
    @Getter
    private final List<String> authors;
    @Getter
    private final String songName;

    public Song(String itemName, String path, String songName, List<String> authors) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        super(itemName, path);
        this.authors = new LinkedList<>(authors);
        this.songName = songName;
    }
}
