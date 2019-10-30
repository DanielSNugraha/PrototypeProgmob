package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LihatDataKelas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_kelas);

        Button resetButton = (Button)findViewById(R.id.btnMatkulMhs);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LihatDataKelas.this);
                builder.setMessage("Mo Keluar Ka ?? ")

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(LihatDataKelas.this, "Rasido to ?", Toast.LENGTH_SHORT).show();
                            } })

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(LihatDataKelas.this,HomeScreenMahasiswa.class);
                                startActivity(i);
                            } });
                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }
    }

