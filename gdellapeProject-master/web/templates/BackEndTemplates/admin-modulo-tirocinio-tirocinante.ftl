<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>

    <#include "../importCss.ftl">

    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>


</head>
<body class="smoothscroll enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark ">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="/#">HOME DASHBOARD</a></li>
        <li class="active"><a href="/#"><b>GESTIONE MODULO:</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
        <#include "sidebar.ftl">
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3 d-print-none">
            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Modulo Richiesta Tirocinio</h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nominativo del tirocinante:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${tirocinante.nome} &nbsp; ${tirocinante.cognome}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nato a:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.luogoDiNascita}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Prov Di Nascita:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.provinciaDiNascita}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Data di nascita:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.dataDiNascita?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Indirizzo di residenza:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.luogoDiResidenza}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Provincia di residenza :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.provinciaDiResidenza}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice fiscale:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.codiceFiscale}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Telefono:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.telefono}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">tudente Corso di Laurea in:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                <#if tirocinante.corsoDiLaurea?has_content> ${tirocinante.corsoDiLaurea}</#if>
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Diplomato. Diploma universitario in:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                <#if tirocinante.diplomaUniversitario?has_content>${tirocinante.diplomaUniversitario}</#if>
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Laureato. Laurea in:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                <#if tirocinante.laureato?has_content> ${tirocinante.laureato}</#if>
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Dottorato di ricerca in:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                <#if tirocinante.DottoratoDiRicerca?has_content> ${tirocinante.DottoratoDiRicerca} </#if>
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Scuola o corso di perfezionamento o specializzazione in
                                :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                <#if tirocinante.ScuolaAltro?has_content> ${tirocinante.ScuolaAltro} </#if>
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Ente/Azienda ospitante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[0]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Luogo di effettuazione del tirocinio :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[1]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Settore di inserimento :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[2]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Tempi di accesso ai locali aziendali :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[3]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Periodo di tirocinio n.</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[4]}&nbsp;mesi dal&nbsp;${dato[5]}&nbsp;al&nbsp;${dato[6]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Numero ore di tirocinio: </h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[7]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Per il conseguimento di n.</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[8]}&nbsp;CFU
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Tutore universitario :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[9]} ${dato[10]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Telefono Tutore Universitario :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[11]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Tutore Aziendale:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[12]} &nbsp;${dato[13]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Telefono Tutore Aziendale :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[14]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Obiettivi del tirocinio:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[15]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Modalit&agrave; :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[16]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Facilitazioni previste:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[17]}
                            </h4>
                        </div>
                    </div>
                </div>
            </section>

        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">


</body>
</html>
