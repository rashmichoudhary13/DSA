import java.util.HashSet;
public class subsequence {

//    // Print Subset
    public static void subseq(String str,int idx,String res){
        if(idx==str.length()){
            System.out.println(res);
            return;
        }

        //choose
        char curr = str.charAt(idx);
        subseq(str,idx+1,res+curr);

        // Don't choose
        subseq(str,idx+1,res);
    }

    //Print uniques subsequence
    public static void unique_subseq(String str,int idx,String newstr,HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newstr)) {
                return;
            }else{
                System.out.println(newstr);
                set.add(newstr);
                return;
            }
        }

        char curr = str.charAt(idx);
        unique_subseq(str,idx+1,newstr+curr,set);

        unique_subseq(str,idx+1,newstr,set);
    }

    // Print Keypad combination
    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printcomb(String str,int idx, String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }

        char curr = str.charAt(idx);
        String mapping = keypad[curr-'0'];

        for(int i=0;i<mapping.length();i++){
            printcomb(str,idx+1,combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        subseq("aaa",0,"");
        HashSet<String> set = new HashSet<>();
        unique_subseq("abc",0,"",set);
         printcomb("23",0,"");
    }
}
