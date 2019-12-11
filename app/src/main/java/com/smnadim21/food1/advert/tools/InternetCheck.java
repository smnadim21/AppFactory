package com.smnadim21.food1.advert.tools;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by d3stR0y3r on 10/14/2018.
 */
public class InternetCheck extends AsyncTask<Void, Void, Boolean> {

    private Consumer mConsumer;
    public  interface Consumer { void accept(Boolean internet); }

    public InternetCheck(Consumer consumer) { mConsumer = consumer; execute(); }

    @Override
    protected Boolean doInBackground(Void... voids) { try {
        Socket sock = new Socket();
        sock.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
        sock.close();
        return true;
    } catch (IOException e) { return false; } }

    @Override
    protected void onPostExecute(Boolean internet) { mConsumer.accept(internet); }
}