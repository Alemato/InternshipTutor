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
        <li class="active"><a href="#"><b>GESTIONE:${azienda.ragioneSociale}</b></a></li>
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
                <div class="col">
                <div class="row">
                    <h4>Email : ${user.email}</h4>
                </div>
                <div class="row">
                    <h4>Nome : ${azienda.ragioneSociale}</h4>
                </div>
                <div class="row">
                    <h4>Cognome : ${azienda.indirizzoSedeLegale}</h4>
                </div>

                <div class="row">
                    <h4>Codice Fiscale o Partita iva : ${azienda.CFiscalePIva}</h4>
                </div>

                <div class="row">
                    <h4>Nome Legale Rappresentante : ${azienda.nomeLegaleRappresentante}</h4>
                </div>
                <div class="row">
                    <h4>Cognome legale Rappresentante : ${azienda.cognomeLegaleRappresentante}</h4>
                </div>
                <#if azienda.nomeResponsabileConvenzione?has_content>
                <div class="row">
                    <h4> Nome Responsabile Convenzione: ${azienda.nomeResponsabileConvenzione}</h4>
                </div>
                </#if>
                <#if azienda.cognomeResponsabileConvenzione?has_content>
                <div class="row">
                    <h4>Cognome Responsabile Convenzione : ${azienda.cognomeResponsabileConvenzione}</h4>
                </div>
                </#if>
                <#if azienda.telefonoResponsabileConvenzione?has_content>
                <div class="row">
                    <h4> Telefono Responsabile Convenzione : ${azienda.telefonoResponsabileConvenzione}</h4>
                </div>
                </#if>
                <#if azienda.emailResponsabileConvenzione?has_content>
                <div class="row">
                    <h4>Email Responsabile Convenzione : ${azienda.emailResponsabileConvenzione}</h4>
                </div>
                </#if>
                <#if azienda.durataConvenzione?has_content>
                <div class="row">
                    <h4>Durata Convenzione : ${azienda.durataConvenzione}</h4>
                </div>

                </#if>
                <#if azienda.foroControversia?has_content>
                <div class="row">
                    <h4>Foro Controversie : ${azienda.foroControversia}</h4>
                </div>
                </#if>
                <#if azienda.descrizione?has_content>
                <div class="row">
                    <h4>Descrizione Azienda : ${azienda.descrizione}</h4>
                </div>
                </#if>
                <#if azienda.link?has_content>
                <div class="row">
                    <h4>Link Azienda : ${azienda.link}</h4>
                </div>
                </#if>
            </div>
            </section>
        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->




</body>
</html>
