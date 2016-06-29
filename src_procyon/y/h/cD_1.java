package y.h;

import java.awt.event.*;
import y.c.*;
import y.h.a.*;

public class cD extends cA
{
    private boolean b;
    private boolean c;
    
    public cD() {
        this((ch)null);
    }
    
    public cD(final ch ch) {
        super(cm.A.toString(), ch);
        this.c = false;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
        }
    }
    
    public void a(final ch p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       y/h/fj.z:Z
        //     3: istore          12
        //     5: aload_1        
        //     6: invokevirtual   y/h/ch.getGraph2D:()Ly/h/bu;
        //     9: astore_2       
        //    10: aload_0        
        //    11: aload_2        
        //    12: invokevirtual   y/h/cD.a:(Ly/h/bu;)Ly/h/a/v;
        //    15: astore_3       
        //    16: aload_3        
        //    17: ifnull          300
        //    20: new             Ly/c/y;
        //    23: dup            
        //    24: invokespecial   y/c/y.<init>:()V
        //    27: astore          4
        //    29: aload_3        
        //    30: aload_2        
        //    31: invokevirtual   y/h/a/v.e:(Ly/c/i;)Ly/c/q;
        //    34: astore          5
        //    36: aload_0        
        //    37: aload_3        
        //    38: aload           5
        //    40: aload           4
        //    42: aload_2        
        //    43: invokespecial   y/h/cD.a:(Ly/h/a/v;Ly/c/q;Ly/c/y;Ly/h/bu;)V
        //    46: new             Ly/c/y;
        //    49: dup            
        //    50: aload_2        
        //    51: invokevirtual   y/h/bu.J:()Ly/c/x;
        //    54: invokespecial   y/c/y.<init>:(Ly/c/x;)V
        //    57: astore          6
        //    59: aload_2        
        //    60: invokevirtual   y/h/bu.r:()V
        //    63: new             Ljava/util/HashSet;
        //    66: dup            
        //    67: aload           4
        //    69: invokespecial   java/util/HashSet.<init>:(Ljava/util/Collection;)V
        //    72: astore          7
        //    74: new             Ly/c/y;
        //    77: dup            
        //    78: aload           4
        //    80: invokespecial   y/c/y.<init>:(Ly/c/y;)V
        //    83: astore          8
        //    85: aload           4
        //    87: invokevirtual   y/c/y.a:()Ly/c/x;
        //    90: astore          9
        //    92: aload           9
        //    94: invokeinterface y/c/x.f:()Z
        //    99: ifeq            155
        //   102: aload_3        
        //   103: aload           9
        //   105: invokeinterface y/c/x.e:()Ly/c/q;
        //   110: invokevirtual   y/h/a/v.n:(Ly/c/q;)Ly/c/q;
        //   113: astore          10
        //   115: aload           10
        //   117: iload           12
        //   119: ifne            188
        //   122: ifnull          143
        //   125: aload           7
        //   127: aload           10
        //   129: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
        //   132: ifeq            143
        //   135: aload           8
        //   137: aload           10
        //   139: invokevirtual   y/c/y.add:(Ljava/lang/Object;)Z
        //   142: pop            
        //   143: aload           9
        //   145: invokeinterface y/c/x.g:()V
        //   150: iload           12
        //   152: ifeq            92
        //   155: aload_2        
        //   156: aload           8
        //   158: invokevirtual   y/c/y.a:()Ly/c/x;
        //   161: invokevirtual   y/h/bu.a:(Ly/c/x;)V
        //   164: aload           4
        //   166: invokevirtual   y/c/y.a:()Ly/c/x;
        //   169: astore          9
        //   171: aload           9
        //   173: invokeinterface y/c/x.f:()Z
        //   178: ifeq            223
        //   181: aload           9
        //   183: invokeinterface y/c/x.e:()Ly/c/q;
        //   188: astore          10
        //   190: aload_2        
        //   191: aload           10
        //   193: invokevirtual   y/h/bu.f:(Ly/c/q;)Z
        //   196: iload           12
        //   198: ifne            243
        //   201: ifeq            211
        //   204: aload_0        
        //   205: aload           10
        //   207: aload_2        
        //   208: invokevirtual   y/h/cD.c:(Ly/c/q;Ly/h/bu;)V
        //   211: aload           9
        //   213: invokeinterface y/c/x.g:()V
        //   218: iload           12
        //   220: ifeq            171
        //   223: aload_2        
        //   224: invokevirtual   y/h/bu.s:()V
        //   227: goto            239
        //   230: astore          11
        //   232: aload_2        
        //   233: invokevirtual   y/h/bu.s:()V
        //   236: aload           11
        //   238: athrow         
        //   239: aload_0        
        //   240: invokevirtual   y/h/cD.b:()Z
        //   243: ifeq            300
        //   246: aload           6
        //   248: invokevirtual   y/c/y.a:()Ly/c/x;
        //   251: astore          7
        //   253: aload           7
        //   255: invokeinterface y/c/x.f:()Z
        //   260: ifeq            300
        //   263: aload           7
        //   265: invokeinterface y/c/x.e:()Ly/c/q;
        //   270: astore          8
        //   272: aload_2        
        //   273: aload           8
        //   275: invokevirtual   y/h/bu.f:(Ly/c/q;)Z
        //   278: ifeq            288
        //   281: aload_2        
        //   282: aload           8
        //   284: iconst_1       
        //   285: invokevirtual   y/h/bu.a:(Ly/c/q;Z)V
        //   288: aload           7
        //   290: invokeinterface y/c/x.g:()V
        //   295: iload           12
        //   297: ifeq            253
        //   300: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  63     223    230    239    Any
        //  230    232    230    239    Any
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void a(final v v, final q q, final y y, final bu bu) {
        final boolean z = fj.z;
        final x p4 = v.p(q);
        while (p4.f()) {
            final q e = p4.e();
            Label_0099: {
                if (this.a(bu, e)) {
                    if (this.c && v.k(e)) {
                        this.a(v, e, y, bu);
                    }
                    y.add(e);
                    if (!z) {
                        break Label_0099;
                    }
                }
                if (v.k(e)) {
                    this.a(v, e, y, bu);
                }
            }
            p4.g();
            if (z) {
                break;
            }
        }
    }
    
    protected boolean a(final bu bu, final q q) {
        final v a = this.a(bu);
        return bu.v(q) && a.k(q);
    }
    
    public void c(final q q, final bu bu) {
        bu.r();
        try {
            final q n = this.a(bu).n(q);
            a autoBoundsFeature = null;
            boolean b = false;
            if (n != null) {
                autoBoundsFeature = bu.t(n).getAutoBoundsFeature();
                b = (autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled());
                if (b) {
                    autoBoundsFeature.setAutoBoundsEnabled(false);
                }
            }
            try {
                this.a(q, bu);
                this.b(bu, q);
                this.b(q, bu);
            }
            finally {
                if (b) {
                    autoBoundsFeature.setAutoBoundsEnabled(true);
                }
            }
        }
        finally {
            bu.s();
        }
        bu.T();
    }
    
    private void b(final bu bu, final q q) {
        this.a(bu).e(q);
        this.a(bu.t(q));
    }
    
    protected void a(fj a) {
        if (a instanceof gd) {
            final gd gd = (gd)a;
            final boolean selected = gd.isSelected();
            a = gd.a(1);
            gd.b(a);
            if (this.c()) {
                gd.setSelected(selected);
            }
            a.setLocation(gd.a(0).getX(), gd.a(0).getY());
            if (!(a instanceof h) || ((h)a).isGroupClosed()) {
                return;
            }
            ((h)a).setGroupClosed(true);
            if (!fj.z) {
                return;
            }
        }
        if (a instanceof h && !((h)a).isGroupClosed()) {
            ((h)a).setGroupClosed(true);
        }
    }
    
    public boolean c() {
        return this.b;
    }
}
