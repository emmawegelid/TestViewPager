package se.testviewpager;

import android.content.Context;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import se.testviewpager.fragments.FirstFragment;
import se.testviewpager.fragments.SecondFragment;
import se.testviewpager.fragments.ThirdFragment;

public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1) {
            return new SecondFragment();
        } else {
            return new ThirdFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.first_title);
            case 1:
                return context.getString(R.string.second_title);
            case 2:
                return context.getString(R.string.third_title);
            default:
                return null;
        }
    }
}
