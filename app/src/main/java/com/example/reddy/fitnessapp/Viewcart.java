package com.example.reddy.fitnessapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.Set;

public class Viewcart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcart);

        Cart cart = CartActivity.m_cart;
        LinearLayout cart_layout = (LinearLayout)findViewById(R.id.cart);
        Set products = cart.getProducts();
        Iterator iterator = products.iterator();
        while(iterator.hasNext()){
            Product product = (Product)iterator.next();
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(linearLayout.HORIZONTAL);
            TextView name = new TextView(this);
            TextView quantity = new TextView(this);
            name.setText(product.getName());
            quantity.setText(Integer.toString(cart.getQuantity(product)));
            linearLayout.addView(name);
            linearLayout.addView(quantity);
            name.setTextSize(20);
            quantity.setTextSize(20);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200, Gravity.CENTER);
            layoutParams.setMargins(20,50,20,50);
            linearLayout.setLayoutParams(layoutParams);
            name.setLayoutParams(new TableLayout.LayoutParams(0, ActionBar.LayoutParams.WRAP_CONTENT,1));
            quantity.setLayoutParams(new TableLayout.LayoutParams(0,ActionBar.LayoutParams.WRAP_CONTENT,1));
            name.setGravity(Gravity.CENTER);
            quantity.setGravity(Gravity.CENTER);
            cart_layout.addView(linearLayout);
        }

    }
}
