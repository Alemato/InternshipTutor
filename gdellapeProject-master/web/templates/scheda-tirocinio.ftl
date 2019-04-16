<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>TIROCINIO PRESSO AVEJA</title>

    <#include "importCss.ftl">


</head>
<body class="smoothscroll enable-animation">
<div id="wrapper">

    <#include "header.ftl">
    <#if Message??>
        <#include "messaggio-errore.ftl">
    </#if>


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
            <#if Message??>
                <#include "messaggio-errore.ftl">
            </#if>
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


            <form id="manda_iscrizione" method="post" action="/sceltarichiesta">
                <input type="hidden" name="Tirocinio" value=${IDTirocinio}>
                <button type="submit" form="manda_iscrizione"
                        class="btn btn-blue b-blu btn-lg pull-right float-right"><i
                            class="fa fa-check"></i> Invia Domanda
                </button>
            </form>
        </div>
    </section>

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">


</body>
</html>