<%@ page language="java" trimDirectiveWhitespaces="true" language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="buildingEditURL" value="/admin/building-edit"/>
<c:url var="buildingUrlAPI" value="/api/building"/>
<title>Quản Lý Tòa Nhà</title>
<!-- Begin Page Content -->
<div class="container-fluid">
    <c:if test="${not empty message}">
		<div class="alert alert-${alert} alert-dismissible">
		 	<button type="button" class="close" data-dismiss="alert">&times;</button>
			${message}
		</div>
	</c:if>
	
	<div class="card shadow mb-4">
		<div class="card-header py-3 d-flex justify-content-between">
			<h6 class="m-0 font-weight-bold text-primary">Tìm kiếm tòa nhà</h6>
           
		</div>
		<div class="card-body">
			<form:form modelAttribute="modelSearch" action="${buildingListURL}" id="listForm" method="GET">
		         <div class="row">
		             <div class="col-sm-6">
		                 <div class="form-group">
		                     <label for="name" class="control-label bolder">Tên tòa nhà</label>
		                     <form:input path="name" cssClass="form-control"/>
		                 </div>
		             </div>
		             <div class="col-sm-6">
		                 <div class="form-group">
		                     <label for="floorArea" class="control-label bolder">Diện tích sàn</label>
		                     <input type="number" class="form-control" id="floorArea" name="floorArea" value="${modelSearch.floorArea}">
		                 </div>
		             </div>
		         </div>
		         <div class="row">
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="districtCode" class="control-label bolder">Quận hiện có</label>
		                     <!-- <select class="chosen-select form-control selectpicker" id="district">
		                         <option value=""> -- Chọn quận -- </option>
		                         <option value="Q1">Quận 1</option>
		                         <option value="Q2">Quận 2</option>
		                         <option value="Q4">Quận 4</option>
		                     </select> -->
		                     <form:select path="districtCode" cssClass="chosen-select form-control">
		                         <form:option value="" label="-- Choose District --"/>
		                         <form:options items="${districtmaps}"/>
		                     </form:select>
		                 </div>
		             </div>
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="ward" class="control-label bolder">Phường</label>
		                     <input type="text" class="form-control" id="ward" name="ward">
		                 </div>
		             </div>
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="street" class="control-label bolder">Đường</label>
		                     <input type="text" class="form-control" id="street" name="street">
		                 </div>
		             </div>
		         </div>
		         <div class="row">
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="numberOfBasement" class="control-label bolder">Số tầng hầm</label>
		                     <input type="text" class="form-control" id="numberOfBasement" name="numberOfBasement">
		                 </div>
		             </div>
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="direction" class="control-label bolder">Hướng</label>
		                     <input type="text" class="form-control" id="direction" name="direction">
		                 </div>
		             </div>
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="level" class="control-label bolder">Hạng</label>
		                     <input type="text" class="form-control" id="level" name="level">
		                 </div>
		             </div>
		         </div>
		         <div class="row">
		             <div class="col-sm-3">
		                 <div class="form-group">
		                     <label for="rentAreaFrom" class="control-label bolder">Diện tích từ</label>
		                     <input type="text" class="form-control" id="rentAreaFrom" name="rentAreaFrom">
		                 </div>
		             </div>
		             <div class="col-sm-3">
		                 <div class="form-group">
		                     <label for="rentAreaTo" class="control-label bolder">Diện tích đến</label>
		                     <input type="text" class="form-control" id="rentAreaTo" name="rentAreaTo">
		                 </div>
		             </div>
		             <div class="col-sm-3">
		                 <div class="form-group">
		                     <label for="rentPriceFrom" class="control-label bolder">Giá thuê từ</label>
		                     <input type="text" class="form-control" id="rentPriceFrom" name="rentPriceFrom">
		                 </div>
		             </div>
		             <div class="col-sm-3">
		                 <div class="form-group">
		                     <label for="rentPriceTo" class="control-label bolder">Giá thuê đến</label>
		                     <input type="text" class="form-control" id="rentPriceTo" name="rentPriceTo">
		                 </div>
		             </div>
		         </div>
		         <div class="row">
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="managerName" class="control-label bolder">Tên quản lý</label>
		                     <input type="text" class="form-control" id="managerName" name="managerName">
		                 </div>
		             </div>
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="managerPhone" class="control-label bolder">Điện thoại quản lý</label>
		                     <input type="text" class="form-control" id="managerPhone" name="managerPhone">
		                 </div>
		             </div>
					 <security:authorize access="hasRole('MANAGER')">
		             <div class="col-sm-4">
		                 <div class="form-group">
		                     <label for="staffId" class="control-label bolder">Chọn nhân viên phụ trách</label>
		                     <form:select path="staffId" cssClass="chosen-select form-control">
		                         <form:option value="" label="-- Chọn nhân viên phụ trách --"/>
		                         <form:options items="${staffmaps}"/>
		                     </form:select>
		                 </div>
		             </div>
					 </security:authorize>
		         </div>
		         <div class="row">
		             <div class="col-sm-12">
		                 <div class="form-group d-flex justify-content-center">
		                 	 <c:forEach var="item" items="${renttypemaps}">
			                 	 <div class="form-check form-check-inline" id="renttype">
								 	 <input class="form-check-input"  name="types" type="checkbox" id="${item.getValue()}" value="${item.getCode()}">
								 	 <label class="form-check-label">${item.getValue()}</label>
								 </div>
		                 	 </c:forEach>
		                 </div>
		             </div>
		         </div>
		         <div class="row">
		             <div class="col-sm-12 d-flex justify-content-center">
		                 <div class="btn-group">
		                     <button type="button" class="btn btn-success" id="btnSearch">Tìm kiếm</button>
		                 </div>
		             </div>
		         </div>
		     </form:form>
		</div>
	</div>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
    <%-- <form action="<c:url value='/admin-news/list'/>" id="formSubmit" method="get"> --%>
    <form:form modelAttribute="modelSearch" action="${buildingListURL}" id="formSubmit" method="GET">
        <security:authorize access="hasRole('MANAGER')">
        <div class="card-header py-3 d-flex justify-content-end">
            <div>
		        <a href="<c:url value='${buildingEditURL}'/>" class="btn btn-success">
		             <span class="text">Thêm tòa nhà</span>
		        </a>
		        <button type="button" class="btn btn-danger" id="delete" disabled>
		             <span class="text">Xóa tòa nhà</span>
		        </button>
	        </div>
        </div>
        </security:authorize>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr class="center text-center">
                            <th><input type="checkbox" id="checkedAll"></th>
							<th>Tên tòa nhà</th>
                            <th>Địa chỉ</th>
                            <th>Tên quản lý</th>
                            <th>Số điện thoại</th>
                            <th>Diện tích sàn</th>
                            <th>Giá thuê</th>
                            <th>Phí dịch vụ</th>
							<th>Diện tích thuê</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="item" items="${buildingsSearch}">
                        <tr class="center text-center">
                            <td><input type="checkbox" name="checkSingle" class="checkSingle" value="${item.id}"></td>
							<td>${item.name}</td>
							<td>${item.address}</td>
							<td>${item.nameManager}</td>
                            <td>${item.phoneManager}</td>
                            <td>${item.floorArea}</td>
                            <td>${item.rentPrice}</td>
                            <td>${item.serviceFee}</td>
							<td>${item.rentArea}</td>
							<td style="width: 150px;">
								<c:url var="updateBuildingURL" value="/admin/building-edit-${item.id}">
									<%--									<c:param name="id" value="${item.id}"/>--%>
								</c:url>
								<security:authorize access="hasRole('MANAGER')">
								<button type="button" class="btn btn-success btn-circle" id="assignBuilding" onClick="assignmentBuilding(${item.id})" title="Giao tòa nhà">
                                   <i class="fas fa-info-circle" aria-hidden="true"></i>
                                </button>
								<a class="btn btn-warning btn-circle" data-toggle="tooltip"
								   title="Cập nhật tòa nhà" href="${updateBuildingURL}"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i>
								</a>
								</security:authorize>
								<security:authorize access="hasRole('STAFF')">
								<a class="btn btn-warning btn-circle" data-toggle="tooltip"
								   title="Chi tiết tòa nhà" href="${updateBuildingURL}"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i>
								</a>
								</security:authorize>
							</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="col-sm-12 d-flex flex-row-reverse">
                	<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
	                	<ul class="pagination" id="pagination"></ul>	
	                </div>
                </div>
				<input type="hidden" value="" id="page" name="page"/>
				<input type="hidden" value="" id="limit" name="limit"/>
            </div>
        </div>
    </form:form>
    </div>

</div>
<!-- /.container-fluid -->

<div class="modal fade" id="assignmentBuildingModal" role="dialog">
    <div class="modal-dialog">
		<form>
			<div class="modal-content">
				<div class="modal-header">
					<h6 class="modal-title">Danh sách nhân viên</h6>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table class="table table-striped table-bordered" id="staffList">
						<thead>
							<tr class="center text-center">
								<th>Chọn</th>
								<th>Nhân viên</th>
							</tr>
						</thead>
						<tbody class="center text-center">
	<%--                        <tr>--%>
	<%--                            <td>--%>
	<%--                                <input type="checkbox" value="1" id="checkbox_2">--%>
	<%--                            </td>--%>
	<%--                            <td>Nguyen Van A</td>--%>
	<%--                        </tr>--%>
	<%--                        <tr>--%>
	<%--                            <td class="">--%>
	<%--                                <input type="checkbox" value="1" id="checkbox_4">--%>
	<%--                            </td>--%>
	<%--                            <td>Nguyen Van B</td>--%>
	<%--                        </tr>--%>
	<%--                        <tr>--%>
	<%--                            <td class="">--%>
	<%--                                <input type="checkbox" value="1" id="checkbox_3">--%>
	<%--                            </td>--%>
	<%--                            <td>Nguyen Van B</td>--%>
	<%--                        </tr>--%>
						</tbody>
					</table>
					<input type="hidden" name="buildingId" id="buildingId" value="">
				</div>
				<div class="modal-footer">
					<button class="btn btn-success" type="button" id="btnAssignBuilding">Giao tòa nhà</button>
					<button class="btn btn-danger" type="button" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</form>
    </div>
</div>
<content tag="local_script">
<script src="<c:url value ='/template/admin/js/jquery.twbsPagination.min.js'/>"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$(document).on("click",".checkSingle",function(event){
	if ($(this).is(":checked")) {
		var isAllChecked = 0;
		$("#dataTable .checkSingle").each(function() {
			console.log(this.checked);
			if (!this.checked) {
				isAllChecked = 1;
			}
		});
		if (isAllChecked == 0) {
			$("#checkedAll").prop("checked", true);
		}
	}
	else {
		$("#checkedAll").prop("checked", false);
	}
});

$(document).on("click",".checkSingle",function(event){
	if ($('#dataTable .checkSingle:checked').length > 0) {
		$('#delete').removeAttr('disabled');
	} else {
		$('#delete').attr('disabled', 'disabled');
	}
});

$(document).ready(function () {
	// Checkbox Check All
	$("#checkedAll").change(function() {
		if (this.checked) {
			$(".checkSingle").each(function() {
				this.checked=true;
			});
			$('#delete').removeAttr('disabled');
		} else {
			$(".checkSingle").each(function() {
				this.checked=false;
			});
			$('#delete').attr('disabled', 'disabled');
		}
	});

	// Search
	$('#btnSearch').click(function(e) {
		e.preventDefault();
		// $('#listForm').submit();
		var formData = $('#listForm').serializeArray();
		console.log(formatData(formData));
		searchBuilding(formatData(formData));
	});

	// Assignment building for staff
    $("#btnAssignBuilding").click(function(e) {
        e.preventDefault();
        var data = {};
        var staffs = [];

        data['buildingId'] = $("#buildingId").val();
        var staffs = $("#staffList").find("tbody input[type=checkbox]:checked").map(function() {
            return $(this).val();
        }).get();
        data["staffIds"] = staffs;
        assignStaff(data);
    });

    $("#delete").click(function(){
    	warningDelete(); 
    });
});

function formatData(formData) {
	var data = {};

	$.each(formData, function (index, v) {
		data["" + v.name + ""] = v.value;
	});

	var types = $("#renttype input[type=checkbox]:checked").map(function () {
		return $(this).val();
	}).get();
	data["types"] = types.join(", ");
	//console.log(types);
	//console.log(data);
	return data;
}

function searchBuilding(data) {
	$.ajax({
		type: 'POST',
		url: '${buildingUrlAPI}/search',
		data: JSON.stringify(data),
		dataType: "json",
		contentType: 'application/json',
		success: function (response) {
			if (response.message == 'ok') {
				var row = '';
				$.each(response.data, function (index, building) {
					row += '<tr class="center text-center">';
					row += '<td><input type="checkbox" name="checkSingle" class="checkSingle" value="' + building.id + '"></td>';
					row += '<td>' + building.name + '</td>';
					row += '<td>' + building.address + '</td>';
					row += '<td>' + building.nameManager + '</td>';
					row += '<td>' + building.phoneManager + '</td>';
					row += '<td>' + building.floorArea + '</td>';
					row += '<td>' + building.rentPrice + '</td>';
					row += '<td>' + building.serviceFee + '</td>';
					row += '<td>' + building.rentArea + '</td>';
					row += '<td style="width: 150px;">';
					row += '<security:authorize access="hasRole('MANAGER')">';
					row += '<button type="button" class="btn btn-success btn-circle" id="assignBuilding" onClick="assignmentBuilding(' + building.id + ')" title="Giao tòa nhà"> <i class="fas fa-info-circle" aria-hidden="true"></i> </button>';
					row += '<a class="btn btn-warning btn-circle" data-toggle="tooltip" title="Cập nhật tòa nhà" href="${buildingEditURL}-'+ building.id +'"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i> </a>';
					row += '</security:authorize>';
					row += '<security:authorize access="hasRole('STAFF')">';
					row += '<a class="btn btn-warning btn-circle" data-toggle="tooltip" title="Chi tiết tòa nhà" href="${buildingEditURL}-'+ building.id +'"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i> </a>';
					row += '</security:authorize>';
				});

				$('#dataTable tbody').html(row);
			}
		},
		error: function (response) {
			console.log("error");
			console.log(response);
		}
	});
}

function updateBuilding(data) {
	$.ajax({
		type: 'PUT',
        url: '${buildingUrlAPI}',
        data: JSON.stringify(data),
        dataType: "json",
        contentType: 'application/json',
        success: function (response) {
        	console.log("success");
        },
        error: function (response) {
        	console.log("error");
        	console.log(response);
        }
    });
}

function assignStaff(data) {
	$.ajax({
		type: 'POST',
        url: '${buildingUrlAPI}/staffs',
        data: JSON.stringify(data),
        dataType: "json",
        contentType: 'application/json',
        success: function (response) {
        	console.log("success");
			if (response.message == "insert_success") {
				alertSuccess();
			}
        },
        error: function (response) {
        	console.log("error");
        }
    });
}

//Assign Building Modal Toggle
function assignmentBuilding(buildingId) {
    openModalAssignmentBuilding();
    loadStaff(buildingId);
    $("#buildingId").val(buildingId);
    // console.log($("#buildingId").val());
}

function loadStaff(data) {
	$.ajax({
		type: 'GET',
        url: '${buildingUrlAPI}/staffs?buildingid=' + data,
        data: JSON.stringify(data),
        dataType: "json",
        contentType: 'application/json',
        success: function (response) {
			var row = '';
			$.each(response.data, function (index, staff) {
				row += '<tr>';
				row += '<td><input type="checkbox" value="' + staff.staffId +'" id="checkbox_' + staff.staffId + '"' + staff.checked + '></td>';
				row += '<td>' + staff.fullname + '</td>'
				row += '<tr>';
			});

			$('#staffList tbody').html(row);
        },
        error: function (response) {
        	console.log("error");
        	console.log(response);
        }
    });
}

function openModalAssignmentBuilding() {
    $("#assignmentBuildingModal").modal();
}


// Delete Building
function deleteBuilding(data) {
	$.ajax({
        url: '${buildingUrlAPI}',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response) {
        	window.location.href = "${buildingListURL}?message=delete_success";
            console.log(response);
        },
        error: function (response) {
        	 // window.location.href = "${newsURL}?page=1&limit=<fmt:message key='label.limit.page' bundle='${lang}'/>&message=error_system";
            console.log(response);
        }
    });
}

function buildingDelete(data) {
	$('input:checkbox.checkSingle').each(function () {
		if (this.checked) {
			console.log($(this).val());
			id = $(this).val();
			data.push(id);
		}
	});
	return data;
}

function warningDelete() {
	swal({
	  title: "Are you sure?",
	  text: "Once deleted, you will not be able to recover this article!",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
		  	var data = [];
		    deleteBuilding(buildingDelete(data));
	  } else {
	   		swal("Your building is safe!");
	  }
	});
}

function alertSuccess() {
	swal({
		title: "Good job!",
		text: "Giao tòa nhà thành công!",
		icon: "success",
		button: "Đóng!",
	});
}
</script>
</content>
