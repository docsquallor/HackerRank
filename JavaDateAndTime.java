
public class Solution {
    public static String getDay(String day, String month, String year) {
        try
        {
            java.util.Date date= new java.text.SimpleDateFormat("dd-MM-yyyy").
                                parse(String.format("%s-%s-%s",day, month, year));
            return new java.text.SimpleDateFormat("EEEE").format(date).toString().toUpperCase();   
        }
        catch(Exception e)
        {
            return null;
        }
    }
