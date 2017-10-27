package se.testviewpager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import se.testviewpager.fragments.SearchFragment;
import se.testviewpager.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity implements OnInteractionListener {

    private ViewPager viewPager;
    private SimpleFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        this.viewPager = viewPager;
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getFragmentManager());
        this.adapter = adapter;
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void openSearch() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flow_root_frame, new SearchFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null).commit();
    }

    @Override
    public void openSettings() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.profile_root_frame, new SettingsFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        OnBackPressedListener currentFragment = (OnBackPressedListener) adapter.getRegisteredFragment(viewPager.getCurrentItem());

        if (currentFragment == null || !currentFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
