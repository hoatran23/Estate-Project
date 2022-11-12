<%@ page language="java" trimDirectiveWhitespaces="true" language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="customerListURL" value="/admin/customer-list"/>
<c:url var="customerEditURL" value="/admin/customer-edit"/>
<c:url var="customerAPI" value="/api/customer"/>
<title>Cập Nhật Thông Tin Khách Hàng</title>
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
            <h6 class="m-0 font-weight-bold text-primary">Quản lý khách hàng</h6>

        </div>
        <div class="card-body">
            <form:form modelAttribute="modelEdit" action="${customerEditURL}" method="GET" id="formSubmit">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="fullName" class="control-label bolder">Tên khách hàng</label>
                            <form:input path="fullName" cssClass="form-control" id="fullName"/>
                        </div>
                    </div>
                </div>
                 <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="phone" class="control-label bolder">Số điện thoại</label>
                            <form:input path="phone" cssClass="form-control" id="phone"/>
                        </div>
                    </div>
                </div>
                 <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <label for="email" class="control-label bolder">Email</label>
                            <form:input path="email" cssClass="form-control" id="email"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 d-flex justify-content-end">
                        <div>
                            <security:authorize access="hasRole('MANAGER')">
                            <c:if test="${not empty modelEdit.id}">
                                <input type="button" class="btn btn-success" id="btnUpdateCustomer" value="Cập nhật thông tin khách hàng">
                                <%--<button id="btnUpdateBuilding" class="btn btn-success" type="button">
                                    Add Building
                                </button>--%>
                            </c:if>
                            <c:if test="${empty modelEdit.id}">
                                <input type="button" class="btn btn-success" id="btnAddCustomer" value="Thêm khách hàng">
                                <%--<button id="btnAddBuilding" class="btn btn-success" type="button">
                                    Add Building
                                </button>--%>
                            </c:if>
                            </security:authorize>
                            <a href="${customerEditURL}" class="btn btn-warning" type="button">
                                Thêm mới
                            </a>
                            <a href="${customerListURL}" class="btn btn-danger" type="button">
                                Hủy bỏ
                            </a>
                        </div>
                    </div>
                </div>
                <form:hidden path="id" id="buildingId"/>
            </form:form>
        </div>
    </div>

<%--    ///--%>
    <c:if test="${not empty modelEdit.id}">
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-between">
            <h6 class="m-0 font-weight-bold text-primary">Quản lý giao dịch khách hàng</h6>
        </div>
        <div class="card-body">
                <c:forEach var="item" items="${transactionTypeMap}">
                    <form:form modelAttribute="modelTransaction" action="${customerEditURL}" method="GET" id="formTransactionSubmit_${item.key}">
                        <div class="modal-content">
                            <div class="modal-header justify-content-center">
                                <h6 class="modal-title text-center">${item.value}</h6>
                            </div>
                            <div class="modal-body text-center">
                                <table class="table table-striped table-bordered" id="staffList">
                                    <thead>
                                    <tr class="center text-center">
                                        <th>Ngày Tạo</th>
                                        <th>Ghi Chú</th>
                                    </tr>
                                    </thead>
                                    <tbody class="center text-center">
                                    <c:forEach var="itemTrans" items="${transactions}">
                                        <c:if test="${item.key == itemTrans.code}">
                                        <tr>
                                            <td>${itemTrans.dateFormat}</td>
                                            <td>${itemTrans.note}</td>
                                        </tr>
                                        </c:if>
                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <div class="form-group">
                                                <form:input path="note" cssClass="form-control" id="note_${item.key}"/>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <input type="hidden" name="customerId" value="${modelEdit.id}">
                                <input type="hidden" name="staffId" value="${modelEdit.staffId}">
                                <input type="hidden" name="code" id="code_${item.key}" value="${item.key}">
                                <input type="button" class="btn btn-success" id="${item.key}" onClick="addTransaction(${item.key})" value="Thêm giao dịch">
                            </div>
                        </div>
                    </form:form>
                </c:forEach>
        </div>
    </div>
    </c:if>
</div>
<!-- /.container-fluid -->

<content tag="local_script">
    <script src="<c:url value ='/template/admin/js/jquery.twbsPagination.min.js'/>"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#btnAddCustomer').click(function (e) {
                e.preventDefault();
                var formData = $('#formSubmit').serializeArray();
                formatData(formData);
            });

            $("#btnUpdateCustomer").click(function (e) {
                e.preventDefault();
                var formData = $('#formSubmit').serializeArray();
                formatData(formData);
            });
        });

        function addTransaction(data) {
            var formData = $('#formTransactionSubmit_' + data.id).serializeArray();
            var data = {};

            $.each(formData, function (index, v) {
                data["" + v.name + ""] = v.value;
            });

            $.ajax({
                type: "POST",
                url: "${customerAPI}/transaction",
                data: JSON.stringify(data),
                dataType: "text",
                contentType: "application/json",
                success: function (response) {
                    // console.log("susscess");
                    var output = JSON.parse(response);
                    window.location.href = "${customerEditURL}-" + output.detail + "?message=" + output.message;
                },
                error: function (error) {
                    console.log("error", error);
                    window.location.href = "${customerEditURL}?message=error_system";
                }
            })
        }

        function createUpdateCustomer(data) {
            $.ajax({
                type: "POST",
                url: "${customerAPI}",
                data: JSON.stringify(data),
                dataType: "text",
                contentType: "application/json",
                success: function (response) {
                    // console.log("susscess");
                    var output = JSON.parse(response);
                    if (output.detail != "") {
                        window.location.href = "${customerEditURL}-" + output.detail + "?message=" + output.message;
                    } else {
                        window.location.href = "${customerEditURL}?message=" + output.message;
                    }
                },
                error: function (error) {
                    console.log("error", error);
                    window.location.href = "${customerEditURL}?message=error_system";
                }
            })
        }

        function isEmail(email) {
            var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            return regex.test(email);
        }

        function formatData(formData) {
            var data = {};

            $.each(formData, function (index, v) {
                data["" + v.name + ""] = v.value;
            });

            // console.log(data);
            if (data.email != "") {
                isEmail(data.email) ? createUpdateCustomer(data) :
                    (data.id == "" ? window.location.href = "${customerEditURL}?message=error_input"
                    : window.location.href = "${customerEditURL}-" + data.id +"?message=error_input");
            } else if (data.fullName != "" || data.phone != "") {
                createUpdateCustomer(data);
            } else {
                data.id == "" ? window.location.href = "${customerEditURL}?message=error_input"
                    : window.location.href = "${customerEditURL}-" + data.id +"?message=error_input";
            }
        }

        function openModalAssingmentBuilding() {
            $("#assignmentBuildingModal").modal();
        }

        function assignmentBuilding() {
            openModalAssingmentBuilding();
        }

        function warningValidate() {
            swal({
                title: "Content Isn't Ready",
                text: "Please fill out all fields in the form before submitting!",
                icon: "warning",
                dangerMode: true,
            }).then((willDelete) => {
                if (willDelete) {
                    swal({
                        title: "Good job!",
                        text: "You clicked the button!",
                        icon: "success",
                        button: "Aww yiss!",
                    });
                }
            });
        }
    </script>
</content>
