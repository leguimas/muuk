
Muuk.dashboard = {};

Muuk.dashboard.load = function() {
	Muuk.dashboard.loadOpportunities('Refinamento');
	Muuk.dashboard.loadOpportunities('OrdemGrandeza');
	Muuk.dashboard.loadOpportunities('VisitaTecnica');
	Muuk.dashboard.loadOpportunities('AguardandoCliente');
	Muuk.dashboard.loadOpportunities('EmElaboracao');
	Muuk.dashboard.loadOpportunities('Defesa');
	Muuk.dashboard.loadOpportunities('NegociacaoAlta');
	Muuk.dashboard.loadOpportunities('NegociacaoMedia');
	Muuk.dashboard.loadOpportunities('NegociacaoBaixa');
	Muuk.dashboard.loadOpportunities('Ganhamos');
	Muuk.dashboard.loadOpportunities('Perdemos');
	Muuk.dashboard.loadOpportunities('OnHold');
	Muuk.dashboard.loadOpportunities('AguardandoTimeTecnico');
}

Muuk.dashboard.loadOpportunities = function(status) {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/all/' + status,
		dataType : 'json',
		success : function(opportunities) {
			$.holy("templates/opportunities/" + status + ".xml", { 'opportunities' : opportunities });
		}
	});
}