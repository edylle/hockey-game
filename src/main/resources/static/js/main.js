$(function() {
	$('[data-toggle="tooltip"]').tooltip();
	$('[rel="tooltip"]').tooltip();
});

var imgTimer;
var txtTimer;

function showLoading() {}

function hideLoading() {}

// MODALS
var idAttention;
var accept;
var userMsg;
var userImg; // mocked
$('#modal-accept-attention').on("show.bs.modal", function(event) {
	idAttention = $(event.relatedTarget).data("id");
	accept = $(event.relatedTarget).data("accept");

	var bodySpanData = "<p>" + $(event.relatedTarget).data("accept-warning") + "</p>";

	if ($(event.relatedTarget).data("type") === "MESSAGE") {
		userMsg = $(event.relatedTarget).data("message");
		bodySpanData += "<p><strong>Message: </strong><i>\"" + userMsg + "\"</i></p>";
		userImg = null;
	} else {
		userMsg = null;
		userImg = getRandomUser();
	}

	$(this).find(".modal-body span").html(bodySpanData);
});

//JUMBOTRON ACTIONS
function showImageOnJumbotron(image) {
	$("#div-jumbotron-wrapper").append('<img id="img-jumbotron" src="' + image + '" class="img-user-jumbotron rounded-circle" />');

	imgTimer = setTimeout(function() {
					$("#img-jumbotron").fadeOut("slow", function() {
						$("#img-jumbotron").remove();
					});
				}, 5000);
};

function showMessageOnJumbotron(message) {
	$("#div-jumbotron-wrapper").append('<div id="txt-jumbotron" class="txt-user-jumbotron text-primary">' + message + '</div>');

	txtTimer = setTimeout(function() {
					$("#txt-jumbotron").fadeOut("slow", function() {
						$("#txt-jumbotron").remove();
					});
				}, 5000);
};

// AJAX
var ctxHome = "/hockey/home";
function acceptAttention() {
	var response = $.ajax({
		url : ctxHome + "/accept-attention/" + idAttention + "/" + accept,
		type : "POST",
		contentType : "application/json; charset=utf-8",
		dataType : "text json",
		async: false,
		beforeSend: function(){ showLoading(); },
		complete: function(){ hideLoading(); }
	});

	response.done(function(e) {
		$("#attention-" + idAttention).hide("slow", function(){ $("#attention-" + idAttention).remove(); evaluateList(); });
		$('#modal-accept-attention').modal("hide");

		$("#img-jumbotron").remove();
		$("#txt-jumbotron").remove();
		clearTimeout(imgTimer);
		clearTimeout(txtTimer);

		if (userImg) {
			showImageOnJumbotron(userImg);

		} else if (userMsg) {
			showMessageOnJumbotron(userMsg);
		}
	});

	response.fail(function() {
		$.growl.error({title: "Error", message: "We could not complete your request", location: "tr" });
		$('#modal-accept-attention').modal("hide");
	});
};

function sendQuestion() {
	var response = $.ajax({
		url : ctxHome + "/send-question",
		type : "POST",
		contentType : "application/json; charset=utf-8",
		dataType : "text json",
		async: false,
		beforeSend: function(){ showLoading(); },
		complete: function(){ hideLoading(); }
	});
	
	response.done(function(e) {
		$.growl.notice({title: "Success", message: "The question was sent", location: "tr" });
	});
	
	response.fail(function() {
		$.growl.error({title: "Error", message: "We could not complete your request", location: "tr" });
	});
};