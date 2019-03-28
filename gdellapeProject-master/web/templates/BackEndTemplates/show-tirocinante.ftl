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
        <#--TODO controlla solo le barre e gli url con il filtro-->

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
                    <h4>Email : ${user.email}</h4>
                </div>
                <div class="row">
                    <h4>Nome : ${tirocinante.nome}</h4>
                </div>
                <div class="row">
                    <h4>Cognome : ${tirocinante.cognome}</h4>
                </div>
                <div class="row">
                    <h4>Luogo di Nascità : ${tirocinante.luogoDiNascita}</h4>
                </div>
                <div class="row">
                    <h4>Risiede : ${tirocinante.luogoDiResidenza}</h4>
                </div>
                <div class="row">
                    <h4>Procincia di Nascità : ${tirocinante.ProvinciaDiNascita}</h4>
                </div>
                <div class="row">
                    <h4>Data di nascità : ${tirocinante.dataDiNascita}</h4>
                </div>
                <div class="row">
                    <h4>Provincia di residenza : ${tirocinante.provinciaDiResidenza}</h4>
                </div>
                <div class="row">
                    <h4> Codice fiscale : ${tirocinante.codiceFiscale}</h4>
                </div>
                <div class="row">
                    <h4>Telefono : ${tirocinante.telefono}</h4>
                </div>
                <#if tirocinante.corsoDiLaurea?has_content>
                <div class="row">
                    <h4>Corso Di Laurea : ${tirocinante.corsoDiLaurea}</h4>
                </div>
                </#if>
                <#if tirocinante.diplomaUniversitario?has_content>
                <div class="row">
                    <h4>Diploma Universitario : ${tirocinante.diplomaUniversitario}</h4>
                </div>
                </#if>
                <#if tirocinante.laureatoUniversitario?has_content>
                <div class="row">
                    <h4>Laurea : ${tirocinante.laureatoUniversitario}</h4>
                </div>
                </#if>
                <#if tirocinante.scuolaAltro?has_content>
                <div class="row">
                    <h4>Scuola o Altro : ${tirocinante.scuolaAltro}</h4>
                </div>
                </#if>

                <#if tirocinante.dottoratoDiRicerca?has_content>
                <div class="row">
                    <h4> Dottorato  : ${tirocinante.dottoratoDiRicerca}</h4>
                </div>
                </#if>
                <div class="row">
                    <h4>HandiCap : <#if tirocinante.handicap> yes <#else> no</#if> </h4>
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
