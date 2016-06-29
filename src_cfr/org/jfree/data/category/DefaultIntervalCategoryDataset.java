/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.data.DataUtilities;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.AbstractSeriesDataset;

public class DefaultIntervalCategoryDataset
extends AbstractSeriesDataset
implements IntervalCategoryDataset {
    private Comparable[] seriesKeys;
    private Comparable[] categoryKeys;
    private Number[][] startData;
    private Number[][] endData;

    public DefaultIntervalCategoryDataset(double[][] arrd, double[][] arrd2) {
        this(DataUtilities.createNumberArray2D(arrd), DataUtilities.createNumberArray2D(arrd2));
    }

    public DefaultIntervalCategoryDataset(Number[][] arrnumber, Number[][] arrnumber2) {
        this(null, null, arrnumber, arrnumber2);
    }

    public DefaultIntervalCategoryDataset(String[] arrstring, Number[][] arrnumber, Number[][] arrnumber2) {
        this((Comparable[])arrstring, null, arrnumber, arrnumber2);
    }

    public DefaultIntervalCategoryDataset(Comparable[] arrcomparable, Comparable[] arrcomparable2, Number[][] arrnumber, Number[][] arrnumber2) {
        this.startData = arrnumber;
        this.endData = arrnumber2;
        if (arrnumber == null) return;
        if (arrnumber2 == null) return;
        String string = "org.jfree.data.resources.DataPackageResources";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(string);
        int n2 = arrnumber.length;
        if (n2 != arrnumber2.length) {
            String string2 = "DefaultIntervalCategoryDataset: the number of series in the start value dataset does not match the number of series in the end value dataset.";
            throw new IllegalArgumentException(string2);
        }
        if (n2 <= 0) {
            this.seriesKeys = null;
            this.categoryKeys = null;
            return;
        }
        if (arrcomparable != null) {
            if (arrcomparable.length != n2) {
                throw new IllegalArgumentException("The number of series keys does not match the number of series in the data.");
            }
            this.seriesKeys = arrcomparable;
        } else {
            String string3 = new StringBuffer().append(resourceBundle.getString("series.default-prefix")).append(" ").toString();
            this.seriesKeys = this.generateKeys(n2, string3);
        }
        int n3 = arrnumber[0].length;
        if (n3 != arrnumber2[0].length) {
            String string4 = "DefaultIntervalCategoryDataset: the number of categories in the start value dataset does not match the number of categories in the end value dataset.";
            throw new IllegalArgumentException(string4);
        }
        if (arrcomparable2 == null) {
            String string5 = new StringBuffer().append(resourceBundle.getString("categories.default-prefix")).append(" ").toString();
            this.categoryKeys = this.generateKeys(n3, string5);
            return;
        }
        if (arrcomparable2.length != n3) {
            throw new IllegalArgumentException("The number of category keys does not match the number of categories in the data.");
        }
        this.categoryKeys = arrcomparable2;
    }

    @Override
    public int getSeriesCount() {
        int n2 = 0;
        if (this.startData == null) return n2;
        return this.startData.length;
    }

    public int getSeriesIndex(Comparable comparable) {
        int n2 = -1;
        int n3 = 0;
        while (n3 < this.seriesKeys.length) {
            if (comparable.equals(this.seriesKeys[n3])) {
                return n3;
            }
            ++n3;
        }
        return n2;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        if (n2 >= this.getSeriesCount()) throw new IllegalArgumentException(new StringBuffer().append("No such series : ").append(n2).toString());
        if (n2 >= 0) return this.seriesKeys[n2];
        throw new IllegalArgumentException(new StringBuffer().append("No such series : ").append(n2).toString());
    }

    public void setSeriesKeys(Comparable[] arrcomparable) {
        if (arrcomparable == null) {
            throw new IllegalArgumentException("Null 'seriesKeys' argument.");
        }
        if (arrcomparable.length != this.getSeriesCount()) {
            throw new IllegalArgumentException("The number of series keys does not match the data.");
        }
        this.seriesKeys = arrcomparable;
        this.fireDatasetChanged();
    }

    public int getCategoryCount() {
        int n2 = 0;
        if (this.startData == null) return n2;
        if (this.getSeriesCount() <= 0) return n2;
        return this.startData[0].length;
    }

    @Override
    public List getColumnKeys() {
        if (this.categoryKeys != null) return Collections.unmodifiableList(Arrays.asList(this.categoryKeys));
        return new ArrayList();
    }

    public void setCategoryKeys(Comparable[] arrcomparable) {
        if (arrcomparable == null) {
            throw new IllegalArgumentException("Null 'categoryKeys' argument.");
        }
        if (arrcomparable.length != this.startData[0].length) {
            throw new IllegalArgumentException("The number of categories does not match the data.");
        }
        int n2 = 0;
        do {
            if (n2 >= arrcomparable.length) {
                this.categoryKeys = arrcomparable;
                this.fireDatasetChanged();
                return;
            }
            if (arrcomparable[n2] == null) {
                throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setCategoryKeys(): null category not permitted.");
            }
            ++n2;
        } while (true);
    }

    @Override
    public Number getValue(Comparable comparable, Comparable comparable2) {
        int n2 = this.getSeriesIndex(comparable);
        if (n2 < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        int n3 = this.getColumnIndex(comparable2);
        if (n3 >= 0) return this.getValue(n2, n3);
        throw new UnknownKeyException("Unknown 'category' key.");
    }

    @Override
    public Number getValue(int n2, int n3) {
        return this.getEndValue(n2, n3);
    }

    @Override
    public Number getStartValue(Comparable comparable, Comparable comparable2) {
        int n2 = this.getSeriesIndex(comparable);
        if (n2 < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        int n3 = this.getColumnIndex(comparable2);
        if (n3 >= 0) return this.getStartValue(n2, n3);
        throw new UnknownKeyException("Unknown 'category' key.");
    }

    @Override
    public Number getStartValue(int n2, int n3) {
        if (n2 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        }
        if (n3 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
        if (n3 < this.getCategoryCount()) return this.startData[n2][n3];
        throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
    }

    @Override
    public Number getEndValue(Comparable comparable, Comparable comparable2) {
        int n2 = this.getSeriesIndex(comparable);
        if (n2 < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        int n3 = this.getColumnIndex(comparable2);
        if (n3 >= 0) return this.getEndValue(n2, n3);
        throw new UnknownKeyException("Unknown 'category' key.");
    }

    @Override
    public Number getEndValue(int n2, int n3) {
        if (n2 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        }
        if (n3 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
        if (n3 < this.getCategoryCount()) return this.endData[n2][n3];
        throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
    }

    public void setStartValue(int n2, Comparable comparable, Number number) {
        if (n2 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        if (n2 > this.getSeriesCount() - 1) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        }
        int n3 = this.getCategoryIndex(comparable);
        if (n3 < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
        }
        this.startData[n2][n3] = number;
        this.fireDatasetChanged();
    }

    public void setEndValue(int n2, Comparable comparable, Number number) {
        if (n2 < 0) throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        if (n2 > this.getSeriesCount() - 1) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        }
        int n3 = this.getCategoryIndex(comparable);
        if (n3 < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
        }
        this.endData[n2][n3] = number;
        this.fireDatasetChanged();
    }

    public int getCategoryIndex(Comparable comparable) {
        int n2 = -1;
        int n3 = 0;
        while (n3 < this.categoryKeys.length) {
            if (comparable.equals(this.categoryKeys[n3])) {
                return n3;
            }
            ++n3;
        }
        return n2;
    }

    private Comparable[] generateKeys(int n2, String string) {
        Comparable[] arrcomparable = new Comparable[n2];
        int n3 = 0;
        while (n3 < n2) {
            String string2;
            arrcomparable[n3] = string2 = new StringBuffer().append(string).append(n3 + 1).toString();
            ++n3;
        }
        return arrcomparable;
    }

    @Override
    public Comparable getColumnKey(int n2) {
        return this.categoryKeys[n2];
    }

    @Override
    public int getColumnIndex(Comparable comparable) {
        if (comparable != null) return this.getCategoryIndex(comparable);
        throw new IllegalArgumentException("Null 'columnKey' argument.");
    }

    @Override
    public int getRowIndex(Comparable comparable) {
        return this.getSeriesIndex(comparable);
    }

    @Override
    public List getRowKeys() {
        if (this.seriesKeys != null) return Collections.unmodifiableList(Arrays.asList(this.seriesKeys));
        return new ArrayList();
    }

    @Override
    public Comparable getRowKey(int n2) {
        if (n2 >= this.getRowCount()) throw new IllegalArgumentException("The 'row' argument is out of bounds.");
        if (n2 >= 0) return this.seriesKeys[n2];
        throw new IllegalArgumentException("The 'row' argument is out of bounds.");
    }

    @Override
    public int getColumnCount() {
        return this.categoryKeys.length;
    }

    @Override
    public int getRowCount() {
        return this.seriesKeys.length;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultIntervalCategoryDataset)) {
            return false;
        }
        DefaultIntervalCategoryDataset defaultIntervalCategoryDataset = (DefaultIntervalCategoryDataset)object;
        if (!Arrays.equals(this.seriesKeys, defaultIntervalCategoryDataset.seriesKeys)) {
            return false;
        }
        if (!Arrays.equals(this.categoryKeys, defaultIntervalCategoryDataset.categoryKeys)) {
            return false;
        }
        if (!DefaultIntervalCategoryDataset.equal(this.startData, defaultIntervalCategoryDataset.startData)) {
            return false;
        }
        if (DefaultIntervalCategoryDataset.equal(this.endData, defaultIntervalCategoryDataset.endData)) return true;
        return false;
    }

    @Override
    public Object clone() {
        DefaultIntervalCategoryDataset defaultIntervalCategoryDataset = (DefaultIntervalCategoryDataset)super.clone();
        defaultIntervalCategoryDataset.categoryKeys = (Comparable[])this.categoryKeys.clone();
        defaultIntervalCategoryDataset.seriesKeys = (Comparable[])this.seriesKeys.clone();
        defaultIntervalCategoryDataset.startData = DefaultIntervalCategoryDataset.clone(this.startData);
        defaultIntervalCategoryDataset.endData = DefaultIntervalCategoryDataset.clone(this.endData);
        return defaultIntervalCategoryDataset;
    }

    private static boolean equal(Number[][] arrnumber, Number[][] arrnumber2) {
        if (arrnumber == null) {
            if (arrnumber2 != null) return false;
            return true;
        }
        if (arrnumber2 == null) {
            return false;
        }
        if (arrnumber.length != arrnumber2.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < arrnumber.length) {
            if (!Arrays.equals(arrnumber[n2], arrnumber2[n2])) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    private static Number[][] clone(Number[][] arrnumber) {
        if (arrnumber == null) {
            throw new IllegalArgumentException("Null 'array' argument.");
        }
        Number[][] arrnumber2 = new Number[arrnumber.length][];
        int n2 = 0;
        while (n2 < arrnumber.length) {
            Number[] arrnumber3 = arrnumber[n2];
            Number[] arrnumber4 = new Number[arrnumber3.length];
            System.arraycopy(arrnumber3, 0, arrnumber4, 0, arrnumber3.length);
            arrnumber2[n2] = arrnumber4;
            ++n2;
        }
        return arrnumber2;
    }

    public List getSeries() {
        if (this.seriesKeys != null) return Collections.unmodifiableList(Arrays.asList(this.seriesKeys));
        return new ArrayList();
    }

    public List getCategories() {
        return this.getColumnKeys();
    }

    public int getItemCount() {
        return this.categoryKeys.length;
    }
}

