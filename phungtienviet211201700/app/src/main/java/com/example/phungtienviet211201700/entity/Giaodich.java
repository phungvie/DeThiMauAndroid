package com.example.phungtienviet211201700.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
@Entity
public class Giaodich {
    @PrimaryKey(autoGenerate = true)
    private int ma;
    private String noiDung;

    private String hoTen;
    private Date ngayThang;
    private boolean loaiGiaoDich;
    private long phiGiaoDich;
    private long soDu;
    public static final long A=00;

    public Giaodich(int ma, String noiDung, Date ngayThang, String hoTen, boolean loaiGiaoDich, long phiGiaoDich, long soDu) {
        this.ma = ma;
        this.noiDung = noiDung;
        this.ngayThang = ngayThang;
        this.hoTen = hoTen;
        this.loaiGiaoDich = loaiGiaoDich;
        this.phiGiaoDich = phiGiaoDich;
        this.soDu = soDu;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(Date ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(boolean loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public long getPhiGiaoDich() {
        return phiGiaoDich;
    }

    public void setPhiGiaoDich(long phiGiaoDich) {
        this.phiGiaoDich = phiGiaoDich;
    }

    public long getSoDu() {
        return soDu;
    }

    public void setSoDu(long soDu) {
        this.soDu = soDu;
    }

    @Override
    public String toString() {
        return "Giaodich{" +
                "ma=" + ma +
                ", noiDung='" + noiDung + '\'' +
                ", ngayThang=" + ngayThang +
                ", hoTen='" + hoTen + '\'' +
                ", loaiGiaoDich=" + loaiGiaoDich +
                ", phiGiaoDich=" + phiGiaoDich +
                ", soDu=" + soDu +
                '}';
    }
    public static long tinhPhiGD(long soTien){
        if(soTien<3000000){
            return (A+1)*1000;
        }else{
            return (A+1)*1500;
        }

    }
    public long tinhSoDu(boolean loaiGiaoDich,long SoTien,long phiGiaoDich){
        if(loaiGiaoDich){
            return this.soDu+SoTien-phiGiaoDich;
        }else {
            return this.soDu-SoTien-phiGiaoDich;
        }
    }
}
