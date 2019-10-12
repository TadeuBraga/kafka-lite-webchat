# kafka-lite-webchat
A real-time stateless webchat, using Vue.js, Spring Boot and Apache Kafka.


## Instalation and Running
### Prerequisites
To start this project you need a [installation of Apache Kafka](https://kafka.apache.org/quickstart) up and running.

### Front-end
Inside litechat-front folder, run the following command to install and run.
```
yarn install
yarn serve
```

It's highly recommended to use yarn instead of NPM.

### Back-end
Inside kafkalitechat you can start the back-end application by running the following command:
```
mvnw spring-boot-run
```

Or executing Spring main class in the root package.

## Development
### Why Kafka
This project uses Apache Kafka to exemplify its utility inside Spring apps, however I totally agree that producer and consumer in the same application aren't useful.

### Built With

* [Apache Kafka](https://spring.io/projects/spring-boot) - A distributed streaming platform
* [Spring and Spring Boot](https://spring.io/projects/spring-boot) - Java back-end set of "tools"
* [Maven](https://maven.apache.org/) - Dependency Management
* [Vue.js](https://vuejs.org/) - Front-end framework 
* [Vuex](https://vuex.vuejs.org/) - State Management 
* [axios](https://github.com/axios/axios) - HTTP Simple Client
* [SockJS and Stomp](https://stomp-js.github.io/guide/stompjs/rx-stomp/ng2-stompjs/2018/09/10/using-stomp-with-sockjs.html) - Socket client libraries.
