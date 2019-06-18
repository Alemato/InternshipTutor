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
        <li><a href="admin/gestione-tirocinanti"><b>GESTIONE TIROCINANTI</b></a></li>
        <li class="active"><a href="#"><b>VISUALIZZA: ${tirocinante.nome} ${tirocinante.cognome}</b></a></li>
    </ol>

    <#include "small-navbar.ftl">

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
                    <h2 class="uppercase fw-100 mb-15">Dettagli Tirocinante :
                        <span class="fw-600 ml-10">${tirocinante.nome}&nbsp;${tirocinante.cognome}</span></h2>
                    <div class="linea-divisione mt-0"></div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Email :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">${user.email}</h4>
                        </div>
                    </div>

                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Luogo di nascita :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.luogoDiNascita}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Luogo di residenza :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.luogoDiResidenza}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Provincia di nascita :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                               ${tirocinante.provinciaDiNascita}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Data di nascit&aacute; :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.dataDiNascita?date?string("dd-MM-yyyy")}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Provinvia di residenza :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.provinciaDiResidenza}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Codice fiscale :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.codiceFiscale}
                            </h4>
                        </div>
                    </div>
                    <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Telefono:</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.telefono}
                            </h4>
                        </div>
                    </div>
                    <#if tirocinante.corsoDiLaurea?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Corso di laurea :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                               ${tirocinante.corsoDiLaurea}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if tirocinante.diplomaUniversitario?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Diploma universitario :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.diplomaUniversitario}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if tirocinante.laureatoUniversitario?has_content>
                          <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Laureato universitario :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${tirocinante.laureatoUniversitario}
                                </h4>
                            </div>
                        </div>
                    </#if>
                    <#if tirocinante.scuolaAltro?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                            <h4 class="uppercase testo-chiaro">Scuola o altro :</h4>
                        </div>
                        <div class="col-12 col-md-5 col-lg-6">
                            <h4 class="testo-scuro">
                                ${tirocinante.scuolaAltro}
                            </h4>
                        </div>
                    </div>
                    </#if>
                    <#if tirocinante.dottoratoDiRicerca?has_content>
                        <div class="row pl-15 pr-15">
                            <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Dottorato di ricerca :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    ${tirocinante.dottoratoDiRicerca}
                                </h4>
                            </div>
                        </div>
                    </#if>
                          <div class="row pl-15 pr-15">
                        <div class="col-12 col-md-7 col-lg-6 mb-sm-5 mb-0">
                                <h4 class="uppercase testo-chiaro">Handicap :</h4>
                            </div>
                            <div class="col-12 col-md-5 col-lg-6">
                                <h4 class="testo-scuro">
                                    <#if tirocinante.handicap> SI <#else> NO</#if>
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
<!-- Script page -->




</body>
</html>
