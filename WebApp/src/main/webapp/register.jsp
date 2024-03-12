<%@page import="com.yuva.entity.UserDao"%>  
<jsp:useBean id="obj" class="com.yuva.entity.User">  
</jsp:useBean>  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
int i=UserDao.register(obj);  
if(i>0)  
out.print("You are successfully registered");  
  
%> 