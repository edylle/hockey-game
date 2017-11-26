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
			addAttention(JSON.parse(msg.body));
		});

		attentionClient.subscribe('/remove-attentions-from', function(msg) {
			removeAttentionsFrom(JSON.parse(msg.body));
		});
	});
};

function disconnectAttention() {
	if (atendimentoClient != null) {
		atendimentoClient.disconnect();
	}
};