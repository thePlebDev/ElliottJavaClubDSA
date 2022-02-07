package com.elliottJavaClub.app.trees;

import com.elliottJavaClub.app.lists.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**TODO: TURN INTO A AVL TREE AND ADD A BALANCE FACTOR**/
public class BasicBinaryTree<E> {

    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e,Node<E> parent, Node<E> left, Node<E> right){
            this.element = e;
            this.parent = parent;
            this.left = left;
            this. right = right;
        }

        //GETTERS
        public E getElement(){
            return this.element;
        }
        public Node<E> getParent(){
            return this.parent;
        }
        public Node<E> getLeft(){
            return this.left;
        }
        public Node<E> getRight(){
            return this.right;
        }
        //SETTERS
        public void setElement(E e){
            this.element = e;
        }
        public void setParent(Node<E> parent){
            this.parent = parent;
        }
        public void setLeft(Node<E> left){
            this.left = left;
        }
        public void setRight(Node<E> right){
            this.right = right;
        }

    }
    //-----------END OF NODE CLASS----------------
    private Node<E> root;
    private int size = 0;

    public BasicBinaryTree(){}

    public boolean isEmpty(){
        return this.size == 0;
    }
    public int size(){
        return this.size;
    }

    public Position<E> addRoot(E e) throws IllegalStateException{
        if(!isEmpty()){
            throw new IllegalArgumentException("THERE IS ALREADY A ROOT ELEMENT");
        }
        root = new Node<E>(e,null,null,null);
        size = 1;
        return root;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("THIS POSITION IS NOT A NODE");
        }
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node){
            throw new IllegalArgumentException("THIS POSITION WAS ALREADY REMOVED");
        }
        return node;
    }

    public Position<E> addLeft(Position<E> node, E e){
        Node<E> parent = validate(node);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("THE NODE ALREADY HAS A LEFT VALUE");
        }
        Node<E> child = new Node<E>(e,parent, null,null);
        parent.setLeft(child);
        size ++;

        return child;
    }
    public Position<E> addRight(Position<E> node, E e){
        Node<E> parent = validate(node);
        if(parent.getRight() != null){
            throw new IllegalArgumentException("THE NODE ALREADY HAS A RIGHT VALUE");
        }
        Node<E> child = new Node<E>(e,parent, null,null);
        parent.setRight(child);
        size ++;

        return child;
    }

    private int numChildren(Node<E> node){
        int counter= 0;
        if(node.getLeft() != null){
            counter ++;
        }
        if(node.getRight() != null){
            counter ++;
        }
        return counter;

    }

    public E remove(Position<E> p){
        Node<E> node = validate(p);
        if(numChildren(node) == 2){
            throw new IllegalStateException("THIS NODE HAS 2 CHILDREN");
        }

        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        if(child!=null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }
        else{
            Node<E> parent = node.getParent();
            if(node == parent.getLeft()){
                parent.setLeft(child);
            }else{
                parent.setRight(child);
            }
        }
        size --;
        E temp = node.getElement();
        node.setRight(null);
        node.setElement(null);
        node.setLeft(null);
        node.setParent(node);
        return temp;
    }


    public void preOrder(){
        preTraverse(this.root);

    }
    private void preTraverse(Node<E> node){
        if(node == null){
            return;
        }
        preTraverse(node.getLeft());
        preTraverse(node.getRight());
        System.out.println(node.getElement());
    }
    public void BFS(){
        breadthFirstSearch(this.root);
    }
    private void breadthFirstSearch(Node<E> root){
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            Node<E> current = queue.remove();
            System.out.println(current.getElement());
            if(current.getLeft() != null){
                queue.add(current.getLeft());
            }
            if(current.getRight() != null){
                queue.add(current.getRight());
            }
        }

    }


    }
