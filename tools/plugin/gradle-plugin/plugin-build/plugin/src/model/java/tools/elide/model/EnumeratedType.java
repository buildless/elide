// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/model/model.proto

package tools.elide.model;

/**
 * <pre>
 * Specifies a special role, if applicable, for a given enumerated type. Each selection governs some special behavior
 * related to defined enums with APIs, databases, and so on.
 * </pre>
 *
 * Protobuf enum {@code model.EnumeratedType}
 */
public enum EnumeratedType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   * Specifies a generic enumeration structure.
   * </pre>
   *
   * <code>GENERIC_ENUMERATION = 0;</code>
   */
  GENERIC_ENUMERATION(0),
  /**
   * <pre>
   * Specifies a structure which enumerates error states.
   * </pre>
   *
   * <code>ERRORS = 1;</code>
   */
  ERRORS(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   * Specifies a generic enumeration structure.
   * </pre>
   *
   * <code>GENERIC_ENUMERATION = 0;</code>
   */
  public static final int GENERIC_ENUMERATION_VALUE = 0;
  /**
   * <pre>
   * Specifies a structure which enumerates error states.
   * </pre>
   *
   * <code>ERRORS = 1;</code>
   */
  public static final int ERRORS_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static EnumeratedType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static EnumeratedType forNumber(int value) {
    switch (value) {
      case 0: return GENERIC_ENUMERATION;
      case 1: return ERRORS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<EnumeratedType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      EnumeratedType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<EnumeratedType>() {
          public EnumeratedType findValueByNumber(int number) {
            return EnumeratedType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return tools.elide.model.Datamodel.getDescriptor().getEnumTypes().get(4);
  }

  private static final EnumeratedType[] VALUES = values();

  public static EnumeratedType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private EnumeratedType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:model.EnumeratedType)
}

