package org.jfree.chart.servlet;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class DisplayChart extends HttpServlet
{
    public void init() {
    }
    
    public void service(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) {
        final HttpSession session = httpServletRequest.getSession();
        final String parameter = httpServletRequest.getParameter("filename");
        if (parameter == null) {
            throw new ServletException("Parameter 'filename' must be supplied");
        }
        final String searchReplace = ServletUtilities.searchReplace(parameter, "..", "");
        final File file = new File(System.getProperty("java.io.tmpdir"), searchReplace);
        if (!file.exists()) {
            throw new ServletException("File '" + file.getAbsolutePath() + "' does not exist");
        }
        boolean chartAvailable = false;
        final ChartDeleter chartDeleter = (ChartDeleter)session.getAttribute("JFreeChart_Deleter");
        if (chartDeleter != null) {
            chartAvailable = chartDeleter.isChartAvailable(searchReplace);
        }
        boolean b = false;
        if (searchReplace.length() >= 6 && searchReplace.substring(0, 6).equals("public")) {
            b = true;
        }
        boolean b2 = false;
        if (searchReplace.startsWith(ServletUtilities.getTempOneTimeFilePrefix())) {
            b2 = true;
        }
        if (chartAvailable || b || b2) {
            ServletUtilities.sendTempFile(file, httpServletResponse);
            if (b2) {
                file.delete();
            }
            return;
        }
        throw new ServletException("Chart image not found");
    }
}
