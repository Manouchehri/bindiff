/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.urls;

import java.io.Serializable;
import java.net.URLEncoder;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.ObjectUtilities;

public class StandardCategoryURLGenerator
implements Serializable,
Cloneable,
CategoryURLGenerator {
    private static final long serialVersionUID = 2276668053074881909L;
    private String prefix = "index.html";
    private String seriesParameterName = "series";
    private String categoryParameterName = "category";

    public StandardCategoryURLGenerator() {
    }

    public StandardCategoryURLGenerator(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        this.prefix = string;
    }

    public StandardCategoryURLGenerator(String string, String string2, String string3) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        if (string2 == null) {
            throw new IllegalArgumentException("Null 'seriesParameterName' argument.");
        }
        if (string3 == null) {
            throw new IllegalArgumentException("Null 'categoryParameterName' argument.");
        }
        this.prefix = string;
        this.seriesParameterName = string2;
        this.categoryParameterName = string3;
    }

    @Override
    public String generateURL(CategoryDataset categoryDataset, int n2, int n3) {
        String string = this.prefix;
        Comparable comparable = categoryDataset.getRowKey(n2);
        Comparable comparable2 = categoryDataset.getColumnKey(n3);
        boolean bl2 = string.indexOf("?") == -1;
        string = new StringBuffer().append(string).append(bl2 ? "?" : "&amp;").toString();
        string = new StringBuffer().append(string).append(this.seriesParameterName).append("=").append(URLEncoder.encode(comparable.toString())).toString();
        return new StringBuffer().append(string).append("&amp;").append(this.categoryParameterName).append("=").append(URLEncoder.encode(comparable2.toString())).toString();
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardCategoryURLGenerator)) {
            return false;
        }
        StandardCategoryURLGenerator standardCategoryURLGenerator = (StandardCategoryURLGenerator)object;
        if (!ObjectUtilities.equal(this.prefix, standardCategoryURLGenerator.prefix)) {
            return false;
        }
        if (!ObjectUtilities.equal(this.seriesParameterName, standardCategoryURLGenerator.seriesParameterName)) {
            return false;
        }
        if (ObjectUtilities.equal(this.categoryParameterName, standardCategoryURLGenerator.categoryParameterName)) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.prefix != null ? this.prefix.hashCode() : 0;
        n2 = 29 * n2 + (this.seriesParameterName != null ? this.seriesParameterName.hashCode() : 0);
        return 29 * n2 + (this.categoryParameterName != null ? this.categoryParameterName.hashCode() : 0);
    }
}

