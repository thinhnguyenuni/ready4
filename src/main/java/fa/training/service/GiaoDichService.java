package fa.training.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.GiaoDich;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface GiaoDichService để quản lý các thao tác liên quan đến đối tượng GiaoDich
public interface GiaoDichService {

	// Phương thức để lưu hoặc cập nhật thông tin giao dịch
	void saveOrUpdate(GiaoDich giaoDich);

	// Phương thức để tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable);

	// Phương thức để tìm một giao dịch dựa trên id
	GiaoDich findById(String id);

	// Phương thức để kiểm tra xem có sự trùng lặp mã khách hàng trong giao dịch
	// không
	boolean duplicateMaKH(GiaoDich giaoDich);
	
	// Phương thức để xóa một đối tượng giao dich dựa trên id
	void deleteById(String id);
}
