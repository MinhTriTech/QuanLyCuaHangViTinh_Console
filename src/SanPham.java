import java.io.*;
import java.util.Arrays;

public abstract class SanPham {
    private String maSp, tenSp, soLuong, gia, moTa, mauSac, khuyenMai, loaiSp;

    private static final String FILE_NAME_SP = "DanhSachSanPham.txt";

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, String soLuong, String gia, String moTa, String mauSac, String khuyenMai, String loaiSp) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.gia = gia;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.khuyenMai = khuyenMai;
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

//    Các phương thức

    public void setRandomId() {
        String lastId = "SP00000";
        File file = new File(FILE_NAME_SP);

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

    public boolean checkGiaKm(String string) {
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

    public static void xuatHeaderSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] headers = {"Ma SP", "Ten SP", "So luong", "Gia", "Mo ta", "Mau sac", "Khuyen mai", "Loai SP", "Dung luong"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    public static void xuatHeaderSpCoStt() {
        int[] columnWidths = {10, 10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] headers = {"STT", "Ma SP", "Ten SP", "So luong", "Gia", "Mo ta", "Mau sac", "Khuyen mai", "Loai SP", "Dung luong"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
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

    public static MuaHangAction checkDsSanPhamTrongGio(SanPham[] dsSanPham) {
        SanPham[] sanPhamSanCo = new SanPham[0];
        SanPham[] sanPhamKhongDatDieuKien = new SanPham[0];

//        Tạo danh sách sản phẩm hiện tại
        try {
            File file = new File(FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            if(count > 0) {
                sanPhamSanCo = Arrays.copyOf(sanPhamSanCo, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < sanPhamSanCo.length; i++) {
                    String s[] = ft.readLine().split(";");
                    if(s[7].equals("LAPTOP")) {
                        sanPhamSanCo[i] = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    }
                    if(s[7].equals("PHUKIEN")) {
                        sanPhamSanCo[i] = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                    if(s[7].equals("TAINGHELOA")) {
                        sanPhamSanCo[i] = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    }
                }

                ft.close();
                fw.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them san pham de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Thực hiện danh sách sản phẩm hiện tại
        for (int i = 0; i < dsSanPham.length; i++) {
            for (int j = 0; j < sanPhamSanCo.length; j++) {
                if(dsSanPham[i].getMaSp().equals(sanPhamSanCo[j].getMaSp())) {

//                    Kiểm tra sau khi trừ có không hợp lệ không
                    if (Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong()) < 0) {

//                        Nếu không hợp lệ thì gán số lượng mới và thêm sản phẩm vào danh sách không hợp lệ
                        sanPhamSanCo[j].setSoLuong(String.valueOf(Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong())));

//                        Tăng kích thước của danh sách sản phẩm không hợp lệ
                        SanPham[] sanPhamKhongDatDieuKienTemp = new SanPham[sanPhamKhongDatDieuKien.length + 1];

                        for (int n = 0; n < sanPhamKhongDatDieuKien.length; n++) {
                            sanPhamKhongDatDieuKienTemp[n] = sanPhamKhongDatDieuKien[n];
                        }

                        sanPhamKhongDatDieuKien = Arrays.copyOf(sanPhamKhongDatDieuKien, sanPhamKhongDatDieuKienTemp.length);

                        for (int n = 0; n < sanPhamKhongDatDieuKienTemp.length; n++) {
                            sanPhamKhongDatDieuKien[n] = sanPhamKhongDatDieuKienTemp[n];
                        }

                        sanPhamKhongDatDieuKien[sanPhamKhongDatDieuKien.length-1] = dsSanPham[i];
                    } else {

//                        Nếu hợp lệ thì chỉ gán số lượng mới
                        sanPhamSanCo[j].setSoLuong(String.valueOf(Integer.parseInt(sanPhamSanCo[j].getSoLuong()) - Integer.parseInt(dsSanPham[i].getSoLuong())));
                    }
                }
            }
        }

        MuaHangAction muaHangAction = new MuaHangAction(sanPhamKhongDatDieuKien, sanPhamSanCo);

        return muaHangAction;
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
                gia + ";" +
                moTa + ";" +
                mauSac + ";" +
                khuyenMai + ";" +
                loaiSp;
    }
}
