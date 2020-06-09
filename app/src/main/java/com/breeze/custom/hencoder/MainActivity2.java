package com.breeze.custom.hencoder;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import com.breeze.custom.hencoder.practice.Practice2DrawCircleView;

public class MainActivity2 extends AppCompatActivity {

//    private List<PagerModel> mList = new ArrayList<>();
//
//    {
//        mList.add(new PagerModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color));
//    }

    private static final float MAX_PROGRESS = 60000;
    private static final float TIME = 1000;
    private float progress;
    private Practice2DrawCircleView mPacked;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mPacked = findViewById(R.id.packed);

        mPacked.setMaxProgress(MAX_PROGRESS);
        mPacked.setProgress(progress);
        mPacked.setOnCallBack(new Practice2DrawCircleView.onCallBack() {
            @Override
            public void callback() {
                Log.d("TAG", "callback: ");
            }
        });
//        ViewPager viewPager = findViewById(R.id.view_page_activity2);
//        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        adapter.setAdapterData(mList);
//        viewPager.setAdapter(adapter);
    }

    public void onClick(View view) {
        progress = 0;
        mHandler = App.getInstance();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                progress += TIME;
//                Log.d("TAG", "run: "+progress);
                if (progress <= 60000) {
                    mPacked.setProgress(progress);
                    mHandler.postDelayed(this, 1000);
                }
            }
        });
    }
}