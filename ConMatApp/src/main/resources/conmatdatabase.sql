-- DROP SCHEMA IF EXISTS `materiaisdb`;
-- -----------------------------------------------------
-- Schema materiaisdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `materiaisdb`;
USE `materiaisdb`;

-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(30) NOT NULL,
  `usuario` VARCHAR(30) NOT NULL,
  `senha` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Professor` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `nomeProf` VARCHAR(45) NOT NULL,
  `nascProf` DATE NOT NULL,
  `salario` DECIMAL(8,2) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `fk_Professor_Usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `materiaisdb`.`Usuario` (`idUsuario`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Aluno` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `nomeAluno` VARCHAR(45) NOT NULL,
  `turma` VARCHAR(10) NOT NULL,
  `nascAluno` DATE NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `fk_Aluno_Usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `materiaisdb`.`Usuario` (`idUsuario`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `dataReserva` DATE NOT NULL,
  `matProf` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  CONSTRAINT `fk_Reserva_Professor`
    FOREIGN KEY (`matProf`)
    REFERENCES `materiaisdb`.`Professor` (`matricula`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Emprestimo` (
  `idEmprestimo` INT NOT NULL AUTO_INCREMENT,
  `dataEmprestimo` DATE NOT NULL,
  `prazoEntrega` DATE NOT NULL,
  `matAluno` INT NOT NULL,
  PRIMARY KEY (`idEmprestimo`),
  CONSTRAINT `fk_Emprestimo_Aluno`
    FOREIGN KEY (`matAluno`)
    REFERENCES `materiaisdb`.`Aluno` (`matricula`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Material` (
  `idMaterial` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `descricao` VARCHAR(200) NULL,
  `status` VARCHAR(20) NOT NULL,
  `idReserva` INT NULL,
  `idEmprestimo` INT NULL,
  PRIMARY KEY (`idMaterial`),
  INDEX `fk_Material_Reserva1_idx` (`idReserva` ASC),
  INDEX `fk_Material_Emprestimo1_idx` (`idEmprestimo` ASC),
  CONSTRAINT `fk_Material_Reserva`
    FOREIGN KEY (`idReserva`)
    REFERENCES `materiaisdb`.`Reserva` (`idReserva`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Material_Emprestimo`
    FOREIGN KEY (`idEmprestimo`)
    REFERENCES `materiaisdb`.`Emprestimo` (`idEmprestimo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Historico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Historico` (
  `idHistorico` INT NOT NULL AUTO_INCREMENT,
  `matProf` INT NOT NULL,
  `idReserva` INT NULL,
  `idEmprestimo` INT NULL,
  PRIMARY KEY (`idHistorico`),
  CONSTRAINT `fk_Historico_Professor`
    FOREIGN KEY (`matProf`)
    REFERENCES `materiaisdb`.`Professor` (`matricula`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Historico_Reserva`
    FOREIGN KEY (`idReserva`)
    REFERENCES `materiaisdb`.`Reserva` (`idReserva`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Historico_Emprestimo`
    FOREIGN KEY (`idEmprestimo`)
    REFERENCES `materiaisdb`.`Emprestimo` (`idEmprestimo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- INSERCAO DE ALGUNS DADOS NAS TABELAS
-- -----------------------------------------------------

INSERT INTO `Usuario`(`email`, `usuario`, `senha`) VALUES
('severino.jorge@gmail.com', 'sevjorge', 'jorge123'),
('miguel@hotmail.com', 'bryanmiguel12', 'bryan145'),
('natalia_lavinia@gmail.com', 'natallia14', 'natlav155'),
('leo_claudio@email.com', 'leoclaudio', 'souzaleo556'),
('isadora.maite.12@hotmail.com', 'isadoramaite', 'isaa1447'),
('hcarlos@email.com', 'carlosedu', 'hugooc114'),
('andrea_pereira@gmail.com', 'liviaandrea88', 'liandrea576'),
('marli_silva@outloook.com', 'maarli_luiza', 'marli123');

INSERT INTO `Aluno` (`nomeAluno`, `turma`, `nascAluno`, `idUsuario`) VALUES
('Miguel Bryan Aragão', 'A', '1989-07-08', '2'),
('Natália Lavínia Fernandes', 'C', '1998-08-03', '3'),
('Leonardo Cláudio Souza', 'A', '2000-11-20', '4'),
('Isadora Maitê Yasmin Monteiro', 'B', '1989-03-11', '5');

INSERT INTO `Professor` (`nomeProf`, `nascProf`, `salario`, `idUsuario`) VALUES
('Severino Jorge Duarte', '1969-01-14', '1232.35', '1'),
('Marli Luzia Silva', '1968-09-19', '1322.20', '8'),
('Hugo Carlos Eduardo Geraldo Aparício', '1965-04-02', '1532.50', '6'),
('Andrea Lívia Pereira', '1972-12-21', '1634.80', '7');

INSERT INTO `Material` (`nome`, `autor`,`dataCadastro`,`descricao`,`status`) VALUES
('Ábaco de Pinos', 'Miguel Bryan Aragão', '2017-05-04', 'indicado para compreender o sistema de numeração decimal e explorar as operações de adição, subtração, etc', 'emprestado'),
('Dominó de Frações', 'Isadora Maitê Yasmin Monteiro', '2017-08-28', 'dominó indicado para o aprendizado da representação fracionária', 'disponível'),
('Geoplano Quadrado', 'Hugo Carlos Eduardo Geraldo Aparício', '2017-09-23', 'contrução de figuras geométricas', 'disponível'),
('Material Dourado', 'Isadora Maitê Yasmin Monteiro', '2017-11-25', 'auxilia no ensino e a aprendizagem do sistema de numeração decimal-posicional e dos algoritmos', 'reservado'),
('Tangram Quadrado', 'Andrea Lívia Pereira', '2018-04-18', 'quebra-cabeças chinês para estudo de figuras geométricas e trabalhar o raciocínio', 'disponível');

-- INSERT INTO `Emprestimo` (`dataEmprestimo`, `prazoEntrega`) VALUES ('2019-02-21', '2019-03-10');

-- INSERT INTO `Reserva` (`dataReserva`) VALUES ('2018-09-21');