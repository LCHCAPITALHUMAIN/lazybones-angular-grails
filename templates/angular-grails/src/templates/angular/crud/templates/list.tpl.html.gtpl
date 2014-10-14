<div crud-breadcrumbs="list"></div>
<div class="row">
<div class="col-md-2">
<h3>Filter List</h3>
<form class="form">
	<% domainProperties.take(4).each { property -> %>
	<div class="form-group">
		<label for="filter.${property.name}">${property.label}</label>
		<%= renderInput(property, 'ctrl.filter') %>
    </div>
	<% } %>
</form>
</div>

<div class="col-md-9">
<h2>${resourceName} List</h2>
<div flash-message ></div>

<p><button crud-button="create" ></button></p>


<table class="table table-striped table-bordered">

    <thead sort-header ng-model="ctrl.sort" on-sort="ctrl.reload()">
        <th sortable-column title="Id" property="id"></th>
		<% domainProperties.take(4).each { property -> %>
		<th sortable-column title="${property.label}" property="${property.name}"></th>
		<% } %>
        <th>&nbsp;</th>
    </thead>
    <tbody>
        <tr ng-repeat="item in ctrl.${moduleName}List">
            <td><a href="#/show/{{item.id}}">{{item.id}}</a></td>
			<% domainProperties.take(4).each { property -> %>
			<td>{{ ${renderDisplay(property, 'item')} }}</td>
			<% } %>
            <td>
                <button crud-button="edit" item="item" ></button>
                <button crud-button="delete" item="item" after-action="ctrl.reload()"></button>
            </td>
        </tr>
    </tbody>
</table>

<div pagination total-items="ctrl.items.getTotalCount()" items-per-page="ctrl.pageSize" ng-model="ctrl.page" ng-change="ctrl.load()"></div>
</div>
</div>