/*
 * JSP generated by Resin-3.0.19 (built Mon, 15 May 2006 04:50:47 PDT)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _terms__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      com.caucho.jsp.QJspFactory.freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.make.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != 7932908523769947432L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.make.Dependency depend;
      depend = (com.caucho.make.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("terms.jsp"), 8500813871678214027L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("links.jsp"), -7853399731057764231L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("copyrights.jsp"), -8144456906676724675L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n\r\n<html>\r\n<head>\r\n	<title>AdSapient</title>\r\n	<link rel=\"STYLESHEET\" type=\"text/css\" href=\"adsapient.css\">\r\n</head>\r\n\r\n<body>\r\n<table class=\"main_table\">\r\n	<tr>\r\n		<td class=\"main_table_top\">\r\n			<table class=\"table_center\" align=\"center\">\r\n				<tr>\r\n					<td></td>\r\n				</tr>\r\n			</table>\r\n		</td>\r\n	</tr>\r\n	<tr>\r\n		<td class=\"main_table_top_links\">\r\n			<table class=\"table_center_links\" align=\"center\">\r\n				<tr>\r\n					<td><a href=\"index.jsp\" class=\"links_text\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"products.jsp\" class=\"links_text\">Products</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"support.jsp\" class=\"links_text\">Support</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"contact.jsp\" class=\"links_text\">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n				</tr>\r\n			</table>\r\n		</td>\r\n	</tr>\r\n	<tr>\r\n		<td class=\"main_table_screen\">\r\n			<table class=\"table_center_screen\" align=\"center\">\r\n				<tr>\r\n					<td width=\"780\" height=\"100%\" valign=\"top\" class=\"products_text\">\r\n					<!--Page Start-->\r\n					\r\n					<center>\r\n\r\n<table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n<tr>\r\n	<td class=\"maintext\" align=\"left\">\r\n	<p>Welcome to <b>AdSapient.com</b>. This is a secure website, operated by AdSapient, Inc. \r\n	Any use of the AdSapient website is subject to the following conditions. Please read them \r\n	carefully.</p>\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>Your permission to use the AdSapient website</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	AdSapient is the owner or licensee of all rights in the AdSapient website, its General Content, \r\n	software, and services. In no event may the information available on the AdSapient website be \r\n	used for any commercial purpose or use. You may not redistribute, retransmit, publish, \r\n	or republish any General Content on or downloaded from the AdSapient website without written \r\n	permission from us or our licensors and without attribution to AdSapient and a legal disclaimer \r\n	acceptable to us; AdSapient and &quot;AdSapient.com&quot; are trademarks of AdSapient, Inc. and you do \r\n	not have any right, title or interest in these or other trademarks belonging to AdSapient.\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>Your Obligations</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	In exercising the limited rights granted you under this Agreement, you \r\n	hereby agree to the following:\r\n	<ol>\r\n	<li>You will take reasonable steps to prevent disclosure of your password to third parties\r\n	<li>If you are authorized to access a client&#146;s AdSapient Account, \r\n	you will maintain the privacy and confidentiality of the information in \r\n	accordance with applicable state and federal laws including, any applicable ethical guidelines\r\n	<li>You will not post or provide any content, information, or data that violates any \r\n	proprietary or privacy right of a third-party or is in any way libelous, defamatory, \r\n	indecent, obscene, pornographic, false, misleading, or inaccurate\r\n	<li>You will not use the AdSapient website or \r\n	information obtained from the AdSapient \r\n	website to threaten, harass, stalk, abuse or otherwise violate any person&#146;s legal rights\r\n	<li>You will not access or attempt to access any AdSapient \r\n	Account and other \r\n	confidential information, which you are not authorized to view or access\r\n	<li>You will not tamper with or in any way modify any General Content posted or provided \r\n	by anyone other than yourself\r\n	<li>You will not change or delete any proprietary notices from materials downloaded from \r\n	the AdSapient website\r\n	<li>You will not systemically print out or store a significant segment of any database of \r\n	the AdSapient website\r\n	<li>You will not systemically or intentionally upload files or data that contain a virus \r\n	or corrupted data\r\n	<li>You will not disrupt the availability of the AdSapient \r\n	website to others, and\r\n	<li>You will not use the AdSapient website in a \r\n	manner contrary to any applicable federal or state law\r\n	</ol>\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>AdSapient is a Communication Tool; \r\nClients are Responsible for the Information Contained</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	We do not verify whether the client has provided the \r\n	correct information to us. Nor do we monitor the information contained in a \r\n	AdSapient Account to ensure its completeness, \r\n	accuracy, reliability and timeliness, or whether information contained in the Account \r\n	were prepared in accordance with applicable professional standards. Therefore, INFORMATION \r\n	CONTAINED IN A ADSAPIENT ACCOUNT IS PROVIDED &quot;AS IS.&quot; WE MAKE NO WARRANTY AS TO THE RELIABILITY, ACCURACY, \r\n	TIMELINESS, USEFULNESS, ADEQUACY, COMPLETENESS OR SUITABILITY OF ANY INFORMATION WHATSOEVER \r\n	CONTAINED IN A ADSAPIENT ACCOUNT.\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>The AdSapient website is Provided &quot;As Is&quot;</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	<p>We make no representation about the accuracy, completeness, suitability, \r\n	or timeliness of the materials and information provided on the AdSapient website. \r\n	You should not rely on this website as \r\n	either comprehensive or error-free.</p>\r\n\r\n	<p class=\"n\">Therefore, SERVICES PROVIDED THROUGH AND INFORMATION CONTAINED ON THE \r\n	ADSAPIENT WEBSITE ARE PROVIDED &quot;AS IS&quot;. ADSAPIENT \r\n	AND ITS LICENSORS MAKE NO, AND HEREBY DISCLAIM ANY, WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING ANY WARRANTIES OF \r\n	TITLE, NONINFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR USE OR PURPOSE. \r\n	FURTHER, ADSAPIENT DISCLAIMS ANY WARRANTY THAT THE \r\n	ADSAPIENT WEBSITE WILL BE AVAILABLE AT ALL TIMES \r\n	OR WILL OPERATE WITHOUT EITHER INTERRUPTION OR ERROR.</p>\r\n\r\n	<p class=\"maintext\">ADSAPIENT AND ITS INFORMATION PROVIDERS \r\n	MAKE NO WARRANTY AS TO THE RELIABILITY, ACCURACY, TIMELINESS, USEFULNESS, ADEQUACY, COMPLETENESS \r\n	OR SUITABILITY OF THE SERVICES OR INFORMATION CONTAINED ON THE ADSAPIENT \r\n	WEBSITE. </p>\r\n\r\n	<p class=\"maintext\">EXCEPT AS OTHERWISE PROVIDED FOR IN THIS AGREEMENT, WE SHALL HAVE NO \r\n	OBLIGATION OR RESPONSIBILITY TO YOU OR ANY OTHER PARTY IN PREVENTING ANY INFORMATION, \r\n	COMMUNICATIONS OR MATERIALS YOU POST OR UPLOAD ON TO THE ADSAPIENT \r\n	WEBSITE FROM BEING COPIED, PLAGIARIZED OR OTHERWISE USED IN ANY UNAUTHORIZED FASHION BY ANY THIRD PARTY.</p>\r\n\r\n	<p class=\"maintext\">Although we take reasonable precautions designed to protect the \r\n	confidentiality and privacy of AdSapient Accounts, \r\n	we cannot absolutely guarantee the privacy and confidentiality of AdSapient \r\n	Accounts. Accordingly, WE SHALL HAVE NO RESPONSIBILITY IF, DESPITE OUR REASONABLE EFFORTS TO PROTECT THE PRIVACY AND \r\n	CONFIDENTIALITY OF A ADSAPIENT ACCOUNT, AN UNAUTHORIZED \r\n	INDIVIDUAL ACCESSES SUCH ACCOUNT. NOR SHALL WE HAVE ANY RESPONSIBILITY IF AN INDIVIDUAL \r\n	AUTHORIZED TO ACCESS AN ACCOUNT USES OR DISCLOSES INFORMATION CONTAINED IN THAT ACCOUNT IN AN UNAUTHORIZED MANNER.</p>\r\n\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>Your are Solely Responsible for Your Use of the AdSapient website</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	<p>You must possess the legal capacity to enter into this Agreement. You \r\n	hereby agree to be solely responsible for your use of the AdSapient website, and hereby \r\n	agree to indemnify, defend, and hold harmless AdSapient, Inc., \r\n	its officers, directors, employees, agents, and licensors from any claim or cause of action \r\n	arising out of or relating to your use of the AdSapient website.</p>\r\n\r\n	<p>ADSAPIENT, ITS OFFICERS, DIRECTORS, EMPLOYEES, AGENTS, AFFILIATES AND \r\n	INFORMATION PROVIDERS SHALL NOT BE LIABLE FOR ANY DAMAGES YOU MAY SUFFER OR CAUSE \r\n	THROUGH YOUR USE OF THE ADSAPIENT WEBSITE EVEN IF WE HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.</p>\r\n\r\n	<p>ADSAPIENT, ITS OFFICERS, DIRECTORS, \r\n	EMPLOYEES, AGENTS, AFFILIATES AND INFORMATION PROVIDERS SHALL NOT BE LIABLE FOR ANY DIRECT, \r\n	INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL, OR PUNITIVE DAMAGES ARISING OUT OF OR RELATING TO \r\n	YOUR USE OF OR INABILITY TO USE THE ADSAPIENT WEBSITE. IN \r\n	NO EVENT SHALL ADSAPIENT, ITS OFFICERS, DIRECTORS, EMPLOYEES, \r\n	AGENTS, AFFILIATES AND INFORMATION PROVIDERS&#146; LIABILITY TO YOU EXCEED THE ADSAPIENT \r\n	ANNUAL FEE.</p>\r\n\r\n	<p>YOU ARE RESPONSIBLE FOR (1) MAINTAINING ANY EQUIPMENT USED BY YOU TO \r\n	ACCESS AND USE THE ADSAPIENT WEBSITE, (2) ENSURING THE \r\n	ACCURACY, RELIABILITY AND COMPLETENESS OF INFORMATION YOU POST, AND (3) \r\n	MAINTAINING A MEANS OR RESOURCE EXTERNAL TO THE ADSAPIENT WEBSITE \r\n	FOR THE RECONSTRUCTION OF ANY LOST DATA.</p>\r\n\r\n	<p>ADSAPIENT, INC MAKES NO REPRESENTATION \r\n	OR WARRANTY, EXPRESS OR IMPLIED, THAT THE MATERIALS ON OR SERVICES OFFERED THROUGH THE \r\n	ADSAPIENT WEBSITE ARE LEGALLY PERMITTED IN YOUR STATE \r\n	OR COUNTRY OF RESIDENCE. YOU MAY NOT ACCESS OR USE THE ADSAPIENT WEBSITE \r\n	FROM A STATE OR COUNTRY WHERE THE CONTENT CONTAINED ON OR SERVICES OFFERED THROUGH THE \r\n	ADSAPIENT WEBSITE ARE ILLEGAL.</p>\r\n\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>We are not Responsible for any Links to or from Other Sites</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	The AdSapient website may include links \r\n	to websites operated by third parties, or other websites may link to the \r\n	AdSapient website or to specific pages within the website. \r\n	We do not monitor, filter, edit, or censor the materials or information appearing on these other \r\n	websites. We assume no liability or responsibility for these other websites or their content. Any \r\n	link to or from a third-party website or web page is not an endorsement of that website by us. \r\n	Statements made on third-party websites linked to or from the AdSapient website \r\n	reflect only the views of their authors and not of AdSapient.\r\n\r\n	</td>\r\n</tr><tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>Your Right to Use the AdSapient website may be Terminated at Any Time</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	Either you or AdSapient, Inc. may terminate your \r\n	right to use the AdSapient website at any time or for any \r\n	reason whatsoever upon notice. We reserve the right to terminate or suspend a subscription to \r\n	AdSapient without prior notice, although we will confirm such \r\n	termination or suspension by subsequent notice. \r\n\r\n	</td>\r\n</tr>\r\n<tr>\r\n	<td>&nbsp;</td>\r\n</tr>\r\n<tr><td class=\"maintext\"><b><center>Other Miscellaneous Provisions</center></b></td></tr>\r\n<tr>\r\n	<td class=\"maintext\">\r\n	<p>These Conditions of Use constitute the entire and only understanding \r\n	between you and AdSapient, Inc. In the event of any \r\n	conflict between these Conditions of Use and any policy or statement regarding your use of \r\n	the AdSapient website, these Conditions of Use shall \r\n	govern. We may modify these Conditions of Use at any time or for any reason in our sole discretion. \r\n	We will notify you of any modifications to these Conditions of Use by posting a general notice \r\n	on the AdSapient website, and any such modification to \r\n	these Conditions of Use will become effective immediately the next time you access the \r\n	AdSapient website after we post the notice of such modification.</p>\r\n\r\n	<p>No joint venture, partnership, employment or agency relationship \r\n	exists between you and AdSapient, Inc. as a result of \r\n	these Conditions of Use or your use of the AdSapient website.</p>\r\n\r\n	<p>Any notice we send to you in connection with these Conditions of Use \r\n	may be delivered to you by a general notice on the AdSapient website. \r\n	You may send a notice to AdSapient, Inc. to the following address:</p>\r\n\r\n	<ul>\r\n		Voronjanskogo Str., 7a - 706<br>\r\n220039 Minsk<br>\r\nRepublic of Belarus<br>\r\n	</ul>\r\n\r\n	<p>Any term or condition of these Conditions of Use are severable to the extent any term is \r\n	deemed invalid, illegal or unenforceable. Our failure to enforce any provision of this \r\n	Conditions of Use Agreement shall not be deemed a waiver of that or any other term or \r\n	condition of these Conditions of Use.</p>\r\n\r\n	<p>You may not transfer or assign these Conditions of Use to any other \r\n	party.</p>\r\n\r\n	<p>The terms or conditions of these Conditions of Use that normally \r\n	would survive the termination of an agreement shall survive any termination of these \r\n	Conditions of Use.</p>\r\n\r\n	<p class=\"maintext\"><center><b>Thank you for using the AdSapient website.</b></center></p>\r\n	</td>\r\n</tr>\r\n</table>\r\n\r\n\r\n					\r\n					\r\n					\r\n					\r\n					\r\n					\r\n					\r\n					<!--Page End-->\r\n					</td>\r\n				</tr>\r\n			</table>\r\n		</td>\r\n	</tr>\r\n	<tr>\r\n		<td class=\"main_table_bottom_links\">\r\n			<table class=\"table_center_links\" align=\"center\">\r\n				<tr>\r\n					<td><a href=\"index.jsp\" class=\"links_text\">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"products.jsp\" class=\"links_text\">Products</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"support.jsp\" class=\"links_text\">Support</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n<a href=\"contact.jsp\" class=\"links_text\">Contact</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n				</tr>\r\n			</table>\r\n		</td>\r\n	</tr>\r\n	<tr>\r\n		<td class=\"main_table_bottom\">\r\n			<table class=\"table_center_bottom\" align=\"center\">\r\n				<tr>\r\n					<td class=\"table_center_bottom_text\">\u00a9 2007 AdSapient. All Rights Reserved. <a href=\"terms.jsp\" class=\"bottom_text\">Terms</a> | <a href=\"privacy.jsp\" class=\"bottom_text\">Privacy</a></td>\r\n				</tr>\r\n			</table>\r\n		</td>\r\n	</tr>\r\n</table>\r\n</body>\r\n</html>\r\n".toCharArray();
  }
}