package ukdw.com.prototypeprogmob;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import ukdw.com.prototypeprogmob.R;

public class CreateKrs extends AppCompatActivity {
    private Spinner spinner1;
    private static final String[] dosen = {"Jong Jek Siang","Argo Wibowo","Budi Sutedjo","Umi Proboyekti","Yetli Oslan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_krs);
        this.setTitle("SI KRS - Hai Admin");

        spinner1 = (Spinner)findViewById(R.id.spinnerDosen);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(CreateKrs.this,android.R.layout.simple_spinner_item,dosen);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

//        Button btnSimpanKrs = (Button)findViewById(R.id.btnSimpanKrs);
//        btnSimpanKrs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CreateKrsActivity.this, HomeAdmin.class);
//                startActivity(intent);
//            }
//        });

        Button btnSimpan = (Button)findViewById(R.id.btnSimpanKrs);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateKrs.this);

                builder.setMessage("Apakah anda yakin untuk menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CreateKrs.this, "Batal Simpan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(CreateKrs.this, HomeScreenAdmin.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }
}
