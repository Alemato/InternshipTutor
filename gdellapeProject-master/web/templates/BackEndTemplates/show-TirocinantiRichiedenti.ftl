<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tirocinanti</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="/home">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="/admin/dashboard">HOME DASHBOARD</a></li>
        <li><a href="/admin/offertetirocinioadmin"><b>GESTIONE OfferteTirocinio</b></a></li>
        <li class="active"><a href="#"><b>TIROCINANTI DI :&nbsp;${Offerta.titolo}</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

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
                    <h4>Offerta&nbsp;:&nbsp;${Offerta.titolo}</h4>

                </div>
                <div class="row">
                    <h4>E stata richiesta da :</h4>

                </div>
                <#if Tirocinanti??>
                <#list Tirocinanti as tirocinante >
                    <div class="row">

                        <a href="/admin/show-tirocinante?IDTirocinante=${tirocinante.IDTirocinante}">
                        <h4>${tirocinante.nome}&nbsp;${tirocinante.cognome}</h4>
                        </a>

                    </div>

                </#list>
                <#else>
                    <div class="row">
                        <h4>Non &eacute; stato richiesto da nessuno</h4>

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
