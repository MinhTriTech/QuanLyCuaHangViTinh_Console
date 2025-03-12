import List.DanhSachTaiKhoan;
import Menu.menuKhachHang;
import Menu.menuQuanLy;
import Class.TaiKhoan;

import java.util.Scanner;

public class QuanLyCuaHang {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String checkMenu_1 = "1", menu_1;
        DanhSachTaiKhoan dsTaiKhoan = new DanhSachTaiKhoan();

        while (checkMenu_1.equals("1")) {
            System.out.println("===Chon===");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky");
            System.out.println("3. Thoat");
            System.out.print("Nhap:");
            menu_1 = sc.nextLine();

            switch (menu_1) {
                case "1":
                    TaiKhoan kq = dsTaiKhoan.dangNhap();

                    if(kq != null) {
                        if(kq.getQuyenTk().equals("KH")) {
                            menuKhachHang mnKH = new menuKhachHang(kq.getMaTk());
                        } else if(kq.getQuyenTk().equals("QL")) {
                            menuQuanLy mnQL = new menuQuanLy();
                        }
                    }
                    break;
                case "2":
                    dsTaiKhoan.dangKyKh();
                    break;
                case "3":
                    checkMenu_1 = "0";
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        }
    }
}
