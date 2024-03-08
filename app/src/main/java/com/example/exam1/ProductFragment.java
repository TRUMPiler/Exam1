package com.example.exam1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {
String titles[]={"Apple Watch Ultra","Titan Endevorz16","olevis mag142"};
String Des[]={"The most rugged and capable Apple Watch pushes the limits again. Featuring the all-new S9 SiP. A magical new way to use your watch without touching the screen. The brightest Apple display ever. And now you can choose a case and strap combination that is carbon neutral.","Keeping every head turn towards it is this glittering piece of art from the Titan Karishma collection. The watch, with a gloss finished case, has a specially shaped dial in champagne colour. It has a unique de-plated design which follows the shape of the dial. The dial also features a studded crystal for the 12-hour mark and gold-coloured dot metal indices for the other marks. The golden colour half kada stainless steel strap completes the style features of this exquisite watch from Titan. Adding value to the watch is the 24 month warranty period.","Rolex timepieces are the most reputable and renowned timepieces in the world today. Invented by Hans Wilsdorf in 1908 and branded under the iconic Rolex name in 1915, these watches epitomize timeless elegance and prestige among all luxury watches."};
ListView ls;
int img[]={R.drawable.img1,R.drawable.img2,R.drawable.img3};
    public ProductFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_product, container, false);
        ls=v.findViewById(R.id.gg);
        adapter aa=new adapter(getContext(),titles,Des,img);
        ls.setAdapter(aa);
        return v;
    }
}