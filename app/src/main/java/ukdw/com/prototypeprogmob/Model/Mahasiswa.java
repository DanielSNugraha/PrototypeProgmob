package ukdw.com.prototypeprogmob.Model;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String email;
    private String alamat;

    public Mahasiswa(String email, String alamat, String nim, String nama) {
        this.nama = nama;
        this.nim = nim;
        this.email = email;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) { this.nama = nama;}


    public String getNim() {
        return nim;
    }

    public void setNim(String nim) { this.nim = nim;}


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
