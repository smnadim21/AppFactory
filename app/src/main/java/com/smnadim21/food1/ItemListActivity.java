package com.smnadim21.food1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.smnadim21.food1.adapter.TopicsAdapter;
import com.smnadim21.food1.advert.retrofit.APIInterface;
import com.smnadim21.food1.advert.retrofit.FactoryAPIInterface;
import com.smnadim21.food1.advert.retrofit.RetrofitClientInstance;
import com.smnadim21.food1.advert.tools.InternetCheck;
import com.smnadim21.food1.advert.tools.NetworkTools;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.smnadim21.food1.advert.AdsLib.getCacheContents;
import static com.smnadim21.food1.advert.SP.setCacheData;
import static com.smnadim21.food1.advert.bdapps.Robi.APP_UNIQUE_KEY;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<CatItem> myDataset = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);


        setTitle(getResources().getString(R.string.app_name));


        Log.e("FACTORY","Calling");




        if (NetworkTools.getConnectivityStatus(getActivity()) == NetworkTools.TYPE_MOBILE
                || NetworkTools.getConnectivityStatus(getActivity()) == NetworkTools.TYPE_WIFI) {
            new InternetCheck(new InternetCheck.Consumer() {
                @Override
                public void accept(Boolean internet) {

                    if (internet) {

                        myDataset.clear();
                        RetrofitClientInstance.getFactoryInstance()
                                .create(FactoryAPIInterface.class)
                                .getcontent(APP_UNIQUE_KEY)
                                .enqueue(new Callback<Contents>() {
                                    @Override
                                    public void onResponse(Call<Contents> call, Response<Contents> response) {

                                        Log.e("FACTORY",response.toString());
                                        Log.e("FACTORY",new Gson().toJson(response.body()));

                                        if(response.body()!=null && response.code()==200)
                                        {
                                            Contents contents = response.body();
                                            setCacheData(new Gson().toJson(contents));
                                            myDataset.addAll(contents.getContents());
                                            mAdapter.notifyDataSetChanged();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Contents> call, Throwable t) {

                                    }
                                });

                    } else {


                        myDataset.addAll(getCacheContents().getContents());

                        //goToError(getActivity(), ERROR_NO_INTERNET);
                    }
                }
            });
        } else {
            myDataset.addAll(getCacheContents().getContents());
        }











   /*     for( int i = 0 ; i < myDataset.size();i++ )
        {
            FirebaseDatabase.getInstance().getReference()
                    .child("bdArcheology")
                    .child("bdArcheology_" + i)
                    .setValue(myDataset.get(i));
        }
*/

         recyclerView = (RecyclerView) findViewById(R.id.rv_main);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

         mAdapter = new TopicsAdapter(this,myDataset);
         recyclerView.setAdapter(mAdapter);
    }


     Activity getActivity()
     {
         return ItemListActivity.this;
     }



}
