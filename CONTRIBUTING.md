# Contributing

> **Note:** This SDK is automatically generated from the Autorender API specification.
> Code pull requests are not accepted — changes to generated code will be overwritten on the next generation cycle.
>
> **Bug reports and feature requests are welcome** — please [open an issue](https://github.com/autorender/autorender-java/issues).

---

## Setting up the environment

This repository uses [Gradle](https://gradle.org/) to manage dependencies and build the project.

To set up and build:

```sh
$ ./gradlew build
```

## Modifying/Adding code

Most of the SDK is generated code. Modifications to code will be persisted between generations, but may
result in merge conflicts between manual patches and changes from the generator.

## Adding and running examples

All files in the `examples/` directory are not modified by the generator and can be freely edited or added to.

## Running tests

Most tests require you to set up a mock server against the OpenAPI spec.

```sh
$ ./scripts/mock
```

```sh
$ ./gradlew test
```

## Publishing and releases

Changes made to this repository via the automated release PR pipeline will publish to Maven Central automatically.
