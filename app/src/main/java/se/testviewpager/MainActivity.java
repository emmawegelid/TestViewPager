package se.testviewpager;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import se.testviewpager.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements OnInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void openSearch() {
        initFragment(new SearchFragment());
    }

    private void initFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .add(R.id.viewpager, fragment)
                .addToBackStack(null)
                .commit();
        getFragmentManager().executePendingTransactions();
    }

    protected boolean canNavigateBack() {
        return getFragmentManager().getBackStackEntryCount() > 0;
    }
}
