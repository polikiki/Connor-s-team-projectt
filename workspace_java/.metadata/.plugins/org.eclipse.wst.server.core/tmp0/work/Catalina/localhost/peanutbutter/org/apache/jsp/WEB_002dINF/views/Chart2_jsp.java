/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-09-08 11:05:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Chart2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>라인별 실적 현황</title>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div style=\"width: 80%; margin: auto;\">\r\n");
      out.write("        <canvas id=\"performanceChart\"></canvas>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"script.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    const ctx = document.getElementById('performanceChart').getContext('2d');\r\n");
      out.write("const performanceChart = new Chart(ctx, {\r\n");
      out.write("    type: 'line',\r\n");
      out.write("    data: {\r\n");
      out.write("        labels: ['00:00', '02:00', '04:00', '06:00', '08:00', '10:00', '12:00', '14:00', '16:00', '18:00', '20:00', '22:00'],\r\n");
      out.write("        datasets: [\r\n");
      out.write("            {\r\n");
      out.write("                label: '라인 1',\r\n");
      out.write("                data: [120, 180, 250, 300, 450, 500, 550, 600, 620, 700, 750, 780],\r\n");
      out.write("                borderColor: 'rgba(255, 99, 132, 1)',\r\n");
      out.write("                backgroundColor: 'rgba(255, 99, 132, 0.2)',\r\n");
      out.write("                fill: false\r\n");
      out.write("            },\r\n");
      out.write("            {\r\n");
      out.write("                label: '라인 2',\r\n");
      out.write("                data: [100, 170, 220, 310, 330, 470, 480, 520, 540, 680, 720, 760],\r\n");
      out.write("                borderColor: 'rgba(54, 162, 235, 1)',\r\n");
      out.write("                backgroundColor: 'rgba(54, 162, 235, 0.2)',\r\n");
      out.write("                fill: false\r\n");
      out.write("            },\r\n");
      out.write("            {\r\n");
      out.write("                label: '라인 3',\r\n");
      out.write("                data: [140, 190, 230, 340, 390, 420, 500, 540, 570, 620, 690, 730],\r\n");
      out.write("                borderColor: 'rgba(255, 206, 86, 1)',\r\n");
      out.write("                backgroundColor: 'rgba(255, 206, 86, 0.2)',\r\n");
      out.write("                fill: false\r\n");
      out.write("            },\r\n");
      out.write("            {\r\n");
      out.write("                label: '라인 4',\r\n");
      out.write("                data: [130, 160, 240, 320, 350, 410, 460, 500, 530, 610, 660, 700],\r\n");
      out.write("                borderColor: 'rgba(75, 192, 192, 1)',\r\n");
      out.write("                backgroundColor: 'rgba(75, 192, 192, 0.2)',\r\n");
      out.write("                fill: false\r\n");
      out.write("            }\r\n");
      out.write("        ]\r\n");
      out.write("    },\r\n");
      out.write("    options: {\r\n");
      out.write("        responsive: true,\r\n");
      out.write("        plugins: {\r\n");
      out.write("            legend: {\r\n");
      out.write("                display: true,\r\n");
      out.write("                position: 'top'\r\n");
      out.write("            },\r\n");
      out.write("            tooltip: {\r\n");
      out.write("                mode: 'index',\r\n");
      out.write("                intersect: false\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        scales: {\r\n");
      out.write("            x: {\r\n");
      out.write("                title: {\r\n");
      out.write("                    display: true,\r\n");
      out.write("                    text: '시간'\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            y: {\r\n");
      out.write("                beginAtZero: true,\r\n");
      out.write("                title: {\r\n");
      out.write("                    display: true,\r\n");
      out.write("                    text: '실적'\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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