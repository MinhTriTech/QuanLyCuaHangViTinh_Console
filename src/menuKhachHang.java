public class menuKhachHang {
    public menuKhachHang() {
        init();
    }

    public void init() {
        int checkMenu_2 = 1, menu_2;
        DanhSachSanPham dsSanPham = new DanhSachSanPham();

        while (checkMenu_2 == 1) {
            System.out.println("===Chon===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly hoa don");
            System.out.println("3. Sua thong tin tai khoan");
            System.out.println("4. Dang xuat");
            System.out.print("Nhap:");
            menu_2 = QuanLyCuaHang.sc.nextInt();

            if (menu_2 == 1) {
                int checkMenu_2_1 = 1, menu_2_1;
                while (checkMenu_2_1 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Mua san pham");
                    System.out.println("2. Xem danh sach san pham");
                    System.out.println("3. Tim san pham");
                    System.out.println("4. Thoat");
                    System.out.print("Nhap:");
                    menu_2_1 = QuanLyCuaHang.sc.nextInt();

                    if (menu_2_1 == 1) {
                        String checkMenu_2_1_1 = "", menu_2_1_1;
                        dsSanPham.xuat();
                        QuanLyCuaHang.sc.nextLine();
                        while (checkMenu_2_1_1 == "") {
                            System.out.println("Xem danh sach san pham theo:");
                            System.out.println("===Chon===");
                            System.out.println("1. Theo thu tu mac dinh");
                            System.out.println("2. Theo gia tu thap den cao");
                            System.out.println("3. Theo gia tu cao den thap");
                            System.out.println("4. Theo danh muc Laptop");
                            System.out.println("5. Theo danh muc Phu kien");
                            System.out.println("6. Theo danh muc Tai nghe/Loa");
                            System.out.println("7. Tim kiem san pham");
                            System.out.println("Nhap cac so ben tren de loc san pham:");
                            System.out.println("Hoac?");
                            System.out.println("Nhap ma san pham muon mua (Nhap a de thanh toan | Nhap e de thoat(Xoa tat ca san pham trong gio hang)):");
                            menu_2_1_1 = QuanLyCuaHang.sc.nextLine();

                            switch (menu_2_1_1) {
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
                                    dsSanPham.xuatTheoDmLaptop();
                                    break;
                                case "5":
                                    dsSanPham.xuatTheoDmPhuKien();
                                    break;
                                case "6":
                                    dsSanPham.xuatTheoDmTaiNgheLoa();
                                    break;
                                case "7":
                                    int checkMenu_2_1_1_1 = 1, menu_2_1_1_1;
                                    while (checkMenu_2_1_1_1 == 1) {
                                        System.out.println("===Chon===");
                                        System.out.println("1. Tim kiem theo ma san pham");
                                        System.out.println("2. Tim kiem tong quat");
                                        System.out.println("3. Thoat");
                                        System.out.print("Nhap:");
                                        menu_2_1_1_1 = QuanLyCuaHang.sc.nextInt();

                                        if (menu_2_1_1_1 == 1) {
                                            dsSanPham.timKiemTheoMaSp();
                                        }
                                        if (menu_2_1_1_1 == 2) {
                                            dsSanPham.timKiemTongQuatSp();
                                        }
                                        if (menu_2_1_1_1 == 3) {
                                            checkMenu_2_1_1_1 = 0;
                                        }
                                    }
                                    break;
                                case "e":
                                    checkMenu_2_1_1 = "e";
                                    break;
                                case "a":
                                    System.out.println("Thanh toan");
                                    break;
                                default:
                                    System.out.println("Check ma sp");
                                    break;
                            }
                        }
                    }
                    if (menu_2_1 == 2) {
                        System.out.println("Khach hang xem tat ca san pham");
                    }
                    if (menu_2_1 == 3) {
                        int checkMenu_2_1_1 = 1, menu_2_1_1;
                        while (checkMenu_2_1_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tim kiem theo ma san pham");
                            System.out.println("2. Tim kiem tong quat");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_2_1_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_2_1_1 == 1) {
                                System.out.println("Khach hang tim kiem theo ma san pham");
                            }
                            if (menu_2_1_1 == 2) {
                                System.out.println("Khach hang tim kiem san pham tong quat");
                            }
                            if (menu_2_1_1 == 3) {
                                checkMenu_2_1_1 = 0;
                            }
                        }
                    }
                    if (menu_2_1 == 4) {
                        checkMenu_2_1 = 0;
                    }
                }
            }
            if (menu_2 == 2) {
                int checkMenu_2_2 = 1, menu_2_2;
                while (checkMenu_2_2 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Xem tat ca hoa don");
                    System.out.println("2. Tim kiem hoa don");
                    System.out.println("3. Thoat");
                    System.out.print("Nhap:");
                    menu_2_2 = QuanLyCuaHang.sc.nextInt();

                    if (menu_2_2 == 1) {
                        System.out.println("Khach hang xem tat ca hoa don cua minh");
                    }
                    if (menu_2_2 == 2) {
                        int checkMenu_2_2_1 = 1, menu_2_2_1;
                        while (checkMenu_2_2_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tim kiem theo ma hoa don");
                            System.out.println("2. Tim kiem tong quat");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_2_2_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_2_2_1 == 1) {
                                System.out.println("Khach hang tim kiem hoa don cua minh theo ma");
                            }
                            if (menu_2_2_1 == 2) {
                                System.out.println("Khach hang tim kiem hoa don cua minh tong quat");
                            }
                            if (menu_2_2_1 == 3) {
                                checkMenu_2_2_1 = 0;
                            }
                        }
                    }
                    if (menu_2_2 == 3) {
                        checkMenu_2_2 = 0;
                    }
                }
            }
            if (menu_2 == 3) {
                System.out.println("Khach hang sua thong tin tai khoan");
            }
            if (menu_2 == 4) {
                checkMenu_2 = 0;
            }
        }
    }
}
