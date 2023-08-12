Thanks for taking the time to contribute to this project.

# How to track and add new Instagram requests
First, you will have to set up Instagram SSL pinning bypass to see the requests sent by Instagram mobile app, [guide here](https://github.com/Eltion/Instagram-SSL-Pinning-Bypass)

Then you will need to replicate that request in Postman for example let's try to replicate the `/accounts/current_user` GET request

# Code Guidelines

## Formatting
Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html), also see other bits of the code base and write consistent code.

### Import Order
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

### Docs
```java
    /**
     * <Description of the method>.
     *
     * @param param1    Description of param1
     * @param param2    Description of param1
     * @param longParam Description of longParam
     */
```

### Curly Braces
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
