package algorithmsapi.bst;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(Long value) {
        this.root = new Node(value);
    }
    public static void readEntry(){
        try (Scanner sc = new Scanner(new File("bst.txt"))) {
            BinarySearchTree bst = new BinarySearchTree(sc.nextLong());
            while (sc.hasNext()){
            Long value = sc.nextLong();
            bst.insert(value);
            }
            bst.posOrder();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Node insert(Node node, Long value){
        if(node == null){
            return new Node(value);
        }
        Long nodeValue = node.getValue();

        if(nodeValue<value){
            node.right = insert(node.right,value);
        }else if(nodeValue>value){
            node.left = insert(node.left,value);
        }
        return node;
    }

    private void insert(Long value){
        insert(root,value);
    }
    void inOrder() { inOrder(root); }

    void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.getValue() + " ");
            inOrder(root.right);
        }
    }

    void preOrder() { preOrder(root); }

    void preOrder(Node root)
    {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void posOrder() { posOrder(root); }

    void posOrder(Node root)
    {
        if (root != null) {
            posOrder(root.left);
            posOrder(root.right);
            System.out.println(root.getValue());
        }
    }


}
