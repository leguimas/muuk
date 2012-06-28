
Muuk.login = {};

Muuk.login.preparePage = function() {
	$('#frmLogin').form();
	$.enterKeyListener($('#btnLogin'));
	$('#txtUsername').focus();

	$('#btnLogin').click(Muuk.login.go);

	if (Muuk.refreshTimer != null) {
		clearInterval(Muuk.refreshTimer);
	}

	Muuk.login.enable();
}

Muuk.login.go = function() {
	Muuk.login.disable();
	username = $.trim($('#txtUsername').val());

	if (username == "") {
		$('.message').message($.i18n.messages.login_error_usernameEmpty, 'error', true);
		Muuk.login.enable();
		return false;
	} else {
		$('#frmLogin').submit();
	}
}

Muuk.login.enable = function() {
	$('#btnLogin').attr("disabled", false);
}

Muuk.login.disable = function() {
	$('#btnLogin').attr("disabled", true);
}