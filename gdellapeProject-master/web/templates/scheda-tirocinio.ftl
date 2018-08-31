<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>TIROCINIO PRESSO AVEJA</title>

    <#include "importCss.ftl">

<#--<!-- mobile settings &ndash;&gt;-->
<#--<meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>-->
<#--<!--[if IE]>-->
<#--<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]&ndash;&gt;-->

<#--<!-- WEB FONTS : use %7C instead of | (pipe) &ndash;&gt;-->
<#--<link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"-->
<#--rel="stylesheet" type="text/css"/>-->

<#--<!-- CORE CSS &ndash;&gt;-->
<#--<link href="/templates/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->

<#--<!-- THEME CSS &ndash;&gt;-->
<#--<link href="/templates/css/essentials.css" rel="stylesheet" type="text/css"/>-->
<#--<link href="/templates/css/layout.css" rel="stylesheet" type="text/css"/>-->

<#--<!-- PAGE LEVEL SCRIPTS &ndash;&gt;-->
<#--<link href="/templates/css/header-1.css" rel="stylesheet" type="text/css"/>-->
<#--<link href="/templates/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>-->
<#--<link href="/templates/css/internshiptutor.css" rel="stylesheet" type="text/css">-->

</head>
<body class="smoothscroll enable-animation">
<div id="wrapper">

    <#include "header.ftl">
<#--<div id="header" class="navbar-toggleable-md  shadow-after-3 clearfix position-fixed">-->
<#--<!-- TOP BAR&ndash;&gt;-->
<#--<div id="topBar" class="dark sticky">-->
<#--<div class="container">-->

<#--<!-- right &ndash;&gt;-->
<#--<ul class="top-links list-inline float-right has-topBar">-->
<#--<li>-->
<#--<a class="dropdown-toggle no-text-underline" data-toggle="dropdown" href="#"><i-->
<#--class="fa fa-user hidden-xs-down"></i> IL MIO ACCOUNT </a>-->
<#--<ul class="dropdown-menu float-right has-topBar">-->
<#--<li><a tabindex="-1" href="#"><i class="fa fa-history"></i> I MIEI-->
<#--TIROCINI</a></li>-->
<#--<li class="divider"></li>-->
<#--<li><a tabindex="-1" href="#"><i class="fa fa-cog"></i> IMPOSTAZIONI-->
<#--DELL'ACCOUNT </a></li>-->
<#--<li class="divider"></li>-->
<#--<li><a tabindex="-1" href="#"><i class="glyphicon glyphicon-off"></i> logout-->
<#--</a></li>-->
<#--</ul>-->
<#--</li>-->
<#--<li class="hidden-xs-down"><a href="#">LOGIN</a></li>-->
<#--<li class="hidden-xs-down"><a href="registrazione.html">REGISTRAZIONE</a></li>-->
<#--</ul>-->

<#--<!-- left &ndash;&gt;-->
<#--<ul class="top-links list-inline has-topBar">-->
<#--<li class="text-welcome hidden-xs-down p-10">Benvenuto, <strong>Mario Rossi</strong></li>-->
<#--</ul>-->

<#--</div>-->
<#--</div>-->
<#--<!-- /TOP BAR&ndash;&gt;-->


<#--<header id="topNav">-->
<#--<div class="container">-->
<#--<!-- Mobile Menu Button &ndash;&gt;-->
<#--<button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">-->
<#--<i class="fa fa-bars"></i>-->
<#--</button>-->


<#--<!-- Logo &ndash;&gt;-->
<#--<a class="logo float-left mb-5 mr-10scripts.jsscripts.js" href="index.html">-->
<#--<img src="/templates/imgs/interns.jpg" alt=""/>-->
<#--</a>-->

<#--<div class="navbar-collapse collapse nav-main-collapse submenu-dark">-->
<#--<nav class="nav-main">-->
<#--<ul id="topMain" class="nav nav-pills nav-main">-->
<#--<li class="dropdown active">-->
<#--<a class="dropdown-toggle noicon" href="index.html">-->
<#--HOME-->
<#--</a>-->
<#--</li>-->
<#--<li class="dropdown active">-->
<#--<a class="dropdown-toggle noicon" href="offerte-tutoraggi.html">-->
<#--LISTA OFFERTE TUTORAGGI-->
<#--</a>-->
<#--</li>-->
<#--<li class="dropdown active">-->
<#--<a class="dropdown-toggle noicon" href="lista-convenzioni.html">-->
<#--LISTA CONVENZIONI-->
<#--</a>-->
<#--</li>-->
<#--<li class="dropdown active">-->
<#--<a class="dropdown-toggle noicon" href="informazioni.html">-->
<#--INFORMAZIONI-->
<#--</a>-->
<#--</li>-->
<#--<form class="d-inline-block col-lg-12 col-xl-4 mb-lg-2">-->
<#--<div class="input-group">-->
<#--<input type="text" class="form-control" aria-label=""-->
<#--placeholder="Cerca nell'intero del sito">-->
<#--<span class="input-group-btn">-->
<#--<button class="btn btn-primary material-ico" type="submit">-->
<#--<i class="material-icons">search</i>-->
<#--</button>-->
<#--</span>-->
<#--</div>-->
<#--</form>-->
<#--</ul>-->
<#--</nav>-->
<#--</div>-->
<#--</div>-->
<#--</header>-->
<#--</div>-->

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>Tirocinio Presso ${AziendaOspitante}</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li>Tirocini</li>
                <li>Tirocinio Presso ${AziendaOspitante} </li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container p-0">
            <h2 class="uppercase fw-100 mb-15">Dettagli Tirocinio :<span
                    class="fw-600 ml-10">Tirocinio Presso ${AziendaOspitante}</span></h2>
            <div class="linea-divisione mt-0"></div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Descrizione :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro"><p>${Descrizione}</p>
                        <p>Per informazioni e candidature contattare la prof.ssa Monica Nesi</p></h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Luogo di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                    ${LuogoEffettuazione}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Orari di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Orario}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Durata del tirocinio :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        Dal ${PeriodoInizio} al ${PeriodoFine}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Obiettivi del tirocinio:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Obbiettivi}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Modalit&agrave; di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${Modalita}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Rimborsi spese e facilitzioni previste :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        <#if Rimbosi??>${Rimbosi}<#else>Nessun tipo di rimborso.</#if><#if Facilitazioni??> ${Facilitazioni}<#else>Nessun tipo di facilitazione prevista.</#if>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Nome e Cognome del Responsabile aziendale:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${NomeRespAz} ${CognomeRepAz}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Email del responsabile aziendale :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-send fs-19 pl-15 pt-4 mr-10"></i>
                    <h4 class="testo-scuro">
                        <a href="mailto:mario.rossi@aveja.it">${EmailRespAZ}</a>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">telefono responsabile Aziendale :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-phone-square fs-19 pl-15 pt-4 mr-10"></i><h4 class="testo-scuro letter-spacing-1">
                    ${TelRespAz}
                </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Nome e cognome referente interno :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${NomeTutUni} ${CognomeTutUni}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Email del refernte interno:</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-send fs-19 pl-15 pt-4 mr-10"></i><h4 class="testo-scuro">
                    <a href="mailto:francesco.totti@1a0.gol">${EmailTutUni}</a>
                </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">telefono referente interno :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-phone-square fs-19 pl-15 pt-4 mr-10"></i><h4 class="testo-scuro letter-spacing-1">
                    ${TelefonoTutUni}
                </h4>
                </div>
            </div>

            <form id="manda_iscrizione" method="get" action="#">
                <input type="hidden" name="tirocinio" value="Aveja">
                <button type="submit" form="manda_iscrizione"
                        class="btn btn-blue b-blu btn-lg pull-right float-right"><i
                        class="fa fa-check"></i> Invia Domanda
                </button>
            </form>
        </div>
    </section>

<#include "footer.ftl">
    <#--<!-- /FOOTER&ndash;&gt;-->
    <#--<footer id="footer">-->
        <#--<div class="container">-->

            <#--<div class="row">-->

                <#--<div class="col-md-3">-->
                    <#--<div class="row">-->
                        <#--<div class="col-4">-->
                            <#--<!-- Footer Logo &ndash;&gt;-->
                            <#--<img class="footer-logo" src="http://www.disim.univaq.it/didattica/img/logo_univaq.png"-->
                                 <#--alt=""/>-->
                        <#--</div>-->
                        <#--<div class="col-6 text-left py-5p">-->

                            <#--<!-- Short Description &ndash;&gt;-->
                            <#--<a href="http://univaq.it">Università degli Studi dell'Aquila</a>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<!-- Contact Address &ndash;&gt;-->
                    <#--<address>-->
                        <#--<ul class="list-unstyled">-->
                            <#--<li class="footer-sprite address">-->
                                <#--67100 L'Aquila, Coppito, Via Vetoio<br>-->
                            <#--</li>-->
                            <#--<li class="footer-sprite phone">-->
                                <#--Phone: +39 0862 433002-->
                            <#--</li>-->
                            <#--<li class="footer-sprite phone">-->
                                <#--Phone: +39 0862 433180 (fax)-->
                            <#--</li>-->
                            <#--<li class="footer-sprite email">-->
                                <#--<a href="mailto:disim.sad@univaq.it">disim.sad@univaq.it</a>-->
                            <#--</li>-->
                        <#--</ul>-->
                    <#--</address>-->
                    <#--<!-- /Contact Address &ndash;&gt;-->

                <#--</div>-->


                <#--<div class="col-md-4">-->

                    <#--<!-- Newsletter Form &ndash;&gt;-->
                    <#--<h4 class="letter-spacing-1">INTERNSHIP TUTOR</h4>-->
                    <#--<p>Internship Tutor rappresenta un sistema web per la gestione dell'iter completo dei tirocini-->
                        <#--universitari del degli Studi dell'Aquila.</p>-->
                <#--</div>-->


                <#--<div class="col-md-3">-->

                    <#--<!-- Latest Blog Posts &ndash;&gt;-->
                    <#--<h4 class="letter-spacing-1">ULTIME OFFERTE PUBLICATE</h4>-->
                    <#--<ul class="footer-posts list-unstyled">-->
                        <#--<li>-->
                            <#--<a href="#">L'azienda PACARO srl, sede di Borgorose (RI), ricerca tirocinanti</a>-->
                            <#--<small>29 June 2017</small>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<a href="#">Tirocini e stage retributi presso la Gunpowder S.r.l. (Spinoff Univ.-->
                                <#--L'Aquila)</a>-->
                            <#--<small>29 June 2017</small>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<a href="#">Tirocinio presso Aveja</a>-->
                            <#--<small>29 June 2017</small>-->
                        <#--</li>-->
                    <#--</ul>-->
                    <#--<!-- /Latest Blog Posts &ndash;&gt;-->

                <#--</div>-->

                <#--<div class="col-md-2">-->

                    <#--<!-- Links &ndash;&gt;-->
                    <#--<h4 class="letter-spacing-1">LINK UTILI</h4>-->
                    <#--<ul class="footer-links list-unstyled">-->
                        <#--<li><a href="#">Home</a></li>-->
                        <#--<li><a href="#">Lista Offerte Tuttoraggi</a></li>-->
                        <#--<li><a href="#">Lista Convenzioni</a></li>-->
                        <#--<li><a href="#">Contattaci</a></li>-->
                        <#--<li><a href="#">Il Mio Accout</a></li>-->
                        <#--<li><a href="#">I Miei Tirocini</a></li>-->

                    <#--</ul>-->
                    <#--<!-- /Links &ndash;&gt;-->

                <#--</div>-->


            <#--</div>-->

        <#--</div>-->

        <#--<div class="copyright">-->
            <#--<div class="container">-->
                <#--<ul class="float-right m-0 list-inline mobile-block">-->
                    <#--<li><a href="#">Terms & Conditions</a></li>-->
                    <#--<li>&bull;</li>-->
                    <#--<li><a href="#">Privacy</a></li>-->
                <#--</ul>-->
                <#--&copy; All Rights Reserved, INTERNSHIP TUTOR-->
            <#--</div>-->
        <#--</div>-->
    <#--</footer>-->
    <#--<!-- /FOOTER &ndash;&gt;-->
</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<#--<script>var plugin_path = 'plugins/';</script>-->
<#--<script src="plugins/jquery/jquery-3.3.1.min.js"></script>-->
<#--<script src="js/scripts.js"></script>-->
<#--<script src="plugins/bootstrap/js/bootstrap.js"></script>-->
<script src="js/internshiptutor.js"></script>


</body>
</html>