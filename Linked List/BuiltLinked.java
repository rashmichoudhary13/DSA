import java.util.LinkedList;
import java.util.Scanner;

class BuiltLinked {

    public static void reverse(LinkedList<Integer> list){
      int left = 0;
      int right = list.size()-1;

      while(left < right){
          int temp = list.get(left);
          list.set(left,list.get(right));
          list.set(right,temp);
          left++;
          right--;
      }
    }
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        //add method
        list.add(1);
        list.add(2); // adds element in last
        list.addLast(3);
        list.addFirst(4);
        list.add(3,5);
        list.add(6);
        System.out.println(list);
        reverse(list);
        System.out.println(list);



//        System.out.println(list.get(1));
//        System.out.println(list.size());
//
//        list.remove(3);
//        list.removeFirst();
//        list.removeLast();
//
//        System.out.println(list);
//        list.remove(); //remove first element
//        System.out.println(list);

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number in the range 1-50 (enter -1 to stop): ");
//
//        while(true){
//            int num = sc.nextInt();
//            if(num == -1) break;
//
//            if(num >= 1 && num <= 50){
//                list.add(num);
//            }else{
//                System.out.println("Out of range");
//            }
//        }
//
//        System.out.println(list);
//
//        for(int i =list.size()-1; i >= 0; i--){
//            if(list.get(i) > 25){
//                list.remove(i);
//            }
//        }
//
//        System.out.println("After removing: " + list);
//
    }
}
//4 30 8 9 40 35 10 28 13 45 -1