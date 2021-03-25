package optional.shell;


import freemarker.template.TemplateException;
import lombok.Data;

import optional.catalogue.Catalog;
import optional.commands.GenericCommand;
import optional.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Shell {
    static final Logger logger = LogManager.getLogger(Shell.class);

    static Catalog catalog = new Catalog("shellCatalogue", System.getProperty("user.dir") + "/catalogues/" + "shellCatalogue.ser");
    static Map<String, GenericCommand> shellCommands = new LinkedHashMap<>(10);

    public static Catalog getCatalog() {
        return catalog;
    }

    public static void addCommand(GenericCommand command) {
        if (commandDoesntExistForShell(command.getCommandName()))
            shellCommands.put(command.getCommandName(), command);
    }

    private static boolean commandDoesntExistForShell(String command) {
        for (var shellCommand : shellCommands.keySet())
            if (shellCommand.equals(command)) {
                return false;
            }
        return true;
    }

    public static void runShell() throws IOException, FailedItemCreationException, InvalidPathFormat, FailedToCreateFileException, InvalidResolution, InvalidItemCreationArguments, InvalidRunParametersException, ClassNotFoundException, InvalidCommandException, TemplateException {

        logger.info("Starting shell execution.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine;
        do {
            System.out.print("> ");
            inputLine = reader.readLine();

            if (inputLine.equals("quit"))
                break;

            var inputCommand = inputLine.split(" ");
            if (commandDoesntExistForShell(inputCommand[0])) {
                throw new InvalidCommandException("Command " + Arrays.toString(inputCommand) + " is invalid");
            }

            shellCommands.get(inputCommand[0]).run(inputCommand);
        } while (true);

        logger.info("Ending shell execution.");
    }
}
