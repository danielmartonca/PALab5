package optional.commands;


import optional.exceptions.*;
import optional.items.*;
import optional.shell.Shell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCommand extends GenericCommand {
    public AddCommand() {
        super("add");
    }

    private Book createBook(String... arguments) throws InvalidPathFormat, FailedToCreateFileException, IOException {
        if (arguments.length < 3)
            return null;
        var bookName = arguments[2];
        var path = Item.DEFAULT_PATH + bookName + ".DOCX";

        List<String> authors = new ArrayList<>(Arrays.asList(arguments).subList(3, arguments.length));
        return new Book(bookName, path, bookName, authors);
    }

    private Image createImage(String... arguments) throws InvalidPathFormat, FailedToCreateFileException, IOException, InvalidResolution {
        if (arguments.length != 4)
            return null;
        var imageName = arguments[2];
        var path = Item.DEFAULT_PATH + imageName + ".jpg";
        var resolution = arguments[3];
        return new Image(imageName, path, resolution, imageName);
    }

    private Movie createMovie(String... arguments) throws InvalidPathFormat, FailedToCreateFileException, IOException {
        if (arguments.length < 5)
            return null;
        var movieName = arguments[2];
        var path = Item.DEFAULT_PATH + movieName + ".mkv";
        var duration = arguments[3];
        List<String> authors = new ArrayList<>(Arrays.asList(arguments).subList(4, arguments.length));
        return new Movie(movieName, path, duration, authors);
    }

    private Song createSong(String... arguments) throws InvalidPathFormat, FailedToCreateFileException, IOException {
        if (arguments.length < 4)
            return null;
        var songName = arguments[2];
        var path = Item.DEFAULT_PATH + songName + ".mp3";
        List<String> authors = new ArrayList<>(Arrays.asList(arguments).subList(2, arguments.length));
        return new Song(songName, path, songName, authors);
    }

    @Override
    public void run(String... arguments) throws FailedItemCreationException, InvalidPathFormat, FailedToCreateFileException, IOException, InvalidResolution, InvalidRunParametersException {

        if (arguments.length < 4)
            throw new InvalidRunParametersException("Invalid parameters in add: " + Arrays.toString(arguments));


        Item item = null;

        if (arguments[1].equalsIgnoreCase("book"))
            item = createBook(arguments);
        if (arguments[1].equalsIgnoreCase("image"))
            item = createImage(arguments);
        if (arguments[1].equalsIgnoreCase("movie"))
            item = createMovie(arguments);
        if (arguments[1].equalsIgnoreCase("song"))
            item = createSong(arguments);

        if (item == null)
            throw new FailedItemCreationException("Failed to create item: " + Arrays.toString(arguments));

        Shell.getCatalog().add(item);
    }
}
