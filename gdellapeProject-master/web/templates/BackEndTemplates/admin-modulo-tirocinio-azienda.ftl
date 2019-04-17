<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modulo Azienda</title>
    <#include "../importCss.ftl" >

    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href=/#">HOME DASHBOARD</a></li>
        <li class="active"><a href="/#"><b>GESTIONE MODULO: ${dato[0]}</b></a></li>
    </ol>

   <#include "small-navbar.ftl">

</nav>
<div class="container-fluid d-print-none">
    <div class="row">
        <#include "sidebar.ftl">
        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3">
            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Modulo Tirocinio Aziendale
                       </h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Ente/Azienda:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${dato[0]}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice fiscale Ente/Azienda :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[1]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Tirocinante</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[2]}&nbsp;${dato[3]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice identificativo tirocinio:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[4]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Periodo del Tirocinio:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                Dal&nbsp;${dato[5]?date?string("yyyy-MM-dd")}&nbsp;al&nbsp;${dato[6]?date?string("yyyy-MM-dd")}&nbsp;Per un totale di&nbsp;${dato[7]}&nbsp;ore
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Sede di svolgimento del tirocinio :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[8]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Descrizione attivita svolta:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[9]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Si attesta che il/la Sig :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dato[3]} &nbsp; ${dato[2]}
                            </h4>
                        </div>
                    </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Ha effettuato i compiti affidatigli conseguendo il seguente risultato :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dato[10]}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Data :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dato[11]?date?string("yyyy-MM-dd")}
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
