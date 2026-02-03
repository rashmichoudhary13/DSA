import java.util.*;

//Hashmap Implementation using Collection framework
// Time complexity is O(1)
// In worst-case it is O(n) where n is the no. of elements in hashmap
public class hashmap {
    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();

        //Insert --- O(1)
        map.put("India",120);
        map.put("China",130);
        map.put("America",90);

        //Print all elements
        System.out.println(map);

        map.put("India",150);
        System.out.println(map); //If key already exist it update the value

        //Search -- O(1)
        //containsValue in worst case is O(n)
        if(map.containsKey("india")){
            System.out.println("key is present in the map.");
        } else{
            System.out.println("Key is not present in the map");
        }

        System.out.println(map.get("China")); // Key exist   return value if key exist
        System.out.println(map.get("Indonesia")); // Key does not exist


        //Delete  --- O(1)
        map.remove("China");
        System.out.println(map);

        //Size
        System.out.println("size of map is: "+ map.size());

        //Iterator
        int arr[] = {1, 2, 3, 4};

        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();

        //for(int val : arr)
        for( Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key+ " "+ map.get(key));
        }
    }
}
