function evaluateList() {
	if ($(".div-row-attentions")[0]) {
		$("#div-empty-attentions").css("display", "none");

	} else {
		$("#div-empty-attentions").css("display", "block");
	}
}

function addAttention(attention) {
	var rowTitle = "";
	if (attention.attentionType === "MESSAGE") {
		rowTitle = "<span style=\"color: orange;\"><strong>Message</strong></span> from seat " + attention.seatNumber;
	} else if (attention.attentionType === "FILM") {
		rowTitle = "<span style=\"color: #2eb4f3;\"><strong>Film</strong></span> seat " + attention.seatNumber;
	}

	var divRowAttention = '<div class="row div-row-attentions ' + attention.seatNumber + '" id="attention-' + attention.id + '">'
                        + '<div class="col-2 text-center middle-row-attentions-img">'
                        + '<img src="' + getRandomUser() + '" width="30" />'
                        + '</div>'
                        + '<div class="col-8 text-left middle-row-attentions-txt">'
                        + '<p>' + rowTitle + '</p>'
                        + '</div>'
                        + '<div class="col-2 text-center middle-row-attentions-check">'
                        + '<a class="text-success cursor-pointer" data-toggle="modal" data-target="#modal-accept-attention" '
                        + 'id="a-attention-row-' + attention.id + '" '
                        + 'title="Accept attention" rel="tooltip" data-placement="top">'
                        + '<i class="fa fa-check" aria-hidden="true"></i>'
                        + '</a>'
                        + '</div>'
                        + '</div>';

    $("#div-wrapper-attention-list").append(divRowAttention);
    $("#attention-" + attention.id).hide();
    $("#attention-" + attention.id).show('slow');

	var currentA = $(document.getElementById('a-attention-row-' + attention.id));
	currentA.data("id", attention.id);
	currentA.data("accept", true);
	currentA.data("type", attention.attentionType);
	currentA.data("accept-warning", "Are you sure you want to accept the attention from seat " + attention.seatNumber);
	currentA.data("message", attention.message);

	evaluateList();

	$.growl.notice({title: "Attention request", message: "New attention from seat " + attention.seatNumber, location: "tr"});
}

function removeAttentionsFrom(seat) {
	$("." + seat.username).hide('slow', function(){ $("." + seat.username).remove(); evaluateList(); });
}