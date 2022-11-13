// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/data/data.proto

package tools.elide.data;

public interface DataContainerRefOrBuilder
    extends
        // @@protoc_insertion_point(interface_extends:data.DataContainerRef)
        com.google.protobuf.MessageOrBuilder {
    /**
     * <pre>
     * Specifies raw data which is enclosed as a value with this reference. In this case, a data blob and fingerprint
     * are enclosed inline within the protocol buffer.
     * </pre>
     *
     * <code>.data.CompressedData data = 1;</code>
     * @return Whether the data field is set.
     */
    boolean hasData();
    /**
     * <pre>
     * Specifies raw data which is enclosed as a value with this reference. In this case, a data blob and fingerprint
     * are enclosed inline within the protocol buffer.
     * </pre>
     *
     * <code>.data.CompressedData data = 1;</code>
     * @return The data.
     */
    tools.elide.data.CompressedData getData();
    /**
     * <pre>
     * Specifies raw data which is enclosed as a value with this reference. In this case, a data blob and fingerprint
     * are enclosed inline within the protocol buffer.
     * </pre>
     *
     * <code>.data.CompressedData data = 1;</code>
     */
    tools.elide.data.CompressedDataOrBuilder getDataOrBuilder();

    /**
     * <pre>
     * Specifies a reference to a file resident in the application JAR or native image.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair resource = 2;</code>
     * @return Whether the resource field is set.
     */
    boolean hasResource();
    /**
     * <pre>
     * Specifies a reference to a file resident in the application JAR or native image.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair resource = 2;</code>
     * @return The resource.
     */
    tools.elide.data.DataContainerRef.FingerprintPathPair getResource();
    /**
     * <pre>
     * Specifies a reference to a file resident in the application JAR or native image.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair resource = 2;</code>
     */
    tools.elide.data.DataContainerRef.FingerprintPathPairOrBuilder getResourceOrBuilder();

    /**
     * <pre>
     * Specifies a reference to a file resident on the filesystem outside of the built application.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair filesystem = 3;</code>
     * @return Whether the filesystem field is set.
     */
    boolean hasFilesystem();
    /**
     * <pre>
     * Specifies a reference to a file resident on the filesystem outside of the built application.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair filesystem = 3;</code>
     * @return The filesystem.
     */
    tools.elide.data.DataContainerRef.FingerprintPathPair getFilesystem();
    /**
     * <pre>
     * Specifies a reference to a file resident on the filesystem outside of the built application.
     * </pre>
     *
     * <code>.data.DataContainerRef.FingerprintPathPair filesystem = 3;</code>
     */
    tools.elide.data.DataContainerRef.FingerprintPathPairOrBuilder getFilesystemOrBuilder();

    public tools.elide.data.DataContainerRef.ReferenceCase getReferenceCase();
}
