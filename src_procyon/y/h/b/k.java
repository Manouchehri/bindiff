package y.h.b;

import y.h.*;
import y.d.*;
import java.awt.geom.*;
import java.util.*;

final class k implements bg
{
    private k() {
    }
    
    public q a(final fj fj) {
        if (fj instanceof a) {
            return a((a)fj);
        }
        return new q(0.0, 0.0);
    }
    
    private static q a(final a a) {
        if (a.e(a) == null) {
            return new q(0.0, 0.0);
        }
        final i l = a.l();
        return new q(a(l), b(l));
    }
    
    private static double a(final i i) {
        final int h = a.H;
        final s s = new s();
        a.a(i, s);
        double n = s.b + s.d;
        final Iterator<c> iterator = (Iterator<c>)i.l().iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + a(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    private static double a(final c c) {
        final int h = a.H;
        final List l = c.l();
        if (l.isEmpty()) {
            return c.f();
        }
        double n = 0.0;
        final r i = c.i();
        if (i != null) {
            n += i.b + i.d;
        }
        final Iterator<c> iterator = l.iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + a(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    private static double b(final i i) {
        final int h = a.H;
        final s s = new s();
        a.b(i, s);
        double n = s.a + s.c;
        final Iterator<f> iterator = (Iterator<f>)i.o().iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + a(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    private static double a(final f f) {
        final int h = a.H;
        final List o = f.o();
        if (o.isEmpty()) {
            return f.f();
        }
        double n = 0.0;
        final r i = f.i();
        if (i != null) {
            n += i.a + i.c;
        }
        final Iterator<f> iterator = o.iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + a(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    public q b(final fj fj) {
        return new q(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private static void b(final a a, final Rectangle2D rectangle2D) {
        final int h = a.H;
        if (a.e(a) != null) {
            final double width = a.getWidth();
            final double height = a.getHeight();
            final double x = a.getX();
            final double y = a.getY();
            final double n = x + width;
            final double n2 = y + height;
            final double width2 = rectangle2D.getWidth();
            final double height2 = rectangle2D.getHeight();
            final double x2 = rectangle2D.getX();
            final double n3 = x2 + width2;
            final double y2 = rectangle2D.getY();
            final double n4 = y2 + height2;
            final double n5 = width - width2;
            final double n6 = height - height2;
            final i l = a.l();
            Label_0288: {
                if (n5 != 0.0) {
                    final List i = l.l();
                    if (Math.abs(x2 - x) > Math.abs(n3 - n)) {
                        if (n5 > 0.0) {
                            final double a2 = a(l);
                            if (a2 > width2) {
                                final double n7 = width - a2;
                                if (n7 <= 0.0) {
                                    break Label_0288;
                                }
                                a(n7, i, true);
                                if (h == 0) {
                                    break Label_0288;
                                }
                            }
                            a(n5, i, true);
                            if (h == 0) {
                                break Label_0288;
                            }
                        }
                        b(-n5, i, true);
                        if (h == 0) {
                            break Label_0288;
                        }
                    }
                    if (n5 > 0.0) {
                        final double a3 = a(l);
                        if (a3 > width2) {
                            final double n8 = width - a3;
                            if (n8 <= 0.0) {
                                break Label_0288;
                            }
                            a(n8, i, false);
                            if (h == 0) {
                                break Label_0288;
                            }
                        }
                        a(n5, i, false);
                        if (h == 0) {
                            break Label_0288;
                        }
                    }
                    b(-n5, i, false);
                }
            }
            if (n6 != 0.0) {
                final List o = l.o();
                if (Math.abs(y2 - y) > Math.abs(n4 - n2)) {
                    if (n6 > 0.0) {
                        final double b = b(l);
                        if (b > height2) {
                            final double n9 = height - b;
                            if (n9 <= 0.0) {
                                return;
                            }
                            a(n9, o, true);
                            if (h == 0) {
                                return;
                            }
                        }
                        a(n6, o, true);
                        if (h == 0) {
                            return;
                        }
                    }
                    b(-n6, o, true);
                    if (h == 0) {
                        return;
                    }
                }
                if (n6 > 0.0) {
                    final double b2 = b(l);
                    if (b2 > height2) {
                        final double n10 = height - b2;
                        if (n10 <= 0.0) {
                            return;
                        }
                        a(n10, o, false);
                        if (h == 0) {
                            return;
                        }
                    }
                    a(n6, o, false);
                    if (h == 0) {
                        return;
                    }
                }
                b(-n6, o, false);
            }
        }
    }
    
    private static void a(final double n, final List list, final boolean b) {
        final int h = a.H;
        y.h.b.q q = list.get(b ? 0 : (list.size() - 1));
        while (q != null) {
            q.d(q.q() + n);
            final List b2 = q.b;
            if (b2.isEmpty()) {
                q = null;
            }
            else {
                q = b2.get(b ? 0 : (b2.size() - 1));
                if (h != 0) {
                    break;
                }
                continue;
            }
        }
    }
    
    private static double b(final double n, final List list, final boolean b) {
        double n2 = n;
        double n3 = 0.0;
        if (b) {
            final Iterator<y.h.b.q> iterator = list.iterator();
            while (iterator.hasNext()) {
                final double a = a(n2, iterator.next(), b);
                n2 -= a;
                n3 += a;
                if (n3 >= n) {
                    break;
                }
            }
        }
        else {
            final ListIterator<y.h.b.q> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                final double a2 = a(n2, listIterator.previous(), b);
                n2 -= a2;
                n3 += a2;
                if (n3 >= n) {
                    break;
                }
            }
        }
        return Math.min(n, n3);
    }
    
    private static double a(final double n, final y.h.b.q q, final boolean b) {
        final List b2 = q.b;
        final double n2 = b2.isEmpty() ? n : b(n, b2, b);
        final double q2 = q.q();
        q.d(q2 - n2);
        return q2 - q.q();
    }
    
    k(final b b) {
        this();
    }
    
    static void a(final a a, final Rectangle2D rectangle2D) {
        b(a, rectangle2D);
    }
}
