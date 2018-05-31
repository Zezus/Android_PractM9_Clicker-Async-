package com.example.Pract_M9_AsyncTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter;
    private MainAsyncTask mainAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void count(View view) {
        if (mainAsyncTask == null || mainAsyncTask.getStatus().equals(AsyncTask.Status.FINISHED)) {
            counter = 0;
            mainAsyncTask = new MainAsyncTask();
            mainAsyncTask.execute();
        }

        counter++;
    }

    class MainAsyncTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return counter;
        }

        @Override
        protected void onPostExecute(Integer i) {
            Toast.makeText(MainActivity.this, "Вы нажали кнопку " + i + " раз(а)", Toast.LENGTH_SHORT).show();
        }
    }
}
