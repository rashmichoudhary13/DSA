public class Trie_ds {
    //Time complexity: O(L)   L - length of the longest word
    //It is a search tree for a string
    //Every node has a array of alphabet and an end of word

    static class Node{
       Node[] children;
       boolean eow;

       public Node(){
           children = new Node[26];
           for(int i=0; i<26; i++){
               children[i] = null;
           }
           eow = false;
       }
    }

    static Node  root = new Node();

    //Insert in trie
    static void insert(String word){
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                //add new node
                curr.children[idx] = new Node();
            }
            if(i == word.length() - 1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    // Search in trie
    static boolean search(String key){
        Node curr = root;

        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            if(i == key.length()-1 && curr.children[idx].eow == false){
                return false;
            }

            curr = curr.children[idx];
        }
        return true;
    }

    // Word break problem
    // Find out if input string can be broken into sequence of dictionary word.
    static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            String firstPart = key.substring(0,i);
            String secPart = key.substring(i);
            if(search(firstPart) && wordBreak(secPart)){
                return true;
            }
        }

        return false;
    }

    // Starts With Problem
    // Return true if the word in dict has the given key as prefix
    static boolean startsWith(String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }


    // Count unique substring
    // Count the total number of unique substring of given string.
    // 1. find all suffix of given string
    // 2. Create a trie from suffix
    // 3. total nodes of trie = count of unique prefix.
    static int countNode(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }

    // Longest word with all prefixes
    // Find longest string in dict such that every prefix of it is also in dict.
    static String ans = " ";;

    static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }

    }

    public static void main(String args[]){
//        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String key = "ilikesamsung";
        String prefix = "mob";
        String str = "ababa";

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

//        for(int i=0; i<str.length(); i++){
//            String suffix = str.substring(i);
//            insert(suffix);
//        }

//        System.out.println("The word like exist in trie: " + search("like"));
//        System.out.println("The word like exist in trie: " + search("thor"));
//
//        System.out.println("Word Break exist: " + wordBreak(key));
//        System.out.println("Prefix mob exist: " + startsWith(prefix));
        System.out.println("Total unique substring: " + countNode(root));
        longestWord(root, new StringBuilder(" "));
        System.out.println(ans);


    }
}
