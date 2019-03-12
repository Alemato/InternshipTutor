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
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULI</b></a></li>
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


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2>Tirocinii</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Richiesta Tirocinio dei Tirocinanti
                </div>
                <div class="card-body">
                    <form id="pdf_tirocinante" method="post" action="print.php">
                        <table class="table table-responsive table-striped table-bordered table-hover"
                               id="datatable_ric_tiro" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Ente/Azienda Ospitante</th>
                                <th>Sede Legale Ente</th>
                                <th>Codice Fiscale Ente</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Tel. Tutore Aziendale</th>
                                <th>Nome Tutore Univeresitario</th>
                                <th>Cognome Tutore Univeresitario</th>
                                <th>Tel. Tutore Univeresitario</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Caricato</th>
                                <th>Carica/Soprascrivi PDF</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Ente/Azienda Ospitante</th>
                                <th>Sede Legale Ente</th>
                                <th>Codice Fiscale Ente</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Tel. Tutore Aziendale</th>
                                <th>Nome Tutore Univeresitario</th>
                                <th>Cognome Tutore Univeresitario</th>
                                <th>Tel. Tutore Univeresitario</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Caricato</th>
                                <th>Carica/Soprascrivi PDF</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <tr>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>Aveja</td>
                                <td>via marco polo 1, l&apos;aquila</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>12345678910</td>
                                <td>Mario</td>
                                <td>Rossi</td>
                                <td>12345678910</td>
                                <td>01/10/2018</td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-1">
                                    </a>
                                </td>
                            </tr>

                            <#list Richieste as tirocinio,dati>
                            <tr>
                                <td>${dati[0]}</td>
                                <td>${dati[1]}</td>
                                <td>${dati[2]}</td>
                                <td>${dati[3]}</td>
                                <td>${dati[4]}</td>
                                <td>${dati[5]}</td>
                                <td>${dati[6]}</td>
                                <td>${dati[7]}</td>
                                <td>${dati[8]}</td>
                                <td>${dati[9]}</td>
                                <td>${dati[10]}</td>
                                <td>${dati[11]}</td>
                                <td>${tirocinio.createDate?date}</td>
                                <td>
                                    <a type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza</a>
                                </td>
                                <td>
                                        <button type="button" class="btn btn-secondary" <#if pdfdisabled??> <i class="fa fa-file-pdf-o"></i>PDF Non Disponibile</button> </#if>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-3">
                                    </a>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="pdf_tirocinante"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="pdf_tirocinante"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2>Convenzioni</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Richiesta di Convenzionamento Aziendale
                </div>
                <div class="card-body">
                    <form id="pdf_convenzioni" method="post" action="print.php">
                        <table class="table table-responsive table-striped table-bordered table-hover"
                               id="datatable_ric_convenzioni" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente/Azienda</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Caricato</th>
                                <th>Carica/Soprascrivi PDF</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente/Azienda</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale/Partita Iva</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Caricato</th>
                                <th>Carica/Soprascrivi PDF</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <tr>
                                <td>Aveja</td>
                                <td>via marco polo 1, l&apos;aquila</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>01/10/2018</td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-1">
                                    </a>
                                </td>
                            </tr>
                           <#list Aziende as azienda >
                            <tr>
                                <td>${azienda.ragioneSociale}</td>
                                <td>${azienda.indirizzoSedeLegale}</td>
                                <td>${azienda.CFiscalePIva}</td>
                                <td>${azienda.nomeResponsabileConvenzione}</td>
                                <td>${azienda.cognomeResponsabileConvenzione}</td>
                                <td>${azienda.dataConvenzione}</td>
                                <td>
                                    <a type="button" href="/#" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza</a>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-secondary"><iclass="fa fa-file-pdf-o"></i>Visualizza PDF</button>
                                </td>
                                <td>
                                    <form action="/#" type="post">
                                        <input type="file" name="file-1">
                                        <button type="submit" class="btn btn-file"><iclass="fa fa-file-pdf-o"></i>Modifica PDF</button>
                                    </form>
                                </td>
                            </tr>
                           </#list>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2>Tirocinii Conclusi</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli per Conclusione Tirocinii
                </div>
                <div class="card-body">
                    <form id="pdf_fine_tirocinio" method="post" action="print.php">
                        <table class="table table-responsive table-striped table-bordered table-hover"
                               id="datatable_fine_tirocinio" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Ente/Azienda Ospitante</th>
                                <th>Sede Legale Ente</th>
                                <th>Codice Fiscale Ente</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Tel. Tutore Aziendale</th>
                                <th>Nome Tutore Univeresitario</th>
                                <th>Cognome Tutore Univeresitario</th>
                                <th>Tel. Tutore Univeresitario</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Modulo Conclusione Tirocinio (Azienda)</th>
                                <th>Visualizza PDF Caricato (Azienda)</th>
                                <th>Carica/Soprascrivi PDF (Azienda)</th>
                                <th>Visualizza Modulo Conclusione Tirocinio (Segreteria)</th>
                                <th>Visualizza PDF Caricato (Segreteria)</th>
                                <th>Carica/Soprascrivi PDF (Segreteria)</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Ente/Azienda Ospitante</th>
                                <th>Sede Legale Ente</th>
                                <th>Codice Fiscale Ente</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Tel. Tutore Aziendale</th>
                                <th>Nome Tutore Univeresitario</th>
                                <th>Cognome Tutore Univeresitario</th>
                                <th>Tel. Tutore Univeresitario</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Modulo Conclusione Tirocinio (Azienda)</th>
                                <th>Visualizza PDF Caricato (Azienda)</th>
                                <th>Carica/Soprascrivi PDF (Azienda)</th>
                                <th>Visualizza Modulo Conclusione Tirocinio (Segreteria)</th>
                                <th>Visualizza PDF Caricato (Segreteria)</th>
                                <th>Carica/Soprascrivi PDF (Segreteria)</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <tr>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>Aveja</td>
                                <td>via marco polo 1, l&apos;aquila</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>12345678910</td>
                                <td>Mario</td>
                                <td>Rossi</td>
                                <td>12345678910</td>
                                <td>01/10/2018</td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-1">
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-1">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>Aveja</td>
                                <td>via marco polo 1, l&apos;aquila</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>12345678910</td>
                                <td>Mario</td>
                                <td>Rossi</td>
                                <td>12345678910</td>
                                <td>01/10/2018</td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-2">
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary"><i
                                                    class="fa fa-file-pdf-o"></i>Visualizza PDF
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-2">
                                    </a>
                                </td>
                            </tr>
                            <tr>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>Aveja</td>
                                <td>via marco polo 1, l&apos;aquila</td>
                                <td>DSKJHFBSDKBFKJBDASF</td>
                                <td>mario</td>
                                <td>rossi</td>
                                <td>12345678910</td>
                                <td>Mario</td>
                                <td>Rossi</td>
                                <td>12345678910</td>
                                <td>01/10/2018</td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary" disabled><i
                                                    class="fa fa-file-pdf-o"></i>PDF Non Disponibile
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-3">
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <button type="button" class="btn btn-secondary" disabled><i
                                                    class="fa fa-file-pdf-o"></i>PDF Non Disponibile
                                        </button>
                                    </a>
                                </td>
                                <td><a href="print.php">
                                        <input type="file" name="file-3">
                                    </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="pdf_fine_tirocinio"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="pdf_fine_tirocinio"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = 'plugins/';</script>
<script src="plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="js/scripts.js"></script>
<script src="plugins/bootstrap/js/bootstrap.js"></script>


<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    // datatable_ric_convenzioni
    // datatable_fine_tirocinio
    function initTableRicTiro() {

        var table = jQuery('#datatable_ric_tiro');

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
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
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

    function initTableRicConvenzioni() {

        var table = jQuery('#datatable_ric_convenzioni');

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
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [7, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
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

    function initTableFineTirocinio() {

        var table = jQuery('#datatable_fine_tirocinio');

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
                "orderable": true
            }, {
                "orderable": false
            },{
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
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

    initTableRicTiro();
    initTableRicConvenzioni();
    initTableFineTirocinio();

</script>
</body>
</html>
