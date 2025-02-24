import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class SanPham {
    String maSp;
    String tenSp;
    String soLuong;
    String gia;
    String moTa;
    String mauSac;
    String khuyenMai;
    String loaiSp;

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

    void setRandomId() {
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


    boolean checkSoLuong(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Vui long nhap lai so luong !!!");
            return false;
        }

        try {
            int number = Integer.parseInt(input);
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

    boolean checkGia(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Vui long nhap lai gia !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(input);
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

    boolean checkGiaKm(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Vui long nhap lai gia !!!");
            return false;
        }

        try {
            double number = Double.parseDouble(input);
            if (number >= 0) {
                return true;
            } else {
                System.out.println("Vui long nhap lai gia !!!");
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    abstract void nhap();
    abstract void xuatThongTinSp();

    public static void xuatHeaderSp() {
        int[] columnWidths = {10, 20, 10, 10, 30, 10, 12, 15, 10};
        String[] headers = {"Ma SP", "Ten SP", "So luong", "Gia", "Mo ta", "Mau sac", "Khuyen mai", "Loai SP", "Dung luong"};

        printSeparator(columnWidths);
        printRow(headers, columnWidths);
        printSeparator(columnWidths);
    }

    void printMultiLineRow(String[] row, int[] columnWidths) {
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

    String[] wrapText(String text, int width) {
        int lines = (int) Math.ceil((double) text.length() / width);
        String[] result = new String[lines];

        for (int i = 0; i < lines; i++) {
            int start = i * width;
            int end = Math.min(start + width, text.length());
            result[i] = text.substring(start, end);
        }

        return result;
    }

    static void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+-" + "-".repeat(width) + "-");
        }
        System.out.println("+");
    }

    static void printRow(String[] row, int[] columnWidths) {
        for (int i = 0; i < row.length; i++) {
            System.out.printf("| %-" + columnWidths[i] + "s ", row[i]);
        }
        System.out.println("|");
    }
}
