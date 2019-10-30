package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LihatDataKrs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data_krs);

        Button resetButton = (Button)findViewById(R.id.btnKrsMhs);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LihatDataKrs.this);
                builder.setMessage("Mo Keluar Ka ?? ")

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(LihatDataKrs.this, "Rasido to ?", Toast.LENGTH_SHORT).show();
                            } })

                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(LihatDataKrs.this,HomeScreenMahasiswa.class);
                                startActivity(i);
                            } });
                AlertDialog dialog = builder.create(); dialog.show();
            }
        });
    }
}

