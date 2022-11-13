// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/model/model.proto

package tools.elide.model;

/**
 * <pre>
 * Specifies options related to persistence of underlying model data associated with this particular message type. This
 * includes settings related to Firestore and other data engines.
 * </pre>
 *
 * Protobuf type {@code model.PersistenceOptions}
 */
public final class PersistenceOptions
    extends com.google.protobuf.GeneratedMessageV3
    implements
        // @@protoc_insertion_point(message_implements:model.PersistenceOptions)
        PersistenceOptionsOrBuilder {

    private static final long serialVersionUID = 0L;

    // Use PersistenceOptions.newBuilder() to construct.
    private PersistenceOptions(
        com.google.protobuf.GeneratedMessageV3.Builder<?> builder
    ) {
        super(builder);
    }

    private PersistenceOptions() {
        mode_ = 0;
        path_ = "";
        parent_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
        return new PersistenceOptions();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private PersistenceOptions(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new java.lang.NullPointerException();
        }
        com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder();
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    case 8:
                        {
                            int rawValue = input.readEnum();

                            mode_ = rawValue;
                            break;
                        }
                    case 18:
                        {
                            java.lang.String s = input.readStringRequireUtf8();

                            path_ = s;
                            break;
                        }
                    case 26:
                        {
                            java.lang.String s = input.readStringRequireUtf8();

                            parent_ = s;
                            break;
                        }
                    default:
                        {
                            if (
                                !parseUnknownField(
                                    input,
                                    unknownFields,
                                    extensionRegistry,
                                    tag
                                )
                            ) {
                                done = true;
                            }
                            break;
                        }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e
                .asInvalidProtocolBufferException()
                .setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(this);
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return tools.elide.model.Datamodel.internal_static_model_PersistenceOptions_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return tools.elide.model.Datamodel.internal_static_model_PersistenceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(
            tools.elide.model.PersistenceOptions.class,
            tools.elide.model.PersistenceOptions.Builder.class
        );
    }

    public static final int MODE_FIELD_NUMBER = 1;
    private int mode_;

    /**
     * <pre>
     * Specifies the storage mode for this entity.
     * </pre>
     *
     * <code>.model.CollectionMode mode = 1;</code>
     * @return The enum numeric value on the wire for mode.
     */
    @java.lang.Override
    public int getModeValue() {
        return mode_;
    }

    /**
     * <pre>
     * Specifies the storage mode for this entity.
     * </pre>
     *
     * <code>.model.CollectionMode mode = 1;</code>
     * @return The mode.
     */
    @java.lang.Override
    public tools.elide.model.CollectionMode getMode() {
        @SuppressWarnings("deprecation")
        tools.elide.model.CollectionMode result = tools.elide.model.CollectionMode.valueOf(
            mode_
        );
        return result == null
            ? tools.elide.model.CollectionMode.UNRECOGNIZED
            : result;
    }

    public static final int PATH_FIELD_NUMBER = 2;
    private volatile java.lang.Object path_;

    /**
     * <pre>
     * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @return The path.
     */
    @java.lang.Override
    public java.lang.String getPath() {
        java.lang.Object ref = path_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            path_ = s;
            return s;
        }
    }

    /**
     * <pre>
     * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
     * </pre>
     *
     * <code>string path = 2;</code>
     * @return The bytes for path.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getPathBytes() {
        java.lang.Object ref = path_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref
            );
            path_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int PARENT_FIELD_NUMBER = 3;
    private volatile java.lang.Object parent_;

    /**
     * <pre>
     * Name of this item's parent collection, if applicable.
     * </pre>
     *
     * <code>string parent = 3;</code>
     * @return The parent.
     */
    @java.lang.Override
    public java.lang.String getParent() {
        java.lang.Object ref = parent_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            parent_ = s;
            return s;
        }
    }

    /**
     * <pre>
     * Name of this item's parent collection, if applicable.
     * </pre>
     *
     * <code>string parent = 3;</code>
     * @return The bytes for parent.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getParentBytes() {
        java.lang.Object ref = parent_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref
            );
            parent_ = b;
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
        if (mode_ != tools.elide.model.CollectionMode.NESTED.getNumber()) {
            output.writeEnum(1, mode_);
        }
        if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(path_)) {
            com.google.protobuf.GeneratedMessageV3.writeString(
                output,
                2,
                path_
            );
        }
        if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(parent_)) {
            com.google.protobuf.GeneratedMessageV3.writeString(
                output,
                3,
                parent_
            );
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        if (mode_ != tools.elide.model.CollectionMode.NESTED.getNumber()) {
            size +=
                com.google.protobuf.CodedOutputStream.computeEnumSize(1, mode_);
        }
        if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(path_)) {
            size +=
                com.google.protobuf.GeneratedMessageV3.computeStringSize(
                    2,
                    path_
                );
        }
        if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(parent_)) {
            size +=
                com.google.protobuf.GeneratedMessageV3.computeStringSize(
                    3,
                    parent_
                );
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
        if (!(obj instanceof tools.elide.model.PersistenceOptions)) {
            return super.equals(obj);
        }
        tools.elide.model.PersistenceOptions other = (tools.elide.model.PersistenceOptions) obj;

        if (mode_ != other.mode_) return false;
        if (!getPath().equals(other.getPath())) return false;
        if (!getParent().equals(other.getParent())) return false;
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
        hash = (37 * hash) + MODE_FIELD_NUMBER;
        hash = (53 * hash) + mode_;
        hash = (37 * hash) + PATH_FIELD_NUMBER;
        hash = (53 * hash) + getPath().hashCode();
        hash = (37 * hash) + PARENT_FIELD_NUMBER;
        hash = (53 * hash) + getParent().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        java.nio.ByteBuffer data
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        com.google.protobuf.ByteString data
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        java.io.InputStream input
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
            PARSER,
            input
        );
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
            PARSER,
            input,
            extensionRegistry
        );
    }

    public static tools.elide.model.PersistenceOptions parseDelimitedFrom(
        java.io.InputStream input
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
            PARSER,
            input
        );
    }

    public static tools.elide.model.PersistenceOptions parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
            PARSER,
            input,
            extensionRegistry
        );
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        com.google.protobuf.CodedInputStream input
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
            PARSER,
            input
        );
    }

    public static tools.elide.model.PersistenceOptions parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry
    ) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
            PARSER,
            input,
            extensionRegistry
        );
    }

    @java.lang.Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(
        tools.elide.model.PersistenceOptions prototype
    ) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @java.lang.Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
            ? new Builder()
            : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent
    ) {
        Builder builder = new Builder(parent);
        return builder;
    }

    /**
     * <pre>
     * Specifies options related to persistence of underlying model data associated with this particular message type. This
     * includes settings related to Firestore and other data engines.
     * </pre>
     *
     * Protobuf type {@code model.PersistenceOptions}
     */
    public static final class Builder
        extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
        implements
            // @@protoc_insertion_point(builder_implements:model.PersistenceOptions)
            tools.elide.model.PersistenceOptionsOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return tools.elide.model.Datamodel.internal_static_model_PersistenceOptions_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return tools.elide.model.Datamodel.internal_static_model_PersistenceOptions_fieldAccessorTable.ensureFieldAccessorsInitialized(
                tools.elide.model.PersistenceOptions.class,
                tools.elide.model.PersistenceOptions.Builder.class
            );
        }

        // Construct using tools.elide.model.PersistenceOptions.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
            com.google.protobuf.GeneratedMessageV3.BuilderParent parent
        ) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
            ) {}
        }

        @java.lang.Override
        public Builder clear() {
            super.clear();
            mode_ = 0;

            path_ = "";

            parent_ = "";

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return tools.elide.model.Datamodel.internal_static_model_PersistenceOptions_descriptor;
        }

        @java.lang.Override
        public tools.elide.model.PersistenceOptions getDefaultInstanceForType() {
            return tools.elide.model.PersistenceOptions.getDefaultInstance();
        }

        @java.lang.Override
        public tools.elide.model.PersistenceOptions build() {
            tools.elide.model.PersistenceOptions result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public tools.elide.model.PersistenceOptions buildPartial() {
            tools.elide.model.PersistenceOptions result = new tools.elide.model.PersistenceOptions(
                this
            );
            result.mode_ = mode_;
            result.path_ = path_;
            result.parent_ = parent_;
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
            java.lang.Object value
        ) {
            return super.setField(field, value);
        }

        @java.lang.Override
        public Builder clearField(
            com.google.protobuf.Descriptors.FieldDescriptor field
        ) {
            return super.clearField(field);
        }

        @java.lang.Override
        public Builder clearOneof(
            com.google.protobuf.Descriptors.OneofDescriptor oneof
        ) {
            return super.clearOneof(oneof);
        }

        @java.lang.Override
        public Builder setRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            int index,
            java.lang.Object value
        ) {
            return super.setRepeatedField(field, index, value);
        }

        @java.lang.Override
        public Builder addRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            java.lang.Object value
        ) {
            return super.addRepeatedField(field, value);
        }

        @java.lang.Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof tools.elide.model.PersistenceOptions) {
                return mergeFrom((tools.elide.model.PersistenceOptions) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(tools.elide.model.PersistenceOptions other) {
            if (
                other ==
                tools.elide.model.PersistenceOptions.getDefaultInstance()
            ) return this;
            if (other.mode_ != 0) {
                setModeValue(other.getModeValue());
            }
            if (!other.getPath().isEmpty()) {
                path_ = other.path_;
                onChanged();
            }
            if (!other.getParent().isEmpty()) {
                parent_ = other.parent_;
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
            com.google.protobuf.ExtensionRegistryLite extensionRegistry
        ) throws java.io.IOException {
            tools.elide.model.PersistenceOptions parsedMessage = null;
            try {
                parsedMessage =
                    PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage =
                    (tools.elide.model.PersistenceOptions) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int mode_ = 0;

        /**
         * <pre>
         * Specifies the storage mode for this entity.
         * </pre>
         *
         * <code>.model.CollectionMode mode = 1;</code>
         * @return The enum numeric value on the wire for mode.
         */
        @java.lang.Override
        public int getModeValue() {
            return mode_;
        }

        /**
         * <pre>
         * Specifies the storage mode for this entity.
         * </pre>
         *
         * <code>.model.CollectionMode mode = 1;</code>
         * @param value The enum numeric value on the wire for mode to set.
         * @return This builder for chaining.
         */
        public Builder setModeValue(int value) {
            mode_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Specifies the storage mode for this entity.
         * </pre>
         *
         * <code>.model.CollectionMode mode = 1;</code>
         * @return The mode.
         */
        @java.lang.Override
        public tools.elide.model.CollectionMode getMode() {
            @SuppressWarnings("deprecation")
            tools.elide.model.CollectionMode result = tools.elide.model.CollectionMode.valueOf(
                mode_
            );
            return result == null
                ? tools.elide.model.CollectionMode.UNRECOGNIZED
                : result;
        }

        /**
         * <pre>
         * Specifies the storage mode for this entity.
         * </pre>
         *
         * <code>.model.CollectionMode mode = 1;</code>
         * @param value The mode to set.
         * @return This builder for chaining.
         */
        public Builder setMode(tools.elide.model.CollectionMode value) {
            if (value == null) {
                throw new NullPointerException();
            }

            mode_ = value.getNumber();
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Specifies the storage mode for this entity.
         * </pre>
         *
         * <code>.model.CollectionMode mode = 1;</code>
         * @return This builder for chaining.
         */
        public Builder clearMode() {
            mode_ = 0;
            onChanged();
            return this;
        }

        private java.lang.Object path_ = "";

        /**
         * <pre>
         * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
         * </pre>
         *
         * <code>string path = 2;</code>
         * @return The path.
         */
        public java.lang.String getPath() {
            java.lang.Object ref = path_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                path_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <pre>
         * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
         * </pre>
         *
         * <code>string path = 2;</code>
         * @return The bytes for path.
         */
        public com.google.protobuf.ByteString getPathBytes() {
            java.lang.Object ref = path_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref
                );
                path_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <pre>
         * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
         * </pre>
         *
         * <code>string path = 2;</code>
         * @param value The path to set.
         * @return This builder for chaining.
         */
        public Builder setPath(java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            path_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
         * </pre>
         *
         * <code>string path = 2;</code>
         * @return This builder for chaining.
         */
        public Builder clearPath() {
            path_ = getDefaultInstance().getPath();
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Data path for a given message, with items in the URL corresponding to parameters in the item's key path.
         * </pre>
         *
         * <code>string path = 2;</code>
         * @param value The bytes for path to set.
         * @return This builder for chaining.
         */
        public Builder setPathBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            path_ = value;
            onChanged();
            return this;
        }

        private java.lang.Object parent_ = "";

        /**
         * <pre>
         * Name of this item's parent collection, if applicable.
         * </pre>
         *
         * <code>string parent = 3;</code>
         * @return The parent.
         */
        public java.lang.String getParent() {
            java.lang.Object ref = parent_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                parent_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <pre>
         * Name of this item's parent collection, if applicable.
         * </pre>
         *
         * <code>string parent = 3;</code>
         * @return The bytes for parent.
         */
        public com.google.protobuf.ByteString getParentBytes() {
            java.lang.Object ref = parent_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref
                );
                parent_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <pre>
         * Name of this item's parent collection, if applicable.
         * </pre>
         *
         * <code>string parent = 3;</code>
         * @param value The parent to set.
         * @return This builder for chaining.
         */
        public Builder setParent(java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            parent_ = value;
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Name of this item's parent collection, if applicable.
         * </pre>
         *
         * <code>string parent = 3;</code>
         * @return This builder for chaining.
         */
        public Builder clearParent() {
            parent_ = getDefaultInstance().getParent();
            onChanged();
            return this;
        }

        /**
         * <pre>
         * Name of this item's parent collection, if applicable.
         * </pre>
         *
         * <code>string parent = 3;</code>
         * @param value The bytes for parent to set.
         * @return This builder for chaining.
         */
        public Builder setParentBytes(com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            parent_ = value;
            onChanged();
            return this;
        }

        @java.lang.Override
        public final Builder setUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields
        ) {
            return super.setUnknownFields(unknownFields);
        }

        @java.lang.Override
        public final Builder mergeUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields
        ) {
            return super.mergeUnknownFields(unknownFields);
        }
        // @@protoc_insertion_point(builder_scope:model.PersistenceOptions)
    }

    // @@protoc_insertion_point(class_scope:model.PersistenceOptions)
    private static final tools.elide.model.PersistenceOptions DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new tools.elide.model.PersistenceOptions();
    }

    public static tools.elide.model.PersistenceOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PersistenceOptions> PARSER = new com.google.protobuf.AbstractParser<PersistenceOptions>() {
        @java.lang.Override
        public PersistenceOptions parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry
        ) throws com.google.protobuf.InvalidProtocolBufferException {
            return new PersistenceOptions(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<PersistenceOptions> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PersistenceOptions> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public tools.elide.model.PersistenceOptions getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
