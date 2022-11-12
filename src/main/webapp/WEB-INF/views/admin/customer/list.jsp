<%@ page language="java" trimDirectiveWhitespaces="true" language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<c:url var="customerUrlAPI" value="/api/customer"/>
<title>Quản Lý Khách Hàng</title>
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
            <h6 class="m-0 font-weight-bold text-primary">Tìm kiếm khách hàng</h6>

        </div>
        <div class="card-body">
            <form:form modelAttribute="modelSearch" action="${customerListURL}" id="listForm" method="GET">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="fullName" class="control-label bolder">Tên khách hàng</label>
                            <form:input path="fullName" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="phone" class="control-label bolder">Di động</label>
<%--                            <input type="text" class="form-control" id="phone" name="phone" value="${modelSearch.floorArea}">--%>
                            <form:input path="phone" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="email" class="control-label bolder">Email</label>
<%--                            <input type="email" class="form-control" id="email" name="email">--%>
                            <form:input path="email" cssClass="form-control"/>
                        </div>
                    </div>
                    <security:authorize access="hasRole('MANAGER')">
                        <div class="col-sm-6">
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
        <form:form modelAttribute="modelSearch" action="${customerListURL}" id="formSubmit" method="GET">
            <security:authorize access="hasRole('MANAGER')">
            <div class="card-header py-3 d-flex justify-content-end">
                <div>
                    <a href="<c:url value='${customerEditURL}'/>" class="btn btn-success">
                        <span class="text">Thêm khách hàng</span>
                    </a>
                    <button type="button" class="btn btn-danger" id="delete" disabled>
                        <span class="text">Xóa khách hàng</span>
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
                            <th>Tên khách hàng</th>
                            <th>Di động</th>
                            <th>Email</th>
                            <th>Thao tác</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${customerSearch}">
                            <tr class="center text-center">
                                <td><input type="checkbox" name="checkSingle" class="checkSingle" value="${item.id}"></td>
                                <td>${item.fullName}</td>
                                <td>${item.phone}</td>
                                <td>${item.email}</td>
                                <td style="width: 150px;">
                                    <c:url var="updateCustomerURL" value="/admin/customer-edit-${item.id}"></c:url>
                                    <security:authorize access="hasRole('MANAGER')">
                                        <button type="button" class="btn btn-success btn-circle" id="assignCustomer" onClick="assignmentCustomer(${item.id})" title="Giao khách hàng">
                                            <i class="fas fa-info-circle" aria-hidden="true"></i>
                                        </button>
                                        <a class="btn btn-warning btn-circle" data-toggle="tooltip"
                                           title="Cập nhật thông tin khách hàng" href="${updateCustomerURL}"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i>
                                        </a>
                                    </security:authorize>
                                    <security:authorize access="hasRole('STAFF')">
                                    <a class="btn btn-warning btn-circle" data-toggle="tooltip"
                                       title="Chi tiết thông tin khách hàng" href="${updateCustomerURL}"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i>
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

<div class="modal fade" id="assignmentCustomerModal" role="dialog">
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
                    <input type="hidden" name="customerId" id="customerId" value="">
                </div>
                <div class="modal-footer">
                    <button class="btn btn-success" type="button" id="btnAssignCustomer">Giao khách hàng</button>
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
            // Search
            $('#btnSearch').click(function(e) {
                e.preventDefault();
                // $('#listForm').submit();
                var formData = $('#listForm').serializeArray();
                console.log(formatData(formData));
                searchCustomer(formatData(formData));
            });

            // Assignment building for staff
            $("#btnAssignCustomer").click(function(e) {
                e.preventDefault();
                var data = {};
                var staffs = [];

                data['customerId'] = $("#customerId").val();
                var staffs = $("#staffList").find("tbody input[type=checkbox]:checked").map(function() {
                    return $(this).val();
                }).get();
                data["staffIds"] = staffs;
                assignStaff(data);
            })

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

        function searchCustomer(data) {
            $.ajax({
                type: 'POST',
                url: '${customerUrlAPI}/search',
                data: JSON.stringify(data),
                dataType: "json",
                contentType: 'application/json',
                success: function (response) {
                    if (response.message == 'ok') {
                        var row = '';
                        $.each(response.data, function (index, customer) {
                            row += '<tr class="center text-center">';
                            row += '<td><input type="checkbox" name="checkSingle" class="checkSingle" value="' + customer.id + '"></td>';
                            row += '<td>' + customer.fullName + '</td>';
                            row += '<td>' + customer.phone + '</td>';
                            row += '<td>' + customer.email + '</td>';
                            row += '<td style="width: 150px;">';
                            row += '<security:authorize access="hasRole('MANAGER')">';
                            row += '<button type="button" class="btn btn-success btn-circle" id="assignCustomer" onClick="assignmentCustomer(' + customer.id + ')" title="Giao khách hàng"><i class="fas fa-info-circle" aria-hidden="true"></i></button>';
                            row += '<a class="btn btn-warning btn-circle" data-toggle="tooltip" title="Cập nhật thông tin khách hàng" href="${customerEditURL}-'+ customer.id +'"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i> </a>';
                            row += '</security:authorize>';
                            row += '<security:authorize access="hasRole('STAFF')">';
                            row += '<a class="btn btn-warning btn-circle" data-toggle="tooltip" title="Chi tiết thông tin khách hàng" href="${customerEditURL}-'+ customer.id +'"><i class="fas fa-exclamation-triangle" aria-hidden="true"></i> </a>';
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

        function updateCustomer(data) {
            $.ajax({
                type: 'PUT',
                url: '${customerUrlAPI}',
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
                url: '${customerUrlAPI}/staffs',
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

        //Assign Customer Modal Toggle
        function assignmentCustomer(customerId) {
            openModalAssignmentCustomer();
            loadStaff(customerId);
            $("#customerId").val(customerId);
            // console.log($("#buildingId").val());
        }

        function loadStaff(data) {
            $.ajax({
                type: 'GET',
                url: '${customerUrlAPI}/staffs?customerid=' + data,
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

        function openModalAssignmentCustomer() {
            $("#assignmentCustomerModal").modal();
        }


        // Delete Building
        function deleteCustomer(data) {
            $.ajax({
                url: '${customerUrlAPI}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (response) {
                    window.location.href = "${customerListURL}?message=delete_success";
                    console.log(response);
                },
                error: function (response) {
                    // window.location.href = "${customerListURL}?page=1&limit=<fmt:message key='label.limit.page' bundle='${lang}'/>&message=error_system";
                    console.log(response);
                }
            });
        }

        function customerDelete(data) {
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
                        deleteCustomer(customerDelete(data));
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
