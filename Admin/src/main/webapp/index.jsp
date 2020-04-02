<%-- 
    Document   : index
    Created on : Mar. 29, 2020, 8:52:39 p.m.
    Author     : tomorrow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <style type="text/css">
            body{
                color: #555; 
                background-color: #CCE8EB;
            }
            a{
                color: darkcyan;   
            }
            table
            {
                border-collapse: collapse;
                margin: 0 auto;
                text-align: center;
            }
            table td, table th
            {
                border: 1px solid #cad9ea;
                color: #555;
                height: 30px;
            }
            table thead th
            {
                background-color: #CCE8EB;
                width: 100px;
            }
            table tr:nth-child(odd) 
            {
                background: #fff;
            }
            table tr:nth-child(even)
            {
                background: #F5FAFA;
            }
        </style>

    </head>
    <body>
    <center>
        <h1 >Video Management</h1>
        <h2>
            <a href="/Admin/new">Add New Video</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Admin">List All Videos</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Videos</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Year</th>
                <th>Category</th>
                <th>Production Company</th>
                <th>Director</th>
                <th>Thumbnail</th>
                <th>Action</th>
                <th>Upload Image</th>
            </tr>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td><c:out value="${movie.id}" /></td>
                    <td><c:out value="${movie.title}" /></td>
                    <td><c:out value="${movie.year}" /></td>
                    <td><c:out value="${movie.category}" /></td>
                    <td><c:out value="${movie.producer}" /></td>
                    <td><c:out value="${movie.director}" /></td>
                    <td><img src='<c:out value="${movie.thumbnail}"/>' alt="Thumbnail" height="171" width="126"></td>
                    <td>
                        <a href="/Admin/edit?id=<c:out value='${movie.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Admin/delete?id=<c:out value='${movie.id}' />">Delete</a>                     
                    </td>
                    <td>
                        <c:if test="${movie.thumbnailFile != null}">
                            <span>An image stores in database</span><br />
                            <span>You can change it here</span>
                        </c:if>
                        <c:if test="${movie.thumbnailFile == null}">
                            <span>No image stores in database</span><br />
                            <span>You can upload a new one</span>
                        </c:if>
                        <form method="post" action="/Admin/upload" enctype="multipart/form-data" >
                            <input type="file" name="file" /><br />
                            <input type="hidden" name="id" value="<c:out value='${movie.id}' />"  /><br />
                            <input type="submit" value="Upload" /><br />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 

</body>
</html>
