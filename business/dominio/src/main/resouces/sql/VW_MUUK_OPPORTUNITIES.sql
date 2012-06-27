CREATE OR REPLACE VIEW VW_MUUK_OPPORTUNITIES AS
select op.id ID,
       ac.name ACCOUNT_NAME,
       op.name NAME,
       CONCAT(us.first_name, ' ', us.last_name) BUSINESS_EXECUTIVE_NAME,
       usCt.avatar_c BUSINESS_EXECUTIVE_AVATAR,
       usCt.color_c BUSINESS_EXECUTIVE_COLOR,
       CONCAT(gp.first_name, ' ', gp.last_name) PROJECT_MANAGER_NAME,
       gp.avatar PROJECT_MANAGER_AVATAR,
       gp.color PROJECT_MANAGER_COLOR,
       CONCAT(pv.first_name, ' ', pv.last_name) PRE_SALES_NAME,
       pv.avatar PRE_SALES_AVATAR,
       pv.color PRE_SALES_COLOR,
       CONCAT(tt.first_name, ' ', tt.last_name) TECHINICAL_TEAM_NAME,
       tt.avatar TECHINICAL_TEAM_AVATAR,
       tt.color TECHINICAL_TEAM_COLOR,
       CASE op.sales_stage
            WHEN 'Em Qualificação' THEN 'EmQualificacao'
            WHEN 'Desqualificada' THEN 'Desqualificada'
            WHEN 'Prospecção - Refinamento' THEN 'Refinamento'
            WHEN 'Prospecção - Ordem de Grandeza' THEN 'OrdemGrandeza'
            WHEN 'Prospecção - Visita Técnica' THEN 'VisitaTecnica'
            WHEN 'Prospecção - Aguardando Cliente' THEN 'AguardandoCliente'
            WHEN 'Aguardando Time Técnico' THEN 'AguardandoTimeTecnico'
            WHEN 'Proposta - Em Elaboração' THEN 'EmElaboracao'
            WHEN 'Proposta - Defesa' THEN 'Defesa'
            WHEN 'Proposta - Negociação Alta' THEN 'NegociacaoAlta'
            WHEN 'Proposta - Negociação Média' THEN 'NegociacaoMedia'
            WHEN 'Proposta - Negociação Baixa' THEN 'NegociacaoBaixa'
            WHEN 'Ganhamos' THEN 'Ganhamos'
            WHEN 'Perdemos' THEN 'Perdemos'
            WHEN 'On Hold' THEN 'OnHold'
            WHEN 'Declinada' THEN 'Declinada'
            WHEN 'Cancelada' THEN 'Cancelada'
            ELSE 'Not Mapped Status' END STATUS_CODE,
       op.sales_stage STATUS_VALUE
from   opportunities op
       inner join accounts_opportunities acOp on acOp.opportunity_id = op.id and acOp.deleted = false
       inner join accounts ac on acOp.account_id = ac.id and ac.deleted = false
       inner join users us on op.assigned_user_id = us.id and us.deleted = false
       left join users_cstm usCt on usCt.id_c = us.id
       left join opportunities_dxsug_gp_1_c opGp on opGp.opportunities_dxsug_gp_1opportunities_ida = op.id and opGp.deleted = false
       left join dxsug_gp gp on opGp.opportunities_dxsug_gp_1dxsug_gp_idb = gp.id and gp.deleted = false
       left join opportunities_dxsug_prevenda_1_c opPv on opPv.opportunities_dxsug_prevenda_1opportunities_ida = op.id and opPv.deleted = false
       left join dxsug_prevenda pv on opPv.opportunities_dxsug_prevenda_1dxsug_prevenda_idb = pv.id and pv.deleted = false
       left join opportunities_dxsug_timetecnico_1_c opTt on opTt.opportunities_dxsug_timetecnico_1opportunities_ida = op.id and opTt.deleted = false
       left join dxsug_timetecnico tt on opTt.opportunities_dxsug_timetecnico_1dxsug_timetecnico_idb = tt.id and tt.deleted = false;
