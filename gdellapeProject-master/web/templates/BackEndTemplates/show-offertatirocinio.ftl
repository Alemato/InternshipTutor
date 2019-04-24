<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VISUALIZZA CONVENZIONE</title>

    <#include "../importCss.ftl">

    <!-- Page Script -->
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
        <li><a href="/admin/offertetirocinioadmin"><b>GESTIONE OFFERTE TIROCINIO</b></a></li>
        <li class="active"><a href="#"><b>OFFERTA : ${offerta.titolo}</b></a></li>
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
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Offerta Di Tirocinio :
                        <span class="fw-600 ml-10">${offerta.titolo}</span></h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Descrizione Breve :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${offerta.descrizioneBreve}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Descrizione :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.descrizione}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Luogo Di Effettuazione :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.luogoEffettuazione}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Orari:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.orari}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Durata ore:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.durataOre}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Mesi :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.durataMesi}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Periodo inizio:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.periodoInizio?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Periodo Fine:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.periodoFine?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro"> Modalit&agrave; :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.modalita}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Obiettivi:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.obbiettivi}
                            </h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Rimborsi:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.rimborsi}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Facilitazione :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.facilitazione}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Azienda Ospitante :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.aziendaOspitante}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice Indetificativo Tirocinio :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${offerta.codIdentTirocinio}
                            </h4>
                        </div>
                    </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Settore di Inserimento :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.settoreInserimento}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Tempo accesso locali aziendali :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.tempoAccessoLocaliAziendali}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Nome Tutore Aziendale :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.nomeTutoreAziendale}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Cognome Tutore Aziendale:</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.cognomeTutoreAziendale}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Telefono Tutore Aziendale:</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.telefonoTutoreAziendale}
                                </h4>
                            </div>
                        </div>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Email Tutore Aziendale:</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${offerta.emailTutoreAziendale}
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
