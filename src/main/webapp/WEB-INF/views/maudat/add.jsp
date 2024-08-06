<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Tạo
			mới mẫu đất</div>
		<div class="p-4">
			<form:form action="${pageContext.request.contextPath}/maudat/create"
				method="post" modelAttribute="maudat" id="inputForm">
				<div class="form-group row">
					<form:label path="id" for="inputID" class="col-sm-3 col-form-label">Mã mẫu đất</form:label>
					<div class="col">
						<form:input path="id" type="text" class="form-control"
							id="inputID" placeholder="Mã mẫu đất (MDxxx)" autocomplete="off" />
						<form:errors path="id" />
						<div class="error text-danger" id="errorID"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="number" for="inputNumber"
						class="col-sm-3 col-form-label">Số mẫu đất</form:label>
					<div class="col">
						<form:input path="number" type="number" class="form-control"
							id="inputNumber" placeholder="Số mẫu đất" autocomplete="off" />
						<form:errors path="number" />
						<div class="error text-danger" id="errorNumber"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="khuDoThi.id" for="inputMaDoThi"
						class="col-sm-3 col-form-label">Mã khu đô thị</form:label>
					<div class="col">
						<form:input path="khuDoThi.id" type="text" class="form-control"
							id="inputMaDoThi" placeholder="Mã khu đô thị (KDTxx)"
							autocomplete="off" />
						<form:errors path="khuDoThi.id" />
						<div class="error text-danger" id="errorMaDoThi"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="khachHang.id" for="inputMaChuSoHuu"
						class="col-sm-3 col-form-label">Mã chủ sở hữu</form:label>
					<div class="col">
						<form:input path="khachHang.id" type="text" class="form-control"
							id="inputMaChuSoHuu" placeholder="Mã chủ sở hữu (KHxxx)"
							autocomplete="off" />
						<form:errors path="khachHang.id" />
						<div class="error text-danger" id="errorMaChuSoHuu"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="width" for="inputWidth"
						class="col-sm-3 col-form-label">Chiều rộng</form:label>
					<div class="col">
						<form:input path="width" type="number" class="form-control"
							id="inputWidth" placeholder="Chiều rộng" autocomplete="off" />
						<form:errors path="width" />
						<div class="error text-danger" id="errorWidth"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="length" for="inputLength"
						class="col-sm-3 col-form-label">Chiều dài</form:label>
					<div class="col">
						<form:input path="length" type="number" class="form-control"
							id="inputLength" placeholder="Chiều dài" autocomplete="off" />
						<form:errors path="length" />
						<div class="error text-danger" id="errorLength"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="price" for="inputPrice"
						class="col-sm-3 col-form-label">Giá gốc</form:label>
					<div class="col">
						<form:input path="price" type="number" class="form-control"
							id="inputPrice" placeholder="Giá gốc" autocomplete="off" />
						<form:errors path="price" />
						<div class="error text-danger" id="errorPrice"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<div class="col"></div>
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<button type="reset" class="btn btn-success">Reset</button>
						<button type="submit" class="btn btn-success mx-3">Add</button>
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>




