package ru.myitschool.mte;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Watchable;

import ru.myitschool.mte.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EditText editText = binding.content.tvResult;
        editText.setBackgroundColor(getResources().getColor(R.color.normal));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                editText.setBackgroundColor(getResources().getColor(R.color.normal));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                    String s= String.valueOf(editText.getText());
                    try {
                        Integer integer = Integer.parseInt(s);
                        if (integer<0){
                            editText.setBackgroundColor(getResources().getColor(R.color.cautious));
                        }
                        else {
                            editText.setBackgroundColor(getResources().getColor(R.color.normal));
                        }

                    } catch (Exception e){
                        editText.setBackgroundColor(Color.BLUE);
                    }




            }

        });
    }
}
