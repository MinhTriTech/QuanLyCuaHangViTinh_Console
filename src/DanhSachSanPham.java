import java.io.*;
import java.util.Arrays;

public class DanhSachSanPham implements IDanhSach{
    private static final String FILE_NAME_SP = "DanhSachSanPham.txt";

    SanPham[] dsSanPham = new SanPham[1];

    @Override
    public void them() {
        try {
            File file = new File(FILE_NAME_SP);

            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("Nhap so luong san pham can them: ");
            int slTemp = QuanLyCuaHang.sc.nextInt();
            for (int i = 1; i<= slTemp; i++) {
                System.out.println("===Chon loai san pham can them: ===");
                System.out.println("1. Laptop");
                System.out.println("2. Phu kien");
                System.out.println("3. Tai nghe/Loa");
                System.out.print("Nhap:");
                int luaChonSp = QuanLyCuaHang.sc.nextInt();

                if (luaChonSp == 1) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    Laptop sp = new Laptop();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
                if (luaChonSp == 2) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    PhuKien sp = new PhuKien();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
                if (luaChonSp == 3) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

                    TaiNgheLoa sp = new TaiNgheLoa();
                    sp.nhap();

                    fr.write(sp.toString());
                    fr.newLine();
                    fr.close();

                    System.out.println("-Them san pham thanh cong-");
                }
            }
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
        try {
            String st;
            System.out.println("+--------------DANH SACH SAN PHAM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[7].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    sp.xuatThongTinSp();
                }
                else if (s[7].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    sp.xuatThongTinSp();
                } else {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    sp.xuatThongTinSp();
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoMaSp() {
        try {
            String st, maSp;
            boolean check = false;
            QuanLyCuaHang.sc.nextLine();
            System.out.println("Nhap ma san pham ban muon tim:");
            maSp = QuanLyCuaHang.sc.nextLine();
            maSp = maSp.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[7].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                else if (s[7].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                } else {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(sp.getMaSp().equals(maSp)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO SAN PHAM TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTongQuatSp() {
        try {
            String st, thongTin;
            boolean check = false;
            QuanLyCuaHang.sc.nextLine();
            System.out.println("Nhap thong tin san pham ban muon tim:");
            thongTin = QuanLyCuaHang.sc.nextLine();
            thongTin = thongTin.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            SanPham.xuatHeaderSp();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_SP));

            for(int i=1; (st = br.readLine()) != null ; i++) {
                String s[] = st.split(";");
                if (s[7].equals("LAPTOP")) {
                    Laptop sp = new Laptop(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                        || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                            || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)
                                || sp.getDungLuong().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
                else if (s[7].equals("PHUKIEN")) {
                    PhuKien sp = new PhuKien(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                                || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                } else {
                    TaiNgheLoa sp = new TaiNgheLoa(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
                    if(sp.getMaSp().contains(thongTin) || sp.getTenSp().contains(thongTin)
                            || sp.getGia().contains(thongTin) || sp.getMoTa().contains(thongTin)
                                || sp.getMauSac().contains(thongTin) || sp.getLoaiSp().contains(thongTin)) {
                        check = true;
                        sp.xuatThongTinSp();
                    }
                }
            }

            br.close();

            if(check == false) {
                System.out.println("+--------------KHONG CO SAN PHAM TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
