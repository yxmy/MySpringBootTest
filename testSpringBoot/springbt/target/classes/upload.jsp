<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    </head>
    <body class="upload">
        <div>
            <form action="upload" enctype="multipart/form-data" method="post">
                <input type="file" name="file"><br/>
                <input type="submit" value="上传">
            </form>
        </div>
    </body>
</html>