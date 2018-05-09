package com.example.user.masterplanner.Remainder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.R;
import java.util.List;

/**
 * Created by emmanuel on 2018-05-08.
 */

public class RemainderAdapter extends RecyclerView.Adapter<RemainderAdapter.RemainderViewHolder>{
    private List<Remainder> remainderList;
    private Context context;

    public RemainderAdapter(Context context, List<Remainder> remainderList){
        this.remainderList = remainderList;
        this.context = context;
    }

    @Override
    public RemainderViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.remainder_item_view, parent, false);
        return new RemainderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemainderViewHolder holder, int position){
        holder.onBindViews(position);
    }

    @Override
    public int getItemCount(){
        return remainderList.size();
    }

    public class RemainderViewHolder extends RecyclerView.ViewHolder{
        private ImageView priorityImageView;
        private TextView priorityTv, remainderTitle, remainderTime;

        public RemainderViewHolder(View itemView){
            super(itemView);
            priorityImageView = itemView.findViewById(R.id.priority_img);
            priorityTv = itemView.findViewById(R.id.priority_tv);
            remainderTitle = itemView.findViewById(R.id.reminder_title);
            remainderTime = itemView.findViewById(R.id.reminder_time);
        }

        public void onBindViews(int position){
            String priority = remainderList.get(position).getPriority();
            String title = remainderList.get(position).getReminderTitle();
            setUpProrityImageView(priority);
            setUpTitle(title);
            setRemainderTime(position);

        }

        private void setRemainderTime(int position){
            int hour = remainderList.get(position).getHour();int mins = remainderList.get(position).getMinutes();
            String time = hour + ":" + mins;
            remainderTime.setText(time);
        }

        private void setUpTitle(String title){
            String firstLetter = String.valueOf(getFirstLetter(title));
            priorityTv.setText(firstLetter);
            remainderTitle.setText(title);
        }

        private char getFirstLetter(String title){
            return title.charAt(0);

        }

        private void setUpProrityImageView(String priority){
            if (priority != null){
                if (priority.equalsIgnoreCase("high")){
                    priorityImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.priority_high));
                }else if (priority.equalsIgnoreCase("medium")){
                    priorityImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.priority_mid));
                }else {
                    priorityImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.priority_low));
                }
            }

        }
    }
}