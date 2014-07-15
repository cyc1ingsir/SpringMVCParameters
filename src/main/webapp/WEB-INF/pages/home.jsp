<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transmit Parameters to Spring-MVC</title>
    <link rel="stylesheet" type="text/css" href="resources/site.css">
</head>
<body>
<div id="formDiv">
    <form:form modelAttribute="a">
        <fieldset>
            <legend>Object A</legend>
            <div>
                <form:label path="aOne">A-One</form:label>
                <form:input path="aOne" id="aOne"/>
                <form:errors path="aOne"/>
            </div>
            <div>
                <form:label path="aTwo">A-Two</form:label>
                <form:input path="aTwo" id="aTwo"/>
                <form:errors path="aTwo"/>
            </div>
        </fieldset>
    </form:form>
    <form:form modelAttribute="b">
        <legend>Object B</legend>
        <fieldset>
            <div>
                <form:label path="bOne">B-One</form:label>
                <form:input path="bOne" id="bOne"/>
                <form:errors path="bOne"/>
            </div>
            <div>
                <form:label path="bTwo">B-Two</form:label>
                <form:input path="bTwo" id="bTwo"/>
                <form:errors path="bTwo"/>
            </div>
        </fieldset>
    </form:form>
</div>
<div>
        <div><input id="add11" type="submit" class="go working" value="1.1"/>Submitting with $().post including a and b</div>
        <div><input id="add12" type="submit" class="go" value="1.2"/>Submitting with $().post including b only</div>
        <div><input id="add21" type="submit" class="go" value="2.1"/>Submitting with $().ajax including a and b (JSON stringified)</div>
        <div><input id="add22" type="submit" class="go" value="2.2"/>Submitting with $().ajax including a only (JSON stringified)</div>
        <div><input id="add23" type="submit" class="go" value="2.3"/>Submitting with $().ajax including a and b (JSON stringified) and Object o as controller argument</div>
    </div>
    <div>
        <div><input id="params" type="submit" class="go" value="Params in URL"/>Put parameters to URL to see if that's possible for a POST</div>
    </div>

    <div id="messages">&nbsp;</div>
    <div id="result"/>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="resources/form.js"></script>


</body>
</html>
