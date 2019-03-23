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
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULO: ${azienda.ragioneSociale}</b></a></li>
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
    <v class="row d-print-none">
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


        <main class="col-sm-10 offset-sm-1 col-md-11 offset-md-2 pt-3 d-print-none">

            <section class="section-sm centrale border-top-section pl-20 pr-20">


                <div class="row mb-0 mr-10 ">
                    <h4 class="col-auto col-sm-auto pr-10 fs-20 fw-400">Previa effetuazione di opportune verifiche e colloquio svoltosi in data </h4>
                    <input class="input-modulo col-3 col-sm-3 pl-0 text-center" type="date" name="Data_colloquio"
                           value="2018-01-01" placeholder="data">
                </div>

                <h4 class="col-auto col-sm-auto p-0 fs-20 fw-400 mb-35">Si attesta che il </h4>

                <h3 class="col-auto col-sm-auto pl-0 mb-35">Tirocinante: </h3>

                <div class="row mb-5 mr-10 mb-35">
                    <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Cognome:</h4>
                    <h4>${tirocinante.nome}</h4>
                    <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Nome</h4>
                    <input class="input-modulo col col-sm-12 col-md pl-0 mb-0" type="text" name="Nome_tirocinante"
                           value="Francesco" placeholder="Nome del tirocinante">
                </div>

                <h4 class="col-auto col-sm-auto p-0 fs-20 fw-400 mt-25">Ha svolto il tirocinio con esito </h4>
                <input class="input-modulo col col-sm-12 col-md pl-0 mb-25" type="text" name="Esito_tirocinio" placeholder="Esito del tirocinio">


                <h4 class="col-auto col-sm-auto p-0 fs-20">Crediti Formativi riconosciuti </h4>
                <h4>${tirocinio.CFU}</h4>

                <div class="row mb-25 mr-10 mt-50">
                    <h4 class="col-auto col-sm-auto pr-10 fs-20">L&apos;Aquila il </h4>
                    <input class="input-modulo col-3 col-sm-3 pl-0 text-center" type="date" name="Data_documento"
                           value="2018-05-01" placeholder="Data">
                </div>


            </section>

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
