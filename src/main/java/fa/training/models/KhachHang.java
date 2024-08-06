package fa.training.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class KhachHang {
	@Id
	@Pattern(regexp = "^KH\\d{3}$", message = "Nhập không đúng định dạng (KHxxx)")
	private String id;

	@NotBlank(message = "Trường không được để trống")
	private String name;

	@NotBlank(message = "Trường không được để trống")
	private String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDay;

	private String address;

	private String phone;

	private String type;

	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MauDat> mauDats;

	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<GiaoDich> giaoDichs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<MauDat> getMauDats() {
		return mauDats;
	}

	public void setMauDats(Set<MauDat> mauDats) {
		this.mauDats = mauDats;
	}

	public Set<GiaoDich> getGiaoDichs() {
		return giaoDichs;
	}

	public void setGiaoDichs(Set<GiaoDich> giaoDichs) {
		this.giaoDichs = giaoDichs;
	}

	public KhachHang() {
	}

	public KhachHang(@Pattern(regexp = "^KH\\d{3}$", message = "Nhập không đúng định dạng (KHxxx)") String id,
			@NotBlank(message = "Trường không được để trống") String name,
			@NotBlank(message = "Trường không được để trống") String gender, LocalDate birthDay, String address,
			String phone, String type) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDay = birthDay;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDay=" + birthDay + ", address="
				+ address + ", phone=" + phone + ", type=" + type + "]";
	}

}
