package quotebook.theoneandonly.com.thequotebook;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {

    private List<Quote> quoteList;

    public QuoteAdapter(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }


    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder quoteViewHolder, int i) {
        Quote q = quoteList.get(i);
        Log.d("QUOTE", "onBindViewHolder: " + q.quote + " " + q.person);
        quoteViewHolder.vQuote.setText(q.quote);
        quoteViewHolder.vPerson.setText(q.person);
    }

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new QuoteViewHolder(itemView);
    }


    public static class QuoteViewHolder extends RecyclerView.ViewHolder {

        protected TextView vQuote;
        protected TextView vPerson;

        public QuoteViewHolder(View v) {
            super(v);
            vQuote = (TextView) v.findViewById(R.id.quote);
            vPerson = (TextView) v.findViewById(R.id.person);
        }
    }
}