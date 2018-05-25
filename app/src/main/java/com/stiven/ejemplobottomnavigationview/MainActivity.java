package com.stiven.ejemplobottomnavigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home Touched",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_tab2:
                        Toast.makeText(MainActivity.this, "Tab2 Touched",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_tab3:
                        Toast.makeText(MainActivity.this, "Tab3 Touched",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
