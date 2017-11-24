var attentionClient = null;
var ctxAttention = "/hockey/home";

$(document).ready(function() {
	connectAttention();
});

function connectAttention() {
	var socket = new SockJS(ctxAttention);
	attentionClient = Stomp.over(socket);
	attentionClient.connect({}, function(frame) {

		attentionClient.subscribe('/attention-client', function(msg) {
			var attention = JSON.parse(msg.body);
			
			// this is just a test
			alert(attention.id + " " + attention.seatNumber);
		});
	});
};

function disconnectAttention() {
	if (atendimentoClient != null) {
		atendimentoClient.disconnect();
	}
};