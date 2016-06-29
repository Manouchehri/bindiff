package y.g;

import java.util.*;
import java.awt.geom.*;
import java.beans.*;
import java.io.*;

final class ab extends a
{
    ab() {
        super((X.n == null) ? (X.n = X.a("java.awt.geom.Rectangle2D")) : X.n);
    }
    
    protected Object a(final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "(,)", false);
        try {
            final Rectangle2D rectangle2D = (Rectangle2D)Beans.instantiate(this.getClass().getClassLoader(), stringTokenizer.nextToken());
            rectangle2D.setFrame(Double.parseDouble(stringTokenizer.nextToken()), Double.parseDouble(stringTokenizer.nextToken()), Double.parseDouble(stringTokenizer.nextToken()), Double.parseDouble(stringTokenizer.nextToken()));
            return rectangle2D;
        }
        catch (NumberFormatException ex3) {
            throw new IllegalArgumentException("Could not parse number " + s);
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Unknown class " + ex);
        }
        catch (IOException ex2) {
            throw new IllegalArgumentException("Could not load class " + ex2);
        }
    }
    
    protected String a(final Object o) {
        final Rectangle2D rectangle2D = (Rectangle2D)o;
        final StringBuffer sb = new StringBuffer(50);
        sb.append(rectangle2D.getClass().getName());
        sb.append('(');
        sb.append(rectangle2D.getX());
        sb.append(',');
        sb.append(rectangle2D.getY());
        sb.append(',');
        sb.append(rectangle2D.getWidth());
        sb.append(',');
        sb.append(rectangle2D.getHeight());
        sb.append(')');
        return sb.toString();
    }
}
