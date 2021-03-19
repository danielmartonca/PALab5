package compulsory.catalogue;

import compulsory.items.Item;
import lombok.Data;

import java.awt.*;
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

    public void add(Item item) throws IOException {
        items.add(item);
        File file = new File(item.getPath());
        if (!file.exists())
            if (file.createNewFile())
                System.out.println("File " + item.getName() + " created successfully at path " + item.getPath());
            else
                System.err.println("Failed to create file " + item.getName() + " at path " + item.getPath());

    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId().equals(Integer.toString(id)))
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

    public void play(int index) throws IOException {
        if (index < 0 || index > items.size()) {
            System.err.println("Index invalid.");
            System.exit(-1);
        }
        Desktop.getDesktop().open(new File(items.get(index).getPath()));
    }
}
