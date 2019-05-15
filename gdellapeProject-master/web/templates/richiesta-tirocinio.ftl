<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Moduli</title>

    <!-- mobile settings -->
    <#include "importCss.ftl">
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1 class="uppercase">Modulo Progetto Formativo e Di Orientamento</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li>Tirocini</li>
                <li>Tirocinio Presso ${azienda.ragioneSociale}</li>
                <li>Invio Modulo</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_richiesta_tirocinante"
                  action="/listaofferte/tirocinio/inviorichiesta?idOffertaTirocinio=${offertatirocinio.IDOffertaTirocinio}"
                  method="post" class="m-0">
                <fieldset>
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati, aggiorna quelli mancanti e clicca su
                        invia per inviare la
                        richiesta</h1>


                    <div class="row mb-0 mr-10 ">
                        <#if erroreNome?? || erroreCognome??>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nominativo del tirocinante </h4>
                        <input class="input-modulo col col-sm pl-0 error" type="text" name="Nominativo"
                               value="${tirocinante.nome} ${tirocinante.cognome}"
                               placeholder="Nome e Cognome del tirocinante" required>
                        <#else>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">Nominativo del tirocinante </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo"
                               value="${tirocinante.nome} ${tirocinante.cognome}"
                               placeholder="Nome e Cognome del tirocinante" required>
                        </#if>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nato a</h4>
                        <input class="input-modulo col-3 col-sm-3 col-md-6 col-lg-7 pl-0" type="text"
                               name="LuogoDiNnascita" value="${tirocinante.luogoDiNascita}"
                               placeholder="Luogo di nascita" required>
                        <#if erroreProvNascita??>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                        <input class="input-modulo col-1 col-sm pl-0 error" type="text" name="ProvinciaDiNascita"
                               value="${tirocinante.provinciaDiNascita}" placeholder="XX" required>
                        <#else>
                         <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                        <input class="input-modulo col-1 col-sm pl-0" type="text" name="ProvinciaDiNascita"
                               value="${tirocinante.provinciaDiNascita}" placeholder="XX" required>
                        </#if>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">il</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="GiornoDiNascita"
                               value="${giorno}" placeholder="XX" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="MeseDiNascita"
                               value="${mese}" placeholder="XX" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="AnnoDiNascita"
                               value="${anno}" placeholder="XXXX" required>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Residente in</h4>
                        <input class="input-modulo col-8 col-sm-8 pl-0" type="text" name="LuogoDiResidenza"
                               value="${tirocinante.luogoDiResidenza}" placeholder="Luogo di residenza" required>
                        <#if erroreProvinciaResidenza??>
                        <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                        <input class="input-modulo text-center col col-sm pl-0 error" type="text"
                               name="ProvinciaDiResidenza" value="${tirocinante.provinciaDiResidenza}" placeholder="XX"
                               required>
                        <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                        <#else>
                        <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text"
                               name="ProvinciaDiResidenza" value="${tirocinante.provinciaDiResidenza}" placeholder="XX"
                               required>
                        <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                        </#if>
                    </div>

                    <div class="row mb-0 mr-10">
                        <#if erroreCodiceFiscale??>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                        <input class="input-modulo col col-sm pl-0 error" type="text" name="CodiceFiscale"
                               value="${tirocinante.codiceFiscale}" placeholder="Codice fiscale" required>
                        <#else>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="CodiceFiscale"
                               value="${tirocinante.codiceFiscale}" placeholder="Codice fiscale" required>
                        </#if>
                    </div>

                    <div class="row mb-0 mr-10">
                        <#if erroreNumeroTelefono??>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0 error" type="text" name="NumeroTelefono"
                               value="${tirocinante.telefono}" placeholder="Numero di telefono" required>
                        <#else>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="NumeroTelefono"
                               value="${tirocinante.telefono}" placeholder="Numero di telefono" required>
                        </#if>
                    </div>

                    <h4 class="text-center text-black fs-16 mb-5 mt-15 mr-10">Attuale condizione (barrare la casella -
                        possibilit&agrave; di scelta multipla):</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckCorsoDilaurea == true>1<#else>0</#if>"
                                   <#if ckCorsoDilaurea == true>checked="checked"</#if>>
                            <i></i> Studente Corso di Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="CorsoLaurea"
                               value="<#if ckCorsoDilaurea == true>${tirocinante.corsoDiLaurea}</#if>"
                               placeholder="Corso di laurea">
                    </div>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckDiplomaUniversitario == true>1<#else>0</#if>"
                                   <#if ckDiplomaUniversitario == true>checked="checked"</#if>>
                            <i></i> Diplomato. Diploma universitario in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="DiplomatoUniversitario"
                               value="<#if ckDiplomaUniversitario == true>${tirocinante.diplomaUniversitario}</#if>"
                               placeholder="Diploma Universitario">
                    </div>
                    <h4>(entro 12 mesi dal diploma)</h4>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckLaureato == true>1<#else>0</#if>"
                                   <#if ckLaureato == true>checked="checked"</#if>>
                            <i></i> Laureato. Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Laurea"
                               value="<#if ckLaureato == true>${tirocinante.laureato}</#if>"
                               placeholder="Laurea">
                    </div>
                    <h4>(entro 12 mesi dalla laurea)</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckDottoratoDiRicerca == true>1<#else>0</#if>"
                                   <#if ckDottoratoDiRicerca == true>checked="checked"</#if>>
                            <i></i> Dottorato di ricerca in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato"
                               value="<#if ckDottoratoDiRicerca == true>${tirocinante.dottoratoDiRicerca}</#if>"
                               placeholder="Dottorato">
                    </div>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                        <input type="checkbox" value="<#if ckScuolaAltro == true>1<#else>0</#if>"
                                   <#if ckScuolaAltro == true>checked="checked"</#if>
                            <i></i> Scuola o corso di perfezionamento o specializzazione in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="ScuolaAltro"
                               value="<#if ckScuolaAltro == true>${tirocinante.scuolaAltro}</#if>"
                               placeholder="Specificare">
                    </div>

                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                    <label class="checkbox ml-200 mr-10">
                        <input type="checkbox" name="Handicap" value="Si" <#if handicap == true>checked="checked"</#if>>
                        <i></i> Si
                    </label><br>
                    <label class="checkbox ml-200 mb-25 mr-10">
                        <input type="checkbox" name="Handicap" value="No"
                               <#if handicap == false>checked="checked"</#if>>
                        <i></i> No
                    </label><br>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda ospitante</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nome_ente_azienda"
                               value="${azienda.ragioneSociale}" placeholder="Nome Ente/Azienda" disabled>
                    </div>

                    <div class="row mb-0 breack-print mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Luogo di effettuazione del tirocinio</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Luogo_di_svolgimento"
                               value="${offertatirocinio.luogoEffettuazione}" placeholder="Luogo di svolgimento"
                               required disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Periodo di tirocinio n.</h4>
                        <input class="input-modulo col col-sm-1 pl-0 text-center" type="text" name="Numero_di_mesi"
                               value="${offertatirocinio.durataMesi}" placeholder="Specificare il numero di mesi"
                               required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">mesi dal</h4>
                        <input class="input-modulo col col-sm pl-0" type="date" name="Data_iniziale"
                               value="${offertatirocinio.periodoInizio}" placeholder="Data inizio" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">al</h4>
                        <input class="input-modulo col col-sm pl-0" type="date" name="Data_fine"
                               value="${offertatirocinio.periodoFine}"
                               placeholder="Data fine" required>
                    </div>
                    <h4>(con possibilit&agrave; di prologa entro i limiti massimi previsti dalla normativa vigente)</h4>

                    <div class="row mb-25 mr-10">
                        <#if erroreOre??>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                            <input class="input-modulo col-2 col-sm-2 pl-0 error" type="text" name="NumeroOreTirocinio"
                                   value="${offertatirocinio.durataOre}" placeholder="numero ore" required>
                        <#else>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                            <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroOreTirocinio"
                                   value="${offertatirocinio.durataOre}" placeholder="numero ore" required>
                        </#if>
                        <#if erroreCFU??>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                            <input class="input-modulo col-2 col-sm-2 pl-0 error" type="text" name="NumeroCfu" value=""
                                   placeholder="Numero CFU" required>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                        <#else>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                            <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroCfu" value=""
                                   placeholder="Numero CFU" required>
                            <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                        </#if>
                    </div>
                    <#if erroreTutore??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${erroreTutore}
                        </div>
                    </#if>
                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Tutore Universitario:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form fancy-form-select">
                                <select id="TuroreUni" class="form-control select2 <#if erroreTutore??>error</#if>" name="TutoreUniversitario" required>
                                    <#list tutoreUniversitario as tutoreUniversitario>
                                        <option value="${tutoreUniversitario.IDTutoreUni}">${tutoreUniversitario.nome} ${tutoreUniversitario.cognome}</option>
                                    </#list>
                                    <option value="NEW">Aggiungi Nuovo Tutore Universitario</option>
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
                                    <input type="text" placeholder="Nome" class="input-modulo"
                                           name="NomeTutoreUniversitario">
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Cognome Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" placeholder="Cognome"
                                           name="CognomeTutoreUniversitario"
                                           class="input-modulo">
                                </label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Telefono Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="tel" placeholder="Telefono"
                                           name="TelefonoTutoreUniversitario"
                                           class="input-modulo">
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Email Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <#if erroreEmailTutore??>
                                        <input type="email" placeholder="Email"
                                               name="EmailTutoreUniversitario"
                                               class="input-modulo error">
                                    <#else>
                                        <input type="email" placeholder="Email"
                                               name="EmailTutoreUniversitario"
                                               class="input-modulo">
                                    </#if>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore Aziendale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo_tutore_aziendale"
                               value="${offertatirocinio.nomeTutoreAziendale} ${offertatirocinio.cognomeTutoreAziendale}"
                               placeholder="Nominativo tutore aziendale" required disabled>
                    </div>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono Tutore Aziendale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_aziendale"
                               value="${offertatirocinio.telefonoTutoreAziendale}"
                               placeholder="Numero di telefono tutore aziendale" required disabled>
                    </div>
                    <footer class="mt-50 d-print-none">
                        <button type="submit" form="modulo_richiesta_tirocinante"
                                class="btn btn-success btn-lg pull-right float-right"><i
                                class="fa fa-check"></i> Invia
                        </button>
                        <button type="reset" form="modulo_richiesta_tirocinante"
                                class="btn btn-red btn-lg pull-right float-left"><i
                                class="fa fa-times"></i> Annulla Modifiche
                        </button>
                    </footer>
                </fieldset>
            </form>
        </div>
    </section>

    <!-- /FOOTER -->
    <#include "footer.ftl">
    <!-- /FOOTER -->

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script>
    $("#TuroreUni").change(function () {
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