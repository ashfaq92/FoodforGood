package com.jaystiqs.jaydahstudios.feedme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

public class EntityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity);

    }

    public void productTypeClicked(View view){
        View dialog = LayoutInflater.from(this).inflate(R.layout.type_of_product_popup, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();
        Button dismissButton = dialog.findViewById(R.id.dissmissPDialog);
        Button navigateButton = dialog.findViewById(R.id.navigatetoPLocation);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });
    }

    public void productDescClicked(View view){
        View dialog = LayoutInflater.from(this).inflate(R.layout.description_of_product_popup, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();
        Button dismissButton = dialog.findViewById(R.id.dissmissPDialog);
        Button navigateButton = dialog.findViewById(R.id.navigatetoPLocation);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });
    }

    public void quantityClicked(View view){
        View dialog = LayoutInflater.from(this).inflate(R.layout.quantity_popup, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();
        Button dismissButton = dialog.findViewById(R.id.dissmissPDialog);
        Button navigateButton = dialog.findViewById(R.id.navigatetoPLocation);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });
    }

    public void pickupTimeClicked(View view){
        View dialog = LayoutInflater.from(this).inflate(R.layout.pickuptime_popup, null);
        final SwipeDismissDialog swipeDismissDialog = new SwipeDismissDialog.Builder(this)
                .setView(dialog)
                .build()
                .show();
        Button dismissButton = dialog.findViewById(R.id.dissmissPDialog);
        Button navigateButton = dialog.findViewById(R.id.navigatetoPLocation);



        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeDismissDialog.dismiss();
            }
        });
    }

    public void pickupLocationClicked(View view){

    }

    public void profileOpen(View view) {
        Intent intent = new Intent(EntityActivity.this, ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
