/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-09-08 06:35:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class factory_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
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

      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("    * {\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container {\n");
      out.write("        background-color: #F0F0E8;\n");
      out.write("        width: 100%;\n");
      out.write("        height: 100%;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .top {\n");
      out.write("        margin: 0px 50px;\n");
      out.write("        color: #676767;\n");
      out.write("        font-size: 24px;\n");
      out.write("        font-weight: bold;\n");
      out.write("        height: 50px;\n");
      out.write("        display: flex;\n");
      out.write("        align-items: center; \n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .title img {\n");
      out.write("        vertical-align: middle;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .title span {\n");
      out.write("        vertical-align: middle;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .section {\n");
      out.write("        height: 500px;\n");
      out.write("        margin: 0px 50px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .table {\n");
      out.write("        width: 100%;\n");
      out.write("        border-collapse: collapse;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    input[type=\"checkbox\"] {\n");
      out.write("        transform: scale(1.5);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .thead {\n");
      out.write("        background-color: rgb(176, 176, 176);\n");
      out.write("        height: 40px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .tbody {\n");
      out.write("        background-color: white;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("   \n");
      out.write("    .thead th:nth-child(1) {\n");
      out.write("        width: 5%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(2) {\n");
      out.write("        width: 15%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(3) {\n");
      out.write("        width: 15%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(4) {\n");
      out.write("        width: 15%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(5) {\n");
      out.write("        width: 15%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(6) {\n");
      out.write("        width: 10%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(7) {\n");
      out.write("        width: 10%;\n");
      out.write("    }\n");
      out.write("    .thead th:nth-child(8) {\n");
      out.write("        width: 10%;\n");
      out.write("    }\n");
      out.write("    .tbody td {\n");
      out.write("        height: 92px;\n");
      out.write("        text-align: center;\n");
      out.write("        border-bottom: 1px solid lightgray;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .thead th {\n");
      out.write("        border-left: 1px solid white;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    td span {\n");
      out.write("        padding: 5px;\n");
      out.write("        border: 1px solid #676767;\n");
      out.write("        background-color: #cfcfcf;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .tbody img {\n");
      out.write("        width: 80px;\n");
      out.write("        height: 80px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .select {\n");
      out.write("        width: 100px;\n");
      out.write("        height: 30px;\n");
      out.write("        font-size: 20px;\n");
      out.write("        margin-left: 180px;\n");
      out.write("    }\n");
      out.write("    .inputText {\n");
      out.write("        height: 30px;\n");
      out.write("        font-size: 20px;\n");
      out.write("        margin-left: 10px;\n");
      out.write("    }\n");
      out.write("    .regBtn{\n");
      out.write("        background-color: #676767;\n");
      out.write("        padding:3px 5px;\n");
      out.write("        color:white;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        margin-left: 30px;\n");
      out.write("        font-size: 17px;\n");
      out.write("        cursor: pointer;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"top\">\n");
      out.write("            <img src=\"image/directory.png\" style=\"width: 30px;\">\n");
      out.write("            <span>공정 관리</span>\n");
      out.write("            <select class=\"select\">\n");
      out.write("                <option value=\"-----\">-----</option>\n");
      out.write("                <option value=\"code\">공정코드</option>\n");
      out.write("                <option value=\"name\">공정명</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"text\" class=\"inputText\">\n");
      out.write("            <img src=\"image/search.png\" style=\"margin-left: 10px;\" onclick=\"searchTable()\">\n");
      out.write("            <span class=\"regBtn\" onclick=\"commitReg()\">등록</span>\n");
      out.write("            <span class=\"regBtn\" onclick=\"deleteSelectedRows()\">삭제</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"section\">\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <thead class=\"thead\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th></th>\n");
      out.write("                        <th>공정코드</th>\n");
      out.write("                        <th>공정명</th>\n");
      out.write("                        <th>공정분류</th>\n");
      out.write("                        <th>제품코드</th>\n");
      out.write("                        <th>사용여부</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody class=\"tbody\">\n");
      out.write("                    ");

                        String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
                        String username = "scott2_9";  
                        String password = "tiger"; 
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;
                        Statement stmt2 = null;
                        ResultSet rs2 = null;

                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url, username, password);
                            String query = "SELECT process_code, process_name, process_category, product_code, is_used FROM PROCESS";
                         
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(query);
                            

                            while (rs.next()) {
                                String processCode = rs.getString("process_code");
                                String processName = rs.getString("process_name");
                                String processType = rs.getString("process_category");
                                String productCode = rs.getString("product_code");
                                String useYn = rs.getString("is_used");
                    
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><input type=\"checkbox\" class=\"delete-checkbox\"></td>\n");
      out.write("                                    <td><a href=\"ProcessServlet3?processCode5=");
      out.print( processCode );
      out.write('"');
      out.write('>');
      out.print( processCode );
      out.write("</a></td> ");
      out.write("\n");
      out.write("                                    <td>");
      out.print( processName );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( processType );
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print( productCode );
      out.write("</td> \n");
      out.write("                                    <td>");
      out.print( useYn );
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                    ");

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (rs != null) rs.close();
                                if (stmt != null) stmt.close();
                                if (conn != null) conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("function sendProcessCode(processCode) {\n");
      out.write("    console.log(`Navigating to: ProcessServlet3?processCode=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${processCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`);\n");
      out.write("    window.location.href = `ProcessServlet3?processCode=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${processCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`;\n");
      out.write("}\n");
      out.write("    function searchTable() { \n");
      out.write("        let selectValue = document.querySelector('.select').value; \n");
      out.write("        let searchText = document.querySelector('.inputText').value; \n");
      out.write("        let table = document.querySelector('.table');\n");
      out.write("\n");
      out.write("        console.log(selectValue)\n");
      out.write("        console.log(searchText);\n");
      out.write("        let rows = table.querySelectorAll('.tbody tr'); \n");
      out.write("        if (selectValue === 'code') {\n");
      out.write("            rows.forEach(row => {\n");
      out.write("                \n");
      out.write("                let code = row.querySelector('td:nth-child(2)'); \n");
      out.write("                if (code) {\n");
      out.write("                    let codeText = code.innerText;\n");
      out.write("                    if (codeText.includes(searchText)) {\n");
      out.write("                        row.style.display = '';\n");
      out.write("                    } else {\n");
      out.write("                        row.style.display = 'none';\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        } else if (selectValue === 'name') {\n");
      out.write("            rows.forEach(row => {\n");
      out.write("                let name = row.querySelector('td:nth-child(3)');    \n");
      out.write("                if (name) {\n");
      out.write("                    let nameText = name.innerText;\n");
      out.write("                    if (nameText.includes(searchText)) {\n");
      out.write("                        row.style.display = '';\n");
      out.write("                    } else {\n");
      out.write("                        row.style.display = 'none';\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        }else if (selectValue === '-----') {\n");
      out.write("            rows.forEach(row => {\n");
      out.write("                row.style.display = '';\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    function deleteSelectedRows() {\n");
      out.write("        let checkedBoxes = document.querySelectorAll('.delete-checkbox:checked');\n");
      out.write("\n");
      out.write("        if (checkedBoxes.length > 0) {\n");
      out.write("            let form = document.createElement('form');\n");
      out.write("            form.method = 'POST';\n");
      out.write("            form.action = 'DeleteProcessServlet';\n");
      out.write("\n");
      out.write("            checkedBoxes.forEach(box => {\n");
      out.write("                let row = box.closest('tr');\n");
      out.write("                let processCode = row.querySelector('td:nth-child(2)').innerText;\n");
      out.write("                let input = document.createElement('input');\n");
      out.write("                input.type = 'hidden';\n");
      out.write("                input.name = 'processCode'; \n");
      out.write("                input.value = processCode;\n");
      out.write("                form.appendChild(input);\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            document.body.appendChild(form);\n");
      out.write("            form.submit();\n");
      out.write("        } else {\n");
      out.write("            alert('삭제할 항목을 선택하세요.');\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    function commitReg(){\n");
      out.write("        window.location.href=\"ProductServlet\";\n");
      out.write("    }\n");
      out.write("</script>");
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