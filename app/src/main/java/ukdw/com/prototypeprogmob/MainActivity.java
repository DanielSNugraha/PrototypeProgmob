package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ukdw.com.prototypeprogmob.Model.Mahasiswa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMulai = (Button)findViewById(R.id.btnStart);
        btnMulai.setOnClickListener(btnStart);
    }

    private View.OnClickListener btnStart = new View.OnClickListener()
    { @Override

    public void onClick(View view)
    { Intent intent = new Intent
            (MainActivity.this,LoginActivity.class);
        startActivity(intent);
        }
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = MainActivity.this.getSharedPreferences
                    ("prefs_file", MODE_PRIVATE);
            String statusLogin = prefs.getString
                    ("isLogin", null);
            SharedPreferences.Editor edit = prefs.edit();

            TextView Emailtext = findViewById(R.id.txtEmail);
            if (Emailtext.getText().toString().contains("@si.ukdw.ac.id")) {
                edit.putString("isLogin", "Dosen");
                edit.commit();
                Intent intent = new Intent(MainActivity.this, Mahasiswa.class);
                startActivity(intent);

            } else if (Emailtext.getText().toString().contains("@staff.ukdw.ac.id")) {
                edit.putString("isLogin", "Admin");
                edit.commit();
                Intent intent = new Intent(MainActivity.this, HomeScreenAdmin.class);
                startActivity(intent);
                } else {
            }
        }
    };
}



