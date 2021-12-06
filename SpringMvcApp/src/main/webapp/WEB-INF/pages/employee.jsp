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

	
	<h1>Add New Employee</h1>
	
		<br>	<br>
	<font color="green"><c:out value="${message}"></c:out></font>	
		<br>	<br>
		<a href="/SpringMvcApp">HOME</a><br><br> <a href="/SpringMvcApp/employee/list">List of Employees</a>	<br>
		<br>
	 <form:form method = "POST" action = "/SpringMvcApp/employee/save/" modelAttribute="empBean">
         <table>
            <tr>
               <td><form:label path = "empId">Employee Id : </form:label></td>
               <td><form:input path = "empId" readonly="true"/></td>
            </tr>
            
           <tr>
               <td><form:label path = "empName">Employee Name :</form:label></td>
               <td><form:input path = "empName" /></td>
            </tr>
            
            <tr>
               <td><form:label path = "empAge">Employee Age : </form:label></td>
               <td><form:input path = "empAge" /></td>
            </tr>
            
             <tr>
               <td><form:label path = "empSalary">Employee Salary</form:label></td>
               <td><form:input path = "empSalary" /></td>
            </tr>
            
            <tr>
               <td><form:label path = "empGender">Employee Gender</form:label></td>
               <td>
              		 <form:radiobutton path = "empGender" value="Male"/>Male
               		 <form:radiobutton path = "empGender" value="Female"/>Female
               </td>
            </tr>
            
               <tr>
	               <td><form:label path = "empSkills">Employee Skills</form:label></td>
	               
	               <td>	               
	               <c:forEach items="${skilllist}" var="sk"> 
							 		<form:checkbox path="empSkills" value="${sk.skillId}"/> ${sk.skillName}
							</c:forEach>
					</td>
            </tr>
            
             <tr>
               <td><form:label path = "empCity">Employee City</form:label></td>
				<td> <form:select path="empCity">
							<form:option value="Pune">Pune</form:option>
							<form:option value="Mumbai">Mumbai</form:option>
							<form:option value="Delhi">Delhi</form:option>
							<form:option value="Bangalore">Bangalore</form:option>
				</form:select>	
				</td>			               
            </tr>
            
             <tr>
               <td><form:label path = "empHobbies">Employee Hobbies</form:label></td>
				<td>
					<form:select path="empHobbies" multiple="true">							
							<c:forEach items="${hblist}" var="hb"> 
							 		<form:option path="empHobbies" value="${hb.hobbyName}"/> 
							</c:forEach>
				</form:select>	
				</td>			               
            </tr>
             <tr>
               
               <td><input type="submit"></td>
               <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
			
      </table>
      </form:form>   
      
      <hr>
           	<table border="1">
		<thead>
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Employee Gender</th>
			<th>Employee Skills</th>
			<th>Employee City</th>
			<th>Employee Hobbies</th>
			<th> Action</th>
		</tr>
		</thead>
		
		<c:forEach items="${emplist}" var="cr"> 
		  <tr>
		    <td>${cr.empId}</td>
		    <td>${cr.empName}</td>
		    <td>${cr.empAge}</td>
		    <td>${cr.empSalary}</td>
		    <td>${cr.empGender}</td>
		    <td>${cr.empSkills}</td>
		    <td>${cr.empCity}</td>
		    <td>${cr.empHobbies}</td>
		    <td>
		<a href="/SpringMvcApp/employee/update/<c:out value="${cr.empId}"></c:out>">UPDATE</a>
		<a href="/SpringMvcApp/employee/delete/<c:out value="${cr.empId}"></c:out>">DELETE</a>
		  </td>
		  </tr>
		</c:forEach>
		</table>  
		
</body>
</html>