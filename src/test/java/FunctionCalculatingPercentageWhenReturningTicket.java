import org.junit.Assert;
import org.junit.Test;

public class FunctionCalculatingPercentageWhenReturningTicket {

    // За 10 и более дней — получить обратно полную стоимость билета.
    @Test
    public void testFullTicketPrice() {
        Integer actualResult = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals("100", actualResult);
    }

    //От 6 до 10 дней включительно — получить 50% стоимости билета.
    @Test
    public void test50TicketPriceMin() {
        Integer actualResult = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals("50", actualResult);
    }
    @Test
    public void test50TicketPriceMax() {
        Integer actualResult = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals("50", actualResult);
    }

    // От 3 до 5 дней включительно — получить 30% стоимости билета.
    @Test
    public void test30TicketPriceMin() {
        Integer actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals("30", actualResult);
    }
    @Test
    public void test30TicketPriceMax() {
        Integer actualResult = getRefundTicketPricePercent(120, false, false);
        Assert.assertEquals("30", actualResult);
    }

    // За 72 часа и менее до начала концерта — стоимость билета не возвращается.
    @Test
    public void test0TicketPrice() {
        Integer actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals("0", actualResult);
    }

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)

    {

        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
