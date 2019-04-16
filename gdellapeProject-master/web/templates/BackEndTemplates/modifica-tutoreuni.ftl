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
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="/gestione-tutoti"><b>GESTIONE TUTORI</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE: ${tutore.nome} ${tutore.cognome}</b></a></li>
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
            <#if WarningGenerico??>
                <div class="alert alert-warning mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningGenerico}
                </div>
            </#if>
            <div class="col">
                <form action="/modifica-tutore" method="post">
                    <input type="hidden" name="IDTutoreUni" value="${tutore.IDTutoreUni}">
                <div class="form-group">
                    <label>Nome</label>
                    <#if ErroreNome??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreNome}
                        </div>
                    </#if>
                    <input type="text" <#if ErroreNome??> class="error" </#if> name="nome"  <#if ValueOfnome?? > value="${ValueOfnome}" <#else> value="${tutore.nome}" </#if> >
                </div>

                <div class="form-group">
                    <label>Cognome</label>
                    <#if ErroreCognome??>
                        <div class="alert alert-danger mb-20">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione!</strong> ${ErroreNome}
                        </div>
                    </#if>
                    <input type="text" <#if ErroreCognome??> class="error" </#if> name="cognome" <#if ValueOfcognome?? > value="${ValueOfcognome}" <#else> value="${tutore.cognome}" </#if> >
                </div>
                    <div class="form-group">
                        <label>Telefono</label>
                        <#if ErroreTelefono??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreTelefono}
                            </div>
                        </#if>
                        <input type="text"  <#if ErroreTelefono??> class="error" </#if>  name="telefono" <#if ValueOftelefono?? > value="${ValueOftelefono}" <#else> value="${tutore.telefono}"</#if> >
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <#if ErroreEmail??>
                            <div class="alert alert-danger mb-20">
                                <button type="button" class="close" data-dismiss="alert">
                                    <span aria-hidden="true">&times;</span>
                                    <span class="sr-only">Chiudi</span>
                                </button>
                                <strong>Attenzione!</strong> ${ErroreEmail}
                            </div>
                        </#if>
                        <input type="text" <#if ErroreEmail??> class="error" </#if> name="email"  <#if ValueOfemail?? > value="${ValueOfemail}" <#else>  value="${tutore.email}" </#if> >
                    </div>


                    <button type="submit" class="btn btn-primary" >Modifica</button>
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
