package compulsory.items;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
public @Data
class Song extends Item {
    private List<String> authors;
    private String songName;

    public Song(String name, String path, String songName, String... authors) {
        super(name, path);
        this.authors = new LinkedList<>(Arrays.asList(authors));
        this.songName = songName;
    }

    @Override
    void isAbstract() {

    }

}
