<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div align="center">
    	<form action="" method="post">
			<table border="1">
				<tr>
					<th>Titre :</th>
					<th>Realisateur :</th>
				</tr>
				<c:forEach var="film" items="${listFilm}">
				<tr>
					<th>${film.titre}</th>
					<th>${film.realisateur}</th>
				</tr>

				</c:forEach>
			</table>
		</form>
    </div>   
</body>
</html>