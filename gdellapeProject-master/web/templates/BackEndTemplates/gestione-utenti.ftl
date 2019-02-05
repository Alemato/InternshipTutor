<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Utenza</title>

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
        <li class="active"><a href="gestione-utenza-admin.html"><b>GESTIONE UTENZA</b></a></li>
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
                    <li class="active"><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
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
                    <li class="list-group-item">
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


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-user"></i> Utenza di Tipo Tirocinanti</h2>
            <h3>Lista Tirocinanti</h3>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Tirocinanti
                </div>
                <div class="card-body">
                    <form class="table-responsive" id="form_tirocinante" action="print.php" method="post">

                        <table class="table table-striped table-bordered table-hover" id="datatable_tirocinante" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Cognome</th>
                                <th>Email</th>
                                <th>Codice Fiscale</th>
                                <th>Data Di Nascita</th>
                                <th>Telefono</th>
                                <th>Portatore Handicap</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome</th>
                                <th>Cognome</th>
                                <th>Email</th>
                                <th>Codice Fiscale</th>
                                <th>Data Di Nascita</th>
                                <th>Telefono</th>
                                <th>Portatore Handicap</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <tr>
                                <td>Marco</td>
                                <td>Polo</td>
                                <td>marco.polo@navigare.oceano</td>
                                <td>HGFCHGHGKHGCVHCVJHG</td>
                                <td>01/01/1254</td>
                                <td>12345678910</td>
                                <td>NO</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            <tr>
                                <td>Mario</td>
                                <td>Bianco</td>
                                <td>mario.bianco@nero.brutto</td>
                                <td>HGFCHGHGKHGCVHCVJHG</td>
                                <td>01/01/2155</td>
                                <td>12345678910</td>
                                <td>SI</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            <tr>
                                <td>Edmund</td>
                                <td>Charly</td>
                                <td>Edmund.Charly@bob.usa</td>
                                <td>HGFCHGHGKHGCVHCVJHG</td>
                                <td>01/01/1994</td>
                                <td>12345678910</td>
                                <td>NO</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            </tbody>
                        </table>

                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="form_tirocinante"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="form_tirocinante"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-industry fs-25"></i> Utenza di Tipo Aziendale</h2>
            <h3>Lista Aziende</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Aziende
                </div>
                <div class="card-body">
                    <form class="table-responsive" id="form_azienda" action="print.php" method="post">
                        <table class="table table-striped table-bordered table-hover" id="datatable_azienda" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA </th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA</th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <tr>
                                <td>Ferrari</td>
                                <td>JHVDUJHJHUVDHJ</td>
                                <td>Enzo</td>
                                <td>Ferrari</td>
                                <td>Mauro</td>
                                <td>Rossi</td>
                                <td>mauro.rossi@ferrari.it</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            <tr>
                                <td>Aveja</td>
                                <td>JHVDUJHJHUVDHJ</td>
                                <td>Enrico</td>
                                <td>Ferani</td>
                                <td>Marco</td>
                                <td>Bianchi</td>
                                <td>marco.bianchi@aveja.it</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            <tr>
                                <td>Brico</td>
                                <td>JHVDUJHJHUVDHJ</td>
                                <td>Marco</td>
                                <td>Ginobili</td>
                                <td>Andrea</td>
                                <td>Blu</td>
                                <td>andrea.blu@brico.it</td>
                                <td>
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Utente
                                    </button>
                                </td>
                                <td>
                                    <a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </a>
                                </td>
                                <td><input type="checkbox" class="checkboxes" name="Marco" value="1"/> <i
                                            class="fa fa-times" style="color: red;"></i> Elimina
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="form_azienda"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="form_azienda"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-graduation-cap"></i> Utenza di Tipo Tutori Universitari</h2>
            <h3 class="mb-10">Crea Utente Turore Universitario</h3>
            <form id="form_crea_tutore_uni" method="post" action="print.php" class="sky-form validate"
                  novalidate="novalidate">
                <label class="input">
                    <p><em>*</em> Nome</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="text" placeholder="Nome" name="Nome_tutore" required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri</b>
                </label>

                <label class="input mb-20">
                    <p><em>*</em> Cognome</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="text" placeholder="Cognome" name="Cognome_tutore" required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri</b>
                </label>

                <label class="input mb-20">
                    <p><em>*</em> Numero di Telefono</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="tel" placeholder="Numero di Telefono" name="Numero_telefono_tutore" required>
                    <b class="tooltip tooltip-bottom-right">Solo numeri</b>
                </label>

                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="email" placeholder="Indirizzo Email" name="Email_tutore" required>
                    <b class="tooltip tooltip-bottom-right">Necessario per essere contattato</b>
                </label>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_crea_tutore_uni"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Crea
                    </button>
                    <button type="reset" form="form_crea_tutore_uni"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
            <h3>Lista Tutori Universitari</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Turori Universitari
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_tutore" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <tr>
                            <td>Mauro</td>
                            <td>Rossi</td>
                            <td>147825369</td>
                            <td>mauro.rossi@ferrari.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Marco</td>
                            <td>Bianchi</td>
                            <td>147852369</td>
                            <td>marco.bianchi@aveja.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>Andrea</td>
                            <td>Blu</td>
                            <td>123456789</td>
                            <td>andrea.blu@brico.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-user-md"></i> Utenza di Tipo Amministratore</h2>
            <h3 class="mb-10">Crea Utente Aministratore</h3>
            <form id="form_crea_admin" method="post" action="print.php" class="sky-form validate"
                  novalidate="novalidate">

                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" placeholder="Indirizzo Email" name="Email" required>
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

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_crea_admin"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Crea
                    </button>
                    <button type="reset" form="form_crea_admin"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
            <h3>Lista Aministratori</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Amministratori
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_amministatori" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Email</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Email</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <tr>
                            <td>mauro.rossi@ferrari.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>marco.bianchi@aveja.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>andrea.blu@brico.it</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Utente
                                </button>
                            </td>
                            <td>
                                <a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </a>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>


<#include "../importScript.ftl">

<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableTirocinanti() {

        var table = jQuery('#datatable_tirocinante');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableAziende() {

        var table = jQuery('#datatable_azienda');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableAdmin() {

        var table = jQuery('#datatable_amministatori');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    initTableTirocinanti();
    initTableAziende();
    initTableAdmin();

</script>

</body>
</html>
