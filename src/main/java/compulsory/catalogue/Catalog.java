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

    public void add(Item item) {
        items.add(item);
    }

    public void list() {
        for (Item item : items)
            System.out.println(item);
    }
}
