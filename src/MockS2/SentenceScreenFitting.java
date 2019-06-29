package MockS2;


/*
 *
 * Wrong solution
 *
 * TODO!!!!!: finish this later!!!!!
 *
 * https://leetcode.com/problems/sentence-screen-fitting/
 * 418. Sentence Screen Fitting
 *
 * */
public class SentenceScreenFitting {
    int remRow;
    int remCol;
    int wordCount;

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sentenceCount = 0;
        wordCount = sentence.length;

        int[] wordLengths = new int[wordCount];
        for (int i = 0; i < wordCount; i++) {
            wordLengths[i] = sentence[i].length();
        }

        remRow = rows;
        remCol = cols;

        while (remRow >= 0) {
            if (typeSentence(wordLengths, rows, cols)) {
                sentenceCount += 1;
            }
            System.out.println("====remRow: " + remRow + " remCol: " + remCol);
        }

        return sentenceCount;
    }

    private boolean typeSentence(int[] wordLengths, int rows, int cols) {
//        int remRow = rows;
//        int remCol = cols;
        System.out.println();
        for (int len : wordLengths) {
            System.out.println("remRow: " + remRow + " remCol: " + remCol);
            if (len > cols) return false; // couldn't put in this word in one row

//            if (len > remCol && remRow == 0) return false; // no way to move to the next line

            remCol -= len;
            if (remCol < 0) { // couldn't put in one word in the same line
                remCol = cols;
                remRow -= 1;
                remCol -= len; // put it in the next line instead
            }

            if (remRow < 0) { // couldn't put in the whole sentence
                return false;
            }

            // Could put current word in one line & still have rows remaining
            remCol -= 1; // should deduct one spacing
            if (remCol == 0) { // should move to the next row
                remCol = cols;
                remRow -= 1;
            }
        }

        return remRow >= 0 && remCol >= 0;
    }

    public static void main(String[] args) {
        SentenceScreenFitting sol = new SentenceScreenFitting();
//        System.out.println(sol.wordsTyping(new String[]{"hello", "world"}, 2, 8));
//        System.out.println(sol.wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
//        System.out.println(sol.wordsTyping(new String[]{"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(sol.wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
    }
}
