package org.jfree.chart.urls;

import java.io.*;
import org.jfree.data.general.*;
import org.jfree.util.*;

public class StandardPieURLGenerator implements Serializable, PieURLGenerator
{
    private static final long serialVersionUID = 1626966402065883419L;
    private String prefix;
    private String categoryParameterName;
    private String indexParameterName;
    
    public StandardPieURLGenerator() {
        this("index.html");
    }
    
    public StandardPieURLGenerator(final String s) {
        this(s, "category");
    }
    
    public StandardPieURLGenerator(final String s, final String s2) {
        this(s, s2, "pieIndex");
    }
    
    public StandardPieURLGenerator(final String prefix, final String categoryParameterName, final String indexParameterName) {
        this.prefix = "index.html";
        this.categoryParameterName = "category";
        this.indexParameterName = "pieIndex";
        if (prefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (categoryParameterName == null) {
            throw new IllegalArgumentException("Null 'categoryParameterName' argument.");
        }
        this.prefix = prefix;
        this.categoryParameterName = categoryParameterName;
        this.indexParameterName = indexParameterName;
    }
    
    public String generateURL(final PieDataset pieDataset, final Comparable comparable, final int n) {
        final String prefix = this.prefix;
        String s;
        if (prefix.indexOf("?") > -1) {
            s = prefix + "&amp;" + this.categoryParameterName + "=" + comparable.toString();
        }
        else {
            s = prefix + "?" + this.categoryParameterName + "=" + comparable.toString();
        }
        if (this.indexParameterName != null) {
            s = s + "&amp;" + this.indexParameterName + "=" + String.valueOf(n);
        }
        return s;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardPieURLGenerator)) {
            return false;
        }
        final StandardPieURLGenerator standardPieURLGenerator = (StandardPieURLGenerator)o;
        return this.prefix.equals(standardPieURLGenerator.prefix) && this.categoryParameterName.equals(standardPieURLGenerator.categoryParameterName) && ObjectUtilities.equal(this.indexParameterName, standardPieURLGenerator.indexParameterName);
    }
}
