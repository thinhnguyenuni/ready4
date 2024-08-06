package fa.training.models;

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

@Entity
public class KhuDoThi {
	@Id
	@Pattern(regexp = "^KDT\\d{2}$", message = "Nhập không đúng định dạng (KDTxx)")
	private String id;

	@NotBlank(message = "Trường không được để trống")
	private String name;

	@OneToMany(mappedBy = "khuDoThi", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<MauDat> mauDats;

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

	public Set<MauDat> getMauDats() {
		return mauDats;
	}

	public void setMauDats(Set<MauDat> mauDats) {
		this.mauDats = mauDats;
	}

	public KhuDoThi() {
	}

	public KhuDoThi(@Pattern(regexp = "^KDT\\d{2}$", message = "Nhập không đúng định dạng (KDTxx)") String id,
			@NotBlank(message = "Trường không được để trống") String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "KhuDoThi [id=" + id + ", name=" + name + "]";
	}

}
