CREATE TABLE public.usuario (
  id BIGSERIAL NOT NULL,
  cpf VARCHAR(20) NOT NULL,
  senha VARCHAR(20) NOT NULL,
  nome VARCHAR(20) NOT NULL,
  email VARCHAR(20) NOT NULL UNIQUE,
  "dataDeNascimento" DATE,
  PRIMARY KEY(id)
) ;

ALTER TABLE public.usuario
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE public.usuario
  ALTER COLUMN cpf SET STATISTICS 0;

ALTER TABLE public.usuario
  ALTER COLUMN senha SET STATISTICS 0;

ALTER TABLE public.usuario
  ALTER COLUMN nome SET STATISTICS 0;

ALTER TABLE public.usuario
  ALTER COLUMN email SET STATISTICS 0;

ALTER TABLE public.usuario
  ALTER COLUMN "dataDeNascimento" SET STATISTICS 0;

CREATE TABLE public.administrador (
  id BIGSERIAL NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE public.administrador
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE public.administrador
  ADD CONSTRAINT administrador_fk FOREIGN KEY (id)
    REFERENCES public.usuario(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE public.usuario_comum (
  id BIGSERIAL NOT NULL,
  ultimo_login DATE,
  pontos INTEGER,
  PRIMARY KEY(id)
) ;

ALTER TABLE public.usuario_comum
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE public.usuario_comum
  ALTER COLUMN ultimo_login SET STATISTICS 0;

ALTER TABLE public.usuario_comum
  ALTER COLUMN pontos SET STATISTICS 0;

ALTER TABLE public.usuario_comum
  ADD CONSTRAINT usuario_comum_fk FOREIGN KEY (id)
    REFERENCES public.usuario(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE public.usuario_critico (
  id BIGSERIAL NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE public.usuario_critico
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE public.usuario_critico
  ADD CONSTRAINT usuario_critico_fk FOREIGN KEY (id)
    REFERENCES public.usuario_comum(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE public.usuario_estudante (
  id SERIAL NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE public.usuario_estudante
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE public.usuario_estudante
  ADD CONSTRAINT usuario_estudante_fk FOREIGN KEY (id)
    REFERENCES public.usuario_comum(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER SCHEMA public
  RENAME TO cinecap;

INSERT INTO cinecap.usuario (id, cpf, senha, email, nome)
VALUES (1, '50364812087', 'admin', 'admin@cinecap.com', 'Jheymesson');

INSERT INTO cinecap.administrador (id)
VALUES (1);

ALTER TABLE cinecap.usuario
  RENAME COLUMN "dataDeNascimento" TO data_nascimento;

  -- atualização dia 29/11 Diógenes

  CREATE TABLE IF NOT EXISTS cinecap.filme (
	id BIGSERIAL NOT NULL,
    titulo VARCHAR(40),
    notaMedia REAL,
    PRIMARY KEY (id)

);

ALTER TABLE cinecap.filme
  ALTER COLUMN id SET STATISTICS 0;
  
ALTER TABLE cinecap.filme
  ALTER COLUMN titulo SET STATISTICS 0;
  
ALTER TABLE cinecap.filme
  ALTER COLUMN notaMedia SET STATISTICS 0;

-- atualização dia 29/11 Diego
CREATE TABLE cinecap.notas_filme (
  id BIGSERIAL NOT NULL,
  id_fillme BIGINT NOT NULL,
  nota NUMERIC(10,2) NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.notas_filme
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.notas_filme
  ALTER COLUMN id_fillme SET STATISTICS 0;

ALTER TABLE cinecap.notas_filme
  ALTER COLUMN nota SET STATISTICS 0;

ALTER TABLE cinecap.notas_filme
  ADD CONSTRAINT notas_filme_fk FOREIGN KEY (id_fillme)
    REFERENCES cinecap.filme(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER TABLE cinecap.filme
  RENAME COLUMN notamedia TO nota_media;

--30/11 diego Calado

ALTER TABLE cinecap.filme
  ADD COLUMN em_cartaz BOOLEAN DEFAULT TRUE NOT NULL UNIQUE;

CREATE TABLE cinecap.poltrona (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(20) NOT NULL,
  usuario_comum_id BIGINT,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.poltrona
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.poltrona
  ALTER COLUMN nome SET STATISTICS 0;

ALTER TABLE cinecap.poltrona
  ALTER COLUMN usuario_comum_id SET STATISTICS 0;

ALTER TABLE cinecap.poltrona
  ADD CONSTRAINT poltrona_fk FOREIGN KEY (usuario_comum_id)
    REFERENCES cinecap.usuario_comum(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE cinecap.historico_filmes (
  id BIGSERIAL NOT NULL,
  sessao_id BIGINT NOT NULL,
  usuario_comum_id BIGINT NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.historico_filmes
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.historico_filmes
  ALTER COLUMN sessao_id SET STATISTICS 0;

ALTER TABLE cinecap.historico_filmes
  ALTER COLUMN usuario_comum_id SET STATISTICS 0;

CREATE TABLE cinecap.sala (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(20) NOT NULL,
  tipo_sala VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.sala
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.sala
  ALTER COLUMN nome SET STATISTICS 0;

ALTER TABLE cinecap.sala
  ALTER COLUMN tipo_sala SET STATISTICS 0;

ALTER TABLE cinecap.poltrona
  ADD COLUMN sala_id BIGINT NOT NULL;

ALTER TABLE cinecap.poltrona
  ADD CONSTRAINT poltrona_fk1 FOREIGN KEY (sala_id)
    REFERENCES cinecap.sala(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

CREATE TABLE cinecap.sessao (
  id BIGSERIAL NOT NULL,
  sala_id BIGINT NOT NULL,
  filme_id BIGINT NOT NULL,
  data_inicio DATE NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.sessao
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.sessao
  ALTER COLUMN sala_id SET STATISTICS 0;

ALTER TABLE cinecap.sessao
  ALTER COLUMN filme_id SET STATISTICS 0;

ALTER TABLE cinecap.sessao
  ALTER COLUMN data_inicio SET STATISTICS 0;

ALTER TABLE cinecap.sala
  DROP COLUMN tipo_sala;

ALTER TABLE cinecap.sala
  ADD COLUMN tipo_sala_id BIGINT NOT NULL;

CREATE TABLE cinecap.tipo_sala (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.tipo_sala
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.tipo_sala
  ALTER COLUMN nome SET STATISTICS 0;

INSERT INTO cinecap.tipo_sala (id, nome) VALUES (1, '3D');
INSERT INTO cinecap.tipo_sala (id, nome) VALUES (2, 'XD');
INSERT INTO cinecap.tipo_sala (id, nome) VALUES (3, 'XD3D');

ALTER TABLE cinecap.sala
  ADD CONSTRAINT sala_fk FOREIGN KEY (tipo_sala_id)
    REFERENCES cinecap.tipo_sala(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER TABLE cinecap.sessao
  ADD CONSTRAINT sessao_fk FOREIGN KEY (filme_id)
    REFERENCES cinecap.filme(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER TABLE cinecap.sessao
  ADD CONSTRAINT sessao_fk1 FOREIGN KEY (sala_id)
    REFERENCES cinecap.sala(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER TABLE cinecap.historico_filmes
  ADD CONSTRAINT historico_filmes_fk FOREIGN KEY (sessao_id)
    REFERENCES cinecap.sessao(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

ALTER TABLE cinecap.historico_filmes
  ADD CONSTRAINT historico_filmes_fk1 FOREIGN KEY (usuario_comum_id)
    REFERENCES cinecap.usuario_comum(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE;

--dia 30/11 - Diógenes
ALTER TABLE cinecap.filme
  DROP CONSTRAINT filme_em_cartaz_key RESTRICT;

--dia 30/11 - Diego
INSERT INTO cinecap.tipo_sala (id, nome) VALUES (4, 'COMUM');

-- dia 30/11 - Valeriano
CREATE TABLE cinecap.lanche (
  id BIGSERIAL NOT NULL,
  nome VARCHAR(20) NOT NULL,
  preco NUMERIC(20,2) NOT NULL,
  PRIMARY KEY(id)
) ;

ALTER TABLE cinecap.lanche
  ALTER COLUMN id SET STATISTICS 0;

ALTER TABLE cinecap.lanche
  ALTER COLUMN nome SET STATISTICS 0;

ALTER TABLE cinecap.lanche
  ALTER COLUMN preco SET STATISTICS 0;

--atualização 01/12 Diego Calado
ALTER TABLE cinecap.sessao
  ALTER COLUMN data_inicio DROP NOT NULL;

ALTER TABLE cinecap.sessao
  ALTER COLUMN data_inicio TYPE TIMESTAMP(0) WITHOUT TIME ZONE;