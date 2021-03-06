package quotebook.theoneandonly.com.thequotebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Quotebook extends Activity {

    public final static String EXTRA_QUOTE = "com.theoneandonly.quotebook.QUOTE";
    public final static String EXTRA_PERSON = "com.theoneandonly.quotebook.PERSON";
    public final static String EXTRA_COLOR = "com.theoneandonly.quotebook.COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);

        final Context mContext = getApplicationContext();

        final RecyclerView cardList = (RecyclerView) findViewById(R.id.cardList);
        cardList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        cardList.setLayoutManager(llm);

        final QuoteAdapter quoteAdapter = new QuoteAdapter(createList());
        cardList.setAdapter(quoteAdapter);

        cardList.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.d("BINGO", "onItemClick: " + position);

                        Intent intent = new Intent(mContext, SingleQuoteActivity.class);
                        Quote q = quoteAdapter.getQuote(position);

                        String hexColor = String.format("#%06X", (0xFFFFFF & q.getColor()));

                        intent.putExtra(EXTRA_QUOTE, q.getQuote());
                        intent.putExtra(EXTRA_PERSON, q.getPerson());
                        intent.putExtra(EXTRA_COLOR, hexColor);

                        startActivity(intent);
                    }
                })
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quotebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private List<Quote> createList() {

        List<Quote> quoteList = new ArrayList<Quote>();

        Quote quote1 = new Quote("Cool Beans", "Rod Kimble");
        quoteList.add(quote1);

        Quote quote2 = new Quote("How can mirrors be real if our eyes aren't real", "Jaden Smith");
        quoteList.add(quote2);

        Quote quote3 = new Quote("That's like me blaming owls for how bad I suck at analogies.", "Britta Perry");
        quoteList.add(quote3);

        Quote quote4 = new Quote("You're more of a fun vampire. You don't suck blood, you just suck.", "Troy Barnes");
        quoteList.add(quote4);

        Quote quote5 = new Quote("I was gonna be the first person in my family to graduate from community college. Everyone else graduated from normal college", "Troy Barnes");
        quoteList.add(quote5);

        return quoteList;
    }
}
