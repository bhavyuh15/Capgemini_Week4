package listinterface.reversealist;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class ReverseAList {
    public void reverse(List<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();
        for (Integer i : list) {
            stack.push(i);
        }
        list.clear();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

    }


    public static void main(String[] args) {
        List<Integer> ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ReverseAList rl = new ReverseAList();
        rl.reverse(ll);
        System.out.println(ll);

        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        rl.reverse(arrayList);
        System.out.println(arrayList);
    }
}