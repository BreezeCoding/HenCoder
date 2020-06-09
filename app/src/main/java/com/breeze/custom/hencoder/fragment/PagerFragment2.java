package com.breeze.custom.hencoder.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.breeze.custom.hencoder.R;

public
class PagerFragment2 extends Fragment {

    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;

    public static PagerFragment2 newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
        Log.d("TAG", "newInstance: ");
        PagerFragment2 fragment = new PagerFragment2();
        Bundle argus = new Bundle();
        argus.putInt("sampleLayoutRes", sampleLayoutRes);
        argus.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(argus);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_page_view, container, false);
        ViewStub stub = view.findViewById(R.id.view_stub);
        stub.setLayoutResource(sampleLayoutRes);
        //初始化
        stub.inflate();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "onCreate: ");
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            sampleLayoutRes = arguments.getInt("sampleLayoutRes");
            practiceLayoutRes = arguments.getInt("practiceLayoutRes");
        }
    }
}
