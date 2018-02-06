/* */

package com.example.android.miwok;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Log.v("SimpleFragmentPagerA", "going for 0");
            return new NumbersFragment();
        } else if (position == 1){
            Log.v("SimpleFragmentPagerA", "going for 1");
            return new ColorsFragment();
        } else if (position == 2) {
            Log.v("SimpleFragmentPagerA", "going for 2");
            return new FamilyFragment();
        } else {
            Log.v("SimpleFragmentPagerA", "going for 3");
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}