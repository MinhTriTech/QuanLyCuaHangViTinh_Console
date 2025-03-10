import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class HoaDon {
    private String maHd, maKh, maKhuyenMai, tongTien, phuongThucThanhToan, ngayRaHd, trangThai;

    private static final String FILE_NAME_HD = "DanhSachHoaDon.txt";
    private static final String FILE_NAME_MGG = "DanhSachMaGiamGia.txt";

    public HoaDon() {
    }

    public HoaDon(String maHd, String maKh, String maKhuyenMai, String tongTien, String phuongThucThanhToan, String ngayRaHd, String trangThai) {
        this.maHd = maHd;
        this.maKh = maKh;
        this.maKhuyenMai = maKhuyenMai;
        this.tongTien = tongTien;
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

//    Các phương thức

    public void setRandomId() {
        String lastId = "HD00000";
        File file = new File(FILE_NAME_HD);

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
            QuanLyCuaHang.sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_MGG));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                MaGiamGia mgg = new MaGiamGia(s[0],s[1],s[2],s[3],s[4]);
                if(mgg.getMaChu().equals(maKm) && mgg.getTrangThai().equals("Hoat dong")) {
                    System.out.println("--Voi hoa don nay ban duoc giam " + mgg.tinhSoTienDuocGiam(Double.parseDouble(tongTien)) + " ban co muon su dung ma giam gia nay khong (Nhap Co hoac Khong de tiep tuc)?");
                    String xacNhan = QuanLyCuaHang.sc.nextLine();
                    if(xacNhan.equals("Co")) {
                        check = true;
                    } else {
                        check = false;
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("--Khong tim thay ma giam gia tuong ung");
            }

            return check;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void nhap(String maKh, String tongTien) {
        String temp;
        setRandomId();

        setMaKh(maKh);
        setTongTien(tongTien);

        do {
            System.out.print("Nhap ma khuyen mai(Nhan Enter de bo qua): ");
            temp = QuanLyCuaHang.sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
        }
        while(!checkMaKm(temp, tongTien));
        if (temp.isEmpty()) {
            setMaKhuyenMai("Khong su dung");
        } else {
            setMaKhuyenMai(temp);
        }

        do {
            System.out.println("Chon phuong thuc thanh toan: ");
            System.out.println("===Chon===");
            System.out.println("1. Tien mat");
            System.out.println("2. Momo");
            System.out.println("3. The ngan hang");
            temp = QuanLyCuaHang.sc.nextLine();
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
            System.out.print("Nhap ngay tao hoa don(dinh dang dd-mm-yyyy): ");
            temp = QuanLyCuaHang.sc.nextLine();}
        while(!checkNgayTaoHd(temp));
        setNgayRaHd(temp);

        setTrangThai("Hoat dong");
    }

    public static void xuatHeaderHd() {
        int[] columnWidths = {10, 10, 15, 30, 20, 10, 10};
        String[] headers = {"Ma HD", "Ma KH", "Ma KM", "Tong tien", "PTTT", "Ngay ra HD", "Trang thai"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public void xuatThongTinHd() {
        int[] columnWidths = {10, 10, 15, 30, 20, 10, 10};
        String[] values = {
                getMaHd(), getMaKh(), getMaKhuyenMai(),
                getTongTien(), getPhuongThucThanhToan(), getNgayRaHd(),
                getTrangThai()
        };

        printMultiLineRow(values, columnWidths);
        printSeparator(columnWidths);
    }

    public void printMultiLineRow(String[] row, int[] columnWidths) {
        int maxLines = 1;
        String[][] wrappedColumns = new String[row.length][];

        for (int i = 0; i < row.length; i++) {
            wrappedColumns[i] = wrapText(row[i], columnWidths[i]);
            maxLines = Math.max(maxLines, wrappedColumns[i].length);
        }

        for (int line = 0; line < maxLines; line++) {
            for (int i = 0; i < row.length; i++) {
                String text = (line < wrappedColumns[i].length) ? wrappedColumns[i][line] : "";
                System.out.printf("| %-" + columnWidths[i] + "s ", text);
            }
            System.out.println("|");
        }
    }

    public String[] wrapText(String text, int width) {
        int lines = (int) Math.ceil((double) text.length() / width);
        String[] result = new String[lines];

        for (int i = 0; i < lines; i++) {
            int start = i * width;
            int end = Math.min(start + width, text.length());
            result[i] = text.substring(start, end);
        }

        return result;
    }

    public static void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+-" + "-".repeat(width) + "-");
        }
        System.out.println("+");
    }

    public static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            System.out.printf("| %-" + columnWidths[i] + "s ", row[i]);
        }
        System.out.println("|");
    }

    @Override
    public String toString() {
        return maHd + ";"
                + maKh + ";"
                + maKhuyenMai + ";"
                + tongTien + ";"
                + phuongThucThanhToan + ";"
                + ngayRaHd + ";"
                + trangThai;
    }
}
