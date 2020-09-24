package com.example.beats_musicapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.beats_musicapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    int headings[] = {R.string.first_slide_title, R.string.second_slide_title, R.string.third_slide_title};

    int descriptions[] = { R.string.first_slide_desc, R.string.second_slide_desc, R.string.third_slide_desc};

    int imageOne[] = {R.drawable.ring_fiilled, R.drawable.ring_transparent, R.drawable.ring_transparent};
    int imageTwo[] = {R.drawable.ring_transparent, R.drawable.ring_fiilled, R.drawable.ring_transparent};
    int imageThree[] = {R.drawable.ring_transparent, R.drawable.ring_transparent, R.drawable.ring_fiilled};

    int imageOneSub[] = {R.drawable.radio_transparent, R.drawable.radio_filled, R.drawable.radio_filled};
    int imageTwoSub[] = {R.drawable.heart_filled, R.drawable.heart_transparent, R.drawable.heart_filled};
    int imageThreeSub[] = {R.drawable.musical_note_filled, R.drawable.musical_note_filled, R.drawable.musical_note_transparent};

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ScrollView)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);

        TextView heading = view.findViewById(R.id.heading);
        TextView description = view.findViewById(R.id.description);
        ImageView one, one_sub, two, two_sub, three, three_sub;
        one = view.findViewById(R.id.image1);
        one_sub = view.findViewById(R.id.image1_sub);
        two = view.findViewById(R.id.image2);
        two_sub = view.findViewById(R.id.image2_sub);
        three = view.findViewById(R.id.image3);
        three_sub = view.findViewById(R.id.image3_sub);

        heading.setText(headings[position]);
        description.setText(descriptions[position]);
        one.setImageResource(imageOne[position]);
        one_sub.setImageResource(imageOneSub[position]);
        two.setImageResource(imageTwo[position]);
        two_sub.setImageResource(imageTwoSub[position]);
        three.setImageResource(imageThree[position]);
        three_sub.setImageResource(imageThreeSub[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView)object);
    }
}
