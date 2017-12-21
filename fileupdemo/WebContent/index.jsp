<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>servlet 上传文件</title>
</head>
<body>
	 <div>
            <form action="fileUpServlet" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td><label for="file1">文件1：</label></td>
                        <td><input type="file" id="file1" name="file"></td>
                    </tr>
                    <tr>
                        <td><label for="file2">文件2：</label></td>
                        <td><input type="file" id="file2" name="file"></td>
                    </tr>
                    <tr>
                        <td><label for="file3">文件3：</label></td>
                        <td><input type="file" id="file3" name="file"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="上传" name="upload"></td>
                    </tr>
                </table>
            </form>
        </div>
</body>
</html>