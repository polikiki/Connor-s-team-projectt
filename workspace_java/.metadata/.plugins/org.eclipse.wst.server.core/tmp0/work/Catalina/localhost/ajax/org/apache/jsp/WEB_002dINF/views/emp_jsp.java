/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-10-04 08:24:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1727059106186L));
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/proj11_ajax/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/proj11_ajax/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/workspace/workspace_java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/proj11_ajax/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
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
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("	Logo\r\n");
      out.write("	<nav>emp > 회원 목록</nav>\r\n");
      out.write("</header>\r\n");
      out.write("<main>\r\n");
      out.write("	<a href=\"join\">회원가입</a>\r\n");
      out.write("	<section>\r\n");
      out.write("		<article>\r\n");
      out.write("			<form id=\"frm\" method=\"get\" action=\"member\">\r\n");
      out.write("			<table border=\"1\">\r\n");
      out.write("				<caption style = \"display:none;\">회원 목록 표시 : display:none으로 감춰놓자</caption>\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr>					\r\n");
      out.write("						<th>select</th>\r\n");
      out.write("						<th id=\"empno\">empno </th>\r\n");
      out.write("						<th>ename</th>\r\n");
      out.write("						<th>job</th>\r\n");
      out.write("						<th>sal</th>\r\n");
      out.write("						<th>hiredate</th>\r\n");
      out.write("						<th>delete</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody id=\"list\">\r\n");
      out.write("					\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			</form>		\r\n");
      out.write("		</article>\r\n");
      out.write("	</section>\r\n");
      out.write("</main>\r\n");
      out.write("<footer>휴먼</footer>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("	window.addEventListener(\"load\", function(){\r\n");
      out.write("		getList()\r\n");
      out.write("	})\r\n");
      out.write("\r\n");
      out.write("	// cb : callback \r\n");
      out.write("	function ajax(url, param, cb, method){\r\n");
      out.write("		// javascript에서 false의 의미는 null, undefined, 0 \r\n");
      out.write("		// true는 false가 아닌것\r\n");
      out.write("		if(!method) method = \"get\";\r\n");
      out.write("			\r\n");
      out.write("		const xhr = new XMLHttpRequest();\r\n");
      out.write("		xhr.open(method,url);\r\n");
      out.write("		xhr.setRequestHeader(\"Content-Type\",\"application/json\");\r\n");
      out.write("		xhr.send(JSON.stringify(param));\r\n");
      out.write("		\r\n");
      out.write("		if(typeof cb == \"function\"){\r\n");
      out.write("			xhr.onload = function(){\r\n");
      out.write("				cb(xhr.responseText)\r\n");
      out.write("			}	\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function getList(){\r\n");
      out.write("		ajax(\"listEmp\", null, drawList) //\"get\" 어차피 아니면 get으로 가도록 설계했으니까 생략가능 get이 아닐때는 delete등을 써서 활용가능\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function drawList(text) {\r\n");
      out.write("		try{\r\n");
      out.write("			const empList = JSON.parse(text);\r\n");
      out.write("			\r\n");
      out.write("			let html = \"\";\r\n");
      out.write("			\r\n");
      out.write("			if(empList.length == 0){\r\n");
      out.write("				html = \"<tr><td colspan='7'>자료가 없습니다</td></tr>\"\r\n");
      out.write("			} else {\r\n");
      out.write("				for(let i=0; i<empList.length; i++){\r\n");
      out.write("					console.log(empList[i])\r\n");
      out.write("					const hiredate = new Date(empList[i].hireDate)\r\n");
      out.write("					const y = hiredate.getFullYear()\r\n");
      out.write("					let m = hiredate.getMonth() + 1\r\n");
      out.write("					if(m < 10){\r\n");
      out.write("						m = \"0\" + m\r\n");
      out.write("					}\r\n");
      out.write("					const d = hiredate.getDate()\r\n");
      out.write("					\r\n");
      out.write("					html += `\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td>\r\n");
      out.write("									<input type=\"checkbox\" name=\"check\" value=\"${empList[i].empno }\">\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>${empList[i].empno}</td>\r\n");
      out.write("								<td><a href=\"emp0?cmd=detail&empno=${empList[i].empno }\">${empList[i].ename }</a></td>\r\n");
      out.write("								<td>${empList[i].job}</td>\r\n");
      out.write("								<td>${empList[i].sal}</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									${y}년 ${m}월 ${d}일\r\n");
      out.write("								</td>\r\n");
      out.write("								<td>\r\n");
      out.write("									<button type=\"button\" data-empno=\"${empList[i].empno }\" class=\"btnDel\" id=\"btn_${empList[i].empno }\">삭제</button>\r\n");
      out.write("								</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("						`;\r\n");
      out.write("					\r\n");
      out.write("				}\r\n");
      out.write("					\r\n");
      out.write("			}\r\n");
      out.write("			document.querySelector(\"#list\").innerHTML = html;\r\n");
      out.write("			\r\n");
      out.write("			bind()\r\n");
      out.write("		\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		}catch(e){\r\n");
      out.write("			console.log(\"ERROR : drawList\", e);\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function bind(){\r\n");
      out.write("			const delBtnList = document.querySelectorAll(\".btnDel\")\r\n");
      out.write("			for(let btn of delBtnList){\r\n");
      out.write("				btn.addEventListener(\"click\", function(event){\r\n");
      out.write("// 					console.log(this)\r\n");
      out.write("// 					console.log(event.target)\r\n");
      out.write("				\r\n");
      out.write("				/* const id =	event.target.getAttribute(\"id\")\r\n");
      out.write("				// btn_7788 : substring, split... */\r\n");
      out.write("				const empno = event.target.getAttribute(\"data-empno\")\r\n");
      out.write("				console.log(\"empno\",empno)\r\n");
      out.write("			\r\n");
      out.write("				const url2 = \"deleteEmp\"\r\n");
      out.write("				const data = {\r\n");
      out.write("						\"empno\": empno\r\n");
      out.write("				}\r\n");
      out.write("				ajax(\"deleteEmp\", data, function(result){\r\n");
      out.write("					if(result != 0){\r\n");
      out.write("						getList()\r\n");
      out.write("					} else {\r\n");
      out.write("						alert(\"삭제에 실패했습니다.\")\r\n");
      out.write("					}\r\n");
      out.write("				}, \"delete\")\r\n");
      out.write("				\r\n");
      out.write("			})\r\n");
      out.write("		}\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("/*\r\n");
      out.write("	window.addEventListener(\"load\",function(){\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		let url = \"listEmp\"\r\n");
      out.write("		const xhr = new XMLHttpRequest();\r\n");
      out.write("		xhr.open(\"get\",url);\r\n");
      out.write("		xhr.send();\r\n");
      out.write("		\r\n");
      out.write("		xhr.onload = function(){\r\n");
      out.write("\r\n");
      out.write("			console.log(xhr.responseText)  \r\n");
      out.write("		\r\n");
      out.write("			try{\r\n");
      out.write("					const empList = JSON.parse(xhr.responseText);\r\n");
      out.write("					let html = \"\";\r\n");
      out.write("			for(let i=0; i<empList.length; i++){\r\n");
      out.write("// 					console.log(empList[i].ename)\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("// 					html += '<tr>';\r\n");
      out.write("// 					html += '	<td>';\r\n");
      out.write("// 					html += '		<input type=\"checkbox\" name=\"check\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.empno }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">';\r\n");
      out.write("// 					html += '	</td>';\r\n");
      out.write("// 					html += '	<td>'+ empList[i].empno +'</td>';\r\n");
      out.write("// 					html += '	<td><a href=\"emp0?cmd=detail&empno=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.empno }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">'+ empList[i].ename +'</a></td>';\r\n");
      out.write("// 					html += '	<td>'+ empList[i].job +'</td>';\r\n");
      out.write("// 					html += '	<td>'+ empList[i].sal +'</td>';\r\n");
      out.write("// 					html += '	<td>'+ empList[i].hireDate+'</td>';\r\n");
      out.write("// 					html += '</tr>';\r\n");
      out.write("				\r\n");
      out.write("				const hiredate = new Date(empList[i].hireDate)\r\n");
      out.write("				const y = hiredate.getFullYear()\r\n");
      out.write("				let m = hiredate.getMonth() + 1\r\n");
      out.write("				if(m <10){\r\n");
      out.write("					m= \"0\"+ m;\r\n");
      out.write("				}\r\n");
      out.write("				const d = hiredate.getDate()\r\n");
      out.write("				\r\n");
      out.write("				html += `\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>\r\n");
      out.write("							<input type=\"checkbox\" name=\"check\" value=\"${empList[i].empno}\">\r\n");
      out.write("						</td>\r\n");
      out.write("						<td>${empList[i].empno}</td>\r\n");
      out.write("						<td><a href=\"emp0?cmd=detail&empno=${empList[i].empno }\">${empList[i].ename }</a></td>\r\n");
      out.write("						<td>${empList[i].job }</td>\r\n");
      out.write("						<td>${empList[i].sal }</td>\r\n");
      out.write("						<td>\r\n");
      out.write("							${y}년 ${m}월 ${d}일\r\n");
      out.write("						</td>\r\n");
      out.write("						<td>\r\n");
      out.write("							<button type=\"button\" data-empno=\"${empList[i].empno}\" class=\"btnDel\" id=\"btn_${empList[i].empno}\" >삭제</button>\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				`;\r\n");
      out.write("				\r\n");
      out.write("				}\r\n");
      out.write("				\r\n");
      out.write("				document.querySelector(\"#list\").innerHTML = html;\r\n");
      out.write("				\r\n");
      out.write("// 				const delBtnList = document.querySelectorAll(\"[id^=btn]\")\r\n");
      out.write("				const delBtnList = document.querySelectorAll(\".btnDel\")\r\n");
      out.write("				for(let btn of delBtnList){\r\n");
      out.write("					btn.addEventListener(\"click\", function(event){\r\n");
      out.write("						console.log(this)\r\n");
      out.write("						console.log(event.target)\r\n");
      out.write("						\r\n");
      out.write("					const id =	event.target.getAttribute(\"id\")\r\n");
      out.write("					// btn_7788 : substring, split...\r\n");
      out.write("					const empno = event.target.getAttribute(\"data-empno\")\r\n");
      out.write("					console.log(\"empno\",empno)\r\n");
      out.write("					\r\n");
      out.write("					const url2 = \"deleteEmp\"\r\n");
      out.write("					const data = {\r\n");
      out.write("							\"empno\": empno\r\n");
      out.write("					}\r\n");
      out.write("					\r\n");
      out.write("					const xhr2 = new XMLHttpRequest();\r\n");
      out.write("					xhr.open(\"delete\",url2);\r\n");
      out.write("					xhr.setRequestHeader(\"Content-Type\",\"application/json\");\r\n");
      out.write("// 					const strData = JSON.stringify(data);\r\n");
      out.write("					xhr.send(JSON.stringify(data));\r\n");
      out.write("					\r\n");
      out.write("					xhr2.onload = function(){\r\n");
      out.write("						console.log( xhr2.responseText )\r\n");
      out.write("						\r\n");
      out.write("						try{\r\n");
      out.write("							let result = JSON.parse(xhr2.responseText)\r\n");
      out.write("							console.log(result)\r\n");
      out.write("						}catch(e){\r\n");
      out.write("							console.log(\"json아님\",e)\r\n");
      out.write("						}     \r\n");
      out.write("					} \r\n");
      out.write("						\r\n");
      out.write("					})\r\n");
      out.write("				}\r\n");
      out.write("								\r\n");
      out.write("			}catch(e){\r\n");
      out.write("				console.log(\"ERROR : url :\", url, e);\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	})\r\n");
      out.write("*/\r\n");
      out.write("</script>\r\n");
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
