package com.example.testngg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView s_title, t_rules, strt_title, t_introgss;
    private Button btn_start;
    private EditText num_input;
    int trials = 0;
    int maxTrials = 3;
    int number = 1 + (int) (30 * Math.random());
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_input = findViewById(R.id.num_input);
        btn_start = findViewById(R.id.btn_start);
        s_title = findViewById(R.id.s_title);
        t_rules = findViewById(R.id.t_rules);
        strt_title = findViewById(R.id.strt_title);
        t_introgss = findViewById(R.id.t_introgss);


        btn_start.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View arg0){

                s_title.setVisibility(View.INVISIBLE);
                t_rules.setVisibility(View.INVISIBLE);
                btn_start.setVisibility(View.INVISIBLE);

                strt_title.setVisibility(View.VISIBLE);
                t_introgss.setVisibility(View.VISIBLE);
                num_input.setVisibility(View.VISIBLE);
            }
        });

        num_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int guessNum = Integer.parseInt(num_input.getText().toString());

                while (trials <= maxTrials) {
                    if (guessNum == number) {
                        Toast.makeText(MainActivity.this, "You won!", Toast.LENGTH_SHORT).show();
                        break;

                    } else if (guessNum < number && trials < maxTrials) {
                        Toast.makeText(MainActivity.this, "The number is bigger", Toast.LENGTH_SHORT).show();
                        trials++;
                        break;

                    } else if (guessNum > number && trials < maxTrials) {
                        Toast.makeText(MainActivity.this, "The number is smaller", Toast.LENGTH_SHORT).show();
                        trials++;
                        break;
                    }
                }
                if (trials == maxTrials) {
                    Toast.makeText(MainActivity.this, "You dont have more tries", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "The number was " + number, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
