package com.reshika.foodmandu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reshika.foodmandu.ui.FoodAdapter;
import com.reshika.foodmandu.R;
import com.reshika.foodmandu.model.Food;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private int[] mImages=new int[]{
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d
    };
    private String [] mImageTitle=new String[]{
            "Liquor","MoMo","Sauce","juice"
    };
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home,container,false);

        CarouselView carouselView;
        carouselView=view.findViewById(R.id.caral);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), mImageTitle[position], Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView=view.findViewById(R.id.recyclerView);

        List<Food> foodList=new ArrayList<>();
        foodList.add(new Food("Restaurants",R.drawable.res));
        foodList.add(new Food("Liquors",R.drawable.liquor));
        foodList.add(new Food("Bakeries",R.drawable.cup));
        foodList.add(new Food("Refreshments",R.drawable.ref));
        foodList.add(new Food("Organics",R.drawable.o));


        FoodAdapter foodAdapter=new FoodAdapter(getContext(),foodList);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return view;
    }
}