package com.elliottJavaClub.app.lists;

public interface CustomList <E>{

    /** Returns the number of elements in this list*/
    int size();

    /** Returns whether the list is empty*/
    boolean isEmpty();

    /** Returns(but does not remove) the element at index i*/
    E get(int it) throws IndexOutOfBoundsException;

    /** Replaces the element at index i with e, and returns the replaced element*/
    E set(int it, E e) throws IndexOutOfBoundsException;

    /** Inserts element e to be at index i, shifting all subsequent elements later*/
    E add(int it, E e) throws IndexOutOfBoundsException;

    /** Removes/returns the element at index i, shifting all subsequent elements earlier*/
    E remove(int i) throws IndexOutOfBoundsException;
}
