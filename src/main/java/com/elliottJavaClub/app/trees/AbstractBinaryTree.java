package com.elliottJavaClub.app.trees;

import com.elliottJavaClub.app.lists.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBinaryTree <E> extends AbstractTree<E> implements BinaryTree<E>{


    /**
     * TODO: TALK ABOUT THE SNAPSHOT TERMS
     * TODO: MAKE THIS CLASS ABSTRACT
     * **/
    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null){
            snapshot.add(left(p));
        }
        if(right(p) != null){
            snapshot.add(right(p));
        }
        return snapshot;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        int count = 0;
        if(left(p) != null){
            count ++;
        }
        if(right(p) != null){
            count++;
        }
        return count;
    }

    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if(parent == null){
            return null;
        }
        if(p == left(parent)){
            return right(parent);
        }else{
            return left(parent);
        }
    }
}
