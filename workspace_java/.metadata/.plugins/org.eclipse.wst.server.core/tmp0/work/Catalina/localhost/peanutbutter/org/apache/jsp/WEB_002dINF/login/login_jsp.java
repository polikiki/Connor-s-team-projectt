/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-09-08 09:22:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.io.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/peanutbutter/WEB-INF/lib/standard.jar!/META-INF/fmt.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1725776852058L));
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/peanutbutter/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/peanutbutter/WEB-INF/lib/standard.jar!/META-INF/fn.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(10);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.naming");
    _jspx_imports_packages.add("javax.sql");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    * {\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .top {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        background-color: #444444;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .body {\r\n");
      out.write("        height: calc(100% - 50px);\r\n");
      out.write("        background-color: #C0B296;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .login_container {\r\n");
      out.write("        background-color: white;\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        height: 300px;\r\n");
      out.write("        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);\r\n");
      out.write("        border-radius: 8px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .logo_div {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 20%;\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    img {\r\n");
      out.write("        max-width: 100%;\r\n");
      out.write("        /* 최대 너비를 컨테이너의 너비로 제한 */\r\n");
      out.write("        max-height: 100%;\r\n");
      out.write("        padding-left: 50px;\r\n");
      out.write("        margin-left: 40px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .id_div, .pw_div{\r\n");
      out.write("        display: flex;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input {\r\n");
      out.write("        height: 40px;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        border: 2px solid #ccc;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        transition: border-color 0.5s;\r\n");
      out.write("        padding:5px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input:focus {\r\n");
      out.write("        border-color: black;\r\n");
      out.write("        outline: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .loginBtn {\r\n");
      out.write("        width: 150px;\r\n");
      out.write("        height: 40px;\r\n");
      out.write("        background-color: white;\r\n");
      out.write("        border: 2px solid #f4753b;\r\n");
      out.write("        color: #f4753b;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("        margin-top: 30px;\r\n");
      out.write("        border-radius: 20px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .pb_join {\r\n");
      out.write("    	text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .loginBtn:hover {\r\n");
      out.write("        background-color: #f4753b;\r\n");
      out.write("        color: white;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   /* 모달 기본 스타일 */\r\n");
      out.write(".modal {\r\n");
      out.write("  display: none;\r\n");
      out.write("  position: fixed;\r\n");
      out.write("  z-index: 1;\r\n");
      out.write("  left: 0;\r\n");
      out.write("  top: 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  height: 100%;\r\n");
      out.write("  background-color: rgba(0, 0, 0, 0.4);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".modal-content {\r\n");
      out.write("  background-color: #fefefe;\r\n");
      out.write("  margin: 10% auto;\r\n");
      out.write("  padding: 20px;\r\n");
      out.write("  border: 1px solid #888;\r\n");
      out.write("  width: 350px;\r\n");
      out.write("  border-radius: 8px;\r\n");
      out.write("  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  margin-bottom: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form-group {\r\n");
      out.write("  display: flex;\r\n");
      out.write("  flex-direction: column;\r\n");
      out.write("  margin-bottom: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("  margin-bottom: 5px;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"], input[type=\"password\"] {\r\n");
      out.write("  padding: 8px;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  border: 1px solid #ccc;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".close {\r\n");
      out.write("  color: #aaa;\r\n");
      out.write("  font-size: 20px;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  float: right;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  margin-right: -10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".close:hover,\r\n");
      out.write(".close:focus {\r\n");
      out.write("  color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".submit-btn {\r\n");
      out.write("  background-color: #4CAF50;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 10px 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  transition: background-color 0.3s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".submit-btn:hover {\r\n");
      out.write("  background-color: #45a049;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"top\"></div>\r\n");
      out.write("        <div class=\"body\">\r\n");
      out.write("            <div class=\"login_container\">\r\n");
      out.write("                <div class=\"logo_div\"><img src=\"image/darkLogo.png\"></div>\r\n");
      out.write("                <form method=\"post\" action=\"login\">\r\n");
      out.write("                	<div class=\"id_div\"><input id=\"id\" type=\"text\" name=\"id\" placeholder=\"아이디 또는 사번\"></div>\r\n");
      out.write("                	<div class=\"pw_div\"><input id=\"pw\" type=\"password\" name=\"pw\" placeholder=\"비밀번호\"></div>\r\n");
      out.write("                	<div class=\"pb_join\">\r\n");
      out.write("                		<input type=\"submit\" class=\"loginBtn\" value=\"로그인\">\r\n");
      out.write("                		<button type=\"button\" class=\"loginBtn\" id=\"showJoin\">회원가입</button>\r\n");
      out.write("                	</div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<!-- 회원가입 모달 -->\r\n");
      out.write("<div id=\"signupModal\" class=\"modal\">\r\n");
      out.write("  <div class=\"modal-content\">\r\n");
      out.write("    <span class=\"close\">&times;</span>\r\n");
      out.write("    <h2>회원가입</h2>\r\n");
      out.write("    <form id=\"signupForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/login/insert\" method=\"post\" onsubmit=\"return validateForm()\">\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <label for=\"ename\">이름:</label>\r\n");
      out.write("        <input type=\"text\" id=\"ename\" name=\"ename\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <label for=\"id\">아이디 또는 사원번호:</label>\r\n");
      out.write("        <input type=\"text\" id=\"id\" name=\"id\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <label for=\"password\">비밀번호:</label>\r\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <div class=\"form-group\">\r\n");
      out.write("        <label for=\"confirmPassword\">비밀번호 확인:</label>\r\n");
      out.write("        <input type=\"password\" id=\"confirmPassword\" name=\"confirmPassword\" required>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      <button type=\"submit\" class=\"submit-btn\">가입하기</button>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    let loginBtn = document.querySelector('.loginBtn');\r\n");
      out.write("\r\n");
      out.write("    loginBtn.addEventListener('click', function(e){\r\n");
      out.write("        let id = document.querySelector('#id').value;\r\n");
      out.write("        let pw = document.querySelector('#pw').value;\r\n");
      out.write("        if (id === 'admin' && pw === 'admin') {\r\n");
      out.write("            alert('관리자로 로그인');\r\n");
      out.write("        } else {\r\n");
      out.write("            alert('작업자로 로그인');\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // 모달 열기 및 닫기 스크립트\r\n");
      out.write("    var modal = document.getElementById(\"signupModal\");\r\n");
      out.write("    var btn = document.getElementById(\"showJoin\");\r\n");
      out.write("    var span = document.getElementsByClassName(\"close\")[0];\r\n");
      out.write("\r\n");
      out.write("    btn.onclick = function() {\r\n");
      out.write("      modal.style.display = \"block\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    span.onclick = function() {\r\n");
      out.write("      modal.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    window.onclick = function(event) {\r\n");
      out.write("      if (event.target == modal) {\r\n");
      out.write("        modal.style.display = \"none\";\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 비밀번호 확인 유효성 검사\r\n");
      out.write("    function validateForm() {\r\n");
      out.write("        var password = document.getElementById(\"password\").value;\r\n");
      out.write("        var confirmPassword = document.getElementById(\"confirmPassword\").value;\r\n");
      out.write("\r\n");
      out.write("        if (password !== confirmPassword) {\r\n");
      out.write("            alert(\"비밀번호가 일치하지 않습니다. 다시 입력해주세요.\");\r\n");
      out.write("            return false;  // 제출을 중지\r\n");
      out.write("        }\r\n");
      out.write("        return true;  // 제출 진행\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write(" // 가입 완료 팝업 처리\r\n");
      out.write("    window.onload = function() {\r\n");
      out.write("        // 서버에서 success 플래그가 true일 경우에 팝업을 띄우는 로직\r\n");
      out.write("        let success = '");
      out.print( request.getAttribute("success") );
      out.write("';\r\n");
      out.write("        if (success === 'true') {\r\n");
      out.write("            alert('가입이 완료되었습니다.');\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}