// File generated from our OpenAPI spec by Stainless.

package io.autorender.services.async

import io.autorender.core.ClientOptions
import io.autorender.core.RequestOptions
import io.autorender.core.http.HttpResponse
import io.autorender.core.http.HttpResponseFor
import io.autorender.models.files.FileDeleteParams
import io.autorender.models.files.FileListPageAsync
import io.autorender.models.files.FileListParams
import io.autorender.models.files.FileRenameParams
import io.autorender.models.files.FileRenameResponse
import io.autorender.models.files.FileRetrieveParams
import io.autorender.models.files.FileRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** File management endpoints (API key required) */
interface FileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync

    /** Get file details */
    fun retrieve(fileNo: String): CompletableFuture<FileRetrieveResponse> =
        retrieve(fileNo, FileRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        fileNo: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRetrieveResponse> =
        retrieve(params.toBuilder().fileNo(fileNo).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        fileNo: String,
        params: FileRetrieveParams = FileRetrieveParams.none(),
    ): CompletableFuture<FileRetrieveResponse> = retrieve(fileNo, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: FileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: FileRetrieveParams): CompletableFuture<FileRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        fileNo: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FileRetrieveResponse> =
        retrieve(fileNo, FileRetrieveParams.none(), requestOptions)

    /** List/search files with pagination, filtering, and sorting. */
    fun list(): CompletableFuture<FileListPageAsync> = list(FileListParams.none())

    /** @see list */
    fun list(
        params: FileListParams = FileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileListPageAsync>

    /** @see list */
    fun list(params: FileListParams = FileListParams.none()): CompletableFuture<FileListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<FileListPageAsync> =
        list(FileListParams.none(), requestOptions)

    /** Delete file */
    fun delete(fileNo: String): CompletableFuture<Void?> = delete(fileNo, FileDeleteParams.none())

    /** @see delete */
    fun delete(
        fileNo: String,
        params: FileDeleteParams = FileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().fileNo(fileNo).build(), requestOptions)

    /** @see delete */
    fun delete(
        fileNo: String,
        params: FileDeleteParams = FileDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(fileNo, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: FileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: FileDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(fileNo: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(fileNo, FileDeleteParams.none(), requestOptions)

    /** Rename file */
    fun rename(fileNo: String, params: FileRenameParams): CompletableFuture<FileRenameResponse> =
        rename(fileNo, params, RequestOptions.none())

    /** @see rename */
    fun rename(
        fileNo: String,
        params: FileRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRenameResponse> =
        rename(params.toBuilder().fileNo(fileNo).build(), requestOptions)

    /** @see rename */
    fun rename(params: FileRenameParams): CompletableFuture<FileRenameResponse> =
        rename(params, RequestOptions.none())

    /** @see rename */
    fun rename(
        params: FileRenameParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FileRenameResponse>

    /** A view of [FileServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): FileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v1/files/{fileNo}`, but is otherwise the same
         * as [FileServiceAsync.retrieve].
         */
        fun retrieve(fileNo: String): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(fileNo, FileRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            fileNo: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(params.toBuilder().fileNo(fileNo).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            fileNo: String,
            params: FileRetrieveParams = FileRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(fileNo, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: FileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: FileRetrieveParams
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            fileNo: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FileRetrieveResponse>> =
            retrieve(fileNo, FileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v1/files`, but is otherwise the same as
         * [FileServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none())

        /** @see list */
        fun list(
            params: FileListParams = FileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>>

        /** @see list */
        fun list(
            params: FileListParams = FileListParams.none()
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FileListPageAsync>> =
            list(FileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /api/v1/files/{fileNo}`, but is otherwise the
         * same as [FileServiceAsync.delete].
         */
        fun delete(fileNo: String): CompletableFuture<HttpResponse> =
            delete(fileNo, FileDeleteParams.none())

        /** @see delete */
        fun delete(
            fileNo: String,
            params: FileDeleteParams = FileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().fileNo(fileNo).build(), requestOptions)

        /** @see delete */
        fun delete(
            fileNo: String,
            params: FileDeleteParams = FileDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(fileNo, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: FileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: FileDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            fileNo: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = delete(fileNo, FileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /api/v1/files/{fileNo}/rename`, but is otherwise
         * the same as [FileServiceAsync.rename].
         */
        fun rename(
            fileNo: String,
            params: FileRenameParams,
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>> =
            rename(fileNo, params, RequestOptions.none())

        /** @see rename */
        fun rename(
            fileNo: String,
            params: FileRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>> =
            rename(params.toBuilder().fileNo(fileNo).build(), requestOptions)

        /** @see rename */
        fun rename(
            params: FileRenameParams
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>> =
            rename(params, RequestOptions.none())

        /** @see rename */
        fun rename(
            params: FileRenameParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FileRenameResponse>>
    }
}
