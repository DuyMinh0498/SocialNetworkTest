package com.example.socialnetworktest.Activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.socialnetworktest.Adapter.ViewPagerAdapter;
import com.example.socialnetworktest.R;

public class OnboardingWalkthroughScreens extends AppCompatActivity {
    ViewPager slideViewPagers;
    LinearLayout dotsIndicator;
    ViewPagerAdapter viewPagerAdapter;
    Button backButton,skipButton,nextButton;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding_walkthrough_screens);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void setDotsIndicator(int position) {
        dots = new TextView[3];
        dotsIndicator.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.grey,getApplicationContext().getTheme()));
            dotsIndicator.addView(dots[i]);
        }
    }
}