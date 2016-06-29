package y.h;

import java.awt.geom.*;
import y.c.*;
import y.f.*;
import y.d.*;
import y.b.*;

public class dj implements d
{
    private static final long xf = 300L;
    private static final boolean uf = true;
    private q zf;
    private boolean wf;
    private boolean sf;
    private long vf;
    private boolean yf;
    private dl tf;
    
    public dj() {
        this.vf = 300L;
        this.yf = true;
    }
    
    public dj(final ch ch, final O o) {
        this.vf = 300L;
        this.yf = true;
        this.initialize(ch, o);
    }
    
    public boolean isEasedExecution() {
        return this.yf;
    }
    
    public void setEasedExecution(final boolean yf) {
        this.yf = yf;
        if (this.tf != null) {
            this.tf.a(yf);
        }
    }
    
    public long preferredDuration() {
        return this.vf;
    }
    
    public void setPreferredDuration(final long vf) {
        this.vf = vf;
        if (this.tf != null) {
            this.tf.a(vf);
        }
    }
    
    public q getFocusNode() {
        return this.zf;
    }
    
    public void setFocusNode(final q zf) {
        this.zf = zf;
        if (this.tf != null) {
            this.tf.a(zf);
        }
    }
    
    public boolean isSmoothViewTransform() {
        return this.wf;
    }
    
    public void setSmoothViewTransform(final boolean wf) {
        this.wf = wf;
        if (this.tf != null) {
            this.tf.b(wf);
        }
    }
    
    public void initAnimation() {
        if (this.tf != null) {
            this.tf.initAnimation();
        }
    }
    
    protected Rectangle2D calcBoundingBox(final i i, final O o, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        final x o2 = i.o();
        while (o2.f()) {
            final am a = o.a(o2.e());
            if (rectangle2D.getWidth() < 0.0) {
                rectangle2D.setFrame(a.getX(), a.getY(), a.getWidth(), a.getHeight());
            }
            rectangle2D.add(a.getX(), a.getY());
            rectangle2D.add(a.getX() + a.getWidth(), a.getY() + a.getHeight());
            final aj[] a_ = o.a_(o2.e());
            Label_0275: {
                if (a_ != null && a_.length > 0) {
                    int j = 0;
                    while (j < a_.length) {
                        final y h = a_[j].a().a(a_[j].getOrientedBox().d(), a, a_[j].getModelParameter()).h();
                        rectangle2D.add(h.c, h.d);
                        rectangle2D.add(h.c + h.a, h.d + h.b);
                        ++j;
                        if (z) {
                            break Label_0275;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                o2.g();
            }
            if (z) {
                break;
            }
        }
        final e p3 = i.p();
    Label_0683_Outer:
        while (p3.f()) {
            final C[] d = o.d(p3.a());
            final I b = o.b(p3.a());
            final am a2 = o.a(p3.a().c());
            final am a3 = o.a(p3.a().d());
            rectangle2D.add(a2.getX() + a2.getWidth() * 0.5 + b.getSourcePoint().a, a2.getY() + a2.getHeight() * 0.5 + b.getSourcePoint().b);
            final Rectangle2D rectangle2D2 = rectangle2D;
            if (!z) {
                rectangle2D.add(a3.getX() + a3.getWidth() * 0.5 + b.getTargetPoint().a, a3.getY() + a3.getHeight() * 0.5 + b.getTargetPoint().b);
                int k = 0;
            Label_0683:
                while (true) {
                    while (k < b.pointCount()) {
                        final t point = b.getPoint(k);
                        rectangle2D.add(point.a, point.b);
                        ++k;
                        if (!z) {
                            if (z) {
                                break;
                            }
                            continue Label_0683_Outer;
                        }
                        else {
                            if (z) {
                                break Label_0683_Outer;
                            }
                            continue Label_0683_Outer;
                        }
                    }
                    if (d != null && d.length > 0) {
                        int l = 0;
                        while (l < d.length) {
                            final y h2 = d[l].getLabelModel().a(d[l].getOrientedBox().d(), b, a2, a3, d[l].getModelParameter()).h();
                            rectangle2D.add(h2.c, h2.d);
                            rectangle2D.add(h2.c + h2.a, h2.d + h2.b);
                            ++l;
                            if (z) {
                                continue Label_0683;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    p3.g();
                    continue Label_0683;
                }
            }
            return rectangle2D2;
        }
        return rectangle2D;
    }
    
    public void calcFrame(final double n) {
        if (this.tf != null) {
            this.tf.calcFrame(n);
        }
    }
    
    public void disposeAnimation() {
        if (this.tf != null) {
            this.tf.disposeAnimation();
            this.tf = null;
        }
    }
    
    public void execute() {
        if (this.tf != null) {
            final ch p = this.tf.p;
            final bu a = this.tf.a;
            final y.b.e e = new y.b.e();
            e.a(p);
            e.a(new dk(this, a));
            if (this.yf) {
                e.a(b.a(this));
                if (!fj.z) {
                    return;
                }
            }
            e.a(this);
        }
    }
    
    public void execute(final ch ch, final O o) {
        this.initialize(ch, o);
        this.execute();
    }
    
    protected void initialize(final ch ch, final O o) {
        (this.tf = new dl(ch, o, this)).c(this.isKeepZoomFactor());
        this.tf.a(this.getFocusNode());
        this.tf.a(this.isEasedExecution());
        this.tf.a(this.preferredDuration());
        this.tf.b(this.isSmoothViewTransform());
    }
    
    public boolean isKeepZoomFactor() {
        return this.sf;
    }
    
    public void setKeepZoomFactor(final boolean sf) {
        this.sf = sf;
        if (this.tf != null) {
            this.tf.c(sf);
        }
    }
}
