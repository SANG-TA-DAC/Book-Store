<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book To Order</title>
</head>
<body>
	<div align="center">
		<h2>
			The book ${book.title } has been added to the order ID ${order.orderId }
		</h2>
		<input type="button" value="Close" onclick="javascript: self.close();" />
	</div>
<script type="text/javascript">
	window.onunload = function(){
		window.opener.location.reload();
	}
</script>
</body>
</html>