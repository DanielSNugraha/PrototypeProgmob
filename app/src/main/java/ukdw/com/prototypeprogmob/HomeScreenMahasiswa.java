package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreenMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_mahasiswa);

        Button resetButton = (Button)findViewById(R.id.btnExit);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeScreenMahasiswa.this);
                builder.setMessage("Mo Keluar Ka ?? ")

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(HomeScreenMahasiswa.this, "Rasido to ?", Toast.LENGTH_SHORT).show();
                            } })

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(HomeScreenMahasiswa.this,LoginActivity.class);
                                startActivity(i);
                            } });
                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }


    public void DataDiriMhs(View view){
        Intent i = new Intent(HomeScreenMahasiswa.this,LihatDataMhsActivity.class);
        startActivity(i);
        }
    public void DaftarKrs(View view){
        Intent i = new Intent(HomeScreenMahasiswa.this,LihatDataKrs.class);
        startActivity(i);
    }
    public void LihatKelas (View view){
        Intent i = new Intent(HomeScreenMahasiswa.this,LihatDataKelas.class);
        startActivity(i);
    }

}
