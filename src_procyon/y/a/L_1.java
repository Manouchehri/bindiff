package y.a;

import y.g.*;

class L
{
    private String f;
    private al g;
    int a;
    int b;
    int c;
    int d;
    int e;
    
    L() {
        this.g = new al();
    }
    
    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = "0";
        this.g.a();
        this.g.e();
    }
    
    public void b() {
        this.f = this.g.toString();
    }
    
    public String toString() {
        return "\nMaxFlow-Statistics:\n   Time: " + this.f + "\n   Pushes: " + this.b + "\n   Inspections: " + this.c + "\n   Relabels: " + this.a + "\n   GlobalRelabels: " + this.d + "\n   Gaps: " + this.e;
    }
}
