package y.f.i.a;

class aW
{
    private ah a;
    private ah b;
    
    aW(final ah a, final ah b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof aW)) {
            return false;
        }
        final aW aw = (aW)o;
        return this.a != null && this.b != null && aw.a != null && aw.b != null && this.a.equals(aw.a) && this.b.equals(aw.b);
    }
    
    public int hashCode() {
        return 31 * ((this.a != null) ? this.a.hashCode() : super.hashCode()) + ((this.b != null) ? this.b.hashCode() : super.hashCode());
    }
}
