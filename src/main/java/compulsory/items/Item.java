package compulsory.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

public @Data
@NoArgsConstructor
abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path;

    public Item(String name, String path) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.path = path;
    }

    abstract void isAbstract();
}
