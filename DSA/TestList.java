import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// A Java program to demonstrate working of list remove
// when index is passed.

public class TestList {
    public static void main(String[] args) {
        // Demonstrating remove on ArrayList
        List<String> myAlist = new ArrayList<>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original ArrayList : " + myAlist);
        myAlist.remove("Quiz");
        myAlist.remove(0);
        myAlist.remove("Quiz");
        System.out.println("Modified ArrayList : " + myAlist);

        // Demonstrating remove on LinkedList
        List<String> myLlist = new LinkedList<>();
        myLlist.add("Geeks");
        myLlist.add("Practice");
        myLlist.add("Quiz");
        System.out.println("Original LinkedList : " + myLlist);
        myLlist.remove(2);
        myLlist.remove("Geeks");
        myLlist.remove("Geeks");
        System.out.println("Modified LinkedList : " + myLlist);
    }
}
