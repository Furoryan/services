<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en" ng-app="angularStrutsApp">
<head>
    <meta charset="utf-8">
    <title>My AngularJS Struts2 App</title>

    <s:url var="ctxUrl" forceAddSchemeHostAndPort="true" includeContext="true" value="/" namespace="/" ></s:url>
    <base href="<s:property value="ctxUrl"/>">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>


<div>
    <a href="/home">Home</a> - <a href="/projects">Projects</a>
</div>

<div ng-controller="AppController">
    <div ng-view></div>
</div>


<script src="<s:url value="js/lib/jquery-1.11.3.min.js" />"></script>
<script src="<s:url value="js/lib/bootstrap/bootstrap.min.js" />"></script>
<script src="<s:url value="js/lib/angular/angular.min.js" />"></script>
<script src="<s:url value="js/lib/angular/angular-route.min.js" />"></script>
<script src="<s:url value="js/bootstrap.js" />"></script>
<script src="<s:url value="js/directives.js" />"></script>
<script src="<s:url value="js/services.js" />"></script>
<script src="<s:url value="js/controllers.js" />"></script>
</body>
</html>
