package dexterdatul.com.viewpagerimageslideshow;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    SlideShowAdapter slideShowAdapter;
    ViewPager viewPager;

    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewpager);
        slideShowAdapter = new SlideShowAdapter(this);
        viewPager.setAdapter(slideShowAdapter);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();
                i++;
                viewPager.setCurrentItem(i, true);
                System.out.print(i);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 2000, 2000);

    }
}
