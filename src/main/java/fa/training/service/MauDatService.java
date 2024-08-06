package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.MauDat;

//Định nghĩa một interface MauDatService để quản lý các thao tác liên quan đến đối tượng MauDat
public interface MauDatService {
	
	// Phương thức để lưu hoặc cập nhật thông tin của một đối tượng MauDat
	void saveOrUpdate(MauDat detail);

	// Phương thức để lấy danh sách tất cả các đối tượng MauDat từ cơ sở dữ liệu
	List<MauDat> findAll();

	// Phương thức để tìm một đối tượng MauDat dựa trên id
	MauDat findByID(String id);

	// Phương thức để xóa một đối tượng MauDat dựa trên id
	void deleteById(String id);

	// Phương thức để lấy danh sách các đối tượng MauDat theo trang từ cơ sở dữ liệu
	Page<MauDat> findAll(Pageable pageable);

	// Phương thức để lấy danh sách các đối tượng MauDat theo điều kiện tìm kiếm và phân trang
	Page<MauDat> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức để kiểm tra xem một đối tượng MauDat có tồn tại trong cơ sở dữ liệu hay không dựa trên id
	boolean existByID(String id);
}

