package SystemDesign;

public class UrlShortener {
//    private static final int NUM_CHARS_IN_SLUG = 7;
//    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

//    private Random random = new Random();
//
//    public String generateRandomSlug() {
//        char[] result = new char[NUM_CHARS_IN_SLUG];
//
//        for (int i = 0; i < NUM_CHARS_IN_SLUG; i++) {
//            int randomIndex = random.nextInt(ALPHABET.length() - 1);
//            result[i] = ALPHABET.charAt(randomIndex);
//        }
//
//        return new String(result);
//    }
/////////////////////////

    // Another approach
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private long currentRandomSlugId = 0;

    public String generateRandomSlug() {
        String slug;

//        while (true) {
        long newId = currentRandomSlugId++;
        slug = baseConversion(newId);

//            // make sure the slug isn't already used
//            if (!DB.checkSlugExists(slug)) {
//                break;
//            }
//        }
        return slug;
    }

    private String baseConversion(long id) {
        long rem = id;
        StringBuilder sb = new StringBuilder();

        while (rem > 0) {
            int tmp = (int) rem % 62;
            sb.append(ALPHABET.charAt(tmp));
            rem = rem / 62;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

        // run your function through some test cases here
        // remember: debugging is half the battle!

        UrlShortener sol = new UrlShortener();
        System.out.println(sol.generateRandomSlug());
    }
}
