<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

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
        <li><#if page == "tirocinante">
                <a href="/admin/gestione-tirocinanti"><b>GESTIONE TIROCINANTI</b></a>
                <#elseif page == "azienda">
                <a href="/admin/gestione-aziende"><b>GESTIONE AZIENDE</b></a>
        </#if>
        </li>
        <li class="active"><a href="#">REIMPOSTA MAIL: ${user.email}</a></li>
    </ol>
   <#include "small-navbar.ftl">

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
                <form action="/admin/reimposta-user" method="post" class="sky-form">
                    <input type="hidden" name="IDUser" value="${user.IDUser}">
                    <input type="hidden" name="page" value="${page}">
                    <#if ErroreGenericoUpdate??>
                        <div class="alert alert-warning mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreGenericoUpdate}
                        </div>
                    </#if>
                    <#if ErroreEmail??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreEmail}
                        </div>
                    </#if>
                        <label class="input">
                            <p><em>*</em> Indirizzo Email</p>
                            <i class="ico-append giu fa fa-envelope"></i>
                            <input type="email" id="form-mail" <#if ErroreEmail??> class="error" </#if> name="email" value="${user.email}" required/>
                            <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                        </label>
                    <button type="submit" class="btn btn-primary float-right" >Modifica</button>

                </form>

            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->



</body>
</html>
