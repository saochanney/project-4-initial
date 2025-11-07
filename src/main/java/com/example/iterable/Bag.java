package com.example.iterable;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag<E> implements Container<E> {
    private ArrayList<E> items;

    public Bag() {
        items = new ArrayList<>();
    }

    @Override
    public void add(E item) {
        items.add(item);
    }

    @Override
    public boolean remove(E item) {
        return items.remove(item);
    }

    @Override
    public boolean contains(E item) {
        return items.contains(item);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return items.iterator();
    }
}