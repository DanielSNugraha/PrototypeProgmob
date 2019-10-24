package ukdw.com.prototypeprogmob.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.DataMahasiswa;
import ukdw.com.prototypeprogmob.R;
import ukdw.com.prototypeprogmob.RecylerViewMhsActivity;

public class DataMahasiswaAdapter extends
        RecylerViewMhsActivity.Adapter<DataMahasiswaAdapter.ViewHolder>{
    private ArrayList<DataMahasiswa> mahasiswaArrayList;

    public DataMahasiswaAdapter(ArrayList<DataMahasiswa> mahasiswaArrayList) {
        this.mahasiswaArrayList = mahasiswaArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_data_mahasiswa,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNama.setText(mahasiswaArrayList.get(position).getNama());
        holder.txtNim.setText(mahasiswaArrayList.get(position).getNim();
        holder.txtEmail.setText(mahasiswaArrayList.get(position).getNim();
        holder.txtAlamat.setText(mahasiswaArrayList.get(position).getAlamat();
    }

    @Override
    public int getItemCount() { //untuk menghitung jumlah data yang ada//
        return (mahasiswaArrayList != null) ?mahasiswaArrayList.size() : 0; }
    public class ViewHolder extends RecylerViewMhsActivity.ViewHolder{
        private TextView txtNama, txtNim, txtEmail, txtAlamat;

        public ViewHolder(View view){
            super(view);

            txtNama = view.findViewById(R.id.txt_nama);
            txtNim = view.findViewById(R.id.txt_nim);
            txtEmail = view.findViewById(R.id.txt_email);
            txtAlamat = view.findViewById(R.id.txt_alamat);
        }
    }
}
