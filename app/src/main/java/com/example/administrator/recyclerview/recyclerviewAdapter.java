package com.example.administrator.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/12/19.
 */
public class recyclerviewAdapter extends RecyclerView.Adapter<recyclerviewAdapter.MyViewHoder>{

    private ArrayList<Integer> mlist=new ArrayList<>();
    private Context mcontext;
    private boolean tag;

    public recyclerviewAdapter(ArrayList<Integer> mlist, Context context,boolean tag) {
        this.mlist = mlist;
        this.mcontext=context;
        this.tag=tag;
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.recyclerivewlayout,null);
        MyViewHoder viewHoder=new MyViewHoder(view);

        return viewHoder;
    }


    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
           holder.tv.setText(mlist.get(position)+"");
        if(tag){
            ViewGroup.LayoutParams param = holder.tv.getLayoutParams();
            param.height= (int) (100+Math.random()*300);
            holder.tv.setLayoutParams(param);
        }

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyViewHoder extends RecyclerView.ViewHolder{

        private final TextView tv;

        public MyViewHoder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}