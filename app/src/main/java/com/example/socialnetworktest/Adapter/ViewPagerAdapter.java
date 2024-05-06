package com.example.socialnetworktest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.socialnetworktest.R;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int sliderAllImages[] = {R.drawable.Img2, R.drawable.img1, R.drawable.img3};
    int sliderAllTitles[] = {R.string.screen1, R.string.screen3, R.string.screen4};
    int sliderAllDescriptions[] = {R.string.title1, R.string.title3, R.string.title4};


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderAllTitles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_screen, container, false);
        ImageView imageView = view.findViewById(R.id.sliderImage);
        TextView title = view.findViewById(R.id.sliderTitle);
        TextView description = view.findViewById(R.id.sliderDesc);
        imageView.setImageResource(sliderAllImages[position]);
        title.setText(this.sliderAllTitles[position]);
        description.setText(this.sliderAllDescriptions[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
