package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
}



