package Class;

import Interface.IRandomId;
import StaticMethod.StaticMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HoaDon implements IRandomId {
    private String maHd, maKh, maKhuyenMai, tongTien, tongTienBanDau, phuongThucThanhToan, ngayRaHd, trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHd, String maKh, String tongTienBanDau, String maKhuyenMai, String tongTien, String phuongThucThanhToan, String ngayRaHd, String trangThai) {
        this.maHd = maHd;
        this.maKh = maKh;
        this.maKhuyenMai = maKhuyenMai;
        this.tongTien = tongTien;
        this.tongTienBanDau = tongTienBanDau;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ngayRaHd = ngayRaHd;
        this.trangThai = trangThai;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getNgayRaHd() {
        return ngayRaHd;
    }

    public void setNgayRaHd(String ngayRaHd) {
        this.ngayRaHd = ngayRaHd;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTongTienBanDau() {
        return tongTienBanDau;
    }

    public void setTongTienBanDau(String tongTienBanDau) {
        this.tongTienBanDau = tongTienBanDau;
    }

    //    Các phương thức

    @Override
    public void setRandomId() {
        String lastId = "HD00000";
        File file = new File(StaticMethod.FILE_NAME_HD);

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
        String newId = String.format("HD%05d", num);
        setMaHd(newId);
    }

    public boolean checkNgayTaoHd(String chuoiNgay) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";

        if (chuoiNgay.matches(regex)) {
            return true;
        } else {
            System.out.println("Sai dinh dang, vui long nhap dung dinh dang dd-mm-yyyy");
            return false;
        }
    }

    public boolean checkMaKm(String maKm, String tongTien) {
        try {
            String st;
            boolean check = false;
            boolean checkYesNo = false;

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                MaGiamGia mgg = new MaGiamGia(s[0],s[1],s[2],s[3],s[4]);
                if(mgg.getMaChu().equals(maKm) && mgg.getTrangThai().equals("Hoat dong")) {
                    System.out.println("--Voi hoa don nay ban duoc giam " + mgg.tinhSoTienDuocGiam(Double.parseDouble(tongTien)) + " ban co muon su dung ma giam gia nay khong?");

                    String xacNhan, tongTienConLaiDaLamTron;

                    do {
                        System.out.print("Nhap Co hoac Khong de tiep tuc:");
                        xacNhan = StaticMethod.sc.nextLine();
                        if(xacNhan.equals("Co")) {
                            check = true;
                            checkYesNo = true;
                            double tongTienConLai = Double.parseDouble(getTongTienBanDau()) - mgg.tinhSoTienDuocGiam(Double.parseDouble(tongTien));
                            tongTienConLaiDaLamTron = String.format("%.2f", tongTienConLai);
                            setTongTien(tongTienConLaiDaLamTron);
                            break;
                        }
                        if(xacNhan.equals("Khong")) {
                            check = true;
                            checkYesNo = false;
                            break;
                        }
                    }
                    while(!xacNhan.equals("Co") || !xacNhan.equals("Khong"));
                }
            }

            br.close();

            if(check == false) {
                System.out.println("--Khong tim thay ma giam gia tuong ung");
            }

            return checkYesNo;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void nhap(String maKh, String tongTien) {
        String temp, tongTienConLaiDaLamTron;
        setRandomId();

        setMaKh(maKh);
        setTongTienBanDau(tongTien);

        do {
            System.out.print("Nhap ma khuyen mai(Nhan Enter de bo qua): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkMaKm(temp, tongTien));
        if (temp.isEmpty()) {
            setMaKhuyenMai("Khong su dung");
            double tongTienConLai = Double.parseDouble(getTongTienBanDau()) - Double.parseDouble("0.0");
            tongTienConLaiDaLamTron = String.format("%.2f", tongTienConLai);
            setTongTien(tongTienConLaiDaLamTron);
        } else {
            setMaKhuyenMai(temp);
        }

        do {
            System.out.println("Chon phuong thuc thanh toan: ");
            System.out.println("===Chon===");
            System.out.println("1. Tien mat");
            System.out.println("2. Momo");
            System.out.println("3. The ngan hang");
            temp = StaticMethod.sc.nextLine();
        }
        while(Integer.parseInt(temp) > 3 && Integer.parseInt(temp) < 0);
        if(Integer.parseInt(temp) == 1) {
            setPhuongThucThanhToan("Tien mat");
        } else if (Integer.parseInt(temp) == 2) {
            setPhuongThucThanhToan("Momo");
        } else {
            setPhuongThucThanhToan("The ngan hang");
        }

        do {
            System.out.print("Nhap ngay tao hoa don(dinh dang dd-mm-yyyy)(Nhan Enter de lay ngay thang nam hien tai): ");
            temp = StaticMethod.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkNgayTaoHd(temp));
        if (temp.isEmpty()) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = today.format(formatter);
            setNgayRaHd(formattedDate);
        } else {
            setNgayRaHd(temp);
        }

        setTrangThai("Hoat dong");
    }

    public void xuatThongTinHd() {
        int[] columnWidths = {10, 10, 30, 15, 30, 20, 10, 20};
        String[] values = {
                getMaHd(), getMaKh(), getTongTienBanDau(), getMaKhuyenMai(),
                getTongTien(), getPhuongThucThanhToan(), getNgayRaHd(),
                getTrangThai()
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public String toString() {
        return maHd + ";"
                + maKh + ";"
                + tongTienBanDau + ";"
                + maKhuyenMai + ";"
                + tongTien + ";"
                + phuongThucThanhToan + ";"
                + ngayRaHd + ";"
                + trangThai;
    }
}
