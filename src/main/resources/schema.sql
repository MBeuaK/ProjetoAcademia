	CREATE TABLE exercicio (
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_exercicio varchar(200),
		numero_de_repeticoes int
	);

	CREATE TABLE treino(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_treino varchar(250),
		tipo_treino varchar(50)  NOT NULL,
		fk_exercicio int,
		FOREIGN KEY (fk_exercicio) REFERENCES exercicio(id)
	);
	
	CREATE TABLE instrutor(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_instrutor varchar(250)
	);
	
	CREATE TABLE aluno(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_aluno varchar(250) NOT NULL,
		fk_instrutor int,
		fk_treino int,
		FOREIGN KEY (fk_instrutor) REFERENCES instrutor(id),
		FOREIGN KEY (fk_treino) REFERENCES treino(id)
	);
	
