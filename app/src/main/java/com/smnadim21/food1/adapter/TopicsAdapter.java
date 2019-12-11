package com.smnadim21.food1.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smnadim21.food1.CatItem;
import com.smnadim21.food1.ItemActivity;
import com.smnadim21.food1.R;
import com.smnadim21.food1.advert.SP;

import java.util.List;

import static com.smnadim21.food1.advert.AdsLib.checkSubStatus;
import static com.smnadim21.food1.advert.AdsLib.subscribe;
import static com.smnadim21.food1.advert.SP.setSubCode;
import static com.smnadim21.food1.advert.bdapps.Robi.MSG_TEXT;

public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.MyViewHolder> {
    private List<CatItem> mDataset;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public TopicsAdapter(Context context, List<CatItem> myDataset) {
        mDataset = myDataset;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);

        MyViewHolder vh = new MyViewHolder(v);

    /*    v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mDataset.get())
            }
        });*/

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tv_title.setText(mDataset.get(position).getTitle());
        holder.tv_desc.setText(mDataset.get(position).getDesc().substring(0,mDataset.get(position).getDesc().length()>255?255:mDataset.get(position).getDesc().length()) + ".... ");
        holder.tv_loc.setText(mDataset.get(position).getLoc());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.imageView.setClipToOutline(true);
        }

        Glide.with(context)
                .load(mDataset.get(position).getImage())
                .placeholder(R.drawable.image_8)
                .into(holder.imageView);

        holder.ll_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (SP.getSubscriptionStatus()) {
                    showDialog((Activity) context);
                } else {
                    context.startActivity(new Intent(context, ItemActivity.class)
                            .putExtra("title", mDataset.get(holder.getAdapterPosition()).getTitle())
                            .putExtra("desc", mDataset.get(holder.getAdapterPosition()).getDesc())
                            .putExtra("img", mDataset.get(holder.getAdapterPosition()).getImage())
                            .putExtra("loc", mDataset.get(holder.getAdapterPosition()).getLoc()));
                    ;
                }


                //Toast.makeText(context,mDataset.get(position).getCatName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_title, tv_desc, tv_loc;
        ImageView imageView;
        LinearLayout ll_card;

        public MyViewHolder(View v) {
            super(v);
            tv_title = (TextView) v.findViewById(R.id.item_title);
            tv_desc = (TextView) v.findViewById(R.id.item_desc);
            tv_loc = (TextView) v.findViewById(R.id.item_loc);
            ll_card = v.findViewById(R.id.ll_card);
            imageView = v.findViewById(R.id.image1);
        }
    }

    public void showDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.sub);


        final TextView textView_sub = dialog.findViewById(R.id.textView_sub);
        final TextView textView_sub1 = dialog.findViewById(R.id.textView_sub1);

        Button button_s_daily = dialog.findViewById(R.id.button_s_daily);
        Button button_s_daily_api = dialog.findViewById(R.id.button_s_daily_api);
        final Button bt_send_sms = dialog.findViewById(R.id.bt_send_sms);
        final Button submit_code = dialog.findViewById(R.id.submit_code);

        final LinearLayout ll_sub = dialog.findViewById(R.id.ll_sub);
        final LinearLayout ll_sub_1 = dialog.findViewById(R.id.ll_sub_1);
        final EditText otp_code = dialog.findViewById(R.id.otp_code);


        button_s_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView_sub.setText("সাবস্ক্রাইব করতে আপনার মোবাইল নাম্বার দিন");
                textView_sub1.setText("শুধুমাত্র রবি এবং এয়ারটেল গ্রাহকদের জন্য");
                // ll_sub.setVisibility(View.VISIBLE);
                ll_sub_1.setVisibility(View.GONE);
                bt_send_sms.setVisibility(View.VISIBLE);
                subscribe();

            }
        });

        button_s_daily_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call sub api
            }
        });

        bt_send_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("smsto:21213");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", MSG_TEXT);
                activity.startActivity(intent);
                dialog.dismiss();
            }
        });


        submit_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSubCode(otp_code.getText().toString().isEmpty() ? "111111" : otp_code.getText().toString());
                checkSubStatus(otp_code.getText().toString().isEmpty() ? "111111" : otp_code.getText().toString());
                dialog.dismiss();
            }
        });

        Button dialogButton = (Button) dialog.findViewById(R.id.video_ad);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        dialog.show();

    }
}