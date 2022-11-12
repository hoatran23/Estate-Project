<%@ page language="java" trimDirectiveWhitespaces="true" language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<c:url var="buildingEditURL" value="/admin/building-edit"/>
<c:url var="buildingAPI" value="/api/building"/>
<title>Cập Nhật Thông Tin Tòa Nhà</title>
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
            <h6 class="m-0 font-weight-bold text-primary">Quản lý tòa nhà</h6>

        </div>
        <div class="card-body">
            <form:form modelAttribute="modelEdit" action="${buildingEditURL}" method="GET" id="formSubmit">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="name" class="control-label bolder">Tên sản phẩm</label>
                            <!-- <input type="text" id="nane" name="name" class="form-control" value=""/>  -->
                            <form:input path="name" cssClass="form-control" id="nane"/>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
<%--                            <label for="floorArea" class="control-label bolder">Nhân viên quản lý</label>--%>
<%--                            <form:select path="staffId" cssClass="chosen-select form-control">--%>
<%--                                <form:option value="-1" label="-- Chọn nhân viên phụ trách --"/>--%>
<%--                                <form:options items="${staffmaps}"/>--%>
<%--                            </form:select>--%>
                            <label for="rentArea" class="control-label bolder">Diện tích thuê</label>
                            <input type="text" id="rentArea" name="rentArea" class="form-control" value="${rentArea}"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="districtCode" class="control-label bolder">Quận</label>
                            <form:select path="districtCode" cssClass="chosen-select form-control">
                                <form:option value="-1" label="-- Chọn quận --"/>
                                <form:options items="${districtmaps}"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="ward" class="control-label bolder">Phường</label>
                            <!-- <input type="text" class="form-control" id="ward" name="ward"> -->
                            <form:input path="ward" cssClass="form-control" id="ward"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="street" class="control-label bolder">Đường</label>
                            <!-- <input type="text" class="form-control" id="street" name="street"> -->
                            <form:input path="street" cssClass="form-control" id="street"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for=structure class="control-label bolder">Kết cấu</label>
                            <!-- <input type="text" class="form-control" id="structure" name="structure"> -->
                            <form:input path="structure" cssClass="form-control" id="structure"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="numberOfBasement" class="control-label bolder">Số tầng hầm</label>
                            <!-- <input type="text" class="form-control" id="numberOfBasement" name="numberOfBasement"> -->
                            <input type="number" class="form-control" id="numberOfBasement" name="numberOfBasement"
                                   value="${modelEdit.numberOfBasement}">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="floorArea" class="control-label bolder">Diện tích sàn</label>
                            <input type="number" class="form-control" id="floorArea" name="floorArea"
                                   value="${modelEdit.floorArea}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="direction" class="control-label bolder">Hướng</label>
                            <!-- <input type="text" class="form-control" id="direction" name="direction"> -->
                            <form:input path="direction" cssClass="form-control" id="direction"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="level" class="control-label bolder">Hạng</label>
                            <!-- <input type="text" class="form-control" id="level" name="level"> -->
                            <form:input path="level" cssClass="form-control" id="level"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="rentPrice" class="control-label bolder">Giá thuê</label>
                            <!-- <input type="text" class="form-control" id="rentPrice" name="rentPrice"> -->
                            <input type="number" class="form-control" id="rentPrice" name="rentPrice"
                                   value="${modelEdit.rentPrice}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="rentPriceDescription" class="control-label bolder">Mô tả giá thuê</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="rentPriceDescription" cssClass="form-control" id="rentPriceDescription"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="serviceFee" class="control-label bolder">Phí dịch vụ</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="serviceFee" cssClass="form-control" id="serviceFee"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="carFee" class="control-label bolder">Phí ô tô</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="carFee" cssClass="form-control" id="carFee"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="motorBikeFee" class="control-label bolder">Phí mô tô</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="motorBikeFee" cssClass="form-control" id="motorBikeFee"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="overtimeFee" class="control-label bolder">Phí ngoài giờ</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="overtimeFee" cssClass="form-control" id="overtimeFee"/>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="waterFee" class="control-label bolder">Tiền nước</label>
                            <!-- <input type="text" class="form-control" id="rentAreaDesc" name="rentAreaDesc"> -->
                            <form:input path="waterFee" cssClass="form-control" id="waterFee"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="electricityFee" class="control-label bolder">Tiền điện</label>
                            <!-- <input type="text" class="form-control" id="electricityFee" name="electricityFee"> -->
                            <form:input path="electricityFee" cssClass="form-control" id="electricityFee"/>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="deposit" class="control-label bolder">Đặt cọc</label>
                            <!-- <input type="text" class="form-control" id="deposit" name="deposit"> -->
                            <form:input path="deposit" cssClass="form-control" id="deposit"/>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="payment" class="control-label bolder">Thanh toán</label>
                            <!-- <input type="text" class="form-control" id="payment" name="payment"> -->
                            <form:input path="payment" cssClass="form-control" id="payment"/>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="rentTime" class="control-label bolder">Thời hạn thuê</label>
                            <!-- <input type="text" class="form-control" id="rentPeriod" name="rentPeriod"> -->
                            <form:input path="rentTime" cssClass="form-control" id="rentTime"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="decorationTime" class="control-label bolder">Thời gian trang trí</label>
                            <!-- <input type="text" class="form-control" id="decorationTime" name="decorationTime"> -->
                            <form:input path="decorationTime" cssClass="form-control" id="decorationTime"/>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="brokerageFee" class="control-label bolder">Phí môi giới</label>
                            <input type="number" class="form-control" id="brokerageFee" name="brokerageFee"
                                   value="${modelEdit.brokerageFee}">
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="nameManager" class="control-label bolder">Tên quản lý</label>
                            <!-- <input type="text" class="form-control" id="managerName" name="managerName"> -->
                            <form:input path="nameManager" cssClass="form-control" id="nameManager"/>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="form-group">
                            <label for="phoneManager" class="control-label bolder">Số điện thoại quản lý</label>
                            <!-- <input type="text" class="form-control" id="phoneManager" name="phoneManager"> -->
                            <form:input path="phoneManager" cssClass="form-control" id="phoneManager"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">
                            <c:forEach var="item" items="${renttypemaps}">
                                <div class="form-check form-check-inline" id="renttype">
                                    <input class="form-check-input" name="types" type="checkbox" value="${item.getCode()}" ${item.getCheck()}>
                                    <label class="form-check-label">${item.getValue()}</label>
                                </div>
                            </c:forEach>
                            <!-- <div class="form-check form-check-inline">
                                 <input class="form-check-input"  name="form-field-checkbox" type="checkbox" id="inlineCheckbox1" value="option1">
                                 <label class="form-check-label" for="inlineCheckbox1">Tầng trệt</label>
                            </div>
                            <div class="form-check form-check-inline">
                                 <input class="form-check-input"  name="form-field-checkbox" type="checkbox" id="inlineCheckbox2" value="option2">
                                  <label class="form-check-label" for="inlineCheckbox2">Nguyên căn</label>
                               </div>
                            <div class="form-check form-check-inline">
                                 <input class="form-check-input" name="form-field-checkbox" type="checkbox" id="inlineCheckbox3" value="option3">
                                  <label class="form-check-label" for="inlineCheckbox3">Nội thất</label>
                            </div> -->
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12 d-flex justify-content-end">
                        <div>
                            <security:authorize access="hasRole('MANAGER')">
                            <c:if test="${not empty modelEdit.id}">
                                <input type="button" class="btn btn-success" id="btnUpdateBuilding" value="Update Building">
                                <%--<button id="btnUpdateBuilding" class="btn btn-success" type="button">
                                    Add Building
                                </button>--%>
                            </c:if>
                            <c:if test="${empty modelEdit.id}">
                                <input type="button" class="btn btn-success" id="btnAddBuilding" value="Thêm tòa nhà">
                                <%--<button id="btnAddBuilding" class="btn btn-success" type="button">
                                    Add Building
                                </button>--%>
                            </c:if>
                            </security:authorize>
                            <a href="${buildingEditURL}" class="btn btn-warning" type="button">
                                Thêm mới
                            </a>
                            <a href="${buildingListURL}" class="btn btn-danger" type="button">
                                Hủy bỏ
                            </a>
                        </div>
                    </div>
                </div>
                <form:hidden path="id" id="buildingId"/>
            </form:form>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<content tag="local_script">
    <script src="<c:url value ='/template/admin/js/jquery.twbsPagination.min.js'/>"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#btnAddBuilding').click(function (e) {
                e.preventDefault();
                var formData = $('#formSubmit').serializeArray();
                formatData(formData);
            });

            $("#btnUpdateBuilding").click(function (e) {
                e.preventDefault();
                var formData = $('#formSubmit').serializeArray();
                formatData(formData);
            });
        });

        function createUpdateBuilding(data) {
            $.ajax({
                type: "POST",
                url: "${buildingAPI}",
                data: JSON.stringify(data),
                dataType: "text",
                contentType: "application/json",
                success: function (response) {
                    // console.log("susscess");
                    var output = JSON.parse(response);
                    if (output.detail != "") {
                        <%--window.location.href = "${buildingEditURL}?message=" + output.message + "&id=" + output.detail;--%>
                        window.location.href = "${buildingEditURL}-" + output.detail + "?message=" + output.message;
                    } else {
                        window.location.href = "${buildingEditURL}?message=" + output.message;
                    }
                },
                error: function (error) {
                    console.log("error", error);
                    window.location.href = "${buildingEditURL}?message=error_system";
                }
            })
        }

        function formatData(formData) {
            var data = {};

            $.each(formData, function (index, v) {
                data["" + v.name + ""] = v.value;
            });

            var types = $("#renttype input[type=checkbox]:checked").map(function () {
                return $(this).val();
            }).get();
            data["types"] = types.join(", ");
            console.log(types);
            console.log(data);
            createUpdateBuilding(data);
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
