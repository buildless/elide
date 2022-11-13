// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/assets/bundle.proto

package tools.elide.assets;

/**
 * <pre>
 * Enumerates supported asset manifest formats. These are all powered by Protocol Buffers' encoding tools. For maximum
 * performance, use the binary format.
 * </pre>
 *
 * Protobuf enum {@code assets.ManifestFormat}
 */
public enum ManifestFormat implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     * The manifest format was unspecified or unrecognized; this value should not be used by regular code.
     * </pre>
     *
     * <code>MANIFEST_FORMAT_UNSPECIFIED = 0;</code>
     */
    MANIFEST_FORMAT_UNSPECIFIED(0),
    /**
     * <pre>
     * Specifies a binary-encoded asset manifest.
     * </pre>
     *
     * <code>BINARY = 1;</code>
     */
    BINARY(1),
    /**
     * <pre>
     * Specifies a JSON-encoded asset manifest.
     * </pre>
     *
     * <code>JSON = 2;</code>
     */
    JSON(2),
    /**
     * <pre>
     * Specifies a text-encoded asset manifest.
     * </pre>
     *
     * <code>TEXT = 3;</code>
     */
    TEXT(3),
    UNRECOGNIZED(-1);

    /**
     * <pre>
     * The manifest format was unspecified or unrecognized; this value should not be used by regular code.
     * </pre>
     *
     * <code>MANIFEST_FORMAT_UNSPECIFIED = 0;</code>
     */
    public static final int MANIFEST_FORMAT_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Specifies a binary-encoded asset manifest.
     * </pre>
     *
     * <code>BINARY = 1;</code>
     */
    public static final int BINARY_VALUE = 1;
    /**
     * <pre>
     * Specifies a JSON-encoded asset manifest.
     * </pre>
     *
     * <code>JSON = 2;</code>
     */
    public static final int JSON_VALUE = 2;
    /**
     * <pre>
     * Specifies a text-encoded asset manifest.
     * </pre>
     *
     * <code>TEXT = 3;</code>
     */
    public static final int TEXT_VALUE = 3;

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
    public static ManifestFormat valueOf(int value) {
        return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ManifestFormat forNumber(int value) {
        switch (value) {
            case 0:
                return MANIFEST_FORMAT_UNSPECIFIED;
            case 1:
                return BINARY;
            case 2:
                return JSON;
            case 3:
                return TEXT;
            default:
                return null;
        }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ManifestFormat> internalGetValueMap() {
        return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<ManifestFormat> internalValueMap = new com.google.protobuf.Internal.EnumLiteMap<ManifestFormat>() {
        public ManifestFormat findValueByNumber(int number) {
            return ManifestFormat.forNumber(number);
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
        return tools.elide.assets.Bundle.getDescriptor().getEnumTypes().get(0);
    }

    private static final ManifestFormat[] VALUES = values();

    public static ManifestFormat valueOf(
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

    private ManifestFormat(int value) {
        this.value = value;
    }
    // @@protoc_insertion_point(enum_scope:assets.ManifestFormat)
}
