# Read Me First
The following was discovered as part of building this project:

* The original package name uses 'br.com.solucitiva.apisecurity' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [ModelMapper](http://modelmapper.org/)

### Guides
The following guides illustrate how to use some features in your localhost:

* [Finding user by id](http://localhost:8080/user/1)
  ```
  localhost:8080\users\{1}  
  ```
* [Insert user](http://localhost:8080/user/)
  ```
  //fase de testes
  {
    "name" : "Bob Mandela",
    "email": "bob@myemail.com",
    "cpf" : "11122233356"
    "password" : "123"
  }
  
  //retorno
  {
    "name" : "Bob Mandela",
    "email": "bob@myemail.com"
  }
  ```

### Concluding Remarks  

* API is not ready yet
* Every day we work in that, we hope to be stay ready soon.