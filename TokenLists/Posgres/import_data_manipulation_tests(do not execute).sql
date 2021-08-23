drop table gender_tokens
commit;

create table gender_tokens
(
ident integer primary key,
tokenName varchar(100),
gender varchar(1)   -- M male F female
);
commit;

create sequence gendertokens_sq increment 1 start 1;

drop table gender_token_import;
commit;

create table gender_token_import
(
tokenName varchar(100),
gender varchar(1),   -- M male F female
origin varchar(100)
);

commit;


select * from gender_token_import;
select count (*) from gender_token_import;
delete from gender_token_import;




delete from gender_tokens 



insert into gender_tokens (ident, tokenname, gender)
select nextval('gendertokens_sq'),a.tokenname,a.gender   
from (
select distinct gti.tokenname, 
(select gt.gender from gender_token_import gt where gti.tokenname = gt.tokenname  limit 1)
from gender_token_import gti
--where gti.origin = 'katowice'
) a


select count(tokenname), tokenname from gender_tokens gt
group by tokenname
having count(tokenname) > 1



select * from gender_tokens gt  where tokenname = 'ADAM'

