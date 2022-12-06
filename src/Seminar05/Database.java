package Seminar05;

import java.util.Collection;

public interface Database {
    void load();
    void save();
    Collection<Entity> getAll();
}
