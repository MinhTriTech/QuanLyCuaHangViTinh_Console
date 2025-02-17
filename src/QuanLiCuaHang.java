import java.util.Scanner;

public class QuanLiCuaHang {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int checkMenu_1 = 1, menu_1;
        DanhSachTaiKhoan dsTaiKhoan = new DanhSachTaiKhoan();

        while (checkMenu_1 == 1) {
            System.out.println("===Chon===");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky");
            System.out.println("3. Thoat");
            System.out.print("Nhap:");
            menu_1 = sc.nextInt();

            if (menu_1 == 1) {
                System.out.println("Dang dang nhap...");
            }
            if (menu_1 == 2) {
                dsTaiKhoan.themKh();
            }
            if (menu_1 == 3) {
                checkMenu_1 = 0;
            }

        }
    }
}
