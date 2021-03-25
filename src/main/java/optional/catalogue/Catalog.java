package optional.catalogue;

import lombok.Data;
import optional.items.Item;


import java.io.Serializable;
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

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' + "\n" +
                ", path='" + path + '\'' + "\n" +
                ", items=" + items +
                '}';
    }
}
