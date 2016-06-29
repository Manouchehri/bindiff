/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package org.jfree.chart.servlet;

import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.servlet.ChartDeleter;
import org.jfree.chart.servlet.ServletUtilities;

public class DisplayChart
extends HttpServlet {
    public void init() {
    }

    public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession httpSession = httpServletRequest.getSession();
        String string = httpServletRequest.getParameter("filename");
        if (string == null) {
            throw new ServletException("Parameter 'filename' must be supplied");
        }
        string = ServletUtilities.searchReplace(string, "..", "");
        File file = new File(System.getProperty("java.io.tmpdir"), string);
        if (!file.exists()) {
            throw new ServletException(new StringBuffer().append("File '").append(file.getAbsolutePath()).append("' does not exist").toString());
        }
        boolean bl2 = false;
        ChartDeleter chartDeleter = (ChartDeleter)httpSession.getAttribute("JFreeChart_Deleter");
        if (chartDeleter != null) {
            bl2 = chartDeleter.isChartAvailable(string);
        }
        boolean bl3 = false;
        if (string.length() >= 6 && string.substring(0, 6).equals("public")) {
            bl3 = true;
        }
        boolean bl4 = false;
        if (string.startsWith(ServletUtilities.getTempOneTimeFilePrefix())) {
            bl4 = true;
        }
        if (!bl2 && !bl3) {
            if (!bl4) throw new ServletException("Chart image not found");
        }
        ServletUtilities.sendTempFile(file, httpServletResponse);
        if (!bl4) return;
        file.delete();
    }
}

