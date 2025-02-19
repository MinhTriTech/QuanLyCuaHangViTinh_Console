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

    private static final String FILE_NAME_SP = "DanhSachTaiKhoan.txt";

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
                String line = reader.readLine();
                if (line != null) {
                    String []mang = line.split(";");
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

    abstract void nhap();
}
