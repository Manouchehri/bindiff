package org.jfree.chart.urls;

import java.io.*;
import java.text.*;
import org.jfree.data.xy.*;
import java.util.*;

public class TimeSeriesURLGenerator implements Serializable, XYURLGenerator
{
    private static final long serialVersionUID = -9122773175671182445L;
    private DateFormat dateFormat;
    private String prefix;
    private String seriesParameterName;
    private String itemParameterName;
    
    public TimeSeriesURLGenerator() {
        this.dateFormat = DateFormat.getInstance();
        this.prefix = "index.html";
        this.seriesParameterName = "series";
        this.itemParameterName = "item";
    }
    
    public TimeSeriesURLGenerator(final DateFormat dateFormat, final String prefix, final String seriesParameterName, final String itemParameterName) {
        this.dateFormat = DateFormat.getInstance();
        this.prefix = "index.html";
        this.seriesParameterName = "series";
        this.itemParameterName = "item";
        this.dateFormat = dateFormat;
        this.prefix = prefix;
        this.seriesParameterName = seriesParameterName;
        this.itemParameterName = itemParameterName;
    }
    
    public String generateURL(final XYDataset xyDataset, final int n, final int n2) {
        String s = this.prefix;
        int n3 = (s.indexOf("?") == -1) ? 1 : 0;
        final Comparable seriesKey = xyDataset.getSeriesKey(n);
        if (seriesKey != null) {
            s = s + ((n3 != 0) ? "?" : "&amp;") + this.seriesParameterName + "=" + seriesKey.toString();
            n3 = 0;
        }
        return s + ((n3 != 0) ? "?" : "&amp;") + this.itemParameterName + "=" + this.dateFormat.format(new Date((long)xyDataset.getXValue(n, n2)));
    }
}
