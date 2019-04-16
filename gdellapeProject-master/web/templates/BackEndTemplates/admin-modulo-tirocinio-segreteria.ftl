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
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULO: ${azienda.ragioneSociale}</b></a></li>
    </ol>
   <#include "small-navbar.ftl">

</nav>
<div class="container-fluid d-print-none">
    <div class="row">
        <#include "sidebar.ftl">
        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3 d-print-none">

            <section class="section-sm centrale border-top-section pl-20 pr-20">

                <div class="row">
                <h3>Previa effetuazione di opportune verifiche e colloquio svoltosi in data :  </h3>
                <h3>&nbsp; ${tirocinio.dataColloquioSegreteria?date?string("dd-MM-yyyy")} </h3>
              </div>
                <div class="row">
                <h3>Tirocinante: </h3>
                        <h3> &nbsp;${tirocinante.cognome} </h3>
                        <h3> &nbsp;${tirocinante.nome}</h3>
                </div>
                <div class="row">
                    <h3>Ha svolto il tirocinio con esito : </h3>
                    <h3> &nbsp;${tirocinio.esitoTirocinio} </h3>
                </div>

                <div class="row">
                <h3>Crediti Formativi riconosciuti :  </h3>
                <h3>&nbsp;${tirocinio.CFU}</h3>
                </div>
                <div class="row">
                    <h3>L&apos;Aquila il : </h3>
                    <h3>&nbsp;${tirocinio.dataConsegnaModuloSegreteria?date?string("dd-MM-yyyy")} </h3>
                </div>


            </section>

        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = 'plugins/';</script>
<script src="/plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="/js/scripts.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.js"></script>


</body>
</html>
