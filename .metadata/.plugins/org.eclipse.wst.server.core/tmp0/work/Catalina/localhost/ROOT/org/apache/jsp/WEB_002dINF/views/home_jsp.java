/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.73
 * Generated at: 2022-02-09 06:58:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.choi.board.common.AuthUser;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(9);
    _jspx_dependants.put("/WEB-INF/views/include/footer.jsp", Long.valueOf(1641772907000L));
    _jspx_dependants.put("/WEB-INF/tags/notLogin.tag", Long.valueOf(1641784532000L));
    _jspx_dependants.put("jar:file:/Users/macintosh/git/ToyProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Reply_Board/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("jar:file:/Users/macintosh/git/ToyProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Reply_Board/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fmt.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("jar:file:/Users/macintosh/git/ToyProject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Reply_Board/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fn.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/WEB-INF/views/include/head.jsp", Long.valueOf(1644389879000L));
    _jspx_dependants.put("/WEB-INF/views/include/header.jsp", Long.valueOf(1641962411000L));
    _jspx_dependants.put("/WEB-INF/tags/isLogin.tag", Long.valueOf(1641784533000L));
    _jspx_dependants.put("/WEB-INF/lib/standard-1.1.2.jar", Long.valueOf(1641747443000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.choi.board.common.AuthUser");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<title>미니 프로젝트 게시판</title>\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"/static/css/bootstrap.min.css\"> -->\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/css/bootstrap.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/static/css/boardlist.css\">\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("	href=\"/static/fonts/glyphicons-halflings-regular.woff2\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("<link\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap\"\n");
      out.write("	rel=\"stylesheet\">\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.css\">\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.ui.position.js\"></script>\n");
      out.write("<script\n");
      out.write("	src=\"https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js\"></script>\n");
      out.write("<script\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("	$(function() {\n");
      out.write("		$.contextMenu({\n");
      out.write("	        selector: '.context-menu-one', \n");
      out.write("	        trigger: 'left',\n");
      out.write("	        callback: function(key, options) {\n");
      out.write("	            var m = \"clicked: \" + key;\n");
      out.write("	            window.console && console.log(m) || alert(m); \n");
      out.write("	        },\n");
      out.write("	        items: {\n");
      out.write("	            \"edit\": {name: \"Edit\", icon: \"edit\"},\n");
      out.write("	            \"cut\": {name: \"Cut\", icon: \"cut\"},\n");
      out.write("	            \"copy\": {name: \"Copy\", icon: \"copy\"},\n");
      out.write("	            \"paste\": {name: \"Paste\", icon: \"paste\"},\n");
      out.write("	            \"delete\": {name: \"Delete\", icon: \"delete\"},\n");
      out.write("	            \"sep1\": \"---------\",\n");
      out.write("	            \"quit\": {name: \"Quit\", icon: function($element, key, item){ return 'context-menu-icon context-menu-icon-quit'; }}\n");
      out.write("	        }\n");
      out.write("	    });\n");
      out.write("		\n");
      out.write("		if ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\n");
      out.write("			alert('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\n");
      out.write("		}\n");
      out.write("	});\n");
      out.write("	function 로그인유저인가(link) {\n");
      out.write("		if ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\n");
      out.write("			location.href = link;\n");
      out.write("		} else {\n");
      out.write("			alert(\"로그인이 필요합니다.\");\n");
      out.write("			location.href = \"list\";\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	function 관리자인가(link) {\n");
      out.write("		if ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("') {\n");
      out.write("			location.href = link;\n");
      out.write("		} else {\n");
      out.write("			alert(\"관리자 권한이 필요합니다.\");\n");
      out.write("			location.href = \"list\";\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	\n");
      out.write("</script>\n");
      out.write("</head>");
      out.write("\n");
      out.write("<style>\n");
      out.write(".btn {\n");
      out.write("	display: inline-block;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("	");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
      out.write("h3 {\n");
      out.write("	color: white;\n");
      out.write("	margin-top: 12px;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<header>\n");
      out.write("	<h1>미니 프로젝트</h1>\n");
      out.write("	<nav>\n");
      out.write("		<ul>\n");
      out.write("			");
      if (_jspx_meth_u_005fnotLogin_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("			");
      if (_jspx_meth_u_005fisLogin_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("		</ul>\n");
      out.write("	</nav>\n");
      out.write("	<script type=\"text/javascript\">\n");
      out.write("	function 팝업창(type){\n");
      out.write("		var url = \"../member/\"+type;\n");
      out.write("		var popupX = (document.body.offsetWidth / 2) - (200 / 2);\n");
      out.write("		var popupY= (window.screen.height / 2) - (300 / 2);\n");
      out.write("		if (type == 'modify' || type == 'register') {\n");
      out.write("			window.open(url,type,'resizable=no width=300 height=300 left=' + popupX +', top='+ popupY +'return false');\n");
      out.write("		} else {\n");
      out.write("			window.open(url,type,'resizable=no width=300 height=200 left=' + popupX +', top='+ popupY +'return false');	\n");
      out.write("		}\n");
      out.write("	}\n");
      out.write("	</script>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("	<div class=\"container\" align=\"center\">\n");
      out.write("		<div class=\"jumbotron\">\n");
      out.write("			<div class=\"container\" align=\"center\">\n");
      out.write("				<h1>웹 사이트 소개</h1>\n");
      out.write("				<p align=\"center\">자유게시판 사이트 입니다.</p>\n");
      out.write("				<a class=\"btn btn-primary btn-block\" href=\"board/list?page=1\">게시판</a>\n");
      out.write("				<p>\n");
      out.write("					<a class=\"btn btn-primary btn-block\" onclick=\"상세설명()\">자세히 알아보기</a>\n");
      out.write("				</p>\n");
      out.write("				<div id=\"detail\"></div>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	<div class=\"container\" align=\"center\">\n");
      out.write("		<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("			<!-- Indicators -->\n");
      out.write("			<ol class=\"carousel-indicators\">\n");
      out.write("				<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("				<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("				<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("			</ol>\n");
      out.write("\n");
      out.write("			<!-- Wrapper for slides -->\n");
      out.write("			<div class=\"carousel-inner\">\n");
      out.write("				<div class=\"item active\">\n");
      out.write("					<img src=\"/static/img/1.png\" alt=\"Spring\"\n");
      out.write("						style=\"width: auto; height: 50vh;\">\n");
      out.write("				</div>\n");
      out.write("\n");
      out.write("				<div class=\"item\">\n");
      out.write("					<img src=\"/static/img/2.png\" alt=\"Tomcat\"\n");
      out.write("						style=\"width: auto; height: 50vh\">\n");
      out.write("				</div>\n");
      out.write("\n");
      out.write("				<div class=\"item\">\n");
      out.write("					<img src=\"/static/img/3.png\" alt=\"Bootstrap\"\n");
      out.write("						style=\"width: auto; height: 50vh\">\n");
      out.write("				</div>\n");
      out.write("			</div>\n");
      out.write("\n");
      out.write("			<!-- Left and right controls -->\n");
      out.write("			<a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">\n");
      out.write("				<span class=\"glyphicon glyphicon-chevron-left\"></span> <span\n");
      out.write("				class=\"sr-only\">Previous</span>\n");
      out.write("			</a> <a class=\"right carousel-control\" href=\"#myCarousel\"\n");
      out.write("				data-slide=\"next\"> <span\n");
      out.write("				class=\"glyphicon glyphicon-chevron-right\"></span> <span\n");
      out.write("				class=\"sr-only\">Next</span>\n");
      out.write("			</a>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	");
      out.write("\n");
      out.write("<footer class=\"main-footer\">\n");
      out.write("	<!-- To the right -->\n");
      out.write("	<div class=\"pull-right hidden-xs\">Anything you want</div>\n");
      out.write("	<!-- Default to the left -->\n");
      out.write("	<strong>Copyright &copy; 2022 <a href=\"#\">Company</a>.\n");
      out.write("	</strong> All rights reserved.\n");
      out.write("</footer>");
      out.write("\n");
      out.write("	<script>\n");
      out.write("		function 상세설명() {\n");
      out.write("			const element = document.getElementById('detail');\n");
      out.write("			element.innerText = '이 게시판은 스프링, 톰캣, 부트스트랩으로 제작되었습니다.';\n");
      out.write("		}\n");
      out.write("		</script>\n");
      out.write("	<script src=\"/static/js/jQuery-3.6.0.js\"></script>\n");
      out.write("	<script src=\"/static/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/include/head.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/views/include/head.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_u_005fnotLogin_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  u:notLogin
    org.apache.jsp.tag.web.notLogin_tag _jspx_th_u_005fnotLogin_005f0 = new org.apache.jsp.tag.web.notLogin_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_u_005fnotLogin_005f0);
    try {
      _jspx_th_u_005fnotLogin_005f0.setJspContext(_jspx_page_context);
      _jspx_th_u_005fnotLogin_005f0.setJspBody(new Helper( 0, _jspx_page_context, _jspx_th_u_005fnotLogin_005f0, null));
      _jspx_th_u_005fnotLogin_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_u_005fnotLogin_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_u_005fisLogin_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  u:isLogin
    org.apache.jsp.tag.web.isLogin_tag _jspx_th_u_005fisLogin_005f0 = new org.apache.jsp.tag.web.isLogin_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_u_005fisLogin_005f0);
    try {
      _jspx_th_u_005fisLogin_005f0.setJspContext(_jspx_page_context);
      _jspx_th_u_005fisLogin_005f0.setJspBody(new Helper( 1, _jspx_page_context, _jspx_th_u_005fisLogin_005f0, null));
      _jspx_th_u_005fisLogin_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_u_005fisLogin_005f0);
    }
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\n");
      out.write("				<li><a class=\"btn\" onclick=\"팝업창('login')\">로그인</a></li>\n");
      out.write("\n");
      out.write("				<li><a class=\"btn\" onclick=\"팝업창('register')\">회원가입</a></li>\n");
      out.write("			");
      return false;
    }
    public boolean invoke1( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("\n");
      out.write("				<li><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginUser.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님의</h3></li>\n");
      out.write("				<li><a class=\"btn\" onclick=\"팝업창('modify')\">회원정보수정</a></li>\n");
      out.write("\n");
      out.write("				<li><a class=\"btn\" href=\"../member/logout\">로그아웃</a></li>\n");
      out.write("			");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
