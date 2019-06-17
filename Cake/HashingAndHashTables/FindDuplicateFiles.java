package HashingAndHashTables;

import java.nio.file.Path;

// TODO: review later

/*
 *
 * Each "fingerprint" takes O(1) time and space, so our total time and space costs are O(n) where nn is the
 * number of files on the file system.
 *
 * */
public class FindDuplicateFiles {

    public static String myFunction(String arg) {

        // write the body of your function here
//
//        Map<String, Stack<String>> dupes = new HashMap<>();
//
//        Deque<String> stack = new ArrayDeque<>();
//
//        for (String file : arg) {
//
//        }


        return "running with " + arg;
    }

    public static void main(String[] args) {

        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "test input";
        System.out.println(myFunction(testInput));
    }
}


class FilePaths {

    private Path duplicatePath;
    private Path originalPath;

    public FilePaths(Path duplicatePath, Path originalPath) {
        this.duplicatePath = duplicatePath;
        this.originalPath = originalPath;
    }

    public Path getDuplicatePath() {
        return duplicatePath;
    }

    public Path getOriginalPath() {
        return originalPath;
    }

    @Override
    public String toString() {
        return String.format("(duplicate: %s, original: %s)", duplicatePath, originalPath);
    }
}