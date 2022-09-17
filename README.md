# wonderland-scala-katas

Scala version of [wonderland-clojure-katas](https://github.com/Rafailong/wonderland-clojure-katas)

## Requirements

This repo is not a scala project in the senses of being based on the usage of
sbt or mill or any other similar tool to those aforementioned.

I decided to go with [scala-cli](https://scala-cli.virtuslab.org)
for the sake of simplicity.

### Running

There are no `main` function in this project, meaning it is not executable.
Although, every kata has its own test suit.

- `test.bash`: runs all tests
- to run an specific kata' tests: `scala-cli test {kata-directory}`