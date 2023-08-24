# JIA - Java Instagram API
JIA is an API wrapper for the Instagram app's private REST API. It allows us to create Instagram Bots or scrappers without the Android app open.

## Wiki
## Login:
```
InstagramClient client = new InstagramClient("username", "password");
client.login(() -> System.getProperty("verificationCode"));
```
## UserInfoRequest
```
UserResponse userResponse = client.sendRequest(new UserInfoRequest("username")).join();
```