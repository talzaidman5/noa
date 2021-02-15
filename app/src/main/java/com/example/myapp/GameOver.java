package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatDialogFragment {
    private View view;
    private Button btn_new,menu;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.activity_game_over, null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        menu= view.findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_open_page();
            }
        });
        btn_new= view.findViewById(R.id.btn_new);
        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openMainActivity();
            }
        });
        return dialog;
    }
    public void Open_open_page(){

        Intent intent = new Intent(GameOver.this.getActivity(),open_page.class);
        startActivity(intent);
    }

    public void openMainActivity(){

        Intent intent = new Intent(GameOver.this.getActivity(),MainActivity.class);
        startActivity(intent);
    }

}


