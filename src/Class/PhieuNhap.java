package Class;

import Interface.IRandomId;
import StaticMethod.StaticMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PhieuNhap implements IRandomId  {
    String maPn, maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, giaVon, nhaCungCap, ngayNhap, nguoiNhap, lyDoNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPn, String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String giaVon, String nhaCungCap, String ngayNhap, String nguoiNhap, String lyDoNhap) {
        this.maPn = maPn;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.loaiSp = loaiSp;
        this.giaVon = giaVon;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.nguoiNhap = nguoiNhap;
        this.lyDoNhap = lyDoNhap;
    }

    public String getMaPn() {
        return maPn;
    }

    public void setMaPn(String maPn) {
        this.maPn = maPn;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaBanDau() {
        return giaBanDau;
    }

    public void setGiaBanDau(String giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(String giaVon) {
        this.giaVon = giaVon;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getLyDoNhap() {
        return lyDoNhap;
    }

    public void setLyDoNhap(String lyDoNhap) {
        this.lyDoNhap = lyDoNhap;
    }

    @Override
    public void setRandomId() {
        String lastId = "PN00000";
        File file = new File(StaticMethod.FILE_NAME_PN);

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
        String newId = String.format("PN%05d", num);
        setMaPn(newId);
    }

    public void nhapKhiQLNhap(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String giaVon, String maQl) {
        setRandomId();
        String temp;

        setMaSp(maSp);
        setTenSp(tenSp);
        setSoLuong(soLuong);
        setGiaBanDau(giaBanDau);
        setMoTa(moTa);
        setMauSac(mauSac);
        setLoaiSp(loaiSp);
        setGiaVon(giaVon);

        System.out.print("Nhap nha cung cap: ");
        temp = StaticMethod.sc.nextLine();
        setNhaCungCap(temp.trim());

        do {
            System.out.print("Nhap ngay tao phieu nhap(dinh dang dd-mm-yyyy)(Nhan Enter de lay ngay thang nam hien tai): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!StaticMethod.checkNgayTaoHd(temp));
        if (temp.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = today.format(formatter);
            setNgayNhap(formattedDate);
        } else {
            setNgayNhap(temp);
        }

        setNguoiNhap(maQl);

        System.out.print("Nhap ly do nhap: ");
        temp = StaticMethod.sc.nextLine();
        setLyDoNhap(temp.trim());
    }

    @Override
    public String toString() {
        return maPn + ";"
                + maSp + ";"
                + tenSp + ";"
                + soLuong + ";"
                + giaBanDau + ";"
                + moTa + ";"
                + mauSac + ";"
                + loaiSp + ";"
                + giaVon + ";"
                + nhaCungCap + ";"
                + ngayNhap + ";"
                + nguoiNhap + ";"
                + lyDoNhap;
    }

}
