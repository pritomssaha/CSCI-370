package edu.qc.seclass.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double checkAmount;
    private int partySize;
    private EditText checkAmountValue;
    private EditText partySizeValue;
    private Button computeButton;
    private EditText percent15Tip;
    private EditText percent20Tip;
    private EditText percent25Tip;
    private EditText percent20Total;
    private EditText percent15Total;
    private EditText percent25Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        computeButton = findViewById(R.id.buttonCompute);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkAmountValue.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }
                else if (partySizeValue.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_LONG).show();
                }
                else if(Integer.valueOf(partySizeValue.getText().toString()) == 0) {
                    Toast.makeText(getApplicationContext(), "Invalid party size", Toast.LENGTH_LONG).show();
                }
                else{
                    percent15Tip = findViewById(R.id.fifteenPercentTipValue);
                    percent20Tip = findViewById(R.id.twentyPercentTipValue);
                    percent25Tip = findViewById(R.id.twentyfivePercentTipValue);
                    percent15Tip.setEnabled(false);
                    percent20Tip.setEnabled(false);
                    percent25Tip.setEnabled(false);
                    percent15Total = findViewById(R.id.fifteenPercentTotalValue);
                    percent20Total = findViewById(R.id.twentyPercentTotalValue);
                    percent25Total = findViewById(R.id.twentyfivePercentTotalValue);
                    percent15Total.setEnabled(false);
                    percent20Total.setEnabled(false);
                    percent25Total.setEnabled(false);
                    checkAmount = Double.valueOf(checkAmountValue.getText().toString());
                    partySize = Integer.valueOf((partySizeValue.getText().toString()));

                    int calculateTip15=(int) Math.ceil((checkAmount / partySize) * .15);
                    int calculateTip20=(int) Math.ceil((checkAmount / partySize) * .20);
                    int calculateTip25=(int) Math.ceil((checkAmount / partySize) * .25);
                    percent15Tip.setText(String.valueOf(calculateTip15));
                    percent20Tip.setText(String.valueOf(calculateTip20));
                    percent25Tip.setText(String.valueOf(calculateTip25));
                    int calculateTotalTip15=TotalTipCalculate(checkAmount, partySize, 0.15);
                    int calculateTotalTip20=TotalTipCalculate(checkAmount, partySize, 0.20);
                    int calculateTotalTip25=TotalTipCalculate(checkAmount, partySize, 0.25);
                    percent15Total.setText(String.valueOf(calculateTotalTip15));
                    percent20Total.setText(String.valueOf(calculateTotalTip20));
                    percent25Total.setText(String.valueOf(calculateTotalTip25));
                }
            }
        });
    }
    public int TotalTipCalculate(double checkAmount, int partySize, double percent){
        double tip = ((checkAmount / partySize) * percent);
        int total = (int) Math.ceil((checkAmount / partySize) + tip);
        return  total;
    }
}