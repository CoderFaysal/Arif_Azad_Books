package com.coderfaysal.arifazadbooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView it_recycle;
    HashMap <String, String> hashMap;
    ArrayList <HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        it_recycle = findViewById(R.id.it_recycle);

        BOOK();

        MyAdapter myAdapter = new MyAdapter();
        it_recycle.setAdapter(myAdapter);
        it_recycle.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));




    }



    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false);


            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            hashMap = arrayList.get(position);

            String title = hashMap.get("title");
            String cover = hashMap.get("cover");
            String bookURL = hashMap.get("url");

            Picasso.get().load(cover).into(holder.it_cover);
            holder.it_title.setText(title);


            holder.book_click.setOnClickListener(view -> {

                WebView.BOOK_URL = bookURL;
                startActivity(new Intent(MainActivity.this, WebView.class));

            });



        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder{

            LinearLayout book_click;
            ImageView it_cover;
            TextView it_title;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                book_click = itemView.findViewById(R.id.book_click);
                it_cover = itemView.findViewById(R.id.it_cover);
                it_title = itemView.findViewById(R.id.it_title);


            }
        }

    }



    public void BOOK(){

        hashMap = new HashMap<>();
        hashMap.put("title", "প্যারাডক্সিক্যাল সাজিদ");
        hashMap.put("cover", "https://i.ibb.co/qNzSQj0/image.png");
        hashMap.put("url", "https://drive.google.com/file/d/1_N-FMFj1DsBJfaSmjtA7NrGdcfTylHTY/view?usp=sharing");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "প্যারাডক্সিক্যাল সাজিদ ২");
        hashMap.put("cover", "https://i.ibb.co/nMhNjFC/2.png");
        hashMap.put("url", "https://drive.google.com/file/d/1PnFLPRyi21fSitBylZCGamijkoZoQIWe/view?usp=sharing");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "প্রত্যাবর্তন");
        hashMap.put("cover", "https://i.ibb.co/fYcMq5S/potraborton.png");
        hashMap.put("url", "https://drive.google.com/file/d/1mmgCXjIZluj8nvmqUizu-frf3dZu99NI/view?usp=sharing");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "মা মা ও বাবা");
        hashMap.put("cover", "https://i.ibb.co/GPKqr4q/ma-ma-baba.png");
        hashMap.put("url", "https://drive.google.com/file/d/1svJcT-etCw6QPBq_j4SBFEPeEqb8jFVY/view?usp=sharing");
        arrayList.add(hashMap);


    }


}