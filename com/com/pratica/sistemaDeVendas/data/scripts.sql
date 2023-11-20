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