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

            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Modulo Tirocinio Azienda</h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nome Tirocinante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${dati[0]}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Cognome Tirocinante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[1]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice Fiscale Tirocinante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[2]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Ente/Azienda Ospitante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[3]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Ente/Azienda Ospitante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[3]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Sede Legale Ente :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[4]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice Fiscale Ente :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[5]}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nome Tutore Aziendale :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${dati[6]}
                            </h4>
                        </div>
                    </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Cognome Tutore Aziendale :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dati[7]}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Tel. Tutore Aziendale :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dati[8]}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Nome Tutore Univeresitario :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dati[9]}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Cognome Tutore Univeresitario :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dati[10]}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Tel. Tutore Univeresitario :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${dati[11]}
                                </h4>
                            </div>
                        </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Data Richiesta :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.createDate?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Durata ore :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.durataOre}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">CFU :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.CFU}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Inizio Tirocinio :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.periodoEffettivoIniziale?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Fine Tirocinio :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.periodoEffettivoFinale?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Risultato Conseguito :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.risultatoConseguito}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Descrizione Attivit&agrave; svolta :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinio.descrizioneAttivitaSvolta}
                            </h4>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
</body>
</html>
