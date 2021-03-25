package optional.commands;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import optional.catalogue.Catalog;
import optional.shell.Shell;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends GenericCommand {
    public ReportCommand(String commandName) {
        super("report");
    }

    public static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

    public ReportCommand() {
        super("report");
    }

    public static void configureFreeMarker() throws IOException {
        cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir") + "\\templates\\"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
    }

    private Map<String, Object> createDataModel(Catalog catalog) {
        Map<String, Object> root = new HashMap<>();
        root.put("catalogName", catalog.getName());
        root.put("catalogPath", catalog.getPath());
        root.put("itemsList", catalog.getItems());

        return root;
    }

    @Override
    public void run(String... arguments) throws IOException, TemplateException {
        var root = createDataModel(Shell.getCatalog());
        Template temp = ReportCommand.cfg.getTemplate("CatalogTemplate.ftlh");

        temp.process(root, new OutputStreamWriter(System.out));

    }


}
