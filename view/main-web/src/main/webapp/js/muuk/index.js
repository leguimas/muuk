Muuk = {};

Muuk.refreshTimer = null;

$.loadTemplate = function(template) {
	if (! $.i18n.loaded) {
		setTimeout("$.loadTemplate('"+ template + "')", 100);
	} else {
		$.holy("templates/" + template, { });
	}
}