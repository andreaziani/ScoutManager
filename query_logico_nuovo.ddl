-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 10.0.3              
-- * Generator date: Aug 17 2017              
-- * Generation date: Thu Jun 21 20:28:15 2018 
-- * LUN file: C:\Users\andre\Desktop\progetto\application\master\PROGETTO_DB.lun 
-- * Schema: traduzione_logico_corretto/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database traduzione_logico_corretto;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table acquisizione (
     codiceIscritto varchar(10) not null,
     nomeCompetenza varchar(20) not null,
     areaCompetenza varchar(20) not null,
     constraint IDacquisizione primary key (nomeCompetenza, areaCompetenza, codiceIscritto));

create table ATT_FORMATIVA (
     codiceAttività varchar(10) not null,
     descrizione varchar(60) not null,
     constraint IDATT_FORMATIVA primary key (codiceAttività));

create table ATT_LUDICA (
     codiceAttività varchar(10) not null,
     descrizione varchar(60) not null,
     constraint IDATT_LUDICA primary key (codiceAttività));

create table CC (
     codiceCC varchar(10) not null,
     constraint IDCC_ID primary key (codiceCC));

create table CC_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceCC varchar(10) not null,
     constraint IDCC_ANNO primary key (codiceIscritto, anno));

create table COMPETENZE (
     nomeCompetenza varchar(20) not null,
     areaCompetenza varchar(20) not null,
     constraint IDCOMPETENZE primary key (nomeCompetenza, areaCompetenza));

create table Contiene_CC (
     codiceCC varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     constraint FKCon_CC_ID primary key (codiceCC),
     constraint FKCon_PAR_ID unique (codiceParrocchia));

create table Contiene_EG (
     codiceEG varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     constraint FKCon_EG_ID primary key (codiceEG),
     constraint FKCon_PAR_ID unique (codiceParrocchia));

create table Contiene_LC (
     codiceLC varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     constraint FKCon_LC_ID primary key (codiceLC),
     constraint FKCon_PAR_ID unique (codiceParrocchia));

create table Contiene_RS (
     codiceRS varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     constraint FKCon_RS_ID primary key (codiceRS),
     constraint FKCon_PAR_ID unique (codiceParrocchia));

create table E_NAZIONALE (
     codiceEvento varchar(10) not null,
     tipo varchar(16) not null,
     dataInizio date not null,
     dataFine date not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     constraint IDE_NAZIONALE_ID primary key (codiceEvento),
     constraint IDE_NAZIONALE_1 unique (dataInizio, dataFine));

create table E_P_EG (
     codiceParrocchia varchar(10) not null,
     tipo varchar(16) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     constraint IDE_P_EG_ID primary key (codiceParrocchia, codiceEvento),
     constraint IDE_P_EG_1 unique (dataInizio, dataFine));

create table E_P_LC (
     codiceParrocchia varchar(10) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     tipo varchar(16) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     constraint IDE_P_LC_ID primary key (codiceParrocchia, codiceEvento),
     constraint IDE_P_LC_1 unique (dataInizio, dataFine));

create table E_P_RS (
     codiceParrocchia varchar(10) not null,
     tipo varchar(16) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     constraint IDE_P_RS_ID primary key (codiceParrocchia, codiceEvento),
     constraint IDE_P_RS_1 unique (dataInizio, dataFine));

create table E_P_TUTTI (
     codiceParrocchia varchar(10) not null,
     tipo varchar(16) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     constraint IDE_P_TUTTI_ID primary key (codiceParrocchia, codiceEvento),
     constraint IDE_P_TUTTI_1 unique (dataInizio, dataFine));

create table EG (
     codiceEG varchar(10) not null,
     constraint IDEG_ID primary key (codiceEG));

create table EG_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceEG varchar(10) not null,
     constraint IDEG_ANNO primary key (codiceIscritto, anno));

create table Formazione_Nazionale (
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint IDFormazione_Nazionale primary key (codiceEvento, codiceAttività));

create table Formazione_Parrocchiale_EG (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint IDFormazione_Parrocchiale_EG primary key (codiceParrocchia, codiceEvento, codiceAttività));

create table Formazione_Parrocchiale_RS (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint IDFormazione_Parrocchiale_RS primary key (codiceParrocchia, codiceEvento, codiceAttività));

create table ISCRITTO (
     codiceIscritto varchar(10) not null,
     CF varchar(16) not null,
     nome varchar(15) not null,
     cognome varchar(15) not null,
     dataNascita date not null,
     luogoNascita varchar(15) not null,
     numeroTelefono varchar(10) not null,
     constraint IDISCRITTO primary key (codiceIscritto),
     constraint IDISCRITTO_1 unique (CF));

create table LC (
     codiceLC varchar(10) not null,
     constraint IDLC_ID primary key (codiceLC));

create table LC_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceLC varchar(10) not null,
     constraint IDLC_ANNO primary key (codiceIscritto, anno));

create table LUOGO (
     città varchar(20) not null,
     constraint IDLUOGO primary key (città));

create table PARROCCHIA (
     codiceParrocchia varchar(10) not null,
     nome varchar(16) not null,
     Ind_via varchar(20) not null,
     Ind_numCivico int not null,
     constraint IDPARROCCHIA primary key (codiceParrocchia));

create table REGISTRAZIONE_E_N (
     codiceEvento varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceIscritto varchar(10) not null,
     constraint IDREGISTRAZIONE_E_N primary key (codiceEvento, codiceRegistrazione));

create table REGISTRAZIONE_E_P_EG (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceIscritto varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_EG primary key (codiceParrocchia, codiceEvento, codiceRegistrazione));

create table REGISTRAZIONE_E_P_LC (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceIscritto varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_LC primary key (codiceParrocchia, codiceEvento, codiceRegistrazione));

create table REGISTRAZIONE_E_P_RS (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceIscritto varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_RS primary key (codiceParrocchia, codiceEvento, codiceRegistrazione));

create table REGISTRAZIONE_E_P_TUTTI (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceIscritto varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_TUTTI primary key (codiceParrocchia, codiceEvento, codiceRegistrazione));

create table Residenza (
     codiceParrocchia varchar(10) not null,
     città varchar(20) not null,
     constraint FKRes_PAR_ID primary key (codiceParrocchia));

create table RESPONSABILE_E_N (
     CF varchar(16) not null,
     nome varchar(15) not null,
     cognome varchar(15) not null,
     dataNascita date not null,
     luogoNascita varchar(15) not null,
     numeroTelefono varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     username varchar(10) not null,
     password varchar(10) not null,
     constraint IDRESPONSABILE_E_N primary key (codiceResponsabile),
     constraint IDRESPONSABILE_E_N_1 unique (CF),
     constraint IDRESPONSABILE_E_N_2 unique (username));

create table RESPONSABILE_P (
     codiceResponsabile varchar(10) not null,
     CF varchar(16) not null,
     nome varchar(15) not null,
     cognome varchar(15) not null,
     dataNascita date not null,
     luogoNascita varchar(20) not null,
     numeroTelefono varchar(10) not null,
     username varchar(10) not null,
     password varchar(10) not null,
     constraint IDRESPONSABILE_P primary key (codiceResponsabile),
     constraint IDRESPONSABILE_P_1 unique (CF),
     constraint IDRESPONSABILE_P_2 unique (username));

create table Responsabilità_E_N (
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_N_ID primary key (codiceEvento));

create table Responsabilità_E_P_EG (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table Responsabilità_E_P_LC (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table Responsabilità_E_P_RS (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table Responsabilità_E_P_TUTTI (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table Responsabilità_parrocchia (
     codiceResponsabile varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     constraint FKRes_RES_ID primary key (codiceResponsabile),
     constraint FKRes_PAR_ID unique (codiceParrocchia));

create table Ricreazione_EG (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint IDRicreazione_EG primary key (codiceParrocchia, codiceEvento, codiceAttività));

create table Ricreazione_LC (
     codiceAttività varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDRicreazione_LC primary key (codiceParrocchia, codiceEvento, codiceAttività));

create table Ricreazione_T (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint FKRic_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table RS (
     codiceRS varchar(10) not null,
     constraint IDRS_ID primary key (codiceRS));

create table RS_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceRS varchar(10) not null,
     constraint IDRS_ANNO primary key (codiceIscritto, anno));


-- Constraints Section
-- ___________________ 

alter table acquisizione add constraint FKacq_COM
     foreign key (nomeCompetenza, areaCompetenza)
     references COMPETENZE;

alter table acquisizione add constraint FKacq_ISC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table CC add constraint IDCC_CHK // MI SA CHE E' INUTILE QUESTA
     check(exists(select * from Contiene_CC
                  where Contiene_CC.codiceCC = codiceCC)); 

alter table CC_ANNO add constraint FKiscrizione_CC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table CC_ANNO add constraint FKattivazione_CC
     foreign key (codiceCC)
     references CC;

alter table Contiene_CC add constraint FKCon_CC_FK
     foreign key (codiceCC)
     references CC;

alter table Contiene_CC add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_EG add constraint FKCon_EG_FK
     foreign key (codiceEG)
     references EG;

alter table Contiene_EG add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_LC add constraint FKCon_LC_FK
     foreign key (codiceLC)
     references LC;

alter table Contiene_LC add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_RS add constraint FKCon_RS_FK
     foreign key (codiceRS)
     references RS;

alter table Contiene_RS add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

// non li ho messi 
alter table E_NAZIONALE add constraint IDE_NAZIONALE_CHK 
     check(exists(select * from Responsabilità_E_N
                  where Responsabilità_E_N.codiceEvento = codiceEvento)); 

alter table E_NAZIONALE add constraint IDE_NAZIONALE_CHK 
     check(exists(select * from Formazione_Nazionale
                  where Formazione_Nazionale.codiceEvento = codiceEvento)); 

create FUNCTION IDE_Nazionale_check(@codiceEvento varchar(10))
    RETURNS varchar(5)
    AS
    BEGIN
    DECLARE @return varchar(5);
    IF EXISTS (select * from Responsabilità_E_N
                  where Responsabilità_E_N.codiceEvento =  @codiceEvento)
	SET
	@return = 'true';
	ELSE
	SET @return = 'false';

    RETURN @return;

    END;
    GO

// queste tre sotto non le ho messe perchè vincolano a registrare prima la ricreazione rispetto all'evento di parrocchia
alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Ricreazione_EG
                  where Ricreazione_EG.codiceParrocchia = codiceParrocchia and Ricreazione_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Responsabilità_E_P_EG
                  where Responsabilità_E_P_EG.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Formazione_Parrocchiale_EG
                  where Formazione_Parrocchiale_EG.codiceParrocchia = codiceParrocchia and Formazione_Parrocchiale_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint FKOrganizza_E_P_EG
     foreign key (codiceParrocchia)
     references PARROCCHIA;

// anche questi due check
alter table E_P_LC add constraint IDE_P_LC_CHK
     check(exists(select * from Ricreazione_LC
                  where Ricreazione_LC.codiceParrocchia = codiceParrocchia and Ricreazione_LC.codiceEvento = codiceEvento)); 

alter table E_P_LC add constraint IDE_P_LC_CHK
     check(exists(select * from Responsabilità_E_P_LC
                  where Responsabilità_E_P_LC.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_LC.codiceEvento = codiceEvento)); 

alter table E_P_LC add constraint FKOrganizza_E_P_LC
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_P_RS add constraint IDE_P_RS_CHK
     check(exists(select * from Formazione_Parrocchiale_RS
                  where Formazione_Parrocchiale_RS.codiceParrocchia = codiceParrocchia and Formazione_Parrocchiale_RS.codiceEvento = codiceEvento)); 

alter table E_P_RS add constraint IDE_P_RS_CHK
     check(exists(select * from Responsabilità_E_P_RS
                  where Responsabilità_E_P_RS.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_RS.codiceEvento = codiceEvento)); 

alter table E_P_RS add constraint FKOrganizza_E_P_RS
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_P_TUTTI add constraint IDE_P_TUTTI_CHK
     check(exists(select * from Ricreazione_T
                  where Ricreazione_T.codiceParrocchia = codiceParrocchia and Ricreazione_T.codiceEvento = codiceEvento)); 

alter table E_P_TUTTI add constraint IDE_P_TUTTI_CHK
     check(exists(select * from Responsabilità_E_P_TUTTI
                  where Responsabilità_E_P_TUTTI.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_TUTTI.codiceEvento = codiceEvento)); 

alter table E_P_TUTTI add constraint FKOrganizza_E_P_TUTTI
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table EG add constraint IDEG_CHK // inutile
     check(exists(select * from Contiene_EG
                  where Contiene_EG.codiceEG = codiceEG)); 

alter table EG_ANNO add constraint FKiscrizione_EG
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table EG_ANNO add constraint FKAttivazione_EG
     foreign key (codiceEG)
     references EG;

alter table Formazione_Nazionale add constraint FKFor_ATT
     foreign key (codiceAttività)
     references ATT_FORMATIVA;

alter table Formazione_Nazionale add constraint FKFor_E_N
     foreign key (codiceEvento)
     references E_NAZIONALE;

alter table Formazione_Parrocchiale_EG add constraint FKFor_ATT
     foreign key (codiceAttività)
     references ATT_FORMATIVA;

alter table Formazione_Parrocchiale_EG add constraint FKFor_E_P
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_EG;

alter table Formazione_Parrocchiale_RS add constraint FKFor_ATT
     foreign key (codiceAttività)
     references ATT_FORMATIVA;

alter table Formazione_Parrocchiale_RS add constraint FKFor_E_P
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_RS;

alter table LC add constraint IDLC_CHK
     check(exists(select * from Contiene_LC
                  where Contiene_LC.codiceLC = codiceLC)); 

alter table LC_ANNO add constraint FKiscrizione_LC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table LC_ANNO add constraint FKAttivazione_LC
     foreign key (codiceLC)
     references LC;

alter table REGISTRAZIONE_E_N add constraint FKregistra_a_E_N
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table REGISTRAZIONE_E_N add constraint FKregistrato_a_E_N
     foreign key (codiceEvento)
     references E_NAZIONALE;

alter table REGISTRAZIONE_E_P_EG add constraint FKregistra_a_E_P_EG
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table REGISTRAZIONE_E_P_EG add constraint FKregistrato_a_E_P_EG
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_EG;

alter table REGISTRAZIONE_E_P_LC add constraint FKregistra_a_E_P_LC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table REGISTRAZIONE_E_P_LC add constraint FKregistrato_a_E_P_LC
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_LC;

alter table REGISTRAZIONE_E_P_RS add constraint FKregistra_a_E_P_RS
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table REGISTRAZIONE_E_P_RS add constraint FKregistrato_a_E_P_RS
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_RS;

alter table REGISTRAZIONE_E_P_TUTTI add constraint FKregistra_a_E_P_TUTTI
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table REGISTRAZIONE_E_P_TUTTI add constraint FKregistrato_a_E_P_TUTTI
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_TUTTI;

alter table Residenza add constraint FKRes_LUO
     foreign key (città)
     references LUOGO;

alter table Residenza add constraint FKRes_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Responsabilità_E_N add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_E_N;

alter table Responsabilità_E_N add constraint FKRes_E_N_FK
     foreign key (codiceEvento)
     references E_NAZIONALE;

alter table Responsabilità_E_P_EG add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

alter table Responsabilità_E_P_EG add constraint FKRes_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_EG;

alter table Responsabilità_E_P_LC add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

alter table Responsabilità_E_P_LC add constraint FKRes_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_LC;

alter table Responsabilità_E_P_RS add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

alter table Responsabilità_E_P_RS add constraint FKRes_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_RS;

alter table Responsabilità_E_P_TUTTI add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

alter table Responsabilità_E_P_TUTTI add constraint FKRes_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_TUTTI;

alter table Responsabilità_parrocchia add constraint FKRes_RES_FK
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

alter table Responsabilità_parrocchia add constraint FKRes_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Ricreazione_EG add constraint FKRic_ATT
     foreign key (codiceAttività)
     references ATT_LUDICA;

alter table Ricreazione_EG add constraint FKRic_E_P
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_EG;

alter table Ricreazione_LC add constraint FKRic_E_P
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_LC;

alter table Ricreazione_LC add constraint FKRic_ATT
     foreign key (codiceAttività)
     references ATT_LUDICA;

alter table Ricreazione_T add constraint FKRic_ATT
     foreign key (codiceAttività)
     references ATT_LUDICA;

alter table Ricreazione_T add constraint FKRic_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_TUTTI;

alter table RS add constraint IDRS_CHK
     check(exists(select * from Contiene_RS
                  where Contiene_RS.codiceRS = codiceRS)); 

alter table RS_ANNO add constraint FKiscrizione_RS
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table RS_ANNO add constraint FKAttivazione_RS
     foreign key (codiceRS)
     references RS;

alter table CC_ANNO add constraint IDCC_ANNO_check_CHK
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 20);

alter table RS_ANNO add constraint IDRS_ANNO_check_CHK
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 15 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 21);

alter table EG_ANNO add constraint IDEG_ANNO_check_CHK
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 10 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 16);

alter table LC_ANNO add constraint IDLC_ANNO_check_CHK
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 7 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 11);


alter table REGISTRAZIONE_E_P_EG add constraint IDREG_E_P_EG_CHK
    check(dbo.REGISTRAZIONE_E_P_EG_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true');

create FUNCTION REGISTRAZIONE_E_P_EG_check(@codiceIscritto varchar(10), @codiceEvento varchar(10), @codiceParrocchia varchar(10))
    RETURNS varchar(5)
    AS
    BEGIN
    DECLARE @annoIscritto int;
    DECLARE @annoEvento int;
    DECLARE @codiceBranca varchar(10);
    DECLARE @return varchar(5);
    DECLARE @return2 varchar(5);
    DECLARE @false varchar(5);
    SET @false = 'false';

    select @annoEvento = year(dataInizio) 
    from E_P_EG E 
    where E.codiceEvento = codiceEvento;

    IF EXISTS ( select * 
        from EG_ANNO E 
        where E.codiceIscritto = @codiceIscritto AND E.anno = @annoEvento)
    SET @return2 = 'true'
    ELSE SET @return2 = 'false'

    select @codiceBranca = codiceEG 
    from EG_ANNO E
    where E.codiceIscritto = @codiceIscritto AND E.anno = @annoEvento

    IF EXISTS (select *
    from Contiene_EG C 
    where C.codiceParrocchia = @codiceParrocchia AND C.codiceEG = @codiceBranca)
    SET @return = 'true'
    ELSE 
    SET @return = 'false'
    IF (@return = 'true' AND @return2 = 'true')
    BEGIN
    RETURN @return;
    END
    RETURN @false;
    END;
    GO

alter table REGISTRAZIONE_E_P_LC add constraint IDREG_E_P_LC_CHK
    check(dbo.REGISTRAZIONE_E_P_LC_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true'); // queste funzioni sono uguali a quella sopra solo cambiando le tabelle

alter table REGISTRAZIONE_E_P_RS add constraint IDREG_E_P_RS_CHK
    check(dbo.REGISTRAZIONE_E_P_RS_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true');

alter table REGISTRAZIONE_E_P_TUTTI add constraint IDREG_E_P_TUTTI_CHK
check(dbo.REGISTRAZIONE_E_P_RS_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true' OR dbo.REGISTRAZIONE_E_P_LC_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true' OR dbo.REGISTRAZIONE_E_P_EG_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true');
-- Index Section
-- _____________ 

