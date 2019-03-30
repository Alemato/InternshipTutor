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
        <li class="active"><a href="#"><b>GESTIONE:</b></a></li>
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
        <#--TODO controlla solo le barre e gli url con il filtro-->

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
                <div class="row">
                    <h4>Titolo : ${offerta.titolo}</h4>
                </div>
                <div class="row">
                    <h4>Descrizione Breve : ${offerta.descrizioneBreve}</h4>
                </div>
                <div class="row">
                    <h4>Descrizione :</h4>
                </div>
                <div class="row">
                    <h5>${offerta.descrizione}</h5>
                </div>
                <div class="row">
                    <h4> Luogo Di Effettuazione : ${offerta.luogoEffettuazione}</h4>
                </div>
                <div class="row">
                    <h4>Orari  : ${offerta.orari}</h4>
                </div>
                <div class="row">
                    <h4>Durata Ore  : ${offerta.durataOre}</h4>
                </div>
                <div class="row">
                    <h4>Mesi : ${offerta.durataMesi}</h4>
                </div>
                <div class="row">
                   <h4>Dall ${offerta.periodoInizio?date?string("dd-MM-yyyy")} All ${offerta.periodoFine?date?string("dd-MM-yyyy")} </h4>
                </div>
                <div class="row">
                    <h4> Modalita :</h4>
                </div>
                <div class="row">
                    <h6>${offerta.modalita}</h6>
                </div>
                <div class="row">
                    <h4>Obbiettivi: ${offerta.obbiettivi}</h4>
                </div>
                <#if offerta.rimborsi?has_content>
                    <div class="row">
                        <h4>Rimborsi : ${offerta.rimborsi}</h4>
                    </div>
                </#if>
                <#if offerta.facilitazione?has_content >
                <div class="row">
                    <h4>Facilitazione : ${offerta.facilitazione}</h4>
                </div>
                </#if>

                <div class="row">
                    <h4>Azienda Ospitante : ${offerta.aziendaOspitante}</h4>
                </div>

                <div class="row">
                    <h4>Codice Indetificativo Tirocinio : ${offerta.codIdentTirocinio}</h4>
                </div>

                <div class="row">
                    <h4> Settore Inserimento : ${offerta.settoreInserimento}</h4>
                </div>

                <div class="row">
                    <h4>Tempo accesso locali aziendali  : ${offerta.tempoAccessoLocaliAziendali}</h4>
                </div>
                <div class="row">
                    <h4>Nome Tutore Aziendale  : ${offerta.nomeTutoreAziendale}</h4>
                </div>
                <div class="row">
                    <h4>Cognome Tutore Aziendale  : ${offerta.cognomeTutoreAziendale}</h4>
                </div>
                <div class="row">
                    <h4>Telefono Tutore Aziendale  : ${offerta.telefonoTutoreAziendale}</h4>
                </div>
                <div class="row">
                    <h4>Email Tutore Aziendale  : ${offerta.emailTutoreAziendale}</h4>
                </div>



            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->




</body>
</html>
