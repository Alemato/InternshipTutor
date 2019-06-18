<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Gestione tirocinio</title>

    <#include "importCss.ftl">

</head>
<body class="enable-animation">

<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>GESTIONI TUTORAGGIO </h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li><a href="/account/moduli">Tirocini e Moduli</a></li>
                <li>Gestione Tutoraggio</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>


    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container p-0">

            <#if tirocinio.stato == 0>
                <!-- HAI INVIATO LA CANDIDATURA MA DEVI ASP-->
                <div class="alert alert-info mb-30"><!-- INFO -->
                    <strong>In attesa di approvazione della candidatura da parte di <a
                                href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}
                            !</a></strong><br>
                    La preghiamo di attende fino a quando non sia disponibile una risposta da parte dell'azienda <a
                            href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}</a> per la sua
                    candidatura per il
                     <a
                            href="/listaofferte/tirocinio?Tirocinio=${tirocinio.offertaTirocinio}">"tirocinio
                        "</a> presso ${azienda.ragioneSociale}.
                </div>
            <#elseif tirocinio.stato == 1>
                <!-- HA ACCETTATO LA CANDIDATURA -->
                <div class="alert alert-success mb-30"><!-- SUCCESS -->
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&ast;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <strong>La tua candidatura &egrave; stata Accettata!</strong><br> Congratualazioni in questa pagina potrai
                    vedere tutti i dati inerenti al tirocinio che stai svolgendo.
                </div>
            <#elseif tirocinio.stato == 3 || tirocinio.stato == 4>

                <div class="alert alert-success mb-30"><!-- SUCCESS -->
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&ast;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <strong>Complimenti!! Hai terminato il Tirocinio con <a
                                href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}</a></strong><br>
                    In questa pagina potrai
                    vedere tutti i dati inerenti al tirocinio che hai svolto.
                    <br>
                    <#if tirocinio.stato == 2>
                        Devi attendere che la Segreteria decreti la finde del tirocinio
                    <#elseif tirocinio.stato == 3>
                        Se non hai votato il tirocinio svolto vai in fondo alla pagina per esprimere la tua valutazione a
                        riguardo <a href="#valutazione">cliccando qui.</a>
                    <#elseif tirocinio.stato == 4>
                        Grazie per aver votato votato!
                    </#if>

                </div>
            <#elseif tirocinio.stato == 2>
                <div class="alert alert-success mb-30"><!-- SUCCESS -->
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&ast;</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <strong>Devi attendere che la Segreteria decreti la finde del tirocinio.</strong>
                </div>
            <#else>
                <!-- NON HAI INVIATO LA CANDIDATURA -->
                <div class="alert alert-warning mb-30"><!-- WARNING -->
                    <strong>Attenzione!</strong> &nbsp; &nbsp;Non ti sei candidato per nessuna offerta! &nbsp; &nbsp;
                    Vai
                    alla <a href="/listaofferte">lista delle offerte</a> per inviare una candidatura.
                </div>
            </#if>

            <h3 class="fw-100 mb-15">Dettagli Tirocinio</h3>
            <div class="linea-divisione mt-0 mb-25"></div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Luogo di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${azienda.ragioneSociale}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Descrizione :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro"><p>${offertaTirocinio.descrizione}
                        </p>
                        <p>Per informazioni e candidature contattare la prof.ssa Monica Nesi</p></h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Luogo di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${offertaTirocinio.luogoEffettuazione}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Orari di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${offertaTirocinio.orari}

                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Durata del tirocinio :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        Dal ${offertaTirocinio.periodoInizio} al ${offertaTirocinio.periodoFine}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Modalit&agrave; di svolgimento :</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${offertaTirocinio.modalita}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Rimborsi spese:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        <#if offertaTirocinio.rimborsi??>
                            ${offertaTirocinio.rimborsi}
                        <#else>
                        Nessuno
                        </#if>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Facilitzioni previste:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        <#if offertaTirocinio.facilitazioni??>
                            ${offertaTirocinio.facilitazioni}
                        <#else>
                            Nessuna
                        </#if>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Nome e Cognome del legale rappresentante dell'azienda:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${azienda.nomeLegaleRappresentante} ${azienda.cognomeLegaleRappresentante}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Nome e cognome del tutore aziendale:</h4>
                </div>
                <div class="col-12 col-md-5 col-lg-6">
                    <h4 class="testo-scuro">
                        ${offertaTirocinio.nomeTutoreAziendale} ${offertaTirocinio.cognomeTutoreAziendale}
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Email del tutore aziendale:</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-send fs-19 pl-15 pt-4 mr-10"></i><h4 class="testo-scuro">
                        <a href="mailto:francesco.totti@1a0.gol">${offertaTirocinio.emailTutoreAziendale}</a>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                    <h4 class="uppercase testo-chiaro">Telefono del tutore aziendale :</h4>
                </div>
                <div class="row col-12 col-md-5 col-lg-6 mb-sm-5 mb-0">
                    <i class="fa fa-phone-square fs-19 pl-15 pt-4 mr-10"></i><h4
                            class="testo-scuro letter-spacing-1">
                        ${offertaTirocinio.telefonoTutoreAziendale}
                    </h4>
                </div>
            </div>

            <a name="valutazione"></a>
            <h2 class="mb-15 mt-25">Valutazione del turoraggio</h2>
            <#if tirocinio.stato == 3>
                <div class="linea-divisione mt-0"></div>
                <form id="valutazione_finale" method="post"
                      action="/account/moduli/gestionetirocinioscelto?idTirocinio=${tirocinio.IDTirocinio}" class="col-10 pl-0 mx-auto"
                      novalidate>
                    <fieldset>
                        <div>
                            <div class="mb-20">
                                <label for="valutazione_tutoraggio" class="text-center mb-15">Valuta il tutoraggio
                                    svolto dando un punteggio tra 0
                                    (Molto Negativo) e 5 (Molto positivo).</label>
                                <label class="field select col-12 pl-0 pr-0 mx-auto">
                                    <select class="form-control" name="valutazioneTutoraggio"
                                            id="valutazione_tutoraggio">
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option selected="selected">3</option>
                                        <option>4</option>
                                        <option>5</option>

                                    </select>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                            <div class="slider-wrapper col-12  pl-0 mx-auto mb-35">
                                <div id="slider4"></div>
                            </div>
                        </div>

                        <footer class="hidden-xs-down">
                            <div class="text-center">
                                <button type="submit" form="valutazione_finale" class="btn btn-success btn-lg"><i
                                            class="fa fa-check"></i> Invia la valutazione
                                </button>
                            </div>
                        </footer>

                        <footer class="hidden-sm-up">
                            <button type="submit" form="valutazione_finale"
                                    class="btn btn-success btn-lg pull-right col mb-25 mt-15"><i
                                        class="fa fa-check"></i> Invia la valutazione
                            </button>
                        </footer>

                    </fieldset>
                </form>
            <#elseif tirocinio.stato == 2>
                <div class="alert alert-info mb-30">
                    <strong>Valutazione del tutoraggio ancora non consentita devi attendere che la segreteria decreti la fine del tirocinio presso <a
                                href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}</a></strong><br>
                    La preghiamo di attende fino al termine del tirocinio
                </div>
            <#elseif tirocinio.stato == 4>
                <!-- HAI GIA VOTATO-->

                <div class="alert alert-info mb-30">
                    <strong>hai gi&agrave; votato il tirocinio svolto presso <a
                                href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}</a></strong>
                </div>
            <#elseif tirocinio.stato == 1>
                <!-- HAI INVIATO LA CANDIDATURA MA DEVI ASP-->

                <div class="alert alert-info mb-30">
                    <strong>Valutazione del tutoraggio ancora non consentita devi completare il tirocinio presso <a
                                href="/schedaazienda?ID=${azienda.IDAzienda}">${azienda.ragioneSociale}</a></strong><br>
                    La preghiamo di attende fino al termine del tirocinio
                </div>

            </#if>
        </div>
    </section>


    <!-- /FOOTER-->
    <#include "footer.ftl">
    <!-- /FOOTER -->

</div>


<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

<script src="/plugins/jquery/jquery-ui.min.js"></script>
<script src="/plugins/jquery/jquery.ui.touch-punch.min.js"></script>
<script src="/plugins/form.slidebar/jquery-ui-slider-pips.min.js"></script>
<script>
    var select = jQuery("#valutazione_tutoraggio");
    var guestnumber = jQuery("#slider4").slider({
        min: 0,
        max: 5,
        animate: true,
        range: "min",
        value: select[0].selectedIndex + 1,
        slide: function (event, ui) {
            select[0].selectedIndex = ui.value - 1;
        }
    });

    jQuery("#valutazione_tutoraggio").change(function () {
        guestnumber.slider("value", this.selectedIndex + 1);
    });

    jQuery("#slider4").slider("pips", {
        rest: false
    });


</script>

</body>
</html>