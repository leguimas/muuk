
Muuk.login = {};

Muuk.login.preparePage = function() {
	$('#frmLogin').form();
	$.enterKeyListener($('#btnLogin'));
	$('#txtUsername').focus();

	$('#btnLogin').click(Muuk.login.go);
}

Muuk.login.go = function() {
	username = $.trim($('#txtUsername').val());

	if (username == "") {
		$('.message').message('Para realizar o login é necessário informar um usuário.', 'error', true);
		return false;
	} else {
		$('#frmLogin').submit();
	}
}