package com.example.recyclerviewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {
    public static final String EXTRA_NAME =
            "com.example.recyclerviewproject.EXTRA_NAME";
    public static final String EXTRA_MARK =
            "com.example.recyclerviewproject.EXTRA_MARK";


    private EditText editTextNume;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextNume = findViewById(R.id.nume);
        numberPicker = findViewById(R.id.number_picker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add User");

    }
    private void saveUser(){
        String nume = editTextNume.getText().toString();
        int nota =numberPicker.getValue();
        if(nume.trim().isEmpty()){
            Toast.makeText(this, "Please insert a name", Toast.LENGTH_SHORT).show();
            return;}
        Intent data = new Intent();
        data.putExtra(EXTRA_NAME,nume);
        data.putExtra(EXTRA_MARK,nota);
        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_user_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_user: saveUser(); return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
