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

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="/home">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="/admin/dashboard">HOME DASHBOARD</a></li>
        <li><a href="/admin/dashboard">GESTIONE MODULO TIROCINIO</a></li>
        <li class="active"><a href="#"><b>GESTIONE MODULO: ${azienda.ragioneSociale}</b></a></li>
    </ol>
   <#include "small-navbar.ftl">

</nav>
<div class="container-fluid d-print-none">
    <div class="row">
        <#include "sidebar.ftl">
        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3 d-print-none">
            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Modulo Tirocinio Segreteria
                    </h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Previa effetuazione di opportune verifiche e colloquio svoltosi in data :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro"> ${tirocinio.dataColloquioSegreteria?date?string("dd-MM-yyyy")}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Tirocinante:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.cognome}&nbsp;${tirocinante.nome}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Ha svolto il tirocinio con esito:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.esitoTirocinio}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Crediti Formativi riconosciuti:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.CFU}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Data:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.dataConsegnaModuloSegreteria?date?string("dd-MM-yyyy")}
                            </h4>
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
