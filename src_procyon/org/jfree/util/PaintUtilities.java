package org.jfree.util;

import java.awt.*;
import java.lang.reflect.*;

public class PaintUtilities
{
    static Class class$java$awt$Color;
    
    public static boolean equal(final Paint paint, final Paint paint2) {
        if (paint == null) {
            return paint2 == null;
        }
        if (paint2 == null) {
            return false;
        }
        boolean equals;
        if (paint instanceof GradientPaint && paint2 instanceof GradientPaint) {
            final GradientPaint gradientPaint = (GradientPaint)paint;
            final GradientPaint gradientPaint2 = (GradientPaint)paint2;
            equals = (gradientPaint.getColor1().equals(gradientPaint2.getColor1()) && gradientPaint.getColor2().equals(gradientPaint2.getColor2()) && gradientPaint.getPoint1().equals(gradientPaint2.getPoint1()) && gradientPaint.getPoint2().equals(gradientPaint2.getPoint2()) && gradientPaint.isCyclic() == gradientPaint2.isCyclic() && gradientPaint.getTransparency() == gradientPaint.getTransparency());
        }
        else {
            equals = paint.equals(paint2);
        }
        return equals;
    }
    
    public static String colorToString(final Color color) {
        try {
            final Field[] fields = ((PaintUtilities.class$java$awt$Color == null) ? (PaintUtilities.class$java$awt$Color = class$("java.awt.Color")) : PaintUtilities.class$java$awt$Color).getFields();
            for (int i = 0; i < fields.length; ++i) {
                final Field field = fields[i];
                if (Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers())) {
                    final String name = field.getName();
                    final Object value = field.get(null);
                    if (value instanceof Color && color.equals(value)) {
                        return name;
                    }
                }
            }
        }
        catch (Exception ex) {}
        final String hexString = Integer.toHexString(color.getRGB() & 0xFFFFFF);
        final StringBuffer sb = new StringBuffer(7);
        sb.append("#");
        for (int n = 6 - hexString.length(), j = 0; j < n; ++j) {
            sb.append("0");
        }
        sb.append(hexString);
        return sb.toString();
    }
    
    public static Color stringToColor(final String s) {
        if (s == null) {
            return Color.black;
        }
        try {
            return Color.decode(s);
        }
        catch (NumberFormatException ex) {
            try {
                return (Color)((PaintUtilities.class$java$awt$Color == null) ? (PaintUtilities.class$java$awt$Color = class$("java.awt.Color")) : PaintUtilities.class$java$awt$Color).getField(s).get(null);
            }
            catch (Exception ex2) {
                Log.info("No such Color : " + s);
                return Color.black;
            }
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
