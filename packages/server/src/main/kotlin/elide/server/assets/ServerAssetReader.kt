package elide.server.assets

import io.micronaut.context.annotation.Context
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Deferred

/**
 *
 */
@Context @Singleton
public class ServerAssetReader : AssetReader {
  @Inject internal lateinit var manifestProvider: ServerAssetManifestProvider
  @Inject internal lateinit var assetIndex: ServerAssetIndex

  /** @inheritDoc */
  override suspend fun readAsync(descriptor: ServerAsset): Deferred<RenderedAsset> {
    TODO("Not yet implemented")
  }

  /** @inheritDoc */
  override fun resolve(path: String): ServerAsset? {
    TODO("Not yet implemented")
  }
}
