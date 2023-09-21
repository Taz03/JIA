# Summary
Thanks for taking the time to contribute to this project.
Index:-
- [How to track and add new Instagram requests](#how-to-track-and-add-new-instagram-requests)
- [Code Guidelines](#code-guidelines)

## How to track and add new Instagram requests
First, you must set up Instagram SSL pinning bypass to see the requests sent by the Instagram mobile app, [guide here](https://github.com/Eltion/Instagram-SSL-Pinning-Bypass).

![image](https://github.com/Taz03/JIA/assets/73871477/62e57422-8912-48ea-9b0a-7272c165a41e)
Then you should see all the requests going out in real-time, and here you can see what action leads to which requests are being sent.

Then you will need to replicate that request for example, let's try to replicate the `/accounts/current_user` GET request.

![image](https://github.com/Taz03/JIA/assets/73871477/7b02b0f1-a8ec-44e8-ac92-eb120094c10b)
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
We also have to add integration test for every new added request.

## Code Guidelines

#### Formatting
Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html), see other bits of the code base, and write consistent code.

#### Import Order
All the static imports should be at the top without any new lines between them in this order:-
- java
- javax
- internal
- external

Without any empty lines in between.

After all the static imports there should be a line break.
And then all other imports in this order:-
- java
- javax
- internal
- external lib 1
- external lib 2
- ...

After each group there should be an empty line.

Example:-
```java
import static java.lang.Math.*; // All the java static imports
import static io.github.taz03.jia.utils.UrlUtils.*; // All the internal static imports
import static org.junit.jupiter.api.Assertions.assertEquals; // All the external static imports

import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import io.github.taz03.jia.requests.InstagramRequest;
import io.github.taz03.jia.requests.accounts.LoginRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
```

#### Docs
```java
    /**
     * Description of the method.
     *
     * @param param1    Description of param1
     * @param param2    Description of param1
     * @param longParam Description of longParam
     */
```

#### Curly Braces
If the logic is in single don't use curly braces.
```java
❌ Wrong
if (condition) {
    // Single line body
} else {
    // Single line body
}
```
```java
✅ Correct
if (condition) ...
else ...
```
```java
✅ Correct
if (condition)
    ...
else
    ...
```
The same applies to loops.
