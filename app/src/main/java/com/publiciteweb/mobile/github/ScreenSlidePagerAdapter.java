package com.publiciteweb.mobile.github;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sun on 17-04-11.
 */

public class ScreenSlidePagerAdapter  extends FragmentStatePagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return ScreenSlidePageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return Activity_ficheJournaliere.NOMBRE_PAGES;
    }
}
