package ukdw.com.prototypeprogmob.;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeScreenAdmin extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.Oprnbrowser){
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeScreenAdmin.this);
            builder.setMessage("Apakahh anda yakin untuk Logout ??")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(HomeScreenAdmin.this, "Tidak Logout", Toast.LENGTH_SHORT).show(); } })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int which)
                    { Toast.makeText(HomeScreenAdmin.this, "Behasil Logout !!", Toast.LENGTH_SHORT).show();
                        SharedPreferences prefs = HomeScreenAdmin.this.getSharedPreferences
                                ("prefs_file", MODE_PRIVATE);
                        String statusLogin = prefs.getString
                                ("isLogin", null);
                        SharedPreferences.Editor edit = prefs.edit();
                        edit.putString("isLogin", null);
                        edit.commit();
                        Intent intent = new Intent(HomeScreenAdmin.this,MainActivity.class);
                        startActivity(intent);
                    }});
            AlertDialog dialog = builder.create(); dialog.show();
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_isi);
        this.setTitle("SI KRS - HAI Mhs");

        ImageButton Daftardosen = findViewById(R.id.imageButton7);
        Daftardosen.setOnClickListener(btnDosen);

        ImageButton DaftarMahasiswa = findViewById(R.id.imageButton5);
        DaftarMahasiswa.setOnClickListener(btnmhs);

        ImageButton Daftarmatkul= findViewById(R.id.imageButton6);
        Daftarmatkul.setOnClickListener(btnmatkul);

        ImageButton Daftarkelola = findViewById(R.id.imageButton4);
        Daftarkelola.setOnClickListener(btnkelolakrs);


    }
    private View.OnClickListener btnDosen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(HomeScreenAdmin.this, LihatDataDosen.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmhs  = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(HomeScreenAdmin.this, LihatDataMhsActivity.class);
            startActivity(intent);
        }
    };
    private  View.OnClickListener btnmatkul = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(HomeScreenAdmin.this, LihatDataMatkul.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnkelolakrs = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(HomeScreenAdmin.this, LihatDataKrs.class);
            startActivity(intent);
        }
    };
}
