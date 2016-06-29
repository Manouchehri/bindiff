package org.jfree.util;

import java.io.*;
import java.util.*;

public class ObjectTable implements Serializable
{
    private static final long serialVersionUID = -3968322452944912066L;
    private int rows;
    private int columns;
    private transient Object[][] data;
    private int rowIncrement;
    private int columnIncrement;
    
    public ObjectTable() {
        this(5, 5);
    }
    
    public ObjectTable(final int n) {
        this(n, n);
    }
    
    public ObjectTable(final int rowIncrement, final int columnIncrement) {
        if (rowIncrement < 1) {
            throw new IllegalArgumentException("Increment must be positive.");
        }
        if (columnIncrement < 1) {
            throw new IllegalArgumentException("Increment must be positive.");
        }
        this.rows = 0;
        this.columns = 0;
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
        this.data = new Object[rowIncrement][];
    }
    
    public int getColumnIncrement() {
        return this.columnIncrement;
    }
    
    public int getRowIncrement() {
        return this.rowIncrement;
    }
    
    protected void ensureRowCapacity(final int n) {
        if (n >= this.data.length) {
            final Object[][] data = new Object[n + this.rowIncrement][];
            System.arraycopy(this.data, 0, data, 0, this.data.length);
            this.data = data;
        }
    }
    
    public void ensureCapacity(final int n, final int n2) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Row is invalid. " + n);
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException("Column is invalid. " + n2);
        }
        this.ensureRowCapacity(n);
        final Object[] array = this.data[n];
        if (array == null) {
            this.data[n] = new Object[Math.max(n2 + 1, this.columnIncrement)];
        }
        else if (n2 >= array.length) {
            final Object[] array2 = new Object[n2 + this.columnIncrement];
            System.arraycopy(array, 0, array2, 0, array.length);
            this.data[n] = array2;
        }
    }
    
    public int getRowCount() {
        return this.rows;
    }
    
    public int getColumnCount() {
        return this.columns;
    }
    
    protected Object getObject(final int n, final int n2) {
        if (n < this.data.length) {
            final Object[] array = this.data[n];
            if (array == null) {
                return null;
            }
            if (n2 < array.length) {
                return array[n2];
            }
        }
        return null;
    }
    
    protected void setObject(final int n, final int n2, final Object o) {
        this.ensureCapacity(n, n2);
        this.data[n][n2] = o;
        this.rows = Math.max(this.rows, n + 1);
        this.columns = Math.max(this.columns, n2 + 1);
    }
    
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof ObjectTable)) {
            return false;
        }
        final ObjectTable objectTable = (ObjectTable)o;
        if (this.getRowCount() != objectTable.getRowCount()) {
            return false;
        }
        if (this.getColumnCount() != objectTable.getColumnCount()) {
            return false;
        }
        for (int i = 0; i < this.getRowCount(); ++i) {
            for (int j = 0; j < this.getColumnCount(); ++j) {
                if (!ObjectUtilities.equal(this.getObject(i, j), objectTable.getObject(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * this.rows + this.columns;
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        final int length = this.data.length;
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; ++i) {
            final Object[] array = this.data[i];
            objectOutputStream.writeBoolean(array != null);
            if (array != null) {
                final int length2 = array.length;
                objectOutputStream.writeInt(length2);
                for (int j = 0; j < length2; ++j) {
                    this.writeSerializedData(objectOutputStream, array[j]);
                }
            }
        }
    }
    
    protected void writeSerializedData(final ObjectOutputStream objectOutputStream, final Object o) {
        objectOutputStream.writeObject(o);
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        final int int1 = objectInputStream.readInt();
        this.data = new Object[int1][];
        for (int i = 0; i < int1; ++i) {
            if (objectInputStream.readBoolean()) {
                final int int2 = objectInputStream.readInt();
                final Object[] array = new Object[int2];
                this.data[i] = array;
                for (int j = 0; j < int2; ++j) {
                    array[j] = this.readSerializedData(objectInputStream);
                }
            }
        }
    }
    
    protected Object readSerializedData(final ObjectInputStream objectInputStream) {
        return objectInputStream.readObject();
    }
    
    public void clear() {
        this.rows = 0;
        this.columns = 0;
        for (int i = 0; i < this.data.length; ++i) {
            if (this.data[i] != null) {
                Arrays.fill(this.data[i], null);
            }
        }
    }
    
    protected void copyColumn(final int n, final int n2) {
        for (int i = 0; i < this.getRowCount(); ++i) {
            this.setObject(i, n2, this.getObject(i, n));
        }
    }
    
    protected void copyRow(final int n, final int n2) {
        this.ensureCapacity(n2, this.getColumnCount());
        final Object[] array = this.data[n];
        if (array == null) {
            final Object[] array2 = this.data[n2];
            if (array2 != null) {
                Arrays.fill(array2, null);
            }
        }
        else {
            this.data[n2] = array.clone();
        }
    }
    
    protected void setData(final Object[][] data, final int columns) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (columns < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.data = data;
        this.rows = data.length;
        this.columns = columns;
    }
    
    protected Object[][] getData() {
        return this.data;
    }
}
