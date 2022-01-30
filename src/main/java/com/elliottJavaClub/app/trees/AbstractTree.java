package com.elliottJavaClub.app.trees;

import com.elliottJavaClub.app.lists.Position;

import java.util.Iterator;

public class AbstractTree<E> implements Tree<E>{
    @Override
    public Position<E> root() {
        return null;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        return null;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) ==0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> position() {
        return null;
    }
}
