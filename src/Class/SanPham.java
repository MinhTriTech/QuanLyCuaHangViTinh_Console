package Class;

import Interface.IRandomId;
import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public abstract class SanPham implements IRandomId {
    private String maSp, tenSp, soLuong, giaBanDau, moTa, mauSac, loaiSp, khuyenMai, gia, giaVon;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia, String giaVon) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.loaiSp = loaiSp;
        this.khuyenMai = khuyenMai;
        this.gia = gia;
        this.giaVon = giaVon;
    }

    public SanPham(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.loaiSp = loaiSp;
        this.khuyenMai = khuyenMai;
        this.gia = gia;
    }

    public SanPham(String maSp, String tenSp, String soLuong, String giaBanDau, String giaVon, String loaiSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.giaVon = giaVon;
        this.loaiSp = loaiSp;
    }

    public SanPham(String maSp, String tenSp, String soLuong, String giaBanDau, String mauSac, String loaiSp, String khuyenMai, String gia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBanDau = giaBanDau;
        this.mauSac = mauSac;
        this.loaiSp = loaiSp;
        this.khuyenMai = khuyenMai;
        this.gia = gia;
    }

    public SanPham(String loaiSp) {
        this.loaiSp = loaiSp;
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

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
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

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public String getGiaBanDau() {
        return giaBanDau;
    }

    public void setGiaBanDau(String giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public String getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(String giaVon) {
        this.giaVon = giaVon;
    }

    //    Các phương thức

    @Override
    public void setRandomId() {
        String lastId = "SP00000";
        File file = new File(StaticMethod.FILE_NAME_SP);

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
        String newId = String.format("SP%05d", num);
        setMaSp(newId);
    }

    public boolean checkSoLuong(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("--Vui long nhap lai so luong");
            return false;
        }

        try {
            int number = Integer.parseInt(string);
            if (number > 0) {
                return true;
            } else {
                System.out.println("--Vui long nhap lai so luong");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkGiaNoPrint(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String tinhGia(String gia, String khuyenMai) {
        double giaLast = Double.parseDouble(gia) - (Double.parseDouble(gia) * Double.parseDouble(khuyenMai) / 100);
        return String.format("%.2f", giaLast);
    }

    public abstract void nhap();
    public abstract void nhapDeSua();
    public abstract void xuatThongTinSp();
    public abstract void xuatThongTinSpCoStt(String soTt);
    public abstract void nhapDeNhapHang();
    public abstract void capNhatPhanTramSanPham();
    public abstract void xuatThongTinSpThongKe();
    public abstract void xuatThongTinSpCoTongGia();
    public abstract void xuatThongTinSpThongKeDm(String tongSoLuong, String tongGiaBd, String tongGiaVon);

    @Override
    public String toString() {
        return  maSp + ";" +
                tenSp + ";" +
                soLuong + ";" +
                giaBanDau + ";" +
                moTa + ";" +
                mauSac + ";" +
                loaiSp + ";" +
                khuyenMai + ";" +
                gia;
    }

    public String toStringCoTongGia() {
        double tongGia = Double.parseDouble(soLuong)*Double.parseDouble(gia);
        String tongGiaString =  String.format("%.2f", tongGia);
        return  maSp + ";" +
                tenSp + ";" +
                soLuong + ";" +
                giaBanDau + ";" +
                mauSac + ";" +
                loaiSp + ";" +
                khuyenMai + ";" +
                gia + ";" +
                tongGiaString;
    }

    public String toStringGiaVon() {
        return  maSp + ";" +
                tenSp + ";" +
                soLuong + ";" +
                giaBanDau + ";" +
                moTa + ";" +
                mauSac + ";" +
                loaiSp + ";" +
                khuyenMai + ";" +
                gia + ";" +
                giaVon;
    }
}
