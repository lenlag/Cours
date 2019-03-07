SELECT * FROM person, address 
WHERE person.id_Address = address.id_address
AND person.id_Address IN (
	SELECT person.id_Address from person
	group by person.id_Address 
	having COUNT(person.id_Address) > 1
)
ORDER BY person.id_Address