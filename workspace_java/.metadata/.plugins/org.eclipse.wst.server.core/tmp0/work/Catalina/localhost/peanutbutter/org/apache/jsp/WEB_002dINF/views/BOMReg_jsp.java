/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2024-09-08 07:38:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BOMReg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>BOM 등록(부품)</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    * {\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        background-color: #F0F0E8;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .top {\r\n");
      out.write("        color: #676767;\r\n");
      out.write("        font-size: 24px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        height: 15vh;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .title {\r\n");
      out.write("        padding-top: 30px;\r\n");
      out.write("        margin-left: 100px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .title img {\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .title span {\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .section {\r\n");
      out.write("        margin: 0 100px;\r\n");
      out.write("        height: 70vh;\r\n");
      out.write("        display: flex;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .sideBarDiv {\r\n");
      out.write("        background-color: #D7D7D7;\r\n");
      out.write("        width: 200px;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .tableDiv {\r\n");
      out.write("        flex: 1;\r\n");
      out.write("        background-color: white;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .table {\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    th {\r\n");
      out.write("        background-color: #b6b6b6;\r\n");
      out.write("        border-right: 1px solid white;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    td {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .tbody tr {\r\n");
      out.write("        border-bottom: 1px solid lightgray;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    tr th,\r\n");
      out.write("    tr td {\r\n");
      out.write("        padding: 5px 0px;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(1) {\r\n");
      out.write("        width: 5%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(2) {\r\n");
      out.write("        width: 10%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(3) {\r\n");
      out.write("        width: 15%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(4) {\r\n");
      out.write("        width: 10%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(5) {\r\n");
      out.write("        width: 10%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(6) {\r\n");
      out.write("        width: 5%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(7) {\r\n");
      out.write("        width: 10%;\r\n");
      out.write("    }\r\n");
      out.write("    .thead th:nth-child(8) {\r\n");
      out.write("        width: 10%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .Btn_css {\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        background-color: #3F3B3B;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        margin-top: 5px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"text\"] {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .mainMenu {\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        color: gray;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .tableTopDiv {\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        padding: 0px 10px;\r\n");
      out.write("        background-color: white;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .regBtn {\r\n");
      out.write("        margin: 0 100px;\r\n");
      out.write("        text-align: right;\r\n");
      out.write("        margin-top: 30px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .inputText {\r\n");
      out.write("        height: 25px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div class=\"container\">\r\n");
      out.write("    <div class=\"top\">\r\n");
      out.write("        <div class=\"title\">\r\n");
      out.write("            <img src=\"image/BOM.png\" style=\"width: 30px;\">\r\n");
      out.write("            <span>BOM 등록(부품)</span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"section\">\r\n");
      out.write("        <div class=\"tableDiv\">\r\n");
      out.write("            <div class=\"tableTopDiv\">\r\n");
      out.write("                <span style=\"font-weight: bold;\">제품목록</span>\r\n");
      out.write("                <select class=\"제품select\">\r\n");
      out.write("                    <option value=\"-----\">-----</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                <span style=\"margin-left: 20px; font-weight: bold;\"></span>\r\n");
      out.write("                <span id=\"제품코드\" style=\"display:inline-block; width: 10px;\"></span>\r\n");
      out.write("\r\n");
      out.write("                <span class=\"Btn_css\" style=\"margin-left: 50px;\" onclick=\"addRow()\">행 추가</span>\r\n");
      out.write("                <span class=\"Btn_css\" style=\"margin-left: 20px;\" onclick=\"deleteSelectedRow()\">행 삭제</span>              \r\n");
      out.write("               		<span class=\"Btn_css\" id=\"editBtn\"  style=\"margin-left: 50px;\"  onclick=\"editBOM()\">정보 수정</span>   \r\n");
      out.write("            </div>\r\n");
      out.write("            <form id=\"bomForm\" action=\"SubmitBOMServlet\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"productList\" id=\"productList\">\r\n");
      out.write("                <table class=\"table\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th></th>\r\n");
      out.write("                            <th>부품명</th>\r\n");
      out.write("                            <th>모델명</th>\r\n");
      out.write("                            <th>부품코드</th>\r\n");
      out.write("                            <th>규격</th>\r\n");
      out.write("                            <th>단위</th>\r\n");
      out.write("                            <th>수량</th>\r\n");
      out.write("                            <th>거래처</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("\r\n");
      out.write("                    <tbody class=\"tbody\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td><input type=\"checkbox\" class=\"delete-checkbox\"></td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <select name=\"partName[]\" class=\"select1\" onchange=\"updateOption(event)\">\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <select name=\"modelName[]\" class=\"select2\" onchange=\"updateCodePrice(event)\">\r\n");
      out.write("                                    <option value=\"-----\">-----</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td class=\"code\"></td>\r\n");
      out.write("                            <td class=\"size\"></td>\r\n");
      out.write("                            <td class=\"unit\"></td>\r\n");
      out.write("                            <td><input type=\"text\" name=\"quantity[]\" style=\"width: 30%;\"></td>\r\n");
      out.write("                            <td><input type=\"text\" name=\"company[]\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>   \r\n");
      out.write("    </div>\r\n");
      out.write("    	<div class=\"regBtn\">\r\n");
      out.write("     		<span class=\"Btn_css\" onclick=\"submitForm()\">BOM 공정 등록</span>\r\n");
      out.write("    	</div>   	\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("function addRow() { \r\n");
      out.write("    let tbody = document.querySelector('.tbody');\r\n");
      out.write("    let newRow = document.createElement('tr');\r\n");
      out.write("    newRow.innerHTML = `\r\n");
      out.write("        <td><input type=\"checkbox\" class=\"delete-checkbox\"></td>\r\n");
      out.write("        <td>\r\n");
      out.write("            <select name=\"partName[]\" class=\"select1\" onchange=\"updateOption(event)\">\r\n");
      out.write("                <option value=\"-----\">-----</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td>\r\n");
      out.write("            <select name=\"modelName[]\" class=\"select2\" onchange=\"updateCodePrice(event)\">\r\n");
      out.write("                <option value=\"-----\">-----</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td class=\"code\"></td>\r\n");
      out.write("        <td class=\"size\"></td>\r\n");
      out.write("        <td class=\"unit\"></td>\r\n");
      out.write("        <td><input type=\"text\" name=\"quantity[]\" style=\"width: 30%;\"></td>\r\n");
      out.write("        <td><input type=\"text\" name=\"company[]\"></td>\r\n");
      out.write("    `;\r\n");
      out.write("    tbody.appendChild(newRow);\r\n");
      out.write("    populatePartDropdowns(newRow);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function deleteSelectedRow() { \r\n");
      out.write("    let checkboxes = document.querySelectorAll('.delete-checkbox');\r\n");
      out.write("    checkboxes.forEach(checkbox => {\r\n");
      out.write("        if (checkbox.checked) {\r\n");
      out.write("            checkbox.closest('tr').remove(); \r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function populatePartDropdowns(row) {\r\n");
      out.write("    const select1 = row.querySelector('.select1');\r\n");
      out.write("    fetch('GetPartsData')\r\n");
      out.write("        .then(response => response.text())\r\n");
      out.write("        .then(data => {\r\n");
      out.write("            select1.innerHTML = data;\r\n");
      out.write("        })\r\n");
      out.write("        .catch(error => console.error('Error fetching part data:', error));\r\n");
      out.write("\r\n");
      out.write("    const select2 = row.querySelector('.select2');\r\n");
      out.write("    select1.addEventListener('change', function(event) {\r\n");
      out.write("        updateOption(event);\r\n");
      out.write("    });\r\n");
      out.write("    select2.addEventListener('change', function(event) {\r\n");
      out.write("        updateCodePrice(event);\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function updateOption(event) {\r\n");
      out.write("    let select1 = event.target;\r\n");
      out.write("    let select2 = select1.closest('tr').querySelector('.select2');\r\n");
      out.write("    let selectedComponent = select1.value;\r\n");
      out.write("\r\n");
      out.write("    fetch('GetModelData?part_name=' + encodeURIComponent(selectedComponent))\r\n");
      out.write("        .then(response => response.text())\r\n");
      out.write("        .then(data => {\r\n");
      out.write("            select2.innerHTML = data;\r\n");
      out.write("        })\r\n");
      out.write("        .catch(error => console.error('Error fetching model data:', error));\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function updateCodePrice(event) {\r\n");
      out.write("    let select2 = event.target;\r\n");
      out.write("    let selectedOption = select2.value;\r\n");
      out.write("\r\n");
      out.write("    fetch('GetCodeSizeData?model_name=' + encodeURIComponent(selectedOption))\r\n");
      out.write("        .then(response => {\r\n");
      out.write("            if (!response.ok) {\r\n");
      out.write("                throw new Error('Network response was not ok ' + response.statusText);\r\n");
      out.write("            }\r\n");
      out.write("            return response.text();\r\n");
      out.write("        })\r\n");
      out.write("        .then(data => {\r\n");
      out.write("            console.log('Server response:', data); // 응답 로그 추가\r\n");
      out.write("            const parts = data.split('|');\r\n");
      out.write("\r\n");
      out.write("            if (parts.length === 3) {\r\n");
      out.write("                const [code, size, unit] = parts;\r\n");
      out.write("                const codeCell = select2.closest('tr').querySelector('.code');\r\n");
      out.write("                const sizeCell = select2.closest('tr').querySelector('.size');\r\n");
      out.write("                const unitCell = select2.closest('tr').querySelector('.unit');\r\n");
      out.write("\r\n");
      out.write("                if (codeCell) codeCell.textContent = code;\r\n");
      out.write("                if (sizeCell) sizeCell.textContent = size;\r\n");
      out.write("                if (unitCell) unitCell.textContent = unit;\r\n");
      out.write("            } else {\r\n");
      out.write("                console.error('Unexpected response format:', data);\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("        .catch(error => console.error('Error fetching code, size, and unit data:', error));\r\n");
      out.write("}\r\n");
      out.write("document.addEventListener(\"DOMContentLoaded\", function() {\r\n");
      out.write("    fetch('BOMGET')\r\n");
      out.write("        .then(response => response.text())\r\n");
      out.write("        .then(data => {\r\n");
      out.write("            populateProductList(data);\r\n");
      out.write("        })\r\n");
      out.write("        .catch(error => console.error('Error fetching product data:', error));\r\n");
      out.write("    \r\n");
      out.write("    document.querySelectorAll('.select1').forEach(select => {\r\n");
      out.write("        fetch('GetPartsData')\r\n");
      out.write("            .then(response => response.text())\r\n");
      out.write("            .then(data => {\r\n");
      out.write("                select.innerHTML = data;\r\n");
      out.write("            })\r\n");
      out.write("            .catch(error => console.error('Error fetching part data:', error));\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function populateProductList(productNamesHTML) {\r\n");
      out.write("    const productNameSelect = document.querySelector('.제품select');\r\n");
      out.write("    productNameSelect.innerHTML = productNamesHTML;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function submitForm() {\r\n");
      out.write("    let form = document.getElementById('bomForm');\r\n");
      out.write("    let productListSelect = document.querySelector('.제품select');\r\n");
      out.write("    let productListValue = productListSelect.value;\r\n");
      out.write("    \r\n");
      out.write("    // 제품 목록을 숨겨진 필드에 저장\r\n");
      out.write("    document.getElementById('productList').value = productListValue;\r\n");
      out.write("    \r\n");
      out.write("    // 모든 행의 코드, 사이즈, 단위 값을 숨겨진 필드에 추가\r\n");
      out.write("    let tbody = document.querySelector('.tbody');\r\n");
      out.write("    let rows = tbody.querySelectorAll('tr');\r\n");
      out.write("\r\n");
      out.write("    rows.forEach((row, index) => {\r\n");
      out.write("        let code = row.querySelector('.code').textContent.trim();\r\n");
      out.write("        let size = row.querySelector('.size').textContent.trim();\r\n");
      out.write("        let unit = row.querySelector('.unit').textContent.trim();\r\n");
      out.write("\r\n");
      out.write("        // 코드 값 숨겨진 필드 추가\r\n");
      out.write("        let codeInput = document.createElement('input');\r\n");
      out.write("        codeInput.type = 'hidden';\r\n");
      out.write("        codeInput.name = `code[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("]`;\r\n");
      out.write("        codeInput.value = code;\r\n");
      out.write("        form.appendChild(codeInput);\r\n");
      out.write("\r\n");
      out.write("        // 사이즈 값 숨겨진 필드 추가\r\n");
      out.write("        let sizeInput = document.createElement('input');\r\n");
      out.write("        sizeInput.type = 'hidden';\r\n");
      out.write("        sizeInput.name = `size[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("]`;\r\n");
      out.write("        sizeInput.value = size;\r\n");
      out.write("        form.appendChild(sizeInput);\r\n");
      out.write("\r\n");
      out.write("        // 단위 값 숨겨진 필드 추가\r\n");
      out.write("        let unitInput = document.createElement('input');\r\n");
      out.write("        unitInput.type = 'hidden';\r\n");
      out.write("        unitInput.name = `unit[");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${index}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("]`;\r\n");
      out.write("        unitInput.value = unit;\r\n");
      out.write("        form.appendChild(unitInput);\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // 폼을 제출하기 전에 모든 선택된 값들을 확인할 수 있습니다.\r\n");
      out.write("    let selects = document.querySelectorAll('.select1, .select2');\r\n");
      out.write("    selects.forEach(select => {\r\n");
      out.write("        console.log(select.name, select.value);  // 선택된 값 확인용\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    form.submit();  // 폼 제출\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function editBOM() {\r\n");
      out.write("    window.location.href = \"BOMEdit\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
