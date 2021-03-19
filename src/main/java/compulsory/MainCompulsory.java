package compulsory;

import compulsory.catalogue.Catalog;
import compulsory.items.Movie;
import compulsory.items.Song;

import java.io.IOException;
import java.time.Duration;

public class MainCompulsory {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("Catalogue1", System.getProperty("user.dir"));

        //catalog.add(new Song("DorianPopa_HatzJhonule", System.getProperty("user.dir").toString() + "DorianPopa_HatzJhonule.mp3", "\"DorianPopa_HatzJhonule", "Dorian Popa"));
        //catalog.add(new Movie("AlPacino", System.getProperty("user.dir").toString() + "AlPacino.mkv", Duration.ofHours(2), "De Niro"));
        //catalog.list();
        //catalog.save();

        catalog.load("Catalogue1.ser");

    }

}
