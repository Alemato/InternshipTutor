<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modulo Tirocinio</title>

    <#include "importCss.ftl">
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class=" enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1 class="uppercase">Modulo termine Progetto Formativo e Di Orientamento</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il mio account</a></li>
                <li><a href="/account/moduli">Moduli Disponibili</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_tirocinante" action="/account/moduli/tirocinio" method="post" class="m-0">
                <fieldset>
                    <input type="hidden" name="ID_Tirocinio" value="${tirocinio.IDTirocinio}">
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati del modulo pre-compilato e clicca su
                        stampa</h1>

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <h6>(da compilare a cura dell'Azienda)</h6>
                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="NominativoEnte"
                               value="<#if azienda.ragioneSociale??>${azienda.ragioneSociale}"
                               placeholder="Nome Ente/Azienda" disabled<#else>" placeholder="Nome Ente/Azienda"</#if>>
                    </div>

                    <div class="row mb-25 mr-10 mt-15">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 fw-400">Codice fiscale Ente/Azienda </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                               value="<#if azienda.CFiscalePIva??>${azienda.CFiscalePIva}" placeholder="Codice fiscale"
                               disabled <#else>" placeholder="Codice fiscale" </#if>>
                    </div>

                    <h3 class="col-auto col-sm-auto pl-0 mb-10">Tirocinante: </h3>

                    <div class="row mb-5 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Cognome:</h4>
                        <input class="input-modulo col col-sm-12 col-md pl-0 mb-0" type="text"
                               name="Cognome_tirocinante" value="<#if tirocinante.cognome??>${tirocinante.cognome}"
                               placeholder="Cognome del tirocinante" disabled <#else>" placeholder="Cognome del
                        tirocinante"</#if>>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Nome</h4>
                        <input class="input-modulo col col-sm-12 col-md pl-0 mb-0" type="text" name="Nome_tirocinante"
                               value="<#if tirocinante.nome??>${tirocinante.nome}" placeholder="Nome del tirocinante"
                               disabled<#else>" placeholder="Nome del tirocinante"</#if>>
                    </div>


                    <h4 class="col-auto col-sm-auto mb-10 pl-0 fs-20 fw-400">(Codice identificativo tirocinio:
                        Dipartimento, Corso di Laurea o diploma, anno, n progressivo, altro)</h4>
                    <input class="input-modulo col-auto col-sm-auto pl-0 mr-20 mt-0 mb-25" type="text"
                           name="Codice_tirocinio"
                           value="<#if offertaTirocinio.codIdentTirocinio??>${offertaTirocinio.codIdentTirocinio}"
                           placeholder="Codice del tirocinio" disabled <#else>" placeholder="Codice del tirocinio"</#if>
                    >

                    <h3 class="col-auto col-sm-auto pr-10 pl-0 mt-45 mb-10">Periodo del Tirocinio: </h3>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Dal</h4>
                        <input class="input-modulo col col-sm pl-0" type="date" name="Data_inizio"
                               value="<#if tirocinio.periodoEffettivoIniziale??>${tirocinio.periodoEffettivoIniziale?date?iso_utc}</#if>"
                               placeholder="Data di inizio tirocinio">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">al</h4>
                        <input class="input-modulo col col-sm pl-0" type="date" name="Data_fine"
                               value="<#if tirocinio.periodoEffettivoFinale??>${tirocinio.periodoEffettivoFinale?date?iso_utc}</#if>"
                               placeholder="Data di fine tirocinio">
                    </div>

                    <div class="row mb-0 mr-10 mt-15">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 fw-400">Per un totale di </h4>
                        <input class="input-modulo col-1 pl-0 text-center" type="number" name="Ore_totali"
                               value="<#if tirocinio.durataOre??>${tirocinio.durataOre}</#if>" placeholder="ore totali">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20  fw-400"> ore</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Sede di svolgimento del tirocinio</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Sede_svolgimento"
                               value="<#if offertaTirocinio.luogoEffettuazione??>${offertaTirocinio.luogoEffettuazione}"
                               placeholder="Sede di svolgimento"
                               disabled<#else>" placeholder="Sede di svolgimento"</#if>>
                    </div>

                    <h4 class="fs-20 mb-0">Descrizione attivita svolta:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-15 mr-10" rows="4" cols="1"
                              name="Descrizione_attivita_svolta"
                              placeholder="descrivi in breve l&apos;attivit&agrave; svolte nel tirocinio"><#if tirocinio.descrizioneAttivitaSvolta??>${tirocinio.descrizioneAttivitaSvolta}</#if></textarea>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Si attesta che il/la Sig </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nome_cognome_tirocinante"
                               value="<#if tirocinante.nome?? && tirocinante.cognome??>${tirocinante.nome} ${tirocinante.cognome}"
                               placeholder="Nominativo tirocinante"
                               disabled<#else>" placeholder="Nominativo tirocinante"</#if>>
                    </div>

                    <h4 class="fs-20 mb-0">Ha effettuato i compiti affidatigli conseguendo il seguente risultato :</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-0 mr-10" rows="4" cols="1"
                              name="risultato_tirocinio"
                              placeholder="descrivi in breve il risultato del tirocinio"><#if tirocinio.risultatoConseguito??>${tirocinio.risultatoConseguito}</#if></textarea>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Data</h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0 text-center" type="date" name="Data_documento"
                               value="${data?date?iso_utc}" placeholder="Data">
                    </div>

                    <h4 class="d-none d-print-block">Firma del Tutor aziendale</h4>

                    <div class="linea col-5 p-0 mt-25"></div>

                    <footer class="mt-50 d-print-none">
                        <button type="submit" form="modulo_tirocinante"
                                class="btn btn-success btn-lg pull-right float-right" onclick="window.print();"><i
                                    class="fa fa-check"></i> Stampa
                        </button>
                        <button type="reset" form="modulo_tirocinante" class="btn btn-red btn-lg pull-right float-left">
                            <i
                                    class="fa fa-times"></i> Annulla
                        </button>
                    </footer>
                </fieldset>
            </form>
        </div>
    </section>
    <#include "footer.ftl">
</div>
<#include "importScript.ftl">
</body>
</html>
