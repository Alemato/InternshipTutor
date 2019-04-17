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
<body class="enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULO: ${azienda.ragioneSociale}</b></a></li>
    </ol>
   <#include "small-navbar.ftl">

</nav>
<div class="container-fluid d-print-none">
    <div class="row d-print-none">
        <#include "sidebar.ftl">
        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3 d-print-none">
            <section class="section-sm centrale border-top-section pl-20 pr-20">

            <div class="row mb-0 mr-10 ">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda : </h3>
                <h3>${azienda.ragioneSociale}</h3>
            </div>

            <div class="row mb-0 mr-10 ">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">con sede legale in (indirizzo) : </h3>
                <h3>${azienda.indirizzoSedeLegale}</h3>
            </div>

            <div class="row mb-0 mr-10">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">Codice Fiscale (o Partita IVA) : </h3>
                <h3>${azienda.CFiscalePIva} </h3>
            </div>


            <div class="row mb-0 mr-10 ">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">rappresentato da :</h3>
                <h3> ${azienda.nomeLegaleRappresentante}</h3>
            </div>
            <div class="row mb-0 mr-10 ">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">rappresentato da : </h3>
                <h3>${azienda.cognomeLegaleRappresentante}</h3>
            </div>


            <div class="row mb-0 mr-10 d-print-none">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">Ruolo del foro competente : </h3>
                <h3>${azienda.foroControversia}</h3>
            </div>
            <div class="row mb-0 mr-10 d-print-none">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">Durata convenzione: </h3>
                <h3>${azienda.durataConvenzione}</h3>
            </div>
            <div class="row mb-0 mr-10 d-print-none">
                <h3 class="col-auto col-sm-auto pr-10 fs-20">Data Convenzione: </h3>
                <h3>${azienda.dataConvenzione?date?string("dd/MM/yyyy")}</h3>
            </div>
            </section>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = '/plugins/';</script>
<script src="/plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="/js/scripts.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.js"></script>


</body>
</html>
