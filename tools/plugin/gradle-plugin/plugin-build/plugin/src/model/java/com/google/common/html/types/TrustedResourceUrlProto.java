// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: webutil/html/types/html.proto

package com.google.common.html.types;

/**
 * <pre>
 * Message containing a string that is safe to use in all URL contexts in DOM
 * APIs and HTML documents; even where the referred-to resource is interpreted
 * as code, e.g., as the src of a script element.
 * </pre>
 *
 * Protobuf type {@code webutil.html.types.TrustedResourceUrlProto}
 */
public final class TrustedResourceUrlProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:webutil.html.types.TrustedResourceUrlProto)
    TrustedResourceUrlProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TrustedResourceUrlProto.newBuilder() to construct.
  private TrustedResourceUrlProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TrustedResourceUrlProto() {
    privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TrustedResourceUrlProto();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TrustedResourceUrlProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 34: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000001;
            privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = bs;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.common.html.types.Html.internal_static_webutil_html_types_TrustedResourceUrlProto_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.common.html.types.Html.internal_static_webutil_html_types_TrustedResourceUrlProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.common.html.types.TrustedResourceUrlProto.class, com.google.common.html.types.TrustedResourceUrlProto.Builder.class);
  }

  private int bitField0_;
  public static final int PRIVATE_DO_NOT_ACCESS_OR_ELSE_TRUSTED_RESOURCE_URL_WRAPPED_VALUE_FIELD_NUMBER = 4;
  private volatile java.lang.Object privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
  /**
   * <pre>
   * IMPORTANT: Never set or read this field, even from tests, it is private.
   * See documentation at the top of .proto file for programming language
   * packages with which to create or read this message.
   * </pre>
   *
   * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
   * @return Whether the privateDoNotAccessOrElseTrustedResourceUrlWrappedValue field is set.
   */
  @java.lang.Override
  public boolean hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * IMPORTANT: Never set or read this field, even from tests, it is private.
   * See documentation at the top of .proto file for programming language
   * packages with which to create or read this message.
   * </pre>
   *
   * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
   * @return The privateDoNotAccessOrElseTrustedResourceUrlWrappedValue.
   */
  @java.lang.Override
  public java.lang.String getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() {
    java.lang.Object ref = privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = s;
      }
      return s;
    }
  }
  /**
   * <pre>
   * IMPORTANT: Never set or read this field, even from tests, it is private.
   * See documentation at the top of .proto file for programming language
   * packages with which to create or read this message.
   * </pre>
   *
   * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
   * @return The bytes for privateDoNotAccessOrElseTrustedResourceUrlWrappedValue.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValueBytes() {
    java.lang.Object ref = privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.common.html.types.TrustedResourceUrlProto)) {
      return super.equals(obj);
    }
    com.google.common.html.types.TrustedResourceUrlProto other = (com.google.common.html.types.TrustedResourceUrlProto) obj;

    if (hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() != other.hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue()) return false;
    if (hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue()) {
      if (!getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue()
          .equals(other.getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue()) {
      hash = (37 * hash) + PRIVATE_DO_NOT_ACCESS_OR_ELSE_TRUSTED_RESOURCE_URL_WRAPPED_VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.common.html.types.TrustedResourceUrlProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.common.html.types.TrustedResourceUrlProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Message containing a string that is safe to use in all URL contexts in DOM
   * APIs and HTML documents; even where the referred-to resource is interpreted
   * as code, e.g., as the src of a script element.
   * </pre>
   *
   * Protobuf type {@code webutil.html.types.TrustedResourceUrlProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:webutil.html.types.TrustedResourceUrlProto)
      com.google.common.html.types.TrustedResourceUrlProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.common.html.types.Html.internal_static_webutil_html_types_TrustedResourceUrlProto_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.common.html.types.Html.internal_static_webutil_html_types_TrustedResourceUrlProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.common.html.types.TrustedResourceUrlProto.class, com.google.common.html.types.TrustedResourceUrlProto.Builder.class);
    }

    // Construct using com.google.common.html.types.TrustedResourceUrlProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.common.html.types.Html.internal_static_webutil_html_types_TrustedResourceUrlProto_descriptor;
    }

    @java.lang.Override
    public com.google.common.html.types.TrustedResourceUrlProto getDefaultInstanceForType() {
      return com.google.common.html.types.TrustedResourceUrlProto.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.common.html.types.TrustedResourceUrlProto build() {
      com.google.common.html.types.TrustedResourceUrlProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.common.html.types.TrustedResourceUrlProto buildPartial() {
      com.google.common.html.types.TrustedResourceUrlProto result = new com.google.common.html.types.TrustedResourceUrlProto(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        to_bitField0_ |= 0x00000001;
      }
      result.privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.common.html.types.TrustedResourceUrlProto) {
        return mergeFrom((com.google.common.html.types.TrustedResourceUrlProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.common.html.types.TrustedResourceUrlProto other) {
      if (other == com.google.common.html.types.TrustedResourceUrlProto.getDefaultInstance()) return this;
      if (other.hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue()) {
        bitField0_ |= 0x00000001;
        privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = other.privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.common.html.types.TrustedResourceUrlProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.common.html.types.TrustedResourceUrlProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = "";
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @return Whether the privateDoNotAccessOrElseTrustedResourceUrlWrappedValue field is set.
     */
    public boolean hasPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @return The privateDoNotAccessOrElseTrustedResourceUrlWrappedValue.
     */
    public java.lang.String getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() {
      java.lang.Object ref = privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @return The bytes for privateDoNotAccessOrElseTrustedResourceUrlWrappedValue.
     */
    public com.google.protobuf.ByteString
        getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValueBytes() {
      java.lang.Object ref = privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @param value The privateDoNotAccessOrElseTrustedResourceUrlWrappedValue to set.
     * @return This builder for chaining.
     */
    public Builder setPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue() {
      bitField0_ = (bitField0_ & ~0x00000001);
      privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = getDefaultInstance().getPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValue();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * IMPORTANT: Never set or read this field, even from tests, it is private.
     * See documentation at the top of .proto file for programming language
     * packages with which to create or read this message.
     * </pre>
     *
     * <code>optional string private_do_not_access_or_else_trusted_resource_url_wrapped_value = 4;</code>
     * @param value The bytes for privateDoNotAccessOrElseTrustedResourceUrlWrappedValue to set.
     * @return This builder for chaining.
     */
    public Builder setPrivateDoNotAccessOrElseTrustedResourceUrlWrappedValueBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      privateDoNotAccessOrElseTrustedResourceUrlWrappedValue_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:webutil.html.types.TrustedResourceUrlProto)
  }

  // @@protoc_insertion_point(class_scope:webutil.html.types.TrustedResourceUrlProto)
  private static final com.google.common.html.types.TrustedResourceUrlProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.common.html.types.TrustedResourceUrlProto();
  }

  public static com.google.common.html.types.TrustedResourceUrlProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<TrustedResourceUrlProto>
      PARSER = new com.google.protobuf.AbstractParser<TrustedResourceUrlProto>() {
    @java.lang.Override
    public TrustedResourceUrlProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TrustedResourceUrlProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TrustedResourceUrlProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TrustedResourceUrlProto> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.common.html.types.TrustedResourceUrlProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

