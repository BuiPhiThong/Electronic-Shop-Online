

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
                        <h4 class="modal-title">Update Category</h4>
                    </div>
                    <c:set value="${requestScope.cupdate}" var="c"/>
                    <form action="updatecategory"  method="post">

                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Id</label>
                                <input type="number" class="form-control" required name="id" value="${c.id}" readonly>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required name="name" value="${c.name}">
                            </div>
                            <div class="form-group">
                                <label>Describe</label>
                                <input type="text" class="form-control" required name="describe" value="${c.describe}">
                            </div>					
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
