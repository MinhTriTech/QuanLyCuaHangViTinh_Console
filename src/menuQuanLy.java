public class menuQuanLy {
    public menuQuanLy() {
        init();
    }

    public void init() {
        int checkMenu_3 = 1, menu_3;
        DanhSachSanPham dsSanPham = new DanhSachSanPham();
        DanhSachTaiKhoan dsTaiKhoan = new DanhSachTaiKhoan();
        DanhSachMaGiamGia dsMaGiamGia = new DanhSachMaGiamGia();

        while (checkMenu_3 == 1) {
            System.out.println("===Chon===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly hoa don");
            System.out.println("3. Thong ke");
            System.out.println("4. Quan ly tai khoan");
            System.out.println("5. Quan ly khuyen mai");
            System.out.println("6. Dang xuat");
            System.out.print("Nhap:");
            menu_3 = QuanLyCuaHang.sc.nextInt();

            if (menu_3 == 1) {
                int checkMenu_3_1 = 1, menu_3_1;
                while (checkMenu_3_1 == 1) {
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
                    menu_3_1 = QuanLyCuaHang.sc.nextInt();

                    if (menu_3_1 == 1) {
                        int checkMenu_3_1_2 = 1, menu_3_1_2;
                        while (checkMenu_3_1_2 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Theo thu tu mac dinh");
                            System.out.println("2. Theo gia tu thap den cao");
                            System.out.println("3. Theo gia tu cao den thap");
                            System.out.println("4. Theo danh muc");
                            System.out.println("5. Thoat");
                            System.out.print("Nhap:");
                            menu_3_1_2 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_1_2 == 1) {
                                dsSanPham.xuat();
                            }
                            if (menu_3_1_2 == 2) {
                                dsSanPham.xuatTheoGiaThapDenCao();
                            }
                            if (menu_3_1_2 == 3) {
                                dsSanPham.xuatTheoGiaCaoDenThap();
                            }
                            if (menu_3_1_2 == 4) {
                                int checkMenu_3_1_2_1 = 1, menu_3_1_2_1;
                                while (checkMenu_3_1_2_1 == 1) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Laptop");
                                    System.out.println("2. Phu kien");
                                    System.out.println("3. Tai nghe/Loa");
                                    System.out.println("4. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_1_2_1 = QuanLyCuaHang.sc.nextInt();

                                    if (menu_3_1_2_1 == 1) {
                                        dsSanPham.xuatTheoDmLaptop();
                                    }
                                    if (menu_3_1_2_1 == 2) {
                                        dsSanPham.xuatTheoDmPhuKien();
                                    }
                                    if (menu_3_1_2_1 == 3) {
                                        dsSanPham.xuatTheoDmTaiNgheLoa();
                                    }
                                    if (menu_3_1_2_1 == 4) {
                                        checkMenu_3_1_2_1 = 0;
                                    }
                                }
                            }
                            if (menu_3_1_2 == 5) {
                                checkMenu_3_1_2 = 0;
                            }
                        }
                    }
                    if (menu_3_1 == 2) {
                        dsSanPham.them();
                    }
                    if (menu_3_1 == 3) {
                        dsSanPham.sua();
                    }
                    if (menu_3_1 == 4) {
                        dsSanPham.xoa();
                    }
                    if (menu_3_1 == 5) {
                        int checkMenu_3_1_1 = 1, menu_3_1_1;
                        while (checkMenu_3_1_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tim kiem theo ma san pham");
                            System.out.println("2. Tim kiem tong quat");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_1_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_1_1 == 1) {
                                dsSanPham.timKiemTheoMaSp();
                            }
                            if (menu_3_1_1 == 2) {
                                dsSanPham.timKiemTongQuatSp();
                            }
                            if (menu_3_1_1 == 3) {
                                checkMenu_3_1_1 = 0;
                            }
                        }
                    }
                    if (menu_3_1 == 6) {
                        System.out.println("Quan ly nhap san pham");
                    }
                    if (menu_3_1 == 7) {
                        System.out.println("Quan ly xuat san pham");
                    }
                    if (menu_3_1 == 8) {
                        checkMenu_3_1 = 0;
                    }
                }
            }
            if (menu_3 == 2) {
                int checkMenu_3_2 = 1, menu_3_2;
                while (checkMenu_3_2 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Xem tat ca hoa don");
                    System.out.println("2. Tim kiem hoa don");
                    System.out.println("3. Xoa hoa don");
                    System.out.println("4. Xem lai hoa don da xoa");
                    System.out.println("5. Thoat");
                    System.out.print("Nhap:");
                    menu_3_2 = QuanLyCuaHang.sc.nextInt();

                    if (menu_3_2 == 1) {
                        System.out.println("Quan ly xem tat ca hoa don");
                    }
                    if (menu_3_2 == 2) {
                        int checkMenu_3_2_1 = 1, menu_3_2_1;
                        while (checkMenu_3_2_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tim kiem theo ma hoa don");
                            System.out.println("2. Tim kiem tong quat");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_2_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_2_1 == 1) {
                                System.out.println("Quan ly tim kiem hoa don theo ma");
                            }
                            if (menu_3_2_1 == 2) {
                                System.out.println("Quan ly tim kiem hoa don tong quat");
                            }
                            if (menu_3_2_1 == 3) {
                                checkMenu_3_2_1 = 0;
                            }
                        }
                    }
                    if (menu_3_2 == 5) {
                        checkMenu_3_2 = 0;
                    }
                }
            }
            if (menu_3 == 3) {
                int checkMenu_3_3 = 1, menu_3_3;
                while (checkMenu_3_3 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Thong ke so ban");
                    System.out.println("2. Thong ke nhap/xuat");
                    System.out.println("3. Thoat");
                    System.out.print("Nhap:");
                    menu_3_3 = QuanLyCuaHang.sc.nextInt();

                    if (menu_3_3 == 1) {
                        int checkMenu_3_3_1 = 1, menu_3_3_1;
                        while (checkMenu_3_3_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Thong ke theo thang");
                            System.out.println("2. Thong ke tu ngay den ngay");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_3_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_3_1 == 1) {
                                int checkMenu_3_3_1_1 = 1, menu_3_3_1_1;
                                while (checkMenu_3_3_1_1 == 1) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo san pham");
                                    System.out.println("2. Tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_1_1 = QuanLyCuaHang.sc.nextInt();

                                    if (menu_3_3_1_1 == 1) {
                                        System.out.println("Quan ly thong ke so ban theo thang (ma san pham)");
                                    }
                                    if (menu_3_3_1_1 == 2) {
                                        System.out.println("Quan ly thong ke so ban theo thang (tong quat)");
                                    }
                                    if (menu_3_3_1_1 == 3) {
                                        checkMenu_3_3_1_1 = 0;
                                    }
                                }
                            }
                            if (menu_3_3_1 == 2) {
                                int checkMenu_3_3_1_2 = 1, menu_3_3_1_2;
                                while (checkMenu_3_3_1_2 == 1) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo san pham");
                                    System.out.println("2. Tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_1_2 = QuanLyCuaHang.sc.nextInt();

                                    if (menu_3_3_1_2 == 1) {
                                        System.out.println("Quan ly thong ke so ban tu ngay den ngay (ma san pham)");
                                    }
                                    if (menu_3_3_1_2 == 2) {
                                        System.out.println("Quan ly thong ke so ban tu ngay den ngay (tong quat)");
                                    }
                                    if (menu_3_3_1_2 == 3) {
                                        checkMenu_3_3_1_2 = 0;
                                    }
                                }
                            }
                            if (menu_3_3_1 == 3) {
                                checkMenu_3_3_1 = 0;
                            }
                        }
                    }
                    if (menu_3_3 == 2) {
                        int checkMenu_3_3_2 = 1, menu_3_3_2;
                        while (checkMenu_3_3_2 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Thong ke theo thang");
                            System.out.println("2. Thong ke tu ngay den ngay");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_3_2 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_3_2 == 1) {
                                int checkMenu_3_3_2_1 = 1, menu_3_3_2_1;
                                while (checkMenu_3_3_2_1 == 1) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo san pham");
                                    System.out.println("2. Tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_2_1 = QuanLyCuaHang.sc.nextInt();

                                    if (menu_3_3_2_1 == 1) {
                                        System.out.println("Quan ly thong ke nhap/xuat theo thang (ma san pham)");
                                    }
                                    if (menu_3_3_2_1 == 2) {
                                        System.out.println("Quan ly thong ke nhap/xuat theo thang (tong quat)");
                                    }
                                    if (menu_3_3_2_1 == 3) {
                                        checkMenu_3_3_2_1 = 0;
                                    }
                                }
                            }
                            if (menu_3_3_2 == 2) {
                                int checkMenu_3_3_2_2 = 1, menu_3_3_2_2;
                                while (checkMenu_3_3_2_2 == 1) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo san pham");
                                    System.out.println("2. Tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_3_3_2_2 = QuanLyCuaHang.sc.nextInt();

                                    if (menu_3_3_2_2 == 1) {
                                        System.out.println("Quan ly thong ke nhap/xuat tu ngay den ngay (ma san pham)");
                                    }
                                    if (menu_3_3_2_2 == 2) {
                                        System.out.println("Quan ly thong ke nhap/xuat tu ngay den ngay (tong quat)");
                                    }
                                    if (menu_3_3_2_2 == 3) {
                                        checkMenu_3_3_2_2 = 0;
                                    }
                                }
                            }
                            if (menu_3_3_2 == 3) {
                                checkMenu_3_3_2 = 0;
                            }
                        }
                    }
                    if (menu_3_3 == 3) {
                        checkMenu_3_3 = 0;
                    }
                }
            }
            if (menu_3 == 4) {
                int checkMenu_3_4 = 1, menu_3_4;
                while (checkMenu_3_4 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Xem danh sach tai khoan");
                    System.out.println("2. Them tai khoan");
                    System.out.println("3. Sua tai khoan");
                    System.out.println("4. Xoa tai khoan");
                    System.out.println("5. Tim kiem tai khoan");
                    System.out.println("6. Thoat");
                    System.out.print("Nhap:");
                    menu_3_4 = QuanLyCuaHang.sc.nextInt();

                    if (menu_3_4 == 1) {
                        int checkMenu_3_4_3 = 1, menu_3_4_3;
                        while (checkMenu_3_4_3 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Theo thu tu mac dinh");
                            System.out.println("2. Theo thu tu quan ly - khach hang");
                            System.out.println("3. Theo thu tu khach hang - quan ly");
                            System.out.println("4. Thoat");
                            System.out.print("Nhap:");
                            menu_3_4_3 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_4_3 == 1) {
                                dsTaiKhoan.xuat();
                            }
                            if (menu_3_4_3 == 2) {
                                dsTaiKhoan.xuatDanhSachTkQlFirst();
                            }
                            if (menu_3_4_3 == 3) {
                                dsTaiKhoan.xuatDanhSachTkKhFirst();
                            }
                            if (menu_3_4_3 == 4) {
                                checkMenu_3_4_3 = 0;
                            }
                        }
                    }
                    if (menu_3_4 == 2) {
                        int checkMenu_3_4_1 = 1, menu_3_4_1;
                        while (checkMenu_3_4_1 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tai khoan khach hang");
                            System.out.println("2. Tai khoan quan ly");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_4_1 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_4_1 == 1) {
                                dsTaiKhoan.dangKyKh();
                            }
                            if (menu_3_4_1 == 2) {
                                dsTaiKhoan.them();
                            }
                            if (menu_3_4_1 == 3) {
                                checkMenu_3_4_1 = 0;
                            }
                        }
                    }
                    if (menu_3_4 == 3) {
                        dsTaiKhoan.sua();
                    }
                    if (menu_3_4 == 4) {
                        dsTaiKhoan.xoa();
                    }
                    if (menu_3_4 == 5) {
                        int checkMenu_3_4_2 = 1, menu_3_4_2;
                        while (checkMenu_3_4_2 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Tim kiem theo ma tai khoan");
                            System.out.println("2. Tim kiem tong quat");
                            System.out.println("3. Thoat");
                            System.out.print("Nhap:");
                            menu_3_4_2 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_4_2 == 1) {
                                dsTaiKhoan.timKiemTheoMaTk();
                            }
                            if (menu_3_4_2 == 2) {
                                dsTaiKhoan.timKiemTongQuatTk();
                            }
                            if (menu_3_4_2 == 3) {
                                checkMenu_3_4_2 = 0;
                            }
                        }
                    }
                    if (menu_3_4 == 6) {
                        checkMenu_3_4 = 0;
                    }
                }
            }
            if (menu_3 == 5) {
                int checkMenu_3_5 = 1, menu_3_5;
                while (checkMenu_3_5 == 1) {
                    System.out.println("===Chon===");
                    System.out.println("1. Xem danh sach ma khuyen mai theo hoa don");
                    System.out.println("2. Them ma khuyen mai theo hoa don");
                    System.out.println("3. Tim kiem ma khuyen mai theo hoa don");
                    System.out.println("4. Xoa ma khuyen mai theo hoa don");
                    System.out.println("5. Khoi phuc ma khuyen mai");
                    System.out.println("6. Cai dat ma khuyen mai theo san pham");
                    System.out.println("7. Thoat");
                    System.out.print("Nhap:");
                    menu_3_5 = QuanLyCuaHang.sc.nextInt();
                    if (menu_3_5 == 1) {
                        int checkMenu_3_4_3 = 1, menu_3_4_3;
                        while (checkMenu_3_4_3 == 1) {
                            System.out.println("===Chon===");
                            System.out.println("1. Theo thu tu mac dinh");
                            System.out.println("2. Theo thu tu quan ly - khach hang");
                            System.out.println("3. Theo thu tu khach hang - quan ly");
                            System.out.println("4. Thoat");
                            System.out.print("Nhap:");
                            menu_3_4_3 = QuanLyCuaHang.sc.nextInt();

                            if (menu_3_4_3 == 1) {
                                dsTaiKhoan.xuat();
                            }
                            if (menu_3_4_3 == 2) {
                                dsTaiKhoan.xuatDanhSachTkQlFirst();
                            }
                            if (menu_3_4_3 == 3) {
                                dsTaiKhoan.xuatDanhSachTkKhFirst();
                            }
                            if (menu_3_4_3 == 4) {
                                checkMenu_3_4_3 = 0;
                            }
                        }
                    }
                    if (menu_3_5 == 2) {
                        dsMaGiamGia.them();
                    }
                }
            }
            if (menu_3 == 6) {
                checkMenu_3 = 0;
            }
        }
    }
}
