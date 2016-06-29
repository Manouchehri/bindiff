package org.jfree.chart.imagemap;

import java.io.*;
import org.jfree.chart.*;
import org.jfree.util.*;
import org.jfree.chart.entity.*;

public class ImageMapUtilities
{
    public static void writeImageMap(final PrintWriter printWriter, final String s, final ChartRenderingInfo chartRenderingInfo) {
        writeImageMap(printWriter, s, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }
    
    public static void writeImageMap(final PrintWriter printWriter, final String s, final ChartRenderingInfo chartRenderingInfo, final boolean b) {
        ToolTipTagFragmentGenerator toolTipTagFragmentGenerator;
        if (b) {
            toolTipTagFragmentGenerator = new OverLIBToolTipTagFragmentGenerator();
        }
        else {
            toolTipTagFragmentGenerator = new StandardToolTipTagFragmentGenerator();
        }
        writeImageMap(printWriter, s, chartRenderingInfo, toolTipTagFragmentGenerator, new StandardURLTagFragmentGenerator());
    }
    
    public static void writeImageMap(final PrintWriter printWriter, final String s, final ChartRenderingInfo chartRenderingInfo, final ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, final URLTagFragmentGenerator urlTagFragmentGenerator) {
        printWriter.println(getImageMap(s, chartRenderingInfo, toolTipTagFragmentGenerator, urlTagFragmentGenerator));
    }
    
    public static String getImageMap(final String s, final ChartRenderingInfo chartRenderingInfo) {
        return getImageMap(s, chartRenderingInfo, new StandardToolTipTagFragmentGenerator(), new StandardURLTagFragmentGenerator());
    }
    
    public static String getImageMap(final String s, final ChartRenderingInfo chartRenderingInfo, final ToolTipTagFragmentGenerator toolTipTagFragmentGenerator, final URLTagFragmentGenerator urlTagFragmentGenerator) {
        final StringBuffer sb = new StringBuffer();
        sb.append("<map id=\"" + s + "\" name=\"" + s + "\">");
        sb.append(StringUtils.getLineSeparator());
        final EntityCollection entityCollection = chartRenderingInfo.getEntityCollection();
        if (entityCollection != null) {
            for (int i = entityCollection.getEntityCount() - 1; i >= 0; --i) {
                final ChartEntity entity = entityCollection.getEntity(i);
                if (entity.getToolTipText() != null || entity.getURLText() != null) {
                    final String imageMapAreaTag = entity.getImageMapAreaTag(toolTipTagFragmentGenerator, urlTagFragmentGenerator);
                    if (imageMapAreaTag.length() > 0) {
                        sb.append(imageMapAreaTag);
                        sb.append(StringUtils.getLineSeparator());
                    }
                }
            }
        }
        sb.append("</map>");
        return sb.toString();
    }
}
