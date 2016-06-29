package com.google.protobuf;

public class TextFormat$Parser$Builder
{
    private boolean allowUnknownFields;
    private TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
    
    public TextFormat$Parser$Builder() {
        this.allowUnknownFields = false;
        this.singularOverwritePolicy = TextFormat$Parser$SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
    }
    
    public TextFormat$Parser$Builder setSingularOverwritePolicy(final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy) {
        this.singularOverwritePolicy = singularOverwritePolicy;
        return this;
    }
    
    public TextFormat$Parser build() {
        return new TextFormat$Parser(this.allowUnknownFields, this.singularOverwritePolicy, null);
    }
}
