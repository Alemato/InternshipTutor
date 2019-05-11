<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>${titolo}</title>

    <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

</head>
<body class="enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="/home">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="/admin/dashboard"><b>HOME DASHBOARD</b></a></li>
        <#if urlpage == "/admin/richisteconvezioni">
            <li><a href="/admin/richisteconvezioni"><b>Richiete Convenzioni</b></a></li>
            <#elseif urlpage=="/admin/Gestione-tirocinio" >
                <li><a href="/admin/gestione-tirocinio"><b>Gestione Tirocinio</b></a></li>
        <#elseif urlpage=="/admin/Gestione-Convenzione" >
            <li><a href="/admin/gestione-convenzione"><b>Gestione Convenzioni</b></a></li>
        </#if>
        <li class="text-white text-uppercase"><b>PDF ${titolo}</b></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
        <#include "sidebar.ftl">
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <div class="section-sm centrale border-top-section pl-20 pr-20">
                <h1 class="mt-25"><i class="fa fa-archive"></i> ${titoloDescrittivo}</h1>
                <#if Url??>
                    <div class="border bg-white p-30 radius-5">
                        <embed src="${Url}" type="application/pdf" style="height: -webkit-fill-available; width: -webkit-fill-available;">
                    </div>
                <#else>
                    <div class="container">
                        <h1 class="error-404 mb-15">500</h1>
                        <h1 class="text-center mb-20">Internal Server Error</h1>
                        <p class="fs-20 mb-10">Il server Web (che esegue il sito Web) ha riscontrato una condizione imprevista che
                            gli ha impedito di soddisfare la richiesta da parte del client per l&apos;accesso all&apos;URL richiesto.
                        </p>
                        <p class="fs-20 mb-10">Questo errore pu&ograve; essere risolto solo mediante correzioni al software del server Web.
                            Non &egrave; un problema lato client.
                        </p>
                        <p class="fs-20 mb-10">Spetta agli operatori del sito Web server individuare e analizzare i registri che
                            dovrebbero fornire ulteriori informazioni sull&apos;errore. Contatta gli Amministratori per altre
                            informazioni.</p>
                        <a class="fs-20 font-lato" href="/home"><i class="glyphicon glyphicon-menu-left mr-10 fs-16"></i> Torna
                            alla Homepage adesso!</a>
                    </div>
                </#if>
            </div>

        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->
</body>
</html>
