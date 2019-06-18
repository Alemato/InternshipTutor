<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Impostazioni Account</title>

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
                <li><a href="/">Home</a></li>
                <li>Impostazione acccount</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <#if ModApp??>
                <div class="alert alert-success mb-30 fs-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Congratulazioni! </strong> ${ModApp}
                </div>
            </#if>
            <form id="form_modifica" action="/account/impostazioni" method="post" class="sky-form .validate boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Aggiorna i tuoi dati</header>
                <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
                <fieldset name="Accesso">
                    <#if MesError??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>ERRORE!</strong> ${MesError}
                        </div>
                    </#if>
                    <label class="input">
                        <#if MesError??>
                            <p><em>*</em>&nbsp;Indirizzo Email Attuale</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" class="error" placeholder="Indirizzo Email" name="EmailAttuale" required>
                            <b class="tooltip tooltip-bottom-right">Necessario per garantire la tua identit&agrave;</b>
                        <#else>
                            <p><em>*</em>&nbsp;Indirizzo Email Attuale</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" placeholder="Indirizzo Email" name="EmailAttuale" required>
                            <b class="tooltip tooltip-bottom-right">Necessario per garantire la tua identit&agrave;</b>
                        </#if>
                    </label>

                    <label class="input">
                        <#if MesError??>
                            <p><em>*</em>&nbsp;Password Attuale</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" class="error" placeholder="Password Attuale" name="PasswordAttuale"
                                   required>
                            <b class="tooltip tooltip-bottom-right">Necessario per garantire la tua identit&agrave;</b>
                        <#else>
                            <p><em>*</em>&nbsp;Password Attuale</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" placeholder="Password Attuale" name="PasswordAttuale" required>
                            <b class="tooltip tooltip-bottom-right">Necessario per garantire la tua identit&agrave;</b>
                        </#if>
                    </label>

                    <p><em>*</em> Campi necessari per effettuare le modifice</p>
                    <#if MesErrorEmail??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>ERRORE!</strong> ${MesErrorEmail}
                        </div>
                    </#if>
                    <#if MesErrorEmailValidation??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>ERRORE!</strong> ${MesErrorEmailValidation}
                        </div>
                    </#if>
                    <#if MesWarningEmail??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${MesWarningEmail}
                        </div>
                    </#if>
                    <label class="input">
                        <#if MesErrorEmail??  || MesErrorEmailValidation?? || MesWarningEmail??>
                            <p> Nuovo Indirizzo Email</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" class="error" placeholder="Indirizzo Email" name="Email">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login</b>
                        <#else>
                            <p> Nuovo Indirizzo Email</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" placeholder="Indirizzo Email" name="Email">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login</b>
                        </#if>
                    </label>
                    <label class="input mb-30">
                        <#if MesErrorEmail??  || MesErrorEmailValidation?? || MesWarningEmail??>
                            <p> Ripeti il nuovo Indirizzo Email</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" class="error" placeholder="Indirizzo Email" name="EmailRipetuta">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login</b>
                        <#else>
                            <p> Ripeti il nuovo Indirizzo Email</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="text" placeholder="Indirizzo Email" name="EmailRipetuta">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login</b>
                        </#if>
                    </label>
                    <#if MesErrorPWD??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>ERRORE!</strong> ${MesErrorPWD}
                        </div>
                    </#if>
                    <#if MesErrorValidationPWD??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>ERRORE!</strong> ${MesErrorValidationPWD}
                        </div>
                    </#if>
                    <#if MesWarningPWD??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${MesWarningPWD}
                        </div>
                    </#if>

                    <label class="input">
                        <#if MesErrorPWD??  || MesErrorValidationPWD?? || MesWarningPWD??>
                            <p>Nuova Password</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" class="error" placeholder="Password Nuova" name="Password">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login, Solo caratteri e numeri
                                latini, necessario per l&apos;accesso
                                al tuo account</b>
                        <#else>
                            <p>Nuova Password</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" placeholder="Password Nuova" name="Password">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login, Solo caratteri e numeri
                                latini, necessario per l&apos;accesso
                                al tuo account</b>
                        </#if>
                    </label>

                    <label class="input">
                        <#if MesErrorPWD??  || MesErrorValidationPWD?? || MesWarningPWD??>
                            <p>Ripeti la nuova Password</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" class="error" placeholder="Password Nuova" name="PasswordRipetuta">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login, Solo caratteri e numeri latini,
                                necessario per l&apos;accesso
                                al tuo account</b>
                        <#else>
                            <p>Ripeti la nuova Password</p>
                            <i class="ico-append giu fa fa-lock"></i>
                            <input type="password" placeholder="Password Nuova" name="PasswordRipetuta">
                            <b class="tooltip tooltip-bottom-right">Necessario per il login, Solo caratteri e numeri latini,
                                necessario per l&apos;accesso
                                al tuo account</b>
                        </#if>
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
                                <input type="date" name="DataNascita" value="${Tirocinante.dataDiNascita}" required>
                                <#--<p>${Tirocinante.dataDiNascita}</p>-->
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
                                       placeholder="Numero di telefono" name="Telefono" value="${Tirocinante.telefono}" required>
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
                            <input type="checkbox" name="CKLaureaIn" value="1" <#if Tirocinante.laureato?? > checked="checked" </#if>>
                            <i></i> Laureato. Laurea in <em class="fw-100">(entro 12 mesi dalla laurea)</em> &nbsp;:
                        </label>
                        <label class="input col">
                            <input type="text" placeholder="Corso di Laurea" name="LaureaIn" <#if Tirocinante.laureato??> value="${Tirocinante.laureato}" </#if> >
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
                            <h4>Barrare se trattasi di soggetto portatore di handicap: <#if Handicap??> <i class="danger"> ${Handicap}</i></#if> </h4>
                        </div>
                        <div class="col-md-auto">
                            <label class="checkbox mt-6 pr-0">
                                <input type="checkbox" name="Handicap" value="Si" <#if Tirocinante.handicap == true> checked="checked" </#if>>
                                <i></i> SI
                            </label>
                            <label class="checkbox mt-6 pr-0">
                                <input type="checkbox" name="Handicap" value="No" <#if Tirocinante.handicap == false> checked="checked" </#if>>
                                <i></i> NO
                            </label>
                        </div>
                    </div>

                </fieldset>


                <footer>
                    <button type="submit" form="form_modifica" class="btn btn-success btn-lg pull-right float-right"><i
                            class="fa fa-check"></i> Aggiorna il tuo Account
                    </button>
                    <button type="reset" form="form_modifica" class="btn btn-red btn-lg pull-right float-left"><i
                            class="fa fa-times"></i> Annulla
                    </button>
                </footer>

            </form>
        </div>
    </section>

    <!-- /FOOTER-->
    <#include "footer.ftl">
    <!-- /FOOTER -->

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script src="/js/internshiptutor.js"></script>

</body>
</html>