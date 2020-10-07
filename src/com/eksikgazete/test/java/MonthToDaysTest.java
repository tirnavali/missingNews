import com.eksikgazete.main.MonthsToDays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MonthToDaysTest {
    public static void main(String[] args) {

        MonthsToDays monthsToDays = new MonthsToDays();
        String[] result = monthsToDays.howManyDaysAtMonth("SUBAT", "2020");
        for (String s : result) {
            System.out.print(s+", ");
        }
    }
    private MonthsToDays monthsToDays = new MonthsToDays();

    @Test
    public void wrongMonthName(){
        String [] result = monthsToDays.howManyDaysAtMonth(" ", " ");
        assertNull("Nesne boş", result);
    }

    @Test
    public void testLeapYear(){
        String [] result = monthsToDays.howManyDaysAtMonth("SUBAT", "2020");
        assertEquals(29,result.length);
    }

    @Test
    public void testFebruary(){
        String [] result = monthsToDays.howManyDaysAtMonth("SUBAT", "2019");
        assertEquals(28,result.length);

    }

    @Test
    public void testThirtyMonths(){
        String[] years = {"1999", "1997", "2002", "1765", "1453", "0000", "2020", "2016"};
        String[] months = {"NISAN","HAZIRAN","EYLUL","KASIM"};
        for (String year : years) {
            for (String month : months) {
                String[] result = monthsToDays.howManyDaysAtMonth(month, year);
                assertEquals(30, result.length);
            }
        }
    }

    @Test
    public void testThirtyonesMonths(){
        String[] years = {"1999", "1997", "2002", "1765", "1453", "0000", "2020", "2016"};
        String[] months = {"OCAK","MART","MAYIS","TEMMUZ","AGUSTOS","EKIM","ARALIK"};
        for (String year : years) {
            for (String month : months) {
                String[] result = monthsToDays.howManyDaysAtMonth(month, year);
                assertEquals(31, result.length);
            }
        }
    }
}
