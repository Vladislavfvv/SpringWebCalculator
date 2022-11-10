package by.tms.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Storage<T, ID> implements CrudDao<T, ID> {
    List<T> list = new ArrayList<>();

    public List<T> getList() {
        return list;
    }

    public abstract Optional<T> findEntity(String parameter);
}
