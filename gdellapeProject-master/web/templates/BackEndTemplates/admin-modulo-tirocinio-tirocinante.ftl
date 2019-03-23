<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>

    <!-- CORE CSS -->
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>
    <!--CSS no print -->
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="smoothscroll enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULO:</b></a></li>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid d-print-none">
    <div class="row d-print-none">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light d-print-none">
            <div class="side-nav mb-60">
                <ul class="list-group list-group-bordered list-group-noicon uppercase">
                    <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
                    <li class=""><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
                    <li class=""><a href="gestione-richieste-convenzioni-admin.html">GESTIONE RICHIESTE CONVENZIONE</a>
                    </li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a>
                        <ul>
                            <li><a href="ultime-offerte-pubblicate-admin.html">ULTIME OFFERTE PUBBLICATE</a></li>
                            <li class=""><a href="offerte-scadute-admin.html">OFFERTE SCADUTE</a></li>
                            <li class=""><a href="tutte-offerte-pubblicate-admin.html">TUTTE LE OFFERTE PUBBLICATE</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item active">
                        <a class="dropdown-toggle" href="gestione-moduli-admin.html">GESTIONE MODULI</a>
                        <ul>
                            <li><a href="richieste-tirocinii-tirocinanti-admin.html">RICHIESTE TIROCINII TIROCINANTI</a>
                            </li>
                            <li><a href="richieste-convenzioni-aziendali-admmin.html">RICHIESTE CONVENZIONI
                                    AZIENDALI</a>
                            </li>
                            <li><a href="modulo-tirocinio-fine-admin.html">MODULO TIROCINIO FINE</a>
                            </li>
                        </ul>
                    </li>

                    <li class=""><a href="impostazione-account-admin.html">IMPOSTAZIONI ACCOUNT</a></li>
                    </li>
                </ul>
            </div>
        </nav>


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3 d-print-none">
            <section class="section-sm centrale border-top-section pl-20 pr-20">
                <div class="container">
                    <form id="modulo_tirocinante"  method="post" class="m-0">
                        <fieldset>

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
                                       value="${tirocinante.nome} ${tirocinante.cognome}"  disabled>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Nato a</h4>
                                <input class="input-modulo col-3 col-sm-3 col-md-6 col-lg-7 pl-0" type="text"
                                       name="Luogo_di_nascita"  value="${tirocinante.luogoDiNascita}" disabled>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                                <input class="input-modulo col-1 col-sm pl-0" type="text" name="Provincia_di_nascita"
                                       value="${tirocinante.provinciaDiNascita}" disabled>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">il</h4>
                                <input class="input-modulo text-center col col-sm pl-0" type="text" name="Giorno_di_nascita"
                                       value="${tirocinante.dataDiNascita?date?string("dd")}" disabled>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                                <input class="input-modulo text-center col col-sm pl-0" type="text" name="Mese_di_nascita"
                                       value="${tirocinante.dataDiNascita?date?string("MM")}" disabled>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                                <input class="input-modulo text-center col col-sm pl-0" type="text" name="Anno_di_nascita"
                                       value="${tirocinante.dataDiNascita?date?string("yyyy")}" disabled>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Residente in</h4>
                                <input class="input-modulo col-8 col-sm-8 pl-0" type="text" name="Luogo_di_residenza"
                                     value="${tirocinante.luogoDiResidenza}" disabled>
                                <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                                <input class="input-modulo text-center col col-sm pl-0" type="text"
                                       name="Provincia_di_nascita" value="${tirocinante.provinciaDiNascita}" disabled>
                                <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                                     value="${tirocinante.codiceFiscale}"  disabled="disabled">
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Numero_telefono"
                                      value="${tirocinante.telefono}" disabled="disabled" >
                            </div>

                            <h4 class="text-center text-black fs-16 mb-5 mt-15 mr-10">Attuale condizione (barrare la casella -
                                possibilità di doppia scelta):</h4>

                            <div class="row mb-25 pl-15 mr-10">
                                <label class="checkbox">
                                    <input type="checkbox" value="1" <#if tirocinante.corsoDiLaurea?has_content> checked</#if>  disabled>
                                    <i></i> Studente Corso di Laurea in:
                                </label>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Corso_laurea"
                                        <#if tirocinante.corsoDiLaurea?has_content> value="${tirocinante.corsoDiLaurea}"</#if>  disabled>
                            </div>

                            <div class="row mb-0 pl-15 mr-10">
                                <label class="checkbox">
                                    <input type="checkbox" value="1" <#if tirocinante.diplomaUniversitario?has_content>checked</#if> disabled>
                                    <i></i> Diplomato. Diploma universitario in:
                                </label>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Diplomato_Universitario"
                                       <#if tirocinante.diplomaUniversitario?has_content>value="${tirocinante.diplomaUniversitario}"</#if>  disabled>
                            </div>
                            <h4>(entro 12 mesi dal diploma)</h4>

                            <div class="row mb-0 pl-15 mr-10">
                                <label class="checkbox">
                                    <input type="checkbox" value="1" <#if tirocinante.laureato?has_content> checked</#if> disabled>
                                    <i></i> Laureato. Laurea in:
                                </label>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Laurea"  <#if tirocinante.laureato?has_content> value="${tirocinante.laureato}"</#if>
                                      disabled>
                            </div>
                            <h4>(entro 12 mesi dalla laurea)</h4>

                            <div class="row mb-25 pl-15 mr-10">
                                <label class="checkbox">
                                    <input type="checkbox" value="1" <#if tirocinante.DottoratoDiRicerca?has_content> checked="checked"</#if> disabled>
                                    <i></i> Dottorato di ricerca in:
                                </label>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca"
                                       <#if tirocinante.DottoratoDiRicerca?has_content> value="${tirocinante.DottoratoDiRicerca}" </#if> disabled >
                            </div>

                            <div class="row mb-25 pl-15 mr-10">
                                <label class="checkbox">
                                    <input type="checkbox" value="1" <#if tirocinante.ScuolaAltro?has_content > checked</#if> disabled>
                                    <i></i> Scuola o corso di perfezionamento o specializzazione in:
                                </label>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca" <#if tirocinante.ScuolaAltro?has_content> value="${tirocinante.ScuolaAltro}" </#if>
                                       placeholder="Specificare" disabled>
                            </div>

                            <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                            <label class="checkbox ml-200 mr-10">
                                <input type="checkbox" <#if tirocinante.handicap==true> checked</#if> disabled>
                                <i></i> Si
                            </label><br>
                            <label class="checkbox ml-200 mb-25 mr-10">
                                <input type="checkbox" value="No" <#if tirocinante.handicap==false> checked</#if> disabled>
                                <i></i> No
                            </label>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda ospitante</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Nome_ente_azienda"
                                       value="${dato[0]}" placeholder="Nome Ente/Azienda" disabled="disabled">
                            </div>

                            <div class="row mb-0 breack-print mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Luogo di effettuazione del tirocinio</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Luogo_di_svolgimento"
                                       value="${dato[1]}" placeholder="Luogo di svolgimento" disabled>
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
                                       value="${dato[2]}" placeholder="Settore di inserimento" disabled="disabled">
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Tempi di accesso ai locali aziendali</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Tempo_accesso_azienda"
                                       value="${dato[3]}" disabled>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Periodo di tirocinio n.</h4>
                                <input class="input-modulo col col-sm-1 pl-0 text-center" type="text" name="Numero_di_mesi"
                                       value="${dato[4]}" disabled="disabled">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">mesi dal</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Data_iniziale"
                                       value="${dato[5]}" disabled="disabled">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">al</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Data_fine" value="${dato[6]}"
                                       disabled="disabled">
                            </div>
                            <h4>(con possibilit&agrave; di prologa entro i limiti massimi previsti dalla normativa vigente)</h4>

                            <div class="row mb-25 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                                <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="Numero_ore_tirocinio"
                                       value="${dato[7]}" disabled="disabled">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                                <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="Numero_cfu" value="${dato[8]}" disabled>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore universitario</h4>
                                <input class="input-modulo col col-sm pl-0" type="text"
                                       name="Nominativo_tutore_universitario" value="${dato[9]} ${dato[10]}" disabled>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                                <input class="input-modulo col col-sm pl-0" type="text"
                                       name="Numero_telefono_tutore_universitario"  value="${dato[11]}" disabled>
                            </div>

                            <div class="row mb-0 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore Aziendale</h4>
                                <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo_tutore_aziendale"
                                       value="${dato[12]} ${dato[13]}" disabled>
                            </div>

                            <div class="row mb-25 mr-10">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                                <input class="input-modulo col col-sm pl-0" type="text"
                                       name="Numero_telefono_tutore_aziendale" value="${dato[14]}" disabled>
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
                                      placeholder="descrivi in breve l&apos;obbiettivo del tirocinio" disabled> ${dato[15]}</textarea>

                            <h4 class="fs-20 mb-0">Modalità:</h4>
                            <textarea class="textarea-modulo col-12 pt-5 mb-0 mr-10" rows="4" cols="1" name="modalita_tirocinio" disabled> ${dato[16]}</textarea>

                            <h4 class="col-12 mt-35 fs-20 pl-0 mb-0">Facilitazioni previste: sussidio di formazione e servizi
                                aziendali
                                (mensa)</h4>
                            <#--TODO chiedi-->
                            <input class="input-modulo col-12 pl-0 breack-print" type="text"
                                   name="Numero_telefono_tutore_aziendale"
                                  value="${dato[17]}" >

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
                            </footer>
                        </fieldset>
                    </form>
                </div>
            </section>

        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = 'plugins/';</script>
<script src="plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="js/scripts.js"></script>
<script src="plugins/bootstrap/js/bootstrap.js"></script>


<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    // datatable_ric_convenzioni
    // datatable_fine_tirocinio
    function initTableRicTiro() {

        var table = jQuery('#datatable_ric_tiro');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableRicConvenzioni() {

        var table = jQuery('#datatable_ric_convenzioni');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [7, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableFineTirocinio() {

        var table = jQuery('#datatable_fine_tirocinio');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            },{
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    initTableRicTiro();
    initTableRicConvenzioni();
    initTableFineTirocinio();

</script>
</body>
</html>
