/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.imagemap;

import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.imagemap.OverLIBToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.imagemap.ToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.URLTagFragmentGenerator;
import org.jfree.util.StringUtils;

public class ImageMapUtilities {
    public static void writeImageMap(PrintWriter printWriter, String string, ChartRenderingInfo chartRenderingInfo) {
        ImageMapUtilities.writeImageMap(printWriter, string, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }

    public static void writeImageMap(PrintWriter printWriter, String string, ChartRenderingInfo chartRenderingInfo, boolean bl2) {
        ToolTipTagFragmentGenerator toolTipTagFragmentGenerator = null;
        toolTipTagFragmentGenerator = bl2 ? new OverLIBToolTipTagFragmentGenerator() : new StandardToolTipTagFragmentGenerator();
        ImageMapUtilities.writeImageMap(printWriter, string, chartRenderingInfo, toolTipTagFragmentGenerator, new StandardURLTagFragmentGenerator());
    }

    public static void writeImageMap(PrintWriter printWriter, String string, ChartRenderingInfo chartRenderingInfo, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator uRLTagFragmentGenerator) {
        printWriter.println(ImageMapUtilities.getImageMap(string, chartRenderingInfo, toolTipTagFragmentGenerator, uRLTagFragmentGenerator));
    }

    public static String getImageMap(String string, ChartRenderingInfo chartRenderingInfo) {
        return ImageMapUtilities.getImageMap(string, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }

    public static String getImageMap(String string, ChartRenderingInfo chartRenderingInfo, ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, URLTagFragmentGenerator uRLTagFragmentGenerator) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("<map id=\"").append(string).append("\" name=\"").append(string).append("\">").toString());
        stringBuffer.append(StringUtils.getLineSeparator());
        EntityCollection entityCollection = chartRenderingInfo.getEntityCollection();
        if (entityCollection != null) {
            int n2 = entityCollection.getEntityCount();
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                String string2;
                ChartEntity chartEntity = entityCollection.getEntity(i2);
                if (chartEntity.getToolTipText() == null && chartEntity.getURLText() == null || (string2 = chartEntity.getImageMapAreaTag(toolTipTagFragmentGenerator, uRLTagFragmentGenerator)).length() <= 0) continue;
                stringBuffer.append(string2);
                stringBuffer.append(StringUtils.getLineSeparator());
            }
        }
        stringBuffer.append("</map>");
        return stringBuffer.toString();
    }
}

