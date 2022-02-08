# Countries reactive REST API

![example workflow](https://github.com/ybarhoush/country-service/actions/workflows/main.yml/badge.svg)

Reactive REST web service; fetches the relevant information for countries from the following service: https://countriesnow.space/

Uses:
* JDK v11.0.13
* Spring Boot v2.6.3

```
GET /countries/
response:
          {
                   [
                             {
                                       "name": "Finland",
                                       "country_code": "FI"
                             },
                             ...
                   ]
          }
GET /countries/{name}
response:
          {
                   "name": "Finland",
                   "country_code": "FI",
                   "capital": "Helsinki",
                   "population": 5491817,
                   "flag_file_url": "<url to the flag file>"
          }
 ```
 
## Application running

It is possible to run the application in different ways:
* using Spring Boot Maven Plugin
* creating a jar bundle and running it with java

### Spring Boot Maven Plugin

To run the application using Spring Boot Maven plugin, it is sufficient to run the following command using Maven wrapper available with this project:
```
./mvnw spring-boot:run
```

### Running with Java

To run the application using java, firstly you need to create a jar bundle using Maven:
```
./mvnw clean package
```

And then:
```
java -jar .\target\country-service-0.0.1-SNAPSHOT.jar
```

## Testing

Both unit and integration tests are included.

To run unit tests:
```
./mvnw test
```

## Continuous Integration

Automatic build and testing is configured using Github Actions.
