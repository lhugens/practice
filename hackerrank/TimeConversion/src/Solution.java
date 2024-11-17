public class Solution {

    public static String timeConversion(String s) {

        String format = s.substring(s.length() - 2);

        String hour = s.substring(0, 2);
        String minute = s.substring(3, 5);
        String second = s.substring(6, 8);

        if (format.equals("AM")) {
            if (hour.equals("12")) {
                hour = "00";
            }
        } else {
            if (!hour.equals("12")) {
                hour = String.valueOf(Integer.parseInt(hour) + 12);
            }
        }

        return hour + ":" + minute + ":" + second;
    }


    public static void main(String[] args) {

        String s;

        s = "12:00:00:AM";
        System.out.println(timeConversion(s));

        s = "02:00:00:AM";
        System.out.println(timeConversion(s));

        s = "02:00:00:PM";
        System.out.println(timeConversion(s));

    }

}
