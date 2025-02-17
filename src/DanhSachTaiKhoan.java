import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTaiKhoan implements IDanhSach{

    private static final String FILE_NAME = "DanhSachTaiKhoan.txt";

    TaiKhoan[] dsTaiKhoan = new TaiKhoan[1];

    @Override
    public void them() {
//        try {
//            File file = new File(FILE_NAME);
//
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            int count = 0;
//
//            BufferedReader fw = new BufferedReader(new FileReader(file));
//            while (fw.readLine() != null) {
//                count++;
//            }
//
//            dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, count);
//
//            BufferedReader ft = new BufferedReader(new FileReader(file));
//
//            for (int i = 0; i < dsTaiKhoan.length; i++) {
//                String s[] = ft.readLine().split(";");
//                dsTaiKhoan[i] = new HoaDon(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
//            }
//
//            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));
//            boolean signal = false;
//            HoaDon hd = new HoaDon();
//            System.out.println("--Nhap thong tin hoa don--");
//            hd.nhap();
//
//            if (signal == false) {
//                fr.write(hd.toString());
//                fr.newLine();
//                System.out.println("-Them hoa don thanh cong-");
//            }
//
//            fr.close();
//            ft.close();
//            fw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void themKh() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            dsTaiKhoan = Arrays.copyOf(dsTaiKhoan, count);

            BufferedReader ft = new BufferedReader(new FileReader(file));

            for (int i = 0; i < dsTaiKhoan.length; i++) {
                String s[] = ft.readLine().split(";");
                if(s[3].equals("KH")) {
                    dsTaiKhoan[i] = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                } else {
                    dsTaiKhoan[i] = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                }
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));
            boolean signal = false;
            TaiKhoan tk = new KhachHang();
            System.out.println("--Nhap thong tin dang ky--");
            tk.nhap();

            if (signal == false) {
                fr.write(tk.toString());
                fr.newLine();
                System.out.println("-Dang ky thanh cong-");
            }

            fr.close();
            ft.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {

    }

    @Override
    public void xuat() {

    }
}
