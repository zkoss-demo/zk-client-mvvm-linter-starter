# ZK Client MVVM Linter Starter

## Introduction

ZK Client MVVM Linter Starter is the starter project for ZK Client MVVM Linter,
a tool designed for identifying potential compatibility issues in Server MVVM files
before upgrading to Client MVVM.

## Setup and Scan

For a detailed guide on how to set up and run the linter, please refer to our blog post:
[Introducing ZK Client MVVM Linter](https://blog.zkoss.org/2023/08/01/zk-10-preview:-introducing-zk-client-mvvm-linter/).

1. Check `app.properties` in this project
to set your target path for `zulDir`, `javaDir`, and other options
2. Run with `./gradlew runLinter`


## Lint Rules

For a comprehensive list of all lint rules along with their descriptions, please refer to the [RULES.md](RULES.md) file.

## Custom Rules

For a detailed guide on how to create custom lint rules, please refer to our blog post:
[Introducing ZK Client MVVM Linter](https://blog.zkoss.org/2023/08/01/zk-10-preview:-introducing-zk-client-mvvm-linter/).
Additionally, you can find some examples in the `org.zkoss.zklinter.upgrade.rule` package.

## Rules for ZK 10 Upgrade

Since zklinter 10.2.0-Eval, specify `upgradeToVersion` in `app.properties`
to enable the `org.zkoss.zklinter.upgrade.RemovedComponentsAndAttributes` rule,
which scans zul files for removed components and attributes.

If you just want to scan zul for upgrade, you can disable client mvvm related rules:

```properties
disabledRules=org.zkoss.zklinter.impl.rule.*
```

## Limitations

While ZK Client MVVM Linter covers most scenarios, there are still some limitations you should be aware of:

- The linter does not check Xhtml files, only MVVM Zul and ViewModel Java files.
- The linter does not check Java code that is directly embedded into Zul files,
  it is recommended to separately declare each ViewModel in its own Java file.
- The linter does not analyze files that are associated through dynamic path binding.
- The linter does not take the usage of `<alias>` and `ProxyTargetHandler` into account,
  please note that `ProxyTargetHandler` is not supported for Client MVVM.

Thank you for using ZK Client MVVM Linter!

## Use ZK Linter in a Maven Project

If you are using Maven, follow the instructions below:

1. Include the zklinter jar:

```xml
<dependency>
    <groupId>org.zkoss.zk</groupId>
    <artifactId>zklinter</artifactId>
    <version>10.2.0-Eval</version>
</dependency>
```
Check https://mavensync.zkoss.org/eval/org/zkoss/zk/ for the latest version.
2. Add app.properties
3. Run zklinter with exec-maven-plugin:
```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.1.1</version>
    <executions>
        <execution>
            <id>zklinter</id>
            <phase>process-resources</phase>
            <goals>
                <goal>java</goal>
            </goals>
            <configuration>
                <mainClass>org.zkoss.zklinter.App</mainClass>
            </configuration>
        </execution>
    </executions>
</plugin>

```   
Then run the Maven goal below to start scanning:

`mvn process-resources`
