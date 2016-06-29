package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public class HtmlGenerator
{
    private static Map initLineCache;
    
    public static String escapeHtml(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int n = (s == null) ? 0 : s.length(), i = 0; i < n; ++i) {
            final char char1 = s.charAt(i);
            if (Character.isLetterOrDigit(char1)) {
                sb.append(char1);
            }
            else {
                sb.append(new StringBuilder(14).append("&#").append((int)char1).append(";").toString());
            }
        }
        return sb.toString();
    }
    
    public static String getHtml(final Collection collection, final String s, final boolean b) {
        final StringBuilder sb = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", s));
        int n = 1;
        for (final String s2 : collection) {
            sb.append((b && n != 0) ? "<b>" : "");
            sb.append(escapeHtml(s2));
            sb.append((b && n != 0) ? "</b>" : "");
            sb.append("<br>");
            n = 0;
        }
        sb.append("</font></html>");
        return sb.toString();
    }
    
    public static String getHtml(final ZyLabelContent zyLabelContent, final String s, final boolean b) {
        return getHtml(zyLabelContent, s, b, false);
    }
    
    public static String getHtml(final ZyLabelContent zyLabelContent, final String s, final boolean b, final boolean b2) {
        if (!HtmlGenerator.initLineCache.containsKey(s)) {
            HtmlGenerator.initLineCache.put(s, String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", s));
        }
        final StringBuilder sb = new StringBuilder(HtmlGenerator.initLineCache.get(s));
        for (int n = (zyLabelContent.getLineCount() >= 40) ? 40 : zyLabelContent.getLineCount(), i = 0; i < n; ++i) {
            final String text = zyLabelContent.getLineContent(i).getText();
            if (b2) {
                if (text.length() < 1 || text.equals("\n") || text.equals("\r")) {
                    continue;
                }
                if (text.equals("\t")) {
                    continue;
                }
            }
            sb.append((b && i == 0) ? "<b>" : "");
            sb.append(escapeHtml(text));
            sb.append((b && i == 0) ? "</b>" : "");
            sb.append("<br>");
        }
        if (zyLabelContent.getLineCount() > 40) {
            sb.append("...");
            sb.append("<br>");
        }
        sb.append("</font></html>");
        return sb.toString();
    }
    
    public static String getHtml(final ZyLabelContent zyLabelContent, final ZyLabelContent zyLabelContent2, final String s, final boolean b) {
        return getHtml(zyLabelContent, zyLabelContent2, s, b, false);
    }
    
    public static String getHtml(final ZyLabelContent zyLabelContent, final ZyLabelContent zyLabelContent2, final String s, final boolean b, final boolean b2) {
        final StringBuilder sb = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", s));
        for (int i = 0; i < zyLabelContent.getLineCount(); ++i) {
            final String text = zyLabelContent.getLineContent(i).getText();
            if (b2) {
                if (text.length() < 1 || text.equals("\n") || text.equals("\r")) {
                    continue;
                }
                if (text.equals("\t")) {
                    continue;
                }
            }
            sb.append((b && i == 0) ? "<b>" : "");
            sb.append(escapeHtml(zyLabelContent.getLineContent(i).getText()));
            sb.append((b && i == 0) ? "</b>" : "");
            sb.append("<br>");
        }
        sb.append("</font>");
        sb.append("<hr></hr>");
        sb.append(String.format("<font face=\"%s\" size=\"3\" color=\"000000\">", s));
        for (int j = 0; j < zyLabelContent2.getLineCount(); ++j) {
            final String text2 = zyLabelContent2.getLineContent(j).getText();
            if (b2) {
                if (text2.length() < 1 || text2.equals("\n") || text2.equals("\r")) {
                    continue;
                }
                if (text2.equals("\t")) {
                    continue;
                }
            }
            sb.append((b && j == 0) ? "<b>" : "");
            sb.append(escapeHtml(zyLabelContent2.getLineContent(j).getText()));
            sb.append((b && j == 0) ? "</b>" : "");
            sb.append("<br>");
        }
        sb.append("</font></html>");
        return sb.toString();
    }
    
    static {
        HtmlGenerator.initLineCache = new HashMap();
    }
}
