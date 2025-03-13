package Class;

import StaticMethod.StaticMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MaGiamGia {
    private String maGg, maChu, phanTramGiam, giaTriToiDa, trangThai;

    public MaGiamGia() {
    }

    public MaGiamGia(String maGg, String maChu, String phanTramGiam, String giaTriToiDa, String trangThai) {
        this.maGg = maGg;
        this.maChu = maChu;
        this.phanTramGiam = phanTramGiam;
        this.giaTriToiDa = giaTriToiDa;
        this.trangThai = trangThai;
    }

    public String getMaGg() {
        return maGg;
    }

    public void setMaGg(String maGg) {
        this.maGg = maGg;
    }

    public String getMaChu() {
        return maChu;
    }

    public void setMaChu(String maChu) {
        this.maChu = maChu;
    }

    public String getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(String phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getGiaTriToiDa() {
        return giaTriToiDa;
    }

    public void setGiaTriToiDa(String giaTriToiDa) {
        this.giaTriToiDa = giaTriToiDa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

//    Các phương thức

    public double tinhSoTienDuocGiam(double tongGiaTri) {
        double discount = tongGiaTri * Double.parseDouble(phanTramGiam) / 100;
        return Math.min(discount, Double.parseDouble(giaTriToiDa));
    }

    public void setRandomId() {
        String lastId = "MGG00000";
        File file = new File(StaticMethod.FILE_NAME_MGG);

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

        int num = Integer.parseInt(lastId.substring(3)) + 1;
        String newId = String.format("MGG%05d", num);
        setMaGg(newId);
    }

    public boolean checkGia(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("-Vui long nhap lai gia-");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number > 0) {
                return true;
            } else {
                System.out.println("-Vui long nhap lai gia-");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("-Vui long nhap lai phan tram khuyen mai-");
            return false;
        }

        try {
            double number = Double.parseDouble(string);
            if (number >= 0 && number <= 100) {
                return true;
            } else {
                System.out.println("-Vui long nhap lai phan tram khuyen mai-");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkMaKm(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("-Vui long nhap lai ma khuyen mai-");
            return false;
        }

        if (string.length() <= 6) {
            return true;
        } else {
            System.out.println("-Vui long nhap lai ma khuyen mai toi da 6 ki tu-");
            return false;
        }
    }

    public void nhap() {
        String temp;
        setRandomId();

        do {
            System.out.print("--Nhap ma khuyen mai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkMaKm(temp));
        setMaChu(temp.trim().toUpperCase());

        do {
            System.out.print("--Nhap % khuyen mai: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkKm(temp));
        setPhanTramGiam(temp.trim());

        do {
            System.out.print("--Nhap gia tri toi da: ");
            temp = StaticMethod.sc.nextLine();}
        while(!checkGia(temp));
        setGiaTriToiDa(temp.trim());

        setTrangThai("Hoat dong");
    }

    public void xuatThongTinMgg() {
        int[] columnWidths = {20, 20, 20, 30, 20};
        String[] values = {
                getMaGg(), getMaChu(), getPhanTramGiam(),
                getGiaTriToiDa(), getTrangThai()
        };
        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return maGg + ";"
                + maChu + ";"
                + phanTramGiam + ";"
                + giaTriToiDa + ";"
                + trangThai;
    }
}
