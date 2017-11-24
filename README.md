# Hockey Game!
This project is part of the challenge from GSL Group for VanHackathon 4.0

## REST endpoints

### 1. Seat

##### 1.1. GET seat numbers
	1. URL (GET): http://server_ip:server_port/hockey/app/seat-numbers
	
	2. JSON response
	
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
	
	2. JSON response
	
```
[
	{
		"points": 100,
		"seatNumber": "036"
	},
	{
		"points": 98,
		"seatNumber": "063"
	},
	{
		"points": 98,
		"seatNumber": "006"
	},
	{
		"points": 96,
		"seatNumber": "076"
	},
	{
		"points": 95,
		"seatNumber": "038"
	}
]
```

##### 2. POST invert notification status
	1. URL (POST): http://server_ip:server_port/hockey/app/invert-notification-status