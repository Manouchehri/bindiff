/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesURLGenerator
implements Serializable,
XYURLGenerator {
    private static final long serialVersionUID = -9122773175671182445L;
    private DateFormat dateFormat = DateFormat.getInstance();
    private String prefix = "index.html";
    private String seriesParameterName = "series";
    private String itemParameterName = "item";

    public TimeSeriesURLGenerator() {
    }

    public TimeSeriesURLGenerator(DateFormat dateFormat, String string, String string2, String string3) {
        this.dateFormat = dateFormat;
        this.prefix = string;
        this.seriesParameterName = string2;
        this.itemParameterName = string3;
    }

    @Override
    public String generateURL(XYDataset xYDataset, int n2, int n3) {
        String string = this.prefix;
        boolean bl2 = string.indexOf("?") == -1;
        Comparable comparable = xYDataset.getSeriesKey(n2);
        if (comparable != null) {
            string = new StringBuffer().append(string).append(bl2 ? "?" : "&amp;").toString();
            string = new StringBuffer().append(string).append(this.seriesParameterName).append("=").append(comparable.toString()).toString();
            bl2 = false;
        }
        long l2 = (long)xYDataset.getXValue(n2, n3);
        String string2 = this.dateFormat.format(new Date(l2));
        string = new StringBuffer().append(string).append(bl2 ? "?" : "&amp;").toString();
        return new StringBuffer().append(string).append(this.itemParameterName).append("=").append(string2).toString();
    }
}

