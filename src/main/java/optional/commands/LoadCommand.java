package optional.commands;

import optional.catalogue.CatalogUtilities;
import optional.exceptions.InvalidRunParametersException;
import optional.shell.Shell;

import java.io.IOException;
import java.util.Arrays;

public class LoadCommand extends GenericCommand {

    public LoadCommand() {
        super("load");
    }

    @Override
    public void run(String... arguments) throws IOException, ClassNotFoundException, InvalidRunParametersException {
        if (arguments.length != 2)
            throw new InvalidRunParametersException("Invalid parameters in load: " + Arrays.toString(arguments));

        CatalogUtilities.load(Shell.getCatalog(), arguments[1]);
    }
}
