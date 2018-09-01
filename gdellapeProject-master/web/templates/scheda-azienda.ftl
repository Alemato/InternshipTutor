<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${RagioneSociale}</title>

   <#include "importCss.ftl">
</head>
<body class="smoothscroll enable-animation">
<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>${RagioneSociale}</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li>Azienda</li>
                <li>${RagioneSociale}</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container p-0">
            <h2 class="uppercase fw-100 mb-15">Dettagli Azienda :<span class="fw-600 ml-10">${RagioneSociale}</span></h2>
            <div class="linea-divisione mt-0"></div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Nome :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${RagioneSociale}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Sito internet :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro"><a href="${Link}">${RagioneSociale}</a></h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">descizione azienda :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro"><p>${Descrizione}</p>
                    </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Indirizzo sedele legale :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro"> ${IndirizzoSedeLegale} </h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Partita IVA / Codice Fiscale :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro letter-spacing-1">${CFiscalepiva}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Nome Rapresentante :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${NomeLegaleRappresentante}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Cognome Rapresentante :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${CognomeLegaleRappresentante}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Nome Responsabile :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${NomeResponsabileConvenzione}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Cognome Responsabile :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${CognomeResponsabileConvenzione}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Numero di telefono Responsabile :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro letter-spacing-1">${TelefonoResponsabileConvenzione}</h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Email Responsabile :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro"><a href="mailto:francesco.totti@1a0.gol">${EmailResponsabileConvenzione}</a></h4>
                </div>
            </div>

            <div class="row pl-15 pr-15">
                <div class="col-12 col-md-5 col-lg-4 mb-0 mb-sm-5">
                    <h4 class="uppercase testo-chiaro mb-5">Foro competente :</h4>
                </div>
                <div class="col-12 col-md-7 col-lg-8 mb-15 mb-sm-5">
                    <h4 class="testo-scuro">${ForoControversia}</h4>
                </div>
            </div>


        </div>
    </section>

<#include "footer.ftl">
</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script src="/js/internshiptutor.js"></script>


</body>
</html>