<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Impostazioni Account</title>

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

            <h1>IMPOSTAZIONE ACCOUNT</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="index.html">Home</a></li>
                <li>Impostazione acccount</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="form_modifica" action="print.php" method="post" class="sky-form .validate boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Aggiorna i tuoi dati</header>
            <#if Message??>
            <#include "messaggio-errore.ftl">
            </#if>

                <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
                <fieldset name="Accesso">
                    <label class="input">
                        <p> Indirizzo Email</p>
                        <i class="ico-append giu fa fa-envelope"></i>
                        <input type="text" placeholder="Indirizzo Email" name="Email" value="${User.email}" required>
                        <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                    </label>

                    <label class="input">
                        <p> Password</p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Attuale" name="Password" required>
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                    <label class="input">
                        <p> Password</p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Nuova" name="PasswordNuova" required>
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                    <label class="input">
                        <p> Password</p>
                        <i class="ico-append giu fa fa-lock"></i>
                        <input type="password" placeholder="Password Nuova" name="PasswordNuova1" required>
                        <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                            al tuo account</b>
                    </label>
                </fieldset>


                <div id="Tirocinante" class="header-form mb-30"><i class="fa fa-user"></i> INFORMAZIONI
                    PERSONALI TIROCINANTE
                </div>
                <fieldset name="Tirocinante">
                    <div class="row pr-15 mb-35">
                        <div class="col-md-auto mt-6 pr-0">
                            <h4>Nominativo del tirocinante: </h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Nome" name="Nome" value="${Tirocinante.nome}" required>
                            </label>
                        </div>
                        <div class="col col">
                            <label class="input">
                                <input type="text" placeholder="Cognome" name="Cognome"  value="${Tirocinante.cognome}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row pr-15 mb-35">
                        <div class="col-md-auto mt-6">
                            <h4>Nato a:</h4>
                        </div>

                        <div class="col">
                            <label class="input">
                                <i class="ico-append fa fa-map-o"></i>
                                <input type="text" placeholder="Luogo di Nascita" name="LuogoNascita" value="${Tirocinante.luogoDiNascita}" required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Provincia: </h4>
                        </div>

                        <div class="col-md-1">
                            <label class="input">
                                <input type="text" class="masked" data-format="aa" placeholder="XX" name="ProvinciaNascita"
                                        value="${Tirocinante.provinciaDiNascita}" required>
                            </label>
                        </div>


                        <div class="col-md-auto mt-6">
                            <h4>Il: </h4>
                        </div>

                        <div class="col">
                            <label class="input">
                                <input type="date" name="DataNascita" value="${Nascita}" required>
                                <p>${Nascita}</p>
                            </label>
                        </div>
                    </div>

                    <div class="row pr-15 mb-35">
                        <div class="col-md-auto mt-6 pr-0">
                            <h4>Residente in: </h4>
                        </div>

                        <div class="col">
                            <label class="input">
                                <i class="ico-append fa fa-map-o"></i>
                                <input type="text" placeholder="Luogo di Residenza" name="LuogoResidenza" value="${Tirocinante.luogoDiResidenza}" required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Provincia: </h4>
                        </div>

                        <div class="col-md-1">
                            <label class="input">
                                <input type="text" class="masked" data-format="aa" data-placeholder="X" placeholder="XX"
                                       name="ProvinciaResidenza"  value="${Tirocinante.provinciaDiResidenza}" required>
                            </label>
                        </div>

                    </div>

                    <div class="row pr-15 mb-35">
                        <div class="col-md-auto mt-6 pr-0">
                            <h4>Codice Fiscale: </h4>
                        </div>

                        <div class="col">
                            <label class="input mb-20">
                                <input type="text" class="masked uppercase" data-format="****************" data-placeholder="X"
                                       placeholder="Codice Fiscale" name="CodiceFiscale" value="${Tirocinante.codiceFiscale}" required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6 pr-0">
                            <h4>Numero di Telefono: </h4>
                        </div>

                        <div class="col">
                            <label class="input mb-20">
                                <i class="ico-append fa fa-phone"></i>
                                <input type="text" class="masked" data-format="999-9999999" data-placeholder="XXX-XXXXXXX"
                                       placeholder="Numero di telefono" name="NumeroTelefono" value="${Tirocinante.telefono}" required>
                            </label>
                        </div>

                    </div>

                    <h4 class="text-center mb-10 mt-30">Attuale condizione :</h4>
                    <h5 class="text-center fs-16 mb-30">(barrare la casella e compila la casella di testo a fianco &ndash;
                        possibilit&agrave; di doppia scelta)</h5>

                    <div class="row pr-15 pl-15 pr-15">
                        <label class="checkbox mt-6">
                            <input type="checkbox" name="CKStudenteCorsoLaurea" value= "1" <#if Tirocinante.corsoDiLaurea??> checked="checked"</#if>>
                            <i></i> Studente Corso di Laurea in:
                        </label>

                        <label class="input col">
                            <input type="text" placeholder="Corso di Laurea" name="StudenteCorsoLaurea" <#if Tirocinante.corsoDiLaurea??>    value = "${Tirocinante.corsoDiLaurea}" </#if>>
                        </label>
                    </div>

                    <div class="row pl-15 pr-15">
                        <label class="checkbox mt-6">
                            <input type="checkbox" name="CKDiplomaUniversitario" value="1" <#if Tirocinante.diplomaUniversitario?? > checked="checked"</#if>>
                            <i></i> Diplomato. Diploma universitario in <em class="fw-100">(entro 12 mesi dal diploma)</em>
                            &nbsp;:
                        </label>
                        <label class="input col">
                            <input type="text" placeholder="Diploma universitario" name="DiplomaUniversitario" <#if Tirocinante.diplomaUniversitario??> value= "${Tirocinante.diplomaUniversitario}" </#if>  >
                        </label>
                    </div>

                    <div class="row pl-15 pr-15">
                        <label class="checkbox mt-6">
                            <input type="checkbox" name="CKLaureaIn" value="1" <#if Tirocinante.laureatoUniversitario?? > checked="checked" </#if>>
                            <i></i> Laureato. Laurea in <em class="fw-100">(entro 12 mesi dalla laurea)</em> &nbsp;:
                        </label>
                        <label class="input col">
                            <input type="text" placeholder="Corso di Laurea" name="LaureaIn" <#if Tirocinante.laureatoUniversitario??> value="${Tirocinante.laureatoUniversitario}" </#if> >
                        </label>
                    </div>

                    <div class="row pl-15 pr-15">
                        <label class="checkbox mt-6">
                            <input type="checkbox" name="CKDottoratoRicerca" value="1" <#if Tirocinante.dottoratoDiRicerca??> checked="checked" </#if>>
                            <i></i> Dottorato di ricerca in:
                        </label>
                        <label class="input col">
                            <input type="text" placeholder="Dottorato di ricerca" name="DottoratoRicerca" <#if Tirocinante.dottoratoDiRicerca??> value="${Tirocinante.dottoratoDiRicerca}" </#if>  >
                        </label>
                    </div>

                    <div class="row pl-15 pr-15">
                        <label class="checkbox mt-6 pr-0">
                            <input type="checkbox" name="CKScuolaAltro" value="1"  <#if Tirocinante.scuolaAltro??> checked="checked" </#if> >
                            <i></i> Scuola o corso di perfezionamento o specializzazione in:
                        </label>
                        <label class="input col">

                            <input type="text" placeholder="Scuola o altro" name="ScuolaAltro" <#if Tirocinante.scuolaAltro??> value="${Tirocinante.scuolaAltro}" </#if> >

                        </label>
                    </div>


                    <div class="row mb-100 mt-80">
                        <div class="col-md-auto mt-4">
                            <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                        </div>
                        <div class="col-md-auto">
                            <label class="checkbox mt-6 pr-0">
                                <input type="checkbox" name="Handicap" value="Si" >
                                <i></i> SI
                            </label>
                            <label class="checkbox mt-6 pr-0">
                                <input type="checkbox" name="Handicap" value="NO" checked="checked">
                                <i></i> NO
                            </label>
                        </div>
                    </div>

                </fieldset>


                <footer>
                    <button type="submit" form="form_modifica" class="btn btn-success btn-lg pull-right float-right"><i
                            class="fa fa-check"></i> Aggiurna il tuo Account
                    </button>
                    <button type="reset" form="form_modifica" class="btn btn-red btn-lg pull-right float-left"><i
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
<script src="js/internshiptutor.js"></script>

</body>
</html>