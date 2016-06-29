package org.ibex.nestedvm;

abstract class UnixRuntime$DevFS$DevDirFD extends UnixRuntime$DirFD
{
    private final UnixRuntime$DevFS this$0;
    
    private UnixRuntime$DevFS$DevDirFD(final UnixRuntime$DevFS this$0) {
        this.this$0 = this$0;
    }
    
    public int myDev() {
        return this.this$0.devno;
    }
    
    UnixRuntime$DevFS$DevDirFD(final UnixRuntime$DevFS unixRuntime$DevFS, final UnixRuntime$1 unixRuntime$1) {
        this(unixRuntime$DevFS);
    }
}
