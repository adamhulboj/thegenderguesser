/*female*/
SELECT DISTINCT a.name
FROM
(
SELECT 
UPPER(TRIM(o.simie)) AS name,
MOD(CAST( SUBSTRING(o.spesel FROM 10 FOR 1) AS integer),2) AS gender   
FROM r_osoby o
WHERE 
	o.spesel IS NOT NULL 
	AND	CHAR_LENGTH(o.spesel) = 11 
	AND	SUBSTRING(TRIM(o.spesel) FROM 10 FOR 1) SIMILAR TO '[0-9]+' 
	--AND	SUBSTRING(o.spesel FROM 10 FOR 1) <> ''
) A 
WHERE 
 a.gender = 0