import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String args[]) throws Exception {

        String ipNumber = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})";
        String ipFull = "(" + ipNumber + "\\." + ipNumber + "\\." + ipNumber + "\\." + ipNumber + ")";
//        String ipFull = ipNumber + "\\." + ipNumber + "\\." + ipNumber + "\\." + ipNumber;
        Pattern patten = Pattern.compile(ipFull);

        String line = "00.11.22.33";
        Matcher matcher = patten.matcher(line);
//        System.out.println(matcher.matches());
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        String[] ips = {
                "1.2.3.4",
                "000.12.23.034",
                "121.234.9.1",
                "23.45.56.12",
                "255.255.255.255",
                "255.1.0.256",
                "00.11.22.33.44",
                "123.45",
                "Im.not.IP.address"
        };

        String zeroTo255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

        String IP_REGEXP = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

        Pattern IP_PATTERN = Pattern.compile(IP_REGEXP);

        for (String ip : ips) {
            Boolean isValid = IP_PATTERN.matcher(ip).matches();
            System.out.printf("%20s: %b%n", ip, isValid);
        }


        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        String regex = "^(((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}
//        (0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9" +
//                "]\\d?))$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("21.22.23.24");
//        if (matcher.find()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//            System.out.println(matcher.group(4));
//        } else {
//            System.out.println("not found");
//        }

//        String regex = "(\\d{1,3}.\\d{1,3}.\\d{1,3}.[0-255])(?:(:hello))";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("0.0.0.0:hello");
//        if (matcher.find()) {
//            System.out.println(matcher.group(1));
//        } else {
//            System.out.println("not found");
//        }


//        String REGEX = "\\bcat\\d\\b";
//        String REGEX = "\\b.*\\b";
//        String INPUT = "cat1 cat2 cat3 cattie cat4";
//        Pattern p = Pattern.compile(REGEX);
//        Matcher m = p.matcher(INPUT);   // get a matcher object
//        int count = 0;
//        while (m.find()) {
//            count++;
//            System.out.println("\nMatch number " + count);
//            System.out.println("group " + count + ": " + m.group(0));
//            System.out.println("start(): " + m.start());
//            System.out.println("end(): " + m.end());
//        }
//        System.out.println(count);


        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Calendar cal = Calendar.getInstance();
        System.out.println("\nCurrent date:" + cal.getTime());
        String formattedDate = sdf.format(cal.getTime());
        System.out.println("Formatted date:" + formattedDate);
        System.out.println(cal.getTimeZone());


//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        System.out.println(line);
////        while(sc.hasNext("[a-z]+..")) {
////            String next = sc.next("[a-z]+..");
////            System.out.println(next);
////        }
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        System.out.println(s);
    }
}