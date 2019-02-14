<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Errore Interno</title>
   <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">

<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('http://localhost:8080/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>ERRORE INTERNO</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
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
        <div class="container mt-50">
            <h1>Dettagli per il debug</h1>
            <div class="row">
            <h3 class="col-3 fw-400">Codice Errore: </h3>
            <h3 class="col-9 fw-400">${StatusCode}</h3>
            </div>
            <div class="row">
                <h3 class="col-3 fw-400">Servelet Name: </h3>
                <h3 class="col-9 fw-400">${ServeletName}</h3>
            </div>

            <#if Throwable??>
            <div class="row">
                <h3 class="col-3 fw-400">Throwable Message: </h3>
                <h3 class="col-9 fw-400">${Throwable}</h3>
            </div>

            <div class="row">
                <h3 class="col-3 fw-400">Throwable StackTrace: </h3>
                <h3 class="col-9 fw-400">${ThrowableStackTrace}</h3>
            </div>
            
            <div class="row">
                <h3 class="col-3 fw-400">Throwable Cause: </h3>
                <h3 class="col-9 fw-400">${ThrowableCause}</h3>
            </div>
            </#if>
        </div>
    </section>
    <!-- /SECTION CENTER -->

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>