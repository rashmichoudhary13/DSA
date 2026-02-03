public class subsetString {
    public static void main(String[] args) {
        findAllSubset("","abc");
    }

    static void findAllSubset(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        findAllSubset(p+up.charAt(0),up.substring(1));

        findAllSubset(p,up.substring(1));
    }
}
