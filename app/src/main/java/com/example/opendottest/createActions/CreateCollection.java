package com.example.opendottest.createActions;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.opendottest.R;
import com.example.opendottest.Close;

public class CreateCollection extends CreateMenu{

    private ImageView closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_collection);

        closeButton = (ImageView) findViewById(R.id.ic_close);

        Close.setCloseButton(closeButton, this);
    }
}
