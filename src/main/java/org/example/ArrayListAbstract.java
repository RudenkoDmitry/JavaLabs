package org.example;

public interface ArrayListAbstract <T> {
    Object get(int index);

    void set(int index, T data);

    void pushback(T data);

    void add(int index, T data);

    boolean remove(T data);

    void removeFromIndex(int index);

    int size();

    boolean isEmpty();

    int getIndex(T data);

    void clear();

    boolean contains(T data);
    Object[] toArray();

}

