<%--
  Created by IntelliJ IDEA.
  User: luwz
  Date: 2023/2/23
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
      <title>JAVA WEB APP Demo</title>
      <script type="text/javascript" src="./lib/js/jquery.min.js"></script>
  </head>
  <body>
      <H1>Hello,World!</H1>

      <form action="./hello" method="post">
        姓名<input type="text" name="name" /><br>
          验证码：<img src="./getValidateCode" width="40" height="30" title="看不清点我" onclick=""/>
        个人爱好：
            <input type="checkbox" name="hobby" value="旅游" >旅游
            <input type="checkbox" name="hobby" value="音乐">音乐
            <input type="checkbox" name="hobby" value="登山">登山
        <input type="submit" value="提交"/>
      </form>

      <hr/>
      <div id="login"
           style="width:400px;padding:20px 70px 20px 70px;">
      <form id="loginForm" action="./hello" method="post">
          <input type="hidden" name="CMD" value="0" />
          <div style="text-align: center;color: red;" id="showMsg"></div>
          <table>
              <tr>
                  <td width="20%">
                      <div style="margin-bottom:10px">
                          用户名
                      </div>
                  </td>
                  <td width="80%">
                      <div style="margin-bottom:10px">
                          <input  type="text" id="name" name="name" style="height:30px;padding:12px" />
                      </div>
                  </td>
              </tr>
              <tr>
                  <td width="20%">
                      <div style="margin-bottom:10px">
                          密　码
                      </div>
                  </td>
                  <td width="80%">
                      <div style="margin-bottom:10px">
                          <input id="passWord" name="passWord"  style="height:30px;padding:12px" />
                      </div>
                  </td>
              </tr>
              <tr>
                  <td width="20%">
                      <div style="margin-bottom:10px">
                          验证码
                      </div>
                  </td>
                  <td width="80%">
                      <div style="margin-bottom:20px">
                          <input  type="text" id="logyzm"
                                 style="width:50%;height:30px;padding:12px" />

                          <span>
                         <img  id="checkIconOK"   style="margin:3px ; vertical-align:middle; width: 12px;"
                               src=""/>
                        <a href="javascript:void(0);" onclick="changeCheckCode();return false;">
                            <img  id="imgCheckCode" style=" margin:3px ; vertical-align:middle; height:26px;width: 60px"
                                  src="./getValidateCode" title="看不清,点击刷新"/>
                        </a>
                        </span>
                      </div>
                  </td>
              </tr>
              <tr>
                  <td width="20%">

                  </td>
                  <td width="80%">
                      <div style="margin-bottom:20px">
                          <input type="checkbox" checked="checked" id="logrem"/>
                          <span>记住密码</span>
                      </div>
                  </td>
              </tr>
              <tr>
              <td colspan="2">
              <div>
                  <input  type="submit" value="登录" style="padding:5px;width:100%;font-size:14px;" onclick="doLogin();return false;"/>
              </div>
              </td>
              </tr>
          </table>
      </form>
      </div>
      <script type="text/javascript">
          $(function() {
              $("#login").dialog({
                  title : '用户登录',
                  backcolor:'#00f',
                  iconCls : 'icon-lock',
                  width : '420',
                  height : '330',
                  closable : false,
                  minimizable : false,
                  maximizable : false,
                  resizable : false,
                  modal : true,
                  closed : false
                  ,
                  buttons : [ {
                      text : '登录',
                      iconCls : 'icon-ok',
                      handler:function(){
                          doLogin();
                      }},
                      {
                          text: '取消',
                          iconCls: 'icon-cancel',
                          handler: function () {
                              $("#login").dialog("close");
                          }

                      } ]
              });

              $("#logyzm").bind("blur",function(){
                  //此处写你需要执行的代码
                  checkCode();
              });

              $("#logyzm").bind("focus",function(){
                  //此处写你需要执行的代码
                  checkCodeClear();
              });

          });
          function doLogin(){
              if($("input[name='userName']").val()=="" || $("input[name='passWord']").val()==""){
                  $("#showMsg").html("用户名或密码为空，请输入");
                  $("input[name='userName']").focus();
              }else
              {
                  $("#login").dialog("close");
                  $("#loginForm").get(0).submit();
              }
          }

          function changeCheckCode() {
              var timestamp = new Date().getTime();
              var path = "./getValidateCode?date=";
              $("#imgCheckCode").attr("src", path + timestamp);
          }

          function checkCode() 	 {
              $.ajax({
                  url: '../checkCode',
                  type: "POST",
                  dataType: "json",
                  data:  {
                      logyzm:$("#logyzm").val()
                  },  //将表单序列化$("#logyzm").serialize(),
                  success: function (data) {
                      data = eval('(' + data + ')');      //将一个json字符串解析成js对象
                      //ajax方式直接将后台的json字符串转换为json对象，即这里的data已经是json对象，不需要转换
                      // $.messager.alert("提示", data.Message, 'info'); //显示后台信息
                      if (data.Success) {
                          $("#checkIconOK").attr("src", "../css/icons/ok.png");
                      }
                      else {
                          $("#checkIconOK").attr("src", "../css/icons/cancel.png");
                      }
                  },
                  error:function(){
                      alert('failed!');
                  }
              })
          }

          function checkCodeClear() 	 {
              $("#checkIconOK").attr("src", "");
              //$("#logyzm").textbox("setValue","");
          }

      </script>
  </body>
</html>
