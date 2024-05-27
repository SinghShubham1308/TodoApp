<%@include file="comman/header.jspf"%>
<div class="container-fluid">
	<%@include file="comman/navigation.jspf"%>
</div>
<div class="container mt-5">
	<h1>Your Todos</h1>
	<table class="table">
		<thead>
			<tr>
				<!--  <th>id</th> -->
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<%--  <td>${todo.id}</td> --%>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-Todo?id=${todo.id}" class="btn btn-danger">delete</a></td>
					<td><a href="update-Todo?id=${todo.id}"
						class="btn btn-secondary">update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@include file="comman/footer.jspf"%>
