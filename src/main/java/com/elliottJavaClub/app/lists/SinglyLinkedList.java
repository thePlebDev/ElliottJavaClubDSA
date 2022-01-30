package com.elliottJavaClub.app.lists;

public class SinglyLinkedList<E> {

    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
        //GETTERS
        public E getElement(){
            return this.element;
        }
        public Node<E> getNext(){
            return this.next;
        }
        //SETTERS
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setElement(E element) {
            this.element = element;
        }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }else{
            return this.head.getElement();
        }
    }
    public E last(){
        if(isEmpty()){
            return null;
        }else{
            return this.tail.getElement();
        }
    }
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e,head);
        this.head = newNode;
        if(this.size == 0){
            this.tail = head;
        }
        size ++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e,null);
        if(isEmpty()){
            this.head = newNode;
        }else{
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        size++;
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            E headElement = head.getElement();
            this.head = this.head.getNext();
            size --;
            if(size == 0){
                tail = null;
            }
            return headElement;
        }
    }
}
