package se.testviewpager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import se.testviewpager.fragments.SearchFragment;
import se.testviewpager.fragments.SettingsFragment;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements OnInteractionListener {

    private ViewPager viewPager;
    private SimpleFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getFragmentManager());

        viewPager.setAdapter(adapter);

        this.viewPager = viewPager;
        this.adapter = adapter;

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void openSearch(FragmentManager fragmentManager) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.flow_root_frame, new SearchFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null).commit();
    }

    @Override
    public void openSettings(FragmentManager fragmentManager) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.profile_root_frame, new SettingsFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        OnBackPressedListener currentFragment = (OnBackPressedListener) adapter.getRegisteredFragment(viewPager.getCurrentItem());

        if (currentFragment == null || !currentFragment.onBackPressed()) {
            Timber.d("onBackPressed by Activity");
            super.onBackPressed();
        }
    }
}
