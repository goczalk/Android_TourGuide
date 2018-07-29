package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by klaudia on 29/07/18.
 */

public class CategoryAdapter extends FragmentPagerAdapter  {

    public static final int PAGE_COUNT = 4;
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_events);
        } else if (position == 1) {
            return mContext.getString(R.string.category_food);
        } else if (position == 2) {
            return mContext.getString(R.string.category_museums);
        } else {
            return mContext.getString(R.string.category_other);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }
}
