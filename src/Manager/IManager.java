package Manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);

    void remove(int id);

    int findById(int id);

    void edit(int id, E e);
    ArrayList<E> findAll();

}
