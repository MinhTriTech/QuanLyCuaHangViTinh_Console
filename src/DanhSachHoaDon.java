import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class DanhSachHoaDon implements IDanhSach{

    private static final String FILE_NAME_HD = "DanhSachHoaDon.txt";

    HoaDon[] dsHoaDon = new HoaDon[1];

    @Override
    public void them() {

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

    public String themHd(String maKh, String tongTien) {
        try {
            File file = new File(FILE_NAME_HD);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            HoaDon hd = new HoaDon();
            System.out.println("--Nhap thong tin--");
            hd.nhap(maKh, tongTien);

            fr.write(hd.toString());
            fr.newLine();
            System.out.println("-Tao hoa don thanh cong-");

            fr.close();

            return hd.getMaHd();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public HoaDon timKiemTheoMaHdBool(String maHd) {
        try {
            String st;

            maHd = maHd.toUpperCase().trim();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6]);
                if(hd.getMaHd().equals(maHd)) {
                    return hd;
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
