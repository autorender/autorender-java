// File generated from our OpenAPI spec by Stainless.

package io.autorender.services

import com.github.tomakehurst.wiremock.client.WireMock.aMultipart
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import io.autorender.client.AutorenderClient
import io.autorender.client.okhttp.AutorenderOkHttpClient
import io.autorender.core.JsonValue
import io.autorender.models.files.FileListParams
import io.autorender.models.uploads.UploadCreateParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: AutorenderClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            AutorenderOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun create() {
        val uploadService = client.uploads()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        uploadService.create(
            UploadCreateParams.builder()
                .file("Example data".byteInputStream())
                .fileName("product.jpg")
                .customId("sku123")
                .folder("products/sku123")
                .metadata("{\"productId\":\"123\"}")
                .randomPrefix("random_prefix")
                .tags("product,thumbnail")
                .transform("transform")
                .webhookUrl("webhook_url")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withAnyRequestBodyPart(
                    aMultipart().withName("secretProperty").withBody(equalTo("42"))
                )
        )
    }

    @Test
    fun list() {
        val fileService = client.files()
        stubFor(get(anyUrl()).willReturn(ok("{}")))

        fileService.list(
            FileListParams.builder()
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .build()
        )

        verify(
            getRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
        )
    }
}
