package com.stiven.ejemplobottomnavigationview;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.support.v4.app.Fragment;

import com.stiven.ejemplobottomnavigationview.view.fragment.HomeFragment;
import com.stiven.ejemplobottomnavigationview.view.fragment.Tab2Fragment;
import com.stiven.ejemplobottomnavigationview.view.fragment.Tab3Fragment;

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

        replaceFragment(new HomeFragment());

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.action_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.action_tab2:
                        fragment = new Tab2Fragment();
                        break;
                    case R.id.action_tab3:
                        fragment = new Tab3Fragment();
                        break;
                }
                replaceFragment(fragment);
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }
}
