package com.example.myapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;

public class PopActivity extends AppCompatDialogFragment {
    private Button menu, btn_continue, btn_new;
    private View view;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.activity_pop, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        menu = view.findViewById(R.id.menu);
        btn_continue = view.findViewById(R.id.btn_continue);
        btn_new = view.findViewById(R.id.btn_new);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_open_page();
            }
        });
        btn_new = view.findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                MainActivity.stopGame=false;
            }
        });
        return dialog;


}



    public void Open_open_page(){

        Intent intent = new Intent(PopActivity.this.getActivity(),open_page.class);
        startActivity(intent);
    }

    public void openMainActivity(){

        Intent intent = new Intent(PopActivity.this.getActivity(),MainActivity.class);
        startActivity(intent);
    }

}
