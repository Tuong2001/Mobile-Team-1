package com.example.team1viewpagermechanismformanagingfragmentsinandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.team1viewpagermechanismformanagingfragmentsinandroid.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mViewPager = findViewById(R.id.view_paper);
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);

        ViewPaperAdapter adapter = new ViewPaperAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.profile).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.settings).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        mViewPager.setCurrentItem(0);
                        HomeFragment homeFragment = (HomeFragment) mViewPager.getAdapter().instantiateItem(mViewPager,0);
                        homeFragment.reloadData();
                        break;
                    case R.id.search:
                        mViewPager.setCurrentItem(1);
                        SearchFragment searchFragment = (SearchFragment) mViewPager.getAdapter().instantiateItem(mViewPager,1);
                        searchFragment.reloadData();
                        break;
                    case R.id.profile:
                        mViewPager.setCurrentItem(2);
                        ProfileFragment profileFragment = (ProfileFragment) mViewPager.getAdapter().instantiateItem(mViewPager,2);
                        profileFragment.reloadData();
                        break;
                    case R.id.settings:
                        mViewPager.setCurrentItem(3);
                        SettingsFragment settingsFragment = (SettingsFragment) mViewPager.getAdapter().instantiateItem(mViewPager,3);
                        settingsFragment.reloadData();
                        break;
                }
                return true;
            }
        });



    }
}