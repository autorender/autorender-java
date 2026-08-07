// File generated from our OpenAPI spec by Stainless.

package io.autorender.services.async

import io.autorender.TestServerExtension
import io.autorender.client.okhttp.AutorenderOkHttpClientAsync
import io.autorender.models.files.FileRenameParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class FileServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            AutorenderOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val fileFuture = fileServiceAsync.retrieve("fileNo")

        val file = fileFuture.get()
        file.validate()
    }

    @Test
    fun list() {
        val client =
            AutorenderOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val pageFuture = fileServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            AutorenderOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val future = fileServiceAsync.delete("fileNo")

        val response = future.get()
    }

    @Test
    fun rename() {
        val client =
            AutorenderOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val fileServiceAsync = client.files()

        val responseFuture =
            fileServiceAsync.rename(
                FileRenameParams.builder().fileNo("fileNo").name("name").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
