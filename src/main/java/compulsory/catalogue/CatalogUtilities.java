package compulsory.catalogue;

import compulsory.items.Item;

import java.awt.*;
import java.io.*;

public class CatalogUtilities {
    //public static void save(C)

    public static Item findById(Catalog catalog, int id) {
        for (Item item : catalog.getItems()) {
            if (item.getId().equals(Integer.toString(id)))
                return item;
        }
        return null;
    }

    public static void save(Catalog catalog) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/catalogues/" + catalog.getName() + ".ser"));
        out.writeObject(catalog);
        out.close();
    }

    public static void load(Catalog catalog, String catalogName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/catalogues/" + catalogName + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Catalog copy = (Catalog) in.readObject();

        catalog.setName(copy.getName());
        catalog.setPath(copy.getPath());
        catalog.setItems(copy.getItems());
    }

    public static void play(Catalog catalog, int index) throws IOException {
        Desktop.getDesktop().open(catalog.getItems().get(index).getFile());
    }
}
