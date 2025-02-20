/*
 * Copyright (c) 2023 Elide Ventures, LLC.
 *
 * Licensed under the MIT license (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   https://opensource.org/license/mit/
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under the License.
 */

package elide.rpc.server

import io.grpc.ServerBuilder
import io.grpc.ServerServiceDefinition
import io.grpc.health.v1.HealthCheckResponse
import io.grpc.health.v1.HealthGrpc
import io.micronaut.context.BeanContext
import io.micronaut.context.BeanResolutionContext
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.inject.BeanDefinition
import io.micronaut.inject.BeanIdentifier
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

/** Tests for the [GrpcConfigurator]. */
@MicronautTest(startApplication = false)
class GrpcWebConfiguratorTest {
  @Inject lateinit var beanContext: BeanContext
  @Inject internal lateinit var rpcRuntime: RpcRuntime
  @Inject internal lateinit var configurator: GrpcConfigurator
  @Inject internal lateinit var healthManager: ServiceHealthManager

  @Test fun testInitConfigurator() {
    assertNotNull(configurator, "gRPC web configurator should be injectable")
  }

  @Test fun testRpcRuntimeInjectable() {
    assertNotNull(rpcRuntime, "RPC runtime util should be injectable")
  }

  @Test fun testHealthInitialState() {
    assertEquals(
      HealthCheckResponse.ServingStatus.SERVING,
      healthManager.currentStatus(HealthGrpc.getServiceDescriptor()),
      "health service should show as serving immediately upon startup"
    )
  }

  @Test fun testOnServerBuilderCreated() {
    val builder = ServerBuilder.forPort(443)
    builder.addService(ServerServiceDefinition.builder("exampleService")
      .build())

    // build a fake bean event
    val event = BeanCreatedEvent(beanContext, object: BeanDefinition<ServerBuilder<*>> {
      override fun isEnabled(context: BeanContext, resolutionContext: BeanResolutionContext?): Boolean {
        return true
      }

      override fun getBeanType(): Class<ServerBuilder<*>> {
        return ServerBuilder::class.java
      }
    }, BeanIdentifier.of("abc123"), builder)

    // run the `onCreated` event
    configurator.onCreated(
      event
    )

    // services should now be registered with the runtime
    val resolvedSample = rpcRuntime.resolveService(
      "exampleService"
    )
    assertNotNull(
      resolvedSample,
      "should be able to resolve `exampleService` after registration through bean creation observer"
    )
    val resolvedNonExistent = rpcRuntime.resolveService(
      "idonotexist"
    )
    assertNull(
      resolvedNonExistent,
      "resolving a service which does not exist should yield `null`"
    )
  }
}
