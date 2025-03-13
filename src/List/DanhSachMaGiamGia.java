package List;

import Class.MaGiamGia;
import Interface.IDanhSach;
import StaticMethod.StaticMethod;

import java.io.*;
import java.util.Arrays;

public class DanhSachMaGiamGia implements IDanhSach {
    private MaGiamGia[] dsMaGiamGia = new MaGiamGia[1];

    @Override
    public void them() {
        try {
            File file = new File(StaticMethod.FILE_NAME_MGG);

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter fr = new BufferedWriter(new FileWriter(file, true));

            MaGiamGia maGiamGia = new MaGiamGia();
            System.out.println("--Nhap thong tin");
            maGiamGia.nhap();

            fr.write(maGiamGia.toString());
            fr.newLine();
            System.out.println("-Tao ma giam gia thanh cong-");

            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua() {

    }

    @Override
    public void xoa() {
        try {
            File file = new File(StaticMethod.FILE_NAME_MGG);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            fw.close();

            if (count > 0) {
                dsMaGiamGia = Arrays.copyOf(dsMaGiamGia, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsMaGiamGia.length; i++) {
                    String s[] = ft.readLine().split(";");
                    dsMaGiamGia[i] = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                }

                boolean signal = false;
                boolean signal_1 = false;
                String maGg, check;
                System.out.println("--Nhap ma giam gia can xoa");
                maGg = StaticMethod.sc.nextLine();
                maGg = maGg.toUpperCase().trim();

                for (int i = 0; i < dsMaGiamGia.length; i++) {
                    if (dsMaGiamGia[i].getMaGg().equals(maGg) && dsMaGiamGia[i].getTrangThai().equals("Hoat dong")) {
                        do {
                            System.out.println("--Ban co chac muon xoa ma giam gia " + dsMaGiamGia[i].getMaGg() + " khong?(Nhap Co hoac Khong de xac nhan)");
                            signal = true;
                            check = StaticMethod.sc.nextLine();
                            if (check.toLowerCase().equals("co") || check.toLowerCase().equals("c")) {
                                signal_1 = true;
                            }
                            if (check.toLowerCase().equals("khong") || check.toLowerCase().equals("k")) {
                                signal_1 = false;
                            }
                        } while (!check.toLowerCase().equals("co") && !check.toLowerCase().equals("c") && !check.toLowerCase().equals("khong") && !check.toLowerCase().equals("k"));
                    }
                }

                if (signal == true && signal_1 == true) {
                    BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                    for (int i = 0; i < dsMaGiamGia.length; i++) {
                        if (!dsMaGiamGia[i].getMaGg().equals(maGg)) {
                            fr.write(dsMaGiamGia[i].toString());
                            fr.newLine();
                        } else {
                            dsMaGiamGia[i].setTrangThai("Het han");
                            fr.write(dsMaGiamGia[i].toString());
                            fr.newLine();
                        }
                    }
                    fr.close();

                    System.out.println("-Xoa ma giam gia thanh cong-");
                }

                if (signal == true && signal_1 == false) {
                    System.out.println("-Huy thao tac xoa ma giam gia-");
                }

                if (signal == false && signal_1 == false) {
                    System.out.println("-Khong tim thay ma giam gia tuong ung voi ma-");
                }

                ft.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them ma giam gia de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xuat() {
        try {
            String st;
            System.out.println("+--------------DANH SACH MA GIAM GIA-----------------+");
            StaticMethod.xuatHeaderMgg();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

            for (int i = 1; (st = br.readLine()) != null; i++) {
                String s[] = st.split(";");
                if (s[4].equals("Hoat dong")) {
                    MaGiamGia mgg = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                    mgg.xuatThongTinMgg();
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoMaGg() {
        try {
            String st, maGg;
            boolean check = false;
            System.out.println("--Nhap ma giam gia ban muon tim(Co the nhap chinh xac ma giam gia hoac nhap ma chu):");
            maGg = StaticMethod.sc.nextLine();
            maGg = maGg.toUpperCase().trim();
            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderMgg();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

            if (maGg.isEmpty()) {

            } else {
                for (int i = 1; (st = br.readLine()) != null; i++) {
                    String s[] = st.split(";");
                    if (s[4].equals("Hoat dong")) {
                        MaGiamGia mgg = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                        if (mgg.getMaGg().equals(maGg) || mgg.getMaChu().contains(maGg)) {
                            check = true;
                            mgg.xuatThongTinMgg();
                        }
                    }
                }
            }

            br.close();

            if (check == false) {
                System.out.println("+--------------KHONG CO MA GIAM GIA TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoPhanTramGiam() {
        try {
            String st, phanTramBatDau, phanTramKetThuc;
            boolean check = false;

            do {
                System.out.println("--Nhap so % bat dau(Nhan Enter de gan gia tri tu 0%):");
                phanTramBatDau = StaticMethod.sc.nextLine();
                if (phanTramBatDau.isEmpty()) {
                    break;
                }
            }
            while (!StaticMethod.checkKm(phanTramBatDau.trim()));
            if (phanTramBatDau.isEmpty()) {
                phanTramBatDau = "0";
            }

            do {
                System.out.println("--Nhap so % ket thuc, khong duoc nho hon % bat dau(Nhan Enter de gan gia tri tu 100%):");
                phanTramKetThuc = StaticMethod.sc.nextLine();
                if (phanTramKetThuc.isEmpty()) {
                    break;
                }
            }
            while (!StaticMethod.checkKm(phanTramKetThuc.trim()) || Integer.parseInt(phanTramKetThuc) < Integer.parseInt(phanTramBatDau));
            if (phanTramKetThuc.isEmpty()) {
                phanTramKetThuc = "100";
            }


            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderMgg();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

            for (int i = 1; (st = br.readLine()) != null; i++) {
                String s[] = st.split(";");
                if (s[4].equals("Hoat dong")) {
                    MaGiamGia mgg = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                    if (Integer.parseInt(mgg.getPhanTramGiam()) >= Integer.parseInt(phanTramBatDau) && Integer.parseInt(mgg.getPhanTramGiam()) <= Integer.parseInt(phanTramKetThuc)) {
                        check = true;
                        mgg.xuatThongTinMgg();
                    }
                }
            }

            br.close();

            if (check == false) {
                System.out.println("+--------------KHONG CO MA GIAM GIA TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void timKiemTheoGiaTriGiam() {
        try {
            String st, min, max;
            boolean check = false;

            do {
                System.out.println("--Nhap so tien bat dau(Nhan Enter de gan gia tri tu 0):");
                min = StaticMethod.sc.nextLine();
                if (min.isEmpty()) {
                    break;
                }
            }
            while (!StaticMethod.checkGia(min.trim()));
            if (min.isEmpty()) {
                min = "0";
            }

            do {
                System.out.println("--Nhap so tien ket thuc, khong duoc nho hon so tien bat dau:");
                max = StaticMethod.sc.nextLine();
                if (max.isEmpty()) {
                    max = "0";
                }
            }
            while (!StaticMethod.checkGia(max.trim()) || Double.parseDouble(max) < Double.parseDouble(min));


            System.out.println("+--------------KET QUA TIM KIEM-----------------+");
            StaticMethod.xuatHeaderMgg();

            BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

            for (int i = 1; (st = br.readLine()) != null; i++) {
                String s[] = st.split(";");
                if (s[4].equals("Hoat dong")) {
                    MaGiamGia mgg = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                    if (Double.parseDouble(mgg.getGiaTriToiDa()) >= Double.parseDouble(min) && Double.parseDouble(mgg.getGiaTriToiDa()) <= Double.parseDouble(max)) {
                        check = true;
                        mgg.xuatThongTinMgg();
                    }
                }
            }

            br.close();

            if (check == false) {
                System.out.println("+--------------KHONG CO MA GIAM GIA TUONG UNG-----------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xuatMaGgHetHan() {
        String st, maGg;
        try {
            File file = new File(StaticMethod.FILE_NAME_MGG);

            if (!file.exists()) {
                file.createNewFile();
            }

            int count = 0;

            BufferedReader fw = new BufferedReader(new FileReader(file));
            while (fw.readLine() != null) {
                count++;
            }

            fw.close();

            if (count > 0) {
                dsMaGiamGia = Arrays.copyOf(dsMaGiamGia, count);

                BufferedReader ft = new BufferedReader(new FileReader(file));

                for (int i = 0; i < dsMaGiamGia.length; i++) {
                    String s[] = ft.readLine().split(";");
                    dsMaGiamGia[i] = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                }

                boolean signal = false;
                boolean signal_1 = false;
                String check, checkWhile = "1";

                while (checkWhile.equals("1")) {
                    System.out.println("+--------------DANH SACH MA GIAM GIA-----------------+");
                    StaticMethod.xuatHeaderMgg();

                    BufferedReader br = new BufferedReader(new FileReader(StaticMethod.FILE_NAME_MGG));

                    for (int i = 1; (st = br.readLine()) != null; i++) {
                        String s[] = st.split(";");
                        if (s[4].equals("Het han")) {
                            MaGiamGia mgg = new MaGiamGia(s[0], s[1], s[2], s[3], s[4]);
                            mgg.xuatThongTinMgg();
                        }
                    }

                    System.out.println("--Nhap ma giam gia can khoi phuc hoac nhap e de thoat");
                    maGg = StaticMethod.sc.nextLine();
                    maGg = maGg.toUpperCase().trim();

                    switch (maGg) {
                        case "E":
                            checkWhile = "0";
                            break;
                        default:
                            for (int i = 0; i < dsMaGiamGia.length; i++) {
                                if (dsMaGiamGia[i].getMaGg().equals(maGg) && dsMaGiamGia[i].getTrangThai().equals("Het han")) {
                                    do {
                                        System.out.println("--Ban co chac muon khoi phuc ma giam gia " + dsMaGiamGia[i].getMaGg() + " khong?(Nhap Co hoac Khong de xac nhan)");
                                        signal = true;
                                        check = StaticMethod.sc.nextLine();
                                        if (check.toLowerCase().equals("co") || check.toLowerCase().equals("c")) {
                                            signal_1 = true;
                                        }
                                        if (check.toLowerCase().equals("khong") || check.toLowerCase().equals("k")) {
                                            signal_1 = false;
                                        }
                                    } while (!check.toLowerCase().equals("co") && !check.toLowerCase().equals("c") && !check.toLowerCase().equals("khong") && !check.toLowerCase().equals("k"));
                                }
                            }

                            if (signal && signal_1) {
                                BufferedWriter fr = new BufferedWriter(new FileWriter(file, false));
                                for (int i = 0; i < dsMaGiamGia.length; i++) {
                                    if (!dsMaGiamGia[i].getMaGg().equals(maGg)) {
                                        fr.write(dsMaGiamGia[i].toString());
                                        fr.newLine();
                                    } else {
                                        dsMaGiamGia[i].setTrangThai("Hoat dong");
                                        fr.write(dsMaGiamGia[i].toString());
                                        fr.newLine();
                                    }
                                }
                                fr.close();

                                System.out.println("-Khoi phuc ma giam gia thanh cong-");
                            }

                            if (signal && !signal_1) {
                                System.out.println("-Huy thao tac khoi phuc ma giam gia-");
                            }

                            if (!signal && !signal_1) {
                                System.out.println("-Khong tim thay ma giam gia tuong ung voi ma-");
                            }
                            break;
                    }
                    br.close();
                }
                ft.close();
            } else {
                System.out.println("-Danh sach dang trong vui long them ma giam gia de thuc hien thao tac-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
