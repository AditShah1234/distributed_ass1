# distributed_ass1
# Title / Repository Name
Distriibuted System Assignment 1
## About / Synopsis

* The goal is to create the server which can save audio informations in the i memory database.
* Make a multi threaded client to stress test the server.
* Host the server on the cloud oracle with red hat Linux




## Table of contents



> * [Title / Repository Name](#title--repository-name)
>   * [About / Synopsis](#about--synopsis)
>   * [Table of contents](#table-of-contents)
>   * [Installation](#installation)
>   * [Usage](#usage)
>     * [Screenshots](#screenshots)
>     * [Features](#features)
>   * [Code](#code)
>     * [Content](#content)
>     * [Requirements](#requirements)
>     * [Limitations](#limitations)
>     * [Build](#build)
>     * [Deploy (how to install build product)](#deploy-how-to-install-build-product)
>   * [Resources (Documentation and other links)](#resources-documentation-and-other-links)
>   * [Contributing / Reporting issues](#contributing--reporting-issues)
>   * [License](#license)
>   * [About Nuxeo](#about-nuxeo)

## Installation

Sample:


## Hosting

![Oracle Free Tier](https://www.oracle.com/cloud/free/#always-free)
![Oracle Instance](/screenshot/oracle.png?raw=true "Oracle Instance")
## Run commands
Do ssh to the instance 
```bash
### Clone the code
git clone https://github.com/AditShah1234/distributed_ass1.git
### Install maven
https://devopscube.com/install-maven-guide/


cd ~/distributed_ass1/server

mvn jetty:run
```
## Client run
```bash
git clone https://github.com/AditShah1234/distributed_ass1.git
### Install maven
https://devopscube.com/install-maven-guide/


cd ~/distributed_ass1/client

mvn jetty:run


## Analytics run

```bash
cd ~/distributed_ass1

pip3 install matplotlib
python3 analytic.py


```

### Features

## Code


### Content

Description, sub-modules organization...

### Requirements




### Build

    mvn clean install

Build options:

* ...

### Deploy (how to install build product)

Direct to MP package if any. Otherwise provide steps to deploy on Nuxeo Platform:

 > Copy the built artifacts into `$NUXEO_HOME/templates/custom/bundles/` and activate the `custom` template.

## Resources (Documentation and other links)

## Contributing / Reporting issues

Link to JIRA component (or project if there is no component for that project). Samples:

* [Link to component](https://jira.nuxeo.com/issues/?jql=project%20%3D%20NXP%20AND%20component%20%3D%20Elasticsearch%20AND%20Status%20!%3D%20%22Resolved%22%20ORDER%20BY%20updated%20DESC%2C%20priority%20DESC%2C%20created%20ASC)
* [Link to project](https://jira.nuxeo.com/secure/CreateIssue!default.jspa?project=NXP)

## License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

## About Nuxeo

Nuxeo Platform is an open source Content Services platform, written in Java. Data can be stored in both SQL & NoSQL databases.

The development of the Nuxeo Platform is mostly done by Nuxeo employees with an open development model.

The source code, documentation, roadmap, issue tracker, testing, benchmarks are all public.

Typically, Nuxeo users build different types of information management solutions for [document management](https://www.nuxeo.com/solutions/document-management/), [case management](https://www.nuxeo.com/solutions/case-management/), and [digital asset management](https://www.nuxeo.com/solutions/dam-digital-asset-management/), use cases. It uses schema-flexible metadata & content models that allows content to be repurposed to fulfill future use cases.

More information is available at [www.nuxeo.com](https://www.nuxeo.com).