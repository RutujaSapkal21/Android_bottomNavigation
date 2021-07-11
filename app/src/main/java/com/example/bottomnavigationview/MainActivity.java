package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomnavigation);
        if (savedInstanceState==null){

            loadfragment(new Home());
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        //fragment
                        Home home=new Home();
                        loadfragment(home);
                        break;
                    case R.id.profile:
                        //fragment
                        Profile profile=new Profile();
                        loadfragment(profile);
                        break;
                    case R.id.activity:
                        Activity_Fragment activity=new Activity_Fragment();
                        loadfragment(activity);
                        break;
                }

                return true;
            }
        });
    }

    public void loadfragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment).commit();
    }
}