package MockP4;

/*
 *
 * 379. Design Phone Directory
 * https://leetcode.com/problems/design-phone-directory/
 *
 * */
public class PhoneDirectory {
    boolean[] numbers;
    int maxNumbers;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.numbers = new boolean[maxNumbers];
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        for (int i = 0; i < maxNumbers; i++) {
            if (!numbers[i]) {
                numbers[i] = true;
                return i;
            }
        }
        return -1;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !numbers[number];
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        numbers[number] = false;
    }


    /**
     * Your PhoneDirectory object will be instantiated and called as such:
     * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
     * int param_1 = obj.get();
     * boolean param_2 = obj.check(number);
     * obj.release(number);
     */
    public static void main(String[] args) {
        PhoneDirectory obj = new PhoneDirectory(3);
        System.out.println(obj.get()); // 0
        System.out.println(obj.get()); // 1
        System.out.println(obj.check(2)); // true
        System.out.println(obj.get()); // 2
        System.out.println(obj.check(2)); // false
        obj.release(2);
        System.out.println(obj.check(2)); // true
    }
}
