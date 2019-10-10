package cf.ericrocha.whichtosupply;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText gas;
    EditText al;
    TextView result;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gas = findViewById(R.id.ed_gas);
        al = findViewById(R.id.ed_al);
        result = findViewById(R.id.tx_result);
    }
    public void calc(View view){
        if(gas.getText().toString().length() == 0 || al.getText().toString().length() == 0){
            result.setText("");
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton(R.string.al_ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    gas.setText("");
                    al.setText("");
                }
            });
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    gas.setText("");
                    al.setText("");
                }
            });

                builder.setTitle(R.string.al_t);
                builder.setMessage(R.string.al_m);


                alert = builder.create();
                alert.show();
        }else {
            String gast = gas.getText().toString();
            Double gasd = Double.parseDouble(gast);

            String alt = al.getText().toString();
            Double ald = Double.parseDouble(alt);
            double temp;

            temp = ald / gasd;

            if(temp >= 0.7){
                result.setText(R.string.tx_result_1);
            }else{
                result.setText(R.string.tx_result_2);
            }
        }
    }
}
