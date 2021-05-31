DROP TABLE IF EXISTS pessoas CASCADE;
DROP TABLE IF EXISTS disciplinas  CASCADE;
DROP TABLE IF EXISTS matriculas  CASCADE;


/*    PESSOA    */

CREATE TABLE IF NOT EXISTS pessoas (
  id SERIAL UNIQUE,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  is_professor BOOLEAN NOT NULL,
  PRIMARY KEY(cpf)
);

INSERT INTO pessoas (nome, cpf, is_professor) VALUES 
('Dalmo Felipe', '11122233344', false), 
('Felipe Torres', '22233344455', false), 
('Torres Paula', '33344455566', false),
('Prof. Girafalles ', '44455566677', true), 
('Prof. Xavier', '55566677788', true), 
('Prof. Raimundo', '66655577788', true);

-- cpf repetido
INSERT INTO pessoas (nome, cpf, is_professor) VALUES 
('Prof. Hugo', '66655577788', true);

-- selecionando professores
SELECT * FROM pessoas WHERE is_professor = true;

-- selectionando alunos
SELECT * FROM pessoas WHERE is_professor = false;

-- excluir professor sem vinculos 
DELETE FROM pessoas WHERE cpf = '123.456.789-00' AND is_professor = TRUE;



/*    DISCIPLINAS  12345678900  */

CREATE TABLE IF NOT EXISTS disciplinas (
  id INT NOT NULL UNIQUE,
  nome VARCHAR(255) NOT NULL UNIQUE,
  carga_horaria INT NOT NULL,
  -- cpf_pessoa VARCHAR(11) NOT NULL REFERENCES pessoas(),
  id_pessoa INT NOT NULL REFERENCES pessoas(id),
  PRIMARY KEY(id)
);

INSERT INTO disciplinas (id, nome, carga_horaria, id_pessoa) VALUES 
(10121, 'FTC', 100, 9),
(6221, 'GRAFOS', 80, 5),
(8321, 'EDO', 60, 4),
(9121, 'S.O.', 100, 4);

SELECT * FROM disciplinas;

INSERT INTO disciplinas (id, nome, carga_horaria, id_pessoa)
SELECT 222, 'TESTE2', 50, p.id
FROM pessoas p
WHERE p.id = 1 AND p.is_professor = TRUE;



/*    MATRICULAS    */

CREATE TABLE IF NOT EXISTS matriculas (
  id SERIAL,
  id_disciplina INTEGER NOT NULL REFERENCES disciplinas(id),
  id_pessoa INT NOT NULL REFERENCES pessoas(id),
  PRIMARY KEY(id_disciplina, id_pessoa)
);

INSERT INTO matriculas (id_disciplina, id_pessoa) VALUES 
(10121, 1), 
(6221, 1),
(8321, 1),
(9121, 1),
INSERT INTO matriculas (id_disciplina, id_pessoa) VALUES 
(10121, 2), 
(6221, 2),
(8321, 3),
(9121, 3);

SELECT * FROM matriculas;


INSERT INTO matriculas (id_disciplina, id_pessoa)
SELECT d.id, p.id
FROM disciplinas d, pessoas p
WHERE p.id = 1
  AND d.id = 6221
  AND p.is_professor = false;


