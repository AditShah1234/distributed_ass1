# Distributed System Assignment 1
## About

* The goal is to create the server which can save audio informations in the in memory database.
* Make a multi threaded client to stress test the server.
* Host the server on the cloud oracle with red hat Linux

## Table of contents

>   * [Title / Repository Name](#title--repository-name)
>   * [About / Synopsis](#about--synopsis)
>   * [Table of contents](#table-of-contents)
>   * [Install Server](#Installatio--Server)
>   * [Install Client](#Installation--Client)
>   * [Swagger](#Swagger)
>   * [Results](#Results)

## Installation Server
Make a cloud instance on https://www.oracle.com/cloud/free/#always-free
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
## Installation Client
```bash
git clone https://github.com/AditShah1234/distributed_ass1.git
### Install maven
https://devopscube.com/install-maven-guide/


cd ~/distributed_ass1/client

mvn jetty:run
```

## Analytics

```bash
cd ~/distributed_ass1

pip3 install matplotlib
python3 analytic.py


```
## Swagger
Go on bellow link for sample implimentation
https://app.swaggerhub.com/apis-docs/ASHAH9497/Assignment1/1.0.0

## Results

![Analysis](/screenshot/2_1.png?raw=true)
![Analysis](/screenshot/5_1.png?raw=true)
![Analysis](/screenshot/10_1.png?raw=true)
![Analysis](/screenshot/2d_1.png?raw=true)
![Analysis](/screenshot/3d_1.png?raw=true)
![Analysis](/screenshot/2_2.png?raw=true)
![Analysis](/screenshot/5_2.png?raw=true)
![Analysis](/screenshot/10_2.png?raw=true)
![Analysis](/screenshot/2d_2.png?raw=true)
![Analysis](/screenshot/3d_2.png?raw=true)

## References: 

https://github.com/youyinnn/distributed_system_jetty_helloworld 

https://www.tutorialspoint.com/servlets/index.htm 

https://swagger.io/docs/specification/describing-parameters/ 

https://www.youtube.com/watch?v=TCd8QIS-2KI ; 

 