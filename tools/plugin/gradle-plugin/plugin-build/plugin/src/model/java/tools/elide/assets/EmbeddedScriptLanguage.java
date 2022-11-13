// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/assets/embedded.proto

package tools.elide.assets;

/**
 * <pre>
 * Enumerates languages which are supported for embedded scripting in Elide.
 * </pre>
 *
 * Protobuf enum {@code assets.EmbeddedScriptLanguage}
 */
public enum EmbeddedScriptLanguage implements
    com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * The language is unknown or unspecified; regular code should not use this value.
     * </pre>
     *
     * <code>LANGUAGE_UNSPECIFIED = 0;</code>
     */
    LANGUAGE_UNSPECIFIED(0),
    /**
     * <pre>
     * The language is a dialect of JavaScript.
     * </pre>
     *
     * <code>JS = 1;</code>
     */
    JS(1),
    UNRECOGNIZED(-1);

    /**
     * <pre>
     * The language is unknown or unspecified; regular code should not use this value.
     * </pre>
     *
     * <code>LANGUAGE_UNSPECIFIED = 0;</code>
     */
    public static final int LANGUAGE_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * The language is a dialect of JavaScript.
     * </pre>
     *
     * <code>JS = 1;</code>
     */
    public static final int JS_VALUE = 1;

    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalArgumentException(
                "Can't get the number of an unknown enum value."
            );
        }
        return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static EmbeddedScriptLanguage valueOf(int value) {
        return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static EmbeddedScriptLanguage forNumber(int value) {
        switch (value) {
            case 0:
                return LANGUAGE_UNSPECIFIED;
            case 1:
                return JS;
            default:
                return null;
        }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<EmbeddedScriptLanguage> internalGetValueMap() {
        return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<EmbeddedScriptLanguage> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<EmbeddedScriptLanguage>() {
        public EmbeddedScriptLanguage findValueByNumber(int number) {
            return EmbeddedScriptLanguage.forNumber(number);
        }
    };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this == UNRECOGNIZED) {
            throw new java.lang.IllegalStateException(
                "Can't get the descriptor of an unrecognized enum value."
            );
        }
        return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
        return tools.elide.assets.Embedded
            .getDescriptor()
            .getEnumTypes()
            .get(0);
    }

    private static final EmbeddedScriptLanguage[] VALUES = values();

    public static EmbeddedScriptLanguage valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc
    ) {
        if (desc.getType() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
                "EnumValueDescriptor is not for this type."
            );
        }
        if (desc.getIndex() == -1) {
            return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
    }

    private final int value;

    private EmbeddedScriptLanguage(int value) {
        this.value = value;
    }
    // @@protoc_insertion_point(enum_scope:assets.EmbeddedScriptLanguage)
}
