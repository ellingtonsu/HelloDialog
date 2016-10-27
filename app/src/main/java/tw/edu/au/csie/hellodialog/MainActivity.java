package tw.edu.au.csie.hellodialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button vBtStdAlert, vBtVarAlert, vBtCustomAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vBtStdAlert = (Button)findViewById(R.id.bt_std_alert);
        vBtVarAlert = (Button)findViewById(R.id.bt_var_alert);
        vBtCustomAlert = (Button)findViewById(R.id.bt_cusom_laert);

        vBtStdAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Standard Alert Dialog");
                builder.setMessage("Standard alert dialog message ...");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        vBtVarAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] items = {"Choice 1", "Choice 2", "Choice 3"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Variant Alert Dialog");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        vBtCustomAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText vEtInput;
                ImageView vIvAndroid;
                LayoutInflater inflater = getLayoutInflater();
                View dialog_layout = inflater.inflate(R.layout.custom_alert_dialog_layout,(ViewGroup)findViewById(R.id.custom_layout));
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(dialog_layout);
                final AlertDialog dialog = builder.create();

                vEtInput = (EditText) dialog_layout.findViewById(R.id.et_input);
                vIvAndroid = (ImageView)dialog_layout.findViewById(R.id.iv_android);
                vIvAndroid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mText = vEtInput.getText().toString();
                        Toast.makeText(MainActivity.this, mText, Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

}
