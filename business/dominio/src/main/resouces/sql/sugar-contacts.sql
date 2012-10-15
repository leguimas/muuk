use sugar_db;
--
SET NAMES utf8;
--
select CONCAT(IFNULL(con.first_name, ''), ' ', IFNULL(con.last_name, '')) "Contato",
       IFNULL(con.first_name, '') "Nome",
       IFNULL(con.last_name, '') "Sobrenome",
       acc.name "Conta",
       emlAddPri.email_address "Email Primário",
       emlAddSec.email_address "Email Secundário",
       con.department "Departamento",
       con.title "Cargo",
       con.phone_home "Telefone Residencial",
       con.phone_mobile "Telefone Celular",
       con.phone_work "Telefone Comercial",
       con.phone_other "Outro Telefone",
       con.phone_fax "Fax",
       REPLACE(CONCAT(con.primary_address_street, ' - ', con.primary_address_city, '/', con.primary_address_state, ' - ', con.primary_address_postalcode, ' - ', con.primary_address_country), '\n', ' ') "Endereço Principal",
       REPLACE(CONCAT(con.alt_address_street, ' - ', con.alt_address_city, '/', con.alt_address_state, ' - ', con.alt_address_postalcode, ' - ', con.alt_address_country), '\n', ' ') "Endereço Secundário",
       con.assistant "Assistente",
       con.assistant_phone  "Telefone Assistente"
INTO OUTFILE '/tmp/contacts.txt'
FIELDS TERMINATED BY '#' OPTIONALLY ENCLOSED BY '"'
from contacts con
     inner join accounts_contacts accCon on accCon.contact_id = con.id and accCon.deleted = 0
     inner join accounts acc on accCon.account_id = acc.id and acc.deleted = 0
     inner join email_addr_bean_rel emlConPri on emlConPri.bean_id = con.id and emlConPri.bean_module = 'Contacts' and emlConPri.deleted = 0 and emlConPri.primary_address = 1
     inner join email_addresses emlAddPri on emlConPri.email_address_id = emlAddPri.id and emlAddPri.deleted = 0
     left join email_addr_bean_rel emlConSec on emlConSec.bean_id = con.id and emlConSec.bean_module = 'Contacts' and emlConSec.deleted = 0 and emlConSec.primary_address = 0
     left join email_addresses emlAddSec on emlConSec.email_address_id = emlAddSec.id and emlAddSec.deleted = 0
where con.deleted = 0
order by acc.name, con.first_name, con.last_name;
--
\q
