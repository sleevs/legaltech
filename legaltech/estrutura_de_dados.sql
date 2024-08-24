
CREATE TABLE usuario (
  usuario_id SERIAL PRIMARY KEY, 
  usuario_nome VARCHAR (50)  ,
  usuario_email VARCHAR (50) 

);


CREATE TABLE processo (
  processo_id SERIAL PRIMARY KEY, 
  processo_descricao VARCHAR (50)  ,
  processo_numero INT  ,
  usuario_id INT ,
  processo_data TIMESTAMP

);


CREATE TABLE reu (
  reu_id SERIAL PRIMARY KEY, 
  reu_nome VARCHAR (50)  ,
  reu_descricao VARCHAR (50) ,
  processo_numero INT 

);
