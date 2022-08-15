	CREATE TABLE exercicio (
		exercicio_id int AUTO_INCREMENT PRIMARY KEY,
		nome_exercicio varchar(200),
        serie varchar(200) ,
        treino_id int,
        CONSTRAINT fk_treino_id FOREIGN KEY (treino_id) REFERENCES treino(treino_id)
	);
	
	
	INSERT INTO exercicio VALUES (null,'Supino reto','3 séries de 12 repetições',1);
	INSERT INTO exercicio VALUES (null,'remada baixa',12);
	INSERT INTO exercicio VALUES (null,'leg 180',12);
	

	CREATE TABLE treino(
		treino_id int AUTO_INCREMENT PRIMARY KEY,
		nome_treino varchar(250),
		tipo_treino int,
        aluno_id int,
        CONSTRAINT fk_aluno_id  FOREIGN KEY (aluno_id ) REFERENCES aluno(aluno_id )
	);
	INSERT INTO treino VALUES (null,'padrão peito',1,1);
	INSERT INTO treino VALUES (null,'padrão costas',2,2);
	INSERT INTO treino VALUES (null,'padrão perna',3,3);
	
	CREATE TABLE instrutor(
		instrutor_id int AUTO_INCREMENT PRIMARY KEY,
		nome_instrutor varchar(250)
	);
	
	
	INSERT INTO instrutor VALUES (null, 'Pedro');
	INSERT INTO instrutor VALUES (null, 'Jorge');
	INSERT INTO instrutor VALUES (null, 'Douglas');
	
	CREATE TABLE aluno(
		aluno_id int AUTO_INCREMENT PRIMARY KEY,
		nome_aluno varchar(250) NOT NULL,
		instrutor_id int,
        CONSTRAINT fk_instrutor_id FOREIGN KEY (instrutor_id) REFERENCES instrutor(id)
        
	);
	
	INSERT INTO aluno VALUES (null,'Kauê Batista',1);
	INSERT INTO aluno VALUES (null,'Guilherme Batista',2);
	INSERT INTO aluno VALUES (null,'Jorge Machado',3);