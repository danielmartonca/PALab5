package optional;

import optional.commands.*;
import optional.shell.Shell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainOptional {
    private static final Logger logger = LogManager.getLogger(MainOptional.class);

    public static void main(String[] args) {
        try {
            ReportCommand.configureFreeMarker();

            Shell.addCommand(new AddCommand());
            Shell.addCommand(new ListCommands());
            Shell.addCommand(new PlayCommand());
            Shell.addCommand(new SaveCommand());
            Shell.addCommand(new LoadCommand());
            Shell.addCommand(new ReportCommand());
            Shell.runShell();

        } catch (Exception exception) {
            logger.error(exception);
        }
    }
    //"E:\Info\FACULTATE\ANUL_2\SEM 2\PA\LABORATOARE\PALab5\out\artifacts\PALab5_jar\PALab5.jar"

}
