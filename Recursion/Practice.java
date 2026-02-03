public class Practice {

//    static void fun1(int num){
//        System.out.println("Print " + num);
//        if(num == 5) return;
//        fun1(num +1);
//        System.out.println("After base condition");
//    }
    public static void main(String []args){
        int a=1034;
//        fun1(1);
        int size = (int) Math.log10(a) + 1;
        System.out.println(size);
    }
}
