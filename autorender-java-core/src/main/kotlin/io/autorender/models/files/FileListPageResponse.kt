// File generated from our OpenAPI spec by Stainless.

package io.autorender.models.files

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.autorender.core.ExcludeMissing
import io.autorender.core.JsonField
import io.autorender.core.JsonMissing
import io.autorender.core.JsonValue
import io.autorender.core.checkKnown
import io.autorender.core.checkRequired
import io.autorender.core.toImmutable
import io.autorender.errors.AutorenderInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Files list */
class FileListPageResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val files: JsonField<List<FileListResponse>>,
    private val meta: JsonField<Meta>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("files")
        @ExcludeMissing
        files: JsonField<List<FileListResponse>> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
    ) : this(files, meta, mutableMapOf())

    /**
     * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun files(): List<FileListResponse> = files.getRequired("files")

    /**
     * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun meta(): Meta = meta.getRequired("meta")

    /**
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<FileListResponse>> = files

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileListPageResponse].
         *
         * The following fields are required:
         * ```java
         * .files()
         * .meta()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileListPageResponse]. */
    class Builder internal constructor() {

        private var files: JsonField<MutableList<FileListResponse>>? = null
        private var meta: JsonField<Meta>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(fileListPageResponse: FileListPageResponse) = apply {
            files = fileListPageResponse.files.map { it.toMutableList() }
            meta = fileListPageResponse.meta
            additionalProperties = fileListPageResponse.additionalProperties.toMutableMap()
        }

        fun files(files: List<FileListResponse>) = files(JsonField.of(files))

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed `List<FileListResponse>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun files(files: JsonField<List<FileListResponse>>) = apply {
            this.files = files.map { it.toMutableList() }
        }

        /**
         * Adds a single [FileListResponse] to [files].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFile(file: FileListResponse) = apply {
            files =
                (files ?: JsonField.of(mutableListOf())).also { checkKnown("files", it).add(file) }
        }

        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [FileListPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .files()
         * .meta()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileListPageResponse =
            FileListPageResponse(
                checkRequired("files", files).map { it.toImmutable() },
                checkRequired("meta", meta),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws AutorenderInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): FileListPageResponse = apply {
        if (validated) {
            return@apply
        }

        files().forEach { it.validate() }
        meta().validate()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: AutorenderInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0)

    class Meta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hasNext: JsonField<Boolean>,
        private val hasPrev: JsonField<Boolean>,
        private val limit: JsonField<Long>,
        private val page: JsonField<Long>,
        private val total: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hasNext") @ExcludeMissing hasNext: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("hasPrev") @ExcludeMissing hasPrev: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("page") @ExcludeMissing page: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        ) : this(hasNext, hasPrev, limit, page, total, mutableMapOf())

        /**
         * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasNext(): Boolean = hasNext.getRequired("hasNext")

        /**
         * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasPrev(): Boolean = hasPrev.getRequired("hasPrev")

        /**
         * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun limit(): Long = limit.getRequired("limit")

        /**
         * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun page(): Long = page.getRequired("page")

        /**
         * @throws AutorenderInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun total(): Long = total.getRequired("total")

        /**
         * Returns the raw JSON value of [hasNext].
         *
         * Unlike [hasNext], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasNext") @ExcludeMissing fun _hasNext(): JsonField<Boolean> = hasNext

        /**
         * Returns the raw JSON value of [hasPrev].
         *
         * Unlike [hasPrev], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hasPrev") @ExcludeMissing fun _hasPrev(): JsonField<Boolean> = hasPrev

        /**
         * Returns the raw JSON value of [limit].
         *
         * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

        /**
         * Returns the raw JSON value of [page].
         *
         * Unlike [page], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Long> = page

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Meta].
             *
             * The following fields are required:
             * ```java
             * .hasNext()
             * .hasPrev()
             * .limit()
             * .page()
             * .total()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var hasNext: JsonField<Boolean>? = null
            private var hasPrev: JsonField<Boolean>? = null
            private var limit: JsonField<Long>? = null
            private var page: JsonField<Long>? = null
            private var total: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                hasNext = meta.hasNext
                hasPrev = meta.hasPrev
                limit = meta.limit
                page = meta.page
                total = meta.total
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            fun hasNext(hasNext: Boolean) = hasNext(JsonField.of(hasNext))

            /**
             * Sets [Builder.hasNext] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNext] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNext(hasNext: JsonField<Boolean>) = apply { this.hasNext = hasNext }

            fun hasPrev(hasPrev: Boolean) = hasPrev(JsonField.of(hasPrev))

            /**
             * Sets [Builder.hasPrev] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasPrev] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasPrev(hasPrev: JsonField<Boolean>) = apply { this.hasPrev = hasPrev }

            fun limit(limit: Long) = limit(JsonField.of(limit))

            /**
             * Sets [Builder.limit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

            fun page(page: Long) = page(JsonField.of(page))

            /**
             * Sets [Builder.page] to an arbitrary JSON value.
             *
             * You should usually call [Builder.page] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun page(page: JsonField<Long>) = apply { this.page = page }

            fun total(total: Long) = total(JsonField.of(total))

            /**
             * Sets [Builder.total] to an arbitrary JSON value.
             *
             * You should usually call [Builder.total] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun total(total: JsonField<Long>) = apply { this.total = total }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNext()
             * .hasPrev()
             * .limit()
             * .page()
             * .total()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Meta =
                Meta(
                    checkRequired("hasNext", hasNext),
                    checkRequired("hasPrev", hasPrev),
                    checkRequired("limit", limit),
                    checkRequired("page", page),
                    checkRequired("total", total),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws AutorenderInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            hasNext()
            hasPrev()
            limit()
            page()
            total()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: AutorenderInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (hasNext.asKnown().isPresent) 1 else 0) +
                (if (hasPrev.asKnown().isPresent) 1 else 0) +
                (if (limit.asKnown().isPresent) 1 else 0) +
                (if (page.asKnown().isPresent) 1 else 0) +
                (if (total.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Meta &&
                hasNext == other.hasNext &&
                hasPrev == other.hasPrev &&
                limit == other.limit &&
                page == other.page &&
                total == other.total &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hasNext, hasPrev, limit, page, total, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{hasNext=$hasNext, hasPrev=$hasPrev, limit=$limit, page=$page, total=$total, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileListPageResponse &&
            files == other.files &&
            meta == other.meta &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(files, meta, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FileListPageResponse{files=$files, meta=$meta, additionalProperties=$additionalProperties}"
}
