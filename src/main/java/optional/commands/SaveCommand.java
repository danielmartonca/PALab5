package optional.commands;

import optional.catalogue.CatalogUtilities;
import optional.exceptions.InvalidRunParametersException;
import optional.shell.Shell;

import java.io.IOException;
import java.util.Arrays;

public class SaveCommand extends GenericCommand {

    public SaveCommand() {
        super("save");
    }

    @Override
    public void run(String... arguments) throws IOException, InvalidRunParametersException {
        if (arguments.length != 1)
            throw new InvalidRunParametersException("Invalid parameters in save: " + Arrays.toString(arguments));

        CatalogUtilities.save(Shell.getCatalog());
    }
}
