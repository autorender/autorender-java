// File generated from our OpenAPI spec by Stainless.

package io.autorender.models.files

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.autorender.core.JsonValue
import io.autorender.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListResponseTest {

    @Test
    fun create() {
        val fileListResponse =
            FileListResponse.builder()
                .addFile(
                    FileListResponse.File.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .fileNo("file_no")
                        .folderName("folder_name")
                        .folderNo("folder_no")
                        .format("format")
                        .height(-9007199254740991L)
                        .metadata(
                            FileListResponse.File.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .mimeType("mime_type")
                        .name("name")
                        .path("path")
                        .size(-9007199254740991L)
                        .source("source")
                        .addTag("string")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .width(-9007199254740991L)
                        .build()
                )
                .meta(
                    FileListResponse.Meta.builder()
                        .hasNext(true)
                        .hasPrev(true)
                        .limit(-9007199254740991L)
                        .page(-9007199254740991L)
                        .total(-9007199254740991L)
                        .build()
                )
                .build()

        assertThat(fileListResponse.files())
            .containsExactly(
                FileListResponse.File.builder()
                    .id("id")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .fileNo("file_no")
                    .folderName("folder_name")
                    .folderNo("folder_no")
                    .format("format")
                    .height(-9007199254740991L)
                    .metadata(
                        FileListResponse.File.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .mimeType("mime_type")
                    .name("name")
                    .path("path")
                    .size(-9007199254740991L)
                    .source("source")
                    .addTag("string")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .url("url")
                    .width(-9007199254740991L)
                    .build()
            )
        assertThat(fileListResponse.meta())
            .isEqualTo(
                FileListResponse.Meta.builder()
                    .hasNext(true)
                    .hasPrev(true)
                    .limit(-9007199254740991L)
                    .page(-9007199254740991L)
                    .total(-9007199254740991L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListResponse =
            FileListResponse.builder()
                .addFile(
                    FileListResponse.File.builder()
                        .id("id")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .fileNo("file_no")
                        .folderName("folder_name")
                        .folderNo("folder_no")
                        .format("format")
                        .height(-9007199254740991L)
                        .metadata(
                            FileListResponse.File.Metadata.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .mimeType("mime_type")
                        .name("name")
                        .path("path")
                        .size(-9007199254740991L)
                        .source("source")
                        .addTag("string")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .url("url")
                        .width(-9007199254740991L)
                        .build()
                )
                .meta(
                    FileListResponse.Meta.builder()
                        .hasNext(true)
                        .hasPrev(true)
                        .limit(-9007199254740991L)
                        .page(-9007199254740991L)
                        .total(-9007199254740991L)
                        .build()
                )
                .build()

        val roundtrippedFileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListResponse),
                jacksonTypeRef<FileListResponse>(),
            )

        assertThat(roundtrippedFileListResponse).isEqualTo(fileListResponse)
    }
}
