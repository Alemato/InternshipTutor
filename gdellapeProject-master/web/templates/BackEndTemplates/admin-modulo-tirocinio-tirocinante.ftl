<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>

    <#include "../importCss.ftl">

    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>


</head>
<body class="smoothscroll enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark ">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="/#">HOME DASHBOARD</a></li>
        <li class="active"><a href="/#"><b>GESTIONE MODULO:</b></a></li>
    </ol>
   <#include "small-navbar.ftl">

</nav>
<div class="container-fluid d-print-none">
    <div class="row">
       <#include "sidebar.ftl">
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3 d-print-none">

            <section class="section-sm centrale border-top-section pl-20 pr-20">

                            <div class="row">
                                <h3>Nominativo del tirocinante :</h3>
                                <h3> &nbsp; ${tirocinante.nome} &nbsp; ${tirocinante.cognome}  </h3>
                                <h3>&nbsp;Nato a </h3>
                                <h3> &nbsp; ${tirocinante.luogoDiNascita}</h3>
                                <h3>&nbsp; Prov</h3>
                                <h3>&nbsp; ${tirocinante.provinciaDiNascita}</h3>
                                <h3>&nbsp; il</h3>
                                <h3>&nbsp; ${tirocinante.dataDiNascita?date?string("dd")} </h3>
                                <h3>&nbsp; /</h3>
                                <h3>&nbsp; ${tirocinante.dataDiNascita?date?string("MM")} </h3>
                                <h3>&nbsp; /</h3>
                                <h3>&nbsp; ${tirocinante.dataDiNascita?date?string("yyyy")} </h3>
                            </div>

                            <div class="row">
                                <h3>Residente in :</h3>
                                <h3>&nbsp;${tirocinante.luogoDiResidenza} </h3>
                                <h3>&nbsp;Prov (</h3>
                                <h3>&nbsp;${tirocinante.provinciaDiNascita}</h3>
                                <h3>)</h3>
                                <h3>&nbsp;Codice fiscale :</h3>
                                <h3>&nbsp;${tirocinante.codiceFiscale}</h3>
                            </div>
                <div class="row">
                <h3>&nbsp;Telefono : </h3>
                <h3>&nbsp;${tirocinante.telefono}</h3>
                </div>


                            <div class="row">

                                <h3> Studente Corso di Laurea in:</h3>
                                <h3> &nbsp;<#if tirocinante.corsoDiLaurea?has_content> ${tirocinante.corsoDiLaurea}</#if>  </h3>
                            </div>

                            <div class="row">

                                <h3> Diplomato. Diploma universitario in:</h3>
                                <h3>&nbsp;<#if tirocinante.diplomaUniversitario?has_content>${tirocinante.diplomaUniversitario}</#if>  </h3>
                            </div>

                            <div class="row">
                                <h3> Laureato. Laurea in: </h3>
                                <h3>&nbsp; <#if tirocinante.laureato?has_content> ${tirocinante.laureato}</#if></h3>
                            </div>

                            <div class="row">

                                <h3> Dottorato di ricerca in:</h3>

                                <h3>&nbsp;<#if tirocinante.DottoratoDiRicerca?has_content> ${tirocinante.DottoratoDiRicerca} </#if> </h3>
                            </div>

                            <div class="row">
                                    <h3>Scuola o corso di perfezionamento o specializzazione in :</h3>

                                <h3>&nbsp;<#if tirocinante.ScuolaAltro?has_content> ${tirocinante.ScuolaAltro} </#if></h3>
                            </div>
                <div class="row">
                    <h3>handicap: <#if tirocinante.handicap==true> SI <#else> NO</#if> </h3>
                    </div>

                            <div class="row">
                                <h3>Ente/Azienda ospitante :</h3>
                                <h3>&nbsp;${dato[0]}</h3>
                                <h3>Luogo di effettuazione del tirocinio :</h3>
                                <h3>&nbsp;${dato[1]}</h3>
                            </div>



                            <div class="row">
                                <h3>Settore di inserimento : </h3>
                                <h3>&nbsp;${dato[2]}</h3>
                                <h3>Tempi di accesso ai locali aziendali :</h3>
                                <h3>&nbsp;${dato[3]}</h3>
                            </div>

                            <div class="row">
                                <h3>Periodo di tirocinio n.</h3>
                                <h3>&nbsp;${dato[4]}</h3>
                                <h3>&nbsp;mesi dal</h3>
                                <h3>&nbsp;${dato[5]}</h3>
                                <h3>&nbsp;al</h3>
                                <h3>&nbsp;${dato[6]}</h3>
                            </div>

                            <div class="row">
                                <h3>numero ore di tirocinio : </h3>
                                <h3>&nbsp;${dato[7]}</h3>
                                <h3>&nbsp;per il conseguimento di n.</h3>
                                <h3> &nbsp;${dato[8]} </h3>
                                <h3> &nbsp;CFU</h3>

                            </div>

                            <div class="row">
                                <h3>Tutore universitario : </h3>
                                <h3> &nbsp;${dato[9]} ${dato[10]}</h3>
                                <h3>&nbsp;Telefono :</h3>
                                <h3> &nbsp; ${dato[11]} </h3>
                            </div>

                            <div class="row">
                                <h3>Tutore Aziendale :</h3>
                                <h3>&nbsp;${dato[12]} &nbsp;${dato[13]} </h3>
                                <h3>&nbsp;Telefono : </h3>
                                <h3>&nbsp;${dato[14]}</h3>
                            </div>
                            <div class="row">
                            <h3>Obiettivi del tirocinio:</h3>
                            <h3> &nbsp;${dato[15]}</h3>
                            </div>
                            <div class="row">
                            <h3>Modalit&agrave; :</h3>
                            <h3>&nbsp; ${dato[16]} </h3>
                            </div>
                            <div class="row">
                            <h3>Facilitazioni previste:</h3>
                            <h3>&nbsp; ${dato[17]} </h3>
                            </div>
            </section>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">


</body>
</html>
