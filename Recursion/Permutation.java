public class Permutation {
    //Print all permutation of abc
    public static void comb(String str,String permu){
        if(str.isEmpty()){
            System.out.println(permu);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            comb(newstr,permu+curr);
        }

    }

    public static void main(String[] args) {
        comb("abc","");
    }
}
