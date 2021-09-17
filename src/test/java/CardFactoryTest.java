import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CardFactoryTest {

    @Test
    public void testCardFactoryCreate() throws IOException, ParseException {
        new CardFactory();
    }

    @Test
    public void testCardFactoryGet() throws IOException, ParseException {
        CardFactory cardFactory = new CardFactory();
        ArrayList<Card> first = cardFactory.getCards(3);
        ArrayList<Card> second = cardFactory.getCards(3);
        Card firstSpy = null;
        Card firstNotSpy = null;
        Card secondSpy = null;
        Card secondNotSpy = null;
        int f = 0;
        int s = 0;
        while(firstSpy == null || firstNotSpy == null) {
            if(first.get(f).getSpy()) {
                firstSpy = first.get(f);
            } else {
                firstNotSpy = first.get(f);
            }
            f++;
        }
        while(secondSpy == null || secondNotSpy == null) {
            if(second.get(s).getSpy()) {
                secondSpy = second.get(s);
            } else {
                secondNotSpy = second.get(s);
            }
            s++;
        }
        Assert.assertEquals(firstSpy, secondSpy);
        Assert.assertNotNull(firstNotSpy.getLocation());
        Assert.assertNotNull(secondNotSpy.getLocation());
        Assert.assertNotSame(firstNotSpy.getLocation(), secondNotSpy.getLocation());
    }
}
