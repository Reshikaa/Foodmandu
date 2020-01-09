package com.reshika.foodmandu.ui.home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.reshika.foodmandu.api.Super;
import com.reshika.foodmandu.model.Detail;
import com.reshika.foodmandu.strictmode.StrictModeClass;
import com.reshika.foodmandu.ui.DetailAdapter;
import com.reshika.foodmandu.ui.FoodAdapter;
import com.reshika.foodmandu.R;
import com.reshika.foodmandu.model.Food;
import com.reshika.foodmandu.url.Url;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.reshika.foodmandu.url.Url.imagePath;

public class HomeFragment extends Fragment {

    List<Detail> detailList;
    DetailAdapter DetailAdapter;
    private HomeViewModel homeViewModel;
    ImageView card1;

    private int[] mImages=new int[]{
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d
    };
    private String [] mImageTitle=new String[]{
            "Liquor","MoMo","Sauce","juice"
    };
    private RecyclerView recyclerView,recyclerView_a;

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
        recyclerView_a=view.findViewById(R.id.recyclerView_a);
        card1=view.findViewById(R.id.card1);

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

        super7();
        return view;
    }

    private void super7(){
        detailList=new ArrayList<>();

        Super s= Url.getInstance().create(Super.class);

        Call<Detail> listCall1=s.getImage(imagePath);

        listCall1.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getActivity(), "Code", Toast.LENGTH_SHORT).show();
                    return;
                }

                String imagepath= imagePath + response.body().getImage();
                StrictModeClass.StrictMode();
                try {
                    URL url= new URL(imagepath);
                    card1.setImageBitmap(BitmapFactory.decodeStream((InputStream)url.getContent()));
                }

                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {

                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Call<List<Detail>> listCall=s.getSuper7();
        listCall.enqueue(new Callback<List<Detail>>() {
            @Override
            public void onResponse(Call<List<Detail>> call, Response<List<Detail>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Detail> detailList1=response.body();
                DetailAdapter =new DetailAdapter(getContext(),detailList1);

                recyclerView_a.setAdapter(DetailAdapter);
                recyclerView_a.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                recyclerView_a.setHasFixedSize(true);

            }

            @Override
            public void onFailure(Call<List<Detail>> call, Throwable t) {

                Log.d("Error Message","Error" + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });



    }
}