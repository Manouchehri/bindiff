package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HtmlGenerator {
   private static Map initLineCache = new HashMap();

   public static String escapeHtml(String var0) {
      StringBuffer var1 = new StringBuffer();
      int var2 = var0 == null?0:var0.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var0.charAt(var3);
         if(Character.isLetterOrDigit(var4)) {
            var1.append(var4);
         } else {
            var1.append((new StringBuilder(14)).append("&#").append(var4).append(";").toString());
         }
      }

      return var1.toString();
   }

   public static String getHtml(Collection var0, String var1, boolean var2) {
      StringBuilder var3 = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var1}));
      boolean var4 = true;

      for(Iterator var5 = var0.iterator(); var5.hasNext(); var4 = false) {
         String var6 = (String)var5.next();
         var3.append(var2 && var4?"<b>":"");
         var3.append(escapeHtml(var6));
         var3.append(var2 && var4?"</b>":"");
         var3.append("<br>");
      }

      var3.append("</font></html>");
      return var3.toString();
   }

   public static String getHtml(ZyLabelContent var0, String var1, boolean var2) {
      return getHtml(var0, var1, var2, false);
   }

   public static String getHtml(ZyLabelContent var0, String var1, boolean var2, boolean var3) {
      if(!initLineCache.containsKey(var1)) {
         initLineCache.put(var1, String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var1}));
      }

      StringBuilder var4 = new StringBuilder((String)initLineCache.get(var1));
      int var5 = var0.getLineCount() >= 40?40:var0.getLineCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         String var7 = var0.getLineContent(var6).getText();
         if(!var3 || var7.length() >= 1 && !var7.equals("\n") && !var7.equals("\r") && !var7.equals("\t")) {
            var4.append(var2 && var6 == 0?"<b>":"");
            var4.append(escapeHtml(var7));
            var4.append(var2 && var6 == 0?"</b>":"");
            var4.append("<br>");
         }
      }

      if(var0.getLineCount() > 40) {
         var4.append("...");
         var4.append("<br>");
      }

      var4.append("</font></html>");
      return var4.toString();
   }

   public static String getHtml(ZyLabelContent var0, ZyLabelContent var1, String var2, boolean var3) {
      return getHtml(var0, var1, var2, var3, false);
   }

   public static String getHtml(ZyLabelContent var0, ZyLabelContent var1, String var2, boolean var3, boolean var4) {
      StringBuilder var5 = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var2}));

      int var6;
      String var7;
      for(var6 = 0; var6 < var0.getLineCount(); ++var6) {
         var7 = var0.getLineContent(var6).getText();
         if(!var4 || var7.length() >= 1 && !var7.equals("\n") && !var7.equals("\r") && !var7.equals("\t")) {
            var5.append(var3 && var6 == 0?"<b>":"");
            var5.append(escapeHtml(var0.getLineContent(var6).getText()));
            var5.append(var3 && var6 == 0?"</b>":"");
            var5.append("<br>");
         }
      }

      var5.append("</font>");
      var5.append("<hr></hr>");
      var5.append(String.format("<font face=\"%s\" size=\"3\" color=\"000000\">", new Object[]{var2}));

      for(var6 = 0; var6 < var1.getLineCount(); ++var6) {
         var7 = var1.getLineContent(var6).getText();
         if(!var4 || var7.length() >= 1 && !var7.equals("\n") && !var7.equals("\r") && !var7.equals("\t")) {
            var5.append(var3 && var6 == 0?"<b>":"");
            var5.append(escapeHtml(var1.getLineContent(var6).getText()));
            var5.append(var3 && var6 == 0?"</b>":"");
            var5.append("<br>");
         }
      }

      var5.append("</font></html>");
      return var5.toString();
   }
}
