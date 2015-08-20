package quotebook.theoneandonly.com.thequotebook;

import android.graphics.Color;
import java.util.Random;


public class Quote {
    public String quote;
    public String person;
    public int color;

    public Quote(String mQuote, String mPerson) {
        super();

        quote = mQuote;
        person = mPerson;

        Random rnd = new Random();

        int r = rnd.nextInt(200);
        int g = rnd.nextInt(200);
        int b = rnd.nextInt(200);

        color = Color.rgb(r, g, b);
    }

    public String getPerson() {
        return person;
    }

    public String getQuote() {
        return quote;
    }

    public int getColor() {
        return color;
    }
}
