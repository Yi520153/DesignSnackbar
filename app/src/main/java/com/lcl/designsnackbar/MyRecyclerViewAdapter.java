package com.lcl.designsnackbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lcl on 2016/12/6.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolderView> {

    private static final String TAG = MyRecyclerViewAdapter.class.getSimpleName();

    private Context context;
    private List<String> contentList;
    private MyItemListener myItemListener;

    public MyRecyclerViewAdapter(Context context, List<String> contentList) {
        this.contentList = contentList;
        this.context = context;
    }

    @Override
    public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_my_recycler_view, null);
        return new MyHolderView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyHolderView holder, int position) {

        if(position>8){
            holder.itemContent.setTextColor(Color.BLUE);
        }else{
            holder.itemContent.setTextColor(Color.BLACK);
        }

        holder.itemContent.setText(contentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myItemListener != null) {
                    myItemListener.onItemListener(v, holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentList != null ? contentList.size() : 0;
    }

    public void setMyItemListener(MyItemListener myItemListener) {
        this.myItemListener = myItemListener;
    }

    class MyHolderView extends RecyclerView.ViewHolder {
        private TextView itemContent;
        private View itemView;

        public MyHolderView(View itemView) {
            super(itemView);
            this.itemView = itemView;
            itemContent = (TextView) itemView.findViewById(R.id.itemContent);
        }
    }
}
