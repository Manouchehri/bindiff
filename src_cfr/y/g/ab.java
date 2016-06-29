/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.awt.geom.Rectangle2D;
import java.beans.Beans;
import java.io.IOException;
import java.util.StringTokenizer;
import y.g.X;
import y.g.a;

final class ab
extends a {
    ab() {
        Class class_ = X.n == null ? (X.n = X.a("java.awt.geom.Rectangle2D")) : X.n;
        super(class_);
    }

    @Override
    protected Object a(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, "(,)", false);
        try {
            String string2 = stringTokenizer.nextToken();
            Rectangle2D rectangle2D = (Rectangle2D)Beans.instantiate(this.getClass().getClassLoader(), string2);
            double d2 = Double.parseDouble(stringTokenizer.nextToken());
            double d3 = Double.parseDouble(stringTokenizer.nextToken());
            double d4 = Double.parseDouble(stringTokenizer.nextToken());
            double d5 = Double.parseDouble(stringTokenizer.nextToken());
            rectangle2D.setFrame(d2, d3, d4, d5);
            return rectangle2D;
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
        Rectangle2D rectangle2D = (Rectangle2D)object;
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append(rectangle2D.getClass().getName());
        stringBuffer.append('(');
        stringBuffer.append(rectangle2D.getX());
        stringBuffer.append(',');
        stringBuffer.append(rectangle2D.getY());
        stringBuffer.append(',');
        stringBuffer.append(rectangle2D.getWidth());
        stringBuffer.append(',');
        stringBuffer.append(rectangle2D.getHeight());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

