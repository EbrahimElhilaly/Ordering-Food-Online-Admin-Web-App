<%-- 
    Document   : UpdateCity
    Created on : Mar 3, 2020, 7:54:59 PM
    Author     : helsli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View City</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/app_style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="../../js/app_script.js"></script>
        <script type="text/javascript">
        </script>
    </head>
    <body>

        <form method="POST">
            <h3 style="margin-left: 30px">City Details</h3>
            <table width="30%" style="margin-left: 30px">
                <tr>
                    <td>
                        <label>City name in Arabic </label>
                    </td>
                    <td>
                        <input type="text" readonly="true"  value="city Name Ar" name="nameAr"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>City name in English </label>
                    </td>
                    <td>
                        <input type="text" readonly="true"  value="city Name En" name="nameEn"/>
                    </td>
                </tr>
            </table>
        </form>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>city Name En Areas</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="City.jsp" class="btn btn-success" > <span>Back</span></a>
                            <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Area</span></a>
                        </div>
                    </div>

                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>Area Id</th>
                            <th>Area Name In Arabic</th>
                            <th>Area Name In English</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${areaSet}" var="iArea"> 
                        <tr>
                            <td>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                    <label for="checkbox1"></label>
                                </span>
                            </td>
                            <td><c:out value="${iArea.id}" /></td>
                        <td><c:out value="${iArea.nameAr}" /></td>
                        <td><c:out value="${iArea.nameEn}" /></td>
                        <td>
                            <a href="UpdateArea.jsp?id=${iArea.id}">
                                <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                            </a>
                            <a href="DeleteCurrentArea?id=${iArea.id}" class="delete" data-toggle="modal"
                               onclick="if (confirm('Confirm Remove ${iArea.nameAr} ?')) {
                                           return true;
                                       } else {
                                           return false;
                                       }">
                                <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                            </a>                                        
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>${areaList.size()}</b> entries</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addNewArea?master_city_id=100" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add New Area</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Area Name In Arabic</label>
                                <input type="text" name="areaNameAr" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Area Name In English</label>
                                <input type="text" name="areaNameEn" class="form-control" required>
                            </div>					
                            <div class="form-group">
                                <label>City</label>
                                <select  name="city_id">

                                </select>                           
                            </div>					
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
