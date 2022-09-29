package com.example.team1customlistviewcardflatlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.team1customlistviewcardflatlist.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.avatar1,R.drawable.avatar2, R.drawable.avatar3,R.drawable.avatar4,
                R.drawable.avatar5, R.drawable.avatar6,R.drawable.avatar7,R.drawable.avatar8,R.drawable.avatar9};
        String[] name = {"Angelina","Cody","Jack","Christina","Harry","Lyly","Mary","Ben","Max"};
        String[] lastMessage = {"Hey, Guys!","Hello, everyone!","Have a nice day!","So funny!",
                "What's up?","How are you?","I'm so blessed","So pretty!","Thanks a lot!"};
        String[] lastmsgTime = {"6:30 am","12:20 am","2:15 pm","4:10 am","6:45 pm","7:30 pm","8:00 pm",
                "9:20 apm","10:30 pm"};
        String[] phoneNo = {"223144155320","3456768901","1234549087","1232450978","3245679800",
                "4456780912","4154759708","1345689078","1243650979"};
        String[] country = {"Germany","Colombia","Brazil","France","United Kingdom",
                "United States of America","Australia","Canada","Italy"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0;i< imageId.length;i++){

            User user = new User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);
            }
        });

    }
}