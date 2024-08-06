package fa.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.GiaoDich;
import fa.training.models.KhachHang;
import fa.training.models.MauDat;
import fa.training.models.dto.SumInfoDTO;
import fa.training.repository.GiaoDichRepository;
import fa.training.service.GiaoDichService;
import fa.training.service.KhachHangService;
import fa.training.service.MauDatService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class GiaoDichServiceImpl implements GiaoDichService {
	// Tự động inject GiaoDichRepository để thực hiện các thao tác liên quan đến GiaoDich
	@Autowired
	private GiaoDichRepository repository;
	
	// Tự động inject MauDatService để sử dụng các phương thức liên quan đến MauDat
	@Autowired
	private MauDatService mauDatService;
	
	// Tự động inject KhachHangService để sử dụng các phương thức liên quan đến KhachHang
	@Autowired
	private KhachHangService khachHangService;

	// Phương thức lưu hoặc cập nhật thông tin của một giao dịch
	@Override
	public void saveOrUpdate(GiaoDich giaoDich) {
		// Kiểm tra nếu giao dịch là null thì in ra thông báo và trở về
		if(giaoDich==null) {
			System.out.println("Không khởi tạo được đối tượng"); 
			return;
		}
		// Lưu hoặc cập nhật thông tin của giao dịch vào cơ sở dữ liệu
		repository.save(giaoDich);
	}

	// Phương thức tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	@Override
	public Page<SumInfoDTO> findAllWithSearch(String searchInput, Pageable pageable) {
		return repository.findAllWithSearch(searchInput, pageable);
	}

	// Phương thức tìm một giao dịch dựa trên id
	@Override
	public GiaoDich findById(String id) {
		return repository.findById(id).orElse(null);
	}

	// Phương thức kiểm tra xem có sự trùng lặp mã khách hàng trong giao dịch không
	@Override
	public boolean duplicateMaKH(GiaoDich giaoDich) {
		// Lấy mã khách hàng từ giao dịch
		String maKH = giaoDich.getKhachHang().getId();
		System.out.println("MaKH" + maKH);
		
		// Tìm mẫu đất dựa trên id của giao dịch
		MauDat mauDat = mauDatService.findByID(giaoDich.getMauDat().getId());
		
		// Lấy thông tin khách hàng từ mẫu đất
		KhachHang khachHang = khachHangService.findByID(mauDat.getKhachHang().getId());
		// Lấy mã chủ sở hữu từ thông tin khách hàng
		String maChuSoHuu =khachHang.getId();
		
		// So sánh mã khách hàng với mã chủ sở hữu
		if(maKH.equals(maChuSoHuu)) {
			return true;
		}
		return false;
	}
	
	// Phương thức để xóa một mẫu đất dựa trên id
	@Override
	public void deleteById(String id) {
		// Xóa mẫu đất dựa trên id
		repository.deleteById(id);
	}
}
