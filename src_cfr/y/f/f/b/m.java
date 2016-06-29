/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.i;
import y.f.f.b.h;

public class m {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public int u = 0;

    public String toString() {
        int n2 = h.a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append("Total time: ").append(this.a).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("  Embedder time: ").append(this.b).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    Subgraph time: ").append(this.c).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    Routing time: ").append(this.d).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    Rerouting time: ").append(this.e).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("  Layout time: ").append(this.f).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("  Compaction time: ").append(this.g).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    preprocessing: ").append(this.h).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    main: ").append(this.i).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("      init: ").append(this.j).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("      heur: ").append(this.k).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("      main: ").append(this.l).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("      post: ").append(this.m).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("    postprocessing: ").append(this.n).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("Crossings: ").append(this.o).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("Bends: ").append(this.p).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("Total Edge Length: ").append(this.q).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("Width: ").append(this.r).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("Height: ").append(this.s).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("NonSubgraphDirectedEdges: ").append(this.t).append("\n").toString());
        stringBuffer.append(new StringBuffer().append("NonSubgraphUndirectedEdges: ").append(this.u).append("\n").toString());
        if (n2 == 0) return stringBuffer.toString();
        i.g = !i.g;
        return stringBuffer.toString();
    }
}

