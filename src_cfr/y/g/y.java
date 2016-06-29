/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.awt.geom.Point2D;
import java.beans.Beans;
import java.io.IOException;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;

final class Y
extends a {
    Y() {
        Class class_ = X.o == null ? (X.o = X.a("java.awt.geom.Point2D")) : X.o;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, "(,)", false);
        try {
            String string2 = stringTokenizer.nextToken();
            Point2D point2D = (Point2D)Beans.instantiate(this.getClass().getClassLoader(), string2);
            double d2 = Double.parseDouble(stringTokenizer.nextToken());
            double d3 = Double.parseDouble(stringTokenizer.nextToken());
            point2D.setLocation(d2, d3);
            return point2D;
        }
        catch (NumberFormatException var3_4) {
            throw new IllegalArgumentException(new StringBuffer().append("Could not parse number ").append(string).toString());
        }
        catch (ClassNotFoundException var3_5) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown class ").append(var3_5).toString());
        }
        catch (IOException var3_6) {
            throw new IllegalArgumentException(new StringBuffer().append("Could not load class ").append(var3_6).toString());
        }
    }

    @Override
    protected String a(Object object) {
        Point2D point2D = (Point2D)object;
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append(point2D.getClass().getName());
        stringBuffer.append('(');
        stringBuffer.append(point2D.getX());
        stringBuffer.append(',');
        stringBuffer.append(point2D.getY());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

