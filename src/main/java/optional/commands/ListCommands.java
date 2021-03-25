package optional.commands;

import optional.exceptions.InvalidRunParametersException;
import optional.shell.Shell;

import java.util.Arrays;

public class ListCommands extends GenericCommand {

    public ListCommands() {
        super("list");
    }

    @Override
    public void run(String... arguments) throws InvalidRunParametersException {
        if (arguments.length != 1)
            throw new InvalidRunParametersException("Invalid parameters in list: " + Arrays.toString(arguments));
        System.out.println(Shell.getCatalog());
    }
}