var usersImages = [ u1, u2, u3, u4, u5, u6 ];
function getRandomUser() {
	return usersImages[Math.floor(Math.random() * usersImages.length)];
};