package com.breeze.custom.hencoder.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.breeze.custom.hencoder.fragment.PagerFragment2;
import com.breeze.custom.hencoder.model.PagerModel;

import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private List<PagerModel> mList;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        PagerModel pagerModel = mList.get(position);
        return PagerFragment2.newInstance(pagerModel.getSampleLayoutRes(), pagerModel.getPracticeLayoutRes());
    }

    @Override
    public int getCount() {
        Log.d("TAG", "mList.size(): " + mList.size());
        return Math.max(mList.size(), 0);
    }

    public void setAdapterData(List<PagerModel> list) {
        this.mList = list;
    }
}
