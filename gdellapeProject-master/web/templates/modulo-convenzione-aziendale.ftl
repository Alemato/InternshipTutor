<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modulo Convenzione</title>

    <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

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

            <h1 class="uppercase">Modulo termine Progetto Formativo e Di Orientamento</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Il mio account</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_tirocinante" action="/account/moduli/covenzione" method="post" class="m-0">
                <fieldset>
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati del modulo pre-compilato e clicca su
                        stampa</h1>

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
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
                    <h4 class="fw-700 text-justify mr-10 fs-22 mb-25 d-none d-print-block">CONVENZIONE PER LO
                        SVOLGIMENTO DI ATTIVITA&apos; DI TIROCINIO E DI ORIENTAMENTO (AI SENSI DELL&apos;ART.18 L.196/97,
                        DELL&apos;ART.1 DECRETO MINISTERO DEL LAVORO E PREVIDENZA SOCIALE N.142/98 E DELLA LEGGE 148 del
                        14/09/2011) PER STUDENTI E LAUREATI DEL DIPARTIMENTO DI INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E
                        MATEMATICA DELL&apos;UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA
                    </h4>
                    <h4 class="fw-400 text-center d-none d-print-block mb-25">tra:</h4>
                    <h4 class="fw-400 text-justify d-none d-print-block mb-25 p-3">L&rsquo;Universit&agrave; degli Studi di L&rsquo;Aquila
                        &ndash;
                        Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica, con sede legale in
                        L&rsquo;Aquila, C.F./P.I. 01021630668, rappresentata per la stipula del presente atto convenzionale,
                        dal Direttore del Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica Prof.
                        Guido Proietti, nato a Roma il 13/06/1966,domiciliato per il presente atto presso la sede legale
                        del l&rsquo;Universit&agrave;, e autorizzato e delegato alla stipula della presente Convenzione dal Rettore
                        dell&rsquo;Universit&agrave; con D.R. n. 522/2018, prot. n. 22151 del 17.05.2018</h4>
                    <h4 class="fw-400 text-center d-none d-print-block mb-25">e</h4>


                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Ente_Azienda"
                               value="${azienda.ragioneSociale}" placeholder="Nome Ente o Azienda">
                    </div>

                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">con sede legale in (indirizzo) </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="SedeLegale"
                               value="${azienda.indirizzoSedeLegale}" placeholder="indirizzo sede legale">
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice Fiscale (o Partita IVA) </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                               value="${azienda.CFiscalePIva}" placeholder="Codice fiscale">
                    </div>


                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">rappresentato da </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Rappresentante_legale_nome"
                               value="${azienda.nomeLegaleRappresentante}" placeholder="Rapresentante legale">
                    </div>
                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">rappresentato da </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Rappresentante_legale_cognome"
                               value="${azienda.cognomeLegaleRappresentante}" placeholder="Rapresentante legale">
                    </div>

                    <h4 class="text-center mt-35 fs-20 mb-30 fw-400 d-none d-print-block">Premesso:</h4>
                    <ul class="d-none d-print-block mr-10">
                        <li><p>
                                che i tirocini formativi e di orientamento sono ora disciplinati dall&apos;articolo 18 della
                                legge 24 giugno 1997 n.196, dal suo regolamento di attuazione emanato con Decreto 25 marzo
                                1998, n.142 e dalla legge 148 del 14/09/2011;</p>
                        </li>
                        <li><p>
                                che il Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica intende attuare
                                progetti diretti al raggiungimento delle finalit&agrave; indicate dall&apos;art.18 L. 24 giugno 1997
                                n.196 e dall&apos;art.1 del suddetto decreto 25 marzo 1998 n. 142, che promuovono tirocini
                                formativi e di orientamento presso le aziende;</p>
                        </li>
                        <li><p>
                                che al fine di agevolare le scelte professionali mediante la conoscenza diretta del mondo
                                del lavoro e realizzare momenti di alternanza tra studio e lavoro nell&apos;ambito dei processi
                                formativi i soggetti richiamati dall&apos;art.18, comma 1, lett. a) della legge 24 giugno 1997
                                n.196, tra cui le Universit&agrave;, possono promuovere tirocini formativi e di orientamento presso
                                datori di lavori pubblici e privati a beneficio di coloro che abbiano gi&agrave; assolto l&apos;obbligo
                                scolastico ai sensi della legge 31.12.62 n.1859;</p>
                        </li>
                    </ul>

                    <div class="text-center d-none d-print-block mr-10" style="page-break-before: always;">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <h4 class="text-center mt-35 fs-20 mb-20 fw-400 d-none d-print-block">si conviene quanto segue:</h4>
                    <h4 class="text-center fs-20 mb-30 fw-400 d-none d-print-block">le premesse costituiscono parte
                        integrante e sostanziale della presente Convenzione.</h4>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 1 Oggetto</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>1.1 </b>
                        L&apos;Ente/l&apos;Azienda si impegna ad accogliere presso le proprie strutture soggetti in tirocinio di
                        formazione ed orientamento, ai sensi dell&apos;art. 18 della legge 24 giugno 1997 n. 196 e della
                        legge 148 del 14/09/2011, in numero non superiore a quanto disposto dall&apos;articolo 1, comma 3,
                        lettera c), del decreto 142/98. In particolare non possono essere attivati tirocini presso
                        aziende che non hanno dipendenti.
                        Potranno effettuare periodi di tirocinio (stage), studenti, neo-laureati e neo-diplomati del
                        Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica dell&apos;Universit&agrave; degli Studi
                        di L&apos;Aquila, a condizione che il tirocinio inizi non oltre i 12 mesi successivi al conseguimento
                        della laurea o dei diploma.
                        Potranno effettuare periodi di tirocinio (stage), anche coloro che frequentano dottorati di
                        ricerca e scuole o corsi di perfezionamento e specializzazione.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>1.2 </b>
                        Ai fini dello svolgimento del tirocinio l&rsquo; Ente/l&apos;Azienda mette a disposizione del Dipartimento
                        di Ingegneria e Scienze dell&rsquo;Informazione e Matematica dell&apos;Universit&agrave; le proprie strutture.
                        L&apos;accesso alle strutture sar&agrave; guidato dal personale dell&rsquo;Ente/Azienda ospitante, con compiti di
                        illustrazione e formazione.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 2 Rapporti con i
                        tirocinanti</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>2.1 </b>
                        Il tirocinio formativo e di orientamento, ai sensi dell&apos;art. 18, comma 1 lett. d) della legge
                        196 del 1997 non costituisce rapporto di lavoro e non d&agrave; luogo ad alcuna ipotesi di attivit&agrave;
                        occupazionale. L&apos;Ente/l&apos;Azienda non ha alcun obbligo di assunzione al termine del periodo di
                        tirocinio.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>2.2 </b>
                        Durante lo svolgimento del tirocinio, l&apos;attivit&agrave; di formazione ed orientamento &egrave; seguita e
                        verificata da un tutore designato dal Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e
                        Matematica dell&apos;Universit&agrave; in veste di responsabile didattico - organizzativo (il cui nominativo
                        risulter&agrave; dal Progetto formativo e di orientamento dei singoli stagisti) e da un responsabile
                        aziendale indicato dall&rsquo; Ente/l&apos;Azienda (risultante dal predetto Progetto)
                    </p>

                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>2.3 </b>
                        Per ciascun tirocinante da inserirsi nell&apos;Ente/Azienda ospitante verr&agrave; predisposto tra le parti
                        un Progetto formativo e di orientamento, come da ALLEGATO 1, contenente:</p>
                    <ul class="d-none d-print-block mr-10" style="list-style-type:lower-latin;">
                        <li>
                            le generalit&agrave; del tirocinante;
                        </li>
                        <li>
                            i nominativi del tutore e del responsabile aziendale;
                        </li>
                        <li>
                            durata, obiettivi e modalit&agrave; di svolgimento del tirocinio;
                        </li>
                        <li>
                            le strutture aziendali (sedi ed uffici) presso cui si svolge il tirocinio;
                        </li>
                        <li>
                            gli estremi identificativi delle assicurazioni INAIL e per la responsabilit&agrave; civile.
                        </li>
                    </ul>


                    <div class="text-center d-none d-print-block" style="page-break-before: always;">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>

                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>2.4 </b>
                        L&apos;avvio operativo per lo svolgimento dei singoli tirocini avverr&agrave; con scambio di lettera di
                        conferma tra l&apos;Ente/l&apos;Azienda ospitante ed il tirocinante, con allegata copia del relativo
                        Progetto di cui al n.2.3 che precede, sottoscritto dall&rsquo;Ente/l&apos;Azienda, dal Dipartimento di
                        Ingegneria e Scienze dell&rsquo;Informazione e Matematica e dallo stagista per adesione ed
                        accettazione.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>2.5 </b>
                        E&apos; consentita, con l&apos;approvazione del responsabile aziendale, la partecipazione del tirocinante
                        ad attivit&agrave; aziendali fuori sede. In tal caso le spese di viaggio e di soggiorno o eventuali
                        altre spese saranno sostenute dall&apos;Ente/Azienda, secondo le norme e le procedure interne
                        all&apos;Ente/Azienda stessa.
                    </p>


                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 3 Svolgimento e durata del
                        tirocinio</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>3.1 </b>
                        Come previsto dalla normativa vigente la durata massima dei tirocini potr&agrave; essere di 6 mesi nel
                        caso di neolaureati/neodiplomati e di 12 mesi per gli studenti. Nel caso di iniziative rivolte a
                        persone con disabilit&agrave; la durata &egrave; estensibile a 18 mesi.
                        La durata viene specificata nel Progetto di cui al n. 2.3 che precede relativo ad ogni
                        tirocinante.
                        La durata stessa potr&agrave; essere prorogata, previo accordo tra le parti, entro i limiti massimi
                        indicati dall&apos;art. 7 del decreto n. 142/98.

                    </p>

                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>3.2 </b>
                        &Egrave; consentita, per giustificati motivi, la richiesta da parte del tirocinante di una interruzione
                        temporanea dello stage, comunque non superiore a n.&deg; 2 settimane consecutive, previa
                        comunicazione all&rsquo;Ente/Azienda ospitante, ferma restando la durata complessiva del tirocinio
                        come prevista nel progetto formativo individuale.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>3.3 </b>
                        Durante lo svolgimento del tirocinio formativo e di orientamento il tirocinante è tenuto a:</p>
                    <ul class="d-none d-print-block mr-10">
                        <li>
                            <p>svolgere le attivit&agrave; previste dal Progetto formativo e di orientamento</p></li>
                        <li><p>cooperare al conseguimento degli obiettivi che lo riguardano, osservando gli orari
                                concordati
                                e rispettando l&apos;ambiente di lavoro e le esigenze di coordinamento dell&apos;attivit&agrave; di ricerca
                                dell&apos;azienda</p></li>
                        <li><p>rispettare le norme in materia di igiene, sicurezza e salute sui luoghi di lavoro con
                                particolare riferimento all&rsquo;art. 20 del D.Lgs. n. 81/2008 &ldquo;Obblighi del lavoratore&rdquo;;</p>
                        </li>
                        <li><p>mantenere la necessaria riservatezza per quanto attiene ai dati, informazioni e/o
                                conoscenze
                                in merito ad attivit&agrave; di ricerca dell&rsquo;Ente/l&apos;Azienda (ed ai relativi contenuti e risultati),
                                acquisiti durante lo svolgimento del tirocinio</p></li>
                        <li><p>inviare al Direttore del Dipartimento di Ingegneria e Scienze dell’Informazione e
                                Matematica
                                dell&apos;Universit&agrave; degli Studi dell&apos;Aquila, mensilmente ed entro il giorno 8 del mese
                                successivo a
                                quello cui si riferiscono, le presenze effettive in tirocinio presso l&rsquo;Ente/Azienda,
                                rilevate
                                dalla scheda che sar&agrave; consegnata all&apos;atto della compilazione del Progetto.</p></li>
                    </ul>

                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>3.4 </b>
                        Qualora si verificassero, da parte del tirocinante, comportamenti lesivi di diritti o interessi
                        dell&rsquo; Ente/l&apos;Azienda essa potr&agrave;, previa informazione al tutore incaricato dal Dipartimento di
                        Ingegneria e Scienze dell&rsquo;Informazione e Matematica, sospendere o interrompere lo svolgimento
                        del tirocinio.
                    </p>


                    <div class="text-center d-none d-print-block" style="page-break-before: always;">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-10"><b>3.5 </b>
                        La realizzazione del tirocinio non comporta per l&rsquo; Ente/l&apos;Azienda e per il Dipartimento di
                        Ingegneria e Scienze dell&rsquo;Informazione e Matematica dell&apos;Universit&agrave; degli Studi dell&apos;Aquila
                        alcun onere finanziario, n&eacute; obblighi di altra natura salvo quelli previsti nella presente
                        Convenzione.</p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        L&rsquo;Ente/l&apos;Azienda potr&agrave; peraltro erogare eventuali somme a titolo di rimborso spese (da prevedere
                        nel progetto formativo), secondo le norme e le procedure interne all&rsquo; Ente/l&apos;Azienda stesso,
                        ovvero eventuali sussidi di formazione e consentire ai tirocinanti l&apos;utilizzo dei servizi
                        aziendali (in particolare, servizio mensa), senza che tali erogazioni possano determinare
                        modifiche alla natura dei rapporti oggetto della presente Convenzione, o facolt&agrave; o diritti
                        ulteriori o diversi da quelli previsti dalla Convenzione stessa e dalle relative disposizioni
                        normative. Potranno essere erogati eventuali premi in denaro nei particolari casi di eccellenza
                        della ricerca svolta e dei risultati raggiunti.

                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-10"><b>3.6 </b>
                        L&rsquo;Azienda/Ente ospitante si impegna a garantire che il tirocinio si svolga presso strutture
                        aziendali (stabilimenti, sedi, reparti, uffici ecc.) che rispettino le vigenti disposizioni
                        normative in tema di prevenzione incendi, igiene e sicurezza del lavoro, garantendo, in
                        particolare, che i locali, le attrezzature e le strumentazioni siano idonee e adeguate ai sensi
                        del D. lgs. 81del 9 Aprile 2008.</p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        L&rsquo;Azienda/Ente ospitante si impegna inoltre ad assolvere a tutti gli obblighi indicati dal D.
                        lgs 81/2008 con particolare riguardo al Titolo I, Capo III, sez. IV &ldquo;Formazione, informazione e
                        addestramento&rdquo;, sezione V &ldquo;Sorveglianza sanitaria&rdquo; per i casi eventualmente previsti (presenza
                        di rischi specifici), e al Titolo III, Capo II &ldquo;Uso dei dispositivi di protezione individuali&rdquo;.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 4 Coperture
                        assicurative</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>4.1 </b>
                        L&apos;Universit&agrave; degli Studi di L&apos;Aquila si impegna ad assicurare i tirocinanti contro gli infortuni
                        sul lavoro presso l&apos;INAIL, nonch&eacute; per la responsabilit&agrave; civile presso compagnie assicurative
                        operanti nel settore ed indicate nel progetto formativo. L&apos;assicurazione dovr&agrave; coprire anche le
                        attivit&agrave; svolte nell&apos;ambito del tirocinio fuori sede ai sensi del punto 2.5. Gli estremi
                        identificativi delle assicurazioni predette saranno indicati nei Progetti.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black"><b>4.2 </b>
                        In caso di infortunio durante lo svolgimento del tirocinio, l&rsquo;Ente/l&apos;Azienda si impegna a
                        segnalare l&apos;evento, entro i tempi previsti dalla normativa vigente, agli istituti assicurativi
                        (quali risultanti dal Progetto formativo e di orientamento e facendo riferimento al numero della
                        polizza sottoscritta dall&apos;Universit&agrave; degli Studi di L&apos;Aquila) ed all&apos;Universit&agrave; stessa.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 5 Comunicazioni</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-10">
                        Il Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica dell&apos;Universit&agrave; degli
                        Studi di L&apos;Aquila si impegna a far pervenire alla Regione o alla Provincia delegata, alle
                        strutture provinciali del Ministero del Lavoro e della Previdenza sociale competenti per
                        territorio in materia di ispezione copia della Convenzione e di ciascun Progetto formativo e di
                        orientamento.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-10">
                        L&rsquo; Ente/l&apos;Azienda per delega che l&apos;Universit&agrave; degli Studi di L&apos;Aquila le conferisce con la
                        presente, provveder&agrave; a far pervenire alle Rappresentanze Sindacali dei Lavoratori copia della
                        presente Convenzione e di ciascun Progetto formativo e di orientamento, ai sensi della normativa
                        vigente.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-10">
                        In ottemperanza a quanto previsto dalla legge n.296/2006 (Finanziaria 2007) l&rsquo;Ente/Azienda
                        ospitante &egrave; tenuto ad effettuare obbligatoriamente la comunicazione dell&apos;avvio dello
                        stage/tirocinio al centro per l&apos;impiego competente entro le ore 24 del giorno antecedente, solo
                        ed esclusivamente per i neolaureati.
                    </p>


                    <div class="text-center d-none d-print-block" style="page-break-before: always;">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 6 Spese e Foro
                        competente</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        La presente convenzione viene redatta in unico originale, conservato agli atti dal Soggetto
                        promotore. Copia del documento viene rilasciata al Soggetto ospitante.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-5">
                        Ogni attivit&agrave; prevista dalla presente Convenzione si svolger&agrave; nel rispetto dell&apos;Ordinamento
                        generale dello Stato e delle leggi che regolano l&apos;attivit&agrave; di entrambi gli Enti.
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black mb-5">
                        Le parti concordano di definire amichevolmente qualsiasi controversia dovesse insorgere
                        dall&apos;interpretazione o applicazione del presente Atto.
                    </p>


                    <div class="pr-15 pl-15 row d-none d-print-block">
                        <p class="d-none d-print-inline mr-10 fs-18 text-black m-0">
                            Qualora non fosse possibile raggiungere tale accordo, il Foro competente a dirimere la
                            controversia sar&agrave; quello di
                        </p>


                        <p class="d-none d-print-inline mr-10 fs-18 text-black mb-5"> non lo so.</p>
                    </div>


                    <div class="row mb-0 mr-10 d-print-none">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ruolo del foro competente: </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="foro_competente"
                               value="${azienda.foroControversia}" placeholder="ruolo del foro competente">
                    </div>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        L&rsquo;imposta di bollo &egrave; a carico del Soggetto ospitante, salvo accordi specifici tra le parti e
                        secondo quanto previsto dalla normativa vigente.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 7 Trattamento dati</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        Le parti dichiarano di essersi reciprocamente informate, di acconsentire che i dati personali
                        raccolti per la formalizzazione del presente atto siano oggetto di trattamento per gli
                        adempimenti di legge ai sensi del d. lgs. 196/03 e di essere a conoscenza di quanto previsto
                        dall&rsquo;art.13 dello stesso decreto.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 8 Richiami</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        Per tutto quanto non previsto dalla presente Convenzione le parti fanno riferimento alla
                        legislazione vigente in materia.
                    </p>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 9 Decorrenza della presente
                        Convenzione</h4>
                    <div class="pr-15 pl-15 row d-none d-print-block">
                        <div class="d-none d-print-inline m-0 fs-18 text-black">
                            La presente Convenzione decorre dalla data in calce, ha durata di
                        </div>


                        <div class="d-none d-print-inline fs-18 text-black m-0 p-0">
                            365 giorni
                        </div>

                        <div class="d-none d-print-inline mr-10 fs-18 text-black">e si
                            intender&agrave; rinnovata tacitamente, a meno di disdetta da comunicarsi entro i tre mesi
                            precedenti
                            alla data di scadenza.
                        </div>
                    </div>

                    <div class="row mb-0 mr-10 d-print-none">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Durata convenzione: </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="durata_gg"
                               value="${azienda.durataConvenzione}" placeholder="N giorni">
                    </div>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 10 Referenti per la
                        Convenzione</h4>
                    <p class="d-none d-print-block mr-10 fs-18 mb-10 text-black">
                        Referenti per la presente Convenzione e per i rapporti fra gli Enti Contraenti nell&apos;ambito
                        della
                        Convenzione stessa sono:
                    </p>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        per Il Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione e Matematica dell&rsquo;Universit&agrave;
                        degli
                        Studi L&apos;Aquila:
                    </p>
                    <div class="linea col-5 p-0"></div>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        per l&rsquo; Ente/l&apos;Azienda:
                    </p>
                    <div class="linea col-5 p-0"></div>

                    <div class="text-center d-none d-print-block" style="page-break-before: always;">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>

                    <h4 class="text-left mt-35 fs-20 mb-20 fw-700 d-none d-print-block">Art. 11 Registrazione e
                        spese</h4>
                    <p class="d-none d-print-block mr-10 fs-18 text-black">
                        La presente Convenzione sar&agrave; registrata a tassa fissa, in caso d&apos;uso, ai sensi degli
                        artt. 5 e
                        39 del D.P.R. 131 del 26.4.86.
                    </p>
                    <div class="row mb-25 mr-10 mt-100 mb-200">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">L&apos;Aquila, il </h4>
                        <input class="input-modulo col-3 col-sm-3 pl-0 text-center" type="date" name="Data_documento"
                               value="${data}">
                    </div>

                    <div class="container d-none d-print-block p-0">
                        <div class="row justify-content-between">
                            <div class="col-5 text-center">
                                <h4 class="mb-0">Il Direttore</h4>
                                <h4 class="mb-30">(Prof. Guido Proietti)</h4>
                                <div class="linea"></div>
                            </div>
                            <div class="col-5 text-center">
                                <h4 class="mb-0">Il Rappresentante</h4>
                                <h4 class="mb-30">Legale dell&rsquo;Azienda</h4>
                                <div class="linea"></div>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <footer class="mt-50 d-print-none">
                    <button type="submit" form="modulo_tirocinante"
                            class="btn btn-success btn-lg pull-right float-right"  ><i
                                class="fa fa-check"></i> Stampa
                    </button>
                    <button type="reset" form="modulo_tirocinante" class="btn btn-red btn-lg pull-right float-left">
                        <i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>

            </form>
        </div>
    </section>

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
