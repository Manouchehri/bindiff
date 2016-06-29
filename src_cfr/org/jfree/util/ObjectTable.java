/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import org.jfree.util.ObjectUtilities;

public class ObjectTable
implements Serializable {
    private static final long serialVersionUID = -3968322452944912066L;
    private int rows;
    private int columns;
    private transient Object[][] data;
    private int rowIncrement;
    private int columnIncrement;

    public ObjectTable() {
        this(5, 5);
    }

    public ObjectTable(int n2) {
        this(n2, n2);
    }

    public ObjectTable(int n2, int n3) {
        if (n2 < 1) {
            throw new IllegalArgumentException("Increment must be positive.");
        }
        if (n3 < 1) {
            throw new IllegalArgumentException("Increment must be positive.");
        }
        this.rows = 0;
        this.columns = 0;
        this.rowIncrement = n2;
        this.columnIncrement = n3;
        this.data = new Object[n2][];
    }

    public int getColumnIncrement() {
        return this.columnIncrement;
    }

    public int getRowIncrement() {
        return this.rowIncrement;
    }

    protected void ensureRowCapacity(int n2) {
        if (n2 < this.data.length) return;
        Object[][] arrarrobject = new Object[n2 + this.rowIncrement][];
        System.arraycopy(this.data, 0, arrarrobject, 0, this.data.length);
        this.data = arrarrobject;
    }

    public void ensureCapacity(int n2, int n3) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Row is invalid. ").append(n2).toString());
        }
        if (n3 < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Column is invalid. ").append(n3).toString());
        }
        this.ensureRowCapacity(n2);
        Object[] arrobject = this.data[n2];
        if (arrobject == null) {
            Object[] arrobject2;
            this.data[n2] = arrobject2 = new Object[Math.max(n3 + 1, this.columnIncrement)];
            return;
        }
        if (n3 < arrobject.length) return;
        Object[] arrobject3 = new Object[n3 + this.columnIncrement];
        System.arraycopy(arrobject, 0, arrobject3, 0, arrobject.length);
        this.data[n2] = arrobject3;
    }

    public int getRowCount() {
        return this.rows;
    }

    public int getColumnCount() {
        return this.columns;
    }

    protected Object getObject(int n2, int n3) {
        if (n2 >= this.data.length) return null;
        Object[] arrobject = this.data[n2];
        if (arrobject == null) {
            return null;
        }
        if (n3 >= arrobject.length) return null;
        return arrobject[n3];
    }

    protected void setObject(int n2, int n3, Object object) {
        this.ensureCapacity(n2, n3);
        this.data[n2][n3] = object;
        this.rows = Math.max(this.rows, n2 + 1);
        this.columns = Math.max(this.columns, n3 + 1);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof ObjectTable)) {
            return false;
        }
        ObjectTable objectTable = (ObjectTable)object;
        if (this.getRowCount() != objectTable.getRowCount()) {
            return false;
        }
        if (this.getColumnCount() != objectTable.getColumnCount()) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.getRowCount()) {
            for (int i2 = 0; i2 < this.getColumnCount(); ++i2) {
                if (ObjectUtilities.equal(this.getObject(n2, i2), objectTable.getObject(n2, i2))) continue;
                return false;
            }
            ++n2;
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.rows;
        return 29 * n2 + this.columns;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n2 = this.data.length;
        objectOutputStream.writeInt(n2);
        int n3 = 0;
        while (n3 < n2) {
            Object[] arrobject = this.data[n3];
            objectOutputStream.writeBoolean(arrobject != null);
            if (arrobject != null) {
                int n4 = arrobject.length;
                objectOutputStream.writeInt(n4);
                for (int i2 = 0; i2 < n4; ++i2) {
                    this.writeSerializedData(objectOutputStream, arrobject[i2]);
                }
            }
            ++n3;
        }
    }

    protected void writeSerializedData(ObjectOutputStream objectOutputStream, Object object) {
        objectOutputStream.writeObject(object);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        this.data = new Object[n2][];
        int n3 = 0;
        while (n3 < n2) {
            boolean bl2 = objectInputStream.readBoolean();
            if (bl2) {
                Object[] arrobject;
                int n4 = objectInputStream.readInt();
                this.data[n3] = arrobject = new Object[n4];
                for (int i2 = 0; i2 < n4; ++i2) {
                    arrobject[i2] = this.readSerializedData(objectInputStream);
                }
            }
            ++n3;
        }
    }

    protected Object readSerializedData(ObjectInputStream objectInputStream) {
        return objectInputStream.readObject();
    }

    public void clear() {
        this.rows = 0;
        this.columns = 0;
        int n2 = 0;
        while (n2 < this.data.length) {
            if (this.data[n2] != null) {
                Arrays.fill(this.data[n2], null);
            }
            ++n2;
        }
    }

    protected void copyColumn(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.getRowCount()) {
            this.setObject(n4, n3, this.getObject(n4, n2));
            ++n4;
        }
    }

    protected void copyRow(int n2, int n3) {
        this.ensureCapacity(n3, this.getColumnCount());
        Object[] arrobject = this.data[n2];
        if (arrobject == null) {
            Object[] arrobject2 = this.data[n3];
            if (arrobject2 == null) return;
            Arrays.fill(arrobject2, null);
            return;
        }
        this.data[n3] = (Object[])arrobject.clone();
    }

    protected void setData(Object[][] arrobject, int n2) {
        if (arrobject == null) {
            throw new NullPointerException();
        }
        if (n2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.data = arrobject;
        this.rows = arrobject.length;
        this.columns = n2;
    }

    protected Object[][] getData() {
        return this.data;
    }
}

