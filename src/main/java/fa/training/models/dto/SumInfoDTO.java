package fa.training.models.dto;

import java.time.LocalDate;

public class SumInfoDTO {
	private String maMauDat;
	private String tenChuSoHuu;
	private Integer chieuRong;
	private Integer chieuDai;
	private Long giaGoc;
	private String maGiaoDich;
	private String maKhachHang;
	private Long giaGiaoDich;
	private Long tienDatCoc;
	private LocalDate ngayDatCoc;
	private LocalDate ngayThanhToan;
	private String trangThai;

	public String getMaMauDat() {
		return maMauDat;
	}

	public void setMaMauDat(String maMauDat) {
		this.maMauDat = maMauDat;
	}

	public String getTenChuSoHuu() {
		return tenChuSoHuu;
	}

	public void setTenChuSoHuu(String tenChuSoHuu) {
		this.tenChuSoHuu = tenChuSoHuu;
	}

	public Integer getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(Integer chieuRong) {
		this.chieuRong = chieuRong;
	}

	public Integer getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(Integer chieuDai) {
		this.chieuDai = chieuDai;
	}

	public Long getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(Long giaGoc) {
		this.giaGoc = giaGoc;
	}

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Long getGiaGiaoDich() {
		return giaGiaoDich;
	}

	public void setGiaGiaoDich(Long giaGiaoDich) {
		this.giaGiaoDich = giaGiaoDich;
	}

	public Long getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(Long tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	public LocalDate getNgayDatCoc() {
		return ngayDatCoc;
	}

	public void setNgayDatCoc(LocalDate ngayDatCoc) {
		this.ngayDatCoc = ngayDatCoc;
	}

	public LocalDate getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(LocalDate ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public SumInfoDTO() {
	}

	public SumInfoDTO(String maMauDat, String tenChuSoHuu, Integer chieuRong, Integer chieuDai, Long giaGoc,
			String maGiaoDich, String maKhachHang, Long giaGiaoDich, Long tienDatCoc, LocalDate ngayDatCoc,
			LocalDate ngayThanhToan, String trangThai) {
		this.maMauDat = maMauDat;
		this.tenChuSoHuu = tenChuSoHuu;
		this.chieuRong = chieuRong;
		this.chieuDai = chieuDai;
		this.giaGoc = giaGoc;
		this.maGiaoDich = maGiaoDich;
		this.maKhachHang = maKhachHang;
		this.giaGiaoDich = giaGiaoDich;
		this.tienDatCoc = tienDatCoc;
		this.ngayDatCoc = ngayDatCoc;
		this.ngayThanhToan = ngayThanhToan;
		this.trangThai = trangThai;
	}

}
