# Atripiera recruitment task

### Acceptance criteria:

As an api consumer, given username and header “Accept: application/json”, I would like to list all his github repositories, which are not forks. Information, which I require in the response, is:



Repository Name

Owner Login

For each branch it’s name and last commit sha



As an api consumer, given not existing github user, I would like to receive 404 response in such a format:
```json
{
  "status": ${responseCode}
  "message": ${whyHasItHappened}
}
```


## API Usage

### Endpoint
```bash
GET localhost:8080/repositories/{username}
Accept: application/json
```

#### Excample:
```bash
GET localhost:8080/repositories/Notosik
Accept: application/json
```

#### Response DTO
```json
{
  "repositories": [
    {
      "ownerLogin": "Notosik",
      "repositoryName": "atipera-recruitment",
      "branches": [
        {
          "name": "main",
          "lastCommitSha": "059eb54e63e7a9904c0c5a9026f69e05aecf0aea"
        }
      ]
    }
  ]
}
```

In case of incorrect username or exceeded request limit from github side we will receive model:

```java
record ApiError(Integer status, String message){}
```


## What could be done in addition
1. GitHub Authentication
2. Handling remaining exceptions uniformly, ensuring they return an `ApiError` model consistently
3. Write much more tests. For feign client using for example WireMock
4. In case of an increasing number of endpoints, Swagger could be added
5. There also more logs could be added
