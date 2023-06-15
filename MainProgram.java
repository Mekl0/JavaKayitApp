import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainProgram {
    static List<Ucak> ucaklar;
    static List<Lokasyon> lokasyonlar;
    static List<Musteri> musteriler;
    static List<Rezervasyon> rezervasyonlar = new ArrayList<Rezervasyon>();

    public static void main(String[] args) {
        ucaklar = new ArrayList<Ucak>();
        lokasyonlar = new ArrayList<Lokasyon>();
        musteriler = new ArrayList<Musteri>();
        rezervasyonlar = new ArrayList<Rezervasyon>();

        // Örnek verileri oluştur
        Ucak ucak1 = new Ucak();
        ucak1.setModel("Model 1");
        ucak1.setMarka("Marka 1");
        ucak1.setSeriNo("123");
        ucak1.setKoltukKapasitesi(100);

        Ucak ucak2 = new Ucak();
        ucak2.setModel("Model 2");
        ucak2.setMarka("Marka 2");
        ucak2.setSeriNo("456");
        ucak2.setKoltukKapasitesi(150);

        Lokasyon lokasyon1 = new Lokasyon();
        lokasyon1.setUlke("Ülke 1");
        lokasyon1.setSehir("Şehir 1");
        lokasyon1.setHavaalani("Havaalanı 1");
        lokasyon1.setAktif(true);

        Lokasyon lokasyon2 = new Lokasyon();
        lokasyon2.setUlke("Ülke 2");
        lokasyon2.setSehir("Şehir 2");
        lokasyon2.setHavaalani("Havaalanı 2");
        lokasyon2.setAktif(true);

        ucaklar.add(ucak1);
        ucaklar.add(ucak2);

        lokasyonlar.add(lokasyon1);
        lokasyonlar.add(lokasyon2);

        // Kullanıcı arayüzü
        System.out.println("Rezervasyon Yapma Uygulaması");
        System.out.println();

        while (true) {
            System.out.println("1. Uçakları Listele");
            System.out.println("2. Lokasyonları Listele");
            System.out.println("3. Rezervasyon Yap");
            System.out.println("4. Rezervasyonları Listele");
            System.out.println("5. Çıkış");
            System.out.println();

            System.out.print("Seçiminizi yapın: ");
            int secim;
            boolean devamEt = true;
            while (devamEt) {
                Scanner scanner = new Scanner(System.in);
                String secimStr = scanner.nextLine();

                if (secimStr.matches("[1-5]")) {
                    secim = Integer.parseInt(secimStr);
                    switch (secim) {
                        case 1:
                            ucaklariListele(ucaklar);
                            break;
                        case 2:
                            lokasyonlariListele(lokasyonlar);
                            break;
                        case 3:
                            rezervasyonYap();
                            break;
                        case 4:
                            rezervasyonlariListele();
                            break;
                        case 5:
                            devamEt = false;
                            break;
                        default:
                            System.out.println("Geçersiz seçim!");
                            break;
                    }
                } else {
                    System.out.println("Geçersiz seçim!");
                }

                System.out.println();
            }
        }
    }

    public static void ucaklariListele(List<Ucak> ucaklar) {
        System.out.println("Uçaklar:");
        for (Ucak ucak : ucaklar) {
            System.out.println("Model: " + ucak.getModel());
            System.out.println("Marka: " + ucak.getMarka());
            System.out.println("Seri No: " + ucak.getSeriNo());
            System.out.println("Koltuk Kapasitesi: " + ucak.getKoltukKapasitesi());
            System.out.println();
        }
    }

    public static void lokasyonlariListele(List<Lokasyon> lokasyonlar) {
        System.out.println("Lokasyonlar:");
        for (Lokasyon lokasyon : lokasyonlar) {
            System.out.println("Ülke: " + lokasyon.getUlke());
            System.out.println("Şehir: " + lokasyon.getSehir());
            System.out.println("Havaalanı: " + lokasyon.getHavaalani());
            System.out.println("Aktif: " + lokasyon.isAktif());
            System.out.println();
        }
    }

    public static void rezervasyonYap() {
        Musteri musteri = new Musteri();
        Lokasyon lokasyon = new Lokasyon();
        Ucak ucak = new Ucak();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rezervasyon Yapma Ekranı");
        System.out.println();

        Rezervasyon rezervasyon = new Rezervasyon();

        System.out.print("Adınız: ");
        musteri.setAd(scanner.nextLine());

        System.out.print("Soyadınız: ");
        musteri.setSoyad(scanner.nextLine());

        System.out.print("Telefonunuz: ");
        musteri.setTelefon(scanner.nextLine());

        System.out.print("Emailiniz: ");
        musteri.setEmail(scanner.nextLine());

        System.out.print("Uçağın Kalkış Tarihi (yyyy-MM-dd HH:mm): ");
        musteri.setKalkistarihi(scanner.nextLine());

        rezervasyon.setMusteri(musteri);

        System.out.print("Varış Yeri Ülke: ");
        lokasyon.setUlke(scanner.nextLine());

        System.out.print("Varış Yeri Şehir: ");
        lokasyon.setSehir(scanner.nextLine());

        System.out.print("Varış Yeri Havaalanı: ");
        lokasyon.setHavaalani(scanner.nextLine());

        rezervasyon.setLokasyon(lokasyon);

        System.out.print("Uçak modeli: ");
        ucak.setModel(scanner.nextLine());

        System.out.print("Uçak markası: ");
        ucak.setMarka(scanner.nextLine());

        System.out.print("Uçak seri no: ");
        ucak.setSeriNo(scanner.nextLine());

        rezervasyon.setUcak(ucak);

        rezervasyonlar.add(rezervasyon);

        System.out.println("Rezervasyon başarıyla yapıldı!");

        System.out.println("Reservation Details:");
        System.out.println("Ad: " + rezervasyon.getMusteri().getAd());
        System.out.println("Soyad: " + rezervasyon.getMusteri().getSoyad());
        System.out.println("Telefon: " + rezervasyon.getMusteri().getTelefon());
        System.out.println("Email: " + rezervasyon.getMusteri().getEmail());
        System.out.println("Kalkış Tarihi: " + rezervasyon.getMusteri().getKalkistarihi());

        System.out.println();
    }

    public static void rezervasyonlariListele() {
        System.out.println("Rezervasyonlar:");
        for (Rezervasyon rezervasyon : rezervasyonlar) {
            System.out.println("Müşteri: " + rezervasyon.getMusteri());
            System.out.println("Uçak: " + rezervasyon.getUcak());
            System.out.println("Varış Yeri: " + rezervasyon.getLokasyon());

            System.out.println();
        }
    }
}