package optional.commands;

import optional.catalogue.CatalogUtilities;
import optional.exceptions.InvalidRunParametersException;
import optional.shell.Shell;

import java.io.IOException;
import java.util.Arrays;

public class PlayCommand extends GenericCommand {
    public PlayCommand() {
        super("play");
    }

    @Override
    public void run(String... arguments) throws InvalidRunParametersException, IOException {
        if (arguments.length != 2)
            throw new InvalidRunParametersException("Invalid parameters in play: " + Arrays.toString(arguments));

        CatalogUtilities.play(Shell.getCatalog(), Integer.parseInt(arguments[1]) - 1);
    }
}
