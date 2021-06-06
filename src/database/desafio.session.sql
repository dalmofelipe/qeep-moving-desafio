DROP TABLE IF EXISTS pessoas CASCADE;
DROP TABLE IF EXISTS disciplinas  CASCADE;
DROP TABLE IF EXISTS matriculas  CASCADE;
/*    PESSOA    */
CREATE TABLE IF NOT EXISTS pessoas (
  id SERIAL NOT NULL,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL UNIQUE,
  is_professor BOOLEAN NOT NULL,
  PRIMARY KEY(id)
);
/*    DISCIPLINAS   */
CREATE TABLE IF NOT EXISTS disciplinas (
  id INT NOT NULL UNIQUE,
  nome VARCHAR(255) NOT NULL UNIQUE,
  carga_horaria INT NOT NULL,
  id_pessoa INT NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_id_pessoa
    FOREIGN KEY(id_pessoa)
      REFERENCES pessoas(id)
);
/*    MATRICULAS    */
CREATE TABLE IF NOT EXISTS matriculas (
  id SERIAL,
  id_disciplina INTEGER NOT NULL REFERENCES disciplinas(id),
  id_pessoa INT NOT NULL REFERENCES pessoas(id),
  PRIMARY KEY(id_disciplina, id_pessoa)
);

/*    SEEDS     */
INSERT INTO pessoas (nome, cpf, is_professor) VALUES 
('marlom brando', '32165498700', true), 
('Dalmo Felipe', '11122233344', false), 
('Felipe Torres', '22233344455', false), 
('Torres Paula', '33344455566', false),
('Prof. Girafalles ', '44455566677', true), 
('Prof. Xavier', '55566677788', true), 
('Prof. Raimundo', '66655577788', true);

INSERT INTO disciplinas (id, nome, carga_horaria, id_pessoa) VALUES 
(10122, 'BD', 100, 7),
(10121, 'FTC', 100, 6),
(6221, 'COMPILADORES', 80, 5),
(8321, 'EDO', 60, 4),
(9121, 'S.O.', 100, 4);

INSERT INTO matriculas (id_disciplina, id_pessoa) VALUES 
(10121, 2), 
(6221, 2),
(8321, 3);

-- 
SELECT * FROM pessoas
SELECT * FROM pessoas WHERE is_professor = false
SELECT * FROM pessoas WHERE is_professor = true
SELECT * FROM disciplinas
SELECT * FROM matriculas

-- removendo aluno
DELETE FROM pessoas WHERE id = 3 AND is_professor = false
DELETE FROM pessoas WHERE id = 7 AND is_professor = true
DELETE FROM disciplinas WHERE id = 8321
DELETE FROM pessoas WHERE id = 3 
