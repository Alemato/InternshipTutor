<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Crea Modulo</title>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>

    <!-- CORE CSS -->
    <link href="/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="/css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="/css/layout.css" rel="stylesheet" type="text/css"/>

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/css/internshiptutor.css" rel="stylesheet" type="text/css">

    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>

    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">



</head>
<body class="enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="/">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class=""><a href="/Gestione-tirocinio">GESTIONE MODULI TIROCINIO</a></li>
        <li class="active"><a href="/#"><b>CREA MODULO SEGRETERIA</b></a></li>
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
<#--TODO im modulo e da centrare per la stampa-->
<div class="container">
    <div class="row">
        <div class="d-print-none">
            <#include "../BackEndTemplates/sidebar.ftl">
        </div>
        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3 centra">
                <div class="container">
                    <form id="modulo_segreteria" action="/crea-modulosegreteria" method="post" class="mt-20 border p-15 radius-5 bg-white modulo-segreteria">
                        <fieldset>
                            <input type="hidden" name="IDTirocinio"  value="${ID}">
                            <h1 class="text-center fw-100 d-print-none ">Controlla i dati del modulo pre-compilato e clicca su stampa</h1>

                            <div class="text-center d-none d-print-block">
                                <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                                <h1 class="Taviraji fw-600 uppercase mb-0 h1-modulo-segreteria">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                                <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                                <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                            </div>
                            <h6 class="d-none d-print-block">(da compilare a cura dell&apos;Univerist&agrave;)</h6>

                            <div class="row mb-0 mr-10 ">
                                <#if ErroreDataColloquio??>
                                    <div class="alert alert-danger mb-20">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione!</strong> ${ErroreDataColloquio}
                                    </div>
                                </#if>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20 fw-400">Previa effetuazione di opportune verifiche e colloquio svoltosi in data </h4>
                                <input class="input-modulo col-3 col-sm-3 pl-0 text-center" type="date" name="Data_colloquio"
                                       <#if ValueOfData_colloquio??> value="${ValueOfData_colloquio?date?iso_utc}" <#elseif tirocinio?? > value="${tirocinio.dataColloquioSegreteria?date?iso_utc}" </#if> placeholder="data">
                            </div>

                            <h4 class="col-auto col-sm-auto p-0 fs-20 fw-400 mb-35">Si attesta che il </h4>

                            <h3 class="col-auto col-sm-auto pl-0 mb-35">Tirocinante: </h3>

                            <div class="row mb-5 mr-10 mb-35">

                                <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Cognome:</h4>
                                <#if ErroreCognome??>
                                    <div class="alert alert-danger mb-20">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione!</strong> ${ErroreCognome}
                                    </div>
                                </#if>
                                <input class="input-modulo col col-sm-12 col-md pl-0 mb-0" type="text"
                                       name="Cognome_tirocinante"  <#if ValueOfCognome_tirocinante??> value="${ValueOfCognome_tirocinante}"  <#else>  value="${tirocinante.cognome}"  </#if> placeholder="Cognome del tirocinante">
                                <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Nome</h4>
                                <#if ErroreNome??>
                                    <div class="alert alert-danger mb-20">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione!</strong> ${ErroreNome}
                                    </div>
                                </#if>
                                <input class="input-modulo col col-sm-12 col-md pl-0 mb-0" type="text" name="Nome_tirocinante"
                                       <#if ValueOfNome_tirocinante??> value="${ValueOfNome_tirocinante}"  <#else>  value="${tirocinante.nome}"  </#if> placeholder="Nome del tirocinante">
                            </div>

                            <h4 class="col-auto col-sm-auto p-0 fs-20 fw-400 mt-25">Ha svolto il tirocinio con esito </h4>
                            <#if ErroreEsito??>
                                <div class="alert alert-danger mb-20">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Chiudi</span>
                                    </button>
                                    <strong>Attenzione!</strong> ${ErroreEsito}
                                </div>
                            </#if>
                            <input class="input-modulo col col-sm-12 col-md pl-0 mb-25" type="text" name="Esito_tirocinio" placeholder="Esito del tirocinio"
                                   <#if ValueOfEsito_tirocinio?? > value="${ValueOfEsito_tirocinio}"  </#if> >



                            <h4 class="d-none d-print-block">Firma del Tutor aziendale</h4>

                            <div class="linea col-6 p-0 mt-25 mb-25"></div>
                            <#if ErroreCrediti??>
                                <div class="alert alert-danger mb-20">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Chiudi</span>
                                    </button>
                                    <strong>Attenzione!</strong> ${ErroreCrediti}
                                </div>
                            </#if>
                            <h4 class="col-auto col-sm-auto p-0 fs-20">Crediti Formativi riconosciuti </h4>
                            <input class="input-modulo col-6 col-sm-6 col-md-6 pl-0 mb-45" type="number" name="Crediti_riconosciuti" placeholder="numero crediti riconosciuti"
                                    <#if ValueOfCrediti_riconosciuti?? > value="${ValueOfCrediti_riconosciuti}" </#if>>

                            <h4 class="d-none d-print-block">Firma del responsabile della struttura didattica competente</h4>
                            <h4 class="d-none d-print-block fw-400">(Presidente del Consiglio di Corso di Studio)</h4>
                            <div class="linea col-6 p-0 mt-25 mb-25"></div>

                            <div class="row mb-25 mr-10 mt-50">
                                <#if ErroreDate??>
                                <div class="alert alert-danger mb-20">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Chiudi</span>
                                    </button>
                                    <strong>Attenzione!</strong> ${ErroreDate}
                                </div>
                                </#if>
                                <h4 class="col-auto col-sm-auto pr-10 fs-20">L&apos;Aquila il </h4>
                                <input class="input-modulo col-3 col-sm-3 pl-0 text-center" type="date" name="Data_documento"
                                       placeholder="Data"  <#if ValueOfData_documento?? > value="${ValueOfData_documento?date?string("dd-MM-yyyy")}" </#if>>
                            </div>
                            <footer class="d-print-none container">
                                <button type="submit" form="modulo_segreteria" class="btn btn-success btn-lg pull-right float-right" onclick="window.print();"><i
                                            class="fa fa-check"></i> Stampa
                                </button>
                                <button type="reset" form="modulo_segreteria" class="btn btn-red btn-lg pull-right float-left"><i
                                            class="fa fa-times"></i> Annulla
                                </button>
                            </footer>
                        </fieldset>
                    </form>
                </div>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = 'plugins/';</script>
<script src="/plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="/js/scripts.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.js"></script>


</body>
</html>
