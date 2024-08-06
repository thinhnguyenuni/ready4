<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row d-flex justify-content-center">
	<div class="col-md-12">
		<h2 class="col-12 text-center text-success text-uppercase mb-3">Thông
			tin giao dịch</h2>
		<div class="col-12 d-flex justify-content-center">
			<a href="${pageContext.request.contextPath}/maudat/create"
				class="btn btn-success">Tạo mới mẫu đất</a>
		</div>
		<div class="col-12">
			<!-- Dòng 5: Phần tìm kiếm và nút tìm kiếm -->
			<div class="row d-flex justify-content-end">
				<form action="list" method="get" class="w-25">
					<!-- Dòng 6: Form tìm kiếm -->
					<input type="hidden" name="pageSize" value="${pageSize}">
					<!-- Dòng 7: Trường ẩn lưu kích thước trang -->
					<div class="search input-group">

						<!-- Dòng 8: Input nhập thông tin tìm kiếm -->
						<input type="text" name="search"
							class="form-control search-input border-success"
							placeholder="Nhập mã mẫu đất" autocomplete="off"
							value="${search}">
						<!-- Dòng 9: Nút tìm kiếm -->
						<button class="btn btn-outline-success search-btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<!-- Dòng 10: Icon tìm kiếm -->
				<i class="far fa-search"></i>
			</div>
			<!-- Dòng 11: Bảng hiển thị thông tin giao dịch -->
			<div class="table-responsive">
				<table id="listTable"
					class="table table-hover table-striped table-content">
					<thead>
						<!-- Dòng 12: Tiêu đề các cột -->
						<tr>
							<th>STT</th>
							<th>Mã mẫu đất</th>
							<th>Tên chủ sở hữu</th>
							<th>Chiều rộng</th>
							<th>Chiều dài</th>
							<th>Giá gốc</th>
							<th>Mã giao dịch</th>
							<th>Mã khách hàng</th>
							<th>Giá giao dịch</th>
							<th>Tiền đặt cọc</th>
							<th>Ngày đặt cọc</th>
							<th>Ngày thanh toán</th>
							<th>Trạng thái</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<!-- Dòng 13-36: Vòng lặp để hiển thị thông tin giao dịch -->
						<c:forEach var="sumInfo" items="${sumInfos}" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${sumInfo.maMauDat}</td>
								<td>${sumInfo.tenChuSoHuu}</td>
								<td>${sumInfo.chieuRong}</td>
								<td>${sumInfo.chieuDai}</td>
								<td>${sumInfo.giaGoc}</td>
								<td>${sumInfo.maGiaoDich}</td>
								<td>${sumInfo.maKhachHang}</td>
								<td>${sumInfo.giaGiaoDich}</td>
								<td>${sumInfo.tienDatCoc}</td>
								<td>${sumInfo.ngayDatCoc}</td>
								<td>${sumInfo.ngayThanhToan}</td>
								<td>${sumInfo.trangThai}</td>
								<td><a href="update?id=${sumInfo.maGiaoDich}"
									class="btn btn-success">Update giao dịch</a>
									<button type="button" class="btn" data-bs-toggle="modal"
										data-bs-target="#computer${sumInfo.maGiaoDich}">
										<i class="fas fa-trash-alt text-danger"></i>
									</button> <!-- Modal -->
									<div class="modal fade" id="computer${sumInfo.maGiaoDich}"
										tabindex="-1" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Xóa máy
														tính</h5>
													<button type="button" class="btn-close"
														data-bs-dismiss="modal" aria-label="Close"></button>
												</div>
												<div class="modal-body">
													Bạn có muốn xóa giao dịch <span class="text-danger">${sumInfo.maGiaoDich}</span>
													này không ?
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Hủy</button>
													<a href="delete/${sumInfo.maGiaoDich}" class="btn btn-danger">Có</a>
												</div>
											</div>
										</div>
									</div>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class=row>
				<!-- Dòng 37-52: Hiển thị phân trang -->
				<div class="col-5">
					<!-- Dòng 37-47: Dropdown chọn số lượng dòng trên mỗi trang -->
					<div class="input-group mb-3">
						<label for="pageSizeSelect">Show </label> <select
							class="select mx-2 rounded px-1" id="pageSizeSelect">
							<!-- Dòng 39-45: Hiển thị danh sách kích thước trang và đánh dấu kích thước đang chọn -->
							<c:forEach var="page" items="${pageSizes}">
								<c:if test="${page == pageSize }">
									<option value="${page}" selected="selected">${page}</option>
								</c:if>
								<c:if test="${page != pageSize }">
									<option value="${page}">${page}</option>
								</c:if>

							</c:forEach>
						</select> <label for="pageSizeSelect"> rows per page </label>
					</div>
					<div class="fw-bold">
						Total: <span class="text-success"> ${totalRows} </span> rows
					</div>
				</div>
				<!-- Dòng 48-52: Hiển thị nút Previous và Next -->
				<ul class="col-7 pagination d-flex justify-content-end">
					<c:if test="${pageNumber > 1}">
						<li class="page-item"><a class="page-link"
							href="list?pageNumber=${pageNumber-1}&pageSize=${pageSize}&search=${search}">Previous</a></li>
					</c:if>
					<c:forEach begin="1" end="${totalPages}" var="i">
						<c:choose>
							<c:when test="${pageNumber eq i}">
								<li class="page-item"><a
									class="page-link active text-white"> ${i} </a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list?pageNumber=${i}&pageSize=${pageSize}&search=${search}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${pageNumber lt totalPages}">
						<li class="page-item"><a class="page-link"
							href="list?pageNumber=${pageNumber+1}&pageSize=${pageSize}&search=${search}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>