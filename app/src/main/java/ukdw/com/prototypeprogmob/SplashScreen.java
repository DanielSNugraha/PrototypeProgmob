package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Splassh = (TextView) findViewById(R.id.screensplash);
                this.getSupportActionBar().hide();

        SharedPreferences prefs = SplashScreen.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin",null);
        if (statusLogin != null){
            if (statusLogin .equals("Admin"))
            {
                Intent intent = new Intent(SplashScreen.this, HomeScreenAdmin.class) ;
                startActivity(intent);
            }else if (statusLogin .equals("User") ){
                Intent intent = new Intent(SplashScreen.this,HomeScreenMahasiswa.class);
                startActivity(intent);
            }
        }else{
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }, 900L); //3000 L = 3 detik
        }
    }
}
