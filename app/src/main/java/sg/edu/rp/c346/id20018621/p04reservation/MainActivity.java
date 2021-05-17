package sg.edu.rp.c346.id20018621.p04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname, etnumber, etgroup;
    Button btnReset,btnConfirm;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;
    TextView tvname, tvnumber, tvsize, tvdate, tvtime, tvs;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            dp = findViewById(R.id.datePicker);
            tp = findViewById(R.id.timePicker);
            cb = findViewById(R.id.checkBoxSelection);
            tvname = findViewById(R.id.textViewOutcomeName);
            tvnumber =findViewById(R.id.textViewOutcomeNumber);
            tvsize = findViewById(R.id.textViewOutcomeSize);
            tvdate = findViewById(R.id.textViewOutcomeDate);
            tvtime = findViewById(R.id.textViewOutcomeTime);
            tvs = findViewById(R.id.textViewOutcomeSelection);
            btnReset = findViewById(R.id.buttonReset);
            btnConfirm = findViewById(R.id.buttonConfirm);
            etname = findViewById(R.id.editTextPersonName);
            etnumber = findViewById(R.id.editTextPhoneNumber);
            etgroup = findViewById(R.id.editTextNumberSize);

            dp.updateDate(2021, 5, 1);

            etname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String length = etname.getText().toString();
                    int ilength = Integer.parseInt(length);
                    if (ilength == 0) {
                        Toast.makeText(MainActivity.this, "Cannot have a blank field", Toast.LENGTH_LONG).show();
                        etnumber.setText("");
                    }
                }
            });

            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etname.setText("");
                    etgroup.setText("");
                    etnumber.setText("");
                    cb.setChecked(false);
                    tp.setCurrentHour(20);
                    tp.setCurrentMinute(30);
                    dp.updateDate(2021,05,01);
                    tvname.setText("");
                    tvnumber.setText("");
                    tvdate.setText("");
                    tvsize.setText("");
                    tvs.setText("");
                    tvtime.setText("");
                    Toast.makeText(MainActivity.this,"Reset Clicked", Toast.LENGTH_LONG).show();
                }
            });


            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etname.getText().toString();
                    String phoneNum = etnumber.getText().toString();
                    String pax = etgroup.getText().toString();

                    String isSmoke = "";
                    if (cb.isChecked()){
                        isSmoke = "smoking";
                    }else {
                        isSmoke = "non-smoking";
                    }

                    String date = dp.getYear() + "/" + (dp.getMonth() + 1 )+ "/" + dp.getDayOfMonth();
                    String time = tp.getCurrentHour() + ":" + String.format("%02", tp.getCurrentMinute());

                    String msg = "Hi, " + name + ", you have booked a " + pax + " person(s) " + isSmoke + " Table on " + date
                            + "at " + time + ". Your phone number is " + phoneNum + ".";

                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

                }
            });

        }
    }
