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
       op.sales_stage STATUS_CODE,
       op.date_closed EXPECTED_CLOSE_DATE
from   opportunities op
       inner join accounts_opportunities acOp on acOp.opportunity_id = op.id and acOp.deleted = false
       inner join accounts ac on acOp.account_id = ac.id and ac.deleted = false
       inner join users us on op.assigned_user_id = us.id and us.deleted = false
       left join users_cstm usCt on usCt.id_c = us.id
       left join dxsug_gp_opportunities_c opGp on opGp.dxsug_gp_opportunitiesopportunities_idb = op.id and opGp.deleted = false
       left join dxsug_gp gp on opGp.dxsug_gp_opportunitiesdxsug_gp_ida = gp.id and gp.deleted = false
       left join dxsug_prevenda_opportunities_c opPv on opPv.dxsug_prevenda_opportunitiesopportunities_idb = op.id and opPv.deleted = false
       left join dxsug_prevenda pv on opPv.dxsug_prevenda_opportunitiesdxsug_prevenda_ida = pv.id and pv.deleted = false
       left join dxsug_timetecnico_opportunities_c opTt on opTt.dxsug_timetecnico_opportunitiesopportunities_idb = op.id and opTt.deleted = false
       left join dxsug_timetecnico tt on opTt.dxsug_timetecnico_opportunitiesdxsug_timetecnico_ida = tt.id and tt.deleted = false;
