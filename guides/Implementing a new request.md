# Implementing a new request

#### Prerequisite: [Instagram request capturing](Instagram%20request%20capturing.md)

We have to experiment and see the least amount of data we need to send in order to get a proper response, here we had to send no more than the default headers and no body at all.
So let's move on to write the code for this. All requests are implemented in the `requests` directory and this is an `accounts` request so we'll go into that sub-directory and add the request.

`JIA/lib/src/main/java/io/github/taz03/jia/requests/accounts/CurrentUserRequest.java`
```java
// Extend `InstagramGetRequest` because it was a GET request,
// and use `UserResponse` as response because that is what it responds,
// we might need to create custom responses stitching multiple models together in some cases
public final class CurrentUserRequest extends InstagramGetRequest<UserResponse> {
    public CurrentUserRequest() {
        // Here we are just configuring in the URL because the body was empty and
        // there are no more headers to add other than the default ones
        super(UserResponse.class, "/api/v1/accounts/current_user/");
    }
}
```
