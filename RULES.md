# ZK Client MVVM Lint Rules

## Zul Rules

### Binding
| Code                | Description                                                       | 
|---------------------|-------------------------------------------------------------------|
| ModelElExpression   | `model="${...}"` not supported, use `model="@init(...)"` instead  |
| ItemRendererBinding | `itemRenderer="@init/load/save/bind(...)"` not supported          |
| PaginalBinding      | `paginal="@init/load/save/bind(...)"` not supported               |
| OnEvent             | `onXXX="..."` should be `@command(...)` or `@global-command(...)` |

### Component
| Name                | Description                        | 
|---------------------|------------------------------------|
| Sort                | `sort="..."` not supported         |
| FragmentComponent   | `<fragment>` not supported         |
| TemplateOutsideMVVM | `<template>` should be inside MVVM |

## Java Rules

### Annotation
| Name          | Description                                                                   | 
|---------------|-------------------------------------------------------------------------------|
| BindingParam  | `@BindingParam Component` and `@BindingParam Event getTarget()` not supported |
| ContextParam  | `@ContextParam(ContextType.COMPONENT and ContextType.BINDER)` not supported   |
| Listen        | `@Listen` not supported                                                       |
| SelectorParam | `@SelectorParam` not supported                                                |
| Wire          | `@Wire` not supported                                                         |
| WireVariable  | `@WireVariable` not supported                                                 |

### Class
| Name           | Description                                            | 
|----------------|--------------------------------------------------------|
| AnnotateBinder | Custom Binder extending `AnnotateBinder` not supported |

### Method
| Name             | Description                                      | 
|------------------|--------------------------------------------------|
| CreateComponents | `Executions.createComponents(...)` not supported |
| PureGetter       | Getter should be pure                            |

### Type
| Name              | Description                         | 
|-------------------|-------------------------------------|
| FormLegacy        | `FormLegacy` not supported          |
| ObjectTypeCasting | `Object` type casting not supported |