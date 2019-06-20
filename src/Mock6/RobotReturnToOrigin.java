package Mock6;

import java.util.Stack;

/*
 *
 * 657. Robot Return to Origin
 * https://leetcode.com/problems/robot-return-to-origin/
 *
 *
 * */
public class RobotReturnToOrigin {
    public boolean judgeCircle1(String moves) {
        Stack<Character> horizontal = new Stack<>();
        Stack<Character> vertical = new Stack<>();
        char[] chars = moves.toCharArray();
        for (char move : chars) {
            switch (move) {
                case 'U':
                    if (!vertical.isEmpty() && vertical.peek() == 'D') {
                        vertical.pop();
                    } else {
                        vertical.push(move);
                    }
                    break;
                case 'D':
                    if (!vertical.isEmpty() && vertical.peek() == 'U') {
                        vertical.pop();
                    } else {
                        vertical.push(move);
                    }
                    break;
                case 'L':
                    if (!horizontal.isEmpty() && horizontal.peek() == 'R') {
                        horizontal.pop();
                    } else {
                        horizontal.push(move);
                    }
                    break;
                case 'R':
                    if (!horizontal.isEmpty() && horizontal.peek() == 'L') {
                        horizontal.pop();
                    } else {
                        horizontal.push(move);
                    }
                    break;
                default:
                    break;
            }
        }
        return horizontal.isEmpty() && vertical.isEmpty();
    }

    /*
     *
     *
     * Don't need 2 stacks actually!
     *
     *
     * */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for (char move : chars) {
            switch (move) {
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }


    public static void main(String[] args) {
        RobotReturnToOrigin sol = new RobotReturnToOrigin();

        System.out.println(sol.judgeCircle("UD"));
    }
}
