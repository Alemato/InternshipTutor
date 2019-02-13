<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="/gestione-utenti"><b>GESTIONE UTENZA</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE:${gestione}</b></a></li>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "../BackEndTemplates/sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <div class="col">
                <div class="row">
                    <h2>Email : ${user.email}</h2>
                </div>
                <div class="row">
                    <h2>Nome : ${tirocinante.nome}</h2>
                </div>
                <div class="row">
                    <h2>Cognome : ${tirocinante.cognome}</h2>
                </div>
                <div class="row">
                    <h2>Luogo di Nascità : ${tirocinante.luogoDiNascita}</h2>
                </div>
                <div class="row">
                    <h2>Risiede : ${tirocinante.luogoDiResidenza}</h2>
                </div>
                <div class="row">
                    <h2>Procincia di Nascità : ${tirocinante.ProvinciaDiNascita}</h2>
                </div>
                <div class="row">
                    <h2>Data di nascità : ${tirocinante.dataDiNascita}</h2>
                </div>
                <div class="row">
                    <h2>Provincia di residenza : ${tirocinante.provinciaDiResidenza}</h2>
                </div>
                <div class="row">
                    <h2> Codice fiscale : ${tirocinante.codiceFiscale}</h2>
                </div>
                <div class="row">
                    <h2>Telefono : ${tirocinante.telefono}</h2>
                </div>

                <div class="row">
                    <h2>Corso Di Laurea : ${tirocinante.corsoDiLaurea}</h2>
                </div>
                <div class="row">
                    <h2>Diploma Universitario : ${tirocinante.diplomaUniversitario}</h2>
                </div>
                <div class="row">
                    <h2>Laurea : ${tirocinante.laureatoUniversitario}</h2>
                </div>
                <div class="row">
                    <h2>Scuola o Altro : ${tirocinante.scuolaAltro}</h2>
                </div>

                <div class="row">
                    <h2> Dottorato  : ${tirocinante.dottoratoDiRicerca}</h2>
                </div>
                <div class="row">
                    <h2>HandiCap : <#if tirocinante.handicap> yes <#else> no</#if> </h2>
                </div>


            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->




</body>
</html>
