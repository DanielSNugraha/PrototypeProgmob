package ukdw.com.prototypeprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreenMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen_mahasiswa);
    }

    public void datadirimhs(View view){
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
