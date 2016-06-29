package y.h;

import java.awt.*;
import java.io.*;
import y.e.*;
import java.util.*;

public class dr extends BasicStroke
{
    private static dr[][] w;
    private byte x;
    private static Map y;
    public static final dr a;
    public static final dr b;
    public static final dr c;
    public static final dr d;
    public static final dr e;
    public static final dr f;
    public static final dr g;
    public static final dr h;
    public static final dr i;
    public static final dr j;
    public static final dr k;
    public static final dr l;
    public static final dr m;
    public static final dr n;
    public static final dr o;
    public static final dr p;
    public static final dr q;
    public static final dr r;
    public static final dr s;
    public static final dr t;
    public static final dr u;
    public static final dr v;
    
    private dr(final float n) {
        super(n, 0, 0, 1.45f);
        this.x = 0;
    }
    
    private dr(final float n, final int n2, final int n3, final float n4, final float[] array, final float n5, final byte x) {
        super(n, n2, n3, n4, array, n5);
        this.x = x;
    }
    
    public static dr a(final float n, final int n2, final int n3, final float n4, final float[] array, final float n5) {
        final dr dr = new dr(n, n2, n3, n4, array, n5, (byte)127);
        synchronized (y.h.dr.y) {
            final dr dr2 = y.h.dr.y.get(dr);
            if (dr2 != null) {
                return dr2;
            }
            y.h.dr.y.put(dr, dr);
            return dr;
        }
    }
    
    public int hashCode() {
        return (int)((5 + this.x) * this.getLineWidth());
    }
    
    public boolean equals(final Object o) {
        final boolean z = fj.z;
        if (o == this) {
            return true;
        }
        if (!(o instanceof dr)) {
            return false;
        }
        final dr dr = (dr)o;
        final float[] dashArray = dr.getDashArray();
        final float[] dashArray2 = this.getDashArray();
        if (dashArray == null ^ dashArray2 == null) {
            return false;
        }
        float n = 0.0f;
        if (dashArray2 != null) {
            if (dashArray.length != dashArray2.length) {
                return false;
            }
            int i = 0;
            while (i < dashArray2.length) {
                n = fcmpl(dashArray[i], dashArray2[i]);
                if (z) {
                    return n == 0 && dr.getEndCap() == this.getEndCap() && dr.getLineJoin() == this.getLineJoin() && dr.getLineWidth() == this.getLineWidth() && dr.getMiterLimit() == this.getMiterLimit() && dr.a() == this.a();
                }
                if (n != 0) {
                    return false;
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
        final float n2 = fcmpl(dr.getDashPhase(), this.getDashPhase());
        return n == 0 && dr.getEndCap() == this.getEndCap() && dr.getLineJoin() == this.getLineJoin() && dr.getLineWidth() == this.getLineWidth() && dr.getMiterLimit() == this.getMiterLimit() && dr.a() == this.a();
    }
    
    public static dr a(int length, final byte b) {
        if (length <= 0) {
            length = 1;
            if (!fj.z) {
                return dr.w[b][length - 1];
            }
        }
        if (length > dr.w[b].length) {
            length = dr.w[b].length;
        }
        return dr.w[b][length - 1];
    }
    
    public byte a() {
        return this.x;
    }
    
    public static void a(final ObjectOutput objectOutput, final dr dr) {
        final boolean z = fj.z;
        if (dr == null) {
            objectOutput.writeByte(1);
            if (!z) {
                return;
            }
        }
        objectOutput.writeByte(0);
        final byte a = dr.a();
        objectOutput.writeByte(a);
        if (a != 127) {
            objectOutput.writeByte((byte)dr.getLineWidth());
            if (!z) {
                return;
            }
        }
        final float[] dashArray = dr.getDashArray();
        Label_0165: {
            Label_0125: {
                if (dashArray == null) {
                    objectOutput.writeInt(0);
                    if (!z) {
                        break Label_0125;
                    }
                }
                objectOutput.writeInt(dashArray.length);
                int i = 0;
                while (i < dashArray.length) {
                    objectOutput.writeFloat(dashArray[i]);
                    ++i;
                    if (z) {
                        break Label_0165;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            objectOutput.writeFloat(dr.getLineWidth());
            objectOutput.writeInt(dr.getEndCap());
            objectOutput.writeInt(dr.getLineJoin());
            objectOutput.writeFloat(dr.getMiterLimit());
        }
        objectOutput.writeFloat(dr.getDashPhase());
    }
    
    public static dr a(final ObjectInput objectInput) {
        final boolean z = fj.z;
        switch (objectInput.readByte()) {
            case 0: {
                final byte byte1 = objectInput.readByte();
                if (byte1 != 127) {
                    return a(objectInput.readByte(), byte1);
                }
                final int int1 = objectInput.readInt();
                float[] array = null;
                if (int1 > 0) {
                    array = new float[int1];
                    int i = 0;
                    while (i < int1) {
                        array[i] = objectInput.readFloat();
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                }
                return a(objectInput.readFloat(), objectInput.readInt(), objectInput.readInt(), objectInput.readFloat(), array, objectInput.readFloat());
            }
            case 1: {
                return null;
            }
            default: {
                throw new a();
            }
        }
    }
    
    static {
        dr.y = new HashMap(11);
        a = new dr(1.0f);
        b = new dr(2.0f);
        c = new dr(3.0f);
        d = new dr(4.0f);
        e = new dr(5.0f);
        f = new dr(6.0f);
        g = new dr(7.0f);
        h = new dr(1.0f, 0, 0, 1.45f, new float[] { 6.0f, 2.0f }, 0.0f, (byte)1);
        i = new dr(2.0f, 0, 0, 1.45f, new float[] { 12.0f, 4.0f }, 0.0f, (byte)1);
        j = new dr(3.0f, 0, 0, 1.45f, new float[] { 18.0f, 6.0f }, 0.0f, (byte)1);
        k = new dr(4.0f, 0, 0, 1.45f, new float[] { 24.0f, 8.0f }, 0.0f, (byte)1);
        l = new dr(5.0f, 0, 0, 1.45f, new float[] { 30.0f, 10.0f }, 0.0f, (byte)1);
        m = new dr(1.0f, 1, 0, 1.45f, new float[] { 0.0f, 4.0f }, 2.0f, (byte)2);
        n = new dr(2.0f, 1, 0, 1.45f, new float[] { 0.0f, 8.0f }, 2.0f, (byte)2);
        o = new dr(3.0f, 1, 0, 1.45f, new float[] { 0.0f, 12.0f }, 2.0f, (byte)2);
        p = new dr(4.0f, 1, 0, 1.45f, new float[] { 0.0f, 16.0f }, 2.0f, (byte)2);
        q = new dr(5.0f, 1, 0, 1.45f, new float[] { 0.0f, 20.0f }, 2.0f, (byte)2);
        r = new dr(1.0f, 1, 0, 1.45f, new float[] { 4.0f, 3.0f, 0.0f, 3.0f }, 0.0f, (byte)3);
        s = new dr(2.0f, 1, 0, 1.45f, new float[] { 8.0f, 6.0f, 0.0f, 6.0f }, 0.0f, (byte)3);
        t = new dr(3.0f, 1, 0, 1.45f, new float[] { 12.0f, 9.0f, 0.0f, 9.0f }, 0.0f, (byte)3);
        u = new dr(4.0f, 1, 0, 1.45f, new float[] { 16.0f, 12.0f, 0.0f, 12.0f }, 0.0f, (byte)3);
        v = new dr(5.0f, 1, 0, 1.45f, new float[] { 20.0f, 15.0f, 0.0f, 15.0f }, 0.0f, (byte)3);
        (dr.w = new dr[4][])[0] = new dr[7];
        dr.w[1] = new dr[5];
        dr.w[2] = new dr[5];
        dr.w[3] = new dr[5];
        dr.w[0][0] = dr.a;
        dr.w[0][1] = dr.b;
        dr.w[0][2] = dr.c;
        dr.w[0][3] = dr.d;
        dr.w[0][4] = dr.e;
        dr.w[0][5] = dr.f;
        dr.w[0][6] = dr.g;
        dr.w[1][0] = dr.h;
        dr.w[1][1] = dr.i;
        dr.w[1][2] = dr.j;
        dr.w[1][3] = dr.k;
        dr.w[1][4] = dr.l;
        dr.w[2][0] = dr.m;
        dr.w[2][1] = dr.n;
        dr.w[2][2] = dr.o;
        dr.w[2][3] = dr.p;
        dr.w[2][4] = dr.q;
        dr.w[3][0] = dr.r;
        dr.w[3][1] = dr.s;
        dr.w[3][2] = dr.t;
        dr.w[3][3] = dr.u;
        dr.w[3][4] = dr.v;
    }
}
