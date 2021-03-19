package compulsory.catalogue;

import compulsory.items.Item;
import lombok.Data;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public @Data
class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new LinkedList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id))
                return item;
        }
        return null;
    }

    public void list() {
        for (Item item : items)
            System.out.println(item);
    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/catalogues/" + name + ".ser"));
        out.writeObject(this);
        out.close();
    }

    public void load(String catalogName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/catalogues/" + name + ".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Catalog copy = (Catalog) in.readObject();

        this.name = copy.getName();
        this.path = copy.getPath();
        this.items = copy.getItems();
    }
}
