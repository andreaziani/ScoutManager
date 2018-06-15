-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 10.0.3              
-- * Generator date: Aug 17 2017              
-- * Generation date: Wed Jun 13 10:05:46 2018 
-- * LUN file: C:\Users\andre\Desktop\progetto\application\master\PROGETTO_DB.lun 
-- * Schema: traduzione_logico/1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database traduzione_logico;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table acquisizione (
     nomeCompetenza varchar(20) not null,
     areaCompetenza varchar(20) not null,
     codiceIscritto varchar(10) not null,
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
     da int not null,
     a int not null,
     constraint IDCC_ID primary key (codiceCC));

create table CC_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceCC varchar(10) not null,
     constraint IDCC_ANNO primary key (codiceIscritto, anno),
     check(anno - dbo.CC_ANNO_check(codiceIscritto) > 20);

create FUNCTION CC_ANNO_check(@codiceIscritto varchar(10))
    RETURNS int
    AS
    BEGIN
     DECLARE @anno int;

     SELECT @anno = year(dataNascita) 
     FROM ISCRITTO I
     WHERE I.codiceIscritto = codiceIscritto

     RETURN @anno;

    END;
    GO

create table COMPETENZE (
     nomeCompetenza varchar(20) not null,
     areaCompetenza varchar(20) not null,
     constraint IDCOMPETENZE primary key (nomeCompetenza, areaCompetenza));

create table Contiene_CC (
     codiceParrocchia varchar(10) not null,
     codiceCC varchar(10) not null,
     constraint FKCon_PAR_ID primary key (codiceParrocchia),
     constraint FKCon_CC_ID unique (codiceCC));

create table Contiene_EG (
     codiceParrocchia varchar(10) not null,
     codiceEG varchar(10) not null,
     constraint FKCon_PAR_ID primary key (codiceParrocchia),
     constraint FKCon_EG_ID unique (codiceEG));

create table Contiene_LC (
     codiceParrocchia varchar(10) not null,
     codiceLC varchar(10) not null,
     constraint FKCon_PAR_ID primary key (codiceParrocchia),
     constraint FKCon_LC_ID unique (codiceLC));

create table Contiene_RS (
     codiceParrocchia varchar(10) not null,
     codiceRS varchar(10) not null,
     constraint FKCon_RS_PAR_ID primary key (codiceParrocchia),
     constraint FKCon_RS_ID unique (codiceRS));

create table E_NAZIONALE (
     codiceEvento varchar(10) not null,
     tipo varchar(20) not null,
     dataInizio date not null,
     dataFine date not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     constraint IDE_NAZIONALE_ID primary key (codiceEvento),
     constraint IDE_NAZIONALE_1 unique (dataInizio, dataFine));

create table E_P_EG (
     codiceParrocchia varchar(10) not null,
     tipo varchar(20) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento char(1) not null,
     constraint IDE_P_EG_1 unique (dataInizio, dataFine),
     constraint IDE_P_EG_ID primary key (codiceParrocchia, codiceEvento));

create table E_P_LC (
     codiceParrocchia varchar(10) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     tipo varchar(20) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     constraint IDE_P_LC_1 unique (dataInizio, dataFine),
     constraint IDE_P_LC_ID primary key (codiceParrocchia, codiceEvento));

create table E_P_RS (
     codiceParrocchia varchar(10) not null,
     tipo varchar(20) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     constraint IDE_P_RS_1 unique (dataInizio, dataFine),
     constraint IDE_P_RS_ID primary key (codiceParrocchia, codiceEvento));

create table E_P_TUTTI (
     codiceParrocchia varchar(10) not null,
     tipo varchar(20) not null,
     località varchar(16) not null,
     descrizione varchar(60) not null,
     dataInizio date not null,
     dataFine date not null,
     codiceEvento varchar(10) not null,
     constraint IDE_P_TUTTI_1 unique (dataInizio, dataFine),
     constraint IDE_P_TUTTI_ID primary key (codiceParrocchia, codiceEvento));

create table EG (
     codiceEG varchar(10) not null,
     da int not null,
     a int not null,
     constraint IDEG_ID primary key (codiceEG));

create table EG_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceEG varchar(10) not null,
     constraint IDEG_ANNO primary key (codiceIscritto, anno),
	 check( anno - dbo.CC_ANNO_check(codiceIscritto) > 11 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 16));

create table ETA(
     da int not null,
     a int not null,
     constraint IDFASCIA_ETA_ID primary key (da, a));

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
     luogoNascita varchar(20) not null,
     numeroTelefono int not null,
     constraint IDISCRITTO primary key (codiceIscritto),
     constraint IDISCRITTO_1 unique (CF));

create table LC (
     codiceLC varchar(10) not null,
     da int not null,
     a int not null,
     constraint IDLC_ID primary key (codiceLC));

create table LC_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceLC varchar(10) not null,
     constraint IDLC_ANNO primary key (codiceIscritto, anno),
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 7 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 11));

create table LUOGO (
     città varchar(20) not null,
     constraint IDLUOGO primary key (città));

create table PARROCCHIA (
     codiceParrocchia varchar(10) not null,
     nome varchar(16) not null,
     Ind_via varchar(20) not null,
     Ind_numCivico int not null,
     constraint IDPARROCCHIA_ID primary key (codiceParrocchia));

create table REGISTRAZIONE_E_N (
     codiceIscritto varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDREGISTRAZIONE_E_N primary key (codiceIscritto, codiceRegistrazione),
     check(dbo.REGISTRAZIONE_E_N_check(codiceIscritto, codiceEvento) = 'true');
    
create FUNCTION REGISTRAZIONE_E_N_check(@codiceIscritto varchar(10), @codiceEvento varchar(10))
    RETURNS varchar(5)
    AS
    BEGIN
    DECLARE @anno_iscritto int;
    DECLARE @anno_evento int;
    DECLARE @return varchar(5);

    select @anno_evento = year(dataInizio) 
    from E_NAZIONALE E 
    where E.codiceEvento = codiceEvento;
 
    IF EXISTS (select * 
        from RS_ANNO R 
        where R.codiceIscritto = codice_iscritto AND R.anno = @anno_evento))
    SET @return = 'true';
        ELSE
        SET @return = 'false';
    RETURN @return;

    END;
    GO

create table REGISTRAZIONE_E_P_EG (
     codiceIscritto varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_EG primary key (codiceIscritto, codiceRegistrazione),
     check(dbo.REGISTRAZIONE_E_P_EG_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true'));
    
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

create table REGISTRAZIONE_E_P_LC (
     codiceIscritto varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_LC primary key (codiceIscritto, codiceRegistrazione),
     check(dbo.REGISTRAZIONE_E_P_LC_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true'));

create table REGISTRAZIONE_E_P_RS (
     codiceIscritto varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_RS primary key (codiceIscritto, codiceRegistrazione),
     check(dbo.REGISTRAZIONE_E_P_RS_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true'));
     

create table REGISTRAZIONE_E_P_TUTTI (
     codiceIscritto varchar(10) not null,
     codiceRegistrazione varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     constraint IDREGISTRAZIONE_E_P_TUTTI primary key (codiceIscritto, codiceRegistrazione),
     check(dbo.REGISTRAZIONE_E_P_RS_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true' OR dbo.REGISTRAZIONE_E_P_LC_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true' OR dbo.REGISTRAZIONE_E_P_EG_check(codiceIscritto, codiceEvento, codiceParrocchia) = 'true'));

create table Residenza (
     codiceParrocchia varchar(10) not null,
     città varchar(20) not null,
     constraint FKRes_PAR_ID primary key (codiceParrocchia));

create table RESPONSABILE_E_N (
     CF varchar(16) not null,
     nome varchar(20) not null,
     cognome varchar(20) not null,
     dataNascita date not null,
     luogoNascita varchar(20) not null,
     numeroTelefono varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     username varchar(10) not null,
     password varchar(10) not null,
     constraint IDRESPONSABILE unique (codiceResponsabile),
     constraint IDRESPONSABILE_E_N unique (username),
     constraint IDRESPONSABILE_E_N_1 primary key (CF));

create table RESPONSABILE_P (
     codiceResponsabile varchar(10) not null,
     CF varchar(16) not null,
     nome varchar(20) not null,
     cognome varchar(20) not null,
     dataNascita date not null,
     luogoNascita varchar(20) not null,
     numeroTelefono varchar(10) not null,
     username varchar(10) not null,
     password varchar(8) not null,
     constraint IDRESPONSABILE_P_ID primary key (codiceResponsabile),
     constraint IDRESPONSABILE_P_1 unique (CF),
     constraint IDRESPONSABILE_P_2 unique (username));

create table Responsabilità_E_N (
     codiceEvento varchar(10) not null,
     CF varchar(16) not null,
     constraint FKRes_E_N_ID primary key (codiceEvento));

create table Responsabilità_E_P_EG (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento),
     check(dbo.RESPONSABILITA_E_P_EG_check(codiceResponsabile, codiceEvento, codiceParrocchia) = 'true'));

     select @codiceParrocchia = codiceParrocchia
     from Responsabilità_parrocchia R
     where R.codiceResponsabile = @codiceResponsabile

    IF EXISTS (select *
    from E_P_EG E
    where E.codiceEvento = @codiceEvento AND E.codiceParrocchia = @codiceParrocchia)
    BEGIN 
        RETURN 'true'
    END
    RETURN 'false'

create table Responsabilità_E_P_LC (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento),
     check(dbo.RESPONSABILITA_E_P_LC_check(codiceResponsabile, codiceEvento, codiceParrocchia) = 'true'));

create table Responsabilità_E_P_RS (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento),
     check(dbo.RESPONSABILITA_E_P_RS_check(codiceResponsabile, codiceEvento, codiceParrocchia) = 'true'));

create table Responsabilità_E_P_TUTTI (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceResponsabile varchar(10) not null,
     constraint FKRes_E_P_ID primary key (codiceParrocchia, codiceEvento)
     check(dbo.RESPONSABILITA_E_P_TUTTI_check(codiceResponsabile, codiceEvento, codiceParrocchia) = 'true'));

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
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint IDRicreazione_LC primary key (codiceParrocchia, codiceEvento, codiceAttività));

create table Ricreazione_T (
     codiceParrocchia varchar(10) not null,
     codiceEvento varchar(10) not null,
     codiceAttività varchar(10) not null,
     constraint FKRic_E_P_ID primary key (codiceParrocchia, codiceEvento));

create table RS (
     codiceRS varchar(10) not null,
     codiceParrocchia varchar(10) not null,
     da int not null,
     a int not null,
     constraint IDRS primary key (codiceRS),
     constraint FKCon_RS_ID unique (codiceParrocchia));

create table RS_ANNO (
     codiceIscritto varchar(10) not null,
     anno int not null,
     codiceRS varchar(10) not null,
     constraint IDRS_ANNO primary key (codiceIscritto, anno),
     check( anno - dbo.CC_ANNO_check(codiceIscritto) > 15 AND anno - dbo.CC_ANNO_check(codiceIscritto) < 20)));


-- Constraints Section
-- ___________________ 

alter table acquisizione add constraint FKacq_ISC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table acquisizione add constraint FKacq_COM
     foreign key (nomeCompetenza, areaCompetenza)
     references COMPETENZE;

alter table CC add constraint IDCC_CHK
     check(exists(select * from Contiene_CC
                  where Contiene_CC.codiceCC = codiceCC)); 

alter table CC add constraint FKfascia_età_CC
     foreign key (da, a)
     references ETA';

alter table CC_ANNO add constraint FKiscrizione_CC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table CC_ANNO add constraint FKattivazione_CC
     foreign key (codiceCC)
     references CC;

alter table Contiene_CC add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_CC add constraint FKCon_CC_FK
     foreign key (codiceCC)
     references CC;

alter table Contiene_EG add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_EG add constraint FKCon_EG_FK
     foreign key (codiceEG)
     references EG;

alter table Contiene_LC add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table Contiene_LC add constraint FKCon_LC_FK
     foreign key (codiceLC)
     references LC;

alter table Contiene_RS add constraint FKCon_PAR_CHK
     check(exists(select * from RS
                  where RS.codiceParrocchia = codiceParrocchia)); 

alter table Contiene_RS add constraint FKCon_PAR_FK
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_NAZIONALE add constraint IDE_NAZIONALE_CHK
     check(exists(select * from Responsabilità_E_N
                  where Responsabilità_E_N.codiceEvento = codiceEvento)); 

alter table E_NAZIONALE add constraint IDE_NAZIONALE_CHK
     check(exists(select * from Formazione_Nazionale
                  where Formazione_Nazionale.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Responsabilità_E_P_EG
                  where Responsabilità_E_P_EG.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Ricreazione_EG
                  where Ricreazione_EG.codiceParrocchia = codiceParrocchia and Ricreazione_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint IDE_P_EG_CHK
     check(exists(select * from Formazione_Parrocchiale_EG
                  where Formazione_Parrocchiale_EG.codiceParrocchia = codiceParrocchia and Formazione_Parrocchiale_EG.codiceEvento = codiceEvento)); 

alter table E_P_EG add constraint FKOrganizza_E_P_EG
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_P_LC add constraint IDE_P_LC_CHK
     check(exists(select * from Responsabilità_E_P_LC
                  where Responsabilità_E_P_LC.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_LC.codiceEvento = codiceEvento)); 

alter table E_P_LC add constraint IDE_P_LC_CHK
     check(exists(select * from Ricreazione_LC
                  where Ricreazione_LC.codiceParrocchia = codiceParrocchia and Ricreazione_LC.codiceEvento = codiceEvento)); 

alter table E_P_LC add constraint FKOrganizza_E_P_LC
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_P_RS add constraint IDE_P_RS_CHK
     check(exists(select * from Responsabilità_E_P_RS
                  where Responsabilità_E_P_RS.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_RS.codiceEvento = codiceEvento)); 

alter table E_P_RS add constraint IDE_P_RS_CHK
     check(exists(select * from Formazione_Parrocchiale_RS
                  where Formazione_Parrocchiale_RS.codiceParrocchia = codiceParrocchia and Formazione_Parrocchiale_RS.codiceEvento = codiceEvento)); 

alter table E_P_RS add constraint FKOrganizza_E_P_RS
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table E_P_TUTTI add constraint IDE_P_TUTTI_CHK
     check(exists(select * from Responsabilità_E_P_TUTTI
                  where Responsabilità_E_P_TUTTI.codiceParrocchia = codiceParrocchia and Responsabilità_E_P_TUTTI.codiceEvento = codiceEvento)); 

alter table E_P_TUTTI add constraint IDE_P_TUTTI_CHK
     check(exists(select * from Ricreazione_T
                  where Ricreazione_T.codiceParrocchia = codiceParrocchia and Ricreazione_T.codiceEvento = codiceEvento)); 

alter table E_P_TUTTI add constraint FKOrganizza_E_P_TUTTI
     foreign key (codiceParrocchia)
     references PARROCCHIA;

alter table EG add constraint IDEG_CHK
     check(exists(select * from Contiene_EG
                  where Contiene_EG.codiceEG = codiceEG)); 

alter table EG add constraint FKfascia_età_EG
     foreign key (da, a)
     references ETA';

alter table EG_ANNO add constraint FKiscrizione_EG
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table EG_ANNO add constraint FKAttivazione_EG
     foreign key (codiceEG)
     references EG;

alter table ETA' add constraint IDFASCIA_ETA'_CHK
     check(exists(select * from LC
                  where LC.da = da and LC.a = a)); 

alter table ETA' add constraint IDFASCIA_ETA'_CHK
     check(exists(select * from EG
                  where EG.da = da and EG.a = a)); 

alter table ETA' add constraint IDFASCIA_ETA'_CHK
     check(exists(select * from RS
                  where RS.da = da and RS.a = a)); 

alter table ETA' add constraint IDFASCIA_ETA'_CHK
     check(exists(select * from CC
                  where CC.da = da and CC.a = a)); 

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

alter table LC add constraint FKfascia_età_LC
     foreign key (da, a)
     references ETA';

alter table LC_ANNO add constraint FKiscrizione_LC
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table LC_ANNO add constraint FKAttivazione_LC
     foreign key (codiceLC)
     references LC;

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Responsabilità_parrocchia
                  where Responsabilità_parrocchia.codiceParrocchia = codiceParrocchia)); 

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Contiene_LC
                  where Contiene_LC.codiceParrocchia = codiceParrocchia)); 

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Contiene_EG
                  where Contiene_EG.codiceParrocchia = codiceParrocchia)); 

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Contiene_RS
                  where Contiene_RS.codiceParrocchia = codiceParrocchia)); 

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Contiene_CC
                  where Contiene_CC.codiceParrocchia = codiceParrocchia)); 

alter table PARROCCHIA add constraint IDPARROCCHIA_CHK
     check(exists(select * from Residenza
                  where Residenza.codiceParrocchia = codiceParrocchia)); 

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

alter table RESPONSABILE_P add constraint IDRESPONSABILE_P_CHK
     check(exists(select * from Responsabilità_parrocchia
                  where Responsabilità_parrocchia.codiceResponsabile = codiceResponsabile)); 

alter table Responsabilità_E_N add constraint FKRes_E_N_FK
     foreign key (codiceEvento)
     references E_NAZIONALE;

alter table Responsabilità_E_N add constraint FKRes_RES
     foreign key (CF)
     references RESPONSABILE_E_N;

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

alter table Responsabilità_E_P_RS add constraint FKRes_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_RS;

alter table Responsabilità_E_P_RS add constraint FKRes_RES
     foreign key (codiceResponsabile)
     references RESPONSABILE_P;

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

alter table Ricreazione_LC add constraint FKRic_ATT
     foreign key (codiceAttività)
     references ATT_LUDICA;

alter table Ricreazione_LC add constraint FKRic_E_P
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_LC;

alter table Ricreazione_T add constraint FKRic_ATT
     foreign key (codiceAttività)
     references ATT_LUDICA;

alter table Ricreazione_T add constraint FKRic_E_P_FK
     foreign key (codiceParrocchia, codiceEvento)
     references E_P_TUTTI;

alter table RS add constraint FKCon_RS_FK
     foreign key (codiceParrocchia)
     references Contiene_RS;

alter table RS add constraint FKfascia_età_RS
     foreign key (da, a)
     references ETA';

alter table RS_ANNO add constraint FKiscrizione_RS
     foreign key (codiceIscritto)
     references ISCRITTO;

alter table RS_ANNO add constraint FKAttivazione_RS
     foreign key (codiceRS)
     references RS;


-- Index Section
-- _____________ 

