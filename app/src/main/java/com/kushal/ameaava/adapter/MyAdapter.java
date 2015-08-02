package com.kushal.ameaava.adapter;

import com.google.android.youtube.player.YouTubeIntents;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kushal.ameaava.R;
import com.kushal.ameaava.model.CardData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kushal on 02-08-2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = "MyAdapter";
    private Context mContext;
    private List<CardData> cardDatas;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, List<CardData> cardDatas) {
        this.cardDatas = cardDatas;
        this.mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v, new ViewHolder.IMyViewHolderClicks() {
            public void startMyActivity(View caller, int position) {
                Intent intent = YouTubeIntents.createPlayVideoIntentWithOptions(v.getContext(), "8yHCyd4XC0k", true, false);
                v.getContext().startActivity(intent);
            }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Picasso.with(mContext)
                .load(cardDatas.get(position).getVideoURL())
//                .placeholder(R.drawable.bird) // optional
//                .error(R.drawable.bird)         // optional
                .into(holder.mThumbNail);

    }

    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView mCardView;
        public ImageView mThumbNail;
        public IMyViewHolderClicks mListener;

        public ViewHolder(View v, IMyViewHolderClicks listener) {
            super(v);
            mListener = listener;
            mCardView = (CardView) v.findViewById(R.id.card_view);
            mThumbNail = (ImageView) mCardView.findViewById(R.id.thumbNail);
            mCardView.setOnClickListener(this);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.startMyActivity((CardView) v, getPosition());
        }

        public static interface IMyViewHolderClicks {
            public void startMyActivity(View caller, int position);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cardDatas.size();
    }
}