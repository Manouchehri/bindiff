package org.jfree.chart.urls;

import java.io.*;
import org.jfree.data.xy.*;
import org.jfree.util.*;

public class StandardXYURLGenerator implements Serializable, XYURLGenerator
{
    private static final long serialVersionUID = -1771624523496595382L;
    public static final String DEFAULT_PREFIX = "index.html";
    public static final String DEFAULT_SERIES_PARAMETER = "series";
    public static final String DEFAULT_ITEM_PARAMETER = "item";
    private String prefix;
    private String seriesParameterName;
    private String itemParameterName;
    
    public StandardXYURLGenerator() {
        this("index.html", "series", "item");
    }
    
    public StandardXYURLGenerator(final String s) {
        this(s, "series", "item");
    }
    
    public StandardXYURLGenerator(final String prefix, final String seriesParameterName, final String itemParameterName) {
        if (prefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (seriesParameterName == null) {
            throw new IllegalArgumentException("Null 'seriesParameterName' argument.");
        }
        if (itemParameterName == null) {
            throw new IllegalArgumentException("Null 'itemParameterName' argument.");
        }
        this.prefix = prefix;
        this.seriesParameterName = seriesParameterName;
        this.itemParameterName = itemParameterName;
    }
    
    public String generateURL(final XYDataset xyDataset, final int n, final int n2) {
        final String prefix = this.prefix;
        return prefix + ((prefix.indexOf("?") == -1) ? "?" : "&amp;") + this.seriesParameterName + "=" + n + "&amp;" + this.itemParameterName + "=" + n2;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardXYURLGenerator)) {
            return false;
        }
        final StandardXYURLGenerator standardXYURLGenerator = (StandardXYURLGenerator)o;
        return ObjectUtilities.equal(standardXYURLGenerator.prefix, this.prefix) && ObjectUtilities.equal(standardXYURLGenerator.seriesParameterName, this.seriesParameterName) && ObjectUtilities.equal(standardXYURLGenerator.itemParameterName, this.itemParameterName);
    }
}
