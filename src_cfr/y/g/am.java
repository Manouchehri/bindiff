/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.io.Serializable;

public final class am
implements Serializable {
    public final Object a;
    public final Object b;

    public am(Object object, Object object2) {
        this.a = object;
        this.b = object2;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof am)) return false;
        am am2 = (am)object;
        if (this.a != null) {
            if (!this.a.equals(am2.a)) return false;
        } else if (am2.a != null) return false;
        if (this.b != null) {
            if (!this.b.equals(am2.b)) return false;
            return true;
        } else if (am2.b != null) return false;
        return true;
    }

    public final int hashCode() {
        if (this.a != null) {
            if (this.b == null) return this.a.hashCode();
            return this.a.hashCode() ^ this.b.hashCode() >>> 1;
        }
        if (this.b == null) return 666;
        return this.b.hashCode() >>> 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append('[');
        stringBuffer.append(this.a);
        stringBuffer.append(':');
        stringBuffer.append(this.b);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public static final Object a(Object object, Object object2) {
        return new am(object, object2);
    }

    public static final Object a(Object object, Object object2, Object object3) {
        return new am(object, new am(object2, object3));
    }

    public static final Object a(Object object, Object object2, Object object3, Object object4) {
        return new am(object, new am(object2, new am(object3, object4)));
    }
}

