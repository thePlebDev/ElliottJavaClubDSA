package com.elliottJavaClub.app;


import com.elliottJavaClub.app.lists.Position;
import com.elliottJavaClub.app.trees.BasicBinaryTree;





/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BasicBinaryTree<Integer> tree = new BasicBinaryTree<>();
        Position<Integer> rootNode = tree.addRoot(30);
        Position<Integer> leftNode1 = tree.addLeft(rootNode,9);

        System.out.println(tree.size());

    }


}
