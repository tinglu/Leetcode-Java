import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.pollLast());
        System.out.println(stack.poll());

    }
}
