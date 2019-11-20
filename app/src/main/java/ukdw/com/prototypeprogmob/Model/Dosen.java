package ukdw.com.prototypeprogmob.Model;

import retrofit2.http.Field;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Dosen {

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nidn")
    @Expose
    private String nidn;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    public Dosen(String email, String alamat, String nidn, String nama) {
        this.nama = nama;
        this.nidn = nidn;
        this.email = email;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) { this.nama = nama;}


    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) { this.nidn = this.nidn;}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email;}


    public String getAlamat() {
        return alamat;
    }

    public void getAlamat(String alamat) {
        this.alamat = alamat;
    }
}
