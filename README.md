
# Hockey Game!
This project is part of a challenge from GSL Group for VanHackathon 4.0!
<br/>
This is the Java server code repository. If you want to go to the dark side, please visit the mobile application repository: [Ionic Cordova repositoy page.](https://github.com/vinnipedrosa/hockey-game-mobile)

The main idea of this project is to enhance the users' experience with the event they are attending to. In order to accomplish that, a loyalty system - gamification - was created and users can gather points by going into shows and when interacting with campaigns that the administrators send to the users' smartphones (push notifications), with only one click on the main webpage.
<br/>
It is also possible to disable push notifications if you don't want to be disturbed :)



This project was built over very well known and trusted technologies and frameworks:

 - Java 8;
 - Spring Boot;
 - Spring Security;
 - Thymeleaf;
 - Bootstrap;
 - jQuery;
 - MySQL;
 - SockJS;
 - Maven;
 - OneSignal (for push notifications).
 
 If you need to apply any changes in the project, such as database credentials, you can do so by modifying applications.properties file located at "hockey-game/src/main/resources" directory.
 <br />
 <br />
 Since this project is managed by Maven, you can generate a build of it by entering the following command in terminal (make sure you are in the same directory where project's pom.xml file is):

    mvn clean package

This command will generate a .jar file named "hockey-game.jar" in a folder called "target" inside the project's directory.
<br />
In order to run the build, enter the following command line in terminal (make sure you are in the same directory where hockey-game.jar file is):

    java -jar hockey-game.jar

Once the system is up and running, if you haven't made any changes in applications.properties, it is possible to access it by the URI http://localhost:8080/hockey

## Home page explanation

This is the home page of the system:

![Main page](https://github.com/edylle/hockey-game/blob/master/src/main/resources/static/img/home-page-prints/01.jpg)

If you click on the question mark located at the top right corner of the page, it will send some random hockey related question to all mobile Android applications. If you answer the questions correctly, you will earn points that can be spent in jumbotron actions.
<br />
<br />
I tried to simulate a Jumbotron on that page. On the right side of the page is where the list of actions made by people on the stadium is presented.
<br />
There are two options of actions (or attentions) that users can call from the Android application: to be filmed by some camera guy and/or send a message to the audience.
<br />
<br />
If you try to accept a message action call, first you have to verify if there is no inappropriate text in it:

 ![Confirm message modal](https://github.com/edylle/hockey-game/blob/master/src/main/resources/static/img/home-page-prints/02.jpg)
 
If everything's alright, you may accept it and the message is displayed in Jumbotron so everyone in the stadium can see it.
 
 ![Message displayed in jumbotron](https://github.com/edylle/hockey-game/blob/master/src/main/resources/static/img/home-page-prints/03.jpg)

The film action is meant for you to call some attention of a camera available in the stadium:

![enter image description here](https://github.com/edylle/hockey-game/blob/master/src/main/resources/static/img/home-page-prints/04.jpg)

Last but not least, of course it is fully responsive :)

![responsible page](https://github.com/edylle/hockey-game/blob/master/src/main/resources/static/img/home-page-prints/05.jpg)

## API REST endpoints
	Important: All POST requests need authentication which is AuthType Basic seatNumber:seatNumber by default.

### 1. Seat

##### 1.1. GET seat numbers
	1. URL (GET): http://server_ip:server_port/hockey/app/seat-numbers

	2. JSON response (example)

```
[
	{
		"available": true,
		"seatNumber": "001"
	},
	{
		"available": false,
		"seatNumber": "002"
	},
	{
		"available": true,
		"seatNumber": "003"
	},
	{
		"available": true,
		"seatNumber": "004"
	},
	{
		"available": false,
		"seatNumber": "005"
	}
]
```

##### 1.2. GET seat ranking
	1. URL (GET): http://server_ip:server_port/hockey/app/seat-ranking

	2. JSON response (example)

```
[
    {
        "seatNumber": "040",
        "fanName": "Fan n040",
        "points": 77
    },
    {
        "seatNumber": "050",
        "fanName": "Fan n050",
        "points": 76
    },
    {
        "seatNumber": "022",
        "fanName": "Fan n022",
        "points": 75
    },
    {
        "seatNumber": "054",
        "fanName": "Fan n054",
        "points": 73
    }
]
```

##### 1.3. POST recover seat balance
	1. URL (POST): http://server_ip:server_port/hockey/app/seat-points-balance

	2. JSON response (example)

```
40
```

##### 1.4. POST my info
	1. URL (POST): http://server_ip:server_port/hockey/app/my info

	2. request body (example) - optional

```
{
	"fanName": "John Doe"
}
```

	3. JSON response (example)

```
{
	"username": "002",
	"receiveNotification": true,
	"fanName": "Fan n002",
	"points": 78
}
```

##### 1.5. POST recover seat history points
	1. URL (POST): http://server_ip:server_port/hockey/app/seat-history-points

	2. JSON response (example)

```
[
    {
        "id": 1,
        "description": "Description CREDIT1",
        "points": 100,
        "historyType": "CREDIT",
        "historyDate": "26/11/2017 - 03:01"
    },
    {
        "id": 2,
        "description": "Description DEBIT1",
        "points": 60,
        "historyType": "DEBIT",
        "historyDate": "26/11/2017 - 03:01"
    }
]
```

##### 1.6. POST logout
	1. URL (POST): http://server_ip:server_port/hockey/app/logout

	2. JSON response (example)

```
You have been successfully logged out
```

### 2. Notification

##### 2.1. POST invert notification status
	1. URL (POST): http://server_ip:server_port/hockey/app/invert-notification-status

### 3. Attention

##### 3.1. POST new attention
	1. URL (POST): http://server_ip:server_port/hockey/app/invert-notification-status

	2. JSON request body (example) (attentionType possible values: "FILM" or "MESSAGE"; "message" key is optional)

```
{
	"attentionType": "MESSAGE",
	"message": "Say hello to me!"
}
```

	3. JSON response (example)
	
```
{
    "message": "Say hello to me!",
    "id": 21,
    "attentionType": "MESSAGE",
    "seatNumber": "001"
}
```

### 4. Quiz

##### 4.1. POST ask a question
	1. URL (POST): http://server_ip:server_port/hockey/app/ask-question

	2. JSON response (example)

```
{
    "listAnswer": [
        {
            "id": 13,
            "description": "Maurice Richard"
        },
        {
            "id": 14,
            "description": "Wayne Gretzky"
        },
        {
            "id": 15,
            "description": "Bryan Trottier"
        },
        {
            "id": 16,
            "description": "Jean Béliveau"
        }
    ],
    "id": 4,
    "description": "Who has recorded the most career points in the Stanley Cup final?"
}
```

##### 4.2. POST submit an answer
	1. URL (POST): http://server_ip:server_port/hockey/app/submit-answer/{idAnswer}

	2. JSON response (example) - true if answer is correct - false otherwise

```
true
```
