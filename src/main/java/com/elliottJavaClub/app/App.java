package com.elliottJavaClub.app;


import com.elliottJavaClub.app.lists.Position;
import com.elliottJavaClub.app.trees.BasicBinaryTree;





/**
 * Hello world!
 *
 */
public class App 
{
    /**TODO: TURN INTO A AVL TREE AND ADD A BALANCE FACTOR**/
    public static void main( String[] args )
    {
        BasicBinaryTree<Integer> tree = new BasicBinaryTree<>();
        Position<Integer> rootNode = tree.addRoot(30);
        Position<Integer> leftNode1 = tree.addLeft(rootNode,9);
        Position<Integer> rightNode1 = tree.addRight(rootNode,33);
        Position<Integer> leftNode2 = tree.addLeft(leftNode1,7);
        Position<Integer> leftNode3 = tree.addRight(leftNode1,10);



        tree.BFS();

    }


}
