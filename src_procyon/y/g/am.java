package y.g;

import java.io.*;

public final class am implements Serializable
{
    public final Object a;
    public final Object b;
    
    public am(final Object a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public final boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof am) {
            final am am = (am)o;
            if (this.a != null) {
                if (!this.a.equals(am.a)) {
                    return false;
                }
            }
            else if (am.a != null) {
                return false;
            }
            if ((this.b == null) ? (am.b == null) : this.b.equals(am.b)) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public final int hashCode() {
        if (this.a != null) {
            if (this.b != null) {
                return this.a.hashCode() ^ this.b.hashCode() >>> 1;
            }
            return this.a.hashCode();
        }
        else {
            if (this.b != null) {
                return this.b.hashCode() >>> 1;
            }
            return 666;
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(50);
        sb.append('[');
        sb.append(this.a);
        sb.append(':');
        sb.append(this.b);
        sb.append(']');
        return sb.toString();
    }
    
    public static final Object a(final Object o, final Object o2) {
        return new am(o, o2);
    }
    
    public static final Object a(final Object o, final Object o2, final Object o3) {
        return new am(o, new am(o2, o3));
    }
    
    public static final Object a(final Object o, final Object o2, final Object o3, final Object o4) {
        return new am(o, new am(o2, new am(o3, o4)));
    }
}
