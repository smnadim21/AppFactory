package com.smnadim21.food1.advert;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smnadim21.food1.CatItem;
import com.smnadim21.food1.Contents;
import com.smnadim21.food1.advert.datamodel.Status;
import com.smnadim21.food1.advert.retrofit.APIInterface;
import com.smnadim21.food1.advert.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.smnadim21.food1.advert.SP.getCacheData;
import static com.smnadim21.food1.advert.bdapps.Robi.APP_ID;
import static com.smnadim21.food1.advert.bdapps.Robi.APP_PATH;


public class AdsLib {

    public static void checkSubStatus(String code) {


        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Call<Status> call = apiInterface.getStatus(code);


        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {

                Log.e("response", response.toString());
                if (response.body() != null) {


                    if (response.body().getStat()) {
                        SP.setSubscriptionStatus(false);
                        Toast.makeText(AppConfig.getContext(), "Subscription Status True", Toast.LENGTH_SHORT).show();
                    } else {
                        SP.setSubscriptionStatus(true);
                        Toast.makeText(AppConfig.getContext(), "not a valid subscriber", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                SP.setSubscriptionStatus(true);
                // Toast.makeText(AppConfig.getContext(), "Status Getting Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public static void subscribe() {
        RetrofitClientInstance.getRetrofitInstance()
                .create(APIInterface.class)
                .subscribe(APP_ID, APP_PATH)
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("response", response.toString());

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("error", t.toString());

                    }
                });
    }


    public static String dummyContent()
    { Contents contents = new Contents();

    contents.setApp_id("APP_016187");
    contents.setSms_keyword("start ballu");
    contents.setUssd_code("*213*5053#");

        List <CatItem> catItems = new ArrayList<>();
        catItems.add( new CatItem(
                "No Internet",
                "Failed to load Data",
                "",
                "Please Turn on Internet"));
    contents.setContents(catItems);


    return new Gson().toJson(contents);
    }


    public  static  Contents getCacheContents()

    {
        return new Gson().fromJson(getCacheData().equals("none")?dummyContent():getCacheData(),Contents.class);
    }




   /* public static void  showDialog(final Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.s);



        final LinearLayout ll_submit = dialog.findViewById(R.id.ll_code);
        LinearLayout ll_msg = dialog.findViewById(R.id.ll_sub);

        final EditText getCode = dialog.findViewById(R.id.editText_getCode);

        Button dialogButton = (Button) dialog.findViewById(R.id.button_sendSMS);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Uri uri = Uri.parse("smsto:21213");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "start abcd");
                activity.startActivity(intent);
                dialog.dismiss();

            }
        });


        dialog.findViewById(R.id.button_submit)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ll_submit.setVisibility(View.VISIBLE);
                    }
                });


        dialog.findViewById(R.id.button_code)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getCode.getText().toString().isEmpty()) {
                            Toast.makeText(activity, "Write a vald code", Toast.LENGTH_SHORT).show();
                        } else {
                            SP.setSubCode(getCode.getText().toString());
                            SP.setSubscriptionClicked(false);
                            checkSubStatus(getCode.getText().toString());
                            dialog.dismiss();
                        }

                    }
                });


        dialog.findViewById(R.id.button_cancel)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SP.setSubscriptionClicked(false);
                        dialog.dismiss();
                    }
                });


        dialog.show();

    }*/


}
