import java.io.*;
import java.util.Arrays;

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

    public void dangKyKh() {
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
                if(s[4].equals("KH")) {
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

    public String dangNhap() {
        String check = "false";
        boolean check_2 = false;
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            QuanLyCuaHang.sc.nextLine();
            System.out.println("--Nhap thong tin dang nhap--");
            System.out.print("Nhap ten dang nhap: ");
            String tenDn = QuanLyCuaHang.sc.nextLine();
            System.out.print("Nhap mat khau: ");
            String matKhau = QuanLyCuaHang.sc.nextLine();

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if(s[4].equals("KH")) {
                    TaiKhoan tk = new KhachHang(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
                    if (tk.getTenDn().equals(tenDn) && tk.getMatKhau().equals(matKhau)) {
                        check = "KH";
                        check_2 = true;
                        System.out.println("Dang nhap thanh cong !!!");
                        System.out.println("Xin chao khach hang " + tk.getHoVaTen());
                    }
                } else {
                    TaiKhoan tk = new QuanLy(s[0], s[1], s[2], s[3], s[4]);
                    if (tk.getTenDn().equals(tenDn) && tk.getMatKhau().equals(matKhau)) {
                        check = "QL";
                        check_2 = true;
                        System.out.println("Dang nhap thanh cong !!!");
                        System.out.println("Xin chao quan ly " + tk.getHoVaTen());
                    }
                }
            }

            br.close();
            if(!check_2) {
                System.out.println("Sai ten dang nhap hoac mat khau !!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
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
