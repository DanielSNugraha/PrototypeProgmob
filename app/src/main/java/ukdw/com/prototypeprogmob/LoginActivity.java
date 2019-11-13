package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnMasuk = (Button) findViewById(R.id.btnSign);
        btnMasuk.setOnClickListener(btnSign);
    }

    private View.OnClickListener btnSign = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent
                    (LoginActivity.this, HomeScreenMahasiswa.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override public void onClick(View v) {
            SharedPreferences prefs = LoginActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
            String statusLogin = prefs.getString("isLogin",null);
            SharedPreferences.Editor edit = prefs.edit();
            Button btnLogin = (Button)findViewById(R.id.btnSign);
            if (statusLogin != null){ edit.putString("isLogin",null);
            btnLogin.setText("Login"); }
            else{ edit.putString("isLogin","Admin");
            btnLogin.setText("Logout");
            }
            edit.commit();
        }
    };
}

      /* private View.OnClickListener btnSign = new View.OnClickListener()
    { @Override
    public void onClick(View view)
    { Intent intent = new Intent
            (LoginActivity.this,HomeScreenAdmin.class);
        startActivity(intent); } };
}
*/

