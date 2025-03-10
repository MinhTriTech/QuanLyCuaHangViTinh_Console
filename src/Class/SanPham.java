package Class;

import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public abstract class SanPham {
    private String maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp, giaBanDau;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, String soLuong, String giaBanDau, String moTa, String mauSac, String loaiSp, String khuyenMai, String gia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.khuyenMai = khuyenMai;
        this.loaiSp = loaiSp;
        this.giaBanDau = giaBanDau;
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

    //    Các phương thức

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
            System.out.println("Vui long nhap lai so luong !!!");
            return false;
        }

        try {
            int number = Integer.parseInt(string);
            if (number > 0) {
                return true;
            } else {
                System.out.println("Vui long nhap lai so luong !!!");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkGia(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Vui long nhap lai gia !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number > 0) {
                return true;
            } else {
                System.out.println("Vui long nhap lai gia !!!");
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

    public boolean checkKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("Vui long nhap lai phan tram khuyen mai !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number >= 0 && number <= 100) {
                return true;
            } else {
                System.out.println("Vui long nhap lai phan tram khuyen mai !!!");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String tinhGia(String gia, String khuyenMai) {
        double giaLast = 0.0;
        giaLast = Double.parseDouble(gia) - (Double.parseDouble(gia) * Double.parseDouble(khuyenMai) / 100);
        String ketQua = String.format("%.2f", giaLast);
        return ketQua;
    }

    public abstract void nhap();
    public abstract void nhapDeSua();
    public abstract void xuatThongTinSp();
    public abstract void xuatThongTinSpCoStt(String soTt);

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
}
