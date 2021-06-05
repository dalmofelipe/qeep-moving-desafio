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
/*    DISCIPLINAS   */
CREATE TABLE IF NOT EXISTS disciplinas (
  id INT NOT NULL UNIQUE,
  nome VARCHAR(255) NOT NULL UNIQUE,
  carga_horaria INT NOT NULL,
  id_pessoa INT NOT NULL REFERENCES pessoas(id),
  PRIMARY KEY(id)
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
('Dalmo Felipe', '11122233344', false), 
('Felipe Torres', '22233344455', false), 
('Torres Paula', '33344455566', false),
('Prof. Girafalles ', '44455566677', true), 
('Prof. Xavier', '55566677788', true), 
('Prof. Raimundo', '66655577788', true);

INSERT INTO disciplinas (id, nome, carga_horaria, id_pessoa) VALUES 
(10121, 'FTC', 100, 9),
(6221, 'COMPILADORES', 80, 5),
(8321, 'EDO', 60, 4),
(9121, 'S.O.', 100, 4);
