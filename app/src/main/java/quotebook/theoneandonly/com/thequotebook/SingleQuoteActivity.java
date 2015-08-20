package quotebook.theoneandonly.com.thequotebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.widget.TextView;

public class SingleQuoteActivity extends Activity {

    protected TextView vQuote;
    protected TextView vPerson;
    protected CardView vCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_layout);

        Intent intent = getIntent();
        String quote = intent.getStringExtra(Quotebook.EXTRA_QUOTE);
        String person = intent.getStringExtra(Quotebook.EXTRA_PERSON);

        vQuote = (TextView) findViewById(R.id.quote);
        vPerson = (TextView) findViewById(R.id.person);
        vCard = (CardView) findViewById(R.id.card_view);

        vQuote.setText(quote);
        vPerson.setText(person);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
