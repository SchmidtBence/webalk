<html>
<head>
<title>Calculator</title>
</head>
<body>
<%
szamologepservlet.ResultDto result= (request.getAttribute("result") != null) ?
        (szamologepszervlet.ResultDto) request.getAttribute("result"):
        new szamologepszervlet,ResultDto();
Double result=(Double) request.getAttribute("result");
String resultText = (result == null) ? "" : "result" + result.toString();
%>
<form method="post" action="/<%=request.getContextPath()%>/szamologep.do">
    <input type="text" name="a" value="<%= result.getA() %>"/><br>
    <input type="text" name="b" value="<%= result.getB() %>"/><br>
    <select name="operator">
        <option value="+" <%="+".equals(result.getOperator())? "selected" : ""%> > +
        <option value="-" <%="-".equals(result.getOperator())? "selected" : ""%> > -
        <option value="*" <%="*".equals(result.getOperator())? "selected" : ""%> > *
        <option value="/" <%="/".equals(result.getOperator())? "selected" : ""%> > /
    </select><br>

<%= resultText %><br>
<input type="submit" /><br>
</from>






</body>
</html>