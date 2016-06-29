package y.b;

import java.awt.event.*;

final class g implements ActionListener
{
    private final e a;
    
    private g(final e a) {
        this.a = a;
    }
    
    public void actionPerformed(final ActionEvent p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       y/b/e.a:I
        //     3: istore          7
        //     5: iconst_1       
        //     6: istore_2       
        //     7: aload_0        
        //     8: getfield        y/b/g.a:Ly/b/e;
        //    11: invokestatic    y/b/e.b:(Ly/b/e;)Ly/c/D;
        //    14: dup            
        //    15: astore_3       
        //    16: monitorenter   
        //    17: aload_0        
        //    18: getfield        y/b/g.a:Ly/b/e;
        //    21: invokestatic    y/b/e.b:(Ly/b/e;)Ly/c/D;
        //    24: ifnonnull       30
        //    27: aload_3        
        //    28: monitorexit    
        //    29: return         
        //    30: aload_0        
        //    31: getfield        y/b/g.a:Ly/b/e;
        //    34: invokestatic    y/b/e.b:(Ly/b/e;)Ly/c/D;
        //    37: invokevirtual   y/c/D.isEmpty:()Z
        //    40: ifne            47
        //    43: iconst_1       
        //    44: goto            48
        //    47: iconst_0       
        //    48: istore_2       
        //    49: iload_2        
        //    50: ifeq            118
        //    53: aload_0        
        //    54: getfield        y/b/g.a:Ly/b/e;
        //    57: invokestatic    y/b/e.b:(Ly/b/e;)Ly/c/D;
        //    60: invokevirtual   y/c/D.k:()Ly/c/p;
        //    63: astore          4
        //    65: aload           4
        //    67: ifnull          118
        //    70: aload           4
        //    72: invokevirtual   y/c/p.c:()Ljava/lang/Object;
        //    75: checkcast       Ly/b/h;
        //    78: astore          5
        //    80: aload           5
        //    82: invokevirtual   y/b/h.a:()Z
        //    85: iload           7
        //    87: ifne            131
        //    90: ifeq            106
        //    93: aload_0        
        //    94: getfield        y/b/g.a:Ly/b/e;
        //    97: invokestatic    y/b/e.b:(Ly/b/e;)Ly/c/D;
        //   100: aload           4
        //   102: invokevirtual   y/c/D.h:(Ly/c/p;)Ljava/lang/Object;
        //   105: pop            
        //   106: aload           4
        //   108: invokevirtual   y/c/p.a:()Ly/c/p;
        //   111: astore          4
        //   113: iload           7
        //   115: ifeq            65
        //   118: aload_3        
        //   119: monitorexit    
        //   120: goto            130
        //   123: astore          6
        //   125: aload_3        
        //   126: monitorexit    
        //   127: aload           6
        //   129: athrow         
        //   130: iload_2        
        //   131: ifeq            153
        //   134: aload_0        
        //   135: getfield        y/b/g.a:Ly/b/e;
        //   138: aload_0        
        //   139: getfield        y/b/g.a:Ly/b/e;
        //   142: invokestatic    y/b/e.c:(Ly/b/e;)Ly/b/a;
        //   145: invokestatic    y/b/e.a:(Ly/b/e;Ly/b/a;)V
        //   148: iload           7
        //   150: ifeq            160
        //   153: aload_0        
        //   154: getfield        y/b/g.a:Ly/b/e;
        //   157: invokestatic    y/b/e.d:(Ly/b/e;)V
        //   160: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  17     29     123    130    Any
        //  30     120    123    130    Any
        //  123    127    123    130    Any
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    g(final e e, final f f) {
        this(e);
    }
}
