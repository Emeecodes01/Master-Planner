package com.example.user.masterplanner.Remainder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
    private RemainderViewHolder viewHolder;
    private int position;

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
        this.viewHolder = holder;
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view){
                setPosition(holder.getAdapterPosition());
                ((AppCompatActivity)context).startSupportActionMode(actionModeCallBacks);
                return false;
            }
        });
    }

    ActionMode.Callback actionModeCallBacks = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu){
            ((AppCompatActivity)context).getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.share:
                    Toast.makeText(context, "share", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.delete:
                    Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.edit:
                    Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

    public RemainderViewHolder getViewHolder(){
        return viewHolder;
    }

    public void setPosition(int pos){
        this.position = pos;
    }

    public int getPosition(){
        return position;
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
            String amOrPm = "AM";
            int hour = remainderList.get(position).getHour();
            int mins = remainderList.get(position).getMinutes();
            String mHour = "", mMinutes = "";

            if (hour > 12){
                amOrPm = "PM";
                hour = hour - 12;
            }

            if (hour < 10){
                mHour = "0"+hour;
                if (mins < 10){
                    mMinutes = "0"+mins;
                }else {
                    mMinutes = ""+mins;
                }
            }
            String time = mHour+ ":" +mMinutes + amOrPm;
            remainderTime.setText(time);
        }

        private void setUpTitle(String title){
            String firstLetter = String.valueOf(getFirstLetter(title)).toUpperCase();
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