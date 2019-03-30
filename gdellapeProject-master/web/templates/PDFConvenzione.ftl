<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Modulo Convenzione</title>
    <#include "importCss.ftl">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 "
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1 class="uppercase">Modulo Convenzione</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il mio account</a></li>
                <li><a href="/account/moduli">Moduli disponibili</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <#if Url??>
        <div class="border bg-white p-30 radius-5">
            <#--<h1 class="mb-30 fs-50 fw-100 text-center border-bottom">MODULO CONVENZIONE</h1>-->
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
    </section>

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
