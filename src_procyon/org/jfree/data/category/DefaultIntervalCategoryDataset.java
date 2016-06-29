package org.jfree.data.category;

import org.jfree.data.general.*;
import java.util.*;
import org.jfree.data.*;

public class DefaultIntervalCategoryDataset extends AbstractSeriesDataset implements IntervalCategoryDataset
{
    private Comparable[] seriesKeys;
    private Comparable[] categoryKeys;
    private Number[][] startData;
    private Number[][] endData;
    
    public DefaultIntervalCategoryDataset(final double[][] array, final double[][] array2) {
        this(DataUtilities.createNumberArray2D(array), DataUtilities.createNumberArray2D(array2));
    }
    
    public DefaultIntervalCategoryDataset(final Number[][] array, final Number[][] array2) {
        this(null, null, array, array2);
    }
    
    public DefaultIntervalCategoryDataset(final String[] array, final Number[][] array2, final Number[][] array3) {
        this(array, null, array2, array3);
    }
    
    public DefaultIntervalCategoryDataset(final Comparable[] seriesKeys, final Comparable[] categoryKeys, final Number[][] startData, final Number[][] endData) {
        this.startData = startData;
        this.endData = endData;
        if (startData != null && endData != null) {
            final ResourceBundle bundle = ResourceBundle.getBundle("org.jfree.data.resources.DataPackageResources");
            final int length = startData.length;
            if (length != endData.length) {
                throw new IllegalArgumentException("DefaultIntervalCategoryDataset: the number of series in the start value dataset does not match the number of series in the end value dataset.");
            }
            if (length > 0) {
                if (seriesKeys != null) {
                    if (seriesKeys.length != length) {
                        throw new IllegalArgumentException("The number of series keys does not match the number of series in the data.");
                    }
                    this.seriesKeys = seriesKeys;
                }
                else {
                    this.seriesKeys = this.generateKeys(length, bundle.getString("series.default-prefix") + " ");
                }
                final int length2 = startData[0].length;
                if (length2 != endData[0].length) {
                    throw new IllegalArgumentException("DefaultIntervalCategoryDataset: the number of categories in the start value dataset does not match the number of categories in the end value dataset.");
                }
                if (categoryKeys != null) {
                    if (categoryKeys.length != length2) {
                        throw new IllegalArgumentException("The number of category keys does not match the number of categories in the data.");
                    }
                    this.categoryKeys = categoryKeys;
                }
                else {
                    this.categoryKeys = this.generateKeys(length2, bundle.getString("categories.default-prefix") + " ");
                }
            }
            else {
                this.seriesKeys = null;
                this.categoryKeys = null;
            }
        }
    }
    
    public int getSeriesCount() {
        int length = 0;
        if (this.startData != null) {
            length = this.startData.length;
        }
        return length;
    }
    
    public int getSeriesIndex(final Comparable comparable) {
        int n = -1;
        for (int i = 0; i < this.seriesKeys.length; ++i) {
            if (comparable.equals(this.seriesKeys[i])) {
                n = i;
                break;
            }
        }
        return n;
    }
    
    public Comparable getSeriesKey(final int n) {
        if (n >= this.getSeriesCount() || n < 0) {
            throw new IllegalArgumentException("No such series : " + n);
        }
        return this.seriesKeys[n];
    }
    
    public void setSeriesKeys(final Comparable[] seriesKeys) {
        if (seriesKeys == null) {
            throw new IllegalArgumentException("Null 'seriesKeys' argument.");
        }
        if (seriesKeys.length != this.getSeriesCount()) {
            throw new IllegalArgumentException("The number of series keys does not match the data.");
        }
        this.seriesKeys = seriesKeys;
        this.fireDatasetChanged();
    }
    
    public int getCategoryCount() {
        int length = 0;
        if (this.startData != null && this.getSeriesCount() > 0) {
            length = this.startData[0].length;
        }
        return length;
    }
    
    public List getColumnKeys() {
        if (this.categoryKeys == null) {
            return new ArrayList();
        }
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.categoryKeys));
    }
    
    public void setCategoryKeys(final Comparable[] categoryKeys) {
        if (categoryKeys == null) {
            throw new IllegalArgumentException("Null 'categoryKeys' argument.");
        }
        if (categoryKeys.length != this.startData[0].length) {
            throw new IllegalArgumentException("The number of categories does not match the data.");
        }
        for (int i = 0; i < categoryKeys.length; ++i) {
            if (categoryKeys[i] == null) {
                throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setCategoryKeys(): null category not permitted.");
            }
        }
        this.categoryKeys = categoryKeys;
        this.fireDatasetChanged();
    }
    
    public Number getValue(final Comparable comparable, final Comparable comparable2) {
        final int seriesIndex = this.getSeriesIndex(comparable);
        if (seriesIndex < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        final int columnIndex = this.getColumnIndex(comparable2);
        if (columnIndex < 0) {
            throw new UnknownKeyException("Unknown 'category' key.");
        }
        return this.getValue(seriesIndex, columnIndex);
    }
    
    public Number getValue(final int n, final int n2) {
        return this.getEndValue(n, n2);
    }
    
    public Number getStartValue(final Comparable comparable, final Comparable comparable2) {
        final int seriesIndex = this.getSeriesIndex(comparable);
        if (seriesIndex < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        final int columnIndex = this.getColumnIndex(comparable2);
        if (columnIndex < 0) {
            throw new UnknownKeyException("Unknown 'category' key.");
        }
        return this.getStartValue(seriesIndex, columnIndex);
    }
    
    public Number getStartValue(final int n, final int n2) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        }
        if (n2 < 0 || n2 >= this.getCategoryCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
        }
        return this.startData[n][n2];
    }
    
    public Number getEndValue(final Comparable comparable, final Comparable comparable2) {
        final int seriesIndex = this.getSeriesIndex(comparable);
        if (seriesIndex < 0) {
            throw new UnknownKeyException("Unknown 'series' key.");
        }
        final int columnIndex = this.getColumnIndex(comparable2);
        if (columnIndex < 0) {
            throw new UnknownKeyException("Unknown 'category' key.");
        }
        return this.getEndValue(seriesIndex, columnIndex);
    }
    
    public Number getEndValue(final int n, final int n2) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
        }
        if (n2 < 0 || n2 >= this.getCategoryCount()) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
        }
        return this.endData[n][n2];
    }
    
    public void setStartValue(final int n, final Comparable comparable, final Number n2) {
        if (n < 0 || n > this.getSeriesCount() - 1) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        }
        final int categoryIndex = this.getCategoryIndex(comparable);
        if (categoryIndex < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
        }
        this.startData[n][categoryIndex] = n2;
        this.fireDatasetChanged();
    }
    
    public void setEndValue(final int n, final Comparable comparable, final Number n2) {
        if (n < 0 || n > this.getSeriesCount() - 1) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
        }
        final int categoryIndex = this.getCategoryIndex(comparable);
        if (categoryIndex < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
        }
        this.endData[n][categoryIndex] = n2;
        this.fireDatasetChanged();
    }
    
    public int getCategoryIndex(final Comparable comparable) {
        int n = -1;
        for (int i = 0; i < this.categoryKeys.length; ++i) {
            if (comparable.equals(this.categoryKeys[i])) {
                n = i;
                break;
            }
        }
        return n;
    }
    
    private Comparable[] generateKeys(final int n, final String s) {
        final Comparable[] array = new Comparable[n];
        for (int i = 0; i < n; ++i) {
            array[i] = s + (i + 1);
        }
        return array;
    }
    
    public Comparable getColumnKey(final int n) {
        return this.categoryKeys[n];
    }
    
    public int getColumnIndex(final Comparable comparable) {
        if (comparable == null) {
            throw new IllegalArgumentException("Null 'columnKey' argument.");
        }
        return this.getCategoryIndex(comparable);
    }
    
    public int getRowIndex(final Comparable comparable) {
        return this.getSeriesIndex(comparable);
    }
    
    public List getRowKeys() {
        if (this.seriesKeys == null) {
            return new ArrayList();
        }
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.seriesKeys));
    }
    
    public Comparable getRowKey(final int n) {
        if (n >= this.getRowCount() || n < 0) {
            throw new IllegalArgumentException("The 'row' argument is out of bounds.");
        }
        return this.seriesKeys[n];
    }
    
    public int getColumnCount() {
        return this.categoryKeys.length;
    }
    
    public int getRowCount() {
        return this.seriesKeys.length;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultIntervalCategoryDataset)) {
            return false;
        }
        final DefaultIntervalCategoryDataset defaultIntervalCategoryDataset = (DefaultIntervalCategoryDataset)o;
        return Arrays.equals(this.seriesKeys, defaultIntervalCategoryDataset.seriesKeys) && Arrays.equals(this.categoryKeys, defaultIntervalCategoryDataset.categoryKeys) && equal(this.startData, defaultIntervalCategoryDataset.startData) && equal(this.endData, defaultIntervalCategoryDataset.endData);
    }
    
    public Object clone() {
        final DefaultIntervalCategoryDataset defaultIntervalCategoryDataset = (DefaultIntervalCategoryDataset)super.clone();
        defaultIntervalCategoryDataset.categoryKeys = this.categoryKeys.clone();
        defaultIntervalCategoryDataset.seriesKeys = this.seriesKeys.clone();
        defaultIntervalCategoryDataset.startData = clone(this.startData);
        defaultIntervalCategoryDataset.endData = clone(this.endData);
        return defaultIntervalCategoryDataset;
    }
    
    private static boolean equal(final Number[][] array, final Number[][] array2) {
        if (array == null) {
            return array2 == null;
        }
        if (array2 == null) {
            return false;
        }
        if (array.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array.length; ++i) {
            if (!Arrays.equals(array[i], array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    private static Number[][] clone(final Number[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null 'array' argument.");
        }
        final Number[][] array2 = new Number[array.length][];
        for (int i = 0; i < array.length; ++i) {
            final Number[] array3 = array[i];
            final Number[] array4 = new Number[array3.length];
            System.arraycopy(array3, 0, array4, 0, array3.length);
            array2[i] = array4;
        }
        return array2;
    }
    
    public List getSeries() {
        if (this.seriesKeys == null) {
            return new ArrayList();
        }
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.seriesKeys));
    }
    
    public List getCategories() {
        return this.getColumnKeys();
    }
    
    public int getItemCount() {
        return this.categoryKeys.length;
    }
}
