# Hockey Game!
This project is part of the challenge from GSL Group for VanHackathon 4.0

## REST endpoints
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

##### 1.4. POST recover seat balance
	1. URL (POST): http://server_ip:server_port/hockey/app/seat-points-balance

	2. JSON response (example)

```
40
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