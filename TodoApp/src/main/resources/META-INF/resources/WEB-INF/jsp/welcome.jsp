<%@include file="comman/header.jspf"%>
<div class="container-fluid">
		<%@include file="comman/navigation.jspf"%>
	</div>
    <div class="container mt-5">
        <h1>Welcome ${username}</h1>
        <p><a href="list-todos" class="btn btn-primary">Manage your todos</a></p>
    </div>
<%@include file="comman/footer.jspf"%>
