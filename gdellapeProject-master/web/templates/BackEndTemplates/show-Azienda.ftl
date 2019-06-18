<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->


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
        <li><a href="/admin/gestione-aziende"><b>GESTIONE UTENZA</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE:${azienda.ragioneSociale}</b></a></li>
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
       <#include "sidebar.ftl">

        <#--TODO controlla solo le barre e gli url con il filtro-->
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <section class="section-sm centrale border-top-section">
                <div class="container p-0">
                    <h2 class="uppercase fw-100 mb-15">Dettagli Azienda:
                        <span class="fw-600 ml-10">${azienda.ragioneSociale}</span></h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Email:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${user.email}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Indirizzo sede legale:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.indirizzoSedeLegale}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice Fiscale o Partita iva:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.CFiscalePIva}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nome Legale Rappresentante:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.nomeLegaleRappresentante}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Cognome legale Rappresentante:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.cognomeLegaleRappresentante}
                            </h4>
                        </div>
                    </div>
                    <#if azienda.nomeResponsabileConvenzione?has_content>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Nome Responsabile Convenzione: </h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.nomeResponsabileConvenzione}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if azienda.cognomeResponsabileConvenzione?has_content>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Cognome Responsabile Convenzione:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.cognomeResponsabileConvenzione}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if azienda.telefonoResponsabileConvenzione?has_content>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Telefono Responsabile Convenzione:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.telefonoResponsabileConvenzione}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if azienda.emailResponsabileConvenzione?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Email Responsabile Convenzione :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${azienda.emailResponsabileConvenzione}
                                </h4>
                            </div>
                        </div>
                    </#if>
                        <#if azienda.durataConvenzione?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Durata Convenzione:</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${azienda.durataConvenzione}
                                </h4>
                            </div>
                        </div>
                    </#if>
                    <#if azienda.foroControversia?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Foro Controversie :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${azienda.foroControversia}
                                </h4>
                            </div>
                        </div>
                    </#if>
                    <#if azienda.descrizione?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Descrizione:</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${azienda.descrizione}
                                </h4>
                            </div>
                        </div>
                    </#if>
                    <#if azienda.link?has_content>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Link Azienda :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${azienda.link}
                            </h4>
                        </div>
                    </div>
                    </#if>
                </div>
            </section>
        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->




</body>
</html>
