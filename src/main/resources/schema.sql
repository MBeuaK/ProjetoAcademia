	CREATE TABLE exercicio (
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_exercicio varchar(200),
		numero_de_repeticoes int
	);
	
	
	INSERT INTO exercicio VALUES (null,'Supino reto',12);
	INSERT INTO exercicio VALUES (null,'remada baixa',12);
	INSERT INTO exercicio VALUES (null,'leg 180',12);
	

	CREATE TABLE treino(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_treino varchar(250),
		tipo_treino varchar(50)  NOT NULL,
		exercicio_id int,
		CONSTRAINT fk_exercicio_id FOREIGN KEY (exercicio_id) REFERENCES exercicio(id)
	);
	INSERT INTO treino VALUES (null,'padrão peito','Peito',1);
	INSERT INTO treino VALUES (null,'padrão costas','Costas',2);
	INSERT INTO treino VALUES (null,'padrão perna','Perna',3);
	
	CREATE TABLE instrutor(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_instrutor varchar(250)
	);
	
	
	INSERT INTO instrutor VALUES (null, 'Pedro');
	INSERT INTO instrutor VALUES (null, 'Jorge');
	INSERT INTO instrutor VALUES (null, 'Douglas');
	
	CREATE TABLE aluno(
		id int AUTO_INCREMENT PRIMARY KEY,
		nome_aluno varchar(250) NOT NULL,
		instrutor_id int,
		treino_id int,
        CONSTRAINT fk_treino_id FOREIGN KEY (treino_id) REFERENCES treino(id),
        CONSTRAINT fk_instrutor_id FOREIGN KEY (instrutor_id) REFERENCES instrutor(id)
        
	);
	
	INSERT INTO aluno VALUES (null,'Kauê Batista',1,1);
	INSERT INTO aluno VALUES (null,'Guilherme Batista',2,2);
	INSERT INTO aluno VALUES (null,'Jorge Machado',3,3);