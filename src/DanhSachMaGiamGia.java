import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DanhSachMaGiamGia implements IDanhSach{
    private static final String FILE_NAME_HD = "DanhSachMaGiamGia.txt";

    MaGiamGia[] dsMaGiamGia = new MaGiamGia[1];

    @Override
    public void them() {
        try {
            File file = new File(FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            MaGiamGia maGiamGia = new MaGiamGia();
            System.out.println("--Nhap thong tin--");
            maGiamGia.nhap();

            fr.write(maGiamGia.toString());
            fr.newLine();
            System.out.println("-Tao ma giam gia thanh cong-");

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {

    }

    @Override
    public void xuat() {

    }
}
