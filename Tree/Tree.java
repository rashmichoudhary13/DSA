import java.awt.*;
import java.util.*;

public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Builds a tree using a preorder traversal
    static class BinaryTree{
        int idx = -1;
        Node buildTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = buildTree(nodes);
            newnode.right = buildTree(nodes);

            return newnode;
        }
    }

    //DFS Traversal
    // 1. PreOrder Traversal ( root left right )
    static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //2. Inorder Traversal (left root right)
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //3. Post-Order Traversal ( left right root)
    static void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //BFS Traversal
    // Level Order Traversal
    static void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currnode = q.remove();
            if(currnode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currnode.data+ " ");
                if(currnode.left != null){
                    q.add(currnode.left);
                }
                if(currnode.right != null){
                    q.add(currnode.right);
                }
            }
        }

    }

    //Count of nodes
    static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);

        return leftNode + rightNode + 1;
    }

    //Sum of nodes
    static int sumofnodes(Node root){
        if(root == null){
            return 0;
        }

        int leftsum = sumofnodes(root.left);
        int rightsum = sumofnodes(root.right);

        return leftsum + rightsum + root.data;
    }

    //Height of Tree
    static int height(Node root){
        if(root == null){
            return 0;
        }

        int leftheight = height(root.left);
        int rightheight = height(root.right);

        int maxheight = Math.max(leftheight,rightheight) + 1;
        return maxheight;
    }

    //Diameter of a tree -->  O(n^2)
    static int diameter(Node root){
        if (root == null) {
            return 0;
        }
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(dia3, Math.max(dia1, dia2));
    }

    //Diameter of a Tree -- O(n)
    static class Treeinfo{
        int ht;
        int dia;

        Treeinfo(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }

    static Treeinfo diameter2(Node root){
        if(root == null){
            return new Treeinfo(0,0);
        }
        Treeinfo left = diameter2(root.left);
        Treeinfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int mydia = Math.max(Math.max(dia1,dia2) , dia3);

        Treeinfo myInfo = new Treeinfo(myHeight, mydia);
        return myInfo;
    }

    //Check a given tree is Subtree of a tree

    static boolean isIdentical(Node root, Node subroot){
        if(root == null && subroot == null){
            return true;
        }

        if(root == null || subroot == null){
            return false;
        }

        if(root.data == subroot.data){
            return isIdentical(root.left, subroot.left) && isIdentical(root.right,subroot.right);
        }

        return false;
    }
    static boolean isSubtree(Node root, Node subroot){
        if(subroot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    //Sum of nodes at Kth level
    static void sumofK(Node root, int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int lvl = 1;
        int sum = 0;
        while(!q.isEmpty()) {
            Node currnode = q.remove();
            if (currnode == null) {
                lvl++;
                if(lvl > k){
                    System.out.println("Sum of Kth node is: "+ sum);
                }
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else {
                if(lvl == k){
                    sum = sum + currnode.data;
                }
                if (currnode.left != null) {
                    q.add(currnode.left);
                }
                if (currnode.right != null) {
                    q.add(currnode.right);
                }
            }
        }
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int nodes2[] = {2,4,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree subtree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        Node subroot = subtree.buildTree(nodes2);

        System.out.println(root.data);
        System.out.println("Preorder Traversal: ");
        preorder(root);
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
        System.out.println("\nLevel Order Traversal:");
        levelorder(root);
        System.out.println("Count of Node is: " + countOfNodes(root));
        System.out.println("Sum of Node is: " + sumofnodes(root));
        System.out.println("Height of Node is: " + height(root));
        System.out.println("Diameter of Node is: " + diameter(root));
        System.out.println("Diameter of Node is: " + diameter2(root).dia);
        System.out.println("Subtree of Node is: " + isSubtree(root,subroot));
        sumofK(root,3);
    }
}
