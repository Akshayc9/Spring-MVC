<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

	
	<h1>Skills Information</h1>
	
	<font color="green"><c:out value="${message}"></c:out></font>	
		<a href="/SpringMvcApp">HOME</a><br>	<br>
		
	<h1>List of Skills</h1>
      <a href="/SpringMvcApp/skill/list"> List of Skills</a>
      <table border="1">
	      <thead>
	      <tr>
			      <th> Skill ID </th>
			      <th> Skill Name </th>
			      <th> Action </th>
	      </tr>
	      </thead>
     	 <c:forEach items="${sklist }" var="sk">
     	 <tr>
     	 <td> ${sk.skillId} </td>
     	  <td> ${sk.skillName} </td>
     	  
     	   <td>
		   <a href="/SpringMvcApp/skill/edit/<c:out value="${sk.skillId}"></c:out>">EDIT</a>
		    <a href="/SpringMvcApp/skill/delete/<c:out value="${sk.skillId}"></c:out>">DELETE</a>
		    
		    </td>
     	  </tr>
     	 </c:forEach>
      </table>
      
       <form:form method = "POST" action = "/SpringMvcApp/skill/edit/" modelAttribute="skillBean">
         <table>
            <tr>
               <td><form:label path = "skillId">Skill Id to Update: </form:label></td>
               <td><form:input path = "skillId"/></td>
            </tr>
                   <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
      </table>
      </form:form>
</body>
</html>