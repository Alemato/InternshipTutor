<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Impostazioni account</title>

  <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">

<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>IMPOSTAZIONE ACCOUNT</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/account">Account</a></li>
                <li>Impostazione acccount</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <#if Message??>
                <#include "messaggio-errore.ftl">
            </#if>

            <form id="form_modifica" action="/account/impostazioni" method="post" class="sky-form  boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Aggiorna i tuoi dati</header>


                <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
                <fieldset name="Accesso">
                    <label class="input">
                        <p> Indirizzo Email</p>
                        <i class="ico-append giu fa fa-envelope"></i>
                        <input type="text" placeholder="Indirizzo Email" name="Email" value="" required>
                        <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                    </label>

                    <label class="input">
                        <p>Per modificare la tua password inserisci la precendente ed quella nuova nei due campi
                            successivi </p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Attuale" name="Password">
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                    <label class="input">
                        <p>Nuova Password</p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Nuova" name="PasswordNuova">
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                    <label class="input">
                        <p>Ripeti Nuova Password</p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Nuova" name="PasswordNuova1">
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                </fieldset>


                <div id="Ente-Azienda" class="header-form mb-30"><i class="fa fa-balance-scale"></i>&nbsp; INFORMAZIONI
                    ENTE /
                    AZIENDA
                </div>
                <fieldset name="Ente-Azienda">
                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Descrizione Azienda: &nbsp;</h4>
                        </div>

                        <textarea class="col-12 pt-5 mb-0 mr-10" rows="4" cols="1" name="Descrizione"
                                  placeholder="Scrivi una descrizione dettagliata dell&apos;azienda">not</textarea>

                    </div>
                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Link Azienda: &nbsp;</h4>
                        </div>
                        <div class="col-md-12 col-lg">
                            <label class="input">
                                <input type="text" placeholder="Link" name="Link" value="">
                            </label>
                        </div>
                    </div>
                </fieldset>


                <footer class="text-center text-sm-right">
                    <button type="submit" form="form_modifica"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                            class="fa fa-check"></i> Aggiorna
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
<script src="../js/internshiptutor.js"></script>


</body>
</html>