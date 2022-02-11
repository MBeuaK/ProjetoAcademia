	CREATE TABLE exercicio (
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_exercicio varchar(200),
		numero_de_repeticoes int
	);

	CREATE TABLE treino(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_treino varchar(250),
		tipo_treino varchar(50)  NOT NULL,
		exercicio_id int,
		CONSTRAINT fk_exercicio_id FOREIGN KEY (exercicio_id) REFERENCES exercicio(id)
	);
	
	CREATE TABLE instrutor(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_instrutor varchar(250)
	);
	
	CREATE TABLE aluno(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_aluno varchar(250) NOT NULL,
		instrutor_id int,
		treino_id int,
        CONSTRAINT fk_treino_id FOREIGN KEY (treino_id) REFERENCES treino(id),
        CONSTRAINT fk_instrutor_id FOREIGN KEY (instrutor_id) REFERENCES instrutor(id)
        
	);