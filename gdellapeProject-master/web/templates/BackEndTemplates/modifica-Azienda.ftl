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
        <li class="active"><a href="#"><b>GESTIONE: ${azienda.ragioneSociale}</b></a></li>
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
                <form action="/modifica-azienda" method="post">
                    <input type="hidden" name="ID" value="${azienda.IDAzienda}">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label>Nuova Password</label>
                    <input type="password" name="newpassword">
                </div>
                    <div class="form-group">
                        <label>Ripeti Nuova Password </label>
                        <input type="password" name="repaetnewpassword">
                    </div>
                    <div class="form-group">
                        <label>Nome Azienda</label>
                        <input type="text" name="ragionesociale" value="${azienda.ragioneSociale}">
                    </div>
                <div class="form-group">
                    <label>Indirizzo sede legale</label>
                    <input type="text" name="indirizzosedelegale" value="${azienda.indirizzoSedeLegale}">
                </div>
                <div class="form-group">
                    <label>Codice Fiscale O Partita Iva</label>
                    <input type="text" name="cfiscalepiva" value="${azienda.CFiscalePIva}">
                </div>
                <div class="row">
                    <label>Nome Legale Rappresentante</label>
                    <input type="text" name="nomelegalerappresentante" value="${azienda.nomeLegaleRappresentante}">
                </div>
                <div class="row">
                    <label>Cognome Legale Rappresentante</label>
                    <input type="text" name="cognomelegalerappresentante" value="${azienda.cognomeLegaleRappresentante}">
                </div>
                <div class="row">
                    <label>Nome Legale Convenzione</label>
                    <input type="text" name="nomeresponsabileconvenzione" value="${azienda.nomeResponsabileConvenzione}" >
                </div>
                <div class="row">

                    <label>Cognome Responsabile Convenzione</label>
                    <input type="text" name="cognomeresponsabileconvenzione" value="${azienda.cognomeResponsabileConvenzione}">
                </div>
                <div class="row">
                    <label>Telefono Responsabile Convenzione</label>
                    <input type="text" name="telefonoResponsabileConvenzione" value="${azienda.telefonoResponsabileConvenzione}">
                </div>

                <div class="row">
                    <label>Email Responsabile Convenzione</label>
                    <input type="text" name="emailresponsabileconvenzione" value="${azienda.emailResponsabileConvenzione}">
                </div>
                <div class="row">
                    <label>Durata Convenzione</label>
                    <input type="text" name="durataconvenzione" value="${azienda.durataConvenzione}">
                </div>
                <div class="row">

                    <label>Foro Controversia</label>
                    <input type="text" name="forocontroversia" value="${azienda.foroControversia}">
                </div>
                <div class="row">
                    <label>Descrizione </label>
                    <textarea inputmode="" name="descrizione">${azienda.descrizione}</textarea>
                </div>

                <div class="row">
                    <label>Link</label>
                    <input type="text" name="link" value="${azienda.link}">
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
