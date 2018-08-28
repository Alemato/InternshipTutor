<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Il mio Account</title>

<#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/templates/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/templates/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/templates/css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/templates/imgs/imgpattern.jpg')">
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
            <div class="row justify-content-between">
                <div class="col-12 col-lg-6 mb-15">
                    <a href="impostazione-account-aziendale.html">
                        <div class="account-settings-item account-settings d-flex">
                            <img src="/templates/imgs/sign-in-lock.png" class="h-95 w-95 float-left m-0">
                            <div class="ml-10 mt-5 float-right">
                                <h4 class="Raleway text-uppercase fw-700 mb-5">Impostazioni Accout</h4>
                                <h6>Modifica il login, il nome e la password e tutti i tuo dati.</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-12 col-lg-6 mb-15">
                    <a href="tirocinio-aziendale.html">
                        <div class="account-settings account-settings-item d-flex">
                            <img src="/templates/imgs/internship-icon.png" class="h-85 w-85 float-left">
                            <div class="ml-10 mt-5 float-right">
                                <h4 class="Raleway text-uppercase fw-700 mb-5">Gestione Tirocinio</h4>
                                <h6>Gestione, Creazione offerte di tirocinio.</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-12 col-lg-6 mb-15">
                    <a href="richieste-tirocinio-aziendale.html">
                        <div class="account-settings account-settings-item d-flex">
                            <img src="/templates/imgs/document-icon.png" class="h-85 w-85 float-left">
                            <div class="ml-10 mt-5 float-right">
                                <h4 class="Raleway text-uppercase fw-700 mb-5">Gestione Richieste di Tirocinio</h4>
                                <h6>Gestione di tutte le richieste per tirocinii.</h6>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-12 col-lg-6 mb-15">
                    <a href="moduli-aziendale.html">
                        <div class="account-settings account-settings-item d-flex">
                            <img src="/templates/imgs/forms.png" class="h-90 float-left mb-5 mr-10">
                            <div class="ml-10 mt-5 float-right">
                                <h4 class="Raleway text-uppercase fw-700 mb-5">Modulistica</h4>
                                <h6>Richiedi e visualizza i moduli necessari per iter burocratico</h6>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
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
<script src="/templates/js/internshiptutor.js"></script>

</body>
</html>