var usersImages = [ "../img/user1.png", "../img/user2.jpg", "../img/user3.png", "../img/user4.png", "../img/user5.png", "../img/user6.png" ];
function getRandomUser() {
	return usersImages[Math.floor(Math.random() * usersImages.length)];
};