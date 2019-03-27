<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>

    <!-- CORE CSS -->
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>
    <!--CSS no print -->
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="smoothscroll enable-animation">

<#--TODO metti a posto la stampa senno si vede male-->

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark d-print-none">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULO:</b></a></li>
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
<div class="container-fluid d-print-none">
    <div class="row d-print-none">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light d-print-none">
            <div class="side-nav mb-60">
                <ul class="list-group list-group-bordered list-group-noicon uppercase">
                    <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
                    <li class=""><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
                    <li class=""><a href="gestione-richieste-convenzioni-admin.html">GESTIONE RICHIESTE CONVENZIONE</a>
                    </li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a>
                        <ul>
                            <li><a href="ultime-offerte-pubblicate-admin.html">ULTIME OFFERTE PUBBLICATE</a></li>
                            <li class=""><a href="offerte-scadute-admin.html">OFFERTE SCADUTE</a></li>
                            <li class=""><a href="tutte-offerte-pubblicate-admin.html">TUTTE LE OFFERTE PUBBLICATE</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item active">
                        <a class="dropdown-toggle" href="gestione-moduli-admin.html">GESTIONE MODULI</a>
                        <ul>
                            <li><a href="richieste-tirocinii-tirocinanti-admin.html">RICHIESTE TIROCINII TIROCINANTI</a>
                            </li>
                            <li><a href="richieste-convenzioni-aziendali-admmin.html">RICHIESTE CONVENZIONI
                                    AZIENDALI</a>
                            </li>
                            <li><a href="modulo-tirocinio-fine-admin.html">MODULO TIROCINIO FINE</a>
                            </li>
                        </ul>
                    </li>

                    <li class=""><a href="impostazione-account-admin.html">IMPOSTAZIONI ACCOUNT</a></li>
                    </li>
                </ul>
            </div>
        </nav>


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3 d-print-none">
            <div class="container-fluid">
            <fieldset>

                            <div class="row">
                                <h4>Nominativo del tirocinante :</h4>
                                <h4> &nbsp; ${tirocinante.nome} &nbsp; ${tirocinante.cognome}  </h4>
                            </div>

                            <div class="row">
                                <h4>Nato a </h4>
                                <h4> &nbsp; ${tirocinante.luogoDiNascita}</h4>
                                <h4>&nbsp; Prov</h4>
                                <h4>&nbsp; ${tirocinante.provinciaDiNascita}</h4>
                                <h4>&nbsp; il</h4>
                                <h4>&nbsp; ${tirocinante.dataDiNascita?date?string("dd")} </h4>
                                <h4>&nbsp; /</h4>
                                <h4>&nbsp; ${tirocinante.dataDiNascita?date?string("MM")} </h4>
                                <h4>&nbsp; /</h4>
                                <h4>&nbsp; ${tirocinante.dataDiNascita?date?string("yyyy")} </h4>
                            </div>

                            <div class="row">
                                <h4>Residente in :</h4>
                                <h4>&nbsp;${tirocinante.luogoDiResidenza} </h4>
                                <h4>&nbsp;Prov (</h4>
                                <h4>${tirocinante.provinciaDiNascita}</h4>
                                <h4>)</h4>
                            </div>

                            <div class="row">
                                <h4>Codice fiscale :</h4>
                                <h4>&nbsp;${tirocinante.codiceFiscale}</h4>
                            </div>

                            <div class="row">
                                <h4>Telefono : </h4>
                                <h4>&nbsp;${tirocinante.telefono}</h4>
                            </div>


                            <div class="row">

                                <h4> Studente Corso di Laurea in:</h4>
                                <h4> &nbsp;<#if tirocinante.corsoDiLaurea?has_content> ${tirocinante.corsoDiLaurea}</#if>  </h4>
                            </div>

                            <div class="row">

                                <h4> Diplomato. Diploma universitario in:</h4>
                                <h4>&nbsp;<#if tirocinante.diplomaUniversitario?has_content>${tirocinante.diplomaUniversitario}</#if>  </h4>
                            </div>
                            <h4>(entro 12 mesi dal diploma)</h4>

                            <div class="row">
                                <h4> Laureato. Laurea in: </h4>
                                <h4>&nbsp; <#if tirocinante.laureato?has_content> ${tirocinante.laureato}</#if></h4>
                            </div>
                            <h4>(entro 12 mesi dalla laurea)</h4>

                            <div class="row">

                                <h4> Dottorato di ricerca in:</h4>

                                <h4>&nbsp;<#if tirocinante.DottoratoDiRicerca?has_content> ${tirocinante.DottoratoDiRicerca} </#if> </h4>
                            </div>

                            <div class="row">
                                    <h4>Scuola o corso di perfezionamento o specializzazione in :</h4>

                                <h4>&nbsp;<#if tirocinante.ScuolaAltro?has_content> ${tirocinante.ScuolaAltro} </#if></h4>
                            </div>

                            <h4>handicap: <#if tirocinante.handicap==true> SI <#else> NO</#if> </h4>

                            <div class="row">
                                <h4>Ente/Azienda ospitante :</h4>
                                <h4>&nbsp;${dato[0]}</h4>
                            </div>

                            <div class="row">
                                <h4>Luogo di effettuazione del tirocinio :</h4>
                                <h4>&nbsp;${dato[1]}</h4>
                            </div>



                            <div class="row">
                                <h4>Settore di inserimento : </h4>
                                <h4>&nbsp;${dato[2]}</h4>
                            </div>

                            <div class="row">
                                <h4>Tempi di accesso ai locali aziendali :</h4>
                                <h4>&nbsp;${dato[3]}</h4>
                            </div>

                            <div class="row">
                                <h4>Periodo di tirocinio n.</h4>
                                <h4>&nbsp;${dato[4]}</h4>
                                <h4>&nbsp;mesi dal</h4>
                                <h4>&nbsp;${dato[5]}</h4>
                                <h4>&nbsp;al</h4>
                                <h4>&nbsp;${dato[6]}</h4>
                            </div>

                            <div class="row">
                                <h4 >numero ore di tirocinio : </h4>
                                <h4>${dato[7]}</h4>
                                <h4>per il conseguimento di n.</h4>
                                <h4>${dato[8]} </h4>
                                <h4>CFU</h4>

                            </div>

                            <div class="row">
                                <h4>Tutore universitario : </h4>
                                <h4> &nbsp;${dato[9]} ${dato[10]}</h4>
                            </div>

                            <div class="row">
                                <h4>Telefono :</h4>
                                <h4> &nbsp; ${dato[11]} </h4>
                            </div>

                            <div class="row">
                                <h4>Tutore Aziendale :</h4>
                                <h4>&nbsp;${dato[12]} &nbsp;${dato[13]} </h4>
                            </div>

                            <div class="row">
                                <h4>Telefono : </h4>
                                <h4>&nbsp;${dato[14]}</h4>
                            </div>
                            <div class="row">
                            <h4>Obiettivi del tirocinio:</h4>
                            <h4> &nbsp;${dato[15]}</h4>
                            </div>
                            <div class="row">
                            <h4 class="fs-20 mb-0">Modalità:</h4>
                            <h4>&nbsp; ${dato[16]} </h4>
                            </div>
                            <div class="row">
                            <h4>Facilitazioni previste:</h4>
                            <h4>&nbsp; ${dato[17]} </h4>
                            </div>
                        </fieldset>
            </div>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = 'plugins/';</script>
<script src="plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="js/scripts.js"></script>
<script src="plugins/bootstrap/js/bootstrap.js"></script>



</body>
</html>
