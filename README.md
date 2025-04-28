# nuxeo-custom-service-startup-event


## About / Synopsis

This plugin demonstrates how to implement a new service that produces an event named `nuxeoPlatformStarted` when the **Nuxeo Platform** is started. This allows you to e.g. define an **event handler** that is triggered by the event when the **Nuxeo Platform** is up and running.

It was generated with the following commands:
```
mkdir nuxeo-custom-service-startup-event && cd $_
nuxeo bootstrap multi-module
nuxeo bootstrap service
# Edit service's XML file and java classes
mvn clean package

nuxeo b package
mvn install
```

## Table of contents

> * [nuxeo-custom-service-startup-event](#nuxeo-custom-service-startup-event)
>   * [About / Synopsis](#about--synopsis)
>   * [Table of contents](#table-of-contents)
>   * [Installation](#installation)
>   * [Requirements](#requirements)
>   * [Build](#build)
>   * [License](#license)
>   * [About Hyland Nuxeo](#about-hyland-nuxeo)

## Requirements

Building requires the following software:

* git
* maven

## Build

```
git clone ...
cd nuxeo-custom-service-startup-event

mvn clean install
```

## Installation

```
nuxeoctl mp-install nuxeo-custom-service-startup-event/nuxeo-custom-service-startup-event-package/target/nuxeo-custom-service-startup-event-*.zip
```

## Support

**These features are not part of the Nuxeo Production platform, they are not supported**

These solutions are provided for inspiration and we encourage customers to use them as code samples and learning resources.

This is a moving project (no API maintenance, no deprecation process, etc.) If any of these solutions are found to be useful for the Nuxeo Platform in general, they will be integrated directly into platform, not maintained here.

## License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

## About Hyland Nuxeo

Nuxeo Platform is an open source Content Services platform, written in Java. Data can be stored in both SQL & NoSQL databases.

The development of the Nuxeo Platform is mostly done by Nuxeo employees with an open development model.

The source code, documentation, roadmap, issue tracker, testing, benchmarks are all public.

Typically, Nuxeo users build different types of information management solutions for [document management](https://www.nuxeo.com/solutions/document-management/), [case management](https://www.nuxeo.com/solutions/case-management/), and [digital asset management](https://www.nuxeo.com/solutions/dam-digital-asset-management/), use cases. It uses schema-flexible metadata & content models that allows content to be repurposed to fulfill future use cases.

More information is available at [www.nuxeo.com](https://www.nuxeo.com).

