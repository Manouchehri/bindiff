package org.jfree.chart.servlet;

import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.servlet.ChartDeleter;
import org.jfree.chart.servlet.ServletUtilities;

public class DisplayChart extends HttpServlet {
   public void init() {
   }

   public void service(HttpServletRequest var1, HttpServletResponse var2) {
      HttpSession var3 = var1.getSession();
      String var4 = var1.getParameter("filename");
      if(var4 == null) {
         throw new ServletException("Parameter \'filename\' must be supplied");
      } else {
         var4 = ServletUtilities.searchReplace(var4, "..", "");
         File var5 = new File(System.getProperty("java.io.tmpdir"), var4);
         if(!var5.exists()) {
            throw new ServletException("File \'" + var5.getAbsolutePath() + "\' does not exist");
         } else {
            boolean var6 = false;
            ChartDeleter var7 = (ChartDeleter)var3.getAttribute("JFreeChart_Deleter");
            if(var7 != null) {
               var6 = var7.isChartAvailable(var4);
            }

            boolean var8 = false;
            if(var4.length() >= 6 && var4.substring(0, 6).equals("public")) {
               var8 = true;
            }

            boolean var9 = false;
            if(var4.startsWith(ServletUtilities.getTempOneTimeFilePrefix())) {
               var9 = true;
            }

            if(!var6 && !var8 && !var9) {
               throw new ServletException("Chart image not found");
            } else {
               ServletUtilities.sendTempFile(var5, var2);
               if(var9) {
                  var5.delete();
               }

            }
         }
      }
   }
}
