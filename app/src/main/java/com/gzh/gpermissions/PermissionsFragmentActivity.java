package com.gzh.gpermissions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PermissionsFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions_fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_permissions_fragment, new PermissionsFragment()).commit();
    }
}
