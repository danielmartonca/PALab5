package compulsory.items;

import compulsory.exceptions.FailedToCreateFileException;
import compulsory.exceptions.InvalidPathFormat;
import compulsory.exceptions.InvalidResolution;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.regex.*;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
public
class Image extends Item {
    @Getter
    private final String resolution;
    @Getter
    private final String imageName;

    public Image(String name, String path, String resolution, String imageName) throws IOException, FailedToCreateFileException, InvalidResolution, InvalidPathFormat {
        super(name, path);
        if (!Pattern.matches("[1-9][0-9]*x[1-9][0-9]*", resolution))
            throw new InvalidResolution("Resolution " + resolution + " is invalid. [NxM]");
        this.resolution = resolution;
        this.imageName = imageName;
    }
}
