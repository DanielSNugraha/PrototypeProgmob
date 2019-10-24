package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
}

      /* private View.OnClickListener btnSign = new View.OnClickListener()
    { @Override
    public void onClick(View view)
    { Intent intent = new Intent
            (LoginActivity.this,HomeScreenAdmin.class);
        startActivity(intent); } };
}
*/

