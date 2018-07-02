<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/29
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载资源</title>

    <style>
        body{margin: 0px;padding: 0px;align-items: center;text-align: center}
    </style>

</head>
<body>
      <form action="/spider/grab" method="post">
          <div style="margin-top: 20px">
              <input type="text" name="savePath" placeholder="输入保存路径" style="width: 30%;height: 40px;">
          </div>
         <div style="margin-top: 20px">
             <textarea name="html" id="" cols="90" rows="50" ></textarea>
         </div>
          <div style="margin-top: 10px;color: red" >
              ${requestScope.msg}
          </div>
          <button type="submit" style="height: 50px;width: 80px;margin-top: 20px">提交</button>
      </form>
</body>
</html>
