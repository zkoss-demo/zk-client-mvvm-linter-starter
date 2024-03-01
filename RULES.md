# ZK Client MVVM Lint Rules

## General
| Code             | Description                                                                                                                                                                                |
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| WarnUncheckedZul | Zul file path evaluated at runtime using `${...}` or `@(...)` is not checked, please supply the path as a constant string (e.g. `src="/dir/file.zul"`)                                     |
| WarnUncheckedVM  | ViewModel `@id('vm') @init(...)` is not checked because it's not a fully-qualified class name, please move the Java code to a separate Java file and supply its fully-qualified class name |

## Zul Rules

### Binding
| Code                | Description                                                                                                                               | 
|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| ModelELBinding      | Client MVVM doesn't support EL `model="${...}"` with data binding `@init/load/save/bind(...)`, please continue using server MVVM          |
| ItemRendererBinding | Client MVVM doesn't support server-side ItemRenderer `itemRenderer="@init/load/save/bind(...)"`, please use `<template>` instead          |
| PaginalBinding      | Client MVVM doesn't support server-side Paginal `paginal="@init/load/save/bind(...)"`, please continue using server MVVM                  |
| OnEvent             | Client MVVM doesn't support adding event listeners in zscript `onXXX="..."`, please use a command binding `onXXX="@command(...)"` instead |

### Component
| Name                | Description                                                                                                                                                                                | 
|---------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| SortAttribute       | Client MVVM doesn't support `sort` attribute, please continue using Server MVVM                                                                                                            |
| FragmentComponent   | Client MVVM doesn't support `<fragment>`, please refer to [the HTML Tags page](https://www.zkoss.org/wiki/ZK_Developer%27s_Reference/UI_Patterns/HTML_Tags) for alternatives               |
| TemplateOutsideMVVM | Client MVVM doesn't support `<template>` outside root view component, please move it to become a descendant of the root view component (i.e. the component with the `viewModel` attribute) |

## Java Rules

### Annotation
| Name          | Description                                                                                                                                                                                                                             | 
|---------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BindingParam  | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support using `@BindingParam Component c` or `@BindingParam Event e` with `e.getTarget()` to get components, please change the usage or continue using server MVVM |
| ContextParam  | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support using `@ContextParam(ContextType.BINDER/COMPONENT)` to get binder/components, please change the usage or continue using server MVVM                        |
| Listen        | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support MVC `@Listen`, please use a command binding `onXXX="@command(...)"` in the Zul file instead                                                                |
| SelectorParam | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support `@SelectorParam`, please change the usage or continue using server MVVM                                                                                    |
| Wire          | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support `@Wire`, please change the usage or continue using server MVVM                                                                                             |
| WireVariable  | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support `@WireVariable`, please change the usage or continue using server MVVM                                                                                     |

### Class
| Name           | Description                                                                                                                                  | 
|----------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| AnnotateBinder | Client MVVM doesn't support binder class customization by extending `AnnotateBinder`, and this feature is not recommended for app developers |

### Method
| Name             | Description                                                                                                                                                                                                                                   | 
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| CreateComponents | To ensure the decoupling of ViewModel from View, Client MVVM doesn't support `Executions.createComponents(...)`, please change the usage or continue using server MVVM                                                                        |
| PureGetter       | In Client MVVM, getters must be pure, meaning they should only contain a simple return statement without any calculation or manipulation logic, please ensure your getter returns a literal, identifier, or another getter's result directly) |

### Type
| Name                | Description                                                                                                                                 | 
|---------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| FormLegacy          | Client MVVM doesn't support `FormLegacy`, please use `Form` instead                                                                         |
| ConverterCastObject | In Client MVVM, `Converter` must not cast an `Object` type parameter to another type, please change the usage or continue using server MVVM |