package com.elliottJavaClub.app.lists;

public class FixedCapacityArrayList<E> implements CustomList<E>{

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

//    public FixedCapacityArrayList(){
//        this(this.CAPACITY);
//
//    }
//    public FixedCapacityArrayList(int capacity){
//        super();
//        data = (E[]) new Object[capacity];
//    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i,this.size);
        return this.data[i];
    }

    @Override
    public E set(int it, E e) throws IndexOutOfBoundsException {
        checkIndex(it,this.size);
        E temp = this.data[it];
        this.data[it] = e;
        return temp;
    }

    @Override
    public E add(int it, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i<0 || i >= 0){
            throw new IndexOutOfBoundsException("ILLEGAL INDEX " + i);
        }
    }
}
