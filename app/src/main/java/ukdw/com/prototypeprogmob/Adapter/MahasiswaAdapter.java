package ukdw.com.prototypeprogmob.Adapter;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import ukdw.com.prototypeprogmob.Model.Dosen;
import ukdw.com.prototypeprogmob.Model.Mahasiswa;
import ukdw.com.prototypeprogmob.R;

public class MahasiswaAdapter extends
        RecylerViewMhsActivity.Adapter<DosenAdapter.ViewHolder> {
    private ArrayList<Mahasiswa> dosenArrayList;

    public MahasiswaAdapter(ArrayList<Dosen> mahasiswaArrayList) {
        this.dosenArrayList = dosenArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_data_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNama.setText(mahasiswaArrayList.get(position).getNama());
        holder.txtNim.setText(mahasiswaArrayList.get(position).getNim());
        holder.txtEmail.setText(mahasiswaArrayList.get(position).getNim());
        holder.txtAlamat.setText(mahasiswaArrayList.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return (mahasiswaArrayList != null) ? mahasiswaArrayList.size() : 0;
    }

    public class ViewHolder extends RecylerViewMhsActivity.ViewHolder
                implements View.OnCreateContextMenuListener{
        private TextView txtNama, txtNim, txtEmail, txtAlamat;
        private ImageView imgViewDosen;

        public ViewHolder(View view) {
            super(view);
            txtNama = view.findViewById(R.id.txt_nama);
            txtNim = view.findViewById(R.id.txt_nidn);
            txtEmail = view.findViewById(R.id.txt_email);
            txtAlamat = view.findViewById(R.id.txt_alamat);
            view.setOnCreateContextMenuListener((this));
        }
        @Override
        public  void onCreateContextMenu (ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo)
            contextMenu.setHeaderTitle("Pilih Aksi");
        contextMenu.add(this.getAdapterPosition()), view.getId(), "Ubah data dosen")
        contextMenu.add(this.getAdapterPosition()), view.getId(), "Hapus data dosen")
    }
}