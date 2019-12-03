package ukdw.com.prototypeprogmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import  ukdw.com.prototypeprogmob.Adapter.DosenAdapter;
import  ukdw.com.prototypeprogmob.Model.Dosen;
import  ukdw.com.prototypeprogmob.MainActivity;
import  ukdw.com.prototypeprogmob.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.prototypeprogmob.Model.Dosen;

import  ukdw.com.prototypeprogmob.Network.GetDataService;
import  ukdw.com.prototypeprogmob.Network.RetrofitClientInstance;

public class RecyclerViewDaftarDosen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucreate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecyclerViewDaftarDosen.this,CreateDosen.class);
            startActivity(intent);
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_daftar_dosen);
        this.setTitle("SI KRS - Hai Admin");
        //tambahData();
        //addData
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArrayList<Dosen>> call = service.getDosenAll("72170177");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                recyclerView = findViewById(R.id.rvDosen);
                dosenAdapter = new DosenAdapter(response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayout(RecyclerViewDaftarDosen.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RecyclerViewDaftarDosen.this,"Login Gagal, Silahkan Coba Lagi",Toast.LENGTH_SHORT);
            }
        });




    }

   /* private void tambahData(){
        dosenList = new ArrayList<>();
        dosenList.add(new Dosen("001","77777","Jong Jek Siang", "Proffesor","jjs@staff.ukdw.ac.id","Jl. Magelang",R.drawable.logo));
        dosenList.add(new Dosen("001","77777","Jong Jek Siang", "Proffesor","jjs@staff.ukdw.ac.id","Jl. Magelang",R.drawable.logo));
        dosenList.add(new Dosen("001","77777","Jong Jek Siang", "Proffesor","jjs@staff.ukdw.ac.id","Jl. Magelang",R.drawable.logo));
    }*/
}
