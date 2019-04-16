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

            <section class="section-sm centrale border-top-section pl-20 pr-20">


                <div class="row">
                    <h3>Ente/Azienda :</h3>
                    <h3>&nbsp;${dato[0]}</h3>
                    <h3>&nbsp;Codice fiscale Ente/Azienda :</h3>
                    <h3>&nbsp;${dato[1]}</h3>
                </div>
                <div class="row">
                    <h3>Tirocinante: </h3>
                    <h3>&nbsp;${dato[2]}</h3>
                    <h3>&nbsp;${dato[3]}</h3>
                </div>
                <div class="row" >
                    <h3>(Codice identificativo tirocinio: Dipartimento, Corso di Laurea o diploma, anno, n progressivo, altro) : </h3>
                    <h3>&nbsp;${dato[4]}</h3>
                </div>
                <div class="row">
                    <h3>&nbsp;Periodo del Tirocinio: </h3>
                    <h3>Dal</h3>
                    <h3>&nbsp;${dato[5]?date?string("yyyy-MM-dd")}</h3>
                    <h3>&nbsp;al</h3>
                    <h3>&nbsp;${dato[6]?date?string("yyyy-MM-dd")}</h3>
                    <h3>&nbsp;Per un totale di </h3>
                    <h3>&nbsp;${dato[7]}</h3>
                    <h3>&nbsp;ore</h3>
                </div>
                <div class="row">
                    <h3>Sede di svolgimento del tirocinio :</h3>
                    <h3>&nbsp; ${dato[8]}</h3>
                </div>
                <div class="row">
                    <h3>Descrizione attivita svolta :</h3>
                    <h3>&nbsp;${dato[9]}</h3>
                </div>

                <div class="row">
                    <h3 >Si attesta che il/la Sig :</h3>
                    <h3>&nbsp;${dato[3]} &nbsp; ${dato[2]}</h3>
                </div>
                <div class="row">
                    <h3>Ha effettuato i compiti affidatigli conseguendo il seguente risultato :</h3>
                    <h3>&nbsp;${dato[10]}</h3>
                </div>
                <div class="row">
                    <h3>Data</h3>
                    <h3>&nbsp;${dato[11]?date?string("yyyy-MM-dd")}</h3>
                </div>
            </section>

        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
</body>
</html>
