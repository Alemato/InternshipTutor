<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Moduli</title>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>
    <link href="httpshttps://fonts.googleapis.com/css?family=Taviraj:600" rel="stylesheet" type="text/css">

    <!-- CORE CSS -->
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <div id="header" class="navbar-toggleable-md  shadow-after-3 clearfix position-fixed d-print-none">
        <!-- TOP BAR-->
        <div id="topBar" class="dark sticky">
            <div class="container">

                <!-- right -->
                <ul class="top-links list-inline float-right has-topBar">
                    <li>
                        <a class="dropdown-toggle no-text-underline" data-toggle="dropdown" href="#"><i
                                class="fa fa-user hidden-xs-down"></i> IL MIO ACCOUNT </a>
                        <ul class="dropdown-menu float-right has-topBar">
                            <li><a tabindex="-1" href="#"><i class="fa fa-history"></i> I MIEI
                                TIROCINI</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="#"><i class="fa fa-cog"></i> IMPOSTAZIONI
                                DELL'ACCOUNT </a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" href="#"><i class="glyphicon glyphicon-off"></i> logout
                            </a></li>
                        </ul>
                    </li>
                    <li class="hidden-xs-down"><a href="#">LOGIN</a></li>
                    <li class="hidden-xs-down"><a href="registrazione.html">REGISTRAZIONE</a></li>
                </ul>

                <!-- left -->
                <ul class="top-links list-inline has-topBar">
                    <li class="text-welcome hidden-xs-down p-10">Benvenuto, <strong>Mario Rossi</strong></li>
                </ul>

            </div>
        </div>
        <!-- /TOP BAR-->


        <header id="topNav">
            <div class="container">
                <!-- Mobile Menu Button -->
                <button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>


                <!-- Logo -->
                <a class="logo float-left mb-5 mr-10scripts.jsscripts.js" href="index.html">
                    <img src="imgs/interns.jpg" alt=""/>
                </a>

                <div class="navbar-collapse collapse nav-main-collapse submenu-dark">
                    <nav class="nav-main">
                        <ul id="topMain" class="nav nav-pills nav-main">
                            <li class="dropdown active">
                                <a class="dropdown-toggle noicon" href="index.html">
                                    HOME
                                </a>
                            </li>
                            <li class="dropdown active">
                                <a class="dropdown-toggle noicon" href="offerte-tutoraggi.html">
                                    LISTA OFFERTE TUTORAGGI
                                </a>
                            </li>
                            <li class="dropdown active">
                                <a class="dropdown-toggle noicon" href="lista-convenzioni.html">
                                    LISTA CONVENZIONI
                                </a>
                            </li>
                            <li class="dropdown active">
                                <a class="dropdown-toggle noicon" href="informazioni.html">
                                    INFORMAZIONI
                                </a>
                            </li>
                            <form class="d-inline-block col-lg-12 col-xl-4 mb-lg-2">
                                <div class="input-group">
                                    <input type="text" class="form-control" aria-label=""
                                           placeholder="Cerca nell'intero del sito">
                                    <span class="input-group-btn">
                                            <button class="btn btn-primary material-ico" type="submit">
                                                <i class="material-icons">search</i>
                                            </button>
                                        </span>
                                </div>
                            </form>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
    </div>
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>IL MIO ACCOUNT</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Il mio account</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_tirocinante" action="print.php" method="post" class="m-0">
                <fieldset>
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati del modulo pre-compilato e clicca su stampa</h1>

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <div class="sergreteria-box mr-10 mb-15 d-none d-print-block">
                        <div class="row">
                            <div class="col pl-35 pt-10 pb-10">
                                <h4 class="fw-100">PARTE RISERVATA</h4>
                                <h4 class="fw-100 mb-0">ALL&rsquo;UNIVERSITA&rsquo;</h4>
                            </div>
                            <div class="col pt-10 pb-10">
                                <h4 class="fw-100">DATA DI RICEVIMENTO:__________________</h4>
                                <h4 class="fw-100 mb-0">Prot. N:__________________</h4>
                            </div>
                        </div>
                    </div>

                    <h3 class="fw-700 text-center mb-0 d-none d-print-block">ALLEGATO 1</h3>
                    <h4 class="fw-700 text-justify mr-10 fs-22 mb-25 d-none d-print-block">alla Convenzione per lo svolgimento di attivit&agrave; di tirocinio e di orientamento (ai
                        sensi dell&apos;art. 18 L.196/97 e dell&apos;Art. 1 Decreto Ministero del Lavoro e Previdenza
                        Sociale N. 142/98 e della Legge 148 del 14/09/2011) per studenti, laureati e diplomati
                        del Dipartimento di Ingegneria, Scienze dell&rsquo;Informazione e Matematica
                        dell&rsquo;Universit&agrave; degli Studi dell&apos;Aquila.
                    </h4>
                    <h3 class="fw-700 text-center d-none d-print-block mb-25">PROGETTO FORMATIVO E DI ORIENTAMENTO</h3>



                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nominativo del tirocinante </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo"
                               value="Francesco Totti" placeholder="Nome e Cognome del tirocinante">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nato a</h4>
                        <input class="input-modulo col-3 col-sm-3 col-md-6 col-lg-7 pl-0" type="text"
                               name="Luogo_di_nascita" value="Roma" placeholder="Luogo di nascita">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                        <input class="input-modulo col-1 col-sm pl-0" type="text" name="Provincia_di_nascita"
                               value="RM" placeholder="XX">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">il</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Giorno_di_nascita"
                               value="01" placeholder="XX">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Mese_di_nascita"
                               value="01" placeholder="XX">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Anno_di_nascita"
                               value="0001" placeholder="XXXX">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Residente in</h4>
                        <input class="input-modulo col-8 col-sm-8 pl-0" type="text" name="Luogo_di_residenza"
                               value="via vai a pesca 1/b" placeholder="Luogo di residenza">
                        <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text"
                               name="Provincia_di_nascita" value="RM" placeholder="XX">
                        <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                               value="PPPPLT80R10M082K" placeholder="Codice fiscale">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Numero_telefono"
                               value="333-1234567" placeholder="Numero di telefono">
                    </div>

                    <h4 class="text-center text-black fs-16 mb-5 mt-15 mr-10">Attuale condizione (barrare la casella -
                        possibilità di doppia scelta):</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1" checked="checked">
                            <i></i> Studente Corso di Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Corso_laurea"
                               value="Matematica" placeholder="Corso di laurea">
                    </div>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1">
                            <i></i> Diplomato. Diploma universitario in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Diplomato_Universitario"
                               value="" placeholder="Diploma Universitario">
                    </div>
                    <h4>(entro 12 mesi dal diploma)</h4>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1">
                            <i></i> Laureato. Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Laurea" value=""
                               placeholder="Laurea">
                    </div>
                    <h4>(entro 12 mesi dalla laurea)</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1" checked="checked">
                            <i></i> Dottorato di ricerca in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca"
                               value="Matematica" placeholder="Dottorato">
                    </div>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1">
                            <i></i> Scuola o corso di perfezionamento o specializzazione in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca" value=""
                               placeholder="Specificare">
                    </div>

                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                    <label class="checkbox ml-200 mr-10">
                        <input type="checkbox" value="Si">
                        <i></i> Si
                    </label><br>
                    <label class="checkbox ml-200 mb-25 mr-10">
                        <input type="checkbox" value="No" checked="checked">
                        <i></i> No
                    </label>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda ospitante</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nome_ente_azienda"
                               value="Avja srl" placeholder="Nome Ente/Azienda">
                    </div>

                    <div class="row mb-0 breack-print mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Luogo di effettuazione del tirocinio</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Luogo_di_svolgimento"
                               value="Negli uffici aziendali" placeholder="Luogo di svolgimento">
                    </div>

                    <div class="text-center d-none d-print-block mr-10">
                        <img class="img-fluid" src="imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Settore di inserimento</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Settore_di_inserimento"
                               value="Non lo so" placeholder="Settore di inserimento">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tempi di accesso ai locali aziendali</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Tempo_accesso_azienda"
                               value="9:00 - 18:00" placeholder="Specificare i tempi di accesso">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Periodo di tirocinio n.</h4>
                        <input class="input-modulo col col-sm-1 pl-0 text-center" type="text" name="Numero_di_mesi"
                               value="3" placeholder="Specificare il numero di mesi">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">mesi dal</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Data_iniziale"
                               value="01/01/0001" placeholder="Data inizio">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">al</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Data_fine" value="01/04/0001"
                               placeholder="Data fine">
                    </div>
                    <h4>(con possibilit&agrave; di prologa entro i limiti massimi previsti dalla normativa vigente)</h4>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="Numero_ore_tirocinio"
                               value="150" placeholder="numero ore">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="Numero_cfu" value="6"
                               placeholder="Numero CFU">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore universitario</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Nominativo_tutore_universitario" value="Mario Rossi"
                               placeholder="Nominativo tutore universitario">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_universitario" value="333-1234567"
                               placeholder="Numero di telefono tutore universitario">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore Aziendale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo_tutore_aziendale"
                               value="Francesco Bianchi" placeholder="Nominativo tutore aziendale">
                    </div>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_aziendale" value="333-1234567"
                               placeholder="Numero di telefono tutore aziendale">
                    </div>
                    <h3 class="mb-0 d-none d-print-block">Polize assicurative:</h3>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio responsabilità civile terzi:</h4>
                    <h4 class="fw-100 mb-5 d-none d-print-block">Compagnia assicurativa:<br>
                        UNIPOLSAI n.65 / 102965221<br>
                        Scadenza polizza: 30 aprile 2018</h4>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio infortuni:</h4>
                    <h4 class="fw-100 d-none d-print-block">Compagnia assicurativa:<br>
                        Copertura da polizza HARMONIE MUTUELLE n.100015<br>
                        Scadenza polizza: 30 aprile 2018 </h4>

                    <h3 class="mb-0 d-none d-print-block">Posizione INAIL:</h3>
                    <h4 class="mb-35 d-none d-print-block">Copertura assicurativa “in conto Stato” ex art. 2 D.P.R. N. 156 del 9.04.1999</h4>

                    <h4 class="fs-20 mb-0">Obiettivi del tirocinio:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-15 mr-10" rows="4" cols="1" name="Obiettivi_tirocinio"
                              placeholder="descrivi in breve l&apos;obbiettivo del tirocinio">Soddisfacendo le esigenze quotidiane di alimentazione, igiene e cura della casa e della persona con brand e servizi di qualit&agrave;, aiutiamo i consumatori a sentirsi bene, ad aver un bell&apos;aspetto e a vivere al meglio. La sostenibilit&agrave; &egrave; il fondamento del nostro business e attraverso le nostre marche miriamo ad esortare i consumatori a compiere piccoli gesti quotidiani che, sommati, possono fare la differenza.</textarea>

                    <h4 class="fs-20 mb-0">Modalità:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-0 mr-10" rows="4" cols="1" name="Obiettivi_tirocinio"
                              placeholder="descrivi in breve l&apos;obbiettivo del tirocinio">Per un&rsquo;igiene orale completa, &egrave; buona norma utilizzare un collutorio ad uso quotidiano come  LISTERINE&reg; due volte al giorno dopo aver spazzolato i denti. bastano 20 ml di soluzione. L&rsquo;equivalente di 4 cucchiaini.
&rarr; Non diluire il prodotto. &Eacute; gi&aacute; pronto. Effettuare uno sciacquo per tutta la bocca per 30 secondi, senza ingerire il prodotto.</textarea>

                    <h4 class="col-12 mt-35 fs-20 pl-0 mb-0">Facilitazioni previste: sussidio di formazione e servizi
                        aziendali
                        (mensa)</h4>
                    <input class="input-modulo col-12 pl-0 breack-print" type="text"
                           name="Numero_telefono_tutore_aziendale"
                           value="bastano 20 ml di soluzione. L&rsquo;equivalente di 4 cucchiaini.">

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <h4 class="col-12 mt-35 fs-20 pl-0 mb-5 d-none d-print-block mr-10">Obblighi del tirocinante:</h4>
                    <ul class="d-none d-print-block mr-10">
                        <li>Seguire le indicazioni dei tutori e fare riferimento ad essi su qualsiasi esigenza di tipo
                            organizzativo ed altre evenienze;
                        </li>
                        <li>Rispettare gli obblighi di riservatezza per quanto attiene ai dati, informazioni e
                            conoscenze in merito all'attività di ricerca dell'Ente/Azienda, acquisiti durante e dopo lo
                            svolgimento del tirocinio;
                        </li>
                        <li>Rispettare i regolamenti aziendali e le norme in materia di igiene e sicurezza;</li>
                        <li>Inviare al Dipartimento di Ingegneria, Scienze dell’Informazione e Matematica
                            dell'Università degli Studi dell'Aquila, mensilmente, le presenze effettive presso
                            l'Azienda rilevate da una scheda che viene consegnata dall’Azienda stessa all'atto
                            della compilazione del presente Progetto.
                        </li>
                    </ul>

                    <p class="text-black  text-justify fs-20 d-none d-print-block mr-10">
                        Ai sensi degli artt. 10 e seguenti della legge 675/ 96, sulla tutela delle persone e di altri
                        soggetti rispetto al trattamento dei dati personali, con la sottoscrizione il tirocinante
                        esprime il suo consenso a che i suoi dati personali vengano comunicati all'Università
                        limitatamente ai trattamenti connessi alle finalità del presente rapporto di tirocinio. La
                        sottoscrizione del presente modello comporta anche il consenso del tirocinante al
                        trattamento dei suoi dati personali nel senso sopraindicato.
                        L'Aquila
                    </p>
                    <h4 class="d-none d-print-block">Firma per visione e accettazione del tirocinante</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Dipartimento di Ingegneria, Scienze dell’Informazione e Matematica dell’Università degli Studi di L'Aquila<br>
                        Il Tutor</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">L&apos;Ente/Azienda <sup>1</sup></h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Tutor aziendale</h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Direttore del Dipartimento di Ingegneria e Scienze dell’Informazione e Matematica.<br>
                        Prof. Guido Proietti
                    </h4>

                    <div class="linea col-5 p-0"></div>

                    <div class="linea col-3 p-0"></div>

                    <h5 class="fw-800 d-none d-print-block"><sup>1</sup>Timbro e firma dell’Azienda</h5>


                    <footer class="mt-50 d-print-none">
                        <button type="submit" form="modulo_tirocinante" class="btn btn-success btn-lg pull-right float-right" onclick="window.print();"><i
                                class="fa fa-check"></i> Stampa
                        </button>
                        <button type="reset" form="modulo_tirocinante" class="btn btn-red btn-lg pull-right float-left"><i
                                class="fa fa-times"></i> Annulla
                        </button>
                    </footer>
                </fieldset>
            </form>
        </div>
    </section>

    <!-- /FOOTER -->
    <footer class="d-print-none" id="footer">
        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <div class="row">
                        <div class="col-4">
                            <!-- Footer Logo -->
                            <img class="footer-logo" src="http://www.disim.univaq.it/didattica/img/logo_univaq.png"
                                 alt=""/>
                        </div>
                        <div class="col-6 text-left py-5p">

                            <!-- Short Description -->
                            <a href="http://univaq.it">Università degli Studi dell'Aquila</a>
                        </div>
                    </div>
                    <!-- Contact Address -->
                    <address>
                        <ul class="list-unstyled">
                            <li class="footer-sprite address">
                                67100 L'Aquila, Coppito, Via Vetoio<br>
                            </li>
                            <li class="footer-sprite phone">
                                Phone: +39 0862 433002
                            </li>
                            <li class="footer-sprite phone">
                                Phone: +39 0862 433180 (fax)
                            </li>
                            <li class="footer-sprite email">
                                <a href="mailto:disim.sad@univaq.it">disim.sad@univaq.it</a>
                            </li>
                        </ul>
                    </address>
                    <!-- /Contact Address -->

                </div>


                <div class="col-md-4">

                    <!-- Newsletter Form -->
                    <h4 class="letter-spacing-1">INTERNSHIP TUTOR</h4>
                    <p>Internship Tutor rappresenta un sistema web per la gestione dell'iter completo dei tirocini
                        universitari del degli Studi dell'Aquila.</p>
                </div>


                <div class="col-md-3">

                    <!-- Latest Blog Posts -->
                    <h4 class="letter-spacing-1">ULTIME OFFERTE PUBLICATE</h4>
                    <ul class="footer-posts list-unstyled">
                        <li>
                            <a href="#">L'azienda PACARO srl, sede di Borgorose (RI), ricerca tirocinanti</a>
                            <small>29 June 2017</small>
                        </li>
                        <li>
                            <a href="#">Tirocini e stage retributi presso la Gunpowder S.r.l. (Spinoff Univ.
                                L'Aquila)</a>
                            <small>29 June 2017</small>
                        </li>
                        <li>
                            <a href="#">Tirocinio presso Aveja</a>
                            <small>29 June 2017</small>
                        </li>
                    </ul>
                    <!-- /Latest Blog Posts -->

                </div>

                <div class="col-md-2">

                    <!-- Links -->
                    <h4 class="letter-spacing-1">LINK UTILI</h4>
                    <ul class="footer-links list-unstyled">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Lista Offerte Tuttoraggi</a></li>
                        <li><a href="#">Lista Convenzioni</a></li>
                        <li><a href="#">Contattaci</a></li>
                        <li><a href="#">Il Mio Accout</a></li>
                        <li><a href="#">I Miei Tirocini</a></li>

                    </ul>
                    <!-- /Links -->

                </div>


            </div>

        </div>

        <div class="copyright">
            <div class="container">
                <ul class="float-right m-0 list-inline mobile-block">
                    <li><a href="#">Terms & Conditions</a></li>
                    <li>&bull;</li>
                    <li><a href="#">Privacy</a></li>
                </ul>
                &copy; All Rights Reserved, INTERNSHIP TUTOR
            </div>
        </div>
    </footer>
    <!-- /FOOTER -->

</div>

</body>
</html>