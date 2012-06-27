
Muuk.dashboard = {};

Muuk.dashboard.load = function() {
	Muuk.dashboard.loadOpportunities('Refinamento', 'Refinamento', 'section.refinamento');
	Muuk.dashboard.loadOpportunities('OrdemGrandeza', 'Ordem de Grandeza', 'section.ordemGrandeza');
	Muuk.dashboard.loadOpportunities('VisitaTecnica', 'Visita Técnica', 'section.visitaTecnica');
	Muuk.dashboard.loadOpportunities('AguardandoCliente', 'Aguardando Cliente', 'section.aguardandoCliente');
	Muuk.dashboard.loadOpportunities('EmElaboracao', 'Em Elaboração', 'section.emElaboracao');
	Muuk.dashboard.loadOpportunities('Defesa', 'Defesa', 'section.defesa');
	Muuk.dashboard.loadOpportunities('NegociacaoAlta', 'Alta Probabilidade', 'section.negociacaoAlta');
	Muuk.dashboard.loadOpportunities('NegociacaoMedia', 'Média Probabilidade', 'section.negociacaoMedia');
	Muuk.dashboard.loadOpportunities('NegociacaoBaixa', 'Baixa Probabilidade', 'section.negociacaoBaixa');
	Muuk.dashboard.loadOpportunities('Ganhamos', 'Ganhamos', 'section.ganhamos');
	Muuk.dashboard.loadOpportunities('Perdemos', 'Perdemos', 'section.perdemos');
	Muuk.dashboard.loadOpportunities('OnHold', 'On Hold', 'section.onHold');
	Muuk.dashboard.loadOpportunitiesAguardandoTimeTecnico();
}

Muuk.dashboard.loadOpportunities = function(statusCode, statusName, seletor) {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/all/' + statusCode,
		dataType : 'json',
		success : function(opportunities) {
			$.holy("templates/opportunities/opportunities.xml", { 'opportunities' : opportunities, 'status' : statusName, 'seletor' : seletor });
		}
	});
}

Muuk.dashboard.loadOpportunitiesAguardandoTimeTecnico = function() {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/all/AguardandoTimeTecnico',
		dataType : 'json',
		success : function(opportunities) {
			$.holy("templates/opportunities/aguardandoTimeTecnico.xml", { 'opportunities' : opportunities });
		}
	});
}
