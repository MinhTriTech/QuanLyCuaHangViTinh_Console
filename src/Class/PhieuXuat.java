package Class;

import Interface.IRandomId;
import StaticMethod.StaticMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PhieuXuat implements IRandomId {
    private String maPx, maHd, doiTuong, tongTienVon, ngayXuat, nguoiXuat, lyDoXuat;

    public PhieuXuat() {
    }

    public PhieuXuat(String maPx, String maHd, String doiTuong, String tongTienVon, String ngayXuat, String nguoiXuat, String lyDoXuat) {
        this.maPx = maPx;
        this.maHd = maHd;
        this.doiTuong = doiTuong;
        this.tongTienVon = tongTienVon;
        this.ngayXuat = ngayXuat;
        this.nguoiXuat = nguoiXuat;
        this.lyDoXuat = lyDoXuat;
    }

    public String getMaPx() {
        return maPx;
    }

    public void setMaPx(String maPx) {
        this.maPx = maPx;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public String getTongTienVon() {
        return tongTienVon;
    }

    public void setTongTienVon(String tongTienVon) {
        this.tongTienVon = tongTienVon;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getNguoiXuat() {
        return nguoiXuat;
    }

    public void setNguoiXuat(String nguoiXuat) {
        this.nguoiXuat = nguoiXuat;
    }

    public String getLyDoXuat() {
        return lyDoXuat;
    }

    public void setLyDoXuat(String lyDoXuat) {
        this.lyDoXuat = lyDoXuat;
    }

    @Override
    public void setRandomId() {
        String lastId = "PX00000";
        File file = new File(StaticMethod.FILE_NAME_PX);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] mang = line.split(";");
                    lastId = mang[0];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int num = Integer.parseInt(lastId.substring(2)) + 1;
        String newId = String.format("PX%05d", num);
        setMaPx(newId);
    }

    public void nhapKhiKHMua(String maHd, String doiTuong, String tongTienVon, String ngayXuat) {
        setRandomId();

        setMaHd(maHd);
        setDoiTuong(doiTuong);
        setNgayXuat(ngayXuat);
        setTongTienVon(tongTienVon);

        setNguoiXuat("He thong");
        setLyDoXuat("Khach hang su dung dich vu");
    }

    @Override
    public String toString() {
        return maPx + ";"
                + maHd + ";"
                + doiTuong + ";"
                + tongTienVon + ";"
                + ngayXuat + ";"
                + nguoiXuat + ";"
                + lyDoXuat;
    }
}
