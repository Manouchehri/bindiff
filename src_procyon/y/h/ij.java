package y.h;

import y.c.*;
import y.d.*;
import java.awt.geom.*;

class ij
{
    public static byte a(final aB ab, final GeneralPath generalPath, final GeneralPath generalPath2, final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        byte b = 0;
        float lineWidth = ab.getLineType().getLineWidth();
        if (lineWidth != 1.0) {
            lineWidth = 1.0f + (lineWidth - 1.0f) / 8.0f;
        }
        final PathIterator pathIterator = generalPath.getPathIterator(null, 0.5);
        final fj sourceRealizer = ab.getSourceRealizer();
        final fj targetRealizer = ab.getTargetRealizer();
        final eU b2 = sourceRealizer.b(ab.vb);
        final eU b3 = targetRealizer.b(ab.zb);
        boolean b4 = false;
        Label_0130: {
            if (b2 != null) {
                b4 = (t.a(eU.b(b2), ab.getSourcePoint()) < 1.0E-12);
                if (!z) {
                    break Label_0130;
                }
            }
            b4 = false;
        }
        boolean b5 = false;
        Label_0180: {
            if (b3 != null) {
                b5 = (t.a(eU.b(b3), ab.getTargetPoint()) < 1.0E-12);
                if (!z) {
                    break Label_0180;
                }
            }
            b5 = false;
        }
        final t a = a(b4, b4 ? b2 : ab.getSourcePort(), sourceRealizer);
        float n = (float)a.a();
        float n2 = (float)a.b();
        final float[] array = new float[2];
        if (!pathIterator.isDone()) {
            pathIterator.currentSegment(array);
            n = array[0];
            n2 = array[1];
        }
        final Point2D.Double double1 = new Point2D.Double();
        final int n3 = b4 ? 1 : 3;
        final fj fj = (fj)(b4 ? b2 : sourceRealizer);
        while (true) {
        Label_0654_Outer:
            while (!pathIterator.isDone()) {
                pathIterator.currentSegment(array);
                pathIterator.next();
                final int a2 = a(b4, fj, array[0], array[1]) ? 1 : 0;
                if (z) {
                    float[] array2 = new float[a2];
                    int n4 = 0;
                    Label_0503: {
                        if (a((byte)n3, fj, sourceRealizer, n, n2, array[0], array[1], double1)) {
                            array2[n4++] = (float)double1.getX();
                            array2[n4++] = (float)double1.getY();
                            point2D.setLocation(double1);
                            array2[n4++] = array[0];
                            array2[n4++] = array[1];
                            if (!z) {
                                break Label_0503;
                            }
                        }
                        array2[n4++] = array[0];
                        array2[n4++] = array[1];
                        point2D.setLocation(array[0], array[1]);
                    }
                    final t a3 = a(b5, b5 ? b3 : ab.getTargetPort(), targetRealizer);
                    array[0] = (float)a3.a();
                    array[1] = (float)a3.b();
                    while (true) {
                        while (!pathIterator.isDone()) {
                            pathIterator.currentSegment(array);
                            pathIterator.next();
                            final int n5 = n4;
                            if (z) {
                                final int n6 = (n5 != 0) ? 1 : 3;
                                final fj fj2 = (fj)(b5 ? b3 : targetRealizer);
                                int i = n4;
                                while (true) {
                                    while (i > 1) {
                                        array[1] = array2[--i];
                                        array[0] = array2[--i];
                                        final int a4;
                                        final int n7 = a4 = (a(b5, fj2, array[0], array[1]) ? 1 : 0);
                                        if (!z) {
                                            if (n7 == 0) {
                                                if (a((byte)n6, fj2, targetRealizer, n, n2, array[0], array[1], double1)) {
                                                    if (++i + 2 > array2.length) {
                                                        final float[] array3 = new float[i + 4];
                                                        System.arraycopy(array2, 0, array3, 0, array2.length);
                                                        array2 = array3;
                                                    }
                                                    array2[++i] = (float)double1.x;
                                                    array2[++i] = (float)double1.y;
                                                    point2D2.setLocation(double1);
                                                    if (!z) {
                                                        break;
                                                    }
                                                }
                                                ++i;
                                                point2D2.setLocation(n, n2);
                                                if (!z) {
                                                    break;
                                                }
                                            }
                                            n = array[0];
                                            n2 = array[1];
                                            if (z) {
                                                break;
                                            }
                                            continue Label_0654_Outer;
                                        }
                                        else {
                                            int j = a4;
                                            int n8 = i - 1;
                                            if (j >= n8) {
                                                goto Label_1064;
                                            }
                                            final float n9 = (float)ab.getSourceArrow().d();
                                            if (n9 <= 0.0f) {
                                                goto Label_1064;
                                            }
                                            float n10 = 0.0f;
                                            float n11 = 0.0f;
                                            Label_1066: {
                                                while (j < n8) {
                                                    n11 = fcmpg(n10, n9);
                                                    if (z || n11 >= 0) {
                                                        break Label_1066;
                                                    }
                                                    final float n12 = array2[j + 2] - array2[j];
                                                    final float n13 = array2[j + 3] - array2[j + 1];
                                                    final float n14 = (float)Math.sqrt(n12 * n12 + n13 * n13);
                                                    n10 += n14;
                                                    if (n10 > n9) {
                                                        array2[j] = array2[j + 2] - (n10 - n9) * n12 / n14;
                                                        array2[j + 1] = array2[j + 3] - (n10 - n9) * n13 / n14;
                                                        if (!z) {
                                                            goto Label_1064;
                                                        }
                                                    }
                                                    j += 2;
                                                    if (z) {
                                                        goto Label_1064;
                                                    }
                                                }
                                                goto Label_1064;
                                            }
                                            if (n11 >= n8) {
                                                goto Label_1239;
                                            }
                                            final float n15 = (float)ab.getTargetArrow().d();
                                            if (n15 > 0.0f) {
                                                float n16 = 0.0f;
                                                float n17 = 0.0f;
                                                Label_1241: {
                                                    while (j < n8) {
                                                        n17 = fcmpg(n16, n15);
                                                        if (z || n17 >= 0) {
                                                            break Label_1241;
                                                        }
                                                        final float n18 = array2[n8 - 2] - array2[n8];
                                                        final float n19 = array2[n8 - 1] - array2[n8 + 1];
                                                        final float n20 = (float)Math.sqrt(n18 * n18 + n19 * n19);
                                                        n16 += n20;
                                                        if (n16 > n15) {
                                                            array2[n8] = array2[n8 - 2] - (n16 - n15) * n18 / n20;
                                                            array2[n8 + 1] = array2[n8 - 1] - (n16 - n15) * n19 / n20;
                                                            if (!z) {
                                                                goto Label_1239;
                                                            }
                                                        }
                                                        n8 -= 2;
                                                        if (z) {
                                                            goto Label_1239;
                                                        }
                                                    }
                                                    goto Label_1239;
                                                }
                                                float n30 = 0.0f;
                                                if (n17 < n8) {
                                                    final float n21 = (float)ab.getSourceArrow().c() * lineWidth;
                                                    if (n21 > 0.0f) {
                                                        final float n22 = array2[j];
                                                        final float n23 = array2[j + 1];
                                                        final float n24 = n21 * n21;
                                                        while (j < n8) {
                                                            final float n25 = array2[j] - n22;
                                                            final float n26 = array2[j + 1] - n23;
                                                            final float n27 = n25 * n25 + n26 * n26;
                                                            final float n28 = array2[j + 2] - n22;
                                                            final float n29 = array2[j + 3] - n23;
                                                            n30 = fcmpl(n28 * n28 + n29 * n29, n24);
                                                            if (z) {
                                                                break;
                                                            }
                                                            if (n30 >= 0) {
                                                                final float n31 = array2[j + 2] - array2[j];
                                                                final float n32 = array2[j + 3] - array2[j + 1];
                                                                final float n33 = n31 * n31 + n32 * n32;
                                                                final float n34 = 2.0f * (n25 * n31 + n26 * n32);
                                                                final float n35 = n34 * n34 - 4.0f * n33 * (n25 * n25 + n26 * n26 - n24);
                                                                if (n35 >= 0.0f) {
                                                                    final float n36 = (-n34 + (float)Math.sqrt(n35)) / (2.0f * n33);
                                                                    if (n36 >= 0.0f && n36 <= 1.0f) {
                                                                        final float[] array4 = array2;
                                                                        final int n37 = j;
                                                                        array4[n37] += n31 * n36;
                                                                        final float[] array5 = array2;
                                                                        final int n38 = j + 1;
                                                                        array5[n38] += n32 * n36;
                                                                        if (n27 > 0.0f && j >= 2) {
                                                                            final float n39 = (float)Math.sqrt(n27);
                                                                            array2[j - 2] = array2[j] - n25 * 0.1f / n39;
                                                                            array2[j - 1] = array2[j + 1] - n26 * 0.1f / n39;
                                                                            j -= 2;
                                                                        }
                                                                    }
                                                                }
                                                                b |= 0x4;
                                                                if (!z) {
                                                                    break;
                                                                }
                                                            }
                                                            j += 2;
                                                            if (z) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                float n49 = 0.0f;
                                                Label_2038: {
                                                    if (n30 < n8) {
                                                        final float n40 = (float)ab.getTargetArrow().c() * lineWidth;
                                                        if (n40 > 0.0f) {
                                                            final float n41 = array2[n8];
                                                            final float n42 = array2[n8 + 1];
                                                            final float n43 = n40 * n40;
                                                            while (j < n8) {
                                                                final float n44 = array2[n8] - n41;
                                                                final float n45 = array2[n8 + 1] - n42;
                                                                final float n46 = n44 * n44 + n45 * n45;
                                                                final float n47 = array2[n8 - 2] - n41;
                                                                final float n48 = array2[n8 - 1] - n42;
                                                                n49 = fcmpl(n47 * n47 + n48 * n48, n43);
                                                                if (z) {
                                                                    break Label_2038;
                                                                }
                                                                if (n49 >= 0) {
                                                                    final float n50 = array2[n8 - 2] - array2[n8];
                                                                    final float n51 = array2[n8 - 1] - array2[n8 + 1];
                                                                    final float n52 = n50 * n50 + n51 * n51;
                                                                    final float n53 = 2.0f * (n44 * n50 + n45 * n51);
                                                                    final float n54 = n53 * n53 - 4.0f * n52 * (n44 * n44 + n45 * n45 - n43);
                                                                    if (n54 >= 0.0f) {
                                                                        final float n55 = (-n53 + (float)Math.sqrt(n54)) / (2.0f * n52);
                                                                        if (n55 >= 0.0f && n55 <= 1.0f) {
                                                                            final float[] array6 = array2;
                                                                            final int n56 = n8;
                                                                            array6[n56] += n50 * n55;
                                                                            final float[] array7 = array2;
                                                                            final int n57 = n8 + 1;
                                                                            array7[n57] += n51 * n55;
                                                                            if (n46 > 0.0f && n8 < array2.length + 3) {
                                                                                final float n58 = (float)Math.sqrt(n46);
                                                                                array2[n8 + 2] = array2[n8] - n44 * 0.1f / n58;
                                                                                array2[n8 + 3] = array2[n8 + 1] - n45 * 0.1f / n58;
                                                                                n8 += 2;
                                                                            }
                                                                        }
                                                                    }
                                                                    b |= 0x8;
                                                                    if (!z) {
                                                                        break;
                                                                    }
                                                                }
                                                                n8 -= 2;
                                                                if (z) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    generalPath2.reset();
                                                }
                                                if (n49 < n8) {
                                                    generalPath2.moveTo(array2[j++], array2[j++]);
                                                    int k = j;
                                                    while (k <= n8) {
                                                        generalPath2.lineTo(array2[k++], array2[k++]);
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                return b;
                                            }
                                            goto Label_1239;
                                        }
                                    }
                                    int a4 = 0;
                                    continue;
                                }
                            }
                            if (n5 == array2.length) {
                                final float[] array8 = new float[array2.length * 2];
                                System.arraycopy(array2, 0, array8, 0, array2.length);
                                array2 = array8;
                            }
                            array2[n4++] = array[0];
                            array2[n4++] = array[1];
                            if (z) {
                                break;
                            }
                        }
                        n = array[0];
                        n2 = array[1];
                        continue;
                    }
                }
                if (a2 == 0) {
                    break;
                }
                n = array[0];
                n2 = array[1];
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    public static byte a(final aB ab, final GeneralPath generalPath, final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        byte b = 0;
        final z bends = ab.bends;
        final Point2D.Double i;
        final Point2D.Double double2;
        final Point2D.Double double1 = double2 = (i = hC.a().i);
        final double n = 0.0;
        double2.y = n;
        i.x = n;
        final fj sourceRealizer = ab.getSourceRealizer();
        final fj targetRealizer = ab.getTargetRealizer();
        final fL sourcePort = ab.getSourcePort();
        final fL targetPort = ab.getTargetPort();
        boolean a = false;
        generalPath.reset();
        final eU b2 = sourceRealizer.b(ab.vb);
        final eU b3 = targetRealizer.b(ab.zb);
        boolean b4 = false;
        Label_0137: {
            if (b2 != null) {
                b4 = (t.a(eU.b(b2), ab.getSourcePoint()) < 1.0E-12);
                if (!z) {
                    break Label_0137;
                }
            }
            b4 = false;
        }
        boolean b5 = false;
        Label_0187: {
            if (b3 != null) {
                b5 = (t.a(eU.b(b3), ab.getTargetPoint()) < 1.0E-12);
                if (!z) {
                    break Label_0187;
                }
            }
            b5 = false;
        }
        final fL fl = (fL)(b4 ? b2 : sourcePort);
        final fL fl2 = (fL)(b5 ? b3 : targetPort);
        int j = 0;
        final t a2 = a(b4, fl, sourceRealizer);
        double n2 = a2.a();
        double n3 = a2.b();
        final t a3 = a(b5, fl2, targetRealizer);
        double n4 = a3.a();
        double n5 = a3.b();
        p p4 = bends.k();
        Label_0477: {
            if (a(b4, b4 ? b2 : sourceRealizer, n2, n3)) {
                double b6 = n2;
                double c = n3;
                final int n6 = b4 ? 1 : 2;
                while (true) {
                    while (p4 != null) {
                        final x x = (x)p4.c();
                        final boolean a4;
                        a = (a4 = a((byte)n6, fl, sourceRealizer, b6, c, x.b(), x.c(), double1));
                        if (!z) {
                            if (a4) {
                                n2 = double1.x;
                                n3 = double1.y;
                                if (!z) {
                                    break;
                                }
                            }
                            b6 = x.b();
                            c = x.c();
                            p4 = p4.a();
                            ++j;
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (!a4 && p4 == null) {
                                a = a((byte)n6, fl, sourceRealizer, b6, c, n4, n5, double1);
                                if (a) {
                                    n2 = double1.x;
                                    n3 = double1.y;
                                }
                            }
                            if (!a) {
                                return b;
                            }
                            break Label_0477;
                        }
                    }
                    continue;
                }
            }
        }
        point2D.setLocation(n2, n3);
        int n7 = 0;
        int size = bends.size();
        p p5 = bends.l();
        Label_2002: {
            int n11 = 0;
            int n12 = 0;
            Label_1942: {
                if (a(b5, b5 ? b3 : targetRealizer, n4, n5)) {
                    double n8 = n4;
                    double n9 = n5;
                    final int n10 = b5 ? 1 : 2;
                    while (p5 != null) {
                        n11 = j;
                        n12 = size;
                        if (z) {
                            break Label_1942;
                        }
                        if (n11 == n12) {
                            n7 = (a((byte)n10, fl2, targetRealizer, n8, n9, n2, n3, double1) ? 1 : 0);
                            if (n7 != 0) {
                                n4 = double1.x;
                                n5 = double1.y;
                                if (!z) {
                                    break;
                                }
                            }
                            generalPath.reset();
                            return b;
                        }
                        final x x2 = (x)p5.c();
                        final double b7 = x2.b();
                        final double c2 = x2.c();
                        n7 = (a((byte)n10, fl2, targetRealizer, n8, n9, b7, c2, double1) ? 1 : 0);
                        if (n7 != 0) {
                            n4 = double1.x;
                            n5 = double1.y;
                            if (!z) {
                                break;
                            }
                        }
                        n8 = b7;
                        n9 = c2;
                        p5 = p5.b();
                        --size;
                        if (z) {
                            break;
                        }
                    }
                    if (n7 == 0) {
                        n7 = (a((byte)n10, fl2, targetRealizer, n8, n9, n2, n3, double1) ? 1 : 0);
                        if (n7 != 0) {
                            if (a(b4, b4 ? b2 : sourceRealizer, double1.x, double1.y)) {
                                n7 = 0;
                            }
                            n4 = double1.x;
                            n5 = double1.y;
                        }
                    }
                    if (n7 == 0) {
                        return b;
                    }
                }
                point2D2.setLocation(n4, n5);
                final double arrowScaleFactor = ab.getArrowScaleFactor();
                final double d = ab.getSourceArrow().d();
                Label_1226: {
                    if (d > 0.0) {
                        double b8 = 0.0;
                        double c3 = 0.0;
                        Label_0875: {
                            if (j == size) {
                                b8 = n4;
                                c3 = n5;
                                if (!z) {
                                    break Label_0875;
                                }
                            }
                            final x x3 = (x)p4.c();
                            b8 = x3.b();
                            c3 = x3.c();
                        }
                        final double n13 = b8 - n2;
                        final double n14 = c3 - n3;
                        final double sqrt = Math.sqrt(n13 * n13 + n14 * n14);
                        if (sqrt > d) {
                            final double n15 = d / sqrt;
                            n2 += n13 * n15;
                            n3 += n14 * n15;
                            if (!z) {
                                break Label_1226;
                            }
                        }
                        if (j >= size) {
                            return b;
                        }
                        if (j <= size) {
                            double b9 = n2;
                            double c4 = n3;
                            double n16 = 0.0;
                            double n17 = 0.0;
                            Label_1128: {
                                while (j < size) {
                                    n17 = dcmpg(n16, d);
                                    if (z || n17 >= 0) {
                                        break Label_1128;
                                    }
                                    final x x4 = (x)p4.c();
                                    final double n18 = x4.b() - b9;
                                    final double n19 = x4.c() - c4;
                                    final double sqrt2 = Math.sqrt(n18 * n18 + n19 * n19);
                                    n16 += sqrt2;
                                    if (n16 >= d) {
                                        n2 = x4.b() - n18 * (n16 - d) / sqrt2;
                                        n3 = x4.c() - n19 * (n16 - d) / sqrt2;
                                        if (!z) {
                                            goto Label_1126;
                                        }
                                    }
                                    b9 = x4.b();
                                    c4 = x4.c();
                                    p4 = p4.a();
                                    ++j;
                                    if (z) {
                                        goto Label_1126;
                                    }
                                }
                                goto Label_1126;
                            }
                            if (n17 == size && n16 < d) {
                                final double n20 = n4 - b9;
                                final double n21 = n5 - c4;
                                final double sqrt3 = Math.sqrt(n20 * n20 + n21 * n21);
                                final double n22 = n16 + sqrt3;
                                if (n22 >= d) {
                                    n2 = n4 - n20 * (n22 - d) / sqrt3;
                                    n3 = n5 - n21 * (n22 - d) / sqrt3;
                                    if (!z) {
                                        break Label_1226;
                                    }
                                }
                                return b;
                            }
                        }
                    }
                }
                final double d2 = ab.getTargetArrow().d();
                Label_1637: {
                    if (d2 > 0.0) {
                        double b10 = 0.0;
                        double c5 = 0.0;
                        Label_1286: {
                            if (j == size) {
                                b10 = n2;
                                c5 = n3;
                                if (!z) {
                                    break Label_1286;
                                }
                            }
                            final x x5 = (x)p5.c();
                            b10 = x5.b();
                            c5 = x5.c();
                        }
                        final double n23 = b10 - n4;
                        final double n24 = c5 - n5;
                        final double sqrt4 = Math.sqrt(n23 * n23 + n24 * n24);
                        if (sqrt4 > d2) {
                            final double n25 = d2 / sqrt4;
                            n4 += n23 * n25;
                            n5 += n24 * n25;
                            if (!z) {
                                break Label_1637;
                            }
                        }
                        if (j >= size) {
                            return b;
                        }
                        if (j != size) {
                            double b11 = n4;
                            double c6 = n5;
                            double n26 = 0.0;
                            double n27 = 0.0;
                            Label_1539: {
                                while (j < size) {
                                    n27 = dcmpg(n26, d2);
                                    if (z || n27 >= 0) {
                                        break Label_1539;
                                    }
                                    final x x6 = (x)p5.c();
                                    final double n28 = x6.b() - b11;
                                    final double n29 = x6.c() - c6;
                                    final double sqrt5 = Math.sqrt(n28 * n28 + n29 * n29);
                                    n26 += sqrt5;
                                    if (n26 >= d2) {
                                        n4 = x6.b() - n28 * (n26 - d2) / sqrt5;
                                        n5 = x6.c() - n29 * (n26 - d2) / sqrt5;
                                        if (!z) {
                                            goto Label_1537;
                                        }
                                    }
                                    b11 = x6.b();
                                    c6 = x6.c();
                                    --size;
                                    p5 = p5.b();
                                    if (z) {
                                        goto Label_1537;
                                    }
                                }
                                goto Label_1537;
                            }
                            if (n27 == size && n26 < d2) {
                                final double n30 = n2 - b11;
                                final double n31 = n3 - c6;
                                final double sqrt6 = Math.sqrt(n30 * n30 + n31 * n31);
                                final double n32 = n26 + sqrt6;
                                if (n32 >= d2) {
                                    n4 = n2 - (n32 - d2) * n30 / sqrt6;
                                    n5 = n3 - (n32 - d2) * n31 / sqrt6;
                                    if (!z) {
                                        break Label_1637;
                                    }
                                }
                                return b;
                            }
                        }
                    }
                }
                final double n33 = ab.getSourceArrow().c() * arrowScaleFactor;
                if (n33 > 0.0) {
                    final double n34 = n2;
                    final double n35 = n3;
                    double b12 = 0.0;
                    double c7 = 0.0;
                    Label_1706: {
                        if (p4 == null) {
                            b12 = n4;
                            c7 = n5;
                            if (!z) {
                                break Label_1706;
                            }
                        }
                        final x x7 = (x)p4.c();
                        b12 = x7.b();
                        c7 = x7.c();
                    }
                    final double n36 = b12 - n34;
                    final double n37 = c7 - n35;
                    final double sqrt7 = Math.sqrt(n36 * n36 + n37 * n37);
                    if (sqrt7 > n33) {
                        n2 += n36 * n33 / sqrt7;
                        n3 += n37 * n33 / sqrt7;
                        b |= 0x4;
                    }
                }
                final double n38 = ab.getTargetArrow().c() * arrowScaleFactor;
                if (n38 > 0.0) {
                    final double n39 = n4;
                    final double n40 = n5;
                    double b13 = 0.0;
                    double c8 = 0.0;
                    Label_1846: {
                        if (p5 == null) {
                            b13 = n2;
                            c8 = n3;
                            if (!z) {
                                break Label_1846;
                            }
                        }
                        final x x8 = (x)p5.c();
                        b13 = x8.b();
                        c8 = x8.c();
                    }
                    final double n41 = b13 - n39;
                    final double n42 = c8 - n40;
                    final double sqrt8 = Math.sqrt(n41 * n41 + n42 * n42);
                    if (sqrt8 > n38) {
                        n4 += n41 * n38 / sqrt8;
                        n5 += n42 * n38 / sqrt8;
                        b |= 0x8;
                    }
                }
                generalPath.moveTo((float)n2, (float)n3);
                if (p5 == null || p4 == null) {
                    break Label_2002;
                }
            }
            if (n11 < n12) {
                while (p4 != p5.a()) {
                    final x x9 = (x)p4.c();
                    generalPath.lineTo((float)x9.b(), (float)x9.c());
                    p4 = p4.a();
                    if (z) {
                        return b;
                    }
                    if (z) {
                        break;
                    }
                }
            }
        }
        generalPath.lineTo((float)n4, (float)n5);
        return b;
    }
    
    private static boolean a(final byte b, final Object o, final fj fj, final double n, final double n2, final double n3, final double n4, final Point2D.Double double1) {
        switch (b) {
            case 1: {
                return ((eU)o).a(n, n2, n3, n4, double1);
            }
            case 2: {
                return ((fL)o).a(fj, n, n2, n3, n4, double1);
            }
            case 3: {
                return ((fj)o).findIntersection(n, n2, n3, n4, double1);
            }
            default: {
                throw new IllegalArgumentException("Invalid type: " + b);
            }
        }
    }
    
    private static boolean a(final boolean b, final Object o, final double n, final double n2) {
        if (b) {
            return ((eU)o).a(n, n2);
        }
        return ((fj)o).contains(n, n2);
    }
    
    private static t a(final boolean b, final Object o, final fj fj) {
        if (b) {
            return ((eU)o).h();
        }
        final fL fl = (fL)o;
        return new t(fl.a(fj), fl.b(fj));
    }
    
    public static byte b(final aB ab, final GeneralPath generalPath, final Point2D point2D, final Point2D point2D2) {
        final boolean z = fj.z;
        final fj sourceRealizer = ab.getSourceRealizer();
        final x bend = ab.getBend(0);
        double n = 0.0;
        double n2 = 0.0;
        double a = 0.0;
        double b = 0.0;
        double n3 = 0.0;
        double angleExtent = 0.0;
        Label_0588: {
            if (sourceRealizer.b(ab.vb) != null || sourceRealizer.b(ab.zb) != null) {
                final fL sourcePort = ab.getSourcePort();
                final t t = new t(sourcePort.a(sourceRealizer), sourcePort.b(sourceRealizer));
                final fL targetPort = ab.getTargetPort();
                final t t2 = new t(targetPort.a(sourceRealizer), targetPort.b(sourceRealizer));
                final t t3 = new t(bend.b(), bend.c());
                if (e.d(t, t2, t3)) {
                    n = t.a();
                    n2 = t.b();
                    a = (t3.a() + n) * 0.5;
                    b = (t3.b() + n2) * 0.5;
                    n3 = Point2D.distance(a, b, n, n2);
                    angleExtent = 360.0;
                    final double n4 = t2.a() - n;
                    final double n5 = t2.b() - n2;
                    if (n4 * n4 + n5 * n5 > 1.0E-12) {
                        generalPath.reset();
                        generalPath.moveTo((float)n, (float)n2);
                        generalPath.lineTo((float)t3.a(), (float)t3.b());
                        generalPath.lineTo((float)t2.a(), (float)t2.b());
                        return a(ab, generalPath, generalPath, point2D, point2D2);
                    }
                    break Label_0588;
                }
                else {
                    final y.d.p p4 = new y.d.p(t, t2, t3);
                    final t a2 = p4.a();
                    a = a2.a();
                    b = a2.b();
                    n3 = p4.b();
                    n = t.a();
                    n2 = t.b();
                    final int a3 = e.a(t, t3, t2);
                    if (a3 == 0) {
                        angleExtent = 360.0;
                        if (!z) {
                            break Label_0588;
                        }
                    }
                    final int a4 = e.a(t, a2, t2);
                    double n6 = 0.0;
                    Label_0506: {
                        if (a4 == 0) {
                            n6 = 180.0;
                            if (!z) {
                                break Label_0506;
                            }
                        }
                        final double n7 = t.a() - a;
                        final double n8 = t.b() - b;
                        final double n9 = t2.a() - a;
                        final double n10 = t2.b() - b;
                        final double b2 = e.b(Math.acos((n7 * n9 + n8 * n10) / (Math.sqrt(n7 * n7 + n8 * n8) * Math.sqrt(n9 * n9 + n10 * n10))));
                        if (a4 == a3) {
                            n6 = 360.0 - b2;
                            if (!z) {
                                break Label_0506;
                            }
                        }
                        n6 = b2;
                    }
                    angleExtent = -a3 * n6;
                    if (!z) {
                        break Label_0588;
                    }
                }
            }
            n = ab.getSourcePort().a(sourceRealizer);
            n2 = ab.getSourcePort().b(sourceRealizer);
            a = (bend.b() + n) / 2.0;
            b = (bend.c() + n2) / 2.0;
            n3 = Point2D.distance(a, b, n, n2);
            angleExtent = 360.0;
        }
        final Arc2D.Float float1 = new Arc2D.Float(0);
        float1.setFrameFromCenter(a, b, a - n3, b - n3);
        float1.setAngleStart(new Point2D.Double(n, n2));
        float1.setAngleExtent(angleExtent);
        final PathIterator pathIterator = float1.getPathIterator(null, 0.20000000298023224);
        final GeneralPath generalPath2 = new GeneralPath(1, 2);
        generalPath2.append(pathIterator, false);
        final GeneralPath generalPath3;
        final byte a5 = a(ab, generalPath2, generalPath3 = new GeneralPath(1, ab.bendCount() + 4), point2D, point2D2);
        final PathIterator pathIterator2 = generalPath3.getPathIterator(null);
        generalPath.reset();
        generalPath.append(pathIterator2, false);
        return a5;
    }
    
    public static byte c(final aB ab, final GeneralPath generalPath, final Point2D point2D, final Point2D point2D2) {
        final byte a = a(ab, generalPath, point2D, point2D2);
        a(ab, generalPath);
        return a;
    }
    
    public static void a(final aB ab, final GeneralPath generalPath) {
        final boolean z = fj.z;
        if (ab.bendCount() > 0) {
            PathIterator pathIterator = generalPath.getPathIterator(null);
            if (pathIterator.isDone()) {
                return;
            }
            final GeneralPath generalPath2 = new GeneralPath(1, ab.bendCount() + 2);
            final float[] array = new float[2];
            final float[] array2 = new float[2];
            final float[] array3 = new float[2];
            final float[] array4 = new float[2];
            final float[] array5 = new float[2];
            pathIterator.currentSegment(array2);
            pathIterator.next();
            generalPath2.moveTo(array2[0], array2[1]);
            pathIterator.currentSegment(array3);
            pathIterator.next();
            a(array2, array3, array5);
            while (true) {
                while (!pathIterator.isDone()) {
                    pathIterator.currentSegment(array4);
                    pathIterator.next();
                    if (z) {
                        generalPath.append(pathIterator, false);
                        return;
                    }
                    if (array4[0] != array3[0] || array4[1] != array3[1]) {
                        array[0] = array2[0];
                        array[1] = array2[1];
                        array2[0] = array3[0];
                        array2[1] = array3[1];
                        array3[0] = array4[0];
                        array3[1] = array4[1];
                        if (e.a(array[0], array[1], array3[0], array3[1], array2[0], array2[1]) != 0) {
                            generalPath2.lineTo(array2[0] - array5[0], array2[1] - array5[1]);
                            a(array2, array3, array5);
                            generalPath2.quadTo(array2[0], array2[1], array2[0] + array5[0], array2[1] + array5[1]);
                            if (!z) {
                                continue;
                            }
                        }
                        a(array2, array3, array5);
                        if (!z) {
                            continue;
                        }
                    }
                    array5[1] = (array5[0] = 0.0f);
                    if (z) {
                        break;
                    }
                }
                generalPath2.lineTo(array3[0], array3[1]);
                generalPath.reset();
                pathIterator = generalPath2.getPathIterator(null, 1.0);
                continue;
            }
        }
    }
    
    private static void a(final float[] array, final float[] array2, final float[] array3) {
        array3[0] = array2[0] - array[0];
        array3[1] = array2[1] - array[1];
        final float n = (float)Math.sqrt(array3[0] * array3[0] + array3[1] * array3[1]);
        final float n2 = (n < 20.0f) ? 0.5f : (10.0f / n);
        array3[0] *= n2;
        array3[1] *= n2;
    }
    
    public static GeneralPath a(final GeneralPath generalPath) {
        final boolean z = fj.z;
        final PathIterator pathIterator = generalPath.getPathIterator(null, 0.1);
        float[] array = new float[60];
        int n = 0;
        final float[] array2 = new float[2];
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(array2);
            array[n++] = array2[0];
            array[n++] = array2[1];
            if (n == array.length) {
                final float[] array3 = new float[Math.min(array.length * 2, array.length + 300)];
                System.arraycopy(array, 0, array3, 0, array.length);
                array = array3;
            }
            pathIterator.next();
            if (z) {
                break;
            }
        }
        final GeneralPath generalPath2 = new GeneralPath(1, n / 2 + 5);
        generalPath2.moveTo(array2[0], array2[1]);
        int i = n - 3;
        GeneralPath generalPath3 = null;
        while (i >= 0) {
            final float[] array4 = array;
            final int n2 = i;
            final int n3 = n2 - 1;
            final float n4 = array4[n2];
            final float[] array5 = array;
            final int n5 = n3;
            i = n5 - 1;
            final float n6 = array5[n5];
            generalPath3 = generalPath2;
            if (z) {
                return generalPath3;
            }
            generalPath3.lineTo(n6, n4);
            if (z) {
                break;
            }
        }
        return generalPath3;
    }
}
