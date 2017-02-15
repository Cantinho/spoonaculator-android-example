package com.cantinho.spoonacularexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by samirtf on 14/02/17.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private Context mContext;
    private ArrayList<Card> mDataset;
    private static MyClickListener myClickListener;

    public class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
            callMenu(getAdapterPosition() + 1);

            System.out.println();
        }

        private void callMenu(final int menuCode) {
            Intent intent = null;


            switch (menuCode) {
                case MainMenuActivity.MENU_01: {
                    System.out.println("Call Menu 01");
                    intent = new Intent(mContext.getApplicationContext(), MenuItem01Activity.class);
                    break;
                }
                case MainMenuActivity.MENU_02: {
                    System.out.println("Call Menu 02");
                    intent = new Intent(mContext.getApplicationContext(), MenuItem02Activity.class);
                    break;
                }
                case MainMenuActivity.MENU_03: {
                    System.out.println("Call Menu 03");
                    intent = new Intent(mContext.getApplicationContext(), MenuItem03Activity.class);
                    break;
                }
                case MainMenuActivity.MENU_04: {
                    System.out.println("Call Menu 04");
                    intent = new Intent(mContext.getApplicationContext(), MenuItem04Activity.class);
                    break;
                }
                default:
                    break;
            }
            if(mContext != null && intent != null) {
                mContext.startActivity(intent);
            }
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyAdapter(Context context, ArrayList<Card> myDataset) {
        mContext = context;
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spoonacular_menu_card_view_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getTitle());
        holder.dateTime.setText(mDataset.get(position).getSubtitle());
    }

    public void addItem(Card dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}