package optional.commands;

import freemarker.template.TemplateException;
import lombok.Data;
import optional.exceptions.*;

import java.io.IOException;
import java.util.Objects;

@Data
public abstract class GenericCommand {
    String commandName;

    public abstract void run(String... arguments) throws FailedItemCreationException, InvalidPathFormat, FailedToCreateFileException, IOException, InvalidResolution, InvalidItemCreationArguments, InvalidRunParametersException, ClassNotFoundException, TemplateException;

    GenericCommand(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericCommand that = (GenericCommand) o;
        return Objects.equals(commandName, that.commandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandName);
    }
}
