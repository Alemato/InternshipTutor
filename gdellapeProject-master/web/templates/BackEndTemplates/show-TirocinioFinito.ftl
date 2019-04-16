<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tirocinio Finito</title>

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
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULI</b></a></li>
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
            <div class="row">
            <h6>Nome Tirocinante : ${dati[0]}</h6>
            </div>

            <div class="row">
            <h6>Cognome Tirocinante :${dati[1]} </h6>
            </div>

            <div class="row">
            <h6>Codice Fiscale Tirocinante : $${dati[2]}}</h6>
                </div>
            <div class="row">
            <h6>Ente/Azienda Ospitante : ${dati[3]}</h6>
            </div>
            <div class="row">
            <h6>Sede Legale Ente : ${dati[4]}</h6>
            </div>
            <div class="row">
            <h6>Codice Fiscale Ente : ${dati[5]}</h6>
            </div>
            <div class="row">
            <h6>Nome Tutore Aziendale :  ${dati[6]}</h6>
            </div>
            <div class="row">
            <h6>Cognome Tutore Aziendale :  ${dati[7]}</h6>
            </div>
            <div class="row">
            <h6>Tel. Tutore Aziendale : ${dati[8]} </h6>
            </div>
            <div class="row">
            <h6>Nome Tutore Univeresitario : ${dati[9]}</h6>
            </div>
            <div class="row">
            <h6>Cognome Tutore Univeresitario : ${dati[10]}</h6>
            </div>
            <div class="row">
            <h6>Tel. Tutore Univeresitario : ${dati[11]}</h6>
            </div>
            <div class="row">
            <h6>Data Richiesta : ${tirocinio.createDate?date}</h6>
            </div>
            <div class="row">
            <h6>Durata ore : ${tirocinio.durataOre}</h6>
            </div>
            <div class="row">
            <h6>CFU : ${tirocinio.CFU}</h6>
            </div>
            <div class="row">
            <h6>Inizio Tirocinio : ${tirocinio.periodoEffettivoIniziale?date} </h6>
            </div>
            <div class="row">
            <h6>Fine Tirocinio : ${tirocinio.periodoEffettivoIniziale?date}</h6>
            </div>
            <div class="row">
            <h6>Risultato Conseguito : ${tirocinio.risultatoConseguito}</h6>
            </div>
            <div class="row">
            <h6>Descrizione Attivit&agrave; svolta : ${tirocinio.descrizioneAttivitaSvolta}</h6>
            </div>


        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
</body>
</html>
