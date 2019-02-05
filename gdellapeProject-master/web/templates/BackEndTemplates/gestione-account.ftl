<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Impostazioni Account</title>

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
        <li class="active"><a href="impostazione-account-admin.html"><b>IMPOSTAZIONI ACCOUNT</b></a></li>
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
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light">
            <div class="side-nav mb-60">
                <ul class="list-group list-group-bordered list-group-noicon uppercase">
                    <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
                    <li class=""><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
                    <li class=""><a href="gestione-richieste-convenzioni-admin.html">GESTIONE RICHIESTE CONVENZIONE</a></li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a>
                        <ul>
                            <li><a href="ultime-offerte-pubblicate-admin.html">ULTIME OFFERTE PUBBLICATE</a></li>
                            <li class=""><a href="offerte-scadute-admin.html">OFFERTE SCADUTE</a></li>
                            <li class=""><a href="tutte-offerte-pubblicate-admin.html">TUTTE LE OFFERTE PUBBLICATE</a></li>
                        </ul>
                    </li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-moduli-admin.html">GESTIONE MODULI</a>
                        <ul>
                            <li><a href="richieste-tirocinii-tirocinanti-admin.html">RICHIESTE TIROCINII TIROCINANTI</a></li>
                            <li><a href="richieste-convenzioni-aziendali-admmin.html">RICHIESTE CONVENZIONI AZIENDALI</a>
                            </li>
                            <li><a href="modulo-tirocinio-fine-admin.html">MODULO TIROCINIO FINE</a>
                            </li>
                        </ul>
                    </li>

                    <li class="active"><a href="impostazione-account-admin.html">IMPOSTAZIONI ACCOUNT</a></li>
                    </li>
                </ul>
            </div>
        </nav>


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-gear"></i> Impostazioni Account</h2>
            <form id="form_registrazione" action="print.php" method="post" class="sky-form validate"
                  novalidate="novalidate">
                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" placeholder="Indirizzo Email" name="Email" value="123@asdasd.it" required>
                    <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                </label>

                <label class="input">
                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" placeholder="Password" name="Password" required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>

                <label class="input mb-20">
                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" placeholder="Conferma password" name="ConfermaPassword" required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <footer>
                    <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                                class="fa fa-check"></i> Aggiorna
                    </button>
                    <button type="reset" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>


        </main>
    </div>
</div>

<#include "../importScript.ftl">
</body>
</html>
