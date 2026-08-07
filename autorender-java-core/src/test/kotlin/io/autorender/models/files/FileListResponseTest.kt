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
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fileNo("file_no")
                .folderName("folder_name")
                .folderNo("folder_no")
                .format("format")
                .height(-9007199254740991L)
                .metadata(
                    FileListResponse.Metadata.builder()
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

        assertThat(fileListResponse.id()).isEqualTo("id")
        assertThat(fileListResponse.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileListResponse.fileNo()).isEqualTo("file_no")
        assertThat(fileListResponse.folderName()).contains("folder_name")
        assertThat(fileListResponse.folderNo()).contains("folder_no")
        assertThat(fileListResponse.format()).contains("format")
        assertThat(fileListResponse.height()).contains(-9007199254740991L)
        assertThat(fileListResponse.metadata())
            .contains(
                FileListResponse.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(fileListResponse.mimeType()).isEqualTo("mime_type")
        assertThat(fileListResponse.name()).isEqualTo("name")
        assertThat(fileListResponse.path()).isEqualTo("path")
        assertThat(fileListResponse.size()).isEqualTo(-9007199254740991L)
        assertThat(fileListResponse.source()).isEqualTo("source")
        assertThat(fileListResponse.tags()).containsExactly("string")
        assertThat(fileListResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(fileListResponse.url()).isEqualTo("url")
        assertThat(fileListResponse.width()).contains(-9007199254740991L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileListResponse =
            FileListResponse.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fileNo("file_no")
                .folderName("folder_name")
                .folderNo("folder_no")
                .format("format")
                .height(-9007199254740991L)
                .metadata(
                    FileListResponse.Metadata.builder()
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

        val roundtrippedFileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileListResponse),
                jacksonTypeRef<FileListResponse>(),
            )

        assertThat(roundtrippedFileListResponse).isEqualTo(fileListResponse)
    }
}
