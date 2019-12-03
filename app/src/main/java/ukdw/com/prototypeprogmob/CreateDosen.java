package ukdw.com.prototypeprogmob;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ukdw.com.prototypeprogmob.Model.Dosen;
import ukdw.com.prototypeprogmob.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response; //menghasilkan data JSON
import ukdw.com.prototypeprogmob.Network.GetDataService;
import ukdw.com.prototypeprogmob.Network.RetrofitClientInstance;

public class CreateDosen extends AppCompatActivity {

    EditText edtNama, edtNidn, edtAlamat, edtEmail, edtGelar;
    GetDataService service;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dosen);
        this.setTitle("SI KRS - Hai Admin");
//        Button btnDaftarKrs = (Button)findViewById(R.id.btnSimpanDosen);
//        btnDaftarKrs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(CreateDosenActivity.this, HomeAdmin.class);
//                startActivity(intent);
//            }
//        });

        Button btnSimpan = (Button)findViewById(R.id.btnSimpanDosen);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CreateDosen.this);

                builder.setMessage("Apakah anda yakin untuk menyimpan?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CreateDosen.this, "Batal Simpan", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                requestInsertDosen();
                            }
                        });

                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }

    private void requestInsertDosen(){
        edtNama = (EditText)findViewById(R.id.edtNamaDsn);
        edtNidn = (EditText)findViewById(R.id.edtNidn);
        edtAlamat = (EditText)findViewById(R.id.edtAlamatDsn);
        edtEmail = (EditText)findViewById(R.id.edtEmailDsn);
        edtGelar = (EditText)findViewById(R.id.edtGelar);
        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        progressDialog =  ProgressDialog.show(this, null, "Harap Tunggu...", true, false);

        Call<Dosen> call =  service.insert_dosen(edtNama.getText().toString(),edtNidn.getText().toString(),
                edtAlamat.getText().toString(),edtEmail.getText().toString(),edtGelar.getText().toString(),"https://picsum.photos/200",
                "72170177");
        call.enqueue(new Callback<Dosen>() {
            @Override
            public void onResponse(Call<Dosen> call, Response<Dosen> response) {
                progressDialog.dismiss();
                Toast.makeText(CreateDosen.this,"Berhasil Insert",Toast.LENGTH_LONG).show();
                Intent refresh = new Intent(CreateDosen.this, RecyclerViewDaftarDosen.class);
                startActivity(refresh);
                finish();

            }

            @Override
            public void onFailure(Call<Dosen> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(CreateDosen.this,"Error cuy",Toast.LENGTH_SHORT);
            }
        });
    }
}
