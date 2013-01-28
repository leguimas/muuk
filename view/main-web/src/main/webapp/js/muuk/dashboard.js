
Muuk.dashboard = {};

Muuk.dashboard.MAX_OPPORTUNITIES = 10;

Muuk.dashboard.load = function() {
	Muuk.dashboard.loadOpportunities('06_Refinamento', 'Refinamento', 'section.refinamento');
	Muuk.dashboard.loadOpportunities('07_OrdemGrandeza', 'Ordem de Grandeza', 'section.ordemGrandeza');
	Muuk.dashboard.loadOpportunities('08_VisitaTecnica', 'Visita Técnica', 'section.visitaTecnica');
	Muuk.dashboard.loadOpportunities('10_AguardandoCliente', 'Aguardando Cliente', 'section.aguardandoCliente');
	Muuk.dashboard.loadOpportunities('12_EmElaboracao', 'Em Elaboração', 'section.emElaboracao');
	Muuk.dashboard.loadOpportunities('13_Defesa', 'Defesa', 'section.defesa');
	Muuk.dashboard.loadOpportunities('15_NegociacaoAlta', 'Alta Probabilidade', 'section.negociacaoAlta');
	Muuk.dashboard.loadOpportunities('16_NegociacaoMedia', 'Média Probabilidade', 'section.negociacaoMedia');
	Muuk.dashboard.loadOpportunities('17_NegociacaoBaixa', 'Baixa Probabilidade', 'section.negociacaoBaixa');
	Muuk.dashboard.loadYearOpportunities('18_Ganhamos', 'Ganhamos', 'section.ganhamos');
	Muuk.dashboard.loadYearOpportunities('19_Perdemos', 'Perdemos', 'section.perdemos');
	Muuk.dashboard.loadYearOpportunities('20_OnHold', 'On Hold', 'section.onHold');
	Muuk.dashboard.loadOpportunitiesAguardandoTimeTecnico();
}

Muuk.dashboard.loadYearOpportunities = function(statusCode, statusName, seletor) {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/year/' + statusCode,
		dataType : 'json',
		success : function(opportunities) {
			var originalSize = opportunities.length;
			$.holy("templates/opportunities/opportunities.xml?t=" + new Date().getTime(), { 'opportunities' : opportunities.splice(0, Muuk.dashboard.MAX_OPPORTUNITIES), 'status' : statusName, 'seletor' : seletor, 'originalSize' : originalSize });
		}
	});
}

Muuk.dashboard.loadOpportunities = function(statusCode, statusName, seletor) {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/all/' + statusCode,
		dataType : 'json',
		success : function(opportunities) {
			var originalSize = opportunities.length;
			$.holy("templates/opportunities/opportunities.xml?t=" + new Date().getTime(), { 'opportunities' : opportunities.splice(0, Muuk.dashboard.MAX_OPPORTUNITIES), 'status' : statusName, 'seletor' : seletor, 'originalSize' : originalSize });
		}
	});
}

Muuk.dashboard.loadOpportunitiesAguardandoTimeTecnico = function() {
	$.ajax({
		type : 'GET',
		url : 's/opportunity/all/09_AguardandoTimeTecnico',
		dataType : 'json',
		success : function(opportunities) {
			$.holy("templates/opportunities/aguardandoTimeTecnico.xml?t=" + new Date().getTime(), { 'opportunities' : opportunities });
		}
	});
}
