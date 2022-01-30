package com.elliottJavaClub.app.lists;

public class DoublyLinkedList <E>{

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E element;

        public Node(E element, Node<E> next, Node<E> previous){
            this.next = next;
            this.previous = previous;
            this.element = element;
        }

        //GETTERS
        public Node<E> getNext(){
            return this.next;
        }
        public Node<E> getPrevious(){
            return this.previous;
        }
        public E getElement(){
            return this.element;
        }

        //SETTERS
        public void setNext(Node<E> next){
            this.next = next;
        }
        public void setPrevious(Node<E> previous){
            this.previous = previous;
        }
        public void setElement(E element){
            this.element = element;
        }
    }
    //END OF THE NODE

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;


    public DoublyLinkedList(){
        this.header = new Node<>(null,null,null);
        this.trailer = new Node<>(null,null,this.header);
        this.header.setNext(this.trailer);
    }

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
            return this.header.getNext().getElement();
        }
    }
    public E last(){
        if(isEmpty()){
            return null;
        }else{
            return this.trailer.getPrevious().getElement();
        }
    }

    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,trailer.getPrevious(),trailer);
    }

    public E removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            return removeNode(header.getNext());
        }
    }
    public E removeLast(){
        if(isEmpty()){
            return null;
        }else{
            return removeNode(trailer.getPrevious());
        }
    }


    private void addBetween(E e, Node<E> previous, Node<E> next){
        Node<E> newNode = new Node<>(e,next,previous);
        previous.setNext(newNode);
        next.setPrevious(newNode);
        size++;
    }

    private E removeNode(Node<E> node){
        Node<E> previous = node.getPrevious();
        Node<E> next = node.getNext();

        previous.setNext(next);
        next.setPrevious(previous);

        size--;
        return node.getElement();

    }

}
