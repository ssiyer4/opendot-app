package com.example.opendot_n.createActions;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.opendot_n.Close;
import com.example.opendottest.R;

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
