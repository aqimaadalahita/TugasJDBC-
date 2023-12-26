import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

// Interface untuk menghitung total barang
interface HitungTotal {
    double hitungTotal();
}

// Kelas utama Faktur
class Faktur {
    private String noFaktur;
    private String namaPelanggan;
    private String noHp;
    private String alamat;

    public Faktur(String noFaktur, String namaPelanggan, String noHp, String alamat) {
        this.noFaktur = noFaktur;
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNoHp(){
        return noHp;
    }

    public String getAlamat(){
        return alamat;
    }
}

// Kelas Barang dengan inheritance dari Faktur
class Barang extends Faktur implements HitungTotal {
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;
    private int jumlahBarang;

    public Barang(String noFaktur, String namaPelanggan, String noHp, String alamat,String kodeBarang, String namaBarang, double hargaBarang, int jumlahBarang) {
        super(noFaktur, namaPelanggan, noHp, alamat);
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getKodeBarang(){
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    @Override
    public double hitungTotal() {
        return hargaBarang * jumlahBarang;
    }
}

public class App{
    public static void main(String[] args) {
        
        //polymorphisme
        Transaksi belanja = new Transaksi();
        belanja.login();
    
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yyyy");
        SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

        Scanner scanner = new Scanner(System.in);
        
        //Exception
        try {
            System.out.print("Masukkan nomor faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan nama pelanggan: ");
            String namaPelanggan = scanner.nextLine();

            System.out.print("Masukkan no.Hp: ");
            String noHp = scanner.nextLine();

            System.out.print("Masukkan alamat: ");
            String alamat = scanner.nextLine();

            System.out.print("Masukkan kode barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan nama barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan harga barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan jumlah barang: ");
            int jumlahBarang = scanner.nextInt();

            // Membuat objek Barang
            Barang barang = new Barang(noFaktur, namaPelanggan, noHp, alamat, kodeBarang, namaBarang, hargaBarang, jumlahBarang);
            
            // Menampilkan informasi faktur dan total barang
            System.out.println(" ");
            System.out.println("-------------SUPER MARKET-------------");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println("======================================");
            System.out.println("DATA PELANGGAN");
            System.out.println("--------------------------------------");
            System.out.println("Nomor Faktur \t: " + barang.getNoFaktur());
            System.out.println("Nama Pelanggan \t: " + barang.getNamaPelanggan());
            System.out.println("No. HP \t\t: " + barang.getNoHp());
            System.out.println("Alamat \t\t: " + barang.getAlamat() );
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("DATA PEMBELIAN BARANG");
            System.out.println("--------------------------------------");
            System.out.println("Kode Barang \t: " + barang.getKodeBarang());
            System.out.println("Nama Barang \t: " + barang.getNamaBarang());
            System.out.println("Harga Barang \t: " + barang.getHargaBarang());
            System.out.println("Jumlah Beli \t: " + barang.getJumlahBarang());
            System.out.println("Total BAYAR \t: " + barang.hitungTotal());
            System.out.println("++++++++++++++++++++++++++++++++++++++");
            System.out.println("Kasir \t\t: Aqima Adalahita\n ");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


