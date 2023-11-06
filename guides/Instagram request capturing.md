# Instagram request capturing

First, you must set up Instagram SSL pinning bypass to see the requests sent by the Instagram mobile app, [guide here](https://github.com/Eltion/Instagram-SSL-Pinning-Bypass).

![image](https://github.com/Taz03/JIA/assets/73871477/62e57422-8912-48ea-9b0a-7272c165a41e)
Then you should see all the requests going out in real-time, and here you can see what action in the app leads to which requests.

Then you will need to replicate that request for example, let's try to replicate the `/accounts/current_user` GET request.

![image](https://github.com/Taz03/JIA/assets/73871477/7b02b0f1-a8ec-44e8-ac92-eb120094c10b)

Try and experiment to see what query does what, and which ones are ignored.

Read next: [Adding a new request](Implementing%20a%20new%20request.md)
