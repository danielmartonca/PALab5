package compulsory;

import compulsory.catalogue.Catalog;
import compulsory.catalogue.CatalogUtilities;
import compulsory.exceptions.FailedToCreateFileException;
import compulsory.exceptions.InvalidResolution;
import compulsory.items.*;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainCompulsory {
    private static final Logger logger = LogManager.getLogger(MainCompulsory.class);

    public static void main(String[] args) {
        try {
            Catalog catalog1 = new Catalog("Catalog1", System.getProperty("user.dir"));

            //catalog1.add(new Image("TestImage", "E:\\Info\\POZA.jpg", "724x724", "Poza")); this line is commented due to the fact that the picture only exists on my computer

            catalog1.add(new Song("DorianPopa_HatzJhonule", Item.DEFAULT_PATH + "DorianPopa_HatzJhonule.mp3", "DorianPopa_HatzJhonule", "Dorian Popa"));
            catalog1.add(new Movie("AlPacino", Item.DEFAULT_PATH + "AlPacino.mkv", Duration.ofHours(2), "De Niro"));
            catalog1.add(new Book("Book1", Item.DEFAULT_PATH + "book1.DOCX", "Book1", "AndyPopescu"));
            catalog1.add(new Image("Img1", Item.DEFAULT_PATH + "sarpe.jpg", "150x250", "sarpe"));


            catalog1.list();
            CatalogUtilities.save(catalog1);

            Catalog catalog2 = new Catalog("Catalog2", System.getProperty("user.dir"));
            CatalogUtilities.load(catalog2, catalog1.getName());
            catalog2.list();

            CatalogUtilities.play(catalog1, 0);

        } catch (Exception exception) {
            logger.error(exception);
        } finally {
            logger.info("Program executed successfully.");
        }
    }

}
