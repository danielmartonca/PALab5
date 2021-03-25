package optional.items;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import optional.exceptions.FailedToCreateFileException;
import optional.exceptions.InvalidPathFormat;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * The Item class is responsible for storing items.
 */
public @NoArgsConstructor
abstract class Item implements Serializable {
    public static final String DEFAULT_PATH = System.getProperty("user.dir") + "\\items\\";
    @Getter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String path;
    @Getter
    private long itemSize;
    @Getter
    private File file;

    public Item(String itemName, String path) throws IOException, FailedToCreateFileException, InvalidPathFormat {
        this.id = UUID.randomUUID().toString();
        this.name = itemName;

        if (!Pattern.matches("[A-Z]:\\\\([\\w|_|\\d|\\s]*\\\\)*[\\w|_|\\d]*.[\\w]*", path))
            throw new InvalidPathFormat("Path " + path + " is invalid. It contains invalid characters.");

        this.path = path;
        this.file = new File(this.path);
        if (!file.exists()) {
            if (file.createNewFile())
                System.out.println("File " + this.name + " created successfully at path " + this.path);
            else
                throw new FailedToCreateFileException("Failed to create file " + this.name + " at path " + this.path);
        }
        this.itemSize = Files.size(Path.of(this.path));
    }

    @Override
    public String toString() {
        return "Item{" + "\n" +
                "           id='" + id + '\'' + "\n" +
                "           name='" + name + '\'' + "\n" +
                "           path='" + path + '\'' + "\n" +
                "           itemSize=" + itemSize + "\n" +
                '}';
    }
}
