SELECT * FROM person, address 
WHERE address.id_Person = person.id_Person
AND address.id_Person IN (
	SELECT address.id_Person from address
	group by address.id_Person 
	having COUNT(address.id_Person) > 1
)
ORDER BY address.id_Person