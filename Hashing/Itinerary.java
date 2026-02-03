import java.util.HashMap;

public class Itinerary {

    static String getstart(HashMap<String,String> tick){
        HashMap<String,String> rev_map = new HashMap<>();

        for(String key: tick.keySet()){
            rev_map.put(tick.get(key), key);
        }

        for(String key: tick.keySet()){
            if(!rev_map.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    //Find Itinerary from Tickets
    public static void main(String args[]){
        HashMap<String,String> tick = new HashMap<>();
        tick.put("Chennai", "Bengaluru");
        tick.put("Mumbai", "Delhi");
        tick.put("Goa", "Chennai");
        tick.put("Delhi", "Goa");

        String start = getstart(tick);

        while(tick.containsKey(start)){
            System.out.print(start+"-->");
            start = tick.get(start);
        }
        System.out.print(start);
    }
}
