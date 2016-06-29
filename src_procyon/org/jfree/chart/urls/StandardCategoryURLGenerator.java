package org.jfree.chart.urls;

import java.io.*;
import org.jfree.data.category.*;
import java.net.*;
import org.jfree.util.*;

public class StandardCategoryURLGenerator implements Serializable, Cloneable, CategoryURLGenerator
{
    private static final long serialVersionUID = 2276668053074881909L;
    private String prefix;
    private String seriesParameterName;
    private String categoryParameterName;
    
    public StandardCategoryURLGenerator() {
        this.prefix = "index.html";
        this.seriesParameterName = "series";
        this.categoryParameterName = "category";
    }
    
    public StandardCategoryURLGenerator(final String prefix) {
        this.prefix = "index.html";
        this.seriesParameterName = "series";
        this.categoryParameterName = "category";
        if (prefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        this.prefix = prefix;
    }
    
    public StandardCategoryURLGenerator(final String prefix, final String seriesParameterName, final String categoryParameterName) {
        this.prefix = "index.html";
        this.seriesParameterName = "series";
        this.categoryParameterName = "category";
        if (prefix == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (seriesParameterName == null) {
            throw new IllegalArgumentException("Null 'seriesParameterName' argument.");
        }
        if (categoryParameterName == null) {
            throw new IllegalArgumentException("Null 'categoryParameterName' argument.");
        }
        this.prefix = prefix;
        this.seriesParameterName = seriesParameterName;
        this.categoryParameterName = categoryParameterName;
    }
    
    public String generateURL(final CategoryDataset categoryDataset, final int n, final int n2) {
        final String prefix = this.prefix;
        return prefix + ((prefix.indexOf("?") == -1) ? "?" : "&amp;") + this.seriesParameterName + "=" + URLEncoder.encode(categoryDataset.getRowKey(n).toString()) + "&amp;" + this.categoryParameterName + "=" + URLEncoder.encode(categoryDataset.getColumnKey(n2).toString());
    }
    
    public Object clone() {
        return super.clone();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StandardCategoryURLGenerator)) {
            return false;
        }
        final StandardCategoryURLGenerator standardCategoryURLGenerator = (StandardCategoryURLGenerator)o;
        return ObjectUtilities.equal(this.prefix, standardCategoryURLGenerator.prefix) && ObjectUtilities.equal(this.seriesParameterName, standardCategoryURLGenerator.seriesParameterName) && ObjectUtilities.equal(this.categoryParameterName, standardCategoryURLGenerator.categoryParameterName);
    }
    
    public int hashCode() {
        return 29 * (29 * ((this.prefix != null) ? this.prefix.hashCode() : 0) + ((this.seriesParameterName != null) ? this.seriesParameterName.hashCode() : 0)) + ((this.categoryParameterName != null) ? this.categoryParameterName.hashCode() : 0);
    }
}
