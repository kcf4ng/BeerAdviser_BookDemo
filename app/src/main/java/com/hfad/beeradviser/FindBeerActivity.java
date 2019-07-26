package com.hfad.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {

    BeerExpert expert = new BeerExpert();

    public void onClickFindBeer(View view){
        String beerType = String.valueOf(color.getSelectedItem());
//        brands.setText(beerType);

        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand : brandList){
            brandsFormatted.append(brand).append("\n");
        }

        brands.setText(brandsFormatted);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
        InitialComponent();
    }

    private void InitialComponent() {
        brands = findViewById(R.id.brands);
        color = findViewById(R.id.color);
    }

    Spinner color;
    TextView brands;
}
