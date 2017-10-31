package com.example.jhordan.people_mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.jhordan.people_mvvm.R;
import com.example.jhordan.people_mvvm.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainActivityBinding;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    Log.e("menu", "home");
                    // TODO: 25.10.2017 replase frame on news fragment
                    return true;
                }
                case R.id.navigation_chat: {
                    Log.e("menu", "dashboard");
                    // TODO: 25.10.2017 replase frame on message fragment
                    return true;
                }
                case R.id.navigation_search: {
                    Log.e("menu", "notifications");
                    // TODO: 25.10.2017 replase frame on search
                    return true;
                }
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setSupportActionBar(mainActivityBinding.toolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:{
                Log.e("menu", "1");
                // TODO: 25.10.2017 replase frame on setting fragment
                break;
            }
            case R.id.menu_reference:{
                Log.e("menu", "2");
                // TODO: 25.10.2017 replase frame on reference fragment
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
