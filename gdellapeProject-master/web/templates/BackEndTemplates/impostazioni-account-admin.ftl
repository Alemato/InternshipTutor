<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Impostazione Account</title>

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
        <li class="active"><a href="#"><b>GESTIONE ACCOUNT</b></a></li>
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
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <#if WarningSuccess??>
                <div class="alert alert-success mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningSuccess}
                </div>
            </#if>
            <#if WarningInsuccess??>
                <div class="alert alert-danger mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningInsuccess}
                </div>
            </#if>
            <form action="/admin/modifica-admin" class="sky-form" method="post">
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
                    <p><em>*</em>Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input <#if ErroreEmail??> class="error" </#if>
                            name="email" <#if ValueOfemail?? > value="${ValueOfemail}"<#else> value="${user.email}" </#if> required/>
                    <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                </label>
                <#if ErrorePassword??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErrorePassword}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input <#if ErrorePassword??> class="error" </#if> type="password" name="newpassword" />
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreConfermaPassword??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreConfermaPassword}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Repeat Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input <#if ErroreConfermaPassword??> class="error" </#if> type="password" name="repeatpassword" />
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreNome??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreNome}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Nome</p>
                    <i class="ico-append giu fa fa-user"></i>
                    <input type="text" <#if ErroreNome??> class="error" </#if>
                           name="nome" <#if ValueOfnome?? > value="${ValueOfnome}"<#else> value="${admin.nome}" </#if> required/>
                </label>
                <#if ErroreCognome??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreCognome}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Cognome</p>
                    <i class="ico-append giu fa fa-user"></i>
                    <input type="text" <#if ErroreCognome??> class="error" </#if>
                           name="cognome" <#if ValueOfcognome?? > value="${ValueOfcognome}"<#else> value="${admin.cognome}" </#if> required />
                </label>
                <button type="submit" class="btn btn-primary float-right"> <i class="fa fa-user"></i>Modifica</button>
            </form>
        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->


</body>
</html>
