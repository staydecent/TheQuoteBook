package quotebook.theoneandonly.com.thequotebook;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;


public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    private List<Quote> quoteList;

    public QuoteAdapter(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }


    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public QuoteAdapter.QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        QuoteViewHolder vh = new QuoteViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder quoteViewHolder, int i) {
        Quote q = quoteList.get(i);
        Log.d("QUOTE", "onBindViewHolder: " + q.quote + " " + q.person);
        quoteViewHolder.vQuote.setText(q.quote);
        quoteViewHolder.vPerson.setText(q.person);
    }


    public static class QuoteViewHolder extends RecyclerView.ViewHolder {

        protected TextView vQuote;
        protected TextView vPerson;
        protected CardView vCard;

        public QuoteViewHolder(View v) {
            super(v);
            vQuote = (TextView) v.findViewById(R.id.quote);
            vPerson = (TextView) v.findViewById(R.id.person);
            vCard = (CardView) v.findViewById(R.id.card_view);

            Random rnd = new Random();

            int r = rnd.nextInt(200);
            int g = rnd.nextInt(200);
            int b = rnd.nextInt(200);

            int randomColor = Color.rgb(r, g, b);

            vCard.setCardBackgroundColor(randomColor);
        }
    }
}