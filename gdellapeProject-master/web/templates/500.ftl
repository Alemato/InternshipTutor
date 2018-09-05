<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Errore Interno</title>
   <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">

<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>ERRORE INTERNO</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container">
            <h1 class="error-404 mb-15">500</h1>
            <h1 class="text-center mb-20">Internal Server Error</h1>
            <p class="fs-20 mb-10">Il server Web (che esegue il sito Web) ha riscontrato una condizione imprevista che
                gli ha impedito di soddisfare la richiesta da parte del client per l'accesso all'URL richiesto.
            </p>
            <p class="fs-20 mb-10">Questo errore può essere risolto solo mediante correzioni al software del server Web.
                Non è un problema lato client.
            </p>
            <p class="fs-20 mb-10">Spetta agli operatori del sito Web server individuare e analizzare i registri che
                dovrebbero fornire ulteriori informazioni sull'errore. Contatta gli Amministratori per altre
                informazioni.</p>
            <a class="fs-20 font-lato" href="index.html"><i class="glyphicon glyphicon-menu-left mr-10 fs-16"></i> Torna
                alla Homepage adesso!</a>
        </div>
    </section>
    <!-- /SECTION CENTER -->

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

</body>
</html>