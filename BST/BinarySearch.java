import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearch {
    // Left subtree < Root
    // Right Subtree > Root
    // Use Inorder traversal in BST

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    // Insert a node
    static Node buildtree(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val < root.data){
            root.left = buildtree(root.left, val);
        }else{
            root.right = buildtree(root.right,val);
        }
        return root;
    }

    static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //Search a node
    static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(key < root.data){
            return search(root.left,key);
        }else if(key == root.data){
            return true;
        }else{
           return search(root.right,key);
        }
    }

    //Delete a node
    static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left,val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);
        }
        else{ // root.data == val
            //The value that needs to be deleted is found

            //case 1: Leaf node
            if(root.right == null && root.left == null){
                return null;
            }

            //case 2: Node with one child
            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }

            //Case 3: Node with two child
            //To delete replace the node with its inorder successor node
            //IS? It is the leftmost node in the right subtree.

            Node IS = inorderSuccessor(root.right); //find inorder Successor
            root.data = IS.data;  // Replace the node that needs to be deleted with the IS node value.
            root.right = delete(root.right, IS.data); //Delete the IS node.
        }

        return root;
    }

    //print in range
    static void range(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data < x){
            range(root.right,x,y);
        }
        else if(root.data >= y){
            range(root.left,x,y);
        }
        else{
            range(root.left,x,y);
            System.out.print(root.data+ " ");
            range(root.right,x,y);
        }
    }

    static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //Root to Leaf path

    static void printPath(ArrayList<Integer> path){
        for(int i=0;i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    static void rootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
           rootToLeaf(root.left,path);
           rootToLeaf(root.right,path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String args[]){
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i < values.length; i++){
            root = buildtree(root,values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(root,19)){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }

        delete(root, 14);
        inorder(root);
        System.out.println();
        range(root, 3, 12);
        System.out.println();

        rootToLeaf(root,new ArrayList<>());
    }
}
