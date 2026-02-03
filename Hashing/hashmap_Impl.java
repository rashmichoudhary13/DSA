import org.w3c.dom.html.HTMLLinkElement;

import java.util.*;

//Implementing Hashmap using LinkedList

public class hashmap_Impl {
    static  class Hashmap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n - nodes
        private int N; //No. of bucket
        private LinkedList<Node> buckets[];

        public Hashmap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int bi = key.hashCode(); // hashcode returns no. from any +ve to -ve integer
            return Math.abs(bi) % N; // bi length should be from 1 to N-1
        }

        private int searchinLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }

            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0; i<N*2;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length;i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchinLL(key, bi);

            if(di == -1){//key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            }else{
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){
                //rehashing
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchinLL(key, bi);

            if(di == -1){//key doesn't exist
               return false;
            }else{
               return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchinLL(key, bi);

            if(di == -1){//key doesn't exist
                return null;
            }else{
                Node data = buckets[bi].remove(di);
                n--;
                return data.value;
            }

        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchinLL(key, bi);

            if(di == -1){//key doesn't exist
                return null;
            }else{
                Node data = buckets[bi].get(di);
                return data.value;
            }
        }

        public ArrayList<K> keySet(){
           ArrayList<K> keys = new ArrayList<>();

           for(int i=0;i< buckets.length;i++){
               LinkedList<Node> ll = buckets[i];
               for(int j=0; j<ll.size();j++){
                   Node data = ll.get(j);
                   keys.add(data.key);
               }
           }
           return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String args[]){
        Hashmap<String, Integer> map = new Hashmap<>();
        map.put("India",190);
        map.put("china",200);
        map.put("US",50);
        map.put("Korea",100);

       ArrayList<String> keys = map.keySet();
       for(int i=0;i<keys.size();i++){
           System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
       }

       System.out.println(map.isEmpty());

    }
}
