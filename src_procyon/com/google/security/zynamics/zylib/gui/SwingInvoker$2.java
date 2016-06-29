package com.google.security.zynamics.zylib.gui;

class SwingInvoker$2 implements Runnable
{
    final /* synthetic */ SwingInvoker this$0;
    
    SwingInvoker$2(final SwingInvoker this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        this.this$0.operation();
    }
}
