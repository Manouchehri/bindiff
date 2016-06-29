/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HtmlGenerator {
    private static Map initLineCache = new HashMap();

    public static String escapeHtml(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = string == null ? 0 : string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (Character.isLetterOrDigit(c2)) {
                stringBuffer.append(c2);
            } else {
                char c3 = c2;
                stringBuffer.append(new StringBuilder(14).append("&#").append((int)c3).append(";").toString());
            }
            ++n3;
        }
        return stringBuffer.toString();
    }

    public static String getHtml(Collection collection, String string, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", string));
        boolean bl3 = true;
        Iterator iterator = collection.iterator();
        do {
            if (!iterator.hasNext()) {
                stringBuilder.append("</font></html>");
                return stringBuilder.toString();
            }
            String string2 = (String)iterator.next();
            stringBuilder.append(bl2 && bl3 ? "<b>" : "");
            stringBuilder.append(HtmlGenerator.escapeHtml(string2));
            stringBuilder.append(bl2 && bl3 ? "</b>" : "");
            stringBuilder.append("<br>");
            bl3 = false;
        } while (true);
    }

    public static String getHtml(ZyLabelContent zyLabelContent, String string, boolean bl2) {
        return HtmlGenerator.getHtml(zyLabelContent, string, bl2, false);
    }

    public static String getHtml(ZyLabelContent zyLabelContent, String string, boolean bl2, boolean bl3) {
        if (!initLineCache.containsKey(string)) {
            initLineCache.put(string, String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", string));
        }
        StringBuilder stringBuilder = new StringBuilder((String)initLineCache.get(string));
        int n2 = zyLabelContent.getLineCount() >= 40 ? 40 : zyLabelContent.getLineCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = zyLabelContent.getLineContent(i2).getText();
            if (bl3 && (string2.length() < 1 || string2.equals("\n") || string2.equals("\r") || string2.equals("\t"))) continue;
            stringBuilder.append(bl2 && i2 == 0 ? "<b>" : "");
            stringBuilder.append(HtmlGenerator.escapeHtml(string2));
            stringBuilder.append(bl2 && i2 == 0 ? "</b>" : "");
            stringBuilder.append("<br>");
        }
        if (zyLabelContent.getLineCount() > 40) {
            stringBuilder.append("...");
            stringBuilder.append("<br>");
        }
        stringBuilder.append("</font></html>");
        return stringBuilder.toString();
    }

    public static String getHtml(ZyLabelContent zyLabelContent, ZyLabelContent zyLabelContent2, String string, boolean bl2) {
        return HtmlGenerator.getHtml(zyLabelContent, zyLabelContent2, string, bl2, false);
    }

    public static String getHtml(ZyLabelContent zyLabelContent, ZyLabelContent zyLabelContent2, String string, boolean bl2, boolean bl3) {
        int n2;
        String string2;
        StringBuilder stringBuilder = new StringBuilder(String.format("<html><font face=\"%s\" size=\"3\" color=\"000000\">", string));
        for (n2 = 0; n2 < zyLabelContent.getLineCount(); ++n2) {
            string2 = zyLabelContent.getLineContent(n2).getText();
            if (bl3 && (string2.length() < 1 || string2.equals("\n") || string2.equals("\r") || string2.equals("\t"))) continue;
            stringBuilder.append(bl2 && n2 == 0 ? "<b>" : "");
            stringBuilder.append(HtmlGenerator.escapeHtml(zyLabelContent.getLineContent(n2).getText()));
            stringBuilder.append(bl2 && n2 == 0 ? "</b>" : "");
            stringBuilder.append("<br>");
        }
        stringBuilder.append("</font>");
        stringBuilder.append("<hr></hr>");
        stringBuilder.append(String.format("<font face=\"%s\" size=\"3\" color=\"000000\">", string));
        n2 = 0;
        do {
            if (n2 >= zyLabelContent2.getLineCount()) {
                stringBuilder.append("</font></html>");
                return stringBuilder.toString();
            }
            string2 = zyLabelContent2.getLineContent(n2).getText();
            if (!bl3 || string2.length() >= 1 && !string2.equals("\n") && !string2.equals("\r") && !string2.equals("\t")) {
                stringBuilder.append(bl2 && n2 == 0 ? "<b>" : "");
                stringBuilder.append(HtmlGenerator.escapeHtml(zyLabelContent2.getLineContent(n2).getText()));
                stringBuilder.append(bl2 && n2 == 0 ? "</b>" : "");
                stringBuilder.append("<br>");
            }
            ++n2;
        } while (true);
    }
}

