package com.mitron57.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mitron57.lifecycle.databinding.ElementsBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ElementsBinding bindings = ElementsBinding.inflate(getLayoutInflater());
        setContentView(bindings.getRoot());
        bindings.Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = false;
                for (int i = 0; i < bindings.Items1.getChildCount(); ++i) {
                    View item = bindings.Items1.getChildAt(i);
                    if (item instanceof CheckBox) {
                        if (((CheckBox) item).isChecked()) {
                            checked = true;
                            break;
                        }
                    }
                }
                if (!checked) {
                    for (int i = 0; i < bindings.Items2.getChildCount(); ++i) {
                        View item = bindings.Items2.getChildAt(i);
                        if (item instanceof CheckBox) {
                            if (((CheckBox) item).isChecked()) {
                                checked = true;
                                break;
                            }
                        }
                    }
                }
                if (checked) {
                    Toast.makeText(
                            MainActivity.this,
                            "Ваш заказ был оформлен, спасибо за покупку!",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Ваша корзина пуста!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
        bindings.Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < bindings.Items1.getChildCount(); ++i) {
                    View child = bindings.Items1.getChildAt(i);
                    if (child instanceof CheckBox) {
                        ((CheckBox) child).setChecked(false);
                    }
                }
                for (int i = 0; i < bindings.Items2.getChildCount(); ++i) {
                    View child = bindings.Items2.getChildAt(i);
                    if (child instanceof CheckBox) {
                        ((CheckBox) child).setChecked(false);
                    }
                }
                for (int i = 0; i < bindings.Delivery.getChildCount(); ++i) {
                    View child = bindings.Delivery.getChildAt(i);
                    if (child instanceof RadioButton) {
                        ((RadioButton) child).setChecked(false);
                    }
                }
                bindings.OrderComments.setText("");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(
                this,
                "ААААААААААААА РАЗРАБУ ДЕНЯК НЕ ДАЛИ И МЫ СЕЙВИТЬ НЕ УМЕЕМ",
                Toast.LENGTH_SHORT
        ).show();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}