package com.example.bakibillah.imageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{
    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hash_file_maps = new HashMap<String ,String >();
        sliderLayout = (SliderLayout)findViewById(R.id.daimajia_slider_image);

        
        Hash_file_maps.put("Five ways we can futureproof education in Bangladesh","http://blog.brac.net/wp-content/uploads/2017/10/cover-photo1.jpg");
        Hash_file_maps.put("Children from one of the BRAC schools in Douladia Ghat","http://blog.brac.net/wp-content/uploads/2015/06/edited_MG_4498.jpg");
        Hash_file_maps.put("Pre-Primary and Primary Education","http://www.vercbd.org/images/shikhon-school.jpg");
        Hash_file_maps.put("Letting girls grow up to be who they want to be","http://blog.brac.net/wp-content/uploads/2014/10/10web.jpg");
        Hash_file_maps.put("A Nutritious Snack Makes School More Attractive","https://www.wfp.org/sites/default/files/imagecache/photo_collection_image/BGD_20130722_WFP_Kauser%20Haider_MG_1948.jpg");

        for (String name: Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView.description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            sliderLayout.addSlider(textSliderView);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(3000);
            sliderLayout.addOnPageChangeListener(this);
        }


    }

    @Override
    protected void onStop() {
        sliderLayout.startAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(MainActivity.this,slider.getBundle().get("extra")+"",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("slider demo","page Chanaged: "+ position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
