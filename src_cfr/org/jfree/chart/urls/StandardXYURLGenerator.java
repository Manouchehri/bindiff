/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class StandardXYURLGenerator
implements Serializable,
XYURLGenerator {
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

    public StandardXYURLGenerator(String string) {
        this(string, "series", "item");
    }

    public StandardXYURLGenerator(String string, String string2, String string3) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("Null 'seriesParameterName' argument.");
        }
        if (string3 == null) {
            throw new IllegalArgumentException("Null 'itemParameterName' argument.");
        }
        this.prefix = string;
        this.seriesParameterName = string2;
        this.itemParameterName = string3;
    }

    @Override
    public String generateURL(XYDataset xYDataset, int n2, int n3) {
        String string = this.prefix;
        boolean bl2 = string.indexOf("?") == -1;
        string = new StringBuffer().append(string).append(bl2 ? "?" : "&amp;").toString();
        return new StringBuffer().append(string).append(this.seriesParameterName).append("=").append(n2).append("&amp;").append(this.itemParameterName).append("=").append(n3).toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardXYURLGenerator)) {
            return false;
        }
        StandardXYURLGenerator standardXYURLGenerator = (StandardXYURLGenerator)object;
        if (!ObjectUtilities.equal(standardXYURLGenerator.prefix, this.prefix)) {
            return false;
        }
        if (!ObjectUtilities.equal(standardXYURLGenerator.seriesParameterName, this.seriesParameterName)) {
            return false;
        }
        if (ObjectUtilities.equal(standardXYURLGenerator.itemParameterName, this.itemParameterName)) return true;
        return false;
    }
}

