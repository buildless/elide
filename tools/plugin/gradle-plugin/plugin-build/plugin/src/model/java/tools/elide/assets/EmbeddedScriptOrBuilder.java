// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: elide/assets/embedded.proto

package tools.elide.assets;

public interface EmbeddedScriptOrBuilder
    extends
        // @@protoc_insertion_point(interface_extends:assets.EmbeddedScript)
        com.google.protobuf.MessageOrBuilder {
    /**
     * <pre>
     * Module name / ID for this embedded script. Set at build time.
     * </pre>
     *
     * <code>string module = 1;</code>
     * @return The module.
     */
    java.lang.String getModule();
    /**
     * <pre>
     * Module name / ID for this embedded script. Set at build time.
     * </pre>
     *
     * <code>string module = 1;</code>
     * @return The bytes for module.
     */
    com.google.protobuf.ByteString getModuleBytes();

    /**
     * <pre>
     * Filename, or some synthesized filename, for this script.
     * </pre>
     *
     * <code>string filename = 2;</code>
     * @return The filename.
     */
    java.lang.String getFilename();
    /**
     * <pre>
     * Filename, or some synthesized filename, for this script.
     * </pre>
     *
     * <code>string filename = 2;</code>
     * @return The bytes for filename.
     */
    com.google.protobuf.ByteString getFilenameBytes();

    /**
     * <pre>
     * Language of the embedded script, and expected interpreted language.
     * </pre>
     *
     * <code>.assets.EmbeddedScriptLanguage language = 3;</code>
     * @return The enum numeric value on the wire for language.
     */
    int getLanguageValue();
    /**
     * <pre>
     * Language of the embedded script, and expected interpreted language.
     * </pre>
     *
     * <code>.assets.EmbeddedScriptLanguage language = 3;</code>
     * @return The language.
     */
    tools.elide.assets.EmbeddedScriptLanguage getLanguage();

    /**
     * <pre>
     * Embedded script-level metadata, including language-specific metadata.
     * </pre>
     *
     * <code>.assets.EmbeddedScriptMetadata metadata = 4;</code>
     * @return Whether the metadata field is set.
     */
    boolean hasMetadata();
    /**
     * <pre>
     * Embedded script-level metadata, including language-specific metadata.
     * </pre>
     *
     * <code>.assets.EmbeddedScriptMetadata metadata = 4;</code>
     * @return The metadata.
     */
    tools.elide.assets.EmbeddedScriptMetadata getMetadata();
    /**
     * <pre>
     * Embedded script-level metadata, including language-specific metadata.
     * </pre>
     *
     * <code>.assets.EmbeddedScriptMetadata metadata = 4;</code>
     */
    tools.elide.assets.EmbeddedScriptMetadataOrBuilder getMetadataOrBuilder();

    /**
     * <pre>
     * Last-modified timestamp for the assets underlying this script.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp last_modified = 5;</code>
     * @return Whether the lastModified field is set.
     */
    boolean hasLastModified();
    /**
     * <pre>
     * Last-modified timestamp for the assets underlying this script.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp last_modified = 5;</code>
     * @return The lastModified.
     */
    com.google.protobuf.Timestamp getLastModified();
    /**
     * <pre>
     * Last-modified timestamp for the assets underlying this script.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp last_modified = 5;</code>
     */
    com.google.protobuf.TimestampOrBuilder getLastModifiedOrBuilder();

    /**
     * <pre>
     * Unique set of direct dependencies for this embedded script asset; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string direct_dependency = 6;</code>
     * @return A list containing the directDependency.
     */
    java.util.List<java.lang.String> getDirectDependencyList();
    /**
     * <pre>
     * Unique set of direct dependencies for this embedded script asset; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string direct_dependency = 6;</code>
     * @return The count of directDependency.
     */
    int getDirectDependencyCount();
    /**
     * <pre>
     * Unique set of direct dependencies for this embedded script asset; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string direct_dependency = 6;</code>
     * @param index The index of the element to return.
     * @return The directDependency at the given index.
     */
    java.lang.String getDirectDependency(int index);
    /**
     * <pre>
     * Unique set of direct dependencies for this embedded script asset; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string direct_dependency = 6;</code>
     * @param index The index of the value to return.
     * @return The bytes of the directDependency at the given index.
     */
    com.google.protobuf.ByteString getDirectDependencyBytes(int index);

    /**
     * <pre>
     * Unique transitive closure of all dependencies this module relies upon; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string transitive_dependency = 7;</code>
     * @return A list containing the transitiveDependency.
     */
    java.util.List<java.lang.String> getTransitiveDependencyList();
    /**
     * <pre>
     * Unique transitive closure of all dependencies this module relies upon; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string transitive_dependency = 7;</code>
     * @return The count of transitiveDependency.
     */
    int getTransitiveDependencyCount();
    /**
     * <pre>
     * Unique transitive closure of all dependencies this module relies upon; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string transitive_dependency = 7;</code>
     * @param index The index of the element to return.
     * @return The transitiveDependency at the given index.
     */
    java.lang.String getTransitiveDependency(int index);
    /**
     * <pre>
     * Unique transitive closure of all dependencies this module relies upon; expected to be other, compatible embedded
     * scripts (same language, same runtime level). Expressed as a `module` ID.
     * </pre>
     *
     * <code>repeated string transitive_dependency = 7;</code>
     * @param index The index of the value to return.
     * @return The bytes of the transitiveDependency at the given index.
     */
    com.google.protobuf.ByteString getTransitiveDependencyBytes(int index);

    /**
     * <pre>
     * Describes the raw data for the script content itself, plus a digest of the data for verification purposes; the
     * digest payload additionally specifies the algorithm used.
     * </pre>
     *
     * <code>.data.DataContainerRef script = 8;</code>
     * @return Whether the script field is set.
     */
    boolean hasScript();
    /**
     * <pre>
     * Describes the raw data for the script content itself, plus a digest of the data for verification purposes; the
     * digest payload additionally specifies the algorithm used.
     * </pre>
     *
     * <code>.data.DataContainerRef script = 8;</code>
     * @return The script.
     */
    tools.elide.data.DataContainerRef getScript();
    /**
     * <pre>
     * Describes the raw data for the script content itself, plus a digest of the data for verification purposes; the
     * digest payload additionally specifies the algorithm used.
     * </pre>
     *
     * <code>.data.DataContainerRef script = 8;</code>
     */
    tools.elide.data.DataContainerRefOrBuilder getScriptOrBuilder();

    /**
     * <pre>
     * Source-map file path for the embedded script, if generated as an external file.
     * </pre>
     *
     * <code>.data.DataContainerRef sourcemap = 9;</code>
     * @return Whether the sourcemap field is set.
     */
    boolean hasSourcemap();
    /**
     * <pre>
     * Source-map file path for the embedded script, if generated as an external file.
     * </pre>
     *
     * <code>.data.DataContainerRef sourcemap = 9;</code>
     * @return The sourcemap.
     */
    tools.elide.data.DataContainerRef getSourcemap();
    /**
     * <pre>
     * Source-map file path for the embedded script, if generated as an external file.
     * </pre>
     *
     * <code>.data.DataContainerRef sourcemap = 9;</code>
     */
    tools.elide.data.DataContainerRefOrBuilder getSourcemapOrBuilder();
}
