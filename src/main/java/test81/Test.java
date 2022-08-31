package test81;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        A a = new A();
//        B b = (B)a;
//        System.out.println(b.getName());
//        System.out.println(h(10));
//        h(19);
//        int number = 5;
//        switch (number) {
//            case 1:
//                System.out.println(1+",");
//                break;
//            case 2:
//                System.out.println(2+",");
//                break;
//            case 5:
//                System.out.println(5+",");
//            default:
//                System.out.println("none");
//        }
        List<TestObject> testObjects = new ArrayList<TestObject>();
        TestObject testObject = new TestObject();
        testObject.setProduct("1,2,3");
        testObject.setName("test");

        TestObject testObject1 = new TestObject();
        testObject1.setProduct("4,5");
        testObject1.setName("test2");
        testObjects.add(testObject1);
    }

//    swapElements(Stack s){
//        if(!s.isEmpty()){
//            int firstElement = s.pop();
//            if(!s.isEmpty()){
//                int secondElement = s.pop();
//                s.push(firstElement);
//                s.push(secondElement);
//            }
//            // 不知道填啥
//        }
//    }

    static int h(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else {
            return h(h(n-1))+h(n-h(n-1));
        }
    }
}
