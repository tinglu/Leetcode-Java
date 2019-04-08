import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    //    4
    //    <h1>Nayeem loves counseling</h1>
    //    <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
    //    <Amee>safat codes like a ninja</amee>
    //    <SA premium>Imtiaz has a secret crush</SA premium>


//    public static String processLine(String line) {
//        System.out.println(line);
//        char[] chars = line.toCharArray();
//        Stack<Character> tags = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        boolean isOpen = false;
//
//        int i = 0;
//        while (i < chars.length) {
//            System.out.println("i: " + i);
//            System.out.println("tags: " + tags);
//            if (isOpen) {
//                if (tags.peek() == '>') {
//                    if (chars[i] == '<') {
//                        tags.add(chars[i]);
//                        isOpen = false;
//                    } else {
//                        sb.append(chars[i]);
//                    }
//                }
//            } else {
//                tags.add(chars[i]);
//
//                if (tags.peek() == '>' && !isOpen) {
//                    isOpen = true;
//                }
//                if (tags.peek() == '/') {
//                    i++;
//                    System.out.println(tags);
//
//                    // pop three characters of > < /
//                    tags.pop(); // '/'
//                    tags.pop(); // '<'
//                    tags.pop(); // '>'
//
//                    System.out.println(tags);
//                    String start = "";
//                    String end = "";
//                    while (!tags.empty()) {
//                        if (chars[i] == '<' || chars[i] == '/' || chars[i] == '>') {
//                            i++;
//                        } else {
//                            System.out.println("tags.peek(): " + tags.peek());
//                            System.out.println("chars[i]): " + chars[i]);
//                            start = tags.pop() + start;
//                            end += chars[i];
//
//                            i++;
//                        }
//
//
//                    }
//
//                    System.out.println("start: " + start);
//                    System.out.println("end: " + end);
//
//                    if (!start.equals(end)) return "None";
//
//                    tags.pop(); // '<'
//                    i++; // bypass closing '>'
//                }
//            }
//            i++;
//        }
//
//        return sb.toString();
//    }


    public static void processLine(String line) {
        boolean matchFound = false;
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher m = r.matcher(line);

        while (m.find()) {
            System.out.println(m.group(2));
            matchFound = true;
        }
        if (!matchFound) {
            System.out.println("None");
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            //Write your code here
            processLine(line);
//            System.out.println();

            testCases--;
        }
    }
}
