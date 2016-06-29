package com.google.common.base;

enum Suppliers$SupplierFunctionImpl implements Suppliers$SupplierFunction
{
    INSTANCE("INSTANCE", 0);
    
    private Suppliers$SupplierFunctionImpl(final String s, final int n) {
    }
    
    public Object apply(final Supplier supplier) {
        return supplier.get();
    }
    
    @Override
    public String toString() {
        return "Suppliers.supplierFunction()";
    }
}
