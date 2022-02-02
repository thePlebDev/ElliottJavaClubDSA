package com.elliottJavaClub.app.trees;

import com.elliottJavaClub.app.lists.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{

    public static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e,Node<E> above, Node<E> leftChild, Node<E> rightChild){
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        //GETTERS
        @Override
        public E getElement() throws IllegalStateException {
            return this.element;
        }
        public Node<E> getParent(){return parent;}
        public Node<E> getLeft(){return this.left;}
        public Node<E> getRight(){return this.right;}

        //UPDATE METHODS
        public void setElement(E e){
            this.element = e;
        }
        public void setParent(Node<E> parentNode){
            this.parent = parentNode;
        }
        public void setLeft(Node<E> leftChild){
            this.left = leftChild;
        }
        public void setRight(Node<E> rightChild){
            this.right = rightChild;
        }
    }//------ END OF NODE CLASS ----------------

    protected Node<E> root = null;
    private int size = 0;

    private Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<E>(e,parent,left,right);
    }
    public LinkedBinaryTree(){}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node){
            throw new IllegalArgumentException("P is longer in the tree");
        }
        return node;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = this.validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = this.validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> position() {
        return null;
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()){
            throw new IllegalStateException("TREE IS NOT EMPTY");
        }
        root = createNode(e,null,null,null);
        size =1;
        return root;
    }

    public Position<E> addRight(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getRight() != null){
            throw new IllegalArgumentException("p already has a right child");
        }
       Node<E> child = createNode(e,parent,null,null);
        parent.setRight(child);
        size++;
        return child;
    }

    public Position<E> addLeft(Position<E> p,E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e,parent,null,null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e){
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);

        if(numChildren(p) == 2){
            throw new IllegalStateException("P HAS TWO CHILDREN");
        }
        Node<E> child = (node.getLeft() !=null ? node.getLeft() : node.getRight());
        if(child !=null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }else{
            Node<E> parent = node.getParent();
            if(node == parent.getLeft()){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setRight(null);
        node.setLeft(null);
        node.setParent(node);
        return temp;
    }

}
