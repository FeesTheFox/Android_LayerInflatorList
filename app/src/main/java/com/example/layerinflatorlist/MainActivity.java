package com.example.layerinflatorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.layerinflatorlist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String[] name = { "Киса", "Мося", "Кеша", "Рыжий",
            "Саймон", "Рокки", "Гудвин", "Том", "Гоша", "Генри", "Барсик", "Бреня"};

    String[] breed = { "Мейн-кун", "Сфинкс", "Норвежская", "Б/п",
            "Манчкин", "Персидская", "Британская", "Бенгальская",
            "Абиссинская", "Сибирская", "Вислоухая", "Бурма"};

    int[] age = { 1, 10, 5, 17, 2, 8, 3, 8, 10, 15, 16, 17};

    int[] colors = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors[0] = Color.parseColor("#A8E4A0");
        colors[1] = Color.parseColor("#DCD36A");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout); // inflating the Linear Layout
        LayoutInflater ltInflater= getLayoutInflater(); // Getting the XML file

        for (int i = 0; i < name.length; i++){
            //Getting the item.xml layout
            View item = ltInflater.inflate(R.layout.item, linLayout, false); //viewing the pet's names
            TextView tvName = (TextView) item.findViewById(R.id.tvName); // finding the tvName by Id
            tvName.setText(name[i]); //Setting the Text of the TextView

            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition); //view the pet's breed
            tvPosition.setText("Порода: " + breed[i]);

            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary); //view the pet's age
            tvSalary.setText("Возраст: " + String.valueOf(age[i]));

            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i%2]);
            linLayout.addView(item);
        }
    }
}