package com.example.anju.angelwatches;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anju.angelwatches.adapters.ShopRecyclerViewAdapter;
import com.example.anju.angelwatches.entities.ProductObject;
import com.example.anju.angelwatches.helpers.MySharedPreference;
import com.example.anju.angelwatches.helpers.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {

    private static final String TAG = ShoppingActivity.class.getSimpleName();

    private RecyclerView shoppingRecyclerView;

    private int cartProductNumber = 0;

    private MySharedPreference sharedPreference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        shoppingRecyclerView = (RecyclerView)findViewById(R.id.product_list);
        GridLayoutManager mGrid = new GridLayoutManager(ShoppingActivity.this, 2);
        shoppingRecyclerView.setLayoutManager(mGrid);
        shoppingRecyclerView.setHasFixedSize(true);
        shoppingRecyclerView.addItemDecoration(new SpacesItemDecoration(2, 12, false));

        ShopRecyclerViewAdapter shopAdapter = new ShopRecyclerViewAdapter(ShoppingActivity.this, getAllProductsOnSale());
        shoppingRecyclerView.setAdapter(shopAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile1, menu);
        return true;
    }



    public boolean onOptionsItemSelected(MenuItem item1) {
        {
            Intent shoppingIntent = new Intent(ShoppingActivity.this, OurStoreActivity.class);
            startActivity(shoppingIntent);
        }
        int id = item1.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_item2) {
            return true;
        }

        return super.onOptionsItemSelected(item1);
    }




    private List<ProductObject> getAllProductsOnSale(){
        List<ProductObject> products = new ArrayList<ProductObject>();
        products.add(new ProductObject(1, "Men1", R.drawable.men10, "Beautiful sleek black metal strap mixed with golden chips", 20, 38, "Black"));
        products.add(new ProductObject(1, "Kids1", R.drawable.kids2, "Beautiful fibric black strap for kids with lights, easy to handle.", 20, 38, "Black"));
        products.add(new ProductObject(1, "Women1", R.drawable.men3, "Beautiful durable sleek black strap for women with nice look", 20, 38, "Black"));
        products.add(new ProductObject(1, "Kids2", R.drawable.kids4, "Batman watch for kids with nice digital display", 20, 38, "Black"));
        products.add(new ProductObject(1, "Women2", R.drawable.men2, "Beautiful sleek black strap with with golden dial", 20, 38, "Black"));
        products.add(new ProductObject(1, "Women3", R.drawable.women8, "Beautiful black metallic strap mixed with rose gold chips", 20, 38, "Multi-color"));
        return products;
    }

    public static ShoppingActivity newInstance() {
        ShoppingActivity fragment = new ShoppingActivity();
        return fragment;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_shopping, container, false);
    }


}


