<%-- 
    Document   : form
    Created on : Mar. 29, 2020, 11:29:21 p.m.
    Author     : tomorrow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                height: 60px;

            }
            table th
            {
                width: 200px;
            }        
            table td
            {
                width: 300px;

            } 
            table thead th
            {
                background-color: #CCE8EB;

            }
            table tr:nth-child(odd) 
            {
                background: #fff;
            }
            table tr:nth-child(even)
            {
                background: #F5FAFA;
            }
            input{
                padding:8px;
                width: 180px;
            }
            #save{
                color: darkcyan;
                font-weight:bolder;
                padding:8px;
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
        <c:if test="${movie != null}">
            <form action="update" method="post">
            </c:if>
            <c:if test="${movie == null}">
                <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${movie != null}">
                                Edit Video
                            </c:if>
                            <c:if test="${movie == null}">
                                Add New Video
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${msg != null}">
                        <div style="color:red">
                            <c:out value='${msg}' />
                        </div>
                    </c:if>  
                    <c:if test="${movie != null}">
                        <input type="hidden" name="id" value="<c:out value='${movie.id}' />" />
                    </c:if>            
                    <tr>
                        <th>Title</th>
                        <td>
                            <input type="text" name="title" 
                                   value="<c:out value="${movie.title}" />" />
                        </td>
                    </tr>
                    <c:if test="${movie != null}">
                        <tr>
                            <th>Year</th>
                            <td>
                                <input type="text" name="year" 
                                       value="<c:out value="${movie.year}" />" />
                            </td>
                        </tr>
                    </c:if> 
                    <c:if test="${movie == null}">
                        <tr>
                            <th>Year</th>
                            <td>
                                <input type="text" name="year"  value="2020"  />
                            </td>
                        </tr>
                    </c:if> 
                    <tr>
                        <th>Category</th>
                        <td>

                            <select name="category" style="width: 200px;"  >
                                <option value="Movie"
                                        <c:if test="${movie.category == 'Movie'}">
                                            selected="selected"
                                        </c:if> 
                                        >Movie</option>
                                <option value="TV Show"
                                        <c:if test="${movie.category == 'TV Show'}">
                                            selected="selected"
                                        </c:if> 
                                        >TV Show</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <th>Production Company</th>
                        <td>
                            <input type="text" name="producer" 
                                   value="<c:out value="${movie.producer}" />"  />
                        </td>
                    </tr>
                    <tr>
                        <th>Director</th>
                        <td>
                            <input type="text" name="director" 
                                   value="<c:out value="${movie.director}" />"  />
                        </td>
                    </tr>
                    <tr>
                        <th>Thumbnail URL</th>
                        <td>
                            <input type="text" name="thumbnail" 
                                   value="<c:out value="${movie.thumbnail}" />"  />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input id='save' type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>

    </div>

</body>
</html>
