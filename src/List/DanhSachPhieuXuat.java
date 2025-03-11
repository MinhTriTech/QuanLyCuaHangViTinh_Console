package List;

import Interface.IDanhSach;
import StaticMethod.StaticMethod;
import Class.HoaDon;
import Class.PhieuXuat;

import java.io.*;

public class DanhSachPhieuXuat implements IDanhSach {
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

    public void themPx(String maHd, String maKh) {
        try {
            File file = new File(StaticMethod.FILE_NAME_PX);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            PhieuXuat px = new PhieuXuat();
            px.nhapKhiKHMua(maHd, maKh, tinhTongTienVonTheoMaHd(maHd), timKiemTheoMaHd(maHd));

            fr.write(px.toString());
            fr.newLine();

            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String timKiemTheoMaHd(String maHd) {
        String ngayXuat = "";
        try {
            String st;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_HD));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                HoaDon hd = new HoaDon(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                if(hd.getMaHd().equals(maHd)) {
                    ngayXuat =  hd.getNgayRaHd();
                }
            }

            br.close();

            return ngayXuat;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ngayXuat;
    }

    public String tinhTongTienVonTheoMaHd(String maHd) {
        String tongTienVon = "";
        double tongTienConLaiTemp = 0.0;

        try {
            String st;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_SPDX));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[6].equals("LAPTOP") && s[10].equals(maHd)) {
                    tongTienConLaiTemp = tongTienConLaiTemp + Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Integer.parseInt(s[2]);
                }
                if(s[6].equals("PHUKIEN") && s[10].equals(maHd)) {
                    tongTienConLaiTemp = tongTienConLaiTemp + Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Integer.parseInt(s[2]);
                }
                if(s[6].equals("TAINGHELOA") && s[10].equals(maHd)) {
                    tongTienConLaiTemp = tongTienConLaiTemp + Double.parseDouble(StaticMethod.layTienVonSp(s[0]))*Integer.parseInt(s[2]);
                }
            }
            tongTienVon = String.format("%.2f", tongTienConLaiTemp);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongTienVon;
    }
}
