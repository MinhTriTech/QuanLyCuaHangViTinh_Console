package ActionClass;

import Class.SanPham;

public class MuaHangAction {
    private SanPham[] dsSanPhamKhongHopLe;
    private SanPham[] dsSanPhamKhoConLai;

    public MuaHangAction() {
    }

    public MuaHangAction(SanPham[] dsSanPhamKhongHopLe, SanPham[] dsSanPhamKhoConLai) {
        this.dsSanPhamKhongHopLe = dsSanPhamKhongHopLe;
        this.dsSanPhamKhoConLai = dsSanPhamKhoConLai;
    }

    public SanPham[] getDsSanPhamKhongHopLe() {
        return dsSanPhamKhongHopLe;
    }

    public void setDsSanPhamKhongHopLe(SanPham[] dsSanPhamKhongHopLe) {
        this.dsSanPhamKhongHopLe = dsSanPhamKhongHopLe;
    }

    public SanPham[] getDsSanPhamKhoConLai() {
        return dsSanPhamKhoConLai;
    }

    public void setDsSanPhamKhoConLai(SanPham[] dsSanPhamKhoConLai) {
        this.dsSanPhamKhoConLai = dsSanPhamKhoConLai;
    }
}
