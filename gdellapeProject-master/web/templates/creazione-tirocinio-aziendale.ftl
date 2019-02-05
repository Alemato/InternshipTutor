<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Creazione Offerta di Tirocinio</title>

    <#include "importCss.ftl">

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <div id="header" class="navbar-toggleable-md  shadow-after-3 clearfix position-fixed">
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
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>Gestione Tirocinio</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Gestione Tirocinio</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>
    <section id="centrale" class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="form_modifica" action="/Createtirocinio" method="post" class="sky-form .validate boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Crea un'offerta di tirocinio</header>
                <fieldset name="Modifica">
                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Titolo:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Titolo" name="Titolo" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Breve Descrizione:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="3" class="form-control form-control-1 word-count" data-maxlength="50"
                                          data-info="textarea-descrizione_breve" name="Descrizione_Breve"
                                          placeholder="Scrivi una breve descrizione dell'offerta di tirocinio  questa descrizione apparirà nel anteprima del offerta">provaaaa</textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 50 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_breve">0/50</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Descrizione Completa:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="5" class="form-control form-control-1 word-count" data-maxlength="200"
                                          data-info="textarea-descrizione_completa" name="Descrizione_Completa"
                                          placeholder="Scrivi una descrizione completa ed esaustiva dell'offerta di tirocinio">provaaaa</textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_completa">0/200</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Orari di svolgimento attività:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: 8:00 - 19:00 orario continuo" name="Orari"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Durata ore:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="ore" name="Durara_Ora"
                                       required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">
                            <h4>Durata Mesi:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="N Mesi" name="Durara_Mesi"
                                       required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">
                            <h4>Periodo Dall:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="date" name="Periodo_inizio"
                                       required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">
                            <h4>All:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="date"  name="Periodo_fine"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Modalità di svolgimento:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: lavoro nel team aziendale" name="Modalita"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Obbiettivi del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="5" class="form-control form-control-1 word-count" data-maxlength="200"
                                          data-info="textarea-obiettivi" name="Obiettivi"
                                          placeholder="Scrivi una descrizione completa ed esaustiva degli obiettivi dell'offerta di tirocinio"></textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-obiettivi">0/200</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Rimborsi:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: eventuali rimborsi spese" name="Rimborsi"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Facilitazioni previste:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: eventuali rimborsi spese" name="Facilitazioni"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Luogo di effettuazione del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: Presso l'azienda in via ..."
                                       name="AziendaOspitante"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Codice del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: DT0012151." name="CodiceIdentTirocinio"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Settore di inserimento:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: NON LO SO." name="SettoreInserimento"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Tempi di accesso locali aziendali:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Tempi_Accesso_Locali"
                                       name="TempiAccessoLocaliAziendali"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Nome Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Nome"
                                       name="NomeTutoreAziendale"
                                       required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Cognome Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Cognome"
                                       name="CognomeTutoreAziendale"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Telefono Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="tel" placeholder="Telefono."
                                       name="TelefonoTutoreAziendale"
                                       required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Email Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="email" placeholder="Email."
                                       name="EmailTutoreAziendale"
                                       required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Tutore Universitario:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form fancy-form-select">
                                <select id="TuroreUni" class="form-control select2" name="TutoreUniversitario">
                                    <option value="0">Pippo 1</option>
                                    <option value="1">Mario 1</option>
                                    <option value="2">Mario 2</option>
                                    <option value="3">Mario 3</option>
                                    <option value="NEW">Altro</option>
                                </select>

                                <i class="fancy-arrow-"></i>
                            </div>
                        </div>
                    </div>
                    <div id="NewTuroreUni" style="display: none">
                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Nome Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" placeholder="Nome"
                                           name="NomeTutoreUniversitario"
                                           required>
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Cognome Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" placeholder="Cognome"
                                           name="CognomeTutoreUniversitario"
                                           required>
                                </label>
                            </div>
                        </div>

                        <div  class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Telefono Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="tel" placeholder="Telefono."
                                           name="TelefonoTutoreUniversitario"
                                           required>
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Email Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="email" placeholder="Email."
                                           name="EmailTutoreUniversitario"
                                           required>
                                </label>
                            </div>
                        </div>
                    </div>

                </fieldset>

                <footer class="text-center text-sm-right">
                    <button type="submit" form="form_modifica"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                            class="fa fa-check"></i> Crea Offerta
                    </button>
                    <button type="reset" form="form_modifica" class="btn btn-red btn-lg pull-right float-sm-left mb-20">
                        <i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
        </div>
    </section>
    <!-- /FOOTER-->
    <footer id="footer">
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

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script src="/js/internshiptutor.js"></script>
<script>
    $("#TuroreUni").change( function () {
        console.log($("#TuroreUni").val());
        if ($("#TuroreUni").val() == "NEW") {
            $("#NewTuroreUni").fadeIn("show");
        } else {
            $("#NewTuroreUni").fadeOut();
        }
    })
</script>

</body>
</html>
