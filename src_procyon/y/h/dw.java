package y.h;

import java.util.*;
import java.awt.event.*;

public class dw extends EventObject
{
    private final Object a;
    private final double b;
    private final double c;
    private final int d;
    private final long e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    
    public double a() {
        return this.b;
    }
    
    public double b() {
        return this.c;
    }
    
    public int c() {
        return this.d;
    }
    
    public int d() {
        return this.f;
    }
    
    public int e() {
        return this.g;
    }
    
    public int f() {
        return this.h;
    }
    
    public dw(final Object o, final Object a, final int d, final long e, final int f, final double b, final double c, final int g, final int h, final boolean i) {
        super(o);
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public dw(final Object o, final Object o2, final double n, final double n2, final MouseEvent mouseEvent) {
        this(o, o2, mouseEvent.getID(), mouseEvent.getWhen(), mouseEvent.getModifiersEx(), n, n2, mouseEvent.getButton(), mouseEvent.getClickCount(), mouseEvent.isPopupTrigger());
    }
    
    public String toString() {
        final boolean z = fj.z;
        Label_0094: {
            switch (this.d) {
                case 500: {
                    final String s = "MOUSE_CLICKED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 506: {
                    final String s = "MOUSE_DRAGGED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 505: {
                    final String s = "MOUSE_EXITED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 504: {
                    final String s = "MOUSE_ENTERED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 501: {
                    final String s = "MOUSE_PRESSED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 502: {
                    final String s = "MOUSE_RELEASED";
                    if (z) {
                        break Label_0094;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
                case 503: {
                    final String s = "MOUSE_MOVED";
                    if (z) {
                        break;
                    }
                    return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
                }
            }
        }
        final String s = "unknown";
        return "Mouse2DEvent[x=" + this.b + ", y=" + this.c + ", id=" + s + ", when=" + this.e + ", modifiers=" + this.f + ", button=" + this.g + ", clickCount=" + this.h + ", popupTrigger=" + this.i + "]";
    }
}
