<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Il mio Account</title>



<#include "importCss.ftl">
</head>
<body class="smoothscroll enable-animation">
<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>Il Mio Account</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Il mio accoun</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container p-0">
            <h3 class="mb-15">Il Mio Account </h3>
            <div class="linea-divisione mt-0"></div>
            <div class="row justify-content-between">
                <a class=" account-settings" href="/impostazioneTirocinante">
                    <div class="account-settings-item d-flex">
                        <img src="imgs/sign-in-lock.png" class="h-90 float-left m-0">
                        <div class="ml-10 mt-5 float-right">
                            <h4 class="Raleway text-uppercase fw-700 mb-5">Impostazioni Accout</h4>
                            <h6>Modifica il login, il nome, la password, ecc.</h6>
                        </div>
                    </div>
                </a>
                <a class=" account-settings" href="documentazione.html">
                    <div class="account-settings-item d-flex">
                        <img src="imgs/document-icon.png" class="h-90 w-90 float-left">
                        <div class="ml-10 mt-5 float-right">
                            <h4 class="Raleway text-uppercase fw-700 mb-5">Documentazione</h4>
                            <h6>Scarica la documentazione precompilata.</h6>
                        </div>
                    </div>
                </a>
                <a class=" account-settings" href="gestione-tirocinio.html">
                    <div class="account-settings-item d-flex">
                        <img src="imgs/internship-icon.png" class="h-90 float-left mb-5 mr-10">
                        <div class="ml-10 mt-5 float-right">
                            <h4 class="Raleway text-uppercase fw-700 mb-5">Gestionio Tirocinio</h4>
                            <h6>Gestionione della richiesta di tirocinio e visualizzazione dei dettagli del tirocinio scelto.</h6>
                        </div>
                    </div>
                </a>
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
                            <a href="http://univaq.it">Universit?? degli Studi dell'Aquila</a>
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

<script src="js/internshiptutor.js"></script>

</body>
</html>