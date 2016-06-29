package y.a;

import y.g.*;

class P
{
    private String d;
    private al e;
    int a;
    int b;
    int c;
    
    P() {
        this.e = new al();
    }
    
    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = "0";
        this.e.a();
        this.e.e();
    }
    
    public void b() {
        this.d = this.e.toString();
    }
    
    public String toString() {
        return "\nMinCostFlow-Statistics:\n   Time: " + this.d + "\n   Scalings: " + this.a + "\n   Augmentations : " + this.b + "\n   ExtractMins: " + this.c;
    }
}
