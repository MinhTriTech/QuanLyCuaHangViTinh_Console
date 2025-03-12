package Menu;

import ActionClass.MuaHangAction;
import List.DanhSachHoaDon;
import List.DanhSachPhieuXuat;
import List.DanhSachSanPham;
import Class.SanPham;
import Class.Laptop;
import Class.PhuKien;
import Class.TaiNgheLoa;
import List.DanhSachSanPhamDaXuat;
import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public class menuKhachHang {

    public menuKhachHang(String maKh) {
        init(maKh);
    }

    public void init(String maKh) {
        String checkMenu_2 = "1", menu_2;
        DanhSachSanPham dsSanPham = new DanhSachSanPham();
        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
        DanhSachSanPhamDaXuat dsSanPhamDaXuat = new DanhSachSanPhamDaXuat();
        DanhSachPhieuXuat dsPhieuXuat = new DanhSachPhieuXuat();

        SanPham[] dsSanPhamTrongGioHang = new SanPham[0];
        SanPham[] dsSanPhamHienTai = new SanPham[1];

        while (checkMenu_2.equals("1")) {
            System.out.println("===Chon===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly hoa don");
            System.out.println("3. Doi mat khau");
            System.out.println("4. Dang xuat");
            System.out.print("Nhap:");
            menu_2 = StaticMethod.sc.nextLine();

            switch (menu_2) {
                case "1":
                    String checkMenu_2_1 = "1", menu_2_1;
                    while (checkMenu_2_1.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Mua san pham");
                        System.out.println("2. Xem danh sach san pham");
                        System.out.println("3. Tim san pham");
                        System.out.println("4. Thoat");
                        System.out.print("Nhap:");
                        menu_2_1 = StaticMethod.sc.nextLine();

                        switch (menu_2_1) {
                            case "1":
                                String checkMenu_2_1_1 = "1", menu_2_1_1;
                                dsSanPham.xuat();
                                while (checkMenu_2_1_1.equals("1")) {
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
                                    System.out.println("Nhap ma san pham muon mua (Nhap s de xem gio hang | Nhap d de xoa san pham trong gio | Nhap a de thanh toan | Nhap e de thoat):");
                                    menu_2_1_1 = StaticMethod.sc.nextLine();

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
                                            String checkMenu_2_1_1_1 = "1", menu_2_1_1_1;
                                            while (checkMenu_2_1_1_1.equals("1")) {
                                                System.out.println("===Chon===");
                                                System.out.println("1. Tim kiem theo ma san pham");
                                                System.out.println("2. Tim kiem tong quat");
                                                System.out.println("3. Thoat");
                                                System.out.print("Nhap:");
                                                menu_2_1_1_1 = StaticMethod.sc.nextLine();

                                                switch (menu_2_1_1_1) {
                                                    case "1":
                                                        dsSanPham.timKiemTheoMaSp();
                                                        break;
                                                    case "2":
                                                        dsSanPham.timKiemTongQuatSp();
                                                        break;
                                                    case "3":
                                                        checkMenu_2_1_1_1 = "0";
                                                        break;
                                                    default:
                                                        System.out.println("--Lua chon khong hop le");
                                                        break;
                                                }
                                            }
                                            break;
                                        case "e":
                                            checkMenu_2_1_1 = "0";
                                            break;
                                        case "a":
                                            if(dsSanPhamTrongGioHang.length == 0) {
                                                System.out.println("--Gio hang trong");
                                            }
                                            else {
                                                Double tongTien = 0.0;
                                                String tongTienDaLamTron = "";
                                                MuaHangAction muaHangAction = new MuaHangAction();
                                                SanPham[] sanPhamKhongDatDieuKien = new SanPham[0];
                                                SanPham[] sanPhamTrongKhoConLai = new SanPham[0];

//                                        Kiểm tra danh sách sản phẩm trong giỏ hàng
                                                muaHangAction = StaticMethod.checkDsSanPhamTrongGio(dsSanPhamTrongGioHang);
                                                sanPhamKhongDatDieuKien = Arrays.copyOf(muaHangAction.getDsSanPhamKhongHopLe(), muaHangAction.getDsSanPhamKhongHopLe().length);
                                                sanPhamTrongKhoConLai = Arrays.copyOf(muaHangAction.getDsSanPhamKhoConLai(), muaHangAction.getDsSanPhamKhoConLai().length);

//                                        Nếu danh sách trả ra rỗng thì tất cả sản phẩm trong giỏ đều hợp lệ
                                                if(sanPhamKhongDatDieuKien.length == 0) {

//                                            Tiến hành trừ trực tiếp vào kho
//                                            Ghi đè mảng sản phẩm còn lại lên file danh sách sản phẩm
                                                    try {
                                                        File file = new File(StaticMethod.FILE_NAME_SP);

                                                        if (!file.exists()) {
                                                            file.createNewFile();
                                                        }
                                                        BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));

                                                        for (int i = 0; i < sanPhamTrongKhoConLai.length; i++) {
                                                            fr.write(sanPhamTrongKhoConLai[i].toStringGiaVon());
                                                            fr.newLine();
                                                        }
                                                        fr.close();
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
//                                            Tạo hóa đơn
                                                    for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                        tongTien += Double.parseDouble(dsSanPhamTrongGioHang[i].getGia());
                                                        tongTienDaLamTron = String.format("%.2f", tongTien);
                                                    }


//                                            Trừ số tiền mã khuyến mãi
                                                    String maHd = dsHoaDon.themHd(maKh, tongTienDaLamTron);

//                                            Thêm các sản phẩm hợp lệ vào file sản phẫm đã xuất
                                                    dsSanPhamDaXuat.themDanhSachVaoFile(dsSanPhamTrongGioHang, maHd);

//                                            Tạo phiếu xuất đối tượng là khách hàng
                                                    dsPhieuXuat.themPx(maHd, maKh);

//                                            Xuất hóa đơn
                                                    StaticMethod.xuatHeaderHd();
                                                    dsHoaDon.timKiemTheoMaHdBool(maHd).xuatThongTinHd();

//                                            Hiển thị chi tiết hóa đơn
                                                    System.out.println("+--------------CHI TIET HOA DON-----------------+");
                                                    dsSanPhamDaXuat.xuatChiTietHoaDon(maHd);

//                                            Xóa giỏ hàng (xóa mảng danh sách sản phẩm trong giỏ hàng)
                                                    dsSanPhamTrongGioHang = new SanPham[0];

                                                }

//                                        Nếu không rỗng nghĩa là có nhiều hơn 1 sản phẩm không hợp lệ
                                                else {
                                                    System.out.println("--Cac san pham ben duoi khong du trong kho, vui long sap xep lai gio hang");
                                                    StaticMethod.xuatHeaderSpCoStt();
                                                    for (int i = 0; i < sanPhamKhongDatDieuKien.length; i++) {
                                                        sanPhamKhongDatDieuKien[i].xuatThongTinSpCoStt(String.valueOf(i + 1));
                                                    }
                                                }
                                            }
                                            break;
                                        case "s":
                                            StaticMethod.xuatHeaderSpCoStt();
                                            if(dsSanPhamTrongGioHang.length == 0) {
                                                System.out.println("--Gio hang trong");
                                            }
                                            else {
                                                for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                    dsSanPhamTrongGioHang[i].xuatThongTinSpCoStt(String.valueOf(i + 1));
                                                }
                                            }
                                            break;
                                        case "d":
                                            StaticMethod.xuatHeaderSpCoStt();
                                            if(dsSanPhamTrongGioHang.length == 0) {
                                                System.out.println("--Gio hang trong");
                                            }
                                            else {
                                                for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                    dsSanPhamTrongGioHang[i].xuatThongTinSpCoStt(String.valueOf(i + 1));
                                                }

                                                String stt;
                                                boolean check = true;

                                                do {
                                                    if(check) {
                                                        System.out.println("--Nhap so thu tu trong gio muon xoa");
                                                        check = false;
                                                    } else {
                                                        System.out.println("--Khong tim thay.Nhap lai so thu tu trong gio muon xoa");
                                                    }
                                                    stt = StaticMethod.sc.nextLine();}
                                                while(Integer.parseInt(stt) > dsSanPhamTrongGioHang.length || Integer.parseInt(stt) <= 0);

                                                SanPham[] dsSanPhamTrongGioHangTemp = new SanPham[dsSanPhamTrongGioHang.length - 1];

                                                for (int i = 0; i < Integer.parseInt(stt) - 1; i++) {
                                                    dsSanPhamTrongGioHangTemp[i] = dsSanPhamTrongGioHang[i];
                                                }

                                                for (int i = Integer.parseInt(stt) - 1; i < dsSanPhamTrongGioHangTemp.length; i++) {
                                                    dsSanPhamTrongGioHangTemp[i] = dsSanPhamTrongGioHang[i + 1];
                                                }

                                                dsSanPhamTrongGioHang = Arrays.copyOf(dsSanPhamTrongGioHang, dsSanPhamTrongGioHangTemp.length);

                                                for (int i = 0; i < dsSanPhamTrongGioHangTemp.length; i++) {
                                                    dsSanPhamTrongGioHang[i] = dsSanPhamTrongGioHangTemp[i];
                                                }

                                                System.out.println("--Xoa san pham thu " + stt + " thanh cong");

                                                StaticMethod.xuatHeaderSpCoStt();
                                                for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                    dsSanPhamTrongGioHang[i].xuatThongTinSpCoStt(String.valueOf(i + 1));
                                                }
                                            }
                                            break;
                                        default:
                                            if(dsSanPham.timKiemTheoMaSpBool(menu_2_1_1)) {
//                                        Tăng số lượng phần tử của mảng danh sách sản phẩm trong giỏ
                                                SanPham[] dsSanPhamTrongGioHangTemp = new SanPham[dsSanPhamTrongGioHang.length + 1];

                                                for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                    dsSanPhamTrongGioHangTemp[i] = dsSanPhamTrongGioHang[i];
                                                }

                                                dsSanPhamTrongGioHang = Arrays.copyOf(dsSanPhamTrongGioHang, dsSanPhamTrongGioHangTemp.length);

                                                for (int i = 0; i < dsSanPhamTrongGioHangTemp.length; i++) {
                                                    dsSanPhamTrongGioHang[i] = dsSanPhamTrongGioHangTemp[i];
                                                }

//                                        Thêm sản phẩm mới vào giỏ hàng
                                                dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1] = dsSanPham.themSanPhamVaoGioHang(menu_2_1_1);

                                                if(dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1] instanceof Laptop) {
                                                    Laptop temp = (Laptop) dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1];
                                                }

                                                if(dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1] instanceof PhuKien) {
                                                    PhuKien temp = (PhuKien) dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1];
                                                }

                                                if(dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1] instanceof TaiNgheLoa) {
                                                    TaiNgheLoa temp = (TaiNgheLoa) dsSanPhamTrongGioHang[dsSanPhamTrongGioHang.length-1];
                                                }

                                                System.out.println("--Them san pham vao gio hang thanh cong");

//                                        Hiển thị giỏ hàng hiện tại
                                                StaticMethod.xuatHeaderSpCoStt();
                                                if(dsSanPhamTrongGioHang.length == 0) {
                                                    System.out.println("--Gio hang trong");
                                                } else {
                                                    for (int i = 0; i < dsSanPhamTrongGioHang.length; i++) {
                                                        dsSanPhamTrongGioHang[i].xuatThongTinSpCoStt(String.valueOf(i + 1));
                                                    }
                                                }
                                            }
                                            else {
                                                System.out.println("--Khong tim thay ma san pham");
                                            }
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                String checkMenu_2_1_3 = "1", menu_2_1_3;
                                dsSanPham.xuat();
                                while (checkMenu_2_1_3.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo thu tu mac dinh");
                                    System.out.println("2. Theo gia tu thap den cao");
                                    System.out.println("3. Theo gia tu cao den thap");
                                    System.out.println("4. Theo danh muc Laptop");
                                    System.out.println("5. Theo danh muc Phu kien");
                                    System.out.println("6. Theo danh muc Tai nghe/Loa");
                                    System.out.println("7. Thoat");
                                    System.out.print("Nhap:");
                                    menu_2_1_3 = StaticMethod.sc.nextLine();

                                    switch (menu_2_1_3) {
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
                                            checkMenu_2_1_3 = "0";;
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                String checkMenu_2_1_2 = "1", menu_2_1_2;
                                while (checkMenu_2_1_2.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tim kiem theo ma san pham");
                                    System.out.println("2. Tim kiem tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_2_1_2 = StaticMethod.sc.nextLine();

                                    switch (menu_2_1_2) {
                                        case "1":
                                            dsSanPham.timKiemTheoMaSp();
                                            break;
                                        case "2":
                                            dsSanPham.timKiemTongQuatSp();
                                            break;
                                        case "3":
                                            checkMenu_2_1_2 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "4":
                                checkMenu_2_1 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "2":
                    String checkMenu_2_2 = "1", menu_2_2;
                    while (checkMenu_2_2.equals("1")) {
                        System.out.println("===Chon===");
                        System.out.println("1. Xem danh sach hoa don");
                        System.out.println("2. Tim kiem hoa don");
                        System.out.println("3. Thoat");
                        System.out.print("Nhap:");
                        menu_2_2 = StaticMethod.sc.nextLine();

                        switch (menu_2_2) {
                            case "1":
                                dsHoaDon.xuatDsHoaDonTheoMaKH(maKh);
                                String checkMenu_2_2_2 = "1", menu_2_2_2;
                                while (checkMenu_2_2_2.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Theo thu tu mac dinh");
                                    System.out.println("2. Theo gia tu thap den cao");
                                    System.out.println("3. Theo gia tu cao den thap");
                                    System.out.println("4. Theo thoi gian moi nhat");
                                    System.out.println("5. Theo thoi gian cu nhat");
                                    System.out.println("6. Thoat");
                                    System.out.print("Nhap:");
                                    menu_2_2_2 = StaticMethod.sc.nextLine();

                                    switch (menu_2_2_2) {
                                        case "1":
                                            dsHoaDon.xuatDsHoaDonTheoMaKH(maKh);
                                            break;
                                        case "2":
                                            dsHoaDon.xuatDsHoaDonTheoMaKHGiaThapDenCao(maKh);
                                            break;
                                        case "3":
                                            dsHoaDon.xuatDsHoaDonTheoMaKHGiaCaoDenThap(maKh);
                                            break;
                                        case "4":
                                            dsHoaDon.xuatDsHoaDonTheoMaKHThoiGianMoiNhat(maKh);
                                            break;
                                        case "5":
                                            dsHoaDon.xuatDsHoaDonTheoMaKHThoiGianCuNhat(maKh);
                                            break;
                                        case "6":
                                            checkMenu_2_2_2 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "2":
                                String checkMenu_2_2_1 = "1", menu_2_2_1;
                                while (checkMenu_2_2_1.equals("1")) {
                                    System.out.println("===Chon===");
                                    System.out.println("1. Tim kiem theo ma hoa don");
                                    System.out.println("2. Tim kiem tong quat");
                                    System.out.println("3. Thoat");
                                    System.out.print("Nhap:");
                                    menu_2_2_1 = StaticMethod.sc.nextLine();

                                    switch (menu_2_2_1) {
                                        case "1":
                                            dsHoaDon.timKiemTheoMaHd();
                                            break;
                                        case "2":
                                            dsHoaDon.timKiemTongQuatHd();
                                            break;
                                        case "3":
                                            checkMenu_2_2_1 = "0";
                                            break;
                                        default:
                                            System.out.println("--Lua chon khong hop le");
                                            break;
                                    }
                                }
                                break;
                            case "3":
                                checkMenu_2_2 = "0";
                                break;
                            default:
                                System.out.println("--Lua chon khong hop le");
                                break;
                        }
                    }
                    break;
                case "3":
                    StaticMethod.doiMatKhauTaiKhoan(maKh);
                    break;
                case "4":
                    checkMenu_2 = "0";
                    break;
                default:
                    System.out.println("--Lua chon khong hop le");
                    break;
            }
        }
    }
}
