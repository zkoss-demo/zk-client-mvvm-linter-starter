# ZK Client MVVM Linter Starter

## Introduction

ZK Client MVVM Linter Starter is the starter project for ZK Client MVVM Linter,
a tool designed for identifying potential compatibility issues in Server MVVM files
before upgrading to Client MVVM.

## Setup and Execution

For a detailed guide on how to set up and run the linter, please refer to our blog post:
[Introducing ZK Client MVVM Linter](https://blog.zkoss.org/2023/08/01/zk-10-preview:-introducing-zk-client-mvvm-linter/).

1. check `app.properties` in this project
set your target path for `zulDir`, `javaDir`, and other options
1. `gradlew runLinter`
 
## Lint Rules

For a comprehensive list of all lint rules along with their descriptions, please refer to the [RULES.md](RULES.md) file.

## Custom Rules

For a detailed guide on how to create custom lint rules, please refer to our blog post:
[Introducing ZK Client MVVM Linter](https://blog.zkoss.org/2023/08/01/zk-10-preview:-introducing-zk-client-mvvm-linter/).
Additionally, you can find some examples in the `org.zkoss.zklinter.impl.rule` package.

## Limitations

While ZK Client MVVM Linter covers most scenarios, there are still some limitations you should be aware of:

- The linter does not check Xhtml files, only MVVM Zul and ViewModel Java files.
- The linter does not check Java code that is directly embedded into Zul files,
  it is recommended to separately declare each ViewModel in its own Java file.
- The linter does not analyze files that are associated through dynamic path binding.
- The linter does not take the usage of `<alias>` and `ProxyTargetHandler` into account,
  please note that `ProxyTargetHandler` is not supported for Client MVVM.

Thank you for using ZK Client MVVM Linter!
