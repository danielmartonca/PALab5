package optional.items;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import optional.exceptions.FailedToCreateFileException;
import optional.exceptions.InvalidPathFormat;
import optional.exceptions.InvalidResolution;

import java.io.IOException;
import java.util.regex.Pattern;

@EqualsAndHashCode(callSuper = true)
public
class Image extends Item {
    @Getter
    private final String resolution;
    @Getter
    private final String imageName;

    public Image(String itemName, String path, String resolution, String imageName) throws IOException, FailedToCreateFileException, InvalidResolution, InvalidPathFormat {
        super(itemName, path);
        if (!Pattern.matches("[1-9][0-9]*x[1-9][0-9]*", resolution))
            throw new InvalidResolution("Resolution " + resolution + " is invalid. [NxM]");
        this.resolution = resolution;
        this.imageName = imageName;
    }
}
