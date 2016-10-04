package id.sch.smktelkom_mlg.tugas01.xrpl3010.formdoge;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText NamaDoge, NamaPemilik, Email;
    RadioGroup kelamin;
    RadioButton laki, perempuan;
    Spinner asal;
    CheckBox bernafas, berenang, makan, maindiluar;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NamaDoge = (EditText) findViewById(R.id.editNamaDoge);
        NamaPemilik = (EditText) findViewById(R.id.editNamaPemilik);
        Email = (EditText) findViewById(R.id.editEmail);
        kelamin = (RadioGroup) findViewById(R.id.rgKelamin);
        laki = (RadioButton) findViewById(R.id.radioLaki);
        perempuan = (RadioButton) findViewById(R.id.radioPerempuan);
        asal = (Spinner) findViewById(R.id.spinnerDaerah);
        bernafas = (CheckBox) findViewById(R.id.cbBernafas);
        berenang = (CheckBox) findViewById(R.id.cbBerenang);
        makan = (CheckBox) findViewById(R.id.cbMakan);
        maindiluar = (CheckBox) findViewById(R.id.cbMainDiluar);
        send = (Button) findViewById(R.id.sebarkan);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verify();
            }
        });
    }

    private void verify(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Peringatan!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        if(NamaDoge.getText().length() == 0){
            dialog.setMessage("Doge belum di isi");
            dialog.create().show();
        }
        else if(Email.getText().length() == 0){
            dialog.setMessage("I Mel belom di isi");
            dialog.create().show();
        }
        else if (kelamin.getCheckedRadioButtonId() == -1)
        {
            dialog.setMessage("Kelamin belum dipilih");
            dialog.create().show();
        }
        else if (!bernafas.isChecked() || !berenang.isChecked() || !makan.isChecked() || !maindiluar.isChecked()){
            dialog.setMessage("Hobi belum dipilih");
            dialog.create().show();
        }
        else if(asal.getSelectedItemId() == 0){
            dialog.setMessage("Pilih asal Doge");
            dialog.create().show();
        }else{
            dialog.setTitle("Sankyu");
            dialog.setMessage("Terima kasih telah mengisi");
            dialog.create().show();
        }
    }

}
