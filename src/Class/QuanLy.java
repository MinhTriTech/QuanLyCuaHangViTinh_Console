package Class;

import StaticMethod.StaticMethod;

public class QuanLy extends TaiKhoan {
    public QuanLy() {
    }

    public QuanLy(String maTk, String tenDn, String matKhau, String hoVaTen, String quyenTk) {
        super(maTk, tenDn, matKhau, hoVaTen, quyenTk);
    }

//    Các phương thức

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void nhap() {
        String temp;
        setRandomId();

        StaticMethod.sc.nextLine();
        do {
            System.out.print("Nhap ten dang nhap: ");
            temp = StaticMethod.sc.nextLine();}
        while(checkTenDangNhap(temp.trim())==true);
        setTenDn(temp.trim());

        System.out.print("Nhap ho va ten: ");
        temp = StaticMethod.sc.nextLine();
        setHoVaTen(temp.trim());

        System.out.print("Nhap mat khau: ");
        temp = StaticMethod.sc.nextLine();

        String temp_test;
        do {
            System.out.print("Nhap lai mat khau: ");
            temp_test = StaticMethod.sc.nextLine();}
        while(!temp.equals(temp_test));
        setMatKhau(temp);

        setQuyenTk("QL");
    }

    @Override
    public void nhapDeSua() {
        String temp;

        System.out.print("Nhap ho va ten moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();
        if (temp.isEmpty()) {
        } else {
            setHoVaTen(temp.trim());
        }

        System.out.print("Nhap mat khau moi(Nhan Enter de giu thong tin cu): ");
        temp = StaticMethod.sc.nextLine();

        if (temp.isEmpty()) {
        } else {
            String temp_test;
            do {
                System.out.print("Nhap lai mat khau: ");
                temp_test = StaticMethod.sc.nextLine();}
            while(!temp.equals(temp_test));
            setMatKhau(temp);
        }
    }

    @Override
    public void xuatThongTinTk() {
        int[] columnWidths = {10, 20, 10, 25, 10, 20, 30, 20};
        String[] values = {
                getMaTk(), getTenDn(), getMatKhau(),
                getHoVaTen(), getQuyenTk(), "",
                "", ""
        };

        StaticMethod.printMultiLineRow(values, columnWidths);
        StaticMethod.printSeparator(columnWidths);
    }

    @Override
    public void nhapDeCapNhatMatKhau() {

    }
}
