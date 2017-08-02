package com.example.ajayj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.ajayj.myapplication.fragments.FifthTabFragment;
import com.example.ajayj.myapplication.fragments.FirstTabFragment;
import com.example.ajayj.myapplication.fragments.FourthTabFragment;
import com.example.ajayj.myapplication.fragments.SecondTabFragment;
import com.example.ajayj.myapplication.fragments.SixthTabFragment;
import com.example.ajayj.myapplication.fragments.ThirdTabFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Tabs Activity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        viewPager= (ViewPager) findViewById(R.id.viewpager1);
        tabLayout= (TabLayout) findViewById(R.id.tablayout1);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        private final List<Fragment> mFragmentList=new ArrayList<>();
        private final List<String> mFragmentTitleList=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment,String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstTabFragment(),"one");
        adapter.addFragment(new SecondTabFragment(),"two");
        adapter.addFragment(new ThirdTabFragment(),"three");
        adapter.addFragment(new FourthTabFragment(),"four");
        adapter.addFragment(new FifthTabFragment(),"five");
        adapter.addFragment(new SixthTabFragment(),"six");
//        adapter.addFragment(new (),"");
        viewPager.setAdapter(adapter);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
                Intent homepage2l=new Intent(TabsActivity.this,StartActivity.class);
                startActivity(homepage2l);
                break;
            default:
                break;
        }


        return true; //super.onOptionsItemSelected(item);
    }


}
