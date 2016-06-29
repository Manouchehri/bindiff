/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.jfree.util.Log;

public class PaintUtilities {
    static Class class$java$awt$Color;

    private PaintUtilities() {
    }

    public static boolean equal(Paint paint, Paint paint2) {
        if (paint == null) {
            if (paint2 != null) return false;
            return true;
        }
        if (paint2 == null) {
            return false;
        }
        boolean bl2 = false;
        if (!(paint instanceof GradientPaint)) return paint.equals(paint2);
        if (!(paint2 instanceof GradientPaint)) return paint.equals(paint2);
        GradientPaint gradientPaint = (GradientPaint)paint;
        GradientPaint gradientPaint2 = (GradientPaint)paint2;
        if (!gradientPaint.getColor1().equals(gradientPaint2.getColor1())) return false;
        if (!gradientPaint.getColor2().equals(gradientPaint2.getColor2())) return false;
        if (!gradientPaint.getPoint1().equals(gradientPaint2.getPoint1())) return false;
        if (!gradientPaint.getPoint2().equals(gradientPaint2.getPoint2())) return false;
        if (gradientPaint.isCyclic() != gradientPaint2.isCyclic()) return false;
        if (gradientPaint.getTransparency() != gradientPaint.getTransparency()) return false;
        return true;
    }

    public static String colorToString(Color color) {
        Object object;
        try {
            Class class_ = class$java$awt$Color == null ? (PaintUtilities.class$java$awt$Color = PaintUtilities.class$("java.awt.Color")) : class$java$awt$Color;
            object = class_.getFields();
            for (int i2 = 0; i2 < object.length; ++i2) {
                Object object2 = object[i2];
                if (!Modifier.isPublic(object2.getModifiers()) || !Modifier.isFinal(object2.getModifiers()) || !Modifier.isStatic(object2.getModifiers())) continue;
                String string = object2.getName();
                Object object3 = object2.get(null);
                if (!(object3 instanceof Color) || !color.equals(object3)) continue;
                return string;
            }
        }
        catch (Exception var1_2) {
            // empty catch block
        }
        object = Integer.toHexString(color.getRGB() & 16777215);
        StringBuffer stringBuffer = new StringBuffer(7);
        stringBuffer.append("#");
        int n2 = 6 - object.length();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                stringBuffer.append((String)object);
                return stringBuffer.toString();
            }
            stringBuffer.append("0");
            ++n3;
        } while (true);
    }

    public static Color stringToColor(String string) {
        if (string == null) {
            return Color.black;
        }
        try {
            return Color.decode(string);
        }
        catch (NumberFormatException var1_1) {
            try {
                Class class_ = class$java$awt$Color == null ? (PaintUtilities.class$java$awt$Color = PaintUtilities.class$("java.awt.Color")) : class$java$awt$Color;
                Field field = class_.getField(string);
                return (Color)field.get(null);
            }
            catch (Exception var2_3) {
                Log.info(new StringBuffer().append("No such Color : ").append(string).toString());
                return Color.black;
            }
        }
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

