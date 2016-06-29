/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.math.BigInteger;
import y.d.b.A;
import y.d.b.b;
import y.d.b.c;
import y.d.b.u;
import y.d.b.v;
import y.d.b.x;
import y.d.b.z;

public class n
extends x {
    private boolean i = true;
    private static final n j = new n();
    private static BigInteger k = BigInteger.valueOf(1);
    private static BigInteger l = BigInteger.valueOf(2);

    public static n f() {
        return j;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Object a(double var1_1, double var3_2) {
        var5_3 = new BigInteger[2];
        var6_4 = new BigInteger[2];
        n.a(var1_1, var5_3);
        n.a(var3_2, var6_4);
        if (!this.i) ** GOTO lbl-1000
        var7_5 = new A(var5_3[0]);
        var9_6 = new A(var5_3[1]);
        var8_7 = new A(var6_4[0]);
        var10_8 = new A(var6_4[1]);
        if (c.a != 0) lbl-1000: // 2 sources:
        {
            var7_5 = new v(var5_3[0]);
            var9_6 = new v(var5_3[1]);
            var8_7 = new v(var6_4[0]);
            var10_9 = new v(var6_4[1]);
        }
        var11_11 = var7_5.c((z)var10_10);
        var12_12 = var8_7.c(var9_6);
        var13_13 = var9_6.c((z)var10_10);
        var14_14 = new b(var11_11, var12_12, var13_13, this);
        var14_14.g();
        return var14_14;
    }

    private static void a(double d2, BigInteger[] arrbigInteger) {
        int n2 = c.a;
        long l2 = Double.doubleToLongBits(d2);
        int n3 = l2 >> 63 == 0 ? 1 : -1;
        int n4 = (int)(l2 >> 52 & 2047);
        long l3 = n4 == 0 ? (l2 & 0xFFFFFFFFFFFFFL) << 1 : l2 & 0xFFFFFFFFFFFFFL | 0x10000000000000L;
        int n5 = n4 - 1075;
        arrbigInteger[0] = BigInteger.valueOf((long)n3 * l3);
        if (n5 == 0) {
            arrbigInteger[1] = k;
            if (n2 == 0) return;
        }
        if (n5 > 0) {
            arrbigInteger[0] = arrbigInteger[0].multiply(l.pow(n5));
            arrbigInteger[1] = k;
            if (n2 == 0) return;
        }
        n5 = - n5;
        arrbigInteger[1] = l.pow(n5);
    }
}

