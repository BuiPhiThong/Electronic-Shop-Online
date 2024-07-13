<%-- 
    Document   : updateproduct
    Created on : Mar 2, 2024, 10:41:45 PM
    Author     : BUI TUAN DAT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">						
                        <h4 class="modal-title">Update Product</h4>
                    </div>
                    <c:set var="p" value="${requestScope.pupdate}" />
                    <form action="updateproduct" method="post">

                        <div class="modal-body">					
                            <div class="form-group">
                                <label>ID</label>
                                <input type="number" class="form-control" required name="id" value="${p.id}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required name="name" value="${p.name}">
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="number" class="form-control" required name="price" value="${p.price}">
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <input type="number" class="form-control" required name="quantity" value="${p.quantity}">
                            </div>
                            <div class="form-group">
                                <label>Describe</label>
                                <input type="text" class="form-control" required name="describe" value="${p.describe}">
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input type="text" class="form-control" required name="image" value="${p.image}">
                            </div>
                            <div class="form-group">
                                <label>DOM</label>
                                <input type="text" class="form-control" required name="dom" value="${p.dom}">
                            </div>
                            <div class="form-group">
                                <label>cid</label>
                                <input type="number" class="form-control" required name="cid" value="${p.cid.id}">
                            </div>
                            <div class="form-group">
                                <label>pid</label>
                                <input type="number" class="form-control" required name="pid" value="${p.pid.pid}">
                            </div>
                            <div class="form-group">
                                <label>auid</label>
                                <input type="number" class="form-control" required name="auid" value="${p.auid.auid}">
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-info" value="Update">
                            </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
