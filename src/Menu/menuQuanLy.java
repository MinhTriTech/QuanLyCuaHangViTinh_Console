package Menu;

import List.DanhSachHoaDon;
import List.DanhSachMaGiamGia;
import List.DanhSachSanPham;
import List.DanhSachTaiKhoan;
import StaticMethod.StaticMethod;

public class menuQuanLy {
    public menuQuanLy() {
        init();
    }

    public void init() {
        String checkMenu_3 = "1", menu_3;
        DanhSachSanPham dsSanPham = new DanhSachSanPham();
        DanhSachTaiKhoan dsTaiKhoan = new DanhSachTaiKhoan();
        DanhSachMaGiamGia dsMaGiamGia = new DanhSachMaGiamGia();
        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();

        while (checkMenu_3.equals("1")) {
            System.out.println("===Chon===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly khuyen mai");
            System.out.println("3. Quan ly hoa don");
            System.out.println("4. Thong ke");
            System.out.println("5. Quan ly tai khoan");
            System.out.println("6. Dang xuat");
            System.out.print("Nhap:");
            menu_3 = StaticMethod.sc.nextLine();

            switch (menu_3) {
                case "1":
                    String checkMenu_3_1 = "1", menu_3_1;
                    while (checkMenu_3_1.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Xem danh sach san pham");
                        System.out.println("2. Them san pham (root)");
                        System.out.println("3. Sua san pham");
                        System.out.println("4. Xoa san pham (root)");
                        System.out.println("5. Tim kiem san pham");
                        System.out.println("6. Nhap san pham");
                        System.out.println("7. Xuat san pham");
                        System.out.println("8. Thoat");
                        System.out.print("Nhap:");
                        menu_3_1 = StaticMethod.sc.nextLine();

                        switch (menu_3_1) {
                            case "1":
                                String checkMenu_3_1_2 = "1", menu_3_1_2;
                                while (checkMenu_3_1_2.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo thu tu mac dinh");
                                    System.out.println("2. Theo gia tu thap den cao");
                                    System.out.println("3. Theo gia tu cao den thap");
                                    System.out.println("4. Theo danh muc");
                                    System.out.println("5. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_1_2 = StaticMethod.sc.nextLine();

                                    switch (menu_3_1_2) {
                                        case "1":
                                            dsSanPham.xuat();
                                            break;
                                        case "2":
                                            dsSanPham.xuatTheoGiaThapDenCao();
                                            break;
                                        case "3":
                                            dsSanPham.xuatTheoGiaCaoDenThap();
                                            break;
                                        case "4":
                                            String checkMenu_3_1_2_1 = "1", menu_3_1_2_1;
                                            while (checkMenu_3_1_2_1.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Laptop");
                                                System.out.println("2. Phu kien");
                                                System.out.println("3. Tai nghe/Loa");
                                                System.out.println("4. Thoat");
                                                System.out.print("Nhap:");
                                                menu_3_1_2_1 = StaticMethod.sc.nextLine();

                                                switch (menu_3_1_2_1) {
                                                    case "1":
                                                        dsSanPham.xuatTheoDmLaptop();
                                                        break;
                                                    case "2":
                                                        dsSanPham.xuatTheoDmPhuKien();
                                                        break;
                                                    case "3":
                                                        dsSanPham.xuatTheoDmTaiNgheLoa();
                                                        break;
                                                    case "4":
                                                        checkMenu_3_1_2_1 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "5":
                                            checkMenu_3_1_2 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                dsSanPham.them();
                                break;
                            case "3":
                                dsSanPham.sua();
                                break;
                            case "4":
                                dsSanPham.xoa();
                                break;
                            case "5":
                                String checkMenu_3_1_1 = "1", menu_3_1_1;
                                while (checkMenu_3_1_1.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tim kiem theo ma san pham");
                                    System.out.println("2. Tim kiem tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_1_1 = StaticMethod.sc.nextLine();

                                    switch (menu_3_1_1) {
                                        case "1":
                                            dsSanPham.timKiemTheoMaSp();
                                            break;
                                        case "2":
                                            dsSanPham.timKiemTongQuatSp();
                                            break;
                                        case "3":
                                            checkMenu_3_1_1 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "6":
                                System.out.println("Quan ly nhap san pham");
                                break;
                            case "7":
                                System.out.println("Quan ly xuat san pham");
                                break;
                            case "8":
                                checkMenu_3_1 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "2":
                    String checkMenu_3_5 = "1", menu_3_5;
                    while (checkMenu_3_5.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Xem danh sach ma khuyen mai theo hoa don");
                        System.out.println("2. Them ma khuyen mai theo hoa don");
                        System.out.println("3. Tim kiem ma khuyen mai theo hoa don");
                        System.out.println("4. Xoa ma khuyen mai theo hoa don");
                        System.out.println("5. Khoi phuc ma khuyen mai");
                        System.out.println("6. Cai dat ma khuyen mai theo san pham");
                        System.out.println("7. Thoat");
                        System.out.print("Nhap:");
                        menu_3_5 = StaticMethod.sc.nextLine();

                        switch (menu_3_5) {
                            case "1":

                                break;
                            case "2":

                                break;
                            case "3":

                                break;
                            case "4":

                                break;
                            case "5":

                                break;
                            case "6":

                                break;
                            case "7":
                                checkMenu_3_5 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "3":
                    String checkMenu_3_2 = "1", menu_3_2;
                    while (checkMenu_3_2.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Xem tat ca hoa don");
                        System.out.println("2. Tim kiem hoa don");
                        System.out.println("3. Xoa hoa don");
                        System.out.println("4. Xem lai hoa don da xoa");
                        System.out.println("5. Thoat");
                        System.out.print("Nhap:");
                        menu_3_2 = StaticMethod.sc.nextLine();

                        switch (menu_3_2) {
                            case "1":
                                dsHoaDon.xuat();
                                break;
                            case "2":
                                String checkMenu_3_2_1 = "1", menu_3_2_1;
                                while (checkMenu_3_2_1.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tim kiem theo ma hoa don");
                                    System.out.println("2. Tim kiem tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_2_1 = StaticMethod.sc.nextLine();

                                    switch (menu_3_2_1) {
                                        case "1":
                                            System.out.println("Quan ly tim kiem hoa don theo ma hoa don va ma khach hang");
                                            break;
                                        case "2":
                                            System.out.println("Quan ly tim kiem hoa don tong quat");
                                            break;
                                        case "3":
                                            checkMenu_3_2_1 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                System.out.println("Quan ly xoa hoa don");
                                break;
                            case "4":
                                System.out.println("Quan ly xem lai cac hoa don da xoa va co the khoi phuc");
                                break;
                            case "5":
                                checkMenu_3_2 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "4":
                    String checkMenu_3_3 = "1", menu_3_3;
                    while (checkMenu_3_3.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Thong ke so ban");
                        System.out.println("2. Thong ke nhap/xuat");
                        System.out.println("3. Thoat");
                        System.out.print("Nhap:");
                        menu_3_3 = StaticMethod.sc.nextLine();

                        switch (menu_3_3) {
                            case "1":
                                String checkMenu_3_3_1 = "1", menu_3_3_1;
                                while (checkMenu_3_3_1.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Thong ke theo thang");
                                    System.out.println("2. Thong ke tu ngay den ngay");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_1 = StaticMethod.sc.nextLine();

                                    switch (menu_3_3_1) {
                                        case "1":
                                            String checkMenu_3_3_1_1 = "1", menu_3_3_1_1;
                                            while (checkMenu_3_3_1_1.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Theo san pham");
                                                System.out.println("2. Tong quat");
                                                System.out.println("3. Thoat");
                                                System.out.print("Nhap:");
                                                menu_3_3_1_1 = StaticMethod.sc.nextLine();

                                                switch (menu_3_3_1_1) {
                                                    case "1":
                                                        System.out.println("Quan ly thong ke so ban theo thang (ma san pham)");
                                                        break;
                                                    case "2":
                                                        System.out.println("Quan ly thong ke so ban theo thang (tong quat)");
                                                        break;
                                                    case "3":
                                                        checkMenu_3_3_1_1 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "2":
                                            String checkMenu_3_3_1_2 = "1", menu_3_3_1_2;
                                            while (checkMenu_3_3_1_2.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Theo san pham");
                                                System.out.println("2. Tong quat");
                                                System.out.println("3. Thoat");
                                                System.out.print("Nhap:");
                                                menu_3_3_1_2 = StaticMethod.sc.nextLine();

                                                switch (menu_3_3_1_2) {
                                                    case "1":
                                                        System.out.println("Quan ly thong ke so ban tu ngay den ngay (ma san pham)");
                                                        break;
                                                    case "2":
                                                        System.out.println("Quan ly thong ke so ban tu ngay den ngay (tong quat)");
                                                        break;
                                                    case "3":
                                                        checkMenu_3_3_1_2 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "3":
                                            checkMenu_3_3_1 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                String checkMenu_3_3_2 = "1", menu_3_3_2;
                                while (checkMenu_3_3_2.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Thong ke theo thang");
                                    System.out.println("2. Thong ke tu ngay den ngay");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_2 = StaticMethod.sc.nextLine();

                                    switch (menu_3_3_2) {
                                        case "1":
                                            String checkMenu_3_3_2_1 = "1", menu_3_3_2_1;
                                            while (checkMenu_3_3_2_1.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Theo san pham");
                                                System.out.println("2. Tong quat");
                                                System.out.println("3. Thoat");
                                                System.out.print("Nhap:");
                                                menu_3_3_2_1 = StaticMethod.sc.nextLine();

                                                switch (menu_3_3_2_1) {
                                                    case "1":
                                                        System.out.println("Quan ly thong ke nhap/xuat theo thang (ma san pham)");
                                                        break;
                                                    case "2":
                                                        System.out.println("Quan ly thong ke nhap/xuat theo thang (tong quat)");
                                                        break;
                                                    case "3":
                                                        checkMenu_3_3_2_1 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "2":
                                            String checkMenu_3_3_2_2 = "1", menu_3_3_2_2;
                                            while (checkMenu_3_3_2_2.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Theo san pham");
                                                System.out.println("2. Tong quat");
                                                System.out.println("3. Thoat");
                                                System.out.print("Nhap:");
                                                menu_3_3_2_2 = StaticMethod.sc.nextLine();

                                                switch (menu_3_3_2_2) {
                                                    case "1":
                                                        System.out.println("Quan ly thong ke nhap/xuat tu ngay den ngay (ma san pham)");
                                                        break;
                                                    case "2":
                                                        System.out.println("Quan ly thong ke nhap/xuat tu ngay den ngay (tong quat)");
                                                        break;
                                                    case "3":
                                                        checkMenu_3_3_2_2 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "3":
                                            checkMenu_3_3_2 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                checkMenu_3_3 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "5":
                    String checkMenu_3_4 = "1", menu_3_4;
                    while (checkMenu_3_4.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Xem danh sach tai khoan");
                        System.out.println("2. Them tai khoan");
                        System.out.println("3. Sua tai khoan");
                        System.out.println("4. Xoa tai khoan");
                        System.out.println("5. Tim kiem tai khoan");
                        System.out.println("6. Thoat");
                        System.out.print("Nhap:");
                        menu_3_4 = StaticMethod.sc.nextLine();

                        switch (menu_3_4) {
                            case "1":
                                String checkMenu_3_4_3 = "1", menu_3_4_3;
                                while (checkMenu_3_4_3.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo thu tu mac dinh");
                                    System.out.println("2. Theo thu tu quan ly - khach hang");
                                    System.out.println("3. Theo thu tu khach hang - quan ly");
                                    System.out.println("4. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_4_3 = StaticMethod.sc.nextLine();

                                    switch (menu_3_4_3) {
                                        case "1":
                                            dsTaiKhoan.xuat();
                                            break;
                                        case "2":
                                            dsTaiKhoan.xuatDanhSachTkQlFirst();
                                            break;
                                        case "3":
                                            dsTaiKhoan.xuatDanhSachTkKhFirst();
                                            break;
                                        case "4":
                                            checkMenu_3_4_3 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                String checkMenu_3_4_1 = "1", menu_3_4_1;
                                while (checkMenu_3_4_1.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tai khoan khach hang");
                                    System.out.println("2. Tai khoan quan ly");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_4_1 = StaticMethod.sc.nextLine();

                                    switch (menu_3_4_1) {
                                        case "1":
                                            dsTaiKhoan.dangKyKh();
                                            break;
                                        case "2":
                                            dsTaiKhoan.them();
                                            break;
                                        case "3":
                                            checkMenu_3_4_1 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                dsTaiKhoan.sua();
                                break;
                            case "4":
                                dsTaiKhoan.xoa();
                                break;
                            case "5":
                                String checkMenu_3_4_2 = "1", menu_3_4_2;
                                while (checkMenu_3_4_2.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tim kiem theo ma tai khoan");
                                    System.out.println("2. Tim kiem tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_4_2 = StaticMethod.sc.nextLine();

                                    switch (menu_3_4_2) {
                                        case "1":
                                            dsTaiKhoan.timKiemTheoMaTk();
                                            break;
                                        case "2":
                                            dsTaiKhoan.timKiemTongQuatTk();
                                            break;
                                        case "3":
                                            checkMenu_3_4_2 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "6":
                                checkMenu_3_4 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "6":
                    checkMenu_3 = "0";
                    break;
                default:
                    System.out.println("--Lua chon khong hop le");
                    break;
            }
        }
    }
}
